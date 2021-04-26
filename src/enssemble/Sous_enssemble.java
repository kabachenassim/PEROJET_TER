/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enssemble;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 *
 * @author ADMIN
 */
// une classe pour la creation d'une seule sous enssemble
public class Sous_enssemble {

  int nombre_elements;  
    
   public Sous_enssemble() {

}
  // creaction d'un seul seul sous ensemble [id,[éléments],parents]
  // notion de pére exemple sous ensemble SE0SE1 liste de ses parents c'est [SE0,SE1]
 public ArrayList elemments (int id,Set elem){ 
            Random r=new Random();
                ArrayList<Object>  elemment = new ArrayList<>();
                 
                        int j=0;
                        String id1= String.valueOf(id);
                        String id2="SE"+id1;
                        elemment.add(id2);
                        
                    //création une liste ordoné des éléments de sous enssemble 
                        Set<Integer> set = new HashSet<Integer>(); 
                        ArrayList<Object>  parent1 = new ArrayList<>();
                    //généré aléatoirement la taille de sous ensemble dans l'intervalle [a,b-a[
                        int taille =  1+r.nextInt(20-10);
                       while (j < taille){ 
                    //généré aléatoirement les éléments dans l'intervalle ]a,b-a[
			int val =  r.nextInt(20-10);
                           set.add(val);
                           elem.add(val);
				 j++;}
                       
                       elemment.add(set);
                       parent1.add(id);
                       elemment.add(parent1);
                      
			return elemment;}

}
