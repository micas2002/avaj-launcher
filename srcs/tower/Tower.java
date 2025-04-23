package tower;

import flyable.Flyable;
import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable>	observers;

	public void	register(Flyable p_flyable) {
		this.observers.add(p_flyable);
		System.out.println("aircraft added");
	}

	public void	unregister(Flyable p_flyable) {
		this.observers.remove(p_flyable);
	}

	protected void	conditionChanged() {
		for (Flyable flyables : this.observers) {
			flyables.updateConditions();
		}
	}
}
