import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JProgressBar;

import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import jaco.mp3.player.MP3Player;

public class SplashScreen extends JWindow {

	private JPanel contentPane;
	private JLabel TicTacToe;
	private JLabel lblDigitalsplashscreen = new JLabel("TicTacToeSplashScreen");
	private boolean isShowOrHide =true;
	MP3Player mp3;

	
	public static void main(String[] args) {

					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					frame.doProgress();
					frame.playMusic();
					
					
	}
					
	private Timer timer;
	private int counter=1;
	private JProgressBar progressBar = new JProgressBar();
	
	private boolean isVisible =true;
	private void doProgress(){
		ActionListener al =new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblDigitalsplashscreen.setVisible(isVisible);
				isVisible =!isVisible;
				progressBar.setValue(counter);
				if(counter>=100){
					timer.stop();
					SplashScreen.this.setVisible(false);
					SplashScreen.this.dispose();
					TicTacToe tictactoe =new TicTacToe();
					tictactoe.setVisible(true);
					
				}
				counter++;
				lblDigitalsplashscreen.setVisible(isShowOrHide);
				isShowOrHide=!isShowOrHide;
				
			}
		};
		timer =new Timer(100, al);
		timer.start();
	}
	
private void playMusic(){	
	mp3 = new MP3Player(SplashScreen.class.getResource("song.mp3"));
	mp3.play();
}	
	
	
	public SplashScreen() {
		Icon icon = new ImageIcon(SplashScreen.class.getResource("Digitalimage.gif"));
		setBounds(100, 100, 642, 508);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		TicTacToe = new JLabel("");
		TicTacToe.setForeground(Color.LIGHT_GRAY);
		TicTacToe.setFont(new Font("Tahoma", Font.BOLD, 20));
		TicTacToe.setBackground(Color.GRAY);
		TicTacToe.setIcon(icon);
		TicTacToe.setBounds(50, 11, 424, 274);
		contentPane.add(TicTacToe);
		
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.YELLOW);
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 20));
		progressBar.setBackground(Color.GREEN);
		progressBar.setBounds(30, 338, 475, 30);
		contentPane.add(progressBar);

		
		//JLabel lblDigitalsplashscreen = new JLabel("TicTacToeSplashScreen");
		lblDigitalsplashscreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigitalsplashscreen.setForeground(new Color(0, 0, 0));
		lblDigitalsplashscreen.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblDigitalsplashscreen.setBounds(50, 273, 403, 54);
		contentPane.add(lblDigitalsplashscreen);
	}
}
