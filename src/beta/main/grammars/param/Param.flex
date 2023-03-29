package com.flipperplz.enfusionWorkbench.languages.param.lexer;

import com.flipperplz.enfusionWorkbench.languages.param.psi.ParamTypes;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.flipperplz.enfusionWorkbench.languages.param.psi.ParamTypes.*;

%%

%{
  // 1 = Double Quoted, 2 = Single Quoted, 3 = Not Quoted, 4 = <angled>
          byte stringMode = -1;
          int stringPreviousState = YYINITIAL;
          int directivePreviousState = YYINITIAL;
          int macroPreviousState = YYINITIAL;
          int concatPreviousState = YYINITIAL;
          int currentScope = 1;



          public ParamLexer() {
            this((java.io.Reader)null);
          }

          private boolean tryCloseUnquoted() {
              if(this.stringMode == 3) {
                  this.stringMode = -1; //leaving string
                  this.yybegin(this.stringPreviousState);
                  return true;
              }
              return false;
          }

          private IElementType startStringMode(int mode) {
                  this.stringMode = (byte) mode;
                  this.stringPreviousState = this.yystate();
                  this.yybegin(this.STRING_MODE);
                  return (mode == 4) ? ParamTypes.INCLUDE_START : ParamTypes.STRING_START;
          }

          private void leaveStringMode() {
              if(this.stringMode == -1) return;
              this.stringMode = -1; //leaving string
              this.yybegin(this.stringPreviousState);
          }

          private IElementType readQuote(boolean isDouble) {
              if(this.stringMode == 1) { /*Only double quoted strings*/
                   if(isDouble) {
                       leaveStringMode();
                       return ParamTypes.STRING_END;
                   }
                   return STRING_CONTENT;
              } else if(this.stringMode == 2) {
                  if(!isDouble) {
                      leaveStringMode();
                      return ParamTypes.STRING_END;
                  }
                  return STRING_CONTENT;
              } else if(this.stringMode == 3) {
                  return TokenType.BAD_CHARACTER;
              } else if(this.stringMode == 4) {
                  return ParamTypes.STRING_CONTENT;
              } else return STRING_CONTENT;
          }

           private IElementType exitDirective(IElementType element) {
                this.yybegin(directivePreviousState);
                return element;
           }

          private IElementType beginSQFMode(IElementType element) {
              this.yybegin(this.SQF_MODE);
              return element;
          }

          private IElementType exitSQFMode() {
              this.yybegin(this.macroPreviousState);
              return ParamTypes.SYM_RPARENTHESIS;
          }

          private IElementType enterMacroMode() {
              this.macroPreviousState = this.yystate();
              this.yybegin(this.MACRO_MODE);
              return ParamTypes.MACRO_MODE;
          }

          private IElementType enterDirectiveMode() {
              this.directivePreviousState = this.yystate();
              this.yybegin(this.DIRECTIVE_MODE);
              return ParamTypes.DIRECTIVE_MODE;
          }

          private IElementType enterConcatMode() {
              this.concatPreviousState = this.yystate();
              this.yybegin(this.DIRECTIVE_CONCAT_MODE);
              return ParamTypes.CONCAT_MODE;
          }

%}

%public
%class ParamLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

LINE_TERMINATOR=\r?\n
WHITE_SPACES=[\s\t\r\n]

SPACE=\s

SINGLE_LINE_COMMENT="//".*{LINE_TERMINATOR}?
DELIMITED_COMMENT= {NORMAL_DELIMITED_COMMENT} | {EMPTY_DELIMITED_COMMENT}
EMPTY_DELIMITED_COMMENT="/"\*\*?"/"
NORMAL_DELIMITED_COMMENT="/"\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+"/"
SYM_BACKSLASH=\
SYM_DQUOTE=\"
SYM_SQUOTE=\'
ESCAPE_DQUOTE=\"\"
ESCAPE_SQUOTE=\'\'
ESCAPES={ESCAPE_DQUOTE}|{ESCAPE_SQUOTE}
SYM_SHARP=#
SYM_LINE='__'
SYM_COMMA=,
SYM_SHARPSHARP=##
SYM_LPAREN=\(
SYM_RPAREN=\)
SYM_CASH=\$
SYM_RANGLE=>
SYM_LANGLE=<
DIRECTIVE_NEWLINE={SYM_BACKSLASH}{LINE_TERMINATOR}
ABS_IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
ABS_NUMERIC=(-?[0-9]+(.[0-9]+)?([eE][-+]?[0-9]+)?|0x[a-fA-F0-9]+)
SYM_SEMICOLON=;
EXIT_CONCAT={ SYM_SHARPSHARP } | { SYM_SEMICOLON } | { SPACE }

%state DIRECTIVE_MODE, MACRO_MODE, SQF_MODE, LOCALIZATION_MODE, DIRECTIVE_CONCAT_MODE, STRING_MODE

%%
{ SINGLE_LINE_COMMENT }          { return ParamTypes.SINGLE_LINE_COMMENT; }
{ EMPTY_DELIMITED_COMMENT }      { return ParamTypes.EMPTY_DELIMITED_COMMENT; }
{ DELIMITED_COMMENT }            { return ParamTypes.DELIMITED_COMMENT; }


<YYINITIAL> {
  {WHITE_SPACES}                 { return TokenType.WHITE_SPACE; }
  "class"                        { return ParamTypes.KW_CLASS; }
  "delete"                       { return ParamTypes.KW_DELETE; }
  "enum"                         { return ParamTypes.KW_ENUM; }
  "@"                            { return ParamTypes.REFERENCE_MODE; }
  "{"                            { this.currentScope++; return ParamTypes.SYM_LCURLY; }
  "}"                            { this.currentScope--; return ParamTypes.SYM_RCURLY; }
  "["                            { return ParamTypes.SYM_LSQUARE; }
  "]"                            { return ParamTypes.SYM_RSQUARE; }
  { SYM_SEMICOLON }              { return ParamTypes.SYM_SEMI; }
  ":"                            { return ParamTypes.SYM_COLON; }
  "="                            { return ParamTypes.OP_ASSIGN; }
  "+="                           { return ParamTypes.OP_ADDASSIGN; }
  "-="                           { return ParamTypes.OP_SUBASSIGN; }
  { SYM_DQUOTE }                 { return this.startStringMode(1); }
  { SYM_SQUOTE }                 { return this.startStringMode(2); }
  { ABS_NUMERIC }                { return ParamTypes.ABS_NUMERIC; }
  { SYM_LPAREN }                 { return ParamTypes.SYM_LPARENTHESIS; }
  { SYM_RPAREN }                 { return ParamTypes.SYM_RPARENTHESIS; }
  { ABS_IDENTIFIER }             { return ParamTypes.ABS_IDENTIFIER; }
  { SYM_COMMA }                  { return ParamTypes.SYM_COMMA; }
  { SYM_SHARP }                  { return this.enterDirectiveMode();}
  { SYM_LINE }                   { return this.enterMacroMode(); }
  { SYM_SHARPSHARP }             { return this.enterConcatMode(); }
}

<STRING_MODE> {
  { ESCAPES }                    { return ParamTypes.STRING_ESCAPE; }
  { SYM_RANGLE }                 {
            if(this.stringMode == 4) {
                leaveStringMode();
                return ParamTypes.INCLUDE_END;
            }
            return STRING_CONTENT;
        }
  { SYM_CASH }                   { this.yybegin(this.LOCALIZATION_MODE); }
  { SYM_DQUOTE }                 { return readQuote(true); }
  { SYM_SQUOTE }                 { return readQuote(false); }
  { SYM_SEMICOLON }              { if(tryCloseUnquoted()) return ParamTypes.STRING_END; }
  { LINE_TERMINATOR }            { return tryCloseUnquoted() ? ParamTypes.STRING_END : TokenType.BAD_CHARACTER; }
  [^]+                           { return ParamTypes.STRING_CONTENT; }
  }

<LOCALIZATION_MODE> {
  { ABS_IDENTIFIER }             { }
  { SPACE }                      { this.yybegin(this.STRING_MODE); return ParamTypes.LOCALIZED_STRING; }
  [^]                            { this.yybegin(this.STRING_MODE); return TokenType.BAD_CHARACTER; }
}

<DIRECTIVE_CONCAT_MODE> {
  { SYM_LPAREN }                   { return ParamTypes.SYM_LPARENTHESIS; }
  { SYM_RPAREN }                   { return ParamTypes.SYM_RPARENTHESIS; }
  { EXIT_CONCAT }                  { this.yybegin(concatPreviousState); return ParamTypes.EXIT_CONCAT; }
}

<DIRECTIVE_MODE> {
  "if"                           { return ParamTypes.KW_IF; }
  "ifdef"                        { return ParamTypes.KW_IFDEF; }
  "ifndef"                       { return ParamTypes.KW_IFNDEF; }
  "include"                      { return ParamTypes.KW_INCLUDE; }
  "define"                        { return ParamTypes.KW_DEFINE; }
//  "line"                         { return ParamTypes.KW_LINE; }
  "else"                         { return ParamTypes.KW_ELSE; }
  "endif"                        { return ParamTypes.KW_ENDIF; }
  "undef"                        { return ParamTypes.KW_UNDEF; }
  "#"                            { return ParamTypes.SYM_HASH; }
  { SYM_LANGLE }                 { return this.startStringMode(4); }
  { SYM_LPAREN }                 { return ParamTypes.SYM_LPARENTHESIS; }
  { SYM_RPAREN }                 { return ParamTypes.SYM_RPARENTHESIS; }
  { ABS_IDENTIFIER }             { return ParamTypes.ABS_IDENTIFIER; }
  { DIRECTIVE_NEWLINE }          { return ParamTypes.DIRECTIVE_NEWLINE; }
  { LINE_TERMINATOR }            { return this.exitDirective(ParamTypes.EXIT_DIRECTIVE); }
  { SYM_COMMA }                  { return ParamTypes.SYM_COMMA; }
  [^]+                           { return ParamTypes.DIRECTIVE_TAIL; }

}

<MACRO_MODE> {
  "LINE"                         { return ParamTypes.MACRO_LINE; }
  "FILE"                         { return ParamTypes.MACRO_FILE; }
  "EXEC"                         { return this.beginSQFMode(ParamTypes.MACRO_EXEC); }
  "EVAL"                         { return this.beginSQFMode(ParamTypes.MACRO_EVAL); }
  "__"                           { return ParamTypes.EXIT_MACRO; }
  [^]                            { return TokenType.BAD_CHARACTER; }
}

<SQF_MODE> {
  { SYM_LPAREN }                 { return ParamTypes.SYM_LPARENTHESIS; }
  { SYM_RPAREN }                 { return this.exitSQFMode(); }
  [^]+                           { return ParamTypes.SQF_STATEMENT; }
}

[^] { return TokenType.BAD_CHARACTER; }
