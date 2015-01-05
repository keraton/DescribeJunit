package com.keraton.describejunit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;

import static org.junit.Assert.assertEquals;

@RunWith(DescribeJunitRunner.class)
public class DescribeJunitWithContextTest { RunNotifier runNotifier; @Test public void SomeClass(){

    class Context {
        int constInt = 1,
            varInt = 1;
    }

    new Spec<Context>().
    describe("someMethod with context", new Context(), runNotifier)

        .beforeEach((context) -> {
            context.varInt = 2;
        })

        .it("should run with context", (context) -> {
            context.varInt++;
            assertEquals(1, context.constInt);
            assertEquals(3, context.varInt);
        })

        .it("should run initialize context", (context) -> {
            assertEquals(2, context.varInt);
        });

}}
