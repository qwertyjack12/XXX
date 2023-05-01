package svc.controllers;

import svc.services.analysisService.AnalysisService;
import svc.services.patientService.PatientService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PatientController {
    private final PatientService patientService;
    private final AnalysisService analysisService;
    private final Scanner scanner;
    private final ExecutorService service;
    public PatientController(PatientService patientService, AnalysisService analysisService, Scanner scanner){
        this.patientService = patientService;
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
                patientService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                patientService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public void setPatient(){
        System.out.println("id of analysis: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();
        System.out.print("Age: ");
        int age = listenInt();
        System.out.print("Gender (male/female): ");
        String gender = listenStr();
        patientService.setPatient(id, name, age, gender);
    }
    public void removePatient(){
        patientService.getPatients();
        System.out.println("id of patients: ");
        int id = listenInt();
        patientService.removePatient(id);
    }
    public void addAnalysis(){
        patientService.getPatients();
        System.out.println("id of patients: ");
        int id = listenInt();
        if (!patientService.checkPatientId(id)){
            return;
        }

        analysisService.getAnalysis();
        System.out.println("id of analysis: ");
        int idAnalysis = listenInt();
        if (!analysisService.checkAnalysisId(idAnalysis)){
            return;
        }
        patientService.addAnalysis(id, analysisService.getAnalyse(idAnalysis));
    }
    public void getPatientsAnalysis(){
        patientService.getPatientsAnalysis();
    }
    public void getPatients(){
        patientService.getPatients();
    }
}
