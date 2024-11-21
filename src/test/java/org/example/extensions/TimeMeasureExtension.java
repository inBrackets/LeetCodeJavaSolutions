package org.example.extensions;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.math.BigDecimal;

@Slf4j
public class TimeMeasureExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    BigDecimal startTime;
    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        startTime = BigDecimal.valueOf(System.nanoTime());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        BigDecimal executionTime = BigDecimal.valueOf(System.nanoTime()).subtract(startTime).divide(new BigDecimal("1000000"));
        logToAllure(String.format("Time execution = %sms", String.format("%10.6f", executionTime)));
        // log.info("Time execution = {}ms", String.format("%10.6f", executionTime));
    }

    @Step("{message}")
    public static void logToAllure(String message) {
        log.info(message);
    }
}
