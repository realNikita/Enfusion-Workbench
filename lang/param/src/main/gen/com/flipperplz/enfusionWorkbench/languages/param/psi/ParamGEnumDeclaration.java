// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.flipperplz.bisutils.param.statement.ParamEnum;

public interface ParamGEnumDeclaration extends ParamGStatement, ParamEnum {

  @NotNull
  List<ParamGEnumValue> getEnumValueList();

  @NotNull
  PsiElement getKwEnum();

  @Nullable
  PsiElement getSymLcurly();

  @Nullable
  PsiElement getSymRcurly();

}
