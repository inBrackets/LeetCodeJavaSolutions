package org.example.problems;

import io.qameta.allure.TmsLink;
import org.example.extensions.Tag;
import org.example.extensions.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.extensions.TestTags.MEDIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(MEDIUM)
})
@TmsLink("maximum-swap")
class MaximumSwapTest extends AbstractTest {

    MaximumSwap base = new MaximumSwap();

    @ParameterizedTest(name = "Case {index}: num={0}, output={1}")
    @MethodSource("generateTestData")
    void testMaximumSwap_0ms(int num, int output) {
        assertEquals(output, base.maximumSwap_0ms(num));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                2736,
                7236
            ),
            Arguments.of(
                9973,
                9973
            )
        );
    }
}