package svc.services.laboratoryService;

import analysis.Analysis;

public interface LaboratoryService {
    void saveData();
    void readData();
    boolean checkLaboratoryId(int id);

    void setLaboratory(int id, String name);
    void removeLaboratory(int id);
    void addLaboratoryAnalysis(int id, Analysis analysis);
    void getLaboratoryAnalysis();
    void getLaboratories();
}
