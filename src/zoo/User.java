/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoo;

import java.io.Serializable;

/**
 *
 * @author Sergio
 */
public class User implements Serializable{
    private String name;
    private String pass;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
    @Override
        public boolean equals(Object o){
            User u = (User) o;
            return u.name.equals(this.name)&u.pass.equals(this.pass);
        }
    public boolean comprobarUsuario(Object o){
        User p = (User) o;
        return p.name.equals(this.name)&p.pass.equals(this.pass);
    }
    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
