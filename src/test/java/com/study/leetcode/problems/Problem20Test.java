package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
