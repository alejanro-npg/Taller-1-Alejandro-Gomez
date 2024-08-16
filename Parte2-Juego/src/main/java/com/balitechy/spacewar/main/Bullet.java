package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.balitechy.spacewar.main.Game.Estilo;

public class Bullet {
	
	private double x;
	private double y;
	public static final int WIDTH = 11;
	public static final int HEIGHT = 21;
	private BufferedImage image;
	
	public Bullet(double x, double y, Game game){
		this.x = x;
		this.y = y;
		
		//Según el estilo cambia la posición de la imagen a usar para las balas

	if(game.getEstilo() == Estilo.SPRITES) {
		image = game.getSprites().getImage(35, 52, WIDTH, HEIGHT);
	}else if (game.getEstilo()== Estilo.COLORFULVECTOR) {
		image = game.getSprites().getImage(348, 92, WIDTH, HEIGHT);

	
		
	}
	}
	
	public void tick(){
		y -= 5;
	}
	
	public void render(Graphics g){
		g.drawImage(image, (int) x, (int) y, null);
	}
	
	public double getY(){
		return y;
	}
}
