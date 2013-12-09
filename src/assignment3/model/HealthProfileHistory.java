package assignment3.model;

import java.util.ArrayList;

public class HealthProfileHistory {
	public ArrayList<HealthProfile> getHealthProfileHistory() {
		return healthProfileHistory;
	}

	public void setHealthProfileHistory(
			ArrayList<HealthProfile> healthProfileHistory) {
		this.healthProfileHistory = healthProfileHistory;
	}

	public HealthProfileHistory(ArrayList<HealthProfile> healthProfileHistory) {
		super();
		this.healthProfileHistory = healthProfileHistory;
	}

	public HealthProfileHistory() {
		super();
	}

	private ArrayList<HealthProfile> healthProfileHistory;
}
