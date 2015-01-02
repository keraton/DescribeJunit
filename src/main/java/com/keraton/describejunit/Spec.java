package com.keraton.describejunit;

import org.junit.runner.notification.RunNotifier;

public class Spec<T> {

    public DescribeJunit<T>  describe(String description, T context, RunNotifier runNotifier){
        return new DescribeJunit<>(description, context, runNotifier);
    }

}
