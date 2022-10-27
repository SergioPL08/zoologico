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
public class Cuidados implements Serializable{
    private String tipoComida;
    private String habitat;
    private float costePromedio;
    private float cantidadComidaKG;
    private int periodicidadComidaDias;
    private final Animal animal;

    public Cuidados(String tipoComida, String habitat, float costePromedio, float cantidadComidaKG, int periodicidadComidaDias, Animal animal) {
        this.tipoComida = tipoComida;
        this.habitat = habitat;
        this.costePromedio = costePromedio;
        this.cantidadComidaKG = cantidadComidaKG;
        this.periodicidadComidaDias = periodicidadComidaDias;
        this.animal = animal;
    }
    
    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public float getCostePromedio() {
        return costePromedio;
    }

    public void setCostePromedio(float costePromedio) {
        this.costePromedio = costePromedio;
    }

    public float getCantidadComidaKG() {
        return cantidadComidaKG;
    }

    public void setCantidadComidaKG(float cantidadComidaKG) {
        this.cantidadComidaKG = cantidadComidaKG;
    }

    public int getPeriodicidadComidaDias() {
        return periodicidadComidaDias;
    }

    public void setPeriodicidadComidaDias(int periodicidadComidaDias) {
        this.periodicidadComidaDias = periodicidadComidaDias;
    }
    
}
