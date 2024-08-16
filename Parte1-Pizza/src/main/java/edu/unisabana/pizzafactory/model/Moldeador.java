
package edu.unisabana.pizzafactory.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */

 /** Se crea un moldeador para cada tipo de masa, teniendo en cuenta el tamaño de la  pizza */
public class Moldeador {

    public void moldearPizzaPequenaDelgada() {
        Logger.getLogger(Moldeador.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza pequena de masa delgada.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR

    }

    public void molderarPizzaMedianaDelgada() {
        Logger.getLogger(Moldeador.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza mediana de masa delgada.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    public void moldearPizzaPequenaIntegral() {
        Logger.getLogger(Moldeador.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza pequena de masa integral.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR

    }

    public void molderarPizzaMedianaIntegral() {
        Logger.getLogger(Moldeador.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza mediana de masa integral.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

    public void moldearPizzaPequenaGruesa() {
        Logger.getLogger(Moldeador.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza pequena de masa gruesa.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR

    }

    public void molderarPizzaMedianaGruesa() {
        Logger.getLogger(Moldeador.class.getName())
                .log(Level.INFO, "[O] Moldeando pizza mediana de masa gruesa.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }

}
