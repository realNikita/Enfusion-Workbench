// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.flipperplz.enfusionWorkbench.languages.param.psi.ParamTypes.*;
import com.flipperplz.enfusionWorkbench.languages.param.psi.mixin.ParamGEnumDeclarationMixin;
import com.flipperplz.enfusionWorkbench.languages.param.psi.*;

public class ParamGEnumDeclarationImpl extends ParamGEnumDeclarationMixin implements ParamGEnumDeclaration {

  public ParamGEnumDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ParamGVisitor visitor) {
    visitor.visitEnumDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ParamGVisitor) accept((ParamGVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ParamGEnumValue> getEnumValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ParamGEnumValue.class);
  }

  @Override
  @NotNull
  public PsiElement getKwEnum() {
    return findNotNullChildByType(KW_ENUM);
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
