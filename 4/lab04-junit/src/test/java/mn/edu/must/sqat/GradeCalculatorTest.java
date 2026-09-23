package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GradeCalculatorTest {

    @ParameterizedTest(name = "score={0} -> {1}")
    @DisplayName("Онооны жишээнүүдийн үсгэн дүнг шалгах")
    @CsvSource({ "95, A", "85, B", "75, C", "65, D", "30, F" })
    void letterGradeExamples(double score, String expected) {
        assertEquals(expected, new GradeCalculator().letterGrade(score));
    }

    @Test
    @DisplayName("65 оноо D дүн байх ёстой")
    void sixtyFiveIsD() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals("D", calculator.letterGrade(65.0));
    }

    @Test
    @DisplayName("30 оноо F дүн байх ёстой")
    void thirtyIsF() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals("F", calculator.letterGrade(30.0));
    }

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой (хязгаарын тохиолдол)")
    void ninetyIsExactlyA() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals("A", calculator.letterGrade(90.0));
    }

    @Test
    @DisplayName("89.99 оноо B дүн байх ёстой (90-өөс бага хязгаар)")
    void eightyNinePointNinetyNineIsB() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals("B", calculator.letterGrade(89.99));
    }

    @Test
    @DisplayName("60 оноо яг D дүн байх ёстой (хязгаарын тохиолдол)")
    void sixtyIsExactlyD() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals("D", calculator.letterGrade(60.0));
    }

    @Test
    @DisplayName("59.99 оноо F дүн байх ёстой (60-аас бага хязгаар)")
    void fiftyNinePointNinetyNineIsF() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals("F", calculator.letterGrade(59.99));
    }

    @Test
    @DisplayName("0 оноо F дүн байх ёстой (доод хязгаар)")
    void zeroIsF() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals("F", calculator.letterGrade(0.0));
    }

    @Test
    @DisplayName("100 оноо A дүн байх ёстой (дээд хязгаар)")
    void oneHundredIsA() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals("A", calculator.letterGrade(100.0));
    }

    @Test
    @DisplayName("-1 оноо өгөхөд IllegalArgumentException үүсэх ёстой")
    void negativeScoreIsRejected() {
        GradeCalculator calculator = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(-1.0));
    }

    @Test
    @DisplayName("101 оноо өгөхөд IllegalArgumentException үүсэх ёстой")
    void scoreAboveOneHundredIsRejected() {
        GradeCalculator calculator = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(101.0));
    }

    @Test
    @DisplayName("Ирцийн оноо сөрөг үед totalScore алдаа өгөх ёстой")
    void negativeAttendanceIsRejected() {
        GradeCalculator calculator = new GradeCalculator();
        assertThrows(IllegalArgumentException.class,
                () -> calculator.totalScore(-5.0, 40.0, 10.0, 10.0, 30.0));
    }

    @Test
    @DisplayName("Лабораторийн оноо 40-өөс их үед totalScore алдаа өгөх ёстой")
    void labScoreAboveMaximumIsRejected() {
        GradeCalculator calculator = new GradeCalculator();
        assertThrows(IllegalArgumentException.class,
                () -> calculator.totalScore(10.0, 41.0, 10.0, 10.0, 30.0));
    }

    @ParameterizedTest(name = "{0}, {1}, {2}, {3}, {4} -> {5}")
    @DisplayName("Зөв оноонуудын нийлбэрийг тооцоолох")
    @CsvSource({
            "10, 40, 10, 10, 30, 100",
            "0, 0, 0, 0, 0, 0",
            "5, 20, 5, 5, 15, 50",
            "10, 30, 8, 9, 25, 82",
            "8, 35, 7, 10, 28, 88"
    })
    void totalScoreIsCalculated(double irts, double lab, double soril1,
            double soril2, double exam, double expected) {
        assertEquals(expected,
                new GradeCalculator().totalScore(irts, lab, soril1, soril2, exam));
    }
}
