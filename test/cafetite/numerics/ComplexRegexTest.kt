package cafetite.numerics

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ComplexRegexTest {

    @Test
    fun testComplexNumberRecognitionNoMatch() {
        Assertions.assertFalse(Complex.regex.matches("i"))
        Assertions.assertFalse(Complex.regex.matches("+i"))
        Assertions.assertFalse(Complex.regex.matches("-i"))
        Assertions.assertFalse(Complex.regex.matches("1.i"))
        Assertions.assertFalse(Complex.regex.matches(".1i"))
        Assertions.assertFalse(Complex.regex.matches("+1.i"))
        Assertions.assertFalse(Complex.regex.matches("+.1i"))
    }

    @Test
    fun testComplexNumberRecognitionMatchImagOnly() {
        Assertions.assertTrue(Complex.regex.matches("1i"))
        Assertions.assertTrue(Complex.regex.matches("+1i"))
        Assertions.assertTrue(Complex.regex.matches("-1i"))
        Assertions.assertTrue(Complex.regex.matches("1.2i"))
        Assertions.assertTrue(Complex.regex.matches("+1.2i"))
        Assertions.assertTrue(Complex.regex.matches("-1.2i"))
    }

    @Test
    fun testComplexNumberRecognitionMatchRealOnly() {
        Assertions.assertTrue(Complex.regex.matches("1+0i"))
        Assertions.assertTrue(Complex.regex.matches("+1+0i"))
        Assertions.assertTrue(Complex.regex.matches("1.5+0i"))
        Assertions.assertTrue(Complex.regex.matches("+1.5+0i"))
    }

    @Test
    fun testComplexNumberRecognitionMatchAll() {
        Assertions.assertTrue(Complex.regex.matches("1+2i"))
        Assertions.assertTrue(Complex.regex.matches("1-2i"))
        Assertions.assertTrue(Complex.regex.matches("1+2.3i"))
        Assertions.assertTrue(Complex.regex.matches("1-2.3i"))
        Assertions.assertTrue(Complex.regex.matches("+1+2i"))
        Assertions.assertTrue(Complex.regex.matches("+1-2i"))
        Assertions.assertTrue(Complex.regex.matches("+1+2.3i"))
        Assertions.assertTrue(Complex.regex.matches("+1-2.3i"))
        Assertions.assertTrue(Complex.regex.matches("1.5+2i"))
        Assertions.assertTrue(Complex.regex.matches("1.5-2i"))
        Assertions.assertTrue(Complex.regex.matches("1.5+2.3i"))
        Assertions.assertTrue(Complex.regex.matches("1.5-2.3i"))
        Assertions.assertTrue(Complex.regex.matches("+1.5+2i"))
        Assertions.assertTrue(Complex.regex.matches("+1.5-2i"))
        Assertions.assertTrue(Complex.regex.matches("+1.5+2.3i"))
        Assertions.assertTrue(Complex.regex.matches("+1.5-2.3i"))
    }
}