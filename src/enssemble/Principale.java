/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enssemble;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Principale {
    // programme principale 
       public static void main (String[] args){
        
        // le nombre de sous enssemble 
        Scanner sc = new Scanner(System.in);
        System.out.println("nombre de sous enssemble");
        int t=sc.nextInt();
        
        // on fait appel a la classe pour la creastion des sous enssemble 
       Enssemble  E=new Enssemble(t);
        System.out.println("la liste des sous-ensembles");
        
       
        ArrayList<Object>  ensemble_des_union = new ArrayList<>();
        
        ArrayList<Object> enssmble_1 =E.listes(t);
        ArrayList<Object> enssemble_s = (ArrayList<Object>) enssmble_1.clone();
        
        System.out.println(enssmble_1);
        
        Algorithme_1  algo=new Algorithme_1();
      // le 1 ere algorithme 
       long debut = System.currentTimeMillis();
      ArrayList<Object>   enssmble_12 = algo.parcours(enssmble_1,ensemble_des_union);
      long fin=  System.currentTimeMillis()-debut;
      
      
      int i=0;
      while(i<enssemble_s.size()){
       ArrayList<Object>  similaire2 = new ArrayList<>();
       similaire2.add("similaire");
       ArrayList paren =  ((ArrayList) enssemble_s.get(i));
      paren.add(similaire2);
      i++;}
      
       Algorithme_2  algo2=new Algorithme_2();
       ArrayList<Object>  ensemble_des_union1 = new ArrayList<>();
      // 2 eme algorithme 
       long debut1 = System.currentTimeMillis();
      ArrayList<Object>   enssmble  = algo2.parcours(enssemble_s,ensemble_des_union1);
      long fin1=  System.currentTimeMillis()-debut;
      
      
      
       
      
        System.out.println("la liste des unions algo 1");
       
        System.out.println(enssmble_12);
         
        System.out.println("1 ere algo : le temps d'exécution des unions pour  "+t+" sous_ensembles est  "+fin+" ms et le nomber des unions est de "+enssmble_12.size());
         
        System.out.println("la liste des unions algo 2");
       
        System.out.println(enssmble);
        System.out.println("2 eme algo : le temps d'exécution des unions pour  "+t+" sous_ensembles est  "+fin1+" ms et le nomber des unions est de "+enssmble.size()); 
                            
  } 
    
}
