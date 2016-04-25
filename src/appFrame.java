import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.JCheckBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;


public class appFrame extends JFrame {

	private JPanel contentPane;
	
	
	
	//variables for main panel
	private JPanel panelMain;
	private JButton btnContinue;
	
	//variables for selection panel
	private JPanel panelSelection;
	private JLabel lblNewLabel;
	private JLabel lblKecleon1;
	private JLabel lblKecleon2;
	private JLabel lblMoveOne;
	private JLabel lblMoveTwo;
	private JLabel lblPlayerOneSelectionHP;
	private JLabel lblPlayerTwoSelectionHP;
	private JLabel lblPlayerOneDollar;
	private JLabel lblPlayerTwoDollar;
	private JButton btnUseSuperPotionOne;
	private JButton btnUseSuperPotionTwo;
	private ArrayList<JLabel> moveOneArray = new ArrayList<JLabel>();
	private ArrayList<JLabel> moveTwoArray = new ArrayList<JLabel>();
	private ArrayList<Integer> moveSetOneArray = new ArrayList<Integer>();
	private ArrayList<Integer> moveSetTwoArray = new ArrayList<Integer>();
	private int numOfSelectedOne = 0;
	private int numOfSelectedTwo = 0;
	private int[] dollars;
	private JButton btnBegin;
	private JButton btnBack;
	
	//animation images & icons
	private int animationImgNum = 0;
	final int ANIMATION_DELAY = 17;
	private Timer timerSelectionAnimation = new Timer(ANIMATION_DELAY, new selectionTimerHandler());
	private Timer timerBattleAnimation = new Timer(ANIMATION_DELAY, new battleAnimationTimerHandler());
	private final String[] kecleonMotionImage = {"frame_000.gif",
			"frame_001.gif",
			"frame_002.gif",
			"frame_003.gif",
			"frame_004.gif",
			"frame_005.gif",
			"frame_006.gif",
			"frame_007.gif",
			"frame_008.gif",
			"frame_009.gif",
			"frame_010.gif",
			"frame_011.gif",
			"frame_012.gif",
			"frame_013.gif",
			"frame_014.gif",
			"frame_015.gif",
			"frame_016.gif",
			"frame_017.gif",
			"frame_018.gif",
			"frame_019.gif",
			"frame_020.gif",
			"frame_021.gif",
			"frame_022.gif",
			"frame_023.gif",
			"frame_024.gif",
			"frame_025.gif",
			"frame_026.gif",
			"frame_027.gif",
			"frame_028.gif",
			"frame_029.gif",
			"frame_030.gif",
			"frame_031.gif",
			"frame_032.gif",
			"frame_033.gif",
			"frame_034.gif",
			"frame_035.gif",
			"frame_036.gif",
			"frame_037.gif",
			"frame_038.gif",
			"frame_039.gif",
			"frame_040.gif",
			"frame_041.gif",
			"frame_042.gif",
			"frame_043.gif",
			"frame_044.gif",
			"frame_045.gif",
			"frame_046.gif",
			"frame_047.gif",
			"frame_048.gif",
			"frame_049.gif",
			"frame_050.gif",
			"frame_051.gif",
			"frame_052.gif",
			"frame_053.gif",
			"frame_054.gif",
			"frame_055.gif",
			"frame_056.gif",
			"frame_057.gif",
			"frame_058.gif",
			"frame_059.gif"};
	private Icon[] kecleonMotionIcon = {new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[0])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[1])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[2])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[3])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[4])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[5])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[6])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[7])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[8])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[9])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[10])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[11])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[12])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[13])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[14])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[15])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[16])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[17])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[18])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[19])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[20])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[21])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[22])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[23])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[24])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[25])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[26])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[27])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[28])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[29])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[30])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[31])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[32])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[33])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[34])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[35])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[36])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[37])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[38])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[39])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[40])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[41])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[42])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[43])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[44])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[45])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[46])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[47])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[48])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[49])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[50])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[51])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[52])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[53])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[54])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[55])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[56])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[57])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[58])),
			new ImageIcon(getClass().getResource("kecleon_motion/"+kecleonMotionImage[59]))};
	
	//type images and icons
	private final String[] typeImg = {"normal.png",
			"grass.png",
			"fire.png",
			"water.png",
			"fight.png",
			"flying.png",
			"poison.png",
			"ground.png",
			"rock.png",
			"bug.png",
			"ghost.png",
			"electric.png",
			"psychic.png",
			"ice.png",
			"dragon.png",
			"dark.png",
			"steel.png",
			"fairy.png"};
	private Icon[] typeIcon = {new ImageIcon(getClass().getResource("type_img/"+typeImg[0])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[1])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[2])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[3])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[4])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[5])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[6])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[7])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[8])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[9])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[10])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[11])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[12])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[13])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[14])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[15])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[16])),
			new ImageIcon(getClass().getResource("type_img/"+typeImg[17]))};
	private ArrayList<JCheckBox> chckbxSelectOneArray = new ArrayList<JCheckBox>();
	private ArrayList<JCheckBox> chckbxSelectTwoArray = new ArrayList<JCheckBox>();
	
	
	//variables for battle panel
	private Game gameApp;
	private JPanel panelBattle;
	private JLabel lblKecleonBattle1;
	private JLabel lblKecleonBattle2;
	private ArrayList<JButton> moveOneButtonArray = new ArrayList<JButton>();
	private ArrayList<JButton> moveTwoButtonArray = new ArrayList<JButton>();
	private JTextArea textBattleLog;
	private JScrollPane scrollBattleLog;
	
	//player ones move slot
	private JButton btnBattleMoveOneFirst;
	private JButton btnBattleMoveOneSecond;
	private JButton btnBattleMoveOneThird;
	private JButton btnBattleMoveOneFourth;
	private JButton btnCancelMoveOne;
	
	//player twos move slot
	private JButton btnBattleMoveTwoFirst;
	private JButton btnBattleMoveTwoSecond;
	private JButton btnBattleMoveTwoThird;
	private JButton btnBattleMoveTwoFourth;
	private JButton btnCancelMoveTwo;
	
	//type that is each selected
	private int selectedMoveOne = -1;
	private int selectedMoveTwo = -1;
	
	//player HPs
	private JLabel lblPlayerOneHP;
	private JLabel lblPlayerTwoHP;
	private int[] hitpoints = new int[2];
	
	//array of string that holds the battle log
	private ArrayList<String> battleLog;

	
	private JButton btnPlayAgain;
	private JButton btnQuit;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appFrame frame = new appFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public appFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		
		//main panel to initiate the game
		panelMain = new JPanel();
		contentPane.add(panelMain, "name_11398316503332");
		panelMain.setLayout(null);
		
		//button creates a Game object to start a new game
		//moves to selection panel
		btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMain.setVisible(false);
				panelSelection.setVisible(true);
				panelBattle.setVisible(false);
				gameApp = new Game();
				dollars = gameApp.getDollar();
				lblPlayerOneDollar.setText(String.valueOf(dollars[0]));
				lblPlayerTwoDollar.setText(String.valueOf(dollars[1]));
				if (dollars[0] >= 50)
					btnUseSuperPotionOne.setVisible(true);
				else
					btnUseSuperPotionOne.setVisible(false);
				if (dollars[1] >= 50)
					btnUseSuperPotionTwo.setVisible(true);
				else
					btnUseSuperPotionTwo.setVisible(false);
				hitpoints = gameApp.getHitPoints();
				lblPlayerOneSelectionHP.setText(String.valueOf(hitpoints[0]));
				lblPlayerTwoSelectionHP.setText(String.valueOf(hitpoints[1]));
				timerSelectionAnimation.start();
			}
		});
		btnContinue.setBounds(265, 430, 200, 30);
		panelMain.add(btnContinue);
		
		
		
		
		//panel for selecting moves & heal
		panelSelection = new JPanel();
		contentPane.add(panelSelection, "name_11398340859753");
		panelSelection.setLayout(null);
		
		//add four selected moves to their each players and kecleons move slot
		//moves to battle panel
		btnBegin = new JButton("Begin");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] passArrayInOne = new int[4];
				int[] passArrayInTwo = new int[4];
				panelMain.setVisible(false);
				panelSelection.setVisible(false);
				panelBattle.setVisible(true);
				timerSelectionAnimation.stop();
				timerBattleAnimation.start();
				for (int i=0;i<4;i++) {
					moveOneButtonArray.get(i).setIcon(typeIcon[moveSetOneArray.get(i)]);
					moveOneButtonArray.get(i).setName(String.valueOf(moveSetOneArray.get(i)));
					moveOneButtonArray.get(i).setVisible(true);
					passArrayInOne[i] = moveSetOneArray.get(i);
					
					moveTwoButtonArray.get(i).setIcon(typeIcon[moveSetTwoArray.get(i)]);
					moveTwoButtonArray.get(i).setName(String.valueOf(moveSetTwoArray.get(i)));
					moveTwoButtonArray.get(i).setVisible(true);
					passArrayInTwo[i] = moveSetTwoArray.get(i);
				}
				btnCancelMoveOne.setVisible(false);
				btnCancelMoveTwo.setVisible(false);
				gameApp.assignMoves(passArrayInOne, passArrayInTwo);
				hitpoints = gameApp.getHitPoints();
				lblPlayerOneHP.setText(String.valueOf(hitpoints[0]));
				lblPlayerTwoHP.setText(String.valueOf(hitpoints[1]));
			}
		});
		btnBegin.setBounds(265, 430, 200, 30);
		panelSelection.add(btnBegin);
		btnBegin.setVisible(false);
		
		//kecleon animation labels
		lblKecleon1 = new JLabel("");
		lblKecleon1.setBounds(14, 12, 102, 134);
		panelSelection.add(lblKecleon1);
		
		lblKecleon2 = new JLabel("");
		lblKecleon2.setBounds(606, 12, 102, 134);
		panelSelection.add(lblKecleon2);
		
		lblNewLabel = new JLabel("Select Four Moves");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(217, 34, 300, 24);
		panelSelection.add(lblNewLabel);
		
		//moves back to the main panel
		btnBack = new JButton("Back to Main");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(true);
				panelSelection.setVisible(false);
				panelBattle.setVisible(false);
				timerSelectionAnimation.stop();
			}
		});
		btnBack.setBounds(265, 400, 200, 27);
		panelSelection.add(btnBack);
		
		JLabel label = new JLabel("HP:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(160, 71, 39, 18);
		panelSelection.add(label);
		
		//player 1s hit point
		lblPlayerOneSelectionHP = new JLabel("P1 HP");
		lblPlayerOneSelectionHP.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerOneSelectionHP.setForeground(new Color(139, 0, 0));
		lblPlayerOneSelectionHP.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPlayerOneSelectionHP.setBounds(213, 70, 107, 18);
		panelSelection.add(lblPlayerOneSelectionHP);
		
		JLabel label_2 = new JLabel("VS");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(330, 71, 62, 18);
		panelSelection.add(label_2);
		
		//player 2s hit point
		lblPlayerTwoSelectionHP = new JLabel("P2 HP");
		lblPlayerTwoSelectionHP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlayerTwoSelectionHP.setForeground(new Color(139, 0, 0));
		lblPlayerTwoSelectionHP.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPlayerTwoSelectionHP.setBounds(406, 71, 107, 18);
		panelSelection.add(lblPlayerTwoSelectionHP);
		
		JLabel label_4 = new JLabel(":HP");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setBounds(527, 71, 39, 18);
		panelSelection.add(label_4);
		
		JLabel lblDollar = new JLabel("Dollar:");
		lblDollar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDollar.setBounds(130, 102, 69, 18);
		panelSelection.add(lblDollar);
		
		//player 1s dollar
		lblPlayerOneDollar = new JLabel("P1 $");
		lblPlayerOneDollar.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerOneDollar.setForeground(Color.ORANGE);
		lblPlayerOneDollar.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPlayerOneDollar.setBounds(213, 101, 107, 18);
		panelSelection.add(lblPlayerOneDollar);
		
		//player 2s dollar
		lblPlayerTwoDollar = new JLabel("P2 $");
		lblPlayerTwoDollar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlayerTwoDollar.setForeground(Color.ORANGE);
		lblPlayerTwoDollar.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPlayerTwoDollar.setBounds(406, 101, 107, 18);
		panelSelection.add(lblPlayerTwoDollar);
		
		JLabel lbldollar = new JLabel(":Dollar");
		lbldollar.setHorizontalAlignment(SwingConstants.LEFT);
		lbldollar.setBounds(527, 101, 62, 18);
		panelSelection.add(lbldollar);
		
		//spends player 1s dollar to use a super potion
		btnUseSuperPotionOne = new JButton("Use a Super Potion");
		btnUseSuperPotionOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameApp.useSuperPotion(0);
				dollars[0] -= 50;
				hitpoints = gameApp.getHitPoints();
				lblPlayerOneSelectionHP.setText(String.valueOf(hitpoints[0]));
				lblPlayerOneDollar.setText(String.valueOf(dollars[0]));
				if (dollars[0] < 50)
					btnUseSuperPotionOne.setVisible(false);
			}
		});
		btnUseSuperPotionOne.setBounds(11, 432, 163, 27);
		panelSelection.add(btnUseSuperPotionOne);
		
		JLabel lblNewLabel_1 = new JLabel("Super Potion = $50");
		lblNewLabel_1.setBounds(14, 404, 160, 18);
		panelSelection.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("Super Potion = $50");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(548, 405, 160, 18);
		panelSelection.add(label_1);
		
		//spends player 2s dollar to use a super potion
		btnUseSuperPotionTwo = new JButton("Use a Super Potion");
		btnUseSuperPotionTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameApp.useSuperPotion(1);
				dollars[1] -= 50;
				hitpoints = gameApp.getHitPoints();
				lblPlayerTwoSelectionHP.setText(String.valueOf(hitpoints[1]));
				lblPlayerTwoDollar.setText(String.valueOf(dollars[1]));
				if (dollars[1] < 50)
					btnUseSuperPotionTwo.setVisible(false);
			}
		});
		btnUseSuperPotionTwo.setBounds(545, 433, 163, 27);
		panelSelection.add(btnUseSuperPotionTwo);
		
		//add four empty labels those will hold the selected moves
		int moveYPos = 155;
		for (int i=0;i<4;i++) {
			lblMoveOne = new JLabel("");
			lblMoveOne.setBounds(14, moveYPos, 90, 30);
			moveOneArray.add(lblMoveOne);
			panelSelection.add(lblMoveOne);
			
			lblMoveTwo = new JLabel("");
			lblMoveTwo.setBounds(618, moveYPos, 90, 30);
			moveTwoArray.add(lblMoveTwo);
			panelSelection.add(lblMoveTwo);
			
			moveYPos += 33;
		}
		
		//add 36 checkboxes and 18 labels for move selections
		int xPos = 150;
		int yPos = 165;
		int chckbxX = 123;
		int chckbxY = 167;
		int chckbxX2 = 245;
		int typeImgNum = 0;
		for (int i=0;i<3;i++) {
			for (int j=0;j<6;j++) {
				final JLabel lblTypeLabel = new JLabel("");
				lblTypeLabel.setBounds(xPos, yPos, 90, 30);
				lblTypeLabel.setIcon(typeIcon[typeImgNum]);
				panelSelection.add(lblTypeLabel);
				yPos += 40;
				typeImgNum++;
				
				final JCheckBox chckbxSelectOne = new JCheckBox("");
				//whenever a checkbox is clicked, it searches through all to see which checkboxes are checked and updates
				//the move selection label accordingly
				chckbxSelectOne.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						moveSetOneArray.clear();
						numOfSelectedOne = 0;
						for (int i=0;i<moveOneArray.size();i++) {
							moveOneArray.get(i).setIcon(null);
						}
						
						int moveNum = 0;
						for (int i=0;i<chckbxSelectOneArray.size();i++) {
							if (chckbxSelectOneArray.get(i).isSelected()) {
								moveOneArray.get(moveNum).setIcon(typeIcon[i]);
								moveSetOneArray.add(i);
								moveNum++;
								numOfSelectedOne++;
							}
							if (numOfSelectedOne == 4) {
								for (int j=0; j<chckbxSelectOneArray.size();j++) {
									if (!chckbxSelectOneArray.get(j).isSelected())
										chckbxSelectOneArray.get(j).setEnabled(false);
								}
							}
							else if (numOfSelectedOne == 3) {
								for (int j=0; j<chckbxSelectOneArray.size();j++) {
									chckbxSelectOneArray.get(j).setEnabled(true);
								}
							}
							if (numOfSelectedOne == 4 && numOfSelectedTwo == 4)
								btnBegin.setVisible(true);
							else
								btnBegin.setVisible(false);
						}
					}
				});
				chckbxSelectOne.setBounds(chckbxX, chckbxY, 25, 27);
				panelSelection.add(chckbxSelectOne);
				chckbxSelectOneArray.add(chckbxSelectOne);
				
				//whenever a checkbox is clicked, it searches through all to see which checkboxes are checked and updates
				//the move selection label accordingly
				final JCheckBox chckbxSelectTwo = new JCheckBox("");
				chckbxSelectTwo.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						moveSetTwoArray.clear();
						numOfSelectedTwo = 0;
						for (int i=0;i<moveTwoArray.size();i++) {
							moveTwoArray.get(i).setIcon(null);
						}
						
						int moveNum = 0;
						for (int i=0;i<chckbxSelectTwoArray.size();i++) {
							if (chckbxSelectTwoArray.get(i).isSelected()) {
								moveTwoArray.get(moveNum).setIcon(typeIcon[i]);
								moveSetTwoArray.add(i);
								moveNum++;
								numOfSelectedTwo++;
							}
							if (numOfSelectedTwo == 4) {
								for (int j=0; j<chckbxSelectTwoArray.size();j++) {
									if (!chckbxSelectTwoArray.get(j).isSelected())
										chckbxSelectTwoArray.get(j).setEnabled(false);
								}
							}
							else if (numOfSelectedTwo == 3) {
								for (int j=0; j<chckbxSelectTwoArray.size();j++) {
									chckbxSelectTwoArray.get(j).setEnabled(true);
								}
							}
							if (numOfSelectedOne == 4 && numOfSelectedTwo == 4)
								btnBegin.setVisible(true);
							else
								btnBegin.setVisible(false);
						}
					}
				});
				chckbxSelectTwo.setBounds(chckbxX2, chckbxY, 25, 27);
				panelSelection.add(chckbxSelectTwo);
				chckbxSelectTwoArray.add(chckbxSelectTwo);
				chckbxY += 40;
			}
			xPos += 165;
			yPos = 165;
			chckbxX += 165;
			chckbxX2 += 165;
			chckbxY = 167;
		}
		
		
		
		
		
		//panel for battle
		panelBattle = new JPanel();
		contentPane.add(panelBattle, "name_11398364014568");
		panelBattle.setLayout(null);
		
		//kecleon animation
		lblKecleonBattle1 = new JLabel("");
		lblKecleonBattle1.setBounds(14, 12, 102, 134);
		panelBattle.add(lblKecleonBattle1);
		
		//kecleon animation
		lblKecleonBattle2 = new JLabel("");
		lblKecleonBattle2.setBounds(606, 12, 102, 134);
		panelBattle.add(lblKecleonBattle2);
		
		
		//player ones move buttons
		//all four will update the selectedMoveOne accordingly to their each names
		btnBattleMoveOneFirst = new JButton("");
		btnBattleMoveOneFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedMoveOne = Integer.parseInt(btnBattleMoveOneFirst.getName());
				for(int i=0;i<moveOneButtonArray.size();i++)
					moveOneButtonArray.get(i).setVisible(false);
				btnCancelMoveOne.setVisible(true);
				
				if (selectedMoveOne != -1 && selectedMoveTwo != -1) {
					btnCancelMoveOne.setVisible(false);
					btnCancelMoveTwo.setVisible(false);
					playGame();
				}
			}
		});
		btnBattleMoveOneFirst.setBounds(14, 155, 90, 30);
		moveOneButtonArray.add(btnBattleMoveOneFirst);
		panelBattle.add(btnBattleMoveOneFirst);
		
		btnBattleMoveOneSecond = new JButton("");
		btnBattleMoveOneSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMoveOne = Integer.parseInt(btnBattleMoveOneSecond.getName());
				for(int i=0;i<moveOneButtonArray.size();i++)
					moveOneButtonArray.get(i).setVisible(false);
				btnCancelMoveOne.setVisible(true);
				
				if (selectedMoveOne != -1 && selectedMoveTwo != -1) {
					btnCancelMoveOne.setVisible(false);
					btnCancelMoveTwo.setVisible(false);
					playGame();
				}
			}
		});
		btnBattleMoveOneSecond.setBounds(14, 188, 90, 30);
		moveOneButtonArray.add(btnBattleMoveOneSecond);
		panelBattle.add(btnBattleMoveOneSecond);
		
		btnBattleMoveOneThird = new JButton("");
		btnBattleMoveOneThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMoveOne = Integer.parseInt(btnBattleMoveOneThird.getName());
				for(int i=0;i<moveOneButtonArray.size();i++)
					moveOneButtonArray.get(i).setVisible(false);
				btnCancelMoveOne.setVisible(true);
				
				if (selectedMoveOne != -1 && selectedMoveTwo != -1) {
					btnCancelMoveOne.setVisible(false);
					btnCancelMoveTwo.setVisible(false);
					playGame();
				}
			}
		});
		btnBattleMoveOneThird.setBounds(14, 221, 90, 30);
		moveOneButtonArray.add(btnBattleMoveOneThird);
		panelBattle.add(btnBattleMoveOneThird);
		
		btnBattleMoveOneFourth = new JButton("");
		btnBattleMoveOneFourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMoveOne = Integer.parseInt(btnBattleMoveOneFourth.getName());
				for(int i=0;i<moveOneButtonArray.size();i++)
					moveOneButtonArray.get(i).setVisible(false);
				btnCancelMoveOne.setVisible(true);
				
				if (selectedMoveOne != -1 && selectedMoveTwo != -1) {
					btnCancelMoveOne.setVisible(false);
					btnCancelMoveTwo.setVisible(false);
					playGame();
				}
			}
		});
		btnBattleMoveOneFourth.setBounds(14, 254, 90, 30);
		moveOneButtonArray.add(btnBattleMoveOneFourth);
		panelBattle.add(btnBattleMoveOneFourth);
		
		
		
		//player twos move buttons
		//all four will update the selectedMoveOne accordingly to their each names
		btnBattleMoveTwoFirst = new JButton("");
		btnBattleMoveTwoFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMoveTwo = Integer.parseInt(btnBattleMoveTwoFirst.getName());
				for(int i=0;i<moveTwoButtonArray.size();i++)
					moveTwoButtonArray.get(i).setVisible(false);
				btnCancelMoveTwo.setVisible(true);
				
				if (selectedMoveOne != -1 && selectedMoveTwo != -1) {
					btnCancelMoveOne.setVisible(false);
					btnCancelMoveTwo.setVisible(false);
					playGame();
				}
			}
		});
		btnBattleMoveTwoFirst.setBounds(618, 155, 90, 30);
		moveTwoButtonArray.add(btnBattleMoveTwoFirst);
		panelBattle.add(btnBattleMoveTwoFirst);
		
		btnBattleMoveTwoSecond = new JButton("");
		btnBattleMoveTwoSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMoveTwo = Integer.parseInt(btnBattleMoveTwoSecond.getName());
				for(int i=0;i<moveTwoButtonArray.size();i++)
					moveTwoButtonArray.get(i).setVisible(false);
				btnCancelMoveTwo.setVisible(true);
				
				if (selectedMoveOne != -1 && selectedMoveTwo != -1) {
					btnCancelMoveOne.setVisible(false);
					btnCancelMoveTwo.setVisible(false);
					playGame();
				}
			}
		});
		btnBattleMoveTwoSecond.setBounds(618, 188, 90, 30);
		moveTwoButtonArray.add(btnBattleMoveTwoSecond);
		panelBattle.add(btnBattleMoveTwoSecond);
		
		btnBattleMoveTwoThird = new JButton("");
		btnBattleMoveTwoThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMoveTwo = Integer.parseInt(btnBattleMoveTwoThird.getName());
				for(int i=0;i<moveTwoButtonArray.size();i++)
					moveTwoButtonArray.get(i).setVisible(false);
				btnCancelMoveTwo.setVisible(true);
				
				if (selectedMoveOne != -1 && selectedMoveTwo != -1) {
					btnCancelMoveOne.setVisible(false);
					btnCancelMoveTwo.setVisible(false);
					playGame();
				}
			}
		});
		btnBattleMoveTwoThird.setBounds(618, 221, 90, 30);
		moveTwoButtonArray.add(btnBattleMoveTwoThird);
		panelBattle.add(btnBattleMoveTwoThird);
		
		btnBattleMoveTwoFourth = new JButton("");
		btnBattleMoveTwoFourth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMoveTwo = Integer.parseInt(btnBattleMoveTwoFourth.getName());
				for(int i=0;i<moveTwoButtonArray.size();i++)
					moveTwoButtonArray.get(i).setVisible(false);
				btnCancelMoveTwo.setVisible(true);
				
				if (selectedMoveOne != -1 && selectedMoveTwo != -1) {
					btnCancelMoveOne.setVisible(false);
					btnCancelMoveTwo.setVisible(false);
					playGame();
				}
			}
		});
		btnBattleMoveTwoFourth.setBounds(618, 254, 90, 30);
		moveTwoButtonArray.add(btnBattleMoveTwoFourth);
		panelBattle.add(btnBattleMoveTwoFourth);
		
		
		//undo player ones move choice
		btnCancelMoveOne = new JButton("Undo");
		btnCancelMoveOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedMoveOne = -1;
				btnCancelMoveOne.setVisible(false);
				for (int i=0;i<moveOneButtonArray.size();i++)
					moveOneButtonArray.get(i).setVisible(true);
			}
		});
		btnCancelMoveOne.setBounds(14, 312, 130, 40);
		panelBattle.add(btnCancelMoveOne);
		
		//undo player twos move choice
		btnCancelMoveTwo = new JButton("Undo");
		btnCancelMoveTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedMoveTwo = -1;
				btnCancelMoveTwo.setVisible(false);
				for (int i=0;i<moveOneButtonArray.size();i++)
					moveTwoButtonArray.get(i).setVisible(true);
			}
		});
		btnCancelMoveTwo.setBounds(578, 312, 130, 40);
		panelBattle.add(btnCancelMoveTwo);
		
		
		
		
		//moves back to the selection panel with the previous battle datas preserved
		btnPlayAgain = new JButton("Back to Selection");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMain.setVisible(false);
				panelSelection.setVisible(true);
				panelBattle.setVisible(false);
				timerBattleAnimation.stop();
				timerSelectionAnimation.start();
				textBattleLog.setText(null);
				hitpoints = gameApp.getHitPoints();
				for (int i=0;i<hitpoints.length;i++) {
					if (hitpoints[i] <= 0) {
						gameApp.revive();
						dollars[i] = 0;
					}
					else {
						gameApp.gainDollar(i, 75);
						dollars = gameApp.getDollar();
					}
				}
				lblPlayerOneDollar.setText(String.valueOf(dollars[0]));
				lblPlayerTwoDollar.setText(String.valueOf(dollars[1]));
				if (dollars[0] >= 50)
					btnUseSuperPotionOne.setVisible(true);
				else
					btnUseSuperPotionOne.setVisible(false);
				if (dollars[1] >= 50)
					btnUseSuperPotionTwo.setVisible(true);
				else
					btnUseSuperPotionTwo.setVisible(false);
				hitpoints = gameApp.getHitPoints();
				lblPlayerOneSelectionHP.setText(String.valueOf(hitpoints[0]));
				lblPlayerTwoSelectionHP.setText(String.valueOf(hitpoints[1]));
				selectedMoveOne = -1;
				selectedMoveTwo = -1;
			}
		});
		btnPlayAgain.setBounds(225, 430, 150, 30);
		panelBattle.add(btnPlayAgain);
		
		
		//Displays battle log
		textBattleLog = new JTextArea();
		textBattleLog.setBounds(225, 12, 300, 340);
		textBattleLog.setEditable(false);
		scrollBattleLog = new JScrollPane (textBattleLog, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBattleLog.setSize(300, 340);
		scrollBattleLog.setLocation(225, 12);
		panelBattle.add(scrollBattleLog);
		DefaultCaret caret = (DefaultCaret)textBattleLog.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		//shuts the program down
		btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(375, 430, 150, 30);
		panelBattle.add(btnQuit);
		
		//player ones hit point
		lblPlayerOneHP = new JLabel("P1 HP");
		lblPlayerOneHP.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPlayerOneHP.setForeground(new Color(139, 0, 0));
		lblPlayerOneHP.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerOneHP.setBounds(225, 377, 107, 18);
		panelBattle.add(lblPlayerOneHP);
		
		//player twos hit point
		lblPlayerTwoHP = new JLabel("P2 HP");
		lblPlayerTwoHP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlayerTwoHP.setForeground(new Color(139, 0, 0));
		lblPlayerTwoHP.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPlayerTwoHP.setBounds(418, 378, 107, 18);
		panelBattle.add(lblPlayerTwoHP);
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);
		lblVs.setBounds(342, 378, 62, 18);
		panelBattle.add(lblVs);
		
		JLabel lblHp = new JLabel("HP:");
		lblHp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHp.setBounds(172, 378, 39, 18);
		panelBattle.add(lblHp);
		
		JLabel lblhp = new JLabel(":HP");
		lblhp.setHorizontalAlignment(SwingConstants.LEFT);
		lblhp.setBounds(539, 378, 39, 18);
		panelBattle.add(lblhp);
	}
	
	//timerhandler for kecleon animation
	private class selectionTimerHandler implements ActionListener {
		@Override public void actionPerformed(ActionEvent actionEvent) {
			doTick();
		}
	}
	
	//timerhandler for kecleon animation on battle panel 
	private class battleAnimationTimerHandler implements ActionListener {
		@Override public void actionPerformed(ActionEvent actionEvent) {
			battleAnimationTick();
		}
	}
	
	//updates kecleon animation on selection panel
	private void doTick() {
		lblKecleon1.setIcon(kecleonMotionIcon[animationImgNum]);
		lblKecleon2.setIcon(kecleonMotionIcon[animationImgNum]);
		animationImgNum = (animationImgNum+1)%60;
	}
	
	//updates kecleon animation on battle panel
	private void battleAnimationTick() {
		lblKecleonBattle1.setIcon(kecleonMotionIcon[animationImgNum]);
		lblKecleonBattle2.setIcon(kecleonMotionIcon[animationImgNum]);
		animationImgNum = (animationImgNum+1)%60;
	}
	
	//method for clicking undo button for player one
	public void undoOne() {
		selectedMoveOne = -1;
		btnCancelMoveOne.setVisible(false);
		for (int i=0;i<moveOneButtonArray.size();i++)
			moveOneButtonArray.get(i).setVisible(true);
	}
	
	//method for clicking undo button for player two
	public void undoTwo() {
		selectedMoveTwo = -1;
		btnCancelMoveTwo.setVisible(false);
		for (int i=0;i<moveTwoButtonArray.size();i++)
			moveTwoButtonArray.get(i).setVisible(true);
	}
	
	//plays a single turn of game
	private void playGame() {
		battleLog = gameApp.battle(selectedMoveOne, selectedMoveTwo);
		timerBattle.start();
		hitpoints = gameApp.getHitPoints();
	}
	
	//timer for battle log speed
	private int logIndex = 0;
	final int BATTLE_DELAY = 1000;
	private Timer timerBattle = new Timer(BATTLE_DELAY, new battleTimerHandler());
	private class battleTimerHandler implements ActionListener {
		@Override public void actionPerformed(ActionEvent actionEvent) {
			singleTurn();
		}
	}
	
	//updates the battle log for single turn
	private void singleTurn() {
		textBattleLog.append(battleLog.get(logIndex));
		logIndex++;
		if (logIndex == battleLog.size()) {
			logIndex = 0;
			textBattleLog.append("\n\n");
			timerBattle.stop();
			updateHP();
		}
	}
	
	//updates both players hit points
	private void updateHP() {
		lblPlayerOneHP.setText(String.valueOf(hitpoints[0]));
		lblPlayerTwoHP.setText(String.valueOf(hitpoints[1]));
		if (hitpoints[0] <= 0 || hitpoints[1] <= 0) {
			btnCancelMoveOne.setVisible(false);
			btnCancelMoveTwo.setVisible(false);
		}
		else {
			undoOne();
			undoTwo();
		}
	}
}
