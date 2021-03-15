/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enssemble;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */

// une classe pour la creation de la liste des sous enssemble
//avec cette structure [[SE0,[éléments],parents],[SE1,[éléments],parents],......]
public class Enssemble {
    int nombre_sous_enssemble;
    
    public Enssemble(int SE){
    this.nombre_sous_enssemble=SE;
    
    }
     
    public ArrayList listes (int ne){ 
        
              Sous_enssemble SE= new Sous_enssemble();
              ArrayList<Object>  l = new ArrayList<>();
                        int j=0;
                        while (j < ne){ 
                            
                            l.add(SE.elemments(j));
			
				 j++;}
					return l;}  
}
