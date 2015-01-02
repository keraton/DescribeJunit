package com.keraton.describejunit;

public interface DescribeRunnerWithContext<T> extends InternalRunner {
    void run(T t);
}
