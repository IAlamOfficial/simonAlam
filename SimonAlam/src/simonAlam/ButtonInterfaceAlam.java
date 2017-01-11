package simonAlam;

import java.awt.Color;

import gui.components.Action;
import gui.components.Clickable;

public interface ButtonInterfaceAlam extends Clickable {

	void setColor(Color color);

	void setX(int i);

	void setY(int i);

	void setAction(Action action);

	void highlight();

	void dim();


}
