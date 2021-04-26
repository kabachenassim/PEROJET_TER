/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enssemble;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class Iteratif {
    
    
  public Iteratif (){}

public ArrayList union (ArrayList liste) {
    
    
    Hashtable ht = new Hashtable();
    int i=0;
   int l=liste.size();
    while (i<liste.size()-1) { 
         ArrayList SE1= (ArrayList) liste.get(i);
         String  id= (String) ( SE1.get(0)); 
         Set element= ((Set) SE1.get(1));
         ArrayList parent = ((ArrayList) SE1.get(2));
        int j=i+1;
        
        
        while (j<liste.size()) {    
             
             ArrayList SE2= (ArrayList) liste.get(j);
             String  id1= (String) ( SE2.get(0)); 
             Set element1= ((Set) SE2.get(1));
             ArrayList parent1 = ((ArrayList) SE2.get(2));
             
             ArrayList<Object>  union = new ArrayList<>();
              Set<Integer> l3 = new HashSet<Integer>(); 
                    
                     ArrayList<Object>  parent2 = new ArrayList<>();   
                      
                      union.add(id+id1);
                      l3.addAll(element);
                      l3.addAll(element1);
                      union.add(l3);
                      parent2.addAll(parent);
                      parent2.addAll(parent1);
                      union.add(parent2);
                      
                      if(similaire(ht,union))
                      {
                      
                      liste.add(union);
                      }
             
            
       j++; }
   i++; }


return liste;} 

public boolean similaire(Hashtable ht,ArrayList l){
    
   String  id= (String) ( l.get(0)); 
   Set element= ((Set) l.get(1));
  
   if(ht.containsKey(element)){
       // si la clé (sous enssemble) exsicte déjà on sauvegarde juste l'id de sous enssemble dans value pour dire que tt les sous enssemble qui sont dans le méme clé sont similaire
       String id1=";"+id;
   ht.put(element, ht.get(element)+id1);
   return false;
   }else{
   ht.put(element, id);
   return true;
   }  
}
    
    
}
