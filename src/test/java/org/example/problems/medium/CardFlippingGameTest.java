package org.example.problems.medium;

import io.qameta.allure.TmsLink;
import org.example.problems.AbstractTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.extensions.TestTags.ARRAY;
import static org.example.extensions.TestTags.HASH_TABLE;
import static org.example.extensions.TestTags.MEDIUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
        @Tag(MEDIUM),
        @Tag(ARRAY),
        @Tag(HASH_TABLE)
})
@TmsLink("card-flipping-game")
class CardFlippingGameTest extends AbstractTest {

    CardFlippingGame base = new CardFlippingGame();

    @ParameterizedTest(name = "Case {index}: fronts={0}, backs={1}, output={2}")
    @MethodSource("generateTestData")
    void testFlippingGame_26ms(int[] fronts, int[] backs, int output) {
        assertEquals(output, base.flipgame_26ms(fronts, backs));
    }

    @ParameterizedTest(name = "Case {index}: fronts={0}, backs={1}, output={2}")
    @MethodSource("generateTestData")
    void testFlippingGame_6ms(int[] fronts, int[] backs, int output) {
        assertEquals(output, base.flipgame_6ms(fronts, backs));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 4, 4, 7},
                        new int[]{1, 3, 4, 1, 3},
                        2
                ),
                Arguments.of(
                        new int[]{1},
                        new int[]{1},
                        0
                )
        );
    }
}