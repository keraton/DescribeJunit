package com.keraton.describejunit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;

import static com.keraton.describejunit.DescribeJunit.describe;
import static org.junit.Assert.assertEquals;

@RunWith(DescribeJunitRunner.class)
public class BeforeAfterTest { RunNotifier runNotifier; @Test public void SomeClass(){

    final StringBuilder sb = new StringBuilder();

    describe("someMethod with context", runNotifier)

        .beforeMethod(() -> {
            sb.append("beforeMethod").append(";");
        })

        .before(() -> {
            sb.append("before").append(";");
        })

        .after(() -> {
            sb.append("after").append(";");
        })

        .it("should run ", () -> {
        })

        .it("should run too", () -> {
        })

        .afterMethod(() -> {
            sb.append("afterMethod").append(";");
        });

    assertEquals("beforeMethod;before;after;before;after;afterMethod;", sb.toString());
}}
