// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.flipperplz.enfusionWorkbench.languages.param.parser.ParamElementType;
import com.flipperplz.enfusionWorkbench.languages.param.lexer.ParamTokenType;
import com.flipperplz.enfusionWorkbench.languages.param.psi.impl.*;

public interface ParamTypes {

  IElementType ARRAY_ELEMENT = new ParamElementType("ARRAY_ELEMENT");
  IElementType ARRAY_LITERAL = new ParamElementType("ARRAY_LITERAL");
  IElementType CLASS_STATEMENT = new ParamElementType("CLASS_STATEMENT");
  IElementType DELETE_STATEMENT = new ParamElementType("DELETE_STATEMENT");
  IElementType ENUM_DECLARATION = new ParamElementType("ENUM_DECLARATION");
  IElementType ENUM_VALUE = new ParamElementType("ENUM_VALUE");
  IElementType EXTERNAL_CLASS_STATEMENT = new ParamElementType("EXTERNAL_CLASS_STATEMENT");
  IElementType IDENTIFIER = new ParamElementType("IDENTIFIER");
  IElementType LITERAL = new ParamElementType("LITERAL");
  IElementType NUMERIC_LITERAL = new ParamElementType("NUMERIC_LITERAL");
  IElementType PARAMETER_STATEMENT = new ParamElementType("PARAMETER_STATEMENT");
  IElementType STATEMENT = new ParamElementType("STATEMENT");
  IElementType STRING_LITERAL = new ParamElementType("STRING_LITERAL");

  IElementType ABS_IDENTIFIER = new ParamTokenType("ABS_IDENTIFIER");
  IElementType ABS_NUMERIC = new ParamTokenType("ABS_NUMERIC");
  IElementType DELIMITED_COMMENT = new ParamTokenType("DELIMITED_COMMENT");
  IElementType EMPTY_DELIMITED_COMMENT = new ParamTokenType("EMPTY_DELIMITED_COMMENT");
  IElementType EOF = new ParamTokenType("EOF");
  IElementType EOL = new ParamTokenType("EOL");
  IElementType KW_CLASS = new ParamTokenType("class");
  IElementType KW_DELETE = new ParamTokenType("delete");
  IElementType KW_ENUM = new ParamTokenType("enum");
  IElementType OP_ADDASSIGN = new ParamTokenType("+=");
  IElementType OP_ASSIGN = new ParamTokenType("=");
  IElementType OP_SUBASSIGN = new ParamTokenType("-=");
  IElementType SINGLE_LINE_COMMENT = new ParamTokenType("SINGLE_LINE_COMMENT");
  IElementType SYM_COLON = new ParamTokenType("SYM_COLON");
  IElementType SYM_COMMA = new ParamTokenType(",");
  IElementType SYM_DQUOTE = new ParamTokenType("SYM_DQUOTE");
  IElementType SYM_LCURLY = new ParamTokenType("{");
  IElementType SYM_LSQUARE = new ParamTokenType("[");
  IElementType SYM_RCURLY = new ParamTokenType("}");
  IElementType SYM_RSQUARE = new ParamTokenType("]");
  IElementType SYM_SEMI = new ParamTokenType(";");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY_LITERAL) {
        return new ParamGArrayLiteralImpl(node);
      }
      else if (type == CLASS_STATEMENT) {
        return new ParamGClassStatementImpl(node);
      }
      else if (type == DELETE_STATEMENT) {
        return new ParamGDeleteStatementImpl(node);
      }
      else if (type == ENUM_DECLARATION) {
        return new ParamGEnumDeclarationImpl(node);
      }
      else if (type == ENUM_VALUE) {
        return new ParamGEnumValueImpl(node);
      }
      else if (type == EXTERNAL_CLASS_STATEMENT) {
        return new ParamGExternalClassStatementImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new ParamGIdentifierImpl(node);
      }
      else if (type == NUMERIC_LITERAL) {
        return new ParamGNumericLiteralImpl(node);
      }
      else if (type == PARAMETER_STATEMENT) {
        return new ParamGParameterStatementImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new ParamGStringLiteralImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
