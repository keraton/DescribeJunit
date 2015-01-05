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

    .before(() -> {
        sb.append("before").append(";");
    })

    .beforeEach(() -> {
        sb.append("beforeEach").append(";");
    })

    .afterEach(() -> {
        sb.append("afterEach").append(";");
    })

    .it("should run ", () -> {
    })

    .it("should run too", () -> {
    })

    .after(() -> {
        sb.append("after").append(";");
    });

assertEquals("before;beforeEach;afterEach;beforeEach;afterEach;after;", sb.toString());

}}
