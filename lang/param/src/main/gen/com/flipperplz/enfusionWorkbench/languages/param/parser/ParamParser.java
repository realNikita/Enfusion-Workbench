// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.flipperplz.enfusionWorkbench.languages.param.psi.ParamTypes.*;
import static com.flipperplz.enfusionWorkbench.languages.param.parser.ParamParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ParamParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, EXTENDS_SETS_);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return file(builder_, level_ + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ARRAY_ELEMENT, ARRAY_LITERAL, LITERAL, NUMERIC_LITERAL,
      STRING_LITERAL),
    create_token_set_(CLASS_STATEMENT, DELETE_STATEMENT, ENUM_DECLARATION, EXTERNAL_CLASS_STATEMENT,
      PARAMETER_STATEMENT, STATEMENT),
  };

  /* ********************************************************** */
  // arrayLiteral | literal
  public static boolean arrayElement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayElement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, ARRAY_ELEMENT, "<array element>");
    result_ = arrayLiteral(builder_, level_ + 1);
    if (!result_) result_ = literal(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // SYM_LCURLY (arrayElement (SYM_COMMA arrayElement)*)? SYM_RCURLY
  public static boolean arrayLiteral(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayLiteral")) return false;
    if (!nextTokenIs(builder_, SYM_LCURLY)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ARRAY_LITERAL, null);
    result_ = consumeToken(builder_, SYM_LCURLY);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, arrayLiteral_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SYM_RCURLY) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (arrayElement (SYM_COMMA arrayElement)*)?
  private static boolean arrayLiteral_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayLiteral_1")) return false;
    arrayLiteral_1_0(builder_, level_ + 1);
    return true;
  }

  // arrayElement (SYM_COMMA arrayElement)*
  private static boolean arrayLiteral_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayLiteral_1_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = arrayElement(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && arrayLiteral_1_0_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (SYM_COMMA arrayElement)*
  private static boolean arrayLiteral_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayLiteral_1_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!arrayLiteral_1_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "arrayLiteral_1_0_1", pos_)) break;
    }
    return true;
  }

  // SYM_COMMA arrayElement
  private static boolean arrayLiteral_1_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayLiteral_1_0_1_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, SYM_COMMA);
    pinned_ = result_; // pin = 1
    result_ = result_ && arrayElement(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // normalOperator | OP_ADDASSIGN | OP_SUBASSIGN
  static boolean arrayOperator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayOperator")) return false;
    boolean result_;
    result_ = normalOperator(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, OP_ADDASSIGN);
    if (!result_) result_ = consumeToken(builder_, OP_SUBASSIGN);
    return result_;
  }

  /* ********************************************************** */
  // SYM_LSQUARE SYM_RSQUARE
  static boolean arraySquare(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arraySquare")) return false;
    if (!nextTokenIs(builder_, SYM_LSQUARE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, SYM_LSQUARE, SYM_RSQUARE);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // KW_CLASS identifier [SYM_COLON identifier] SYM_LCURLY statementWithSemi* SYM_RCURLY
  public static boolean classStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classStatement")) return false;
    if (!nextTokenIs(builder_, KW_CLASS)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CLASS_STATEMENT, null);
    result_ = consumeToken(builder_, KW_CLASS);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, identifier(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, classStatement_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, SYM_LCURLY)) && result_;
    result_ = pinned_ && report_error_(builder_, classStatement_4(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, SYM_RCURLY) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // [SYM_COLON identifier]
  private static boolean classStatement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classStatement_2")) return false;
    classStatement_2_0(builder_, level_ + 1);
    return true;
  }

  // SYM_COLON identifier
  private static boolean classStatement_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classStatement_2_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, SYM_COLON);
    pinned_ = result_; // pin = 1
    result_ = result_ && identifier(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // statementWithSemi*
  private static boolean classStatement_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "classStatement_4")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!statementWithSemi(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "classStatement_4", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KW_DELETE identifier
  public static boolean deleteStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "deleteStatement")) return false;
    if (!nextTokenIs(builder_, KW_DELETE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, DELETE_STATEMENT, null);
    result_ = consumeToken(builder_, KW_DELETE);
    pinned_ = result_; // pin = 1
    result_ = result_ && identifier(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // KW_ENUM SYM_LCURLY (enumValue ((SYM_COMMA | EOL | SYM_SEMI) enumValue)*) SYM_RCURLY SYM_SEMI
  public static boolean enumDeclaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumDeclaration")) return false;
    if (!nextTokenIs(builder_, KW_ENUM)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ENUM_DECLARATION, null);
    result_ = consumeTokens(builder_, 1, KW_ENUM, SYM_LCURLY);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, enumDeclaration_2(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeTokens(builder_, -1, SYM_RCURLY, SYM_SEMI)) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // enumValue ((SYM_COMMA | EOL | SYM_SEMI) enumValue)*
  private static boolean enumDeclaration_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumDeclaration_2")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = enumValue(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && enumDeclaration_2_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ((SYM_COMMA | EOL | SYM_SEMI) enumValue)*
  private static boolean enumDeclaration_2_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumDeclaration_2_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!enumDeclaration_2_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "enumDeclaration_2_1", pos_)) break;
    }
    return true;
  }

  // (SYM_COMMA | EOL | SYM_SEMI) enumValue
  private static boolean enumDeclaration_2_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumDeclaration_2_1_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = enumDeclaration_2_1_0_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && enumValue(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // SYM_COMMA | EOL | SYM_SEMI
  private static boolean enumDeclaration_2_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumDeclaration_2_1_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SYM_COMMA);
    if (!result_) result_ = consumeToken(builder_, EOL);
    if (!result_) result_ = consumeToken(builder_, SYM_SEMI);
    return result_;
  }

  /* ********************************************************** */
  // identifier [OP_ASSIGN numericLiteral]
  public static boolean enumValue(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumValue")) return false;
    if (!nextTokenIs(builder_, ABS_IDENTIFIER)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ENUM_VALUE, null);
    result_ = identifier(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && enumValue_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // [OP_ASSIGN numericLiteral]
  private static boolean enumValue_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumValue_1")) return false;
    enumValue_1_0(builder_, level_ + 1);
    return true;
  }

  // OP_ASSIGN numericLiteral
  private static boolean enumValue_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "enumValue_1_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OP_ASSIGN);
    pinned_ = result_; // pin = 1
    result_ = result_ && numericLiteral(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // KW_CLASS identifier
  public static boolean externalClassStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "externalClassStatement")) return false;
    if (!nextTokenIs(builder_, KW_CLASS)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXTERNAL_CLASS_STATEMENT, null);
    result_ = consumeToken(builder_, KW_CLASS);
    pinned_ = result_; // pin = 1
    result_ = result_ && identifier(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // statementWithSemi*
  static boolean file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!statementWithSemi(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "file", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ABS_IDENTIFIER
  public static boolean identifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier")) return false;
    if (!nextTokenIs(builder_, ABS_IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ABS_IDENTIFIER);
    exit_section_(builder_, marker_, IDENTIFIER, result_);
    return result_;
  }

  /* ********************************************************** */
  // numericLiteral | stringLiteral
  public static boolean literal(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "literal")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, LITERAL, "<literal>");
    result_ = numericLiteral(builder_, level_ + 1);
    if (!result_) result_ = stringLiteral(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // OP_ASSIGN
  static boolean normalOperator(PsiBuilder builder_, int level_) {
    return consumeToken(builder_, OP_ASSIGN);
  }

  /* ********************************************************** */
  // ABS_NUMERIC
  public static boolean numericLiteral(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "numericLiteral")) return false;
    if (!nextTokenIs(builder_, ABS_NUMERIC)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ABS_NUMERIC);
    exit_section_(builder_, marker_, NUMERIC_LITERAL, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier ((arraySquare arrayOperator arrayLiteral) | (normalOperator literal))
  public static boolean parameterStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameterStatement")) return false;
    if (!nextTokenIs(builder_, ABS_IDENTIFIER)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, PARAMETER_STATEMENT, null);
    result_ = identifier(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && parameterStatement_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (arraySquare arrayOperator arrayLiteral) | (normalOperator literal)
  private static boolean parameterStatement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameterStatement_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameterStatement_1_0(builder_, level_ + 1);
    if (!result_) result_ = parameterStatement_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // arraySquare arrayOperator arrayLiteral
  private static boolean parameterStatement_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameterStatement_1_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = arraySquare(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, arrayOperator(builder_, level_ + 1));
    result_ = pinned_ && arrayLiteral(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // normalOperator literal
  private static boolean parameterStatement_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameterStatement_1_1")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = normalOperator(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && literal(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // SYM_DQUOTE SYM_DQUOTE
  static boolean quoteEscape(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "quoteEscape")) return false;
    if (!nextTokenIs(builder_, SYM_DQUOTE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, SYM_DQUOTE, SYM_DQUOTE);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // deleteStatement        |
  //               classStatement         |
  //               externalClassStatement |
  //               parameterStatement |
  //               enumDeclaration
  public static boolean statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, STATEMENT, "<statement>");
    result_ = deleteStatement(builder_, level_ + 1);
    if (!result_) result_ = classStatement(builder_, level_ + 1);
    if (!result_) result_ = externalClassStatement(builder_, level_ + 1);
    if (!result_) result_ = parameterStatement(builder_, level_ + 1);
    if (!result_) result_ = enumDeclaration(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // statement SYM_SEMI
  static boolean statementWithSemi(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statementWithSemi")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = statement(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, SYM_SEMI);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // (SYM_DQUOTE (quoteEscape | !SYM_DQUOTE)* SYM_DQUOTE) |
  //                   (!(SYM_RCURLY | SYM_SEMI | EOL | EOF ))*
  public static boolean stringLiteral(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stringLiteral")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, STRING_LITERAL, "<string literal>");
    result_ = stringLiteral_0(builder_, level_ + 1);
    if (!result_) result_ = stringLiteral_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // SYM_DQUOTE (quoteEscape | !SYM_DQUOTE)* SYM_DQUOTE
  private static boolean stringLiteral_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stringLiteral_0")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, SYM_DQUOTE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, stringLiteral_0_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SYM_DQUOTE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (quoteEscape | !SYM_DQUOTE)*
  private static boolean stringLiteral_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stringLiteral_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!stringLiteral_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "stringLiteral_0_1", pos_)) break;
    }
    return true;
  }

  // quoteEscape | !SYM_DQUOTE
  private static boolean stringLiteral_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stringLiteral_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = quoteEscape(builder_, level_ + 1);
    if (!result_) result_ = stringLiteral_0_1_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // !SYM_DQUOTE
  private static boolean stringLiteral_0_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stringLiteral_0_1_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !consumeToken(builder_, SYM_DQUOTE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (!(SYM_RCURLY | SYM_SEMI | EOL | EOF ))*
  private static boolean stringLiteral_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stringLiteral_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!stringLiteral_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "stringLiteral_1", pos_)) break;
    }
    return true;
  }

  // !(SYM_RCURLY | SYM_SEMI | EOL | EOF )
  private static boolean stringLiteral_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stringLiteral_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !stringLiteral_1_0_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // SYM_RCURLY | SYM_SEMI | EOL | EOF
  private static boolean stringLiteral_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stringLiteral_1_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SYM_RCURLY);
    if (!result_) result_ = consumeToken(builder_, SYM_SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    if (!result_) result_ = consumeToken(builder_, EOF);
    return result_;
  }

}
