// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.flipperplz.bisutils.param.statement.ParamDeleteStatement;

public interface ParamGDeleteStatement extends ParamGStatement, ParamDeleteStatement {

  @Nullable
  ParamGIdentifier getIdentifier();

  @NotNull
  PsiElement getKwDelete();

}
