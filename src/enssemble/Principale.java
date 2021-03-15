/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enssemble;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Principale {
    // programme principale 
       public static void main (String[] args){
        
        // le nombre de sous enssemble au départ 
        Scanner sc = new Scanner(System.in);
        System.out.println("nombre de sous enssemble");
        int t=sc.nextInt();
        
        
        // on fait appel a la classe enssemble  pour la creastion la liste des sous enssemble 
       Enssemble  E=new Enssemble(t);
        ArrayList<Object> enssmble_1 =E.listes(t);
        // on fait une copie pour la liste pour trvailler avec la méme liste pour les deux algorithme
        ArrayList<Object> enssemble_s = (ArrayList<Object>) enssmble_1.clone();
        System.out.println("la liste des sous-ensembles");
        System.out.println(enssmble_1);
        
        
        Algorithme_1  algo=new Algorithme_1();
        ArrayList<Object>  ensemble_des_union = new ArrayList<>();
      //  1 ere algorithme   va prendre en parmatres les sous ensembles de départ et retourn liste des union possible 
       long debut = System.currentTimeMillis();
      //a partir de 20 sous ensemble le temps d'excution de l'algorithme 1 vas a l'infiné 
      //a partir de 20 sous ensemble on doit commonté l'instruction suivente pour que l'algo 2 marche 
       ArrayList<Object>   enssmble_12 = algo.parcours(enssmble_1,ensemble_des_union);
       long fin=  System.currentTimeMillis()-debut;
      
      
      // déclaration d'une table de hachage pour sauvegarde la liste des elements (clé,valeur) --->(liste des éléments, sous_ensembles correspondent)
       Hashtable ht = new Hashtable();
       Algorithme_2  algo2=new Algorithme_2();
       ArrayList<Object>  ensemble_des_union1 = new ArrayList<>();
      //  2 éme algorithme  va prendre en parmatres les sous ensembles de départ et retourn liste des unions sans duplicate 
       long debut1 = System.currentTimeMillis();
     ArrayList<Object>   enssmble  = algo2.parcours(enssemble_s,ensemble_des_union1,ht);
      long fin1=  System.currentTimeMillis()-debut1;
      
      
      
       
      // l'affichage de la liste des unions pour la vérfication 
       // System.out.println("la liste des unions algo 1");
        //System.out.println(enssmble_12);
         
    System.out.println("1 ere algo : le temps d'exécution des unions pour  "+t+" sous_ensembles est  "+fin+" ms et le nomber des unions est de "+enssmble_12.size());
         
       // System.out.println("la liste des unions algo 2");
       
       // System.out.println(enssmble);
       // vérifcation les sous ensemble similaire sauvgardre dans la table de hachage chaque clé lié a une liste des sous enssembles similaire
        //System.out.println(ht);
       System.out.println("2 eme algo : le temps d'exécution des unions pour  "+t+" sous_ensembles est  "+fin1+" ms et le nomber des unions est de "+enssmble.size()); 
                            
  } 
    
}
