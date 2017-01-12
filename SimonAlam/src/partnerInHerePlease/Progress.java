package partnerInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;

import gui.components.Component;
import simonAlam.ProgressInterfaceAlam;

public class Progress extends Component implements ProgressInterfaceAlam {

	private String roundNum;
	private String sequenceNum;
	private boolean gameOver;
	
	public Progress(int x, int y, int w, int h) {
		super(x, y, w, h);
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
			arg0.setColor(Color.WHITE);
			arg0.fillRect(0, 0, 120, 50);
			arg0.setColor(Color.ORANGE);
			arg0.drawString("Game Over!", 120, 20);
			arg0.drawString(sequenceNum, 120, 40);
		}
		else{
			arg0.fillRect(0, 0, 120, 50);
			arg0.setColor(Color.black);
			arg0.drawRect(0, 0, 120, 50);
			arg0.drawString("Round #: roundNum", 120, 20);
			arg0.drawString(sequenceNum, 120, 40);
			
		}

	}

}
