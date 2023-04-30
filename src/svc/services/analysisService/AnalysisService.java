package svc.services.analysisService;

import analysis.Analysis;

public interface AnalysisService {
    void saveData();
    void readData();
    boolean checkAnalysisId(int id);

    void setBloodAnalysis(int id, String name, String description, String bloodType);
    void setUrineAnalysis(int id, String name, String description, String urineColor);
    void removeAnalysis(int id);
    void getAnalysis();
    Analysis getAnalyse(int id);
}
