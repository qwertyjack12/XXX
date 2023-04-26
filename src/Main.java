import analysis.BloodAnalysis;
import analysis.UrineAnalysis;
import laboratory.Laboratory;
import patients.Patient;

public class Main {
    public static void main(String[] args) {
        BloodAnalysis bloodAnalysis = new BloodAnalysis("1", "Norm", "O");
        UrineAnalysis urineAnalysis = new UrineAnalysis("2", "Not Norm", "Green");
        Patient patient = new Patient("Khabib", 33, "Male");
        Laboratory laboratory = new Laboratory("45");
        System.out.println(bloodAnalysis);
        System.out.println(urineAnalysis);
        System.out.println(patient);
        System.out.println(laboratory);
        laboratory.addAnalysis(bloodAnalysis);
        laboratory.addAnalysis(urineAnalysis);
        System.out.println(laboratory);
        patient.addAnalysis(urineAnalysis);
        System.out.println(patient.getAnalyses());

    }
}