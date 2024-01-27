// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.flipperplz.enfusionWorkbench.languages.param.psi.ParamTypes.*;
import com.flipperplz.enfusionWorkbench.languages.param.psi.mixin.ParamGArrayLiteralMixin;
import com.flipperplz.enfusionWorkbench.languages.param.psi.*;

public class ParamGArrayLiteralImpl extends ParamGArrayLiteralMixin implements ParamGArrayLiteral {

  public ParamGArrayLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ParamGVisitor visitor) {
    visitor.visitArrayLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ParamGVisitor) accept((ParamGVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ParamGLiteral> getLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ParamGLiteral.class);
  }

  @Override
  @NotNull
  public PsiElement getSymLcurly() {
    return findNotNullChildByType(SYM_LCURLY);
  }

  @Override
  @Nullable
  public PsiElement getSymRcurly() {
    return findChildByType(SYM_RCURLY);
  }

}
