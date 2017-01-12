package partnerInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import gui.components.Action;
import gui.components.Component;
import simonAlam.ButtonInterfaceAlam;

public class Button extends Component implements ButtonInterfaceAlam {

	private Color col;
	private Color col2;
	private Action acts;
	private final static int WIDTH = 65;
	private final static int HEIGHT = 65;
	private boolean highlighted;
	
	private static int count;
	
	public Button() {
		super(70*count + 50, 300, WIDTH, HEIGHT);
		count++;
	}

	@Override
	public void act() {
		acts.act();

	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		double distance = Math.sqrt(Math.pow(arg0-(getX()+WIDTH/2), 2)+Math.pow(arg1-(getY()+HEIGHT/2), 2));
		return distance < WIDTH/2;
	}

	@Override
	public void setColor(Color color) {
		this.col = color;
		col2 = col;
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
		if(col != null){
			col2 = col;
		}
		highlighted = true;
		update();
	}

	@Override
	public void dim() {
		col2 = Color.gray;
		highlighted = false;
		update();
		
	}
 
	@Override
	public void update(Graphics2D arg0) {
		if(col2 != null){
			arg0.setColor(col2);
		}
		else arg0.setColor(Color.gray);
		arg0.fillOval(0, 0, WIDTH, HEIGHT);
		arg0.setColor(Color.black);
		arg0.drawOval(0, 0, WIDTH - 1, HEIGHT - 1);
	}

}
