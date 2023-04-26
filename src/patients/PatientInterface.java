package patients;
import analysis.Analysis;

import java.util.List;

/**
 * Интерфейс для работы с классом Patient
 *
 * @author Nechvoloda
 * @version 1.0
 */

public interface PatientInterface {
    /**
     * Функция добавляющая пациенту анализ
     */
    void addAnalysis(Analysis analysis);
    /**
     * Функция получения всех анализов
     */
    List<Analysis> getAnalyses();
    /**
     * Функция удаляющая пациенту анализ
     */
    void removeAnalysis(Analysis analysis);
}
