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
package com.h3xstream.findsecbugs.cookie;

import com.h3xstream.findbugs.test.BaseDetectorTest;
import com.h3xstream.findbugs.test.EasyBugReporter;
import org.testng.annotations.Test;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class UrlRewritingDetectorTest extends BaseDetectorTest {
    
    @Test
    public void detectUrlRewriting() throws Exception {
        //Locate test code
        String[] files = {
                getClassFilePath("testcode/cookie/UrlRewriting")
        };

        //Run the analysis
        EasyBugReporter reporter = spy(new SecurityReporter());
        analyze(files, reporter);


        //1rst variation encodeURL(req.getRequestURI())
        verify(reporter).doReportBug(
                bugDefinition()
                        .bugType("URL_REWRITING")
                        .inClass("UrlRewriting").inMethod("encodeURLRewrite").atLine(17)
                        .build()
        );
        //2nd variation, deprecated encodeUrl(req.getRequestURI())
        verify(reporter).doReportBug(
                bugDefinition()
                        .bugType("URL_REWRITING")
                        .inClass("UrlRewriting").inMethod("encodeUrlRewrite").atLine(21)
                        .build()
        );
        //3rd variation encodeRedirectURL(req.getRequestURI())
        verify(reporter).doReportBug(
                bugDefinition()
                        .bugType("URL_REWRITING")
                        .inClass("UrlRewriting").inMethod("encodeRedirectURLRewrite").atLine(25)
                        .build()
        );
        //4th variation, deprecated encodeRedirectUrl(req.getRequestURI())
        verify(reporter).doReportBug(
                bugDefinition()
                        .bugType("URL_REWRITING")
                        .inClass("UrlRewriting").inMethod("encodeRedirectUrlRewrite").atLine(29)
                        .build()
        );

        verify(reporter, times(4)).doReportBug(
                bugDefinition()
                        .bugType("URL_REWRITING")
                        .build()
        );
    }
}
