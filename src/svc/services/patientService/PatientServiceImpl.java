package svc.services.patientService;

import analysis.Analysis;
import patients.Patient;
import svc.Deserializator;
import svc.Serializator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class PatientServiceImpl implements PatientService{
    private Hashtable<Integer, Patient> patientHashtable;
    private final String fileName = "src\\usedFiles\\Patient.txt";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }
    @Override
    public void saveData() {
        Serializator.serialization(patientHashtable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.patientHashtable = Deserializator.getHashtable(fileName);
        } catch (IOException|ClassNotFoundException e) {
            this.patientHashtable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkPatientId(int id) {
        if (patientHashtable.containsKey(id)) {
            return true;
        } else {
            System.out.println("Wrong patient id input!");
            return false;
        }
    }

    @Override
    public void setPatient(int id, String name, int age, String gender) {
        patientHashtable.put(id, new Patient(id, name, age, gender));
    }

    @Override
    public void removePatient(int id) {
        if ((patientHashtable.size() != 0) & (patientHashtable.containsKey(id))) {
            patientHashtable.remove(id);
        }
    }

    @Override
    public void addAnalysis(int id, Analysis analysis) {
        patientHashtable.get(id).addAnalysis(analysis);
    }

    @Override
    public void getPatientsAnalysis() {
        for (var x: patientHashtable.keySet()){
            System.out.println(patientHashtable.get(x).getName());
            System.out.println(patientHashtable.get(x).getAnalyses());
        }
    }

    @Override
    public void getPatients() {
        System.out.println(patientHashtable);
    }
}
