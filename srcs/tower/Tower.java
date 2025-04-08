package tower;

import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable>	observers;

	public void	register(Flyable p_flyable) {};
	public void	unregister(Flyable p_flyable) {};
	protected void	conditionChanged() {};
}
