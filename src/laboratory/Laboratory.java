package laboratory;
import analysis.Analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс лаборатория со свойством name
 *
 * @author Nechvoloda
 * @version 1.0
 */

public class Laboratory<T extends Analysis> {
    /**
     * Поле название
     */
    private String name;
    /**
     * Поле списка анализов
     */
    private List<T> analyses;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name  - название анализа
     * @see Laboratory#Laboratory(String)
     */
    public Laboratory(String name) {
        this.name = name;
        this.analyses = new ArrayList<>();
    }
    /**
     * Процедура определения значения названия {@link Laboratory#name}
     *
     * @param name - значение названия
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Функция получения значения поля {@link Laboratory#name}
     *
     * @return позвращает значение названия
     */
    public String getName() {
        return name;
    }
    /**
     * Функция получения списка анализов {@link Laboratory#analyses}
     *
     * @return позвращает список анализов
     */
    public List<T> getAnalyses() {
        return analyses;
    }
    /**
     * Функция добавления анализа в список {@link Laboratory#analyses}
     */
    public void addAnalysis(T analysis) {
        analyses.add(analysis);
    }
    /**
     * Функция удаления анализа из списка {@link Laboratory#analyses}
     */
    public void removeAnalysis(T analysis) {
        analyses.remove(analysis);
    }
    /**
     * Функция toString
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Laboratory number: ").append(name).append("\n");
        for (T analysis : analyses) {
            sb.append(analysis.toString()).append("\n");
        }
        return sb.toString();
    }
    /**
     * Функция equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laboratory)) return false;
        Laboratory<?> that = (Laboratory<?>) o;
        return Objects.equals(name, that.name) && Objects.equals(analyses, that.analyses);
    }
    /**
     * Функция hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, analyses);
    }
}