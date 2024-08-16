package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Space War 2D";

	private boolean running = false;
	private Thread thread;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	private SpritesImageLoader sprites;
	private Estilo estilo;  // Estilo de visual del juego
	
	// Componentes del juego
	private Player player;
	private BulletController bullets;
	private BackgroundRenderer backgRenderer;

	// Se guardan los estilos a usar
	public enum Estilo {
		SPRITES, COLORFULVECTOR
	}

	// Constructor que acepta un estilo para el juego
	public Game(Estilo estilo) {
		this.estilo = estilo;
	}

	public void init(){
		requestFocus();
		
		// Se carga el estilo que se va a usar en el juego
		cargarEstilo();
		
		// Añadir listener del teclado
		addKeyListener(new InputHandler(this));
		
		// Inicializar componentes del juego
		player = new Player((WIDTH * SCALE - Player.WIDTH) / 2, HEIGHT * SCALE - 50, this);
		bullets = new BulletController();
		backgRenderer = new BackgroundRenderer();
	}
	
	// Método para cargar los esprites según el estilo
	private void cargarEstilo() {
		switch (estilo) {
			case SPRITES:
				sprites = new SpritesImageLoader("/sprites.png");
				break;
			case COLORFULVECTOR:
				sprites = new SpritesImageLoader("/colorvector.png");
				break;
		}
		
		if (sprites != null) {
			try {
				sprites.loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

	public SpritesImageLoader getSprites(){
		return sprites;
	}
	
	public BulletController getBullets(){
		return bullets;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key){
			case KeyEvent.VK_RIGHT:
				player.setVelX(5);
				break;
			
			case KeyEvent.VK_LEFT:
				player.setVelX(-5);
				break;
			
			case KeyEvent.VK_UP:
				player.setVelY(-5);
				break;
			
			case KeyEvent.VK_DOWN:
				player.setVelY(5);
				break;
			
			case KeyEvent.VK_SPACE:
				player.shoot();
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key){
			case KeyEvent.VK_RIGHT:
				player.setVelX(0);
				break;
			
			case KeyEvent.VK_LEFT:
				player.setVelX(0);
				break;
			
			case KeyEvent.VK_UP:
				player.setVelY(0);
				break;
			
			case KeyEvent.VK_DOWN:
				player.setVelY(0);
				break;
		}
	}
	
	private synchronized void start(){
		if(running) return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running) return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	@Override
	public void run() {
		init();
		
		long lastTime = System.nanoTime();
		final double numOfTicks = 60.0;
		double ns = 1000000000 / numOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + "ticks, fps " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void tick(){
		player.tick();
		bullets.tick();
	}
	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////////
		
		try {
			backgRenderer.render(g, this, estilo);
			player.render(g);
			bullets.render(g);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]){		
		Estilo estilo = Estilo.COLORFULVECTOR; // Se especifica el estilo que se va a usar 
		
		Game game = new Game(estilo); // Pasar el estilo al constructor
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}
}
