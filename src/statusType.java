import java.util.ArrayList;

public class statusType extends Type {
	
	//it gets a bit higher critical hit chance than vanilla types
	private ArrayList<Integer> critChance = new ArrayList<Integer>();
	
	//construct a type with critical hit chance
	public statusType(int typeInt){
		setTypeInt(typeInt);
		for (int i=0;i<7;i++)
			critChance.add(i);
	}
	
	//defends against the incoming type
	public int defend(Type attackingType) {
		double multiplier = 1;
		if (weakness.contains(attackingType.getTypeInt()))
			multiplier += 1;
		else if (resistance.contains(attackingType.getTypeInt()))
			multiplier -= 0.5;
		else if (noEffect.contains(attackingType.getTypeInt()))
			multiplier = 0;
		double finalDamage = DAMAGE * multiplier;
		return (int) finalDamage;
	}
	
	//checks for critical hit
	public boolean chance() {
		int critNumber = rng.nextInt(20);
		return critChance.contains(critNumber);
	}
}
