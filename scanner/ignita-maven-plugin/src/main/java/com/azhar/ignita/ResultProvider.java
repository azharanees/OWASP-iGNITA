package com.azhar.ignita;

import org.apache.maven.plugin.MojoExecutionException;

public interface ResultProvider {
    String getVersion(String command) throws MojoExecutionException;
}
