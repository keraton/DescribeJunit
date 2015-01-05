package com.keraton.describejunit.it;

import com.keraton.describejunit.it.It;
import com.keraton.describejunit.it.ItRunner;
import org.junit.runner.RunWith;

@RunWith(ItRunner.class)
public class DescribeItRunner {

    @It("should run this test with annotation value")
    public void _1(){
    }
}
