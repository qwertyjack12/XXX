package svc.services.analysisService;

import analysis.Analysis;
import analysis.BloodAnalysis;
import analysis.UrineAnalysis;
import svc.Deserializator;
import svc.Serializator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class AnalysisServiceImpl implements AnalysisService{
    private Hashtable<Integer, Analysis> analysisHashtable;
    private final String fileName = "src\\usedFiles\\Analysis.txt";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }
    @Override
    public void saveData() {
        Serializator.serialization(analysisHashtable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.analysisHashtable = Deserializator.getHashtable(fileName);
        } catch (IOException|ClassNotFoundException e) {
            this.analysisHashtable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkAnalysisId(int id) {
        if (analysisHashtable.containsKey(id)){
            return true;
        }else {
            System.out.println("Wrong analysis id input!");
            return false;
        }
    }

    @Override
    public void setBloodAnalysis(int id, String name, String description, String bloodType) {
        analysisHashtable.put(id, new BloodAnalysis(id, name, description, bloodType));
    }

    @Override
    public void setUrineAnalysis(int id, String name, String description, String urineColor) {
        analysisHashtable.put(id, new UrineAnalysis(id, name, description, urineColor));
    }

    @Override
    public void removeAnalysis(int id) {
        analysisHashtable.remove(id);
    }

    @Override
    public void getAnalysis() {
        System.out.println(analysisHashtable);
    }

    @Override
    public Analysis getAnalyse(int id) {
        return analysisHashtable.get(id);
    }
}
