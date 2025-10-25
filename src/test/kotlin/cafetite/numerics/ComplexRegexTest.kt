package cafetite.numerics

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ComplexRegexTest {    //            "([+\\-]?\\d+(.\\d)?+i)", // imaginary only
    //            "([+\\-]?\\d+(.\\d+)?[+\\-](\\d+(.\\d+)?)?i)" // real only or real +/- imaginary
    private val complexRegex = Regex("([+\\-]?\\d+(.\\d)?+i)|([+\\-]?\\d+(.\\d+)?[+\\-](\\d+(.\\d+)?)?i)")

    @Test
    fun testComplexNumberRecognitionNoMatch() {
        Assertions.assertFalse(complexRegex.matches("i"))
        Assertions.assertFalse(complexRegex.matches("+i"))
        Assertions.assertFalse(complexRegex.matches("-i"))
        Assertions.assertFalse(complexRegex.matches("1.i"))
        Assertions.assertFalse(complexRegex.matches(".1i"))
        Assertions.assertFalse(complexRegex.matches("+1.i"))
        Assertions.assertFalse(complexRegex.matches("+.1i"))
    }

    @Test
    fun testComplexNumberRecognitionMatchImagOnly() {
        Assertions.assertTrue(complexRegex.matches("1i"))
        Assertions.assertTrue(complexRegex.matches("+1i"))
        Assertions.assertTrue(complexRegex.matches("-1i"))
        Assertions.assertTrue(complexRegex.matches("1.2i"))
        Assertions.assertTrue(complexRegex.matches("+1.2i"))
        Assertions.assertTrue(complexRegex.matches("-1.2i"))
    }

    @Test
    fun testComplexNumberRecognitionMatchRealOnly() {
        Assertions.assertTrue(complexRegex.matches("1+i"))
        Assertions.assertTrue(complexRegex.matches("+1+i"))
        Assertions.assertTrue(complexRegex.matches("1.5+i"))
        Assertions.assertTrue(complexRegex.matches("+1.5+i"))
    }

    @Test
    fun testComplexNumberRecognitionMatchAll() {
        Assertions.assertTrue(complexRegex.matches("1+2i"))
        Assertions.assertTrue(complexRegex.matches("1-2i"))
        Assertions.assertTrue(complexRegex.matches("1+2.3i"))
        Assertions.assertTrue(complexRegex.matches("1-2.3i"))
        Assertions.assertTrue(complexRegex.matches("+1+2i"))
        Assertions.assertTrue(complexRegex.matches("+1-2i"))
        Assertions.assertTrue(complexRegex.matches("+1+2.3i"))
        Assertions.assertTrue(complexRegex.matches("+1-2.3i"))
        Assertions.assertTrue(complexRegex.matches("1.5+2i"))
        Assertions.assertTrue(complexRegex.matches("1.5-2i"))
        Assertions.assertTrue(complexRegex.matches("1.5+2.3i"))
        Assertions.assertTrue(complexRegex.matches("1.5-2.3i"))
        Assertions.assertTrue(complexRegex.matches("+1.5+2i"))
        Assertions.assertTrue(complexRegex.matches("+1.5-2i"))
        Assertions.assertTrue(complexRegex.matches("+1.5+2.3i"))
        Assertions.assertTrue(complexRegex.matches("+1.5-2.3i"))
    }
}