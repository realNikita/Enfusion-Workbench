// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.flipperplz.enfusionWorkbench.languages.param.psi.ParamTypes.*;
import com.flipperplz.enfusionWorkbench.languages.param.psi.mixin.ParamGNumericLiteralMixin;
import com.flipperplz.enfusionWorkbench.languages.param.psi.*;

public class ParamGNumericLiteralImpl extends ParamGNumericLiteralMixin implements ParamGNumericLiteral {

  public ParamGNumericLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ParamGVisitor visitor) {
    visitor.visitNumericLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ParamGVisitor) accept((ParamGVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getAbsNumeric() {
    return findNotNullChildByType(ABS_NUMERIC);
  }

}
