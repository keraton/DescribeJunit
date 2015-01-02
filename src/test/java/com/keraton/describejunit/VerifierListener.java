package com.keraton.describejunit;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.util.HashMap;
import java.util.Map;

class VerifierListener extends RunListener {

    public static final String OK = "OK";
    public static final String FAILURE = "FAILURE";
    public static final String IGNORED = "IGNORED";

    private final Map<String,String> map = new HashMap<>();

    @Override
    public void testStarted(Description description) throws Exception {
        updateStatus(description, OK);
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        updateStatus(failure.getDescription(), FAILURE);
    }

    @Override
    public void testAssumptionFailure(Failure failure) {
        updateStatus(failure.getDescription(), FAILURE);
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        updateStatus(description, IGNORED);
    }

    String getStatus(String displayName) {
        return map.get(displayName);
    }

    private void updateStatus(Description description, String status) {
        map.put(description.getDisplayName(), status);
    }
}
