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

        .before((context) -> {
            sb.append("before").append(";");
        })

        .beforeEach((context) -> {
            sb.append("beforeEach").append(";");
        })

        .afterEach((context) -> {
            sb.append("afterEach").append(";");
        })

        .it("should run with context", (context) -> {
        })

        .it("should run with context too", (context) -> {
        })

        .after((context) -> {
            sb.append("after").append(";");
        });

    assertEquals("before;beforeEach;afterEach;beforeEach;afterEach;after;", sb.toString());
}}
