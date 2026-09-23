package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GradeCalculatorTest {

    @Test
    @DisplayName("95 оноо A дүн байх ёстой")
    void ninetyFiveIsA() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        String grade = calculator.letterGrade(95.0);

        // Assert
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("85 оноо B дүн байх ёстой")
    void eightyFiveIsB() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        String grade = calculator.letterGrade(85.0);

        // Assert
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("75 оноо C дүн байх ёстой")
    void seventyFiveIsC() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        String grade = calculator.letterGrade(75.0);

        // Assert
        assertEquals("C", grade);
    }

    @Test
    @DisplayName("65 оноо D дүн байх ёстой")
    void sixtyFiveIsD() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        String grade = calculator.letterGrade(65.0);

        // Assert
        assertEquals("D", grade);
    }

    @Test
    @DisplayName("30 оноо F дүн байх ёстой")
    void thirtyIsF() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        String grade = calculator.letterGrade(30.0);

        // Assert
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой (хязгаарын тохиолдол)")
    void ninetyIsExactlyA() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        String grade = calculator.letterGrade(90.0);

        // Assert
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("89.99 оноо B дүн байх ёстой (90-өөс бага хязгаар)")
    void eightyNinePointNinetyNineIsB() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        String grade = calculator.letterGrade(89.99);

        // Assert
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("60 оноо яг D дүн байх ёстой (хязгаарын тохиолдол)")
    void sixtyIsExactlyD() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        String grade = calculator.letterGrade(60.0);

        // Assert
        assertEquals("D", grade);
    }

    @Test
    @DisplayName("59.99 оноо F дүн байх ёстой (60-аас бага хязгаар)")
    void fiftyNinePointNinetyNineIsF() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        String grade = calculator.letterGrade(59.99);

        // Assert
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("0 оноо F дүн байх ёстой (доод хязгаар)")
    void zeroIsF() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        String grade = calculator.letterGrade(0.0);

        // Assert
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("100 оноо A дүн байх ёстой (дээд хязгаар)")
    void oneHundredIsA() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        String grade = calculator.letterGrade(100.0);

        // Assert
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("-1 оноо өгөхөд IllegalArgumentException үүсэх ёстой")
    void negativeScoreIsRejected() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(-1.0));
    }

    @Test
    @DisplayName("101 оноо өгөхөд IllegalArgumentException үүсэх ёстой")
    void scoreAboveOneHundredIsRejected() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(101.0));
    }

    @Test
    @DisplayName("Ирцийн оноо сөрөг үед totalScore алдаа өгөх ёстой")
    void negativeAttendanceIsRejected() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
                () -> calculator.totalScore(-5.0, 40.0, 10.0, 10.0, 30.0));
    }

    @Test
    @DisplayName("Лабораторийн оноо 40-өөс их үед totalScore алдаа өгөх ёстой")
    void labScoreAboveMaximumIsRejected() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
                () -> calculator.totalScore(10.0, 41.0, 10.0, 10.0, 30.0));
    }

    @Test
    @DisplayName("Зөв оноонуудын нийлбэр 100 гарах ёстой")
    void validScoresSumToOneHundred() {
        // Arrange
        GradeCalculator calculator = new GradeCalculator();

        // Act
        double total = calculator.totalScore(10.0, 40.0, 10.0, 10.0, 30.0);

        // Assert
        assertEquals(100.0, total);
    }
}
