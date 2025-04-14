package tower;

import flyable.Flyable;
import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable>	observers;

	public void	register(Flyable p_flyable) {
		this.observers.add(p_flyable);
	};

	public void	unregister(Flyable p_flyable) {
		// add index system
		// this.observers.remove();
	};

	protected void	conditionChanged() {};
}
