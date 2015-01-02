package com.keraton.describejunit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;

import static org.junit.Assert.assertEquals;

@RunWith(DescribeJunitRunner.class)
public class BeforeAfterWithContextTest { RunNotifier runNotifier; @Test public void SomeClass(){

    class Context {
    }

    final StringBuilder sb = new StringBuilder();

    new Spec<Context>().
    describe("someMethod with context", new Context(), runNotifier)

        .beforeMethod((context) -> {
            sb.append("beforeMethod").append(";");
        })

        .before((context) -> {
            sb.append("before").append(";");
        })

        .after((context) -> {
            sb.append("after").append(";");
        })

        .it("should run with context", (context) -> {
        })

        .it("should run with context too", (context) -> {
        })

        .afterMethod((context) -> {
            sb.append("afterMethod").append(";");
        });

    assertEquals("beforeMethod;before;after;before;after;afterMethod;", sb.toString());
}}
