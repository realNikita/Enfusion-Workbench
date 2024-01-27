// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.flipperplz.bisutils.param.statement.ParamExternalClass;
import com.intellij.psi.PsiNamedElement;
import com.flipperplz.bisutils.param.statement.ParamDeleteStatement;
import com.flipperplz.bisutils.param.literal.ParamString;
import com.flipperplz.bisutils.param.literal.ParamArray;
import com.flipperplz.bisutils.param.statement.ParamVariableStatement;
import com.flipperplz.bisutils.param.statement.ParamClass;
import com.flipperplz.bisutils.param.node.ParamNumerical;
import com.flipperplz.bisutils.param.statement.ParamEnum;

public class ParamGVisitor extends PsiElementVisitor {

  public void visitArrayElement(@NotNull ParamGArrayElement o) {
    visitLiteral(o);
  }

  public void visitArrayLiteral(@NotNull ParamGArrayLiteral o) {
    visitArrayElement(o);
    // visitParamArray(o);
  }

  public void visitClassStatement(@NotNull ParamGClassStatement o) {
    visitExternalClassStatement(o);
    // visitParamClass(o);
  }

  public void visitDeleteStatement(@NotNull ParamGDeleteStatement o) {
    visitStatement(o);
    // visitParamDeleteStatement(o);
  }

  public void visitEnumDeclaration(@NotNull ParamGEnumDeclaration o) {
    visitStatement(o);
    // visitParamEnum(o);
  }

  public void visitEnumValue(@NotNull ParamGEnumValue o) {
    visitParamPsiElement(o);
  }

  public void visitExternalClassStatement(@NotNull ParamGExternalClassStatement o) {
    visitStatement(o);
    // visitParamExternalClass(o);
  }

  public void visitIdentifier(@NotNull ParamGIdentifier o) {
    visitPsiNamedElement(o);
    // visitParamPsiElement(o);
  }

  public void visitLiteral(@NotNull ParamGLiteral o) {
    visitLiteralExt(o);
    // visitParamPsiElement(o);
  }

  public void visitNumericLiteral(@NotNull ParamGNumericLiteral o) {
    visitLiteral(o);
    // visitParamNumerical(o);
  }

  public void visitParameterStatement(@NotNull ParamGParameterStatement o) {
    visitStatement(o);
    // visitParamVariableStatement(o);
  }

  public void visitStatement(@NotNull ParamGStatement o) {
    visitStatementExt(o);
    // visitParamPsiElement(o);
  }

  public void visitStringLiteral(@NotNull ParamGStringLiteral o) {
    visitLiteral(o);
    // visitParamString(o);
  }

  public void visitLiteralExt(@NotNull ParamGLiteralExt o) {
    visitPsiElement(o);
  }

  public void visitStatementExt(@NotNull ParamGStatementExt o) {
    visitPsiElement(o);
  }

  public void visitParamPsiElement(@NotNull ParamPsiElement o) {
    visitElement(o);
  }

  public void visitPsiNamedElement(@NotNull PsiNamedElement o) {
    visitElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
