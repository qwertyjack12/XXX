package svc.controllers;

import svc.services.analysisService.AnalysisService;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class AnalysisController {
    private final AnalysisService analysisService;
    private final Scanner scanner;
    private final ExecutorService service;
    public AnalysisController(AnalysisService analysisService, Scanner scanner){
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
                analysisService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                analysisService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public void setAnalysis(){
        System.out.println("id of analysis: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();
        System.out.print("Description: ");
        String description = listenStr();
        System.out.print("Type analysis (blood/urine): ");
        String type = listenStr();
        if (type.equals("blood")){
            System.out.print("Blood type: ");
            String bloodType = listenStr();
            analysisService.setBloodAnalysis(id, name, description, bloodType);
        } else if (type.equals("urine")) {
            System.out.print("Urine color: ");
            String urineColor = listenStr();
            analysisService.setUrineAnalysis(id, name, description, urineColor);
        }
        else {
            System.out.println("WRONG INPUT ANALYSIS TYPE");
            return;
        }
    }
    public void removeAnalysis(){
        analysisService.getAnalysis();
        System.out.println("id of analysis: ");
        int id = listenInt();
        analysisService.removeAnalysis(id);
    }
    public void getAnalysis(){
        analysisService.getAnalysis();
    }
}
