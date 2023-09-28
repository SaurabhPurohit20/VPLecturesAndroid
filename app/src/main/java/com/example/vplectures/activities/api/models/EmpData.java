package com.example.vplectures.activities.api.models;

public class EmpData {
    int id, employee_salary, employee_age;
    String employee_name, profile_image;

    public EmpData(int id, int employee_salary, int employee_age, String employee_name, String profile_image) {
        this.id = id;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.employee_name = employee_name;
        this.profile_image = profile_image;
    }

    @Override
    public String toString() {
        return "EmpData{" +
                "id=" + id +
                ", employee_salary=" + employee_salary +
                ", employee_age=" + employee_age +
                ", employee_name='" + employee_name + '\'' +
                ", profile_image='" + profile_image + '\'' +
                '}';
    }
}
