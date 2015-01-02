package com.keraton.describejunit;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class DescribeJunit<T> {

    private final String description;
    private final RunNotifier runNotifier;
    private final RunnerHelper runHelper;
    private final T context;
    private final LinkedList<InternalRunner> before = new LinkedList<>();
    private final LinkedList<InternalRunner> afters = new LinkedList<>();

    public DescribeJunit(String description, T context, RunNotifier runNotifier) {
        this.description = description;
        this.runNotifier = runNotifier;
        this.runHelper = new RunnerHelper();
        this.context = context;
    }

    public static DescribeJunit describe(String description, Object context, RunNotifier runNotifier) {
        return new DescribeJunit(description, context, runNotifier);
    }

    public static DescribeJunit describe(String description, RunNotifier runNotifier) {
        return new DescribeJunit(description, null, runNotifier);
    }


    public DescribeJunit<T> it(String description, DescribeRunner runner) {
        it(description, null, runner);
        return this;
    }

    public DescribeJunit<T> it(String description, DescribeRunnerWithContext<T> runner) {
        runIt(description, null, runner);
        return this;
    }

    public DescribeJunit it(String description, Class throwableClass, DescribeRunner runner) {
        runIt(description, throwableClass, runner);
        return this;
    }

    public DescribeJunit it(String description, Class throwableClass, DescribeRunnerWithContext runner) {
        runIt(description, throwableClass, runner);
        return this;
    }

    void runIt(String description, Class throwableClass, InternalRunner runner) {
        Description desc = Description.createTestDescription(this.description, description, null);
        runNotifier.fireTestStarted(desc);
        try {
            this.runHelper.runListRunner(before, context);
            this.runHelper.runWithCatch(runner, throwableClass, context);
            this.runHelper.runListRunner(afters, context);
        }
        catch (Throwable e) {
            runNotifier.fireTestFailure(new Failure(desc, e));
        }
        runNotifier.fireTestFinished(desc);
    }


    public DescribeJunit ignore(String description, DescribeRunner runner) {
        Description desc = Description.createTestDescription(this.description, description, null);
        runNotifier.fireTestStarted(desc);
        runNotifier.fireTestIgnored(desc);
        return this;
    }

    public DescribeJunit<T> ignore(String description, DescribeRunnerWithContext<T> runner) {
        Description desc = Description.createTestDescription(this.description, description, null);
        runNotifier.fireTestStarted(desc);
        runNotifier.fireTestIgnored(desc);
        return this;
    }

    public DescribeJunit before(DescribeRunner runner) {
        before.add(runner);
        return this;
    }

    public DescribeJunit<T> before(DescribeRunnerWithContext<T> runner) {
        before.add(runner);
        return this;
    }

    public DescribeJunit after(DescribeRunner runner) {
        afters.add(runner);
        return this;
    }

    public DescribeJunit<T> after(DescribeRunnerWithContext<T> runner) {
        afters.add(runner);
        return this;
    }

    public DescribeJunit beforeMethod(DescribeRunner runner) {
        this.runHelper.runMethod(runner, context);
        return this;
    }

    public DescribeJunit<T>  beforeMethod(DescribeRunnerWithContext<T> runner) {
        this.runHelper.runMethod(runner, context);
        return this;
    }

    public DescribeJunit afterMethod(DescribeRunner runner) {
        this.runHelper.runMethod(runner, context);
        return this;
    }

    public DescribeJunit<T>  afterMethod(DescribeRunnerWithContext<T> runner) {
        this.runHelper.runMethod(runner, context);
        return this;
    }
}
