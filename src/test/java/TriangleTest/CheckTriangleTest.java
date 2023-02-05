package TriangleTest;

import Triangle.CalculationClass;
import Triangle.MyExcemption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CheckTriangleTest {
    @DisplayName("First test")
    @Test
    void testPositive1() throws MyExcemption {
        CalculationClass triangleClass = new CalculationClass();
        Assertions.assertEquals(68, triangleClass.calculateGeroneFormula(12,12,14));
        Assertions.assertEquals(30, triangleClass.calculateGeroneFormula(12, 5,13));
        Assertions.assertThrows(MyExcemption.class, () -> triangleClass.calculateGeroneFormula(-12, 12, 14));
    }

    @ParameterizedTest
    @CsvSource({"5, 12, 3, -1", "1, 3, 100, -1", "3, 3, 9, -1"})
    public void testIsTriangle (int a, int b, int c, int result) throws MyExcemption {
        CalculationClass triangleClass = new CalculationClass();
        Assertions.assertNotEquals(result, triangleClass.calculateGeroneFormula(a,b,c));
    }

    @ParameterizedTest
    @CsvSource ({"10, 12, 0", "-10, 12, -14", "12, -12, 14"})
    public void testNegative1 (int a, int b, int c) throws MyExcemption {
        CalculationClass triangleClass = new CalculationClass();
        Assertions.assertThrows(MyExcemption.class, () -> triangleClass.calculateGeroneFormula(a, b, c));
    }


    @AfterAll
    static void close() {
        System.out.println("Tests are finished");
    }

}
