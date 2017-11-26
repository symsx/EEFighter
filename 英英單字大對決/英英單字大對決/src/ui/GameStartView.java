package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameStartView extends JFrame{

	private Label player1Lab;
	private Label player2Lab;
	private Label wordDefinitionLab;
	private GridBagConstraints gbc;
	private JPanel gameViewPanel;
	
	public GameStartView() {
		super("英英單字大對決");
		setBounds(215, 80, 1100, 700);
		setupViews();
		setupLayout();
	}

	private void setupLayout() {
		getContentPane().setBackground(Color.GRAY);
		getContentPane().setLayout(new GridBagLayout());
		getContentPane().add(gameViewPanel);
		setupViewsLocation();
		setupViewsBackground();
	}
	
	private void setupViewsBackground() {
		player1Lab.setBackground(Color.gray);
		player2Lab.setBackground(Color.gray);
		wordDefinitionLab.setBackground(new Color(155, 55, 55));
	}
	
	private void setupViewsLocation() {
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		addComponent(player1Lab, 1.5, 1.0, 0, 0, 1, 2);
		addComponent(wordDefinitionLab, 3.0, 1.0, 3, 0, 2, 2);
		addComponent(player2Lab, 1.5, 1.0, 5, 0, 1, 2);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.WEST;
		addComponent(gameViewPanel, 1.0, 8.0, 0, 5, 7, 7);
	}

	private void setupViews() {
		initializeAll();
		setupGameViewPanel();
		setViewsFont(new Font(null, Font.BOLD, 20));
		setViewsSize(new Dimension(400, 100));
		setViewsText();
	}
	
	private void setViewsText() {
		player1Lab.setText("Player1: ");
		wordDefinitionLab.setText("Word defintion : ");
		player2Lab.setText("Player2: ");
	}

	private void setViewsSize(Dimension dimension) {
		player1Lab.setSize(dimension);
		player2Lab.setSize(dimension);
		wordDefinitionLab.setSize(new Dimension(100, 700));
	}

	private void setViewsFont(Font font) {
		player1Lab.setFont(font);
		player2Lab.setFont(font);
		wordDefinitionLab.setFont(font);
	}

	private void setupGameViewPanel() {
		gameViewPanel.setPreferredSize(new Dimension(1050, 650));
	}

	private void initializeAll() {
		player1Lab = new Label();
		player2Lab = new Label();
		wordDefinitionLab = new Label();
		gbc = new GridBagConstraints();
		gameViewPanel = new GameViewImp();
	}
	
	public void addComponent(Component c, Double weightX, Double weightY, int row, int column, int width, int height) {
		gbc.weightx = weightX;
		gbc.weighty = weightY;
		gbc.gridx = row;
		gbc.gridy = column;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		add(c, gbc);
	}
	
}
