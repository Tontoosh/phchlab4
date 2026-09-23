package mn.edu.must.sqat;

public class GradeCalculator {

    public String letterGrade(double score) {
        if (Double.isNaN(score) || score < 0 || score > 100) {
            throw new IllegalArgumentException("0-100 hoorond bh estoi");
        }

        if (score > 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        }
        return "F";
    }

    public double totalScore(double irts, double lab, double soril1, double soril2, double exam) {
        validateRange(irts, 10);
        validateRange(lab, 40);
        validateRange(soril1, 10);
        validateRange(soril2, 10);
        validateRange(exam, 30);

        return irts + lab + soril1 + soril2 + exam;
    }

    private void validateRange(double score, double maximum) {
        if (Double.isNaN(score) || score < 0 || score > maximum) {
            throw new IllegalArgumentException("0-100 gaas uur utga");
        }
    }
}
