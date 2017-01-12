package partnerInHerePlease;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import gui.components.Component;
import simonAlam.ProgressInterfaceAlam;

public class Progress extends Component implements ProgressInterfaceAlam {

	private String roundNum;
	private String sequenceNum;
	private boolean gameOver;
	private static final int WIDTH = 120;
	private static final int HEIGHT = 50;
	
	public Progress() {
		super(60, 60, WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setRoundNumber(int roundNumber) {
		roundNum = "Round #" + roundNumber;
		update();
	}

	@Override
	public void setSequence(int size) {
		sequenceNum = "Sequence: " + size;
		update();
	}
	
	public void gameOver(){
		gameOver = true;
		update();
	}

	@Override
	public void update(Graphics2D arg0) {

		if(gameOver){
			arg0.setColor(Color.black);
			arg0.fillRect(0, 0, WIDTH, HEIGHT);
			arg0.setColor(Color.white);
			arg0.drawString("Game Over!", 120, 20);
			arg0.drawString(sequenceNum, 120, 40);
		}
		else{
			arg0.setColor(Color.orange);
			arg0.fillRect(0, 0, WIDTH, HEIGHT);
			arg0.setColor(Color.black);
			arg0.drawRect(0, 0, WIDTH - 1, HEIGHT - 1);
			if(roundNum !=null && sequenceNum != null){
				arg0.drawString(roundNum, (WIDTH - 45 )/2, 20);
				arg0.drawString(sequenceNum, (WIDTH - 55)/2, 40);
			}

		}

	}
	

}
