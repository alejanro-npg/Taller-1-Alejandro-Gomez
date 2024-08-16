
package edu.unisabana.pizzafactory.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */

 /** Se crea un amasador para cada tipo de masa */
public class Amasador {

    
    
    public void amasarPizzaDelgada() {
        Logger.getLogger(Amasador.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza con masa delgada.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
    }
    public void amasarPizzaIntegral() {
        Logger.getLogger(Amasador.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza con masa integral.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
    }
    public void amasarPizzaGruesa() {
        Logger.getLogger(Amasador.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza con masa gruesa.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
    }
    
}
