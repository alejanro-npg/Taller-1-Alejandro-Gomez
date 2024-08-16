
package edu.unisabana.pizzafactory.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */

 /** Se crea un horneador para cada tipo de masa */
public class Horneador {

    public void hornearMasaGruesa() {
        Logger.getLogger(Amasador.class.getName())
            .log(Level.INFO, "[~~] Horneando la pizza con masa gruesa.");

        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
    public void hornearMasaDelgada() {
        Logger.getLogger(Amasador.class.getName())
            .log(Level.INFO, "[~~] Horneando la pizza con masa delgada.");

        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
    public void hornearMasaIntegral() {
        Logger.getLogger(Amasador.class.getName())
            .log(Level.INFO, "[~~] Horneando la pizza con masa integral.");

        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
    
}
