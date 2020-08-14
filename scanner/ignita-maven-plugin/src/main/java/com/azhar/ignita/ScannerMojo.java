package com.azhar.ignita;
import com.azhar.Application;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import javax.inject.Inject;
import java.io.IOException;

/***
 * Skeleton Ignita scanner results
 */
@Mojo(name="runScan",defaultPhase = LifecyclePhase.INSTALL)
public class ScannerMojo extends AbstractMojo{

    @Parameter(property = "git.command",defaultValue = "git rev-parse --short HEAD")
    private String command;

    @Parameter(property = "project", readonly = true)
    private MavenProject project;


    @Inject
    ResultProvider resultProvider;
    public void execute() throws MojoExecutionException, MojoFailureException {

        String result = resultProvider.getVersion(command);
        String jarPath = project.getBuild().getDirectory() + "\\" +project.getArtifactId()+"-"+(project.getVersion())+".jar";

    getLog().info("File Scanning"+ jarPath);
        Application application = new Application();
        try {
            application.findBugs(jarPath);
            getLog().info("Scan Complete "+ result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
