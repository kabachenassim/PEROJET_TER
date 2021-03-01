/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enssemble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ADMIN
 */


// algorithme ignore les doublons et il prendre en consédration les sous enssembles similaires
public class Algorithme_2 {
    
    
    
  public Algorithme_2() {
        
    }
   
public  ArrayList parcours (ArrayList E,ArrayList liste){
 
 if (E.isEmpty()||E.size()==1){
 if(E.size()==1){
 liste.addAll(E);
 }
 
 return liste;}
 else{

  
     ArrayList noeud1= (ArrayList) E.get(0);
     ArrayList noeud= (ArrayList) noeud1.clone();
         E.remove(0);
       // verifcation si y des sous_enssemble similaire  
      sup_similaire(noeud,E);   
 return union(noeud,E,liste);
 
 }
 
 
}    
    
    
 public ArrayList union (ArrayList E1,ArrayList E,ArrayList liste){
     
     
     if(liste.isEmpty()){
         //mettre le premier noeud dans la liste (le cas d'union avec l'ensemble vide). 
           String  id= (String) ( E1.get(0)); 
           Set element= ((Set) E1.get(1));
           ArrayList parent = ((ArrayList) E1.get(2));
           ArrayList similaire = ((ArrayList) E1.get(3));
           
           
          
           
       //la création de 1ere noeud des union  
       
         ArrayList<Object>  noeud1 = new ArrayList<>();
           noeud1.add(id);  
           noeud1.add(element);
           noeud1.add(parent);
           noeud1.add(similaire);
           liste.add(noeud1);
           
        
           
           int i=0;
               while (i<E.size()){
                         
                      String id1 = ((String) ((ArrayList) E.get(i)).get(0));     
                      Set element1 = ((Set)((ArrayList) E.get(i)).get(1));
                      ArrayList parent2 = ((ArrayList)((ArrayList) E.get(i)).get(2));
                      
                
                     ArrayList<Object>  noeud2 = new ArrayList<>();
                     ArrayList<Object>  similaire2 = new ArrayList<>();
                   
                   Set<Integer> l3 = new HashSet<Integer>(); 
                 //liste des parents pour le marquage    
                     ArrayList<Object>  parent1 = new ArrayList<>();   
                      
                      noeud2.add(id+id1);
                      l3.addAll(element);
                      l3.addAll(element1);
                      noeud2.add(l3);
                      parent1.addAll(parent);
                      parent1.addAll(parent2);
                      similaire2.add("similaire");
                      noeud2.add(parent1);
                      noeud2.add(similaire2);
                      
                     // verifcation si y des sous_enssemble similaire  
                    sup_similaire(noeud2,liste); 
                      
                      liste.add(noeud2);
                           
                          
               i++;}  
         
         parcours(E, liste);
     }else{
             //mettre le premier noeud dans la liste (le cas d'union avec lensemble vide). 
           String  id= (String) ( E1.get(0)); 
           Set element= ((Set) E1.get(1));
           ArrayList parent = ((ArrayList) E1.get(2));
           
          
           
       //la création de 1ere noeud des union  
       
         ArrayList<Object>  noeud1 = new ArrayList<>();
         ArrayList<Object>  similaire3 = new ArrayList<>();
           noeud1.add(id);  
           noeud1.add(element);
           noeud1.add(parent);
           similaire3.add("similaire");
           noeud1.add(similaire3);
           liste.add(noeud1);
           

            
          
           //verifcation si y des sous_enssemble similaire
           sup_similaire(noeud1,liste);
           int i=0;
           //int j=liste.size();
               while (i<liste.size()){     
                      String id1 = ((String) ((ArrayList) liste.get(i)).get(0));     
                      Set element1 = ((Set)((ArrayList) liste.get(i)).get(1));
                      ArrayList parent2 = ((ArrayList)((ArrayList) liste.get(i)).get(2));
                     ArrayList<Object>  noeud2 = new ArrayList<>();
                     ArrayList<Object>  similaire4 = new ArrayList<>();
                    Set<Integer> l3 = new HashSet<Integer>(); 
                 //liste des parents pour le marquage    
                     ArrayList<Object>  parent1 = new ArrayList<>();   
                      
                      noeud2.add(id+id1);
                      l3.addAll(element);
                      l3.addAll(element1);
                      noeud2.add(l3);
                      parent1.addAll(parent);
                      parent1.addAll(parent2);
                      noeud2.add(parent1);
                      similaire4.add("similaire");
                      noeud2.add(similaire4);
                      
                   //marquage des parents
                   
                 if(true==  marquage(parent1, parent2)){
                  sup_similaire(noeud2,liste);
                      liste.add(noeud2); } 
               i++;}
          int i1=0;
      while (i1<E.size()){
                         
                     String id1 = ((String) ((ArrayList) E.get(i1)).get(0));     
                     Set element1 = ((Set)((ArrayList) E.get(i1)).get(1));
                     ArrayList parent2 = ((ArrayList)((ArrayList) E.get(i1)).get(2));
                
                     ArrayList<Object>  noeud2 = new ArrayList<>();
                     ArrayList<Object>  similaire5 = new ArrayList<>();
                    
                    Set<Integer> l3 = new HashSet<Integer>(); 
                 //liste des parents pour le marquage    
                     ArrayList<Object>  parent1 = new ArrayList<>();   
                      
                      noeud2.add(id+id1);
                      l3.addAll(element);
                      l3.addAll(element1);
                      noeud2.add(l3);
                      parent1.addAll(parent);
                      parent1.addAll(parent2);
                      noeud2.add(parent1);
                      similaire5.add("similaire");
                      noeud2.add(similaire5);
                      
                      liste.add(noeud2);
                           
                          
               i1++;} 
         
            parcours(E, liste);
        
         
     }
 return liste;}   
    
    
    
public boolean marquage(ArrayList parents,ArrayList liste){
     
 //methode test si un des parent n'est pas marqué qui veut dire n'est pas encore exploer     
   
    boolean test1=true;
    boolean test2=false;
 Collections.sort(parents);
 Collections.sort(liste);
    
   Set<Integer> set = new HashSet<Integer>(parents); 
   
    if(set.size()<parents.size()){
    
    test1=false;
    
    }else{
        
    int i=0;
          
       while(i<liste.size()&&test2==false){
          int  idparent= (int) ( parents.get(i));
            int  id1= (int) ( liste.get(i));
           
                if(id1!=idparent) {
                 test2=true;   
                }
                    
      
              i++;}
       
    
    }
 
  boolean test=test1&&test2;
   
 return test;
 }


// méthode pour supprimer les doublicat 
public ArrayList sup_similaire(ArrayList l,ArrayList liste){
    
   
   String  id= (String) ( l.get(0)); 
   Set element= ((Set) l.get(1));
   ArrayList sim= ((ArrayList) l.get(3));
   
   int j=0;
   while(j<liste.size()){
       ArrayList noeud2= (ArrayList) liste.get(j);
       ArrayList noeud= (ArrayList) noeud2.clone();
       Set element2= ((Set) noeud.get(1));
       ArrayList sim1= ((ArrayList) noeud.get(3));
       String  id1= (String) ( noeud.get(0));
       
   if (element2.equals(element) && element.size()==element2.size()&& !id1.equals(id) ){ 
       liste.remove(j);
       sim.add(id1);
   
   }
   
   j++;}
   



return liste;}
      
}



