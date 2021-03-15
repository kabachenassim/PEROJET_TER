/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enssemble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class Algorithme_2 {
     public Algorithme_2() {
        
    }
   
    //méthode pour parcourir la liste des sous enssemble 
public  ArrayList parcours (ArrayList E,ArrayList liste,Hashtable ht){
 
 if (E.isEmpty()||E.size()==1){
 if(E.size()==1){
     ArrayList noeud1= (ArrayList) E.get(0);
    if(similaire(ht,noeud1)){
 liste.addAll(E);}
 }
 
 return liste;}
 else{
     
     ArrayList noeud1= (ArrayList) E.get(0);
     ArrayList noeud= (ArrayList) noeud1.clone();
         E.remove(0);
            
 return union(noeud,E,liste,ht);
 
 }
 
 
}    
    
  // méthode qui génere tous les unions 
 public ArrayList union (ArrayList E1,ArrayList E,ArrayList liste,Hashtable ht){
     
     
     if(liste.isEmpty()){
         //mettre le premier noeud dans la liste (le cas d'union avec l'ensemble vide). 
           String  id= (String) ( E1.get(0)); 
           Set element= ((Set) E1.get(1));
           ArrayList parent = ((ArrayList) E1.get(2));
           
           
       //la création de 1ere noeud des union  
       
         ArrayList<Object>  noeud1 = new ArrayList<>();
           noeud1.add(id);  
           noeud1.add(element);
           noeud1.add(parent);
          
           liste.add(noeud1);
           
        
           similaire(ht,noeud1);
           int i=0;
               while (i<E.size()){
                         
                      String id1 = ((String) ((ArrayList) E.get(i)).get(0));     
                      Set element1 = ((Set)((ArrayList) E.get(i)).get(1));
                      ArrayList parent2 = ((ArrayList)((ArrayList) E.get(i)).get(2));
                      
                
                     ArrayList<Object>  noeud2 = new ArrayList<>();
                   
                   
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
                     
                      
                     // verifcation si y des sous_enssemble similaire  
                     
                     if(similaire(ht,noeud2)){
                      
                      liste.add(noeud2);}
                           
                          
               i++;}  
         
         parcours(E, liste,ht);
     }else{
             //mettre le premier noeud dans la liste (le cas d'union avec lensemble vide). 
           String  id= (String) ( E1.get(0)); 
           Set element= ((Set) E1.get(1));
           ArrayList parent = ((ArrayList) E1.get(2));
           
          
           
       //la création de 1ere noeud des union  
       
         ArrayList<Object>  noeud1 = new ArrayList<>();
        
           noeud1.add(id);  
           noeud1.add(element);
           noeud1.add(parent);
            //verifcation si y des sous_enssemble similaire
          similaire(ht,noeud1);
           
           liste.add(noeud1);
                      
           int i=0;
           //int j=liste.size();
               while (i<liste.size()){     
                      String id1 = ((String) ((ArrayList) liste.get(i)).get(0));     
                      Set element1 = ((Set)((ArrayList) liste.get(i)).get(1));
                      ArrayList parent2 = ((ArrayList)((ArrayList) liste.get(i)).get(2));
                     ArrayList<Object>  noeud2 = new ArrayList<>();
                    
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
                     
                      
                   //marquage des parents
                   
                 if(true==  marquage(parent1, parent2)){
                   if(similaire(ht,noeud2)){
                      
                      liste.add(noeud2);}
                       } 
               i++;}
          int i1=0;
      while (i1<E.size()){
                         
                     String id1 = ((String) ((ArrayList) E.get(i1)).get(0));     
                     Set element1 = ((Set)((ArrayList) E.get(i1)).get(1));
                     ArrayList parent2 = ((ArrayList)((ArrayList) E.get(i1)).get(2));
                
                     ArrayList<Object>  noeud2 = new ArrayList<>();
                    
                    
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
                    
                      
                      if(similaire(ht,noeud2)){
                      
                      liste.add(noeud2);}
                           
                          
               i1++;} 
       
            parcours(E, liste,ht);
        
         
     }
 return liste;}   
    
    
  //methode test si un des parent n'est pas marqué qui veut dire n'est pas encore exploer 
  //pour eviter les duplicate dans ce sens SE0SE1 == SE1SE0 , SE0SE2SE1 == SE2SE0SE1 ....... 
public boolean marquage(ArrayList parents,ArrayList liste){
     
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

// verification l'exictance de sous_enssemble dans la table de hachage (clé,valeur) --->(liste des éléments, sous_ensembles correspondent)
////pour eviter les duplicate dans ce sens SE0=[1,2,3] SE1=[1,2] alors SE0SE1=[1,2,3]==SE0 alors dans la liste des unions on prendre que SE0 
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
