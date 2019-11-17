package org.whrhs.dlamson.apa.labs.bricks;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class BoardStarter extends JPanel{
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 500;
	
	private static final int BRICK_WIDTH = 50;
	private static final int BRICK_HEIGHT = 25;
	
	private static final Color bg = new Color(0x6b8cff);
	private static final Color brickColor = new Color(0xe85b11);
	
	public BoardStarter() {
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
		
		
		/* TODO: test your methods by uncommenting the calls below*/
		
		//drawWall(g2d);
		//drawRandom(g2d);
		//drawSteps(g2d);
		//drawPyramid(g2d);
		//freeStyle(g2d);
		
	}
	
	private void drawBrick(Graphics2D g, int x, int y) {
		g.setColor(brickColor);
		g.fillRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		g.setColor(brickColor.darker());
		g.setStroke(new BasicStroke(3));
		g.drawRect(x,  y, BRICK_WIDTH, BRICK_HEIGHT);
	}
	
	private void drawWall(Graphics2D g) {
		// challenge #1
	}
	
	private void drawRandom(Graphics2D g) {
		// challenge #2
	}
	
	private void drawSteps(Graphics2D g) {
		// challenge #3
	}
	
	private void drawPyramid(Graphics2D g) {
		// challenge #4
	}
	
	private void freeStyle(Graphics2D g) {
		// challenge #5
	}
	
}

