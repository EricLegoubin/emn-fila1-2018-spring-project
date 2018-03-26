package main.ott.service.internalManagement.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class CommandLinePusher {
    @Autowired
    private PushDailyCousesJob pushDailyCousesJob;

    @ShellMethod("Force le push daily")
    public void pushdaily() {
        pushDailyCousesJob.pushCourses();
    }
}
