/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enssemble;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 *
 * @author ADMIN
 */
public class Enssemble {

   int nombre_se;
   

    public Enssemble(int ns) {
        ns=nombre_se;
    }
   
    public ArrayList listes (int nb){ 
              ArrayList<Object>  l = new ArrayList<>();
                        int j=0;
                        while (j < nb){ 
                            Sous_enssemble se=new Sous_enssemble();
                            l.add(se.elemments(nb,j));
			
				 j++;}
					return l;}
    
    
    
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
         
 return union(noeud,E,liste);
 
 }
 
 
}   
    
    
 public ArrayList union (ArrayList E1,ArrayList E,ArrayList liste){
     
     
     if(liste.isEmpty()){
         //mettre le premier noeud dans la liste (le cas d'union avec l'ensemble vide). 
           String  id= (String) ( E1.get(0)); 
           ArrayList element= ((ArrayList) E1.get(1));
           ArrayList parent = ((ArrayList) E1.get(2));
           
          
           
       //la création de 1ere noeud des union  
       
         ArrayList<Object>  noeud1 = new ArrayList<>();
           noeud1.add(id);  
           noeud1.add(element);
           noeud1.add(parent);
           liste.add(noeud1);
           
           int i=0;
               while (i<E.size()){
                         
                      String id1 = ((String) ((ArrayList) E.get(i)).get(0));     
                      ArrayList element1 = ((ArrayList)((ArrayList) E.get(i)).get(1));
                      ArrayList parent2 = ((ArrayList)((ArrayList) E.get(i)).get(2));
                      
                
                     ArrayList<Object>  noeud2 = new ArrayList<>();
                    ArrayList<Object>  l3 = new ArrayList<>();
                 //liste des parents pour le marquage    
                     ArrayList<Object>  parent1 = new ArrayList<>();   
                      
                      noeud2.add(id+id1);
                      l3.addAll(element);
                      l3.addAll(element1);
                      noeud2.add(l3);
                      parent1.addAll(parent);
                      parent1.addAll(parent2);
                      
                      noeud2.add(parent1);
                      
                      
                      liste.add(noeud2);
                           
                          
               i++;}  
           
         parcours(E, liste);
     }else{
             //mettre le premier noeud dans la liste (le cas d'union avec lensemble vide). 
           String  id= (String) ( E1.get(0)); 
           ArrayList element= ((ArrayList) E1.get(1));
           ArrayList parent = ((ArrayList) E1.get(2));
           
          
           
       //la création de 1ere noeud des union  
       
         ArrayList<Object>  noeud1 = new ArrayList<>();
           noeud1.add(id);  
           noeud1.add(element);
           noeud1.add(parent);
           liste.add(noeud1);
           
           int i=0;
           int j=liste.size();
               while (i<j){     
                      String id1 = ((String) ((ArrayList) liste.get(i)).get(0));     
                      ArrayList element1 = ((ArrayList)((ArrayList) liste.get(i)).get(1));
                      ArrayList parent2 = ((ArrayList)((ArrayList) liste.get(i)).get(2));
                     ArrayList<Object>  noeud2 = new ArrayList<>();
                    ArrayList<Object>  l3 = new ArrayList<>();
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
                  
                      liste.add(noeud2); } 
               i++;}
          int i1=0;
      while (i1<E.size()){
                         
                     String id1 = ((String) ((ArrayList) E.get(i1)).get(0));     
                     ArrayList element1 = ((ArrayList)((ArrayList) E.get(i1)).get(1));
                     ArrayList parent2 = ((ArrayList)((ArrayList) E.get(i1)).get(2));
                
                     ArrayList<Object>  noeud2 = new ArrayList<>();
                    ArrayList<Object>  l3 = new ArrayList<>();
                 //liste des parents pour le marquage    
                     ArrayList<Object>  parent1 = new ArrayList<>();   
                      
                      noeud2.add(id+id1);
                      l3.addAll(element);
                      l3.addAll(element1);
                      noeud2.add(l3);
                      parent1.addAll(parent);
                      parent1.addAll(parent2);
                      noeud2.add(parent1);
                      
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
 

    

  

    public static void main (String[] args){
        
        // taille de les elemments 
        Scanner sc = new Scanner(System.in);
        System.out.println("la taille");
        int t=sc.nextInt();
        Enssemble E=new Enssemble(t);
        System.out.println("la liste des sous-ensembles");
        
        ArrayList<Object>  enssmble_1 = new ArrayList<>();
        ArrayList<Object>  ensemble_des_union = new ArrayList<>();
        ArrayList<Object>  enssmble_12 = new ArrayList<>();
        enssmble_1 =E.listes(t);
        System.out.println(enssmble_1);
        
       long debut = System.currentTimeMillis();
        enssmble_12 = E.parcours(enssmble_1,ensemble_des_union);
      long fin=  System.currentTimeMillis()-debut;
      
         
        System.out.println("la liste des unions");
       
         System.out.println(enssmble_12);
         
        System.out.println("le temps d'exécution des unions pour  "+t+" sous_ensembles est  "+fin+" ms et le nomber des unions est de "+enssmble_12.size());
         
         
                            
  }

    
   }
          

