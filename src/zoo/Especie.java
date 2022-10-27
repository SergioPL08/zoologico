/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

/**
 *
 * @author Sergio
 */
public class Especie {
    private int id;
    private String name;

    public Especie(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Especie(Especie esp) {
        this.name = esp.getName();
        this.id = esp.getId();
    }
    
    
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    
    @Override
    public String toString(){
        return name;
    }
    
    
}
