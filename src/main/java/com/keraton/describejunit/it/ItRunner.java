package com.keraton.describejunit.it;

import org.junit.runner.Description;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.List;

public class ItRunner extends BlockJUnit4ClassRunner {

    public ItRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Description describeChild(FrameworkMethod method) {
        String methodName = testName(method);
        It it = method.getAnnotation(It.class);
        methodName = it.value();

        return Description.createTestDescription(getTestClass().getJavaClass(),
                methodName, method.getAnnotations());
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> methods = getTestClass().getAnnotatedMethods(It.class);
        return methods;
    }

}
