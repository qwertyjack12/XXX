package svc.services.laboratoryService;

import analysis.Analysis;
import laboratory.Laboratory;
import svc.Deserializator;
import svc.Serializator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class LaboratoryServiceImpl implements LaboratoryService {
    private Hashtable<Integer, Laboratory> laboratoryHashtable;
    private final String fileName = "src\\usedFiles\\Laboratory.txt";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }
    @Override
    public void saveData() {
        Serializator.serialization(laboratoryHashtable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.laboratoryHashtable = Deserializator.getHashtable(fileName);
        } catch (IOException|ClassNotFoundException e) {
            this.laboratoryHashtable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkLaboratoryId(int id) {
        if (laboratoryHashtable.containsKey(id)) {
            return true;
        } else {
            System.out.println("Wrong laboratory id input!");
            return false;
        }
    }

    @Override
    public void setLaboratory(int id, String name) {
        laboratoryHashtable.put(id, new Laboratory(id, name));
    }

    @Override
    public void removeLaboratory(int id) {
        if ((laboratoryHashtable.size() != 0) & (laboratoryHashtable.containsKey(id))) {
            laboratoryHashtable.remove(id);
        }
    }

    @Override
    public void addLaboratoryAnalysis(int id, Analysis analysis) {
        laboratoryHashtable.get(id).addAnalysis(analysis);
    }


    @Override
    public void getLaboratoryAnalysis() {
        for (var x: laboratoryHashtable.keySet()){
            System.out.println(laboratoryHashtable.get(x).getName());
            System.out.println(laboratoryHashtable.get(x).getAnalyses());
        }
    }

    @Override
    public void getLaboratories() {
        System.out.println(laboratoryHashtable);
    }
}
