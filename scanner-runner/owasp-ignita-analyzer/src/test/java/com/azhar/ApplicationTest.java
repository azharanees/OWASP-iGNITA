package com.azhar;

import edu.umd.cs.findbugs.BugInstance;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class ApplicationTest {
    private Application app;

    @Before
    public void setUp() throws Exception {
        app = new Application();
    }

    @Test
    public void testNoOfDefects() throws IOException, InterruptedException {
        final Collection<BugInstance> defects = app.findBugs("uploads/webgoat-container-7.0.1.jar");
        assertThat(defects.size()).as("Should find more than 2 defects").isGreaterThan(2);
    }

}