package tower;

import flyable.Flyable;
import flyable.aircraft.Aircraft;
import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable>	observers = new ArrayList<>();

	public void	register(Flyable p_flyable) {
		this.observers.add(p_flyable);

		String registerMessage = "Tower says: %s#%s(%d) registered to weather tower.";
		System.out.println(String.format(registerMessage, p_flyable.getType(), ((Aircraft) p_flyable).getName(), ((Aircraft) p_flyable).getId()));
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
