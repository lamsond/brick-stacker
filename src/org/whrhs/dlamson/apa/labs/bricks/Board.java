package org.whrhs.dlamson.apa.labs.bricks;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class Board extends JPanel{
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 500;
	
	private static final int BRICK_WIDTH = 50;
	private static final int BRICK_HEIGHT = 25;
	
	private static final Color bg = new Color(0x6b8cff);
	private static final Color brickColor = new Color(0xe85b11);
	
	public Board() {
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
		
		/* I kept them as comments because you can't call them all at once with JPanel*/
		
		drawPyramid(g2d);
		//drawWall(g2d);
		//drawRandom(g2d);
		//drawSteps(g2d);
		//drawFreestyle(g2d);
	}
	
	private void drawBrick(Graphics2D g, int x, int y) {
		g.setColor(brickColor);
		g.fillRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		g.setColor(brickColor.darker());
		g.setStroke(new BasicStroke(3));
		g.drawRect(x,  y, BRICK_WIDTH, BRICK_HEIGHT);
	}
	
    private void drawWall(Graphics2D g) {
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                drawBrick(g, j*BRICK_WIDTH, i*BRICK_HEIGHT);
            }
        }
    }

    private void drawRandom(Graphics2D g) {
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                if (Math.random()>= 0.5){
                    drawBrick(g, j*BRICK_WIDTH, i*BRICK_HEIGHT);}

            }
        }
    }

    private void drawSteps(Graphics2D g) {
        for (int i = 0; i < 20; i++){
            for (int j = 0; j <= i; j++){
                drawBrick(g, j*BRICK_WIDTH, i*BRICK_HEIGHT);

            }
        }
    }

    
    private void drawPyramid(Graphics2D g) 
	{
		int x = 1;
		for (int j = 0; j <= 500; j += 25)
		{
			if (x%2 != 0)
			{
				for (int i = 1 ; i <= x ; i++)
				{
					int capx = 475;
					capx -= 25*x;

					drawBrick(g, (capx + 50 * i), j);
					
				}
				
			}
			else 
			{
				for (int k = 1 ; k <= x ; k++)
				{
					int cap2 = 475;
					cap2 -= 25*x;
					drawBrick(g, cap2 + 50 * k, j);
				}
			}
			x++;
		}
	}
	private void drawFreestyle(Graphics2D g) {
		for(int i = 0; i<=950; i= i+100)
		{
			for(int j = 0; j<=475; j=j+50)
			{
				drawBrick(g, i ,j);
			}
		}
	}
	
	private void drawDiamond(Graphics2D g) {
		for (int i = 0; i<=10; i++){
			for (int j = 0; j<=i; j++){
				drawBrick(g,500 - i*25 + j*50,i*25);
			}
		}
		for (int i = 0; i<=10; i++){
			for (int j = 0; j<=i; j++){
				drawBrick(g,500 - i*25 + j*50,500 - i*25);
			}
		}
		
	}
	public void drawX(Graphics2D g) {
		int initialX = 0;
		int initialY = 0;
		int widthRemover = 1;
		for (int i = 0; i < 4; i++) {
			for (int n = 0; n < 5; n++) {
				drawBrick(g, initialX, initialY);
				drawBrick(g, (WIDTH - BRICK_WIDTH), 0);
				drawBrick(g, (WIDTH - widthRemover * BRICK_WIDTH), initialY);
				widthRemover++;
				initialX += BRICK_WIDTH;
				initialY += BRICK_HEIGHT;
			}
		}	
	}
	
	private void hp(Graphics2D g) {
		//HP logo!
		
		for (int i = 5; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				drawBrick(g, 368 - (i * 5), i * 25 - 25);
			}
		}
		
		for (int i = 5; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				drawBrick(g, 440 - (i * 5), i * 25 + 100);
			}
		}
		
		for (int i = 5; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				drawBrick(g, 530 - (i * 5), i * 25 + 100);
			}
		}
		
		for (int i = 5; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				drawBrick(g, 620 - (i * 5), i * 25 + 100);
			}
		}
	}

    private void jayFu(Graphics2D g){
        for (int y = 0; y <= 12; y++){
            drawBrick(g, 250, 400-25*y);
            if (y == 10) continue;
            else
            drawBrick(g, 550, 400-25*y);
        }
        drawBrick(g, 550, 75);
        drawBrick(g, 600, 100);
        for (int x = 0; x <=5; x++) {
            drawBrick(g, 250 + 50*x, 400);
            if (x == 4) continue; else
            drawBrick(g, 250 + 50*x, 100);
        }
        drawBrick(g, 350, 175);
        for (int y1 = 0; y1 <= 5; y1++) {
            drawBrick(g, 400, 175 + 25*y1);
        }
        for (int x1 = 0; x1 <= 2; x1++) {
            drawBrick(g, 350 + 50*x1, 325);
        }
    }
	
}