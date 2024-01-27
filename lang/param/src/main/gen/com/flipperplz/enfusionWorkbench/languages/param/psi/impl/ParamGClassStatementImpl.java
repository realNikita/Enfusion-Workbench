// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.flipperplz.enfusionWorkbench.languages.param.psi.ParamTypes.*;
import com.flipperplz.enfusionWorkbench.languages.param.psi.mixin.ParamGClassStatementMixin;
import com.flipperplz.enfusionWorkbench.languages.param.psi.*;

public class ParamGClassStatementImpl extends ParamGClassStatementMixin implements ParamGClassStatement {

  public ParamGClassStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ParamGVisitor visitor) {
    visitor.visitClassStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ParamGVisitor) accept((ParamGVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ParamGIdentifier> getIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ParamGIdentifier.class);
  }

  @Override
  @NotNull
  public List<ParamGStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ParamGStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getSymColon() {
    return findChildByType(SYM_COLON);
  }

  @Override
  @Nullable
  public PsiElement getSymLcurly() {
    return findChildByType(SYM_LCURLY);
  }

  @Override
  @Nullable
  public PsiElement getSymRcurly() {
    return findChildByType(SYM_RCURLY);
  }

}
