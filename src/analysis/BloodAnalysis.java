package analysis;

import java.io.Serializable;

/**
 * Класс анализа крови со свойством bloodType
 *
 * @author Nechvoloda
 * @version 1.0
 */

public class BloodAnalysis extends Analysis implements Serializable {
    /**
     * Поле типа крови
     */
    private String bloodType;
    /**
     * Конструктор - создание нового объекта с определенным значением
     *
     * @param bloodType - значение тип крови
     * @param name - значение название анализа
     * @param description - значение описание анализа
     * @see BloodAnalysis#BloodAnalysis(int, String, String, String)
     */
    public BloodAnalysis(int id, String name, String description, String bloodType) {
        super(id, name, description);
        this.bloodType = bloodType;
    }
    /**
     * Процедура определения значения названия {@link BloodAnalysis#bloodType}
     *
     * @param bloodType - значение типа крови
     */
    public void setBloodType(String bloodType){
        this.bloodType = bloodType;
    }
    /**
     * Функция получения значения поля {@link BloodAnalysis#bloodType}
     *
     * @return позвращает значение типа крови
     */
    public String getBloodType() {
        return bloodType;
    }
    /**
     * Абстрактная функция performAnalysis
     */
    @Override
    public void performAnalysis() {
        System.out.println("Performing blood analysis...");
    }
    /**
     * Функция toString
     */
    @Override
    public String toString() {
        return super.toString() + ", Blood Type: " + bloodType;
    }
}