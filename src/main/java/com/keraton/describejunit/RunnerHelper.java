package com.keraton.describejunit;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RunnerHelper<T> {

    public void runWithCatch(InternalRunner runner, Class throwableClass, T context) throws Throwable {
        try {
            run(runner, context);
            verifyException(throwableClass);
        }
        catch (Throwable t){
            throwExceptionIfNotWaitedThrowable(throwableClass, t);
        }
    }

    private void run(InternalRunner runner, T context) {
        if (runner instanceof DescribeRunner) {
            ((DescribeRunner)runner).run();
        }

        if (runner instanceof DescribeRunnerWithContext) {
            ((DescribeRunnerWithContext)runner).run(context);
        }
    }

    private void verifyException(Class throwableClass) {
        if (throwableClass != null) {
            assertEquals(throwableClass, null);
        }
    }

    private void throwExceptionIfNotWaitedThrowable(Class throwableClass, Throwable t) throws Throwable {
        if (t.getClass() != throwableClass) {
            throw t;
        }
    }

    public void runListRunner(List<InternalRunner> befores, T context) {
        befores.forEach((runner) -> {run(runner, context);});
    }

    public void runMethod(InternalRunner runner, T context) {
        run(runner, context);
    }
}
