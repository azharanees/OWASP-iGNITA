/**
 * Find Security Bugs
 * Copyright (c) Philippe Arteau, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */
package com.h3xstream.findsecbugs.password;

import com.h3xstream.findbugs.test.BaseDetectorTest;
import com.h3xstream.findbugs.test.EasyBugReporter;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class HardcodedPasswordEqualsDetectorTest extends BaseDetectorTest {

    @Test
    public void detectHardCodePasswordsWithEquals() throws Exception {
//        FindSecBugsGlobalConfig.getInstance().setDebugPrintInstructionVisited(true);
//        FindSecBugsGlobalConfig.getInstance().setDebugTaintState(true);


        String[] files = {
//                getClassFilePath("testcode/crypto/BlockCipherList"),
//                getClassFilePath("testcode/template/FreemarkerUsage"),
                getClassFilePath("testcode/password/EqualsPasswordField"),
        };

        EasyBugReporter reporter = spy(new BaseDetectorTest.SecurityReporter());
        analyze(files, reporter);

        for (Integer line : Arrays.asList(19, 28, 39)) {
            verify(reporter).doReportBug(
                    bugDefinition()
                            .bugType("HARD_CODE_PASSWORD")
                            .inClass("EqualsPasswordField").atLine(line)
                            .build()
            );
        }

        verify(reporter, times(3)).doReportBug(bugDefinition().bugType("HARD_CODE_PASSWORD").build());
    }
}
