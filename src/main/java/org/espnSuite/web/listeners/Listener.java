package org.espnSuite.web.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Class Listener
 * @author Pinguin
 */

public class Listener implements ITestListener {

    private Logger log = Logger.getLogger(Listener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("onFinish");
    }
}
