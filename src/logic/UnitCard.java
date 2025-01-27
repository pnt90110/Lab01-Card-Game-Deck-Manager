package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public UnitCard(String name, int bloodCost, int
			power, int health, String flavorText){
		setName(name);
		setBloodCost(bloodCost);
		setPower(power);
		setHealth(health);
		this.flavorText=flavorText;
	}
	
	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.isBlank()) name = "Creature";
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if(power<0) power=0;
		this.power = power;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health<1) health=1;
		this.health = health;
	}

	public int getBloodCost() {
		return bloodCost;
	}

	public void setBloodCost(int bloodCost) {
		if(bloodCost<0) bloodCost=0;
		this.bloodCost = bloodCost;
	}
	
	public String getFlavorText() {
		return flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public boolean equals(UnitCard other) {
		if(this.getName()==other.getName()) 
			return true;
		return false;
	}


}
