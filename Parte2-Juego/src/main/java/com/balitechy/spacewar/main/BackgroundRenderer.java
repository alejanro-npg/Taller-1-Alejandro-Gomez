package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BackgroundRenderer {

	private Game game;  // Referencia al juego para acceder al estilo

    
	public void render(Graphics g, Canvas c, Game.Estilo estilo) throws IOException{
		BufferedImage background = null;
		SpritesImageLoader bg;

		//Según el estilo se escoge un fondo diferente

		switch (estilo) {
            case SPRITES:
                bg = new SpritesImageLoader("/bg.png");
                break;
            case COLORFULVECTOR:
                bg = new SpritesImageLoader("/colorscreen.png");
                break;
            default:
                throw new IllegalArgumentException("Estilo desconocido: " + estilo);
        }

		bg.loadImage();
		background = bg.getImage(0, 0, 640, 480);
		g.drawImage(background, 0, 0, c.getWidth(), c.getHeight(), c);
		
	}
	
}
