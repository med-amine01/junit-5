import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("When running MathUtils")
class MathUtilsTest {
    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void initBeforeAll() {
        System.out.println("this is before all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
    }


    @Nested
    @DisplayName("add method")
    @Tag("Math sum")
    class TestSum {
        @Test
        @DisplayName("when adding two positive numbers")
        void testSumPositive() {
            testReporter.publishEntry("running "+ testInfo.getDisplayName() + " with tag " + testInfo.getTags());
            assertEquals(2, mathUtils.add(1, 1), "should return the right sum");
        }

        @Test
        @DisplayName("when adding two negative numbers")
        void testSumNegative() {
            assertEquals(-2, mathUtils.add(-1, -1), () -> "should return the right sum");
        }
    }

    @Test
    @DisplayName("Test multiply method with assertAll")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(0, 2)),
                () -> assertEquals(8, mathUtils.multiply(4, 2))
        );
    }

    @Test
    @DisplayName("Testing sum method")
    void testSum() {
        boolean isServerUp = false;
        assumeTrue(isServerUp);
        assertEquals(2, mathUtils.add(1, 1), "Sum should be 2");
    }

    @Test
    @DisplayName("Testing divide method")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.div(1, 0), "Divide by zero should throw ArithmeticException");
    }

    @Test
    @DisplayName("Testing compute circle radius method")
//    @RepeatedTest(3)
    void testComputeCircleRadius() {
        assertEquals(314.1592653589793, mathUtils.computeCircleRadius(10),
                "computeCircleRadius methode should calculate the circle radius");
    }

    @Test
    @DisplayName("TDD method")
    @Disabled
    void testTDD() {
        fail("this should be fail and disable");
    }
}