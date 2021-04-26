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
public class Algorithme_Recursive {
    
    public Algorithme_Recursive(){
    }
    
  public Set  parcours (ArrayList LE,Set elme)  {
      
       Integer[] tab = (Integer[]) elme.toArray(new Integer[elme.size()]);
       
         // Set  sol = new HashSet ();
         Set<Set> sol = new HashSet<Set>(); 
         int i=0;
         Set<Integer> A = new HashSet<Integer>();
         
         generation(LE, A, tab, i,sol);
       
  return sol;}
  
  
    
 public Set   generation (ArrayList LE, Set A, Integer[] tab, int i,Set sol){
     
     int n=tab.length;
     if(i==n){
         sol.add(A);
     
     }else { 
      ArrayList<Object> LE1 = (ArrayList<Object>) LE.clone();
      
    int t=0;

    while (t<LE.size()) { 
         ArrayList SE1= (ArrayList) LE.get(t);
         Set  element= ((Set) SE1.get(1));
        
        
    if (!element.contains(tab[i])){
    
      sol.add(element);
      A.add(tab[i]);
     generation(LE, A, tab, i+1, sol);
    }else{
        sol.add(element);
        filtier(LE1, i);
        generation(LE1, A, tab, i+1, sol);
    }    
        
   t++; }  
          
     }
    return sol;}
 
 // méthode de filtrage supprimier les sous-ensemble qui contient l'élément i
 public void filtier (ArrayList LE,int i){
     int j=0;
     while (j<LE.size()){
     ArrayList SE1= (ArrayList) LE.get(j);
     Set element= ((Set) SE1.get(1));
     if (element.contains(i)){ 
     LE.remove(j);
     } 
    j++; 
     }
 }
    
}
