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
    private int id;
    private String nombreEspecialidad;
    private String desc;

    public Especialidad(int id, String nombreEspecialidad, String desc) {
        this.id = id;
        this.nombreEspecialidad = nombreEspecialidad;
        this.desc = desc;
    }
    
    public Especialidad(String nombreEspecialidad, String desc) {
        this.id = id;
        this.nombreEspecialidad = nombreEspecialidad;
        this.desc = desc;
    }
    
    public Especialidad(int id, String nombreEspecialidad) {
        this.id = id;
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    
    
    @Override
    public String toString(){
        return nombreEspecialidad;
    }
    
    
}
