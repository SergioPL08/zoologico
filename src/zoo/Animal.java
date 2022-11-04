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
public class Animal implements Serializable{
    private int id;
    private String name, especie;
    private float peso;

    public Animal(int id,String name, String especie, float peso) {
        this.id=id;
        this.name = name;
        this.especie = especie;
        this.peso = peso;
    }
    
    public String toString(){
        return "Nombre: "+this.name+"\nEspecie:"+this.especie+"\nPeso:"+this.peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
   
}
