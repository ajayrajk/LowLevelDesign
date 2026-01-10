package org.designpattern.behavioral.templatedesign.withtemp;

abstract class CourseTemplate {

    public final void conductCourse(){
         prepareMaterial();
         conductClasses();
         giveAssignment();
         takeFeedback();
    }

    private void takeFeedback() {
        System.out.println("Preparing material");
    }

    private void giveAssignment() {
        System.out.println("Giving Assignment");
    }

    private void conductClasses() {
        System.out.println("Conduct classes");
    }

    private void prepareMaterial() {
        System.out.println("Preparing material");
    }
}
