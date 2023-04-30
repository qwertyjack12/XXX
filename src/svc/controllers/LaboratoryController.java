package svc.controllers;

import svc.services.analysisService.AnalysisService;
import svc.services.laboratoryService.LaboratoryService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LaboratoryController {
    private final LaboratoryService laboratoryService;
    private final AnalysisService analysisService;
    private final Scanner scanner;
    private final ExecutorService service;
    public LaboratoryController(LaboratoryService laboratoryService, AnalysisService analysisService, Scanner scanner){
        this.laboratoryService = laboratoryService;
        this.analysisService = analysisService;
        this.scanner = scanner;
        service = Executors.newFixedThreadPool(2);
    }
    public int listenInt(){
        return scanner.nextInt();
    }
    public String listenStr(){
        return scanner.next();
    }
    public void saveChanges(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                laboratoryService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                laboratoryService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public void setLaboratory(){
        System.out.println("id of laboratory: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();
        laboratoryService.setLaboratory(id, name);
    }
    public void removeLaboratory(){
        laboratoryService.getLaboratories();
        System.out.println("id of laboratory: ");
        int id = listenInt();
        laboratoryService.removeLaboratory(id);
    }
    public void addLaboratoryAnalysis(){
        laboratoryService.getLaboratories();
        System.out.println("id of laboratory: ");
        int id = listenInt();
        if (!laboratoryService.checkLaboratoryId(id)){
            return;
        }

        analysisService.getAnalysis();
        System.out.println("id of analysis: ");
        int idAnalysis = listenInt();
        if (!analysisService.checkAnalysisId(idAnalysis)){
            return;
        }
        laboratoryService.addLaboratoryAnalysis(id, analysisService.getAnalyse(idAnalysis));

    }
    public void getLaboratoryAnalysis(){
        laboratoryService.getLaboratoryAnalysis();
    }
    public void getLaboratories(){
        laboratoryService.getLaboratories();
    }
}
