// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.flipperplz.enfusionWorkbench.languages.param.psi.ParamTypes.*;
import com.flipperplz.enfusionWorkbench.languages.param.psi.mixin.ParamGEnumValueMixin;
import com.flipperplz.enfusionWorkbench.languages.param.psi.*;

public class ParamGEnumValueImpl extends ParamGEnumValueMixin implements ParamGEnumValue {

  public ParamGEnumValueImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ParamGVisitor visitor) {
    visitor.visitEnumValue(this);
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
  public ParamGNumericLiteral getNumericLiteral() {
    return findChildByClass(ParamGNumericLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getOpAssign() {
    return findChildByType(OP_ASSIGN);
  }

}
