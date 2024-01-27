// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.flipperplz.enfusionWorkbench.languages.param.psi.ParamTypes.*;
import com.flipperplz.enfusionWorkbench.languages.param.psi.*;

public class ParamGParameterStatementImpl extends com.flipperplz.enfusionWorkbench.languages.param.psi.mixin.ParamGParameterStatementImpl implements ParamGParameterStatement {

  public ParamGParameterStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ParamGVisitor visitor) {
    visitor.visitParameterStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ParamGVisitor) accept((ParamGVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ParamGIdentifier getIdentifier() {
    return findNotNullChildByClass(ParamGIdentifier.class);
  }

  @Override
  @Nullable
  public ParamGLiteral getLiteral() {
    return findChildByClass(ParamGLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getOpAddassign() {
    return findChildByType(OP_ADDASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getOpAssign() {
    return findChildByType(OP_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getOpSubassign() {
    return findChildByType(OP_SUBASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getSymLsquare() {
    return findChildByType(SYM_LSQUARE);
  }

  @Override
  @Nullable
  public PsiElement getSymRsquare() {
    return findChildByType(SYM_RSQUARE);
  }

}
