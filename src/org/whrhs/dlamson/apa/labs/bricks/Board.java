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
		
		//drawPyramid(g2d);
		//drawWall(g2d);
		//drawRandom(g2d);
		//drawSteps(g2d);
		d(g2d);
	}
	
	
	
	private void randomAll(Graphics2D g){
		for(int x = 0; x < 20; x++)
		{
			for(int y = 0; y < 20; y++)
			{
				drawBrick(g, (int)(Math.random()*1000), (int)(Math.random()*1000));
			}
		}
		
	}
	
	private void d(Graphics2D g) {
		for(int i = 0; i < 1000; i += 80) {
			for(int j = 0; j < 500; j += 50){
				drawBrick(g, i, j);
			}
		}
	}
		
	
	private void freeBoi(Graphics2D g){
		int b = 0;
		for(int k = 0; k<500; k+=25)	{
			for(int i = 500; i<1000; i+=50){
				drawBrick(g, i-b, k);
			}
		b+=25;
		}
		
	}
	private void brice(Graphics2D g)
	{
		int steps = 475;
		int number = 0;
		for(int x=0; x<10; x++){
			drawBrick (g,steps,number);
			for(int y=0; y<=x; y++)
			{
				drawBrick(g,steps+y*50,number);
			}
			steps-=25;
			number+=25;
		}
		
		int steps2 = 225;
		int number2 = 250;
		for(int x=0; x<10; x++){
			drawBrick (g,steps2,number2);
			for(int y=0; y<=x; y++)
			{
				drawBrick(g,steps2,number2);
			}
			steps2+=25;
			number2+=25;
		}
		
		int steps3 = 500;
		int number3 = 475;
		for(int x=20; x>10; x--){
			drawBrick (g,steps3,number3);
			for(int y=20; y>=x; y--)
			{
				drawBrick(g,steps3,number3);
			}
			steps3+=25;
			number3-=25;
		}
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

    
    private void drawPyramid(Graphics2D g) {
		// challenge #4
		int y = 0;
		int bricksInARow = 1;
		int rowStart = 475;
		for(int j = 0; j < 20; j++) {
			int x = rowStart;
			for(int i = 0; i  < bricksInARow; i++) {
				drawBrick(g, x, y);
				x+=50; // steps to right
			}
			y+= 25; //goes down to next row
			bricksInARow++;
			rowStart -= 25;
		}
	}
	
    private void freestyle(Graphics2D g)
	{
		for (int x = 0; x < 1000; x = x + 50)
		{
			for (int y = x; y < 500; y = y + 25)
			{
				drawBrick(g, x, y);
			}
		}
	}

    
    private void checkerboard(Graphics2D g)
	{
		int x =0;
		int y=0;
		int z=1;
		for(int g1 =0; g1<=20; g1++)
		{
			for(int g2=0; g2<=20; g2++)
			{
				if(z%2==0)
				{
				drawBrick(g,x,y);
				}
				z++;
				y+=25;
			}
			x+=50;
			y=0;
		}
	}
	
    private void randomBars(Graphics2D g)
	{
		int WX = 0;
		int WY = 0;
		for(int i = 0; i < 20; i++)
		{
			for(int l = 0; l < 20; l++)
			{
				if(Math.random() >= 0.5)
				{
					drawBrick(g, WX, WY);
					WX += 50;
				}
			}
			WX = 0;
			WY += 25;
		}
	}
    
    private void unionJack(Graphics2D g) {
    	int x = 0; int y = 0;
    	int x1 = WIDTH - BRICK_WIDTH; int y1 = 0;
    	int x2 = (WIDTH / 2) - BRICK_WIDTH; int y2 = 0;
    	int x3 = 0; int y3 = (HEIGHT / 2) - BRICK_HEIGHT;
    	
    	for (int i = 0; i < HEIGHT / BRICK_HEIGHT; i++) {
    		drawBrick(g, x, y);
    		x += BRICK_WIDTH;
    		y += BRICK_HEIGHT;
    	}
    	
    	for (int j = 0; j < HEIGHT / BRICK_HEIGHT; j++) {
    		drawBrick(g, x1, y1);
    		x1 -= BRICK_WIDTH;
    		y1 += BRICK_HEIGHT;
    	}
    	
    	for (int l = 0; l < HEIGHT / BRICK_HEIGHT; l++) {
    		drawBrick(g, x2, y2);
    		drawBrick(g, x2 + BRICK_WIDTH, y2);
    		y2 += BRICK_HEIGHT;
    	}
    	
    	for (int s = 0; s < 2; s++) {
    		for (int r = 0; r < WIDTH / BRICK_WIDTH; r++) {
    			drawBrick(g, x3, y3);
    			x3 += BRICK_WIDTH;
    		}
    		x3 = 0;
    		y3 += BRICK_HEIGHT;
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