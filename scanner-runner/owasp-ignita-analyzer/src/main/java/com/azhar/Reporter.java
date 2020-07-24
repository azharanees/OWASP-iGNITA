package com.azhar;

import edu.umd.cs.findbugs.*;
import edu.umd.cs.findbugs.classfile.ClassDescriptor;
import org.apache.bcel.classfile.JavaClass;

public class Reporter extends TextUIBugReporter {

    private final BugCollection bugs;

    Reporter(BugCollection bugs) {
        this.bugs = bugs;
        setPriorityThreshold(Detector.NORMAL_PRIORITY);
    }

    @Override
    protected void doReportBug(BugInstance bugInstance) {
        bugs.add(bugInstance);
    }

    public void finish() {
        System.out.println("Analysis Complete");
        System.out.println("Results: ");
        if(bugs.getCollection().isEmpty()) {
            System.out.println("No vulnerabilities found");
        } else {
            System.out.println(String.format("%d vulnerabilities found", bugs.getCollection().size()));
            for (BugInstance b :
                    bugs) {
                System.out.print(b.getMessage()+" ");
                System.out.println(b.getPrimarySourceLineAnnotation());
            }
            System.out.println(bugs);
        }

    }

    public void observeClass(JavaClass javaClass) {

    }
    public void observeClass(ClassDescriptor classDescriptor) {
    }

    public BugCollection getBugCollection() {
        return bugs;
    }

}
