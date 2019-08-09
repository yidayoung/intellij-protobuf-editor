/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.devtools.intellij.protoeditor.lang.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A body that contains a start and end token and some number of elements in between. For example, a
 * message definition wrapped between '{' and '}', or an option list wrapped between '[' and ']'.
 */
public interface ProtoBlockBody extends PsiElement {
  /** Returns the start token. For example, '{' or '['. */
  @NotNull
  PsiElement getStart();

  /** Returns the end token. For example, '}' or ']'. */
  @Nullable
  PsiElement getEnd();
}
