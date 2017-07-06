package dev.TP05;

import java.util.Scanner;



/**
 * @author Pau-Pau
 *
 */
public class Menu 
{
    public static void main( String[] args )
    {
    	Pizza[] pizzas= new Pizza [20];
    	pizzas[0]= new Pizza(0,"PEP","Peperoni",12.5);
    	pizzas[1]= new Pizza(1,"MAR","Margherita",14);
    	pizzas[2]= new Pizza(2,"REI","La Reine",11.5);
    	pizzas[3]= new Pizza(3,"FRO","La 4 fromages",12);
    	pizzas[4]= new Pizza(4,"CAN","La Cannibale",12.5);
    	pizzas[5]= new Pizza(5,"SAV","La savoyarde",13.0);
    	pizzas[6]= new Pizza(6,"ORI","L'orientale",13.5);
    	pizzas[7]= new Pizza(7,"IND","L'indienne",14);

    	int numPizzas = 8;
    	
        System.out.println( "***** Pizzeria Administration *****" );

        System.out.println( "1. Lister les pizzas" );
        System.out.println( "2. Ajouter une nouvelle pizza" );
        System.out.println( "3. Mettre à jour une pizza" );
        System.out.println( "4. Supprimer une pizza" );
        System.out.println( "99. Sortir" );
        
        Scanner scann= new Scanner(System.in) ;
        int a=scann.nextInt();
        
        while (a!=99){
        	
        	switch(a){
        	
        		case (1): //List of Pizzas
        			List.list(pizzas, numPizzas);
        		break;
        		
        		case (2)://Add a new Pizza
        			numPizzas=Add.addPizza(pizzas, numPizzas);
        		break;
        	
        		case (3): //Correct the information of one pizza
        			Modify.modifyPizza(pizzas, numPizzas);
        		break;
        		
        		case (4):// Delete a Pizza from the list
        			numPizzas=Delete.deletePizza(numPizzas, pizzas);
        			break;
        		case (99):
        			break;
        		default :System.out.println( "Code not found" );}
        	
            System.out.println( "1. Lister les pizzas" );
            System.out.println( "2. Ajouter une nouvelle pizza" );
            System.out.println( "3. Mettre à jour une pizza" );
            System.out.println( "4. Supprimer une pizza" );
            System.out.println( "99. Sortir" );
        	
            a=scann.nextInt();
            
        }
        
    }
    }

