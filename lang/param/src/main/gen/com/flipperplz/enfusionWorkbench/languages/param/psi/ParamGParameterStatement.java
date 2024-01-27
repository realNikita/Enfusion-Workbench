// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.flipperplz.bisutils.param.statement.ParamVariableStatement;

public interface ParamGParameterStatement extends ParamGStatement, ParamVariableStatement {

  @NotNull
  ParamGIdentifier getIdentifier();

  @Nullable
  ParamGLiteral getLiteral();

  @Nullable
  PsiElement getOpAddassign();

  @Nullable
  PsiElement getOpAssign();

  @Nullable
  PsiElement getOpSubassign();

  @Nullable
  PsiElement getSymLsquare();

  @Nullable
  PsiElement getSymRsquare();

}
