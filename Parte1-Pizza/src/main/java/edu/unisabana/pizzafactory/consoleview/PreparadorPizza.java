
package edu.unisabana.pizzafactory.consoleview;

import edu.unisabana.pizzafactory.model.Amasador;
import edu.unisabana.pizzafactory.model.ExcepcionParametrosInvalidos;
import edu.unisabana.pizzafactory.model.Horneador;
import edu.unisabana.pizzafactory.model.Ingrediente;
import edu.unisabana.pizzafactory.model.Moldeador;
import edu.unisabana.pizzafactory.model.Tamano;
import edu.unisabana.pizzafactory.model.TipoMasa;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */
public class PreparadorPizza {

    public static void main(String args[]){
        try {
            Ingrediente[] ingredientes=new Ingrediente[]{new Ingrediente("queso",1),new Ingrediente("jamon",2)};            
            PreparadorPizza pd=new PreparadorPizza();
            PreparadorPizza pg=new PreparadorPizza();   
            PreparadorPizza pi=new PreparadorPizza();
            /** Se creó tres pizzas de diferentes tipo de masas */               
            pd.prepararPizza(ingredientes, Tamano.MEDIANO, TipoMasa.Delgada);
            pg.prepararPizza(ingredientes, Tamano.PEQUENO, TipoMasa.Gruesa);
            pi.prepararPizza(ingredientes, Tamano.MEDIANO, TipoMasa.Integral);
        } catch (ExcepcionParametrosInvalidos ex) {
            Logger.getLogger(PreparadorPizza.class.getName()).log(Level.SEVERE, "Problema en la preparacion de la Pizza", ex);
        }
                
    }
    
    /** Según el tipo de masa se usa el amasador, el moldeador y el horneador correspondiente */
    public void prepararPizza(Ingrediente[] ingredientes, Tamano tam, TipoMasa tm)
            throws ExcepcionParametrosInvalidos {
        Amasador am = new Amasador();
        Horneador hpd = new Horneador();
        Moldeador mp = new Moldeador();
        if (tm==TipoMasa.Delgada) {
            am.amasarPizzaDelgada();
        } else if (tm==TipoMasa.Gruesa) {
            am.amasarPizzaGruesa();
        } else if (tm==TipoMasa.Integral) {
            am.amasarPizzaIntegral();
        } else {
            throw new ExcepcionParametrosInvalidos("Tipo  de masa inválido:"+tm);
        }
        if (tm==TipoMasa.Delgada) {
            if (tam == Tamano.PEQUENO) {
                mp.moldearPizzaPequenaDelgada();
            } else if (tam == Tamano.MEDIANO) {
                mp.molderarPizzaMedianaDelgada();
            } else {
                throw new ExcepcionParametrosInvalidos("Tamano de piza invalido:"+tam);
            }
        } else if (tm==TipoMasa.Gruesa) {
            if (tam == Tamano.PEQUENO) {
                mp.moldearPizzaPequenaGruesa();
            } else if (tam == Tamano.MEDIANO) {
                mp.molderarPizzaMedianaGruesa();
            } else {
                throw new ExcepcionParametrosInvalidos("Tamano de piza invalido:"+tam);
            }
        } else if (tm==TipoMasa.Integral) {
            if (tam == Tamano.PEQUENO) {
                mp.moldearPizzaPequenaIntegral();
            } else if (tam == Tamano.MEDIANO) {
                mp.molderarPizzaMedianaIntegral();
            } else {
                throw new ExcepcionParametrosInvalidos("Tamano de piza invalido:"+tam);
            }

        } else {
            throw new ExcepcionParametrosInvalidos("Tipo  de masa inválido:"+tm);
        }
       
	aplicarIngredientes(ingredientes);
    if (tm==TipoMasa.Delgada) {
        hpd.hornearMasaDelgada();
    } else if (tm==TipoMasa.Gruesa) {
        hpd.hornearMasaGruesa();
    } else if (tm==TipoMasa.Integral) {
        hpd.hornearMasaIntegral();
    } else {
        throw new ExcepcionParametrosInvalidos("Tipo  de masa inválido:"+tm);
    }
        
    }

    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        Logger.getLogger(PreparadorPizza.class.getName())
                .log(Level.INFO, "APLICANDO INGREDIENTES!:{0}", Arrays.toString(ingredientes));
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
        
        
    }


}
