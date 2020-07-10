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
package com.h3xstream.findsecbugs.xml;

import com.h3xstream.findbugs.test.BaseDetectorTest;
import com.h3xstream.findbugs.test.EasyBugReporter;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class XmlReaderDetectorTest extends BaseDetectorTest {

    @Test
    public void detectXxe() throws Exception {
        //Locate test code
        String[] files = {
                getClassFilePath("testcode/xxe/XmlReaderVulnerable")
        };

        //Run the analysis
        EasyBugReporter reporter = spy(new SecurityReporter());
        analyze(files, reporter);

        //Assertions
        verify(reporter).doReportBug(
                bugDefinition()
                        .bugType("XXE_XMLREADER")
                        .inClass("XmlReaderVulnerable").inMethod("receiveXMLStream").atLine(22)
                        .build()
        );
        verify(reporter, never()).doReportBug(
                bugDefinition()
                        .bugType("XXE_SAXPARSER")
                        .build()
        );
        Mockito.verify(reporter, never()).doReportBug(
                bugDefinition()
                        .bugType("XXE_DOCUMENT")
                        .build()
        );
    }

    @Test
    public void avoidFalsePositive() throws Exception {
        //Locate test code
        String[] files = {
                getClassFilePath("testcode/xxe/XmlReaderSafeProperty")
        };

        //Run the analysis
        EasyBugReporter reporter = spy(new SecurityReporter());
        analyze(files, reporter);

        //Assertions
        verify(reporter,never()).doReportBug(
                bugDefinition()
                        .bugType("XXE_XMLREADER")
                        .build()
        );
        verify(reporter, never()).doReportBug(
                bugDefinition()
                        .bugType("XXE_SAXPARSER")
                        .build()
        );
        verify(reporter, never()).doReportBug(
                bugDefinition()
                        .bugType("XXE_DOCUMENT")
                        .build()
        );
    }
}
