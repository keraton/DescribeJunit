package com.keraton.describejunit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;

import static com.keraton.describejunit.DescribeJunit.describe;
import static org.junit.Assert.assertNotNull;

@RunWith(DescribeJunitRunner.class)
public class DescribeJunitRunnerTest { RunNotifier runNotifier; @Test public void DescribeJunitRunner (){

describe("DescribeJunit RunWith feature", runNotifier)

      .it("should set runNotifier field", () -> {
          assertNotNull(runNotifier);
      });

}}
