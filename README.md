DescribeJunit
=============

## Background
Another way to write Junit, The fact we need to use camelCase or snake_case to define
our test name can be too much. Sometimes it becomes hard to read, specially if we want to use some specific char that Java
forbid to use it as a method name (ex. '+'). So this framework attempt to help developpers to have a better test by writing the test case naturally.

Inspired by Mocha.js http://mochajs.org/ It start with describe and continue with it.It uses Java 8 (lambda expression)

## How it works ?

This is how DescribeJunit test.

```
@RunWith(DescribeJunitRunner.class)
public class DescribeJunitTest {  RunNotifier runNotifier;  @Test public void SomeClass(){


    describe("someMethod", runNotifier)

        .it("should run nicely", () -> {
            assertTrue(true);
        })

        .ignore("should be ignored", () -> {
        })

        .it("should test throw exception", RuntimeException.class, () -> {
            throw new RuntimeException("Should be catch");
        })

        .afterMethod(() -> {
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

}}
```

DescribeJunit works as a JunitRunner, it catch Junit RunNotifier and push it to the DescribeRunner. If you feel like to know better please see the test section.






