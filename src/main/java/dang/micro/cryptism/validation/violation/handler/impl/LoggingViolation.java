package dang.micro.cryptism.validation.violation.handler.impl;

import dang.micro.cryptism.validation.violation.handler.ViolationListener;
import dang.micro.cryptism.validation.violation.Violation;

public class LoggingViolation implements ViolationListener {
    @Override
    public void process(Violation data) {
        System.out.println("Logging listener: " + data);
    }

    @Override
    public boolean shouldProcess(Violation data) {
        //Handle every cases
        //TODO: test
        return true;
    }
}
