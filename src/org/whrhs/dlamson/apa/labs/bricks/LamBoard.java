package org.whrhs.dlamson.apa.labs.bricks;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class LamBoard extends JPanel{
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 500;
	
	private static final int BRICK_WIDTH = 50;
	private static final int BRICK_HEIGHT = 25;
	
	private static final Color bg = new Color(0x6b8cff);
	private static final Color brickColor = new Color(0xe85b11);
	
	public LamBoard() {
		initBoard();
	}
	
	private void initBoard() {
		setSize(WIDTH, HEIGHT);
		setBackground(bg);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		g2d.setColor(Color.BLACK);
		//drawPyramid(g2d);
		//drawWall(g2d);
		//drawRandom(g2d);
		//drawSteps(g2d);
	}
	
	private void drawBrick(Graphics2D g, int x, int y) {
		g.setColor(brickColor);
		g.fillRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		g.setColor(brickColor.darker());
		g.setStroke(new BasicStroke(3));
		g.drawRect(x,  y, BRICK_WIDTH, BRICK_HEIGHT);
	}
	
	private void drawWall(Graphics2D g) {
		for(int i = 0; i < HEIGHT/BRICK_HEIGHT; i++) {
			for(int j = 0; j < WIDTH/BRICK_WIDTH; j++) {
				drawBrick(g, j * BRICK_WIDTH, i * BRICK_HEIGHT);
			}
		}
	}
	
	private void drawRandom(Graphics2D g) {
		for(int i = 0; i < HEIGHT/BRICK_HEIGHT; i++) {
			for(int j = 0; j < WIDTH/BRICK_WIDTH; j++) {
				if(Math.random() < 0.5) {
					drawBrick(g, j * BRICK_WIDTH, i * BRICK_HEIGHT);
				}
			}
		}
	}
	
	private void drawSteps(Graphics2D g) {
		for(int i = 0; i < HEIGHT/BRICK_HEIGHT; i++) {
			for(int j = 0; j < WIDTH/BRICK_WIDTH; j++) {
				if(i >= j) {
					drawBrick(g, j * BRICK_WIDTH, i * BRICK_HEIGHT);
				}
			}
		}
	}
	
	private void drawPyramid(Graphics2D g) {
		int maxBricks = WIDTH/BRICK_WIDTH;
		int numRows = HEIGHT/BRICK_HEIGHT;
		int numBricks = 1;
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numBricks; j++) {
				drawBrick(g, WIDTH/2 - numBricks*BRICK_WIDTH/2 + j*BRICK_WIDTH, i * BRICK_HEIGHT);
			}
			numBricks++;
		}
	}
	
	
}
