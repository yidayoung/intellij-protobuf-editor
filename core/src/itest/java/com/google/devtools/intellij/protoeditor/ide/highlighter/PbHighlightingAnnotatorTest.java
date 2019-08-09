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
package com.google.devtools.intellij.protoeditor.ide.highlighter;

import com.google.devtools.intellij.protoeditor.TestUtils;
import com.google.devtools.intellij.protoeditor.fixtures.PbCodeInsightFixtureTestCase;

public class PbHighlightingAnnotatorTest extends PbCodeInsightFixtureTestCase {

  @Override
  public void setUp() throws Exception {
    super.setUp();
    myFixture.addFileToProject(
        TestUtils.OPENSOURCE_DESCRIPTOR_PATH, TestUtils.getOpensourceDescriptorText());
    TestUtils.addTestFileResolveProvider(getProject(), TestUtils.OPENSOURCE_DESCRIPTOR_PATH);
    TestUtils.registerTestdataFileExtension();
  }

  @Override
  public void tearDown() throws Exception {
    TestUtils.removeTestFileResolveProvider(getProject());
    super.tearDown();
  }

  @Override
  public String getTestDataPath() {
    String discoveredPath = TestUtils.getTestdataPath(PbHighlightingAnnotatorTest.class);
    return discoveredPath == null ? "" : discoveredPath;
  }

  public void testAnnotator() {
    myFixture.configureByFile("ide/highlighter/TopLevelString.proto.testdata");
    myFixture.testFile("ide/highlighter/Highlighted.proto.testdata").checkSymbolNames().test();
  }
}
