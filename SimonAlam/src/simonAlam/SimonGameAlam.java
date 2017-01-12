package simonAlam;

import gui.GUIApplication;
import java.awt.Container;
public class SimonGameAlam extends GUIApplication {

	public SimonGameAlam(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenAlam game = new SimonScreenAlam(getWidth(), getHeight());
		setScreen(game);
	}

	public static void main(String[] args) {
		SimonGameAlam game = new SimonGameAlam(800,600);
		Thread simon = new Thread(game);
		simon.start();

	}
}
