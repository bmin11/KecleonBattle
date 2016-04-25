import java.util.ArrayList;

public class Kecleon {
	//static variables for coders convenience
	protected static final int NORMAL = 0;
	protected static final int GRASS = 1;
	protected static final int FIRE = 2;
	protected static final int WATER = 3;
	protected static final int FIGHT = 4;
	protected static final int FLYING = 5;
	protected static final int POISON = 6;
	protected static final int GROUND = 7;
	protected static final int ROCK = 8;
	protected static final int BUG = 9;
	protected static final int GHOST = 10;
	protected static final int ELECTRIC = 11;
	protected static final int PSYCHIC = 12;
	protected static final int ICE = 13;
	protected static final int DRAGON = 14;
	protected static final int DARK = 15;
	protected static final int STEEL = 16;
	protected static final int FAIRY = 17;
	private static final int[] vanillaTypeIntArray = {NORMAL, WATER, FIGHT, FLYING, GROUND, ROCK, GHOST, PSYCHIC, DRAGON, DARK, STEEL, FAIRY};
	private static final int[] statusTypeIntArray = {GRASS, FIRE, POISON, BUG, ELECTRIC, ICE};
	
	//kecleons current type
	private Type currentType = new vanillaType(NORMAL);
	//kecleons move slot
	private ArrayList<Type> moveSlot = new ArrayList<Type>();
	//kecleons hit point
	private int hitPoint = 100;
	
	//construct a kecleon with given type int and hit points
	public Kecleon(int currentTypeInt, int hitPoint) {
		Type type;
		for (int i=0; i<vanillaTypeIntArray.length;i++) {
			if (vanillaTypeIntArray[i] == currentTypeInt) {
				type = new vanillaType(currentTypeInt);
				currentType = type;
				break;
			}
		}
		for (int i=0; i<statusTypeIntArray.length;i++) {
			if (statusTypeIntArray[i] == currentTypeInt) {
				type = new statusType(currentTypeInt);
				currentType = type;
				break;
			}
		}
		this.hitPoint = hitPoint;
	}
	
	//add a move to kecleon's move slot
	public void addMove(int moveInt) {
		Type move;
		for (int i=0; i<vanillaTypeIntArray.length;i++) {
			if (vanillaTypeIntArray[i] == moveInt) {
				move = new vanillaType(moveInt);
				moveSlot.add(move);
				break;
			}
		}
		for (int i=0; i<statusTypeIntArray.length;i++) {
			if (statusTypeIntArray[i] == moveInt) {
				move = new statusType(moveInt);
				moveSlot.add(move);
				break;
			}
		}
	}
	
	//kecleon attacks with a move
	public Type attack(int moveInt) {
		int index = 0;
		for (int i=0; i<moveSlot.size();i++) {
			if (moveSlot.get(i).getTypeInt() == moveInt) {
				index = i;
			}
		}
		this.currentType = moveSlot.get(index);
		return moveSlot.get(index);
	}
	
	//kecleon defends against the incoming move
	public int defend(Type attackType) {
		hitPoint -= this.currentType.defend(attackType);
		if (hitPoint < 0)
			hitPoint = 0;
		return this.currentType.defend(attackType);
	}
	
	//returns kecleons hit point
	public int getHitPoint() {
		return hitPoint;
	}
	
	//heals kecleons hit point
	public void heal(int amount) {
		if (hitPoint + amount > 100)
			hitPoint = 100;
		else
			hitPoint += amount;
	}
}
