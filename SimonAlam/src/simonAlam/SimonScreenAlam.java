package simonAlam;

import java.util.ArrayList;
import java.util.List;

import gui.ClickableScreen;
import gui.components.TextLabel;
import gui.components.Visible;

public class SimonScreenAlam extends ClickableScreen implements Runnable {

	private static TextLabel label;
	private static ButtonInterfaceAlam [] button;
	private static ProgressInterfaceAlam progress;
	private static ArrayList<MoveInterfaceAlam> sequence;
	private static int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private static int lastSelectedButton;
	
	
	public SimonScreenAlam(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	
	public static void initAllObjects(ArrayList<Visible> viewObjects ){
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceAlam>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private static MoveInterfaceAlam randomMove() {
		int select = (int) (Math.random()*button.length);
		while(select == lastSelectedButton){
			select = (int) (Math.random()*button.length);
		}
		lastSelectedButton = select;
		return new partnerInHerePlease.Move(button[select]);
	}

	private static ProgressInterfaceAlam getProgress() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private static void addButtons(int noOfButtons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}

}
