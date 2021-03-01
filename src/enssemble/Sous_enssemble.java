/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enssemble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 *
 * @author ADMIN
 */
// une classe pour la creation d'une seule sous enssemble (données aléatoire nombre d'elemnts entre 0 et 10 sur un enssmble varié de 0 a 10
public class Sous_enssemble {

  int nombre_elements;  
    
   public Sous_enssemble() {

}
 public ArrayList elemments (int id){ 
            Random r=new Random();
                ArrayList<Object>  elemment = new ArrayList<>();
                 
                	
                        int j=0;
                        String id1= String.valueOf(id);
                        String id2="SE"+id1;
                        elemment.add(id2);
                        
                      
                        Set<Integer> set = new HashSet<Integer>(); 
                        ArrayList<Object>  parent1 = new ArrayList<>();
                        int taille =  1+r.nextInt(20-10);
                       while (j < taille){ 
			int val =  r.nextInt(20-10);
                           set.add(val);
				 j++;}
                       
                       
                       
                       elemment.add(set);
                       parent1.add(id);
                       elemment.add(parent1);
                      
			return elemment;}

}
