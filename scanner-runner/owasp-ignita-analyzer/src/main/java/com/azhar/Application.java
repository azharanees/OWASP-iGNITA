package com.azhar;

import edu.umd.cs.findbugs.*;
import edu.umd.cs.findbugs.config.UserPreferences;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Application {

    private static final String TARGET_JAR_PATH = "uploads/webgoat-container-7.0.1.jar";
    private static final String FINDSECBUGS_JAR_PATH = "target/lib/findsecbugs-plugin-1.9.0.jar";

    private FindBugs2 findBugs;

    public Application() {
        this.findBugs = new FindBugs2();
    }

    public Collection<BugInstance> findBugs(String p) throws IOException, InterruptedException {
        Project project = new Project();

        addPlugin();
        setupFiles(project, p);

        BugCollection bugs = new SortedBugCollection();
        BugReporter bugReporter = new Reporter(bugs);
        findBugs.setProject(project);

        findBugs.setDetectorFactoryCollection(DetectorFactoryCollection.instance());
        findBugs.setBugReporter(bugReporter);
        final UserPreferences defaultUserPreferences = UserPreferences.createDefaultUserPreferences();
        defaultUserPreferences.setEffort(UserPreferences.EFFORT_MAX);
        findBugs.setUserPreferences(defaultUserPreferences);

        findBugs.execute();

        return Collections.unmodifiableCollection(findBugs.getBugReporter().getBugCollection().getCollection());
    }

    private void addPlugin() {
        try {
            Path pluginPath = Paths.get(FINDSECBUGS_JAR_PATH);
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            Plugin plugin = Plugin.addCustomPlugin(pluginPath.toUri(), contextClassLoader);
        } catch (PluginException e) {
            System.err.println("Could not load plugin " + e.getMessage());
        }
    }

    private void setupFiles(Project project, String path) {
        project.addFile(path);

        Iterator<File> it = FileUtils.iterateFiles(new File("target/uploads"), null, false);
        Iterator<File> it2 = FileUtils.iterateFiles(new File("target/lib"), null, false);
        while(it.hasNext()) {
            File next = it.next();
            if(!next.getName().equals(new File(TARGET_JAR_PATH).getName()))
                project.addAuxClasspathEntry(next.getAbsolutePath());
        }
        while(it2.hasNext()) {
            File next = it2.next();
            if(!next.getName().equals(new File(TARGET_JAR_PATH).getName()))
                project.addAuxClasspathEntry(next.getAbsolutePath());
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Scanning Files");
//        String path = args[0];
        new Application().findBugs("target/lib/webgoat-container-7.0.1.jar");
    }
}
