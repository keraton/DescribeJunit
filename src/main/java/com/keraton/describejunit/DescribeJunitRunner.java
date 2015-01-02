package com.keraton.describejunit;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import java.lang.reflect.Field;

public class DescribeJunitRunner extends BlockJUnit4ClassRunner {

    private RunNotifier notifier;

    public DescribeJunitRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    protected Statement withBefores(FrameworkMethod method, Object target,
                                    Statement statement) {
        Field[] fields = target.getClass().getDeclaredFields();
        for(Field field: fields) {
            if (field.getType().equals(RunNotifier.class)){
                field.setAccessible(true);
                try {
                    field.set(target, notifier);
                } catch (IllegalAccessException e) {
                }
            }
        }
        return super.withBefores(method, target, statement);
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
        this.notifier = notifier;
        super.runChild(method, notifier);
    }
}
