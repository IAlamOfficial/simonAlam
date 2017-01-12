package partnerInHerePlease;

import simonAlam.ButtonInterfaceAlam;
import simonAlam.MoveInterfaceAlam;

public class Move implements MoveInterfaceAlam {

	private ButtonInterfaceAlam moveButton;
	
	public Move(ButtonInterfaceAlam b) {
		this.moveButton = b;
	}

	@Override
	public ButtonInterfaceAlam getButton() {
		return moveButton;
	}

}
