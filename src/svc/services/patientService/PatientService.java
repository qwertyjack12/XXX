package svc.services.patientService;

import analysis.Analysis;

public interface PatientService {
    void saveData();
    void readData();
    boolean checkPatientId(int id);

    void setPatient(int id, String name, int age, String gender);
    void removePatient(int id);
    void addAnalysis(int id, Analysis analysis);
    void getPatientsAnalysis();
    void getPatients();
}
