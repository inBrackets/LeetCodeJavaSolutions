package org.example.problems;

import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Disabled;
import org.example.extensions.Tag;
import org.example.extensions.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.extensions.TestTags.MEDIUM;
import static org.example.extensions.TestTags.PREMIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(PREMIUM),
    @Tag(MEDIUM)
})
@TmsLink("find-the-celebrity")
@Disabled("Whole task is broken. TDDO: find on gitghub a working version")
class FindTheCelebrityTest extends AbstractTest {

    FindTheCelebrity base = new FindTheCelebrity();

    @ParameterizedTest(name = "Case {index}: n={0}, output={1}")
    @MethodSource("generateTestData")
    void testFindCelebrity(int n, int output) {
        assertEquals(output, base.findCelebrity(n));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                0,
                -1
            ),
            Arguments.of(
                2,
                -1
            )

        );
    }
}