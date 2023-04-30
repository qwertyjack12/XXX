package svc.view;

import svc.controllers.*;

import java.util.Scanner;

public class ConsoleView implements View {
    private  final AnalysisController analysisController;
    private  final LaboratoryController laboratoryController;
    private  final PatientController patientController;
    private boolean flag;

    public ConsoleView(AnalysisController analysisController, LaboratoryController laboratoryController, PatientController patientController) {
        this.flag = true;
        this.analysisController = analysisController;
        this.laboratoryController = laboratoryController;
        this.patientController = patientController;
    }

    @Override
    public int listen() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void init() {
        while (this.flag) {
            showMenu();
        }
    }

    @Override
    public void saveChanges() {
        analysisController.saveChanges();
        laboratoryController.saveChanges();
        patientController.saveChanges();
    }

    @Override
    public void readData() {
        analysisController.readData();
        laboratoryController.readData();
        patientController.readData();
    }

    @Override
    public void closeThread() {
        analysisController.closeThread();
        laboratoryController.closeThread();
        patientController.closeThread();
    }

    @Override
    public void showMenu() {

        System.out.println("Menu:");
        System.out.println("-> 1: Analysis");
        System.out.println("-> 2: Laboratory");
        System.out.println("-> 3: Patient");
        System.out.println("-> 4: Save");
        System.out.println("-> 5: Read");
        System.out.println("-> 0: Close app");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                this.flag = false;
                this.closeThread();
                return;
            }
            case 1 -> showAnalysis();
            case 2 -> showLaboratories();
            case 3 -> showPatients();
            case 4 -> this.saveChanges();
            case 5 -> this.readData();
            default -> showMenu();
        }

    }

    @Override
    public void showAnalysis() {
        System.out.println("Analysis Menu:");
        System.out.println("-> 1: Add analysis");
        System.out.println("-> 2: Remove analysis");
        System.out.println("-> 3: Show analysis");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> analysisController.setAnalysis();
            case 2 -> analysisController.removeAnalysis();
            case 3 -> analysisController.getAnalysis();
            default -> showAnalysis();
        }
    }

    @Override
    public void showLaboratories() {
        System.out.println("Laboratories Menu:");
        System.out.println("-> 1: Add laboratory");
        System.out.println("-> 2: Remove laboratory");
        System.out.println("-> 3: Add analysis for laboratory");
        System.out.println("-> 4: Show analysis for any laboratories");
        System.out.println("-> 5: Show laboratories");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> laboratoryController.setLaboratory();
            case 2 -> laboratoryController.removeLaboratory();
            case 3 -> laboratoryController.addLaboratoryAnalysis();
            case 4 -> laboratoryController.getLaboratoryAnalysis();
            case 5 -> laboratoryController.getLaboratories();
            default -> showLaboratories();
        }
    }

    @Override
    public void showPatients() {
        System.out.println("Patients Menu:");
        System.out.println("-> 1: Add patient");
        System.out.println("-> 2: Remove patient");
        System.out.println("-> 3: Add analysis for patient");
        System.out.println("-> 4: Show analysis any patients");
        System.out.println("-> 5: Show patients");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> patientController.setPatient();
            case 2 -> patientController.removePatient();
            case 3 -> patientController.addAnalysis();
            case 4 -> patientController.getPatientsAnalysis();
            case 5 -> patientController.getPatients();
            default -> showPatients();
        }
    }
}
