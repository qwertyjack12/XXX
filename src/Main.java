import svc.controllers.AnalysisController;
import svc.controllers.LaboratoryController;
import svc.controllers.PatientController;
import svc.services.analysisService.AnalysisServiceImpl;
import svc.services.laboratoryService.LaboratoryServiceImpl;
import svc.services.patientService.PatientServiceImpl;
import svc.view.ConsoleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnalysisServiceImpl analysisService = new AnalysisServiceImpl();
        LaboratoryServiceImpl laboratoryService = new LaboratoryServiceImpl();
        PatientServiceImpl patientService = new PatientServiceImpl();

        Scanner scanner = new Scanner(System.in);

        AnalysisController analysisController = new AnalysisController(analysisService, scanner);
        LaboratoryController laboratoryController = new LaboratoryController(laboratoryService, analysisService, scanner);
        PatientController patientController = new PatientController(patientService, analysisService, scanner);

        ConsoleView consoleView = new ConsoleView(analysisController, laboratoryController, patientController);

        consoleView.init();

    }
}