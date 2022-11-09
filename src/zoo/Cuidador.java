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
public class Cuidador implements Serializable{
    private String nombre, apellidos, tel;
    private float salario;
    private int id;
    
    public Cuidador(String nombre, String apellidos, String tel, float salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tel = tel;
        this.salario = salario;
    }

    public Cuidador(int id,String nombre) {
        this.id=id;
        this.nombre = nombre;
    }
    
    public Cuidador(Cuidador cui) {
        this.id=cui.id;
        this.nombre = cui.nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
    
    
    
}
