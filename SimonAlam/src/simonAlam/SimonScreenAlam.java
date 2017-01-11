package simonAlam;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui.ClickableScreen;
import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;
import simonAlam.ButtonInterfaceAlam;
import simonAlam.MoveInterfaceAlam;

public class SimonScreenAlam extends ClickableScreen implements Runnable {

	private static TextLabel label;
	private static ButtonInterfaceAlam[] button;
	private static ProgressInterfaceAlam progress;
	private static ArrayList<MoveInterfaceAlam> sequence;
	private static int roundNumber;
	private static boolean acceptingInput;
	private static int sequenceIndex;
	private static int lastSelectedButton;

	public SimonScreenAlam(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();
	}
	public static void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons(viewObjects);
		progress = getProgress();
		label = new TextLabel(130, 230, 300, 40, "Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceAlam>();
		// add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		
		
		viewObjects.add((Visible) progress);
		viewObjects.add(label);
	}

	private static void addButtons(ArrayList<Visible> viewObjects) {
		int numberOfButtons = 6;
		Color[] colors = { Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.MAGENTA };
		button = new ButtonInterfaceAlam[numberOfButtons];
		for(int i = 0; i < numberOfButtons; i++){
			
			button[i] = getAButton();
			button[i].setColor(colors[i]);
		    button[i].setX(100*(i+1));
		    button[i].setY(100*(i+1));
		    
		    final ButtonInterfaceAlam b = button[i];
		    
		    button[i].setAction(new Action(){
		    	public void act(){
		    		if(acceptingInput){
		    			Thread blink = new Thread(new Runnable(){
		    				public void run(){
		    					b.highlight();
		    					try{
		    						Thread.sleep(800);
		    					}
		    					catch(InterruptedException e) {
		    						e.printStackTrace();
		    					}
		    					b.dim();
		    				}
		    			});
		    		
		    			blink.start();
		    			
		    			if(b == sequence.get(sequenceIndex).getButton()){
		    				sequenceIndex++;
		    			}
		    			else{
		    				gameOver();
		    			}
		    			if(sequenceIndex == sequence.size()){
		    				Thread nextRound = new Thread(SimonScreenAlam.this);
		    				//check with Nockles
							nextRound.start(); 
		    			}
		    		}
		    	}

		    });
		    viewObjects.add(button[i]);
		}
	}
	private static void gameOver() {
		ProgressInterfaceAlam.gameOver();
		
	}

	private static ButtonInterfaceAlam getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	private static MoveInterfaceAlam randomMove() {
		int select = (int) (Math.random() * button.length);
		while (select == lastSelectedButton) {
			select = (int) (Math.random() * button.length);
		}
		lastSelectedButton = select;
		return new partnerInHerePlease.Move(button[select]);
	}

	private static ProgressInterfaceAlam getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Placeholder until partner finishes implementation of ProgressInterface
	 */

	private void playSequence() {
		ButtonInterfaceAlam b = null;
		for(MoveInterfaceAlam i:  sequence){
			if(b != null){
				b.dim();
				b = i.getButton();
				b.highlight();
				int sleepTime = 0;
				if(roundNumber >= 15){
					sleepTime = 500;		
				}else if(roundNumber >= 10){
					sleepTime = 1000;
				}else if(roundNumber >= 5){
					sleepTime = 2000;
				}else{
					sleepTime = 3000;
				}
				try{
					Thread.sleep(sleepTime);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		b.dim();
		
	}

	private void changeText(String string) {
		try {
			label.setText(string);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		progress.setRoundNumber(roundNumber);
		progress.setSequence(sequence.size());
		changeText("Simon's Turn.");
		label.setText("");
		playSequence();
		changeText("Your Turn.");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	@Override
	public void initAllObjects(List<Visible> arg0) {
		// TODO Auto-generated method stub
		
	}
}
