// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.flipperplz.enfusionWorkbench.languages.param.psi.ParamTypes.*;
import com.flipperplz.enfusionWorkbench.languages.param.psi.mixin.ParamGExternalClassStatementMixin;
import com.flipperplz.enfusionWorkbench.languages.param.psi.*;

public class ParamGExternalClassStatementImpl extends ParamGExternalClassStatementMixin implements ParamGExternalClassStatement {

  public ParamGExternalClassStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ParamGVisitor visitor) {
    visitor.visitExternalClassStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ParamGVisitor) accept((ParamGVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ParamGIdentifier getIdentifier() {
    return findChildByClass(ParamGIdentifier.class);
  }

  @Override
  @NotNull
  public PsiElement getKwClass() {
    return findNotNullChildByType(KW_CLASS);
  }

}
