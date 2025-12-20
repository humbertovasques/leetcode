package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem20Test {

    @ParameterizedTest
    @CsvSource({
        // Casos básicos (já existentes)
        "'()', true",
        "'()[]{}', true",
        "'(]', false",
        "'([])', true",
        "'([)]', false",

        // Um único par de cada tipo
        "'[]', true",
        "'{}', true",

        // Começa com fechamento
        "')', false",
        "']', false",
        "'}', false",

        // Apenas aberturas / apenas fechamentos
        "'((((', false",
        "'))))', false",
        "'{{{{', false",
        "'}}}}', false",
        "'[[[[', false",
        "']]]]', false",

        // Falta fechamento
        "'(', false",
        "'([]', false",
        "'({}', false",
        "'()[{}', false",

        // Falta abertura
        "')(', false",
        "']()', false",
        "'}{}', false",
        "'(])', false",

        // Aninhamentos corretos mais profundos
        "'{[()]}', true",
        "'[({})]', true",
        "'(([]){})', true",
        "'()[{}]', true",
        "'({}[])', true",
        "'()()()()', true",

        // Erros sutis em estruturas aninhadas
        "'{[(])}', false",
        "'[({})](]', false",
        "'(([]){})]', false",
        "'({}[])(', false"
    })
    void solve(String input, boolean expected) {
        assertEquals(expected, Problem20.solve(input));
    }

    @ParameterizedTest
    @MethodSource("validParenthesesCases")
    void isValid(String input, boolean expected) {
        // give
        Problem20 p20 = new Problem20();

        // when
        boolean result = p20.isValid(input);
//        boolean result = Problem20.solve(input);

        // then
        assertEquals(expected, result);
    }

    static Stream<Arguments> validParenthesesCases() {
        return Stream.of(
            // Casos básicos
            Arguments.of("()", true),
            Arguments.of("()[]{}", true),
            Arguments.of("(]", false),
            Arguments.of("([])", true),
            Arguments.of("([)]", false),

            // Um único par de cada tipo
            Arguments.of("[]", true),
            Arguments.of("{}", true),

            // Começa com fechamento
            Arguments.of(")", false),
            Arguments.of("]", false),
            Arguments.of("}", false),

            // Apenas aberturas / apenas fechamentos
            Arguments.of("((((", false),
            Arguments.of("))))", false),
            Arguments.of("{{{{", false),
            Arguments.of("}}}}", false),
            Arguments.of("[[[[", false),
            Arguments.of("]]]]", false),

            // Falta fechamento
            Arguments.of("(", false),
            Arguments.of("([]", false),
            Arguments.of("({}", false),
            Arguments.of("()[{}", false),

            // Falta abertura
            Arguments.of(")(", false),
            Arguments.of("]()", false),
            Arguments.of("}{}", false),
            Arguments.of("(])", false),

            // Aninhamentos corretos mais profundos
            Arguments.of("{[()]}", true),
            Arguments.of("[({})]", true),
            Arguments.of("(([]){})", true),
            Arguments.of("()[{}]", true),
            Arguments.of("({}[])", true),
            Arguments.of("()()()()", true),

            // Erros sutis em estruturas aninhadas
            Arguments.of("{[(])}", false),
            Arguments.of("[({})](]", false),
            Arguments.of("(([]){})]", false),
            Arguments.of("({}[])(", false)
        );
    }
}
