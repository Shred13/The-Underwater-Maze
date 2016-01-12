//I made all the arrow keys and the Pause Buttons
//The Main Menu Picture was photoshopped from  http://galleryhip.com/orca-killer-whale-clipart.html (Killer Whale)
//and the underwater temple from http://disney.wikia.com/wiki/Sofia_the_First:_The_Floating_Palace
//I took the wave from https://www.google.ca/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0CAYQjB0&url=http%3A%2F%2Fbergconsulting.com.au%2FBerg_Consulting_Blog%2Ftag%2FCirque_de_Soleil_Blue_Ocean_Strategy%2F&ei=pbW9VNeCF4GdNpSwgKgO&bvm=bv.83829542,d.eXY&psig=AFQjCNGY8xTjevJvDoSJGQCs9pda62aDog&ust=1421805342877059
// and then photoshopped it to make it darker for the deep ocean. For the bubbles I used it from https://www.google.ca/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0CAYQjB0&url=http%3A%2F%2Fimgkid.com%2Funderwater-bubble.shtml&ei=8rW9VIiVE4KXgwSEkYPABw&bvm=bv.83829542,d.eXY&psig=AFQjCNFOeav3AyhkJ9sSosOCArkgvtQwJw&ust=1421805390934490
// and then again edited in PaintBrush for the other bubbles. For the loser killer whale I screenshootted a whale from http://img0.liveinternet.ru/images/attach/c/5/3970/3970473_sprite198.swf
//and edited a royal crown from https://www.google.ca/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0CAYQjB0&url=http%3A%2F%2Fpixgood.com%2Fcrown-transparent-background.html&ei=np-9VLymH8yfgwTP5oLwCw&psig=AFQjCNG0ydgZ5WVY_J8KKPFAZc_qywgNTA&ust=1421799685626125
// I then got a happy whale from https://www.google.ca/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0CAYQjB0&url=http%3A%2F%2Fwww.deviantart.com%2Fmorelikethis%2Fcollections%2F438797167%3Fview_mode%3D2&ei=Q6u9VMOODsSdNriYgcAB&psig=AFQjCNH4VVNdS8IhknsVzKRs7qEvc17voA&ust=1421802528496728
// and then inserted the treasure chest from https://www.google.ca/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0CAYQjB0&url=http%3A%2F%2Fwww.wpclipart.com%2Fmoney%2Ftreasure%2Ftreasure_2%2Ftreasure_chest_gold.png.html&ei=iba9VNrgF5LjggS51YPwBQ&bvm=bv.83829542,d.eXY&psig=AFQjCNGUSzOyU4Ufj3Ojb8W1qMyImX4mTA&ust=1421805574543597
// The music is Destiny Day by Kevin Macleod (http://incompetech.com/music/royalty-free/?feels%5B%5D=Bright&Search=Search)
import java.applet.Applet; 
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;
public class thegame extends Applet implements ActionListener, KeyListener
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//timer for music and pausing/playing it
	int countP = 0;
	//size of the grid
    int row = 20;
    JLabel a[] = new JLabel [row * row];
    Panel p_card;
    //Different Screen cards
    Panel card1, card2, card3, card4, card5;
    CardLayout cdLayout = new CardLayout ();
    //All my levels, 1=shallow water, 2=deep water, 3=Right Air Current, 4=Start, 5=End, 6=Left Air Current, 8=Final End
    int map1 [][] = {{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 2, 1, 1, 1, 2, 2, 2, 2, 2, 2}, {2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2, 2, 3, 2}, {2, 2, 1, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2}, {2, 1, 3, 1, 1, 2, 2, 1, 1, 1, 3, 1, 1, 2, 2, 2, 2, 2, 1, 2}, {2, 4, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 2}, {2, 1, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2}, {2, 1, 2, 2, 1, 2, 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2}, {2, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 3, 1, 1, 1, 2, 1, 2, 1, 2}, {2, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 2, 1, 2, 3, 2, 1, 2}, {2, 2, 1, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2}, {2, 2, 1, 2, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2}, {2, 2, 1, 1, 3, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2}, {2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2}, {2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2}, {2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 5, 1, 1, 1, 2}, {2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2}, {2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
    int map2 [][] = {{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 1, 1, 1, 1, 3, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2}, {2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 3, 2, 2, 2, 2, 1, 1, 2, 2}, {2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 2, 1, 2, 2}, {2, 2, 1, 2, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 2, 1, 2, 1, 1, 2}, {2, 1, 1, 2, 2, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 2}, {2, 2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2}, {2, 1, 1, 2, 2, 1, 2, 1, 2, 1, 1, 4, 1, 1, 1, 1, 2, 2, 1, 2}, {2, 2, 1, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 3, 2}, {2, 3, 1, 1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2}, {2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 1, 2, 1, 3, 2, 2, 1, 1, 1, 2}, {2, 1, 1, 2, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 2, 2, 2}, {2, 2, 1, 1, 2, 2, 2, 1, 1, 2, 2, 5, 2, 1, 2, 2, 1, 2, 2, 2}, {2, 2, 2, 1, 2, 1, 2, 3, 2, 1, 1, 1, 2, 1, 2, 2, 1, 1, 3, 2}, {2, 2, 2, 1, 2, 1, 2, 1, 2, 3, 2, 2, 1, 3, 2, 1, 2, 2, 1, 2}, {2, 2, 1, 3, 2, 1, 2, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2}, {2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 1, 1, 2}, {2, 2, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2}, {2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 1, 2, 1, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
    int map3 [][] ={{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}, {2,1,1,1,1,1,2,2,2,2,2,2,2,2,1,1,1,1,1,2}, {2,2,1,2,2,1,1,1,1,1,1,1,1,1,1,2,2,2,1,2}, {2,1,4,1,1,2,2,1,2,2,2,2,2,2,2,2,2,2,1,2}, {2,2,1,2,1,2,2,2,2,1,1,1,2,1,1,1,1,1,1,2}, {2,3,1,2,1,2,1,1,1,1,2,1,2,1,2,2,1,2,1,2}, {2,2,2,2,1,2,2,1,2,2,1,1,2,2,2,2,1,2,3,2}, {2,1,1,1,1,2,2,1,2,2,1,2,1,1,1,2,1,2,1,2}, {2,1,2,2,2,2,1,1,2,1,3,2,1,2,1,1,2,1,1,2}, {2,3,2,1,1,1,1,2,2,2,1,1,1,2,2,3,1,2,2,2}, {2,1,2,1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2}, {2,1,1,1,1,1,1,3,1,1,1,2,1,3,1,2,2,1,1,2}, {2,2,1,2,2,2,2,2,2,2,1,2,1,2,1,2,2,2,1,2}, {2,1,1,1,1,2,1,2,1,2,1,2,1,2,1,1,1,1,1,2}, {2,2,3,2,1,1,1,1,1,1,3,1,1,1,2,2,3,2,2,2}, {2,1,1,2,2,2,2,2,1,2,2,1,2,1,1,2,1,1,2,2}, {2,2,1,2,1,1,1,2,3,2,2,1,3,2,1,1,2,1,3,2}, {2,1,1,1,1,2,1,1,1,1,1,2,2,1,2,1,1,2,1,2}, {2,2,2,2,2,2,2,2,2,2,1,3,1,1,2,2,5,2,2,2}, {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
    int map4 [][] = {{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}, {2,1,1,1,1,1,1,3,1,1,1,1,6,2,2,2,2,2,2,2}, {2,2,1,1,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,2}, {2,1,1,2,6,4,1,1,1,1,1,1,2,2,3,2,2,2,1,2}, {2,1,2,2,2,1,2,2,2,2,2,1,1,1,1,3,1,2,1,2}, {2,2,2,1,2,1,3,1,1,1,1,1,2,2,2,2,2,2,1,2}, {2,2,1,1,2,2,2,2,2,2,2,2,2,2,1,2,2,2,1,2}, {2,2,1,2,2,1,1,1,1,1,1,1,1,6,1,2,2,2,1,2}, {2,2,1,1,1,1,2,2,2,2,2,2,1,2,1,1,1,1,1,2}, {2,1,1,2,2,2,2,2,2,2,2,2,1,2,2,2,1,1,1,2}, {2,2,1,2,1,1,1,1,3,1,1,1,2,2,2,2,2,2,2,2}, {2,1,1,1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2}, {2,2,2,2,2,1,1,1,1,1,2,3,2,1,1,1,1,1,6,2}, {2,2,1,2,2,1,2,2,2,1,2,1,2,1,2,2,2,2,1,2}, {2,1,6,2,2,1,2,1,2,1,2,1,2,3,2,2,1,1,1,2}, {2,1,2,1,1,1,2,1,2,6,2,6,1,1,2,2,3,2,2,2}, {2,1,2,1,2,1,2,1,2,1,2,2,2,2,2,1,1,1,1,2}, {2,1,1,1,2,6,5,1,2,1,1,1,1,1,1,6,2,2,1,2}, {2,2,2,2,2,2,1,2,2,2,1,2,2,1,2,1,2,1,1,2}, {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
    int map5 [][] = {{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,2,2,2},{2,2,1,1,1,2,2,1,2,1,2,2,2,1,2,2,1,1,1,2},{2,2,2,1,2,1,2,1,2,1,1,1,1,1,1,1,2,2,1,2},{2,1,1,1,1,3,2,5,2,2,6,2,2,2,2,1,2,2,1,2},{2,2,1,2,2,1,2,2,2,1,1,2,2,1,6,1,1,1,1,2},{2,1,1,2,1,1,1,1,2,1,2,2,2,2,2,2,2,2,1,2},{2,1,2,2,2,2,2,1,2,1,1,1,1,1,3,1,1,1,1,2},{2,1,2,1,1,1,2,1,1,2,2,1,2,1,2,1,2,2,2,2},{2,1,1,1,2,2,2,2,3,1,1,1,2,1,2,1,1,1,2,2},{2,2,2,1,6,1,1,2,1,2,2,2,2,2,2,1,2,1,2,2},{2,2,2,2,2,2,1,2,1,1,2,2,2,1,1,1,2,6,1,2},{2,1,1,3,1,1,1,2,2,6,2,1,2,3,2,2,1,1,2,2},{2,2,1,2,2,2,2,2,2,1,2,1,2,1,2,2,1,2,1,2},{2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,2,1,2},{2,2,1,2,2,2,2,2,2,2,2,1,2,2,2,1,1,1,1,2},{2,2,1,2,1,1,1,1,1,1,1,2,2,2,2,1,2,1,2,2},{2,2,1,1,1,2,2,1,2,2,1,2,2,1,1,1,2,1,2,2},{2,2,2,2,2,1,1,1,1,2,1,4,1,1,2,2,1,1,1,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
    int map6 [][]= {{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,1,8,1,1,2,1,1,1,1,3,1,1,1,2,2,1,1,1,2},{2,2,1,2,1,1,1,2,2,2,2,2,2,1,1,1,2,2,1,2},{2,2,1,2,2,2,2,2,6,2,2,1,1,2,2,1,1,2,1,2},{2,2,1,2,1,1,1,1,1,2,1,1,2,2,6,2,1,3,1,2},{2,2,1,1,1,2,2,1,2,2,6,2,2,2,1,2,2,1,2,2},{2,2,2,2,2,2,2,1,2,1,1,1,1,1,1,1,2,1,2,2},{2,1,1,2,1,1,1,1,2,2,2,2,1,2,1,2,1,1,2,2},{2,1,2,1,6,2,1,2,2,1,3,1,1,2,6,2,1,2,1,2},{2,1,2,2,2,2,1,2,1,1,2,2,1,2,2,1,1,2,1,2},{2,1,1,1,1,2,1,2,1,2,1,1,1,1,1,1,2,1,1,2},{2,1,2,2,1,2,2,3,1,2,1,2,1,2,2,2,2,2,1,2},{2,1,2,2,1,2,2,1,2,1,1,2,1,1,1,3,1,2,1,2},{2,1,2,2,6,1,1,1,2,1,2,2,2,2,2,2,2,2,1,2},{2,1,1,2,2,2,2,2,2,1,2,6,1,1,1,1,1,2,1,2},{2,2,3,2,2,1,1,1,2,1,2,1,2,2,1,2,1,1,1,2},{2,2,1,2,1,2,2,1,1,1,1,1,1,2,1,1,2,2,1,2},{2,2,1,2,1,2,2,2,2,2,2,2,2,2,2,2,1,2,1,2},{2,1,1,1,1,1,1,1,6,1,1,3,1,1,1,1,1,1,4,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
    int level =1;
    //Help tell the players which level they are on
    JLabel levels; 
    //How many moves the player can move
    int move = 400;
    //Help to enable certain parts of the grid
    int newr= 0;
    int newc = 0;
    //Tracker, c=column, r=row
    int c = 1;
    int r = 5;
    //For the Whale Pictures
    char dir = 'U';
    //Timer for the game
    Timer timer;
    //Directions and Pauses in game
    JButton up;
    JButton down;
    JButton right;
    JButton left;
    JButton Pause;
    JButton Pause2;
    JButton Pause3;
    //The timer on screen
    JTextField timeLeft = new JTextField(3);
    JButton start;
    String hoursString, minutesString,secondsString;
    //getting music
    AudioClip soundFile;
    int minutes= 5,seconds= 0;
    //for the loading bar in the beginning
    JProgressBar progressBar;
    // moves in the redraw
    JLabel m;
    //The loading bar in the beginning of the game
    public thegame(){
    JFrame frame = new JFrame ();	
    JProgressBar loading = new JProgressBar();
    loading.setStringPainted(true);
    frame.setSize(500,80);
    frame.getContentPane().add(loading);
    frame.setDefaultCloseOperation(0);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    for (int x=0; x<10; x++){
    	try {
    		Thread.sleep(250);
    		loading.setValue(loading.getValue()+10);
    		}
    		catch(Exception e){
    			
    		}
    		
    	}
    frame.dispose();
    }
	public void init ()
	{

		//Music for the game
		soundFile = getAudioClip (getDocumentBase (), "DestinyDay.wav");
		soundFile.loop ();	   
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	screen1 ();
	screen2 (); 
	screen3 ();
	resize (1230, 975);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }
	//The Main Menu
	public void screen1 ()
    { 
		Pause = new JButton  (createImageIcon("Pause.jpg"));
		Pause.addActionListener(this);
		Pause.setActionCommand ("Pause");
	card1 = new Panel ();
	card1.setBackground (Color.blue);
	JLabel home = new JLabel (createImageIcon ("underwater temple copy.jpg"));
	JButton Enter = new JButton ("Enter the Labrynth Here");
	Enter.addKeyListener(this);
	Enter.addActionListener (this);
	Enter.setActionCommand ("2");
	JButton instruct = new JButton ("Instructions");
	instruct.addActionListener (this);
	instruct.setActionCommand ("instruct");
	new Panel ();
	card1.add (Pause);
	card1.add (home);
	card1.add (Enter);
	card1.add (instruct);
	p_card.add ("1", card1);
    }
	//The instructions
    public void screen3 ()
    {
    	Pause2 = new JButton  (createImageIcon("Pause.jpg"));
		Pause2.addActionListener(this);
		Pause2.setActionCommand ("Pause");
	card3 = new Panel ();
	setBackground (Color.cyan);
	JButton back = new JButton ("Main Menu");
	back.addActionListener (this);
	back.setActionCommand ("1");
	JLabel title = new JLabel ("The Instructions");
	title.setFont (new Font ("Comic Sans", Font.BOLD, 72));
	title.setForeground (Color.yellow);
	JButton Enter = new JButton ("Enter the Labrynth Here");
	Enter.addKeyListener(this);
	Enter.addActionListener (this);
	Enter.setActionCommand ("2");
	JLabel Beginning = new JLabel ("Help Okar the Orca - the king of Orcas get the treasure by leading him through the maze. He will not be able to go through any deep waters ");
	JLabel water = new JLabel  (createImageIcon("2.jpg"));
	JLabel b2 = new JLabel ("but he can go anywhere else. To move around use the arrow key on the bottom");
	JLabel arrow = new JLabel (createImageIcon("Up.jpg"));
	JLabel arrow2 = new JLabel (createImageIcon("Left.jpg"));
	JLabel arrow3 = new JLabel (createImageIcon("Right.jpg"));
	JLabel arrow4 = new JLabel (createImageIcon("Down .jpg"));
	JLabel b3 = new JLabel ("Or after pressing one of the arrow key buttons, you can also use the arrow keys on the keyboard. REMEMBER TO PRESS THE BUTTONS ON SCREEN FIRST TO ACTIVATE THE KEYS ON KEYBOARD");
	JLabel b4 = new JLabel ("There are also some air currents King Okar can use to move around faster. The left air current ");
	JLabel arrow5 = new JLabel (createImageIcon("6.jpg"));
	JLabel b5 = new JLabel ("makes him travel anywhere randomly from 0 to 5 squares to the left. Similarily the right air current");
	JLabel arrow6 = new JLabel (createImageIcon ("3.jpg"));
	JLabel b6 = new JLabel ("makes him move between 0 to 5 squares to the right.");
	JLabel b7 = new JLabel ("Since Okar cannot keep his breath forever underwater, after 250 moves he will need to take a breathe causing him to restart his journey");
	JLabel b8 = new JLabel ("If you ever get stuck, simply press the reset button on the bottom to go back to the beginning of the level. ");
	JLabel b9 = new JLabel ("By the way, to pause the music, just press the pause button and press it again to restart it. Good Luck Helping Okar!");
	card3.add (title);
	card3.add (Pause2);
	card3.add(Beginning);
	card3.add(water);
	card3.add (b2);
	card3.add(arrow);
	card3.add(arrow2);
	card3.add(arrow3);
	card3.add(arrow4);
	card3.add (b3);
	card3.add (b4);
	card3.add (arrow5);
	card3.add(b5);
	card3.add (arrow6);
	card3.add(b6);
	card3.add (b7);
	card3.add (b8);
	card3.add (b9);
	card3.add (Enter);
	card3.add (back);
	p_card.add ("instruct", card3);
    }
    //To redraw the screen after each move to show where the player is in the maze
    public void redraw ()
    {
	int m = 0;
	for (int i = 0 ; i < 20 ; i++)
	{
	    for (int j = 0 ; j < 20 ; j++)
	    {
		a [m].setIcon (createImageIcon (map1 [i] [j] + ".jpg"));
		m++;
	    }
	}
	a [r * 20 + c].setIcon (createImageIcon ("w" + dir + ".jpg"));
    
    }
    //The Grids/Maze
    public void screen2 ()
    {
    	//Pauses the music
    	Pause3 = new JButton  (createImageIcon("Pause.jpg"));
		Pause3.addActionListener(this);
		Pause3.setActionCommand ("Pause");
		Pause3.addKeyListener(this);
		//Shows the player how many moves they have left
    	m=new JLabel ("You have " +move + " moves left."); 
    	m.setFont (new Font ("Comic Sans", Font.BOLD, 35));
		m.setForeground (Color.white);
    level = 1;  
	card2 = new Panel ();
	setBackground (Color.cyan);
	JButton back = new JButton ("Main Menu");
	back.addActionListener (this);
	back.setActionCommand ("1");
	Panel g = new Panel (new GridLayout (row, row));
	for (int i = 0 ; i < a.length ; i++)
	{
	    a [i] = new JLabel (createImageIcon ("1.jpg"));
	    a [i].setPreferredSize (new Dimension (38, 38));
	    g.add (a [i]);
	}
		//Shows which level the player is in
		levels = new JLabel ("You are in level " + level); 
		levels.setFont (new Font ("Comic Sans", Font.BOLD, 40));
		levels.setForeground (Color.green);
		//All the different moving buttons
	 down = new JButton (createImageIcon("Down .jpg"));
	down.setActionCommand ("Down");
	down.addActionListener (this);
	down.addKeyListener(this);
	down.setSize(36,36);
	
	up = new JButton (createImageIcon("Up.jpg"));
	up.addActionListener (this);
	up.setActionCommand ("Up");
	up.addKeyListener(this);
	up.setSize(36,36);
	
	left = new JButton (createImageIcon("Left.jpg"));
	left.addActionListener (this);
	left.setActionCommand ("Left");
	left.addKeyListener(this);
	left.setSize(36,36);

	 right = new JButton (createImageIcon("Right.jpg"));
	right.addActionListener (this);
	right.setActionCommand ("Right");
	right.addKeyListener(this);
	right.setSize(36,36);
	
	//resets the game if player wishes to
	JButton reset = new JButton ("Reset");
	reset.addActionListener (this);
	reset.addKeyListener(this);
	reset.setActionCommand ("reset");

	JButton instruct = new JButton ("Instructions");
	instruct.addActionListener (this);
	instruct.setActionCommand ("instruct");	
	//repositions the whale for te beginning
	r=5;
	c=1;
	redraw(); //or redraw() or whatever)
	timeLeft.setText("00:00");
	card2.add (g);
	card2.add (timeLeft);
	card2.add(Pause3);
	card2.add (levels);
	card2.add (m);
	card2.add (up);
	card2.add (left);
	card2.add (right);
	card2.add (down);
	card2.add (instruct);
	card2.add (back);
	card2.add (reset);
	p_card.add ("2", card2);
    }
    //If the player fails, they will come here
    public void failure ()
    {
    	card4 = new Panel ();
    	JLabel Fail = new JLabel ("You Lost.");
    	Fail.setFont (new Font ("Comic Sans", Font.BOLD, 72));
    	Fail.setForeground (Color.RED);
    	JLabel sW = new JLabel  (createImageIcon("wS.png"));
    	setBackground (Color.cyan);
    	JButton back = new JButton ("Main Menu");
    	back.addActionListener (this);
    	back.setActionCommand ("1");
    	card4.add(Fail);
    	card4.add (back);
    	card4.add(sW);
    	p_card.add("4", card4);
    	cdLayout.show(p_card,"4");    	
    }
    //If the player wins they will come here
    public void winner ()
    {
    	card5 = new Panel ();
    	JLabel WIN = new JLabel ("You Won!");
    	WIN.setFont (new Font ("Comic Sans", Font.BOLD, 72));
    	WIN.setForeground (Color.GREEN);
    	JLabel sW = new JLabel  (createImageIcon("ww.png"));
    	int winner = (500-move);
    	new JLabel ("It only took "+ winner + " for you to win!");
    	setBackground (Color.cyan);
    	JButton back = new JButton ("Main Menu");
    	back.addActionListener (this);
    	back.setActionCommand ("1");
    	card5.add(WIN);
    	card5.add (back);
    	card5.add(sW);
    	p_card.add("5", card5);
    	cdLayout.show(p_card,"5");    	
    }
   
    public void actionPerformed (ActionEvent e)
     {
    	//To the main menu
	if (e.getActionCommand ().equals ("1"))
	{
		cdLayout.show (p_card, "1");
	
		
	}
	//To the game
	else if (e.getActionCommand ().equals ("2"))
	{  
	if (level==1)
	{
		for(int i=0; i<20; i++)
		{for(int j=0; j<20; j++)
			map1[i][j]=map1[i][j];
			}
	}
		else if (level==2)
		{
			for(int i=0; i<20; i++)
			{for(int j=0; j<20; j++)
				map2[i][j]=map1[i][j];
				}
		}
			else if (level==3)
			{
				for(int i=0; i<20; i++)
				{for(int j=0; j<20; j++)
					map3[i][j]=map1[i][j];
					}
			}
				else if (level==4)
				{
					for(int i=0; i<20; i++)
					{for(int j=0; j<20; j++)
						map4[i][j]=map1[i][j];
						}
				}
					else 	if (level==5)
					{
						for(int i=0; i<20; i++)
						{for(int j=0; j<20; j++)
							map5[i][j]=map1[i][j];
						}
					}
						else 
						{
							for(int i=0; i<20; i++)
							{for(int j=0; j<20; j++)
								map6[i][j]=map1[i][j];
								}
						}
		move=500;
		screen2();
		cdLayout.show (p_card, "2");
		resize (1465,975); 
		Time();
		minutes = 7;
		seconds=50;
		timer = new Timer(1000, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				seconds--;
				//minute to second converter
				if(seconds == 0 && minutes != 0){
					minutes--;
					seconds = 59;
				}

				if (seconds == 0 &&minutes ==0 )
				{
					timer.stop();
					JOptionPane.showMessageDialog(null,"Time over!");
					failure();	
				}	
				if(seconds <10 && seconds >=0){
					secondsString= "0"+seconds;
				}
				else{
					secondsString=("" +seconds);
				}
				if(minutes <10 && seconds >=0){
					minutesString=("0"+minutes);
				}
				else{
					minutesString=("" +minutes);
				}
				
				timeLeft.setText(minutesString + ":" +secondsString);			
			}	
			 }
			);
		timer.start();		
	}
	//To go to the instructions
	else if (e.getActionCommand ().equals ("instruct"))
	    cdLayout.show (p_card, "instruct");
	//To stop and play the music
	else if (e.getActionCommand ().equals ("Pause"))
	{
		countP++;
	if (countP %2==1)
	{
		soundFile.stop ();
		Pause.setIcon (createImageIcon("Start.jpg"));
		Pause2.setIcon (createImageIcon("Start.jpg"));
		Pause3.setIcon (createImageIcon("Start.jpg"));	
	}
	
		else
		{
	soundFile.loop();
	Pause.setIcon (createImageIcon("Pause.jpg"));
	Pause2.setIcon (createImageIcon("Pause.jpg"));
	Pause3.setIcon (createImageIcon("Pause.jpg"));
		}		
    }
    //All the different move buttons ingame
	else if (e.getActionCommand ().equals ("Down"))
	{ 
		portal (newr, newc);
	portalr (newr, newc);
	move--;
	if (move==0)
	{
		failure();
	}
	else
	{
	m.setText ("You have " + move + " moves left");
	    if (tracker (r + 1, c))
	    {
		dir = 'D';
		r++;
		redraw ();
	    }
	}
	}    
	
	else if (e.getActionCommand ().equals ("Up"))
	{    portal (newr, newc);
	portalr (newr, newc);
	move--;
	m.setText ("You have " + move + " moves left");
	if (move==0)
	{
		failure();
	}
	else
	{
	    if (tracker (r - 1, c))
	    {
		dir = 'U';
		r--;
		redraw ();
	    }
	}
	}
	else if (e.getActionCommand ().equals ("Left"))
	{    portal (newr, newc);
	move--;
	m.setText ("You have " + move + " moves left");
	if (move==0)
	{
		failure();
	}
	else
	{
	portalr (newr, newc);
	    if (tracker (r, c - 1))
	    {
		dir = 'L';
		c--;
		redraw ();
	    }
	}
	}
	else if (e.getActionCommand ().equals ("Right"))
	{
		
	    portal (newr, newc);
	    portalr (newr, newc);
	    move--;
		m.setText ("You have " + move + " moves left");
		if (move==0)
		{
			failure();
		}
		else
		{
	    if (tracker (r, c + 1))
	    {
		dir = 'R';
		c++;
		redraw ();
	    }
		}
	}
	//To reset the game if the player wishes to
	else if (e.getActionCommand ().equals ("reset"))
	{
		move--;
		m.setText ("You have " + move + " moves left");
		if (move==0)
		{
			failure();
		}
		if (level == 1)
		{
			r=5;
			c=1;
			redraw ();
		}
		else if (level == 2)
		{
			r=7;
			c=11;
			redraw ();
		}
		else if (level == 3)
		{
			r=3;
			c=2;
			redraw ();
		}
		else if (level == 4)
		{
			r=3;
			c=5;
			redraw ();
		}
		else if (level == 5)
		{
			r=18;
			c=11;
			redraw ();
		}
		else if (level == 6)
		{ 
			r=18;
			c=18;
			redraw ();
		}
	}
	//To bring the player across the different levels when they reach a specific point on the grid
	 if (c == 15 &&r==16 && level ==1)
	{
		for(int i=0; i<20; i++)
		{for(int j=0; j<20; j++)
			map1[i][j]=map2[i][j];
		
		}
		level = 2;
		r=7;
		c=11;
		redraw();
	}
	
	 else if (c==11 && r==12 && level ==2)
	 {		 
				for(int i=0; i<20; i++)
				{for(int j=0; j<20; j++)
					map1[i][j]=map3[i][j];
	 }
		level = 3;
		r=3;
		c=2;
		redraw();
	}
	 else if (c==16 && r==18 && level ==3)
	 {		 
				for(int i=0; i<20; i++)
				{for(int j=0; j<20; j++)
					map1[i][j]=map4[i][j];
	 }
		level = 4;
		r=3;
		c=5;
		redraw();
	}
	 else if (c==6 && r==17 && level ==4)
			
	 {
	 {		 
				for(int i=0; i<20; i++)
				{for(int j=0; j<20; j++)
					map1[i][j]=map5[i][j];
	 }
		level = 5;                 
		c=11;
		r=18;
		redraw();
	}
			}
	 else if (c==7 && r==4 && level ==5)
			{
	 {		 
				for(int i=0; i<20; i++)
				{for(int j=0; j<20; j++)
					map1[i][j]=map6[i][j];
	 }
		level = 6;                 
		c=18;
		r=18;
		redraw();
		
	}
			}
	 else if (c==2 && r == 2 && level ==6)
	 {
		 winner();
	 }
	 showStatus ("Made by Shredded Developments");
	 levels.setText ("You are now in level " + level +"!");
					}
    //First portal/air current
public void portal (int newr, int newc)
{ 
	if (map1 [newr] [newc] == 3)    
	  {
			dir = 'L';
			c=c+5;
			redraw ();
		    }

	}
//Second portal/air current
public void portalr (int newr, int newc)
{
	if (map1 [newr] [newc] == 6)    
	  {
			dir = 'R';
			c=c-5;
			redraw ();
	  }
		    	
}
//The timer
	public void Time()
	{
		new Timer(1000, new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				seconds++;
				System.out.print(seconds); 
				
			}
			
		}); };
	
//To ensure the player cannot go on the deep water
    public boolean tracker (int newr, int newc)
    { //newr is the place you want to go
    	if (map1 [newr] [newc] == 6)
    	 {
			int x = 0 + ((int) (Math.random () * 6));
			c=c-x;
			redraw ();
		    }		
    	
	if (map1 [newr] [newc] == 3)
	  {
			int x = 0 + ((int) (Math.random () * 6));
			c=c+x;
			redraw ();
		    }
    {
	if (map1 [newr] [newc] == 2)
	    return false;
	else
	    return true;
    }
	}
    

//The images method
    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = thegame.class.getResource (path);
	if (imgURL != null)
	    return new ImageIcon (imgURL);
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    

  
   }
//All the keyListeners
	public void keyTyped(KeyEvent ke) {
		
	}
	public void keyPressed(KeyEvent ke) {
		if (move == 0)
			   failure();
    int keyint = ke.getKeyCode();
    if(keyint == 38)
    {
	up.doClick();
    }   
    if(keyint == 39)
    {
	right.doClick();
    }   
    if(keyint == 37)
    {
	left.doClick();
    }   
    if(keyint == 40)
    {
	down.doClick();
    }   
    
    }
	public void keyReleased(KeyEvent e) {
		
	}
}



