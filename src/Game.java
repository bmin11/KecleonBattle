import java.util.Random;
import java.util.ArrayList;


public class Game {
	//static variable
	private static Random rng = new Random();
	
	//variables for running the game
	private String[] player = {"Player 1", "Player 2"}; 
	private Kecleon[] kecleon = new Kecleon[2];
	private int[] playerDollar = {0,0};
	private int turn = 1;
	
	//creates two kecleons as constructor
	public Game() {
		kecleon[0] = new Kecleon(0, 100);
		kecleon[1] = new Kecleon(0, 100);
	}
	
	//assign both kecleons with 4 moves each
	public void assignMoves(int[] moveOne, int[] moveTwo) {
		for (int i=0;i<moveOne.length;i++) {
			kecleon[0].addMove(moveOne[i]);
			kecleon[1].addMove(moveTwo[i]);
		}
	}
	
	//runs a single turn of battle
	public ArrayList<String> battle(int moveOne, int moveTwo) {
		ArrayList<String> battleLog = new ArrayList<String>();
		int firstAct = rng.nextInt(2);
		int secondAct = (firstAct+1)%2;
		int[] moves = {moveOne, moveTwo};
		int[] damageDoneTo = new int[2];
		
		battleLog.add("Turn " + turn + "\n--------------------------------------------------------------------\n");
		battleLog.add(player[firstAct] + " attacked " + player[secondAct] + " with a " + Type.getTypeNameWithInt(moves[firstAct]) + " type move!\n");
		
		damageDoneTo[secondAct] = kecleon[secondAct].defend(kecleon[firstAct].attack(moves[firstAct]));
		if (damageDoneTo[secondAct] == 0)
			battleLog.add("It has no effect...\n");
		else if (damageDoneTo[secondAct] > 20)
			battleLog.add("It was super-effective!\n");
		else if (damageDoneTo[secondAct] < 20)
			battleLog.add("It wasn't very effective...\n");
		if (kecleon[firstAct].attack(moves[firstAct]).chance() && damageDoneTo[secondAct] != 0) {
			battleLog.add("It was a critical hit!\n");
			damageDoneTo[secondAct] = (int) (damageDoneTo[secondAct] * 1.5);
		}
		battleLog.add(player[secondAct] + " has received " + damageDoneTo[secondAct] + " as damage.\n\n");
		
		int continueTurn = 0;
		if (kecleon[secondAct].getHitPoint() > 0)
			continueTurn = 1;
		switch (continueTurn) {
		case 0:
			battleLog.add(player[secondAct] + " has fainted.\n" + player[firstAct] + " has won the battle!\n");
			break;
		case 1:
			secondAct = firstAct;
			firstAct = (firstAct+1)%2;
			battleLog.add(player[firstAct] + " attacked " + player[secondAct] + " with a " + Type.getTypeNameWithInt(moves[firstAct]) + " type move!\n");
			
			damageDoneTo[secondAct] = kecleon[secondAct].defend(kecleon[firstAct].attack(moves[firstAct]));
			if (damageDoneTo[secondAct] == 0)
				battleLog.add("It has no effect...\n");
			else if (damageDoneTo[secondAct] > 20)
				battleLog.add("It was super-effective!\n");
			else if (damageDoneTo[secondAct] < 20)
				battleLog.add("It wasn't very effective...\n");
			if (kecleon[firstAct].attack(moves[firstAct]).chance() && damageDoneTo[secondAct] != 0) {
				battleLog.add("It was a critical hit!\n");
				damageDoneTo[secondAct] = (int) (damageDoneTo[secondAct] * 1.5);
			}
			battleLog.add(player[secondAct] + " has received " + damageDoneTo[secondAct] + " as damage.\n");
			if (kecleon[secondAct].getHitPoint() <= 0)
				battleLog.add(player[secondAct] + " has fainted.\n" + player[firstAct] + " has won the battle!\n");
			break;
		}
		battleLog.add("--------------------------------------------------------------------\n");
		turn++;
		
		return battleLog;
	}
	
	//returns both hit points
	public int[] getHitPoints() {
		int[] hitPoints = {kecleon[0].getHitPoint(), kecleon[1].getHitPoint()};
		return hitPoints;
	}
	
	//revive any kecleon that has 0 HP
	public void revive() {
		for (int i=0;i<player.length;i++)
			if (kecleon[i].getHitPoint() <= 0)
				kecleon[i] = new Kecleon(0, 100);
	}
	
	//return both players dollar
	public int[] getDollar() {
		return playerDollar;
	}
	
	//give a player some $$$
	public void gainDollar(int playerInt, int dollar) {
		playerDollar[playerInt] += dollar;
	}
	
	//heal a kecleon
	public void useSuperPotion(int playerInt) {
		kecleon[playerInt].heal(50);
	}
}
