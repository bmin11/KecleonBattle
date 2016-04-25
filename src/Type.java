import java.util.ArrayList;
import java.util.Random;


public abstract class Type {
	//static variables for coders convenience
	protected static final String[] TYPENAMES = {"normal","grass","fire","water","fight","flying","poison","ground","rock","bug",
											   "ghost","electric","psychic","ice","dragon","dark","steel","fairy"};
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
	
	//all types has a damage of 20
	protected static final int DAMAGE = 20;
	
	protected static Random rng = new Random();
	
	//types properties
	protected String name;
	protected int typeInt;
	//list of types weakness, resistance, and ineffectiveness
	protected ArrayList<Integer> weakness = new ArrayList<Integer>();
	protected ArrayList<Integer> resistance = new ArrayList<Integer>();
	protected ArrayList<Integer> noEffect = new ArrayList<Integer>();
	
	//constructor with default type as NORMAL type
	public Type() {
		setName(TYPENAMES[0]);
	}
	
	//get methods
	public String getName() {return name;}
	public int getTypeInt() {return typeInt;}
	
	//sets both name and typeInt accordingly to the given name to be set
	public void setName(String name) {
		for(int i=0;i<TYPENAMES.length;i++) {
			if (name.toLowerCase().equals(TYPENAMES[i])) {
				this.name = name;
				typeInt = i;
			}
		}
		setTypeInteraction();
	}
	
	//sets both name and typeInt accordingly to the given type integer to be set
	public void setTypeInt(int typeInt) {
		if (typeInt >= 0 && typeInt < TYPENAMES.length) {
			this.typeInt = typeInt;
			name = TYPENAMES[typeInt];
		}
		setTypeInteraction();
	}
	
	//set all types weakness, resistance, and ineffectiveness
	public void setTypeInteraction() {
		switch(typeInt) {
		case NORMAL:
			weakness.add(FIGHT);
			noEffect.add(GHOST);
			break;
		case GRASS:
			weakness.add(FLYING);
			weakness.add(POISON);
			weakness.add(BUG);
			weakness.add(FIRE);
			weakness.add(ICE);
			resistance.add(GROUND);
			resistance.add(WATER);
			resistance.add(GRASS);
			resistance.add(ELECTRIC);
			break;
		case FIRE:
			weakness.add(GROUND);
			weakness.add(ROCK);
			weakness.add(WATER);
			resistance.add(BUG);
			resistance.add(STEEL);
			resistance.add(FIRE);
			resistance.add(GRASS);
			resistance.add(ICE);
			resistance.add(FAIRY);
			break;
		case WATER:
			weakness.add(GRASS);
			weakness.add(ELECTRIC);
			resistance.add(STEEL);
			resistance.add(FIRE);
			resistance.add(WATER);
			resistance.add(ICE);
			break;
		case FIGHT:
			weakness.add(FLYING);
			weakness.add(PSYCHIC);
			weakness.add(FAIRY);
			resistance.add(ROCK);
			resistance.add(BUG);
			resistance.add(DARK);
			break;
		case FLYING:
			weakness.add(ROCK);
			weakness.add(ELECTRIC);
			weakness.add(ICE);
			resistance.add(FIGHT);
			resistance.add(BUG);
			resistance.add(GRASS);
			noEffect.add(GROUND);
			break;
		case POISON:
			weakness.add(GROUND);
			weakness.add(PSYCHIC);
			resistance.add(FIGHT);
			resistance.add(POISON);
			resistance.add(BUG);
			resistance.add(GRASS);
			resistance.add(FAIRY);
			break;
		case GROUND:
			weakness.add(WATER);
			weakness.add(GRASS);
			weakness.add(ICE);
			resistance.add(POISON);
			resistance.add(ROCK);
			noEffect.add(ELECTRIC);
			break;
		case ROCK:
			weakness.add(FIGHT);
			weakness.add(GROUND);
			weakness.add(STEEL);
			weakness.add(WATER);
			weakness.add(GRASS);
			resistance.add(NORMAL);
			resistance.add(FLYING);
			resistance.add(POISON);
			resistance.add(FIRE);
			break;
		case BUG:
			weakness.add(FLYING);
			weakness.add(ROCK);
			weakness.add(FIRE);
			resistance.add(FIGHT);
			resistance.add(GROUND);
			resistance.add(GRASS);
			break;
		case GHOST:
			weakness.add(GHOST);
			weakness.add(DARK);
			resistance.add(POISON);
			resistance.add(BUG);
			noEffect.add(NORMAL);
			noEffect.add(FIGHT);
			break;
		case ELECTRIC:
			weakness.add(GROUND);
			resistance.add(FLYING);
			resistance.add(STEEL);
			resistance.add(ELECTRIC);
			break;
		case PSYCHIC:
			weakness.add(BUG);
			weakness.add(GHOST);
			weakness.add(DARK);
			resistance.add(FIGHT);
			resistance.add(PSYCHIC);
			break;
		case ICE:
			weakness.add(FIGHT);
			weakness.add(ROCK);
			weakness.add(STEEL);
			weakness.add(FIRE);
			resistance.add(ICE);
			break;
		case DRAGON:
			weakness.add(ICE);
			weakness.add(DRAGON);
			weakness.add(FAIRY);
			resistance.add(FIRE);
			resistance.add(WATER);
			resistance.add(GRASS);
			resistance.add(ELECTRIC);
			break;
		case DARK:
			weakness.add(FIGHT);
			weakness.add(BUG);
			weakness.add(FAIRY);
			resistance.add(GHOST);
			resistance.add(DARK);
			noEffect.add(PSYCHIC);
			break;
		}
	}
	
	//translate the type integer to the type name
	public static String getTypeNameWithInt(int typeInt) {
		return TYPENAMES[typeInt];
	}

	//abstract methods to be implemented for all sub classes
	public abstract int defend(Type attackType);
	public abstract boolean chance();
}
