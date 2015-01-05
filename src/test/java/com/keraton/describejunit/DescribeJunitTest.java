package com.keraton.describejunit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;

import static com.keraton.describejunit.DescribeJunit.describe;
import static com.keraton.describejunit.VerifierListener.FAILURE;
import static com.keraton.describejunit.VerifierListener.IGNORED;
import static com.keraton.describejunit.VerifierListener.OK;
import static org.junit.Assert.*;

@RunWith(DescribeJunitRunner.class)
public class DescribeJunitTest {  RunNotifier runNotifier;  @Test public void SomeClass(){

    final VerifierListener listener = new VerifierListener();

    RunNotifier testerRunNotifier = new RunNotifier();
    testerRunNotifier.addListener(listener);

    // To see the test with provided runNotifier, replace testerRunNotifier with runNotifier
    describe("someMethod", testerRunNotifier)

        .it("is not implemented yet")

        .it("should run nicely", () -> {
            assertTrue(true);
        })

        .itSkip("should be ignored", () -> {
        })

        .it("should test throw exception", RuntimeException.class, () -> {
            throw new RuntimeException("Should be catch");
        })

        .after(() -> {
            System.out.println("End of test");
        });


    describe("anotherMethod", testerRunNotifier)

        .it("should throw exception when no exception throw", RuntimeException.class, () -> {
        })

        .it("should throw exception", () -> {
            throw new RuntimeException("Oh my..");
        })

        .it("should failure", () -> {
            assertNotNull(null);
        });


    assertEquals(OK, listener.getStatus("should run nicely(someMethod)"));
    assertEquals(IGNORED,listener.getStatus("should be ignored(someMethod)"));
    assertEquals(OK,listener.getStatus("should test throw exception(someMethod)"));

    assertEquals(FAILURE, listener.getStatus("should throw exception when no exception throw(anotherMethod)"));
    assertEquals(FAILURE, listener.getStatus("should throw exception(anotherMethod)"));
    assertEquals(FAILURE, listener.getStatus("should failure(anotherMethod)"));

}}
