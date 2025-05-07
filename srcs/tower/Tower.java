package tower;

import flyable.Flyable;
import flyable.aircraft.Aircraft;
import flyable.aircraft.LogMessage;
import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable>	observers = new ArrayList<>();

	public ArrayList<Flyable> getObservers() {
		return (observers);
	}

	public void	register(Flyable p_flyable) {
		this.observers.add(p_flyable);

		p_flyable.registerTower((WeatherTower) this);

		String registerMessage = "Tower says: %s#%s(%d) registered to weather tower.";
		LogMessage.writeMessage(String.format(registerMessage, p_flyable.getType(), ((Aircraft) p_flyable).getName(), ((Aircraft) p_flyable).getId()));
	}

	public void	unregister(Flyable p_flyable) {
		this.observers.remove(p_flyable);

		String unregisterMessage = "Tower says: %s#%s(%d) unregistered to weather tower.";
		LogMessage.writeMessage(String.format(unregisterMessage, p_flyable.getType(), ((Aircraft) p_flyable).getName(), ((Aircraft) p_flyable).getId()));
	}

	protected void	conditionChanged() {
		ArrayList<Flyable> ob = new ArrayList<>(observers);
		for (Flyable flyables : ob) {
			flyables.updateConditions();
		}
	}
}
