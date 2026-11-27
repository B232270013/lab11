
package mn.edu.must.sqat;

// ЛАБ 11-ийн ЭХЛЭЛИЙН тестийн багц.
// АНХААР: Энэ багц JaCoCo-гоор Line 100% (Branch 38/41) өгдөг —
// гэхдээ assertion-ууд нь ЗОРИУДААР СУЛ бичигдсэн.
// Таны даалгавар: PIT-ээр амьд үлдсэн мутантуудыг олж,
// тестүүдийг ХҮЧТЭЙ болгож mutation score-ийг өсгөх.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    ScholarshipCalculator calc;

    @BeforeEach
    void setUp() { calc = new ScholarshipCalculator(); }

    // B1 - letterGrade: яг үнэлгээг шалгах

    @Test
    void letterGrade_returnsCorrectGradeForAllRanges() {
        assertEquals("A", calc.letterGrade(95));
        assertEquals("B", calc.letterGrade(85));
        assertEquals("C", calc.letterGrade(75));
        assertEquals("D", calc.letterGrade(65));
        assertEquals("F", calc.letterGrade(30));
    }

    @Test
    void letterGrade_invalidInputs_throw() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.letterGrade(-1));

        assertThrows(IllegalArgumentException.class,
                () -> calc.letterGrade(101));
    }

    // B1 - GPA: яг тооцоолсон утгыг шалгах

    @Test
    void gpa_returnsCorrectAverage() {
        double g1 = calc.gpa(new double[]{95, 85});
        double g2 = calc.gpa(new double[]{75, 65});
        double g3 = calc.gpa(new double[]{40});

        assertEquals(3.5, g1, 0.000001);
        assertEquals(1.5, g2, 0.000001);
        assertEquals(0.0, g3, 0.000001);
    }

    @Test
    void gpa_invalidInputs_throw() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.gpa(null));

        assertThrows(IllegalArgumentException.class,
                () -> calc.gpa(new double[]{}));
    }

    // B1 - scholarship: яг хувийг шалгах

    @Test
    void scholarship_returnsCorrectPercent() {
        int s1 = calc.scholarship(3.9, 16, false);
        int s2 = calc.scholarship(3.5, 13, false);
        int s3 = calc.scholarship(3.1, 5, false);
        int s4 = calc.scholarship(2.0, 1, false);
        int s5 = calc.scholarship(4.0, 20, true);

        assertEquals(100, s1);
        assertEquals(70, s2);
        assertEquals(50, s3);
        assertEquals(0, s4);
        assertEquals(0, s5);
    }

    @Test
    void scholarship_invalidInputs_throw() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.scholarship(4.1, 10, false));

        assertThrows(IllegalArgumentException.class,
                () -> calc.scholarship(3.0, -1, false));
    }

    // =============================
    // B2 - Boundary Value Testing
    // =============================

    @Test
    void letterGrade_boundaryValues() {
        assertEquals("A", calc.letterGrade(100));
        assertEquals("A", calc.letterGrade(90));
        assertEquals("B", calc.letterGrade(89.99));
        assertEquals("B", calc.letterGrade(80));
        assertEquals("C", calc.letterGrade(79.99));
        assertEquals("C", calc.letterGrade(70));
        assertEquals("D", calc.letterGrade(69.99));
        assertEquals("D", calc.letterGrade(60));
        assertEquals("F", calc.letterGrade(59.99));
        assertEquals("F", calc.letterGrade(0));
    }

    @Test
    void letterGrade_outsideBoundary_throw() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.letterGrade(-0.01));

        assertThrows(IllegalArgumentException.class,
                () -> calc.letterGrade(100.01));
    }

    @Test
    void gpa_allGradeValues() {
        assertEquals(4.0, calc.gpa(new double[]{95}), 0.000001);
        assertEquals(3.0, calc.gpa(new double[]{85}), 0.000001);
        assertEquals(2.0, calc.gpa(new double[]{75}), 0.000001);
        assertEquals(1.0, calc.gpa(new double[]{65}), 0.000001);
        assertEquals(0.0, calc.gpa(new double[]{40}), 0.000001);

        assertEquals(2.0,
                calc.gpa(new double[]{95, 85, 75, 65, 40}),
                0.000001);
    }

    @Test
    void scholarship100_boundaryValues() {
        assertEquals(100, calc.scholarship(3.8, 15, false));
        assertEquals(70, calc.scholarship(3.79, 15, false));
        assertEquals(70, calc.scholarship(3.8, 14, false));
        assertEquals(100, calc.scholarship(3.81, 16, false));
    }

    @Test
    void scholarship70_boundaryValues() {
        assertEquals(70, calc.scholarship(3.4, 12, false));
        assertEquals(50, calc.scholarship(3.39, 12, false));
        assertEquals(50, calc.scholarship(3.4, 11, false));
        assertEquals(70, calc.scholarship(3.41, 13, false));
    }

    @Test
    void scholarship50_boundaryValues() {
        assertEquals(50, calc.scholarship(3.0, 10, false));
        assertEquals(0, calc.scholarship(2.99, 10, false));
        assertEquals(50, calc.scholarship(3.01, 10, false));
    }

    @Test
    void scholarship_validInputLimits() {
        assertEquals(0, calc.scholarship(0.0, 10, false));
        assertEquals(100, calc.scholarship(4.0, 15, false));
        assertEquals(50, calc.scholarship(3.8, 0, false));
        assertEquals(0, calc.scholarship(0.0, 0, false));
    }

    @Test
    void scholarship_invalidInputLimits_throw() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.scholarship(-0.01, 10, false));

        assertThrows(IllegalArgumentException.class,
                () -> calc.scholarship(4.01, 10, false));

        assertThrows(IllegalArgumentException.class,
                () -> calc.scholarship(3.8, -1, false));
    }

}
