/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

import java.io.Serializable;

/**
 *
 * @author sergio
 */
public class Especialidad implements Serializable{
    private String nombreEspecialidad;
    private float salarioMedio;
    private float extraPeligrosidad;
    private Animal animal;
    
    public Especialidad(String nombreEspecialidad, float salarioMedio, float extraPeligrosidad, Animal animal) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.salarioMedio = salarioMedio;
        this.extraPeligrosidad = extraPeligrosidad;
        this.animal= animal;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public float getSalarioMedio() {
        return salarioMedio;
    }

    public void setSalarioMedio(float salarioMedio) {
        this.salarioMedio = salarioMedio;
    }

    public float getExtraPeligrosidad() {
        return extraPeligrosidad;
    }

    public void setExtraPeligrosidad(float extraPeligrosidad) {
        this.extraPeligrosidad = extraPeligrosidad;
    }
    
    
}
