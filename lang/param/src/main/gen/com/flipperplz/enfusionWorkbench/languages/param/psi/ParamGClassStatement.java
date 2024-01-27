// This is a generated file. Not intended for manual editing.
package com.flipperplz.enfusionWorkbench.languages.param.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.flipperplz.bisutils.param.statement.ParamClass;

public interface ParamGClassStatement extends ParamGExternalClassStatement, ParamClass {

  @NotNull
  List<ParamGIdentifier> getIdentifierList();

  @NotNull
  List<ParamGStatement> getStatementList();

  @Nullable
  PsiElement getSymColon();

  @Nullable
  PsiElement getSymLcurly();

  @Nullable
  PsiElement getSymRcurly();

}
