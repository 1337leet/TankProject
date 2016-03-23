package mainGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class GUI extends JFrame {
	
	public GUI() {
		
		JFrame gameFrame = new JFrame();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(new Dimension(800, 600));
		gameFrame.setResizable(false);
		gameFrame.setTitle("Copyright © 1337");
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		gameFrame.setContentPane(mainPanel);
		
		// Image //
		JLabel imgIcon = new JLabel(new ImageIcon("media/hex.gif"));
		imgIcon.setBounds(0, 0, 800, 600);
		
		// Label //
		
		JLabel title = new JLabel("Tank Simulator 2016");
		title.setForeground(Color.WHITE);
		title.setBounds(150, 75, 800, 100);
		title.setFont(new Font("Bebas Neue", Font.PLAIN, 72));
		
		// Exit Button //
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setBounds(50, 400, 700, 75);
		exitBtn.setFont(new Font("Bebas Neue", Font.PLAIN, 36));
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitBtn.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				exitBtn.setFont(new Font("Bebas Neue", Font.BOLD, 48));
			}

			@Override
			public void focusLost(FocusEvent e) {
				exitBtn.setFont(new Font("Bebas Neue", Font.PLAIN, 36));
			}
		});
		
		// Play Button //
		
		JButton playBtn = new JButton("Play");
		playBtn.setBounds(50, 300, 700, 75);
		playBtn.setFont(new Font("Bebas Neue", 1, 48));
		playBtn.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				playBtn.setFont(new Font("Bebas Neue", Font.BOLD, 48));
			}

			@Override
			public void focusLost(FocusEvent e) {
				playBtn.setFont(new Font("Bebas Neue", Font.PLAIN, 36));
			}
		});
		playBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
			}
		});
		
		// Add Components to Panel //
		
		mainPanel.add(title);
		mainPanel.add(exitBtn);
		mainPanel.add(playBtn);
		mainPanel.add(imgIcon);
		
		gameFrame.setVisible(true);
		
		// Play Menu Music //
		try {
			AudioInputStream as = AudioSystem.getAudioInputStream(new File("media/cool.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(as);
			clip.start();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}

public class MainGame {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		GUI gameFrame = new GUI();
	}

}