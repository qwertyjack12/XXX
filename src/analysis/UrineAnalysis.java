package analysis;

import java.io.Serializable;

/**
 * Класс анализа мочи со свойством urineColor
 *
 * @author Nechvoloda
 * @version 1.0
 */

public class UrineAnalysis extends Analysis implements Serializable {
    /**
     * Поле цвета мочи
     */
    private String urineColor;
    /**
     * Конструктор - создание нового объекта с определенным значением
     *
     * @param urineColor - значение цвет мочи
     * @param name - значение название анализа
     * @param description - значение описание анализа
     * @see UrineAnalysis#UrineAnalysis(int, String, String, String)
     */
    public UrineAnalysis(int id, String name, String description, String urineColor) {
        super(id, name, description);
        this.urineColor = urineColor;
    }
    /**
     * Процедура определения значения названия {@link UrineAnalysis#urineColor}
     *
     * @param urineColor - значение цвета мочи
     */
    public void setUrineColor(String urineColor){
        this.urineColor = urineColor;
    }
    /**
     * Функция получения значения поля {@link UrineAnalysis#urineColor}
     *
     * @return позвращает значение цвета мочи
     */
    public String getUrineColor() {
        return urineColor;
    }
    /**
     * Абстрактная функция performAnalysis
     */
    @Override
    public void performAnalysis() {
        System.out.println("Performing urine analysis...");
    }
    /**
     * Функция toString
     */
    @Override
    public String toString() {
        return super.toString() + ", Urine Color: " + urineColor;
    }
}