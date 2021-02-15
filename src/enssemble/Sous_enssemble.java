/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enssemble;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author ADMIN
 */
public class Sous_enssemble {

    
    
   public Sous_enssemble() {

}
 public ArrayList elemments (int nb,int id){ 
            Random r=new Random();
                ArrayList<Object>  elemment = new ArrayList<>();
                 
                	
                        int j=0;
                        String id1= String.valueOf(id);
                        String id2="SE"+id1;
                        elemment.add(id2);
                        
                        ArrayList<Object>  elemment1 = new ArrayList<>();
                        ArrayList<Object>  parent1 = new ArrayList<>();
                       while (j < nb){ 
			int val =  r.nextInt(20-10);
                           elemment1.add(val);
			
				
				 j++;}
                       elemment.add(elemment1);
                       parent1.add(id);
                       elemment.add(parent1);
					return elemment;}
 
   

}
