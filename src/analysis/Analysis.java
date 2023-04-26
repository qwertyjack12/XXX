package analysis;

import java.util.Objects;

/**
 * Абстрактный класс анализа со свойствами name и discription
 *
 * @author Nechvoloda
 * @version 1.0
 */

public abstract class Analysis {
    /**
     * Поле название
     */
    private String name;
    /**
     * Поле описание
     */
    private String description;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name  - название анализа
     * @param description - описание
     * @see Analysis#Analysis(String, String)
     */
    public Analysis(String name, String description) {
        this.name = name;
        this.description = description;
    }
    /**
     * Функция получения значения поля {@link Analysis#name}
     *
     * @return позвращает значение названия
     */
    public String getName(){
        return name;
    }
    /**
     * Процедура определения значения названия {@link Analysis#name}
     *
     * @param name - значение названия
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Функция получения значения поля {@link Analysis#description}
     *
     * @return позвращает значение описания
     */
    public String getDescription(){
        return description;
    }
    /**
     * Процедура определения значения описания {@link Analysis#description}
     *
     * @param description - значение описания
     */
    public void setDescription(String description){
        this.description = description;
    }
    /**
     * Абстрактная функция performAnalysis
     */
    public abstract void performAnalysis();
    /**
     * Функция toString
     */
    @Override
    public String toString() {
        return "Analysis name: " + name + ", Description: " + description;
    }
    /**
     * Функция equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Analysis)) return false;
        Analysis analysis = (Analysis) o;
        return Objects.equals(name, analysis.name) && Objects.equals(description, analysis.description);
    }
    /**
     * Функция hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}