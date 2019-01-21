/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package StringCalculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTests {

    private StringCalculator calculator;

    @Before
    public void before() {
        calculator = new StringCalculator();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void AddReturnsZeroWhenPassedEmptyString() {
        int result = calculator.add("");
        assertEquals(result, 0);
    }

    @Test
    public void AddReturnsNumberWhenPassedSingleNumber() {
        int result = calculator.add("1");
        assertEquals(result, 1);
    }

    @Test
    public void AddReturnsSumWhenPassedMultipleNumbers() {
        int result = calculator.add("1,2,3");
        assertEquals(result, 6);
    }

    @Test
    public void AddReturnsSumWhenPassedMultipleNumbersWithNewLineDelimiter() {
        int result = calculator.add("1\n2\n3");
        assertEquals(result, 6);
    }

    @Test
    public void AddReturnsSumWhenPassedMultipleNumbersWithNewLineAndCommaDelimiter() {
        int result = calculator.add("1,2\n3");
        assertEquals(result, 6);
    }

    @Test
    public void AddReturnsSumWhenPassedMultipleNumbersWithDifferentDelimiter() {
        int result = calculator.add("//;\n1;2");
        assertEquals(result, 3);
    }

    @Test
    public void AddReturnsThrowsExceptionWhenPassedNegativeOperand() {
        thrown.expect(InvalidParameterException.class);
        thrown.expectMessage("negatives not allowed " + "-1");
        calculator.add("-1");
    }
}
