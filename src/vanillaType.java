
public class vanillaType extends Type {
	
	
	public vanillaType(int typeInt){
		setTypeInt(typeInt);
	}
	
	//vanilla types are more resistance against resisted hits
	public int defend(Type attackingType) {
		double multiplier = 1;
		if (weakness.contains(attackingType.getTypeInt()))
			multiplier += 1;
		if (resistance.contains(attackingType.getTypeInt()))
			multiplier -= 0.7;
		if (noEffect.contains(attackingType.getTypeInt()))
			multiplier = 0;
		double finalDamage = DAMAGE * multiplier;
		return (int) finalDamage;
	}
	
	//checks for critical hit
	public boolean chance() {
		int critNumber = rng.nextInt(16);
		return (critNumber == 1);
	}
}
