package patients;

import analysis.Analysis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Класс пациент со свойствами name, age, gender
 *
 * @author Nechvoloda
 * @version 1.0
 */

public class Patient implements PatientInterface, Serializable {
    private int id;
    /**
     * Поле имя
     */
    private String name;
    /**
     * Поле возраст
     */
    private int age;
    /**
     * Поле пол
     */
    private String gender;
    /**
     * Поле списка анализов
     */
    private ArrayList<Analysis> analyses;
    /**
     * Конструктор - создание нового объекта с определенным значением
     *
     * @param name - значение тип крови
     * @param age - значение возраста пациента
     * @param gender - значение пола пациента
     * @see Patient#Patient(int, String, int, String)
     */
    public Patient(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.analyses = new ArrayList<>();
    }
    /**
     * Процедура определения значения имени {@link Patient#name}
     *
     * @param name - значение имени
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Функция получения значения поля {@link Patient#name}
     *
     * @return позвращает значение имени
     */
    public String getName() {
        return name;
    }
    /**
     * Процедура определения значения возраста {@link Patient#age}
     *
     * @param age - значение возраста
     */
    public void setAne(int age){
        this.age = age;
    }
    /**
     * Функция получения значения поля {@link Patient#age}
     *
     * @return позвращает значение возраста
     */
    public int getAge() {
        return age;
    }
    /**
     * Процедура определения значения пола {@link Patient#gender}
     *
     * @param gender - значение пола
     */
    public void setGender(String gender){
        this.gender = gender;
    }
    /**
     * Функция получения значения пола {@link Patient#gender}
     *
     * @return позвращает значение пола
     */
    public String getGender() {
        return gender;
    }
    /**
     * Функция получения списка анализов {@link Patient#analyses}
     *
     * @return позвращает список анализов
     */
    public ArrayList<Analysis> getAnalyses(){
        return (ArrayList<Analysis>) analyses;
    }
    /**
     * Функция добавления анализа в список {@link Patient#analyses}
     */
    @Override
    public void addAnalysis(Analysis analysis) {
        analyses.add(analysis);
    }
    /**
     * Функция удаления анализа из списка {@link Patient#analyses}
     */
    @Override
    public void removeAnalysis(Analysis analysis) {
        analyses.remove(analysis);
    }
    /**
     * Функция toString
     */
    @Override
    public String toString() {
        return "Patient: " + name + ", Age: " + age + ", Gender: " + gender;
    }
    /**
     * Функция equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return age == patient.age &&
                Objects.equals(name, patient.name) &&
                Objects.equals(gender, patient.gender);
    }
    /**
     * Функция hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}