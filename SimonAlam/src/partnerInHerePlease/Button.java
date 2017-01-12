package partnerInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;

import gui.components.Action;
import gui.components.Component;
import simonAlam.ButtonInterfaceAlam;

public class Button extends Component implements ButtonInterfaceAlam {

	private Color col;
	private Action acts;
	private final static int WIDTH = 65;
	private final static int HEIGHT = 65;
	private boolean highlighted;
	
	public Button() {
		super(0, 0, WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		acts.act();

	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		
		return  arg0 > getX() && arg0 < getX() + getWidth() && arg1 > getY() && arg1 < getY() + getHeight();
	}

	@Override
	public void setColor(Color color) {
		this.col = color;
		update();
	}

	@Override
	public void setX(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAction(Action action) {
		this.acts = action;

	}

	@Override
	public void highlight() {
		highlighted = true;
		update();
	}

	@Override
	public void dim() {
		highlighted = false;
		update();

	}

	@Override
	public void update(Graphics2D arg0) {
		if(col != null){  
			arg0.setColor(col);
		}
		else{
			arg0.setColor(Color.gray);
		}
		arg0.fillOval(0, 0, WIDTH, HEIGHT);
		arg0.drawOval(0, 0, WIDTH - 1 , HEIGHT - 1);
	}

}
