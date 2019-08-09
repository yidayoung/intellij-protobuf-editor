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
package com.google.devtools.intellij.protoeditor.lang.stub.type;

import com.google.devtools.intellij.protoeditor.lang.psi.PbExtendDefinition;
import com.google.devtools.intellij.protoeditor.lang.psi.PbTypeName;
import com.google.devtools.intellij.protoeditor.lang.psi.impl.PbExtendDefinitionImpl;
import com.google.devtools.intellij.protoeditor.lang.stub.PbExtendDefinitionStub;
import com.intellij.lang.Language;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public class PbExtendDefinitionType
    extends IStubElementType<PbExtendDefinitionStub, PbExtendDefinition> {

  PbExtendDefinitionType(String debugName, Language language) {
    super(debugName, language);
  }

  @Override
  public PbExtendDefinition createPsi(@NotNull PbExtendDefinitionStub stub) {
    return new PbExtendDefinitionImpl(stub, this);
  }

  @Override
  public PbExtendDefinitionStub createStub(
      @NotNull PbExtendDefinition psi, @SuppressWarnings("rawtypes") StubElement parentStub) {
    // TODO(volkman): Handle extended type better
    String typeString = null;
    PbTypeName typeName = psi.getTypeName();
    if (typeName != null) {
      typeString = typeName.getReferenceString();
    }

    return new PbExtendDefinitionStub(parentStub, this, typeString == null ? "" : typeString);
  }

  @NotNull
  @Override
  public String getExternalId() {
    return "protobuf.extend";
  }

  @Override
  public void serialize(@NotNull PbExtendDefinitionStub stub, @NotNull StubOutputStream dataStream)
      throws IOException {
    dataStream.writeUTF(stub.getExtendedType());
  }

  @NotNull
  @Override
  public PbExtendDefinitionStub deserialize(
      @NotNull StubInputStream dataStream, @SuppressWarnings("rawtypes") StubElement parentStub)
      throws IOException {
    String extendedType = dataStream.readUTF();
    return new PbExtendDefinitionStub(parentStub, this, extendedType);
  }

  @Override
  public void indexStub(@NotNull PbExtendDefinitionStub stub, @NotNull IndexSink sink) {}
}
