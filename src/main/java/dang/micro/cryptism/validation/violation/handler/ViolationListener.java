package dang.micro.cryptism.validation.violation.handler;

import dang.micro.cryptism.validation.violation.Violation;

public interface ViolationListener {
    void process(Violation data);
    boolean shouldProcess(Violation data);
}
