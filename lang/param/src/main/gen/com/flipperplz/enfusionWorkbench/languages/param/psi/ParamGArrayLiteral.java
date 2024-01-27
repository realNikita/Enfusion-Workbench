// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.flipperplz.bisutils.param.literal.ParamArray;

public interface ParamGArrayLiteral extends ParamGArrayElement, ParamArray {

  @NotNull
  List<ParamGLiteral> getLiteralList();

  @NotNull
  PsiElement getSymLcurly();

  @Nullable
  PsiElement getSymRcurly();

}
