package org.whrhs.dlamson.apa.labs.bricks;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class BrickStacker extends JFrame{
	
	private Board board;
	
	public BrickStacker() {
		initUI();
	}
	
	private void initUI() {
		board = new Board();
		add(board);
		setSize(board.WIDTH + 15, board.HEIGHT + 38);
		setTitle("Lab 016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			BrickStacker app = new BrickStacker();
			app.setVisible(true);
		});
	}
}

