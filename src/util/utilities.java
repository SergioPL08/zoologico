/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import util.Lista;
import zoo.Animal;
        
/**
 *
 * @author Sergio
 */
public class utilities {
    @Deprecated
    public static void guardar (ArrayList lista, String ruta) throws IOException{
        FileOutputStream fos = new FileOutputStream(ruta);
        ObjectOutputStream write = new ObjectOutputStream(fos);
        write.writeObject(lista);
        write.close();
    }
    public static String[] rellenator(ArrayList lista, String ruta) throws IOException, ClassNotFoundException {
        lista = utilities.cargar(lista, ruta);
                Iterator iter = lista.iterator();
                String [] listados = new String[lista.size()];
                int i = 0;
                while(iter.hasNext()){
                    Animal a = (Animal)iter.next();
                    listados[i]=a.getName();
                    //System.out.println(listaAnimales[i]);
                    i++;
                }
        return listados;
    }
    @Deprecated
    public static ArrayList cargar (ArrayList lista,String ruta) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        lista = (ArrayList) ois.readObject();
        ois.close();
        return lista;
    }
    
   
    
}
