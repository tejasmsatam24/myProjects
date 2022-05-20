/**********************************************************************************************
 * Name: Tejas M. Satam, Gopi Vinyas Musunuru                                                  *
 * JAVA ASSIGNMENT 04                                                                          *
 * ZID : Z1854197, Z1857015                                                                    *
 * TA: Sindhusha Parimi                                                                        *
 * Purpose: The purpose of the assignment is to understand various concepts of JAVA SWING      *
 **********************************************************************************************/


//package com.company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PDGameGUI extends JFrame implements ActionListener, ListSelectionListener {


    private final DefaultListModel<String> list = new DefaultListModel<>();
    private final JList<String> gamesList;

    private final JLabel computer_strategy_label = new JLabel("Computer Strategy");
    private final JTextField computer_strategy_text_field = new JTextField(10);


    private final JComboBox<Object> strategies_selection_combo_box;

    private int computerStrategy = 1;

    private final JLabel ask_decision_label = new JLabel("Your decision this round?");

    private final JTextArea results_Text_Area = new JTextArea(15, 30);

    private PDGame currentPDGame = null;

    private String gameStartTime = "";
    private final HashMap<String, GameStat> stats = new HashMap<>();

    private final JLabel rounds_played_label = new JLabel("Rounds Played");
    private final JTextField rounds_played_text_field = new JTextField(10);

    private final JLabel computer_strategy_lbl = new JLabel("Computer Strategy");

    private final JLabel plr_sentence_lbl = new JLabel("Player Sentence");
    private final JTextField plr_sentence_text_field = new JTextField(10);

    private final JLabel comp_sent_lbl = new JLabel("Computer Sentence");
    private final JTextField comp_sent_txt_field = new JTextField(10);

    private final JLabel win_label = new JLabel("Winner");
    private final JTextField win_txt_field = new JTextField(10);


    private final JButton start_Btn = new JButton("Start New Game");
    private final JButton silent_Btn = new JButton("Remain Silent");
    private final JButton betray_Btn = new JButton("Testify");


    public static void main(String[] args) {
        createAndShowGUI();
    }//emd main


    //This method will create the GUI
    public static void createAndShowGUI() {
        PDGameGUI frame = new PDGameGUI();
        frame.addListeners();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }//end createAndShowGUI

    //Here in this method the entire GUI is defined
    public PDGameGUI() {

        //setting title
        super("Prisoner's Dilemma ");
        currentPDGame = new PDGame("/Users/tejassatam/Desktop/PrisonersDilema/src/com/company/file.txt");
        Color c1 = new Color(211, 210, 21);
        Color c2 = new Color(200, 142, 17);

        //setting the frame layout to BorderLayout
        super.setLayout(new BorderLayout());

        //creating the left panel with BorderLayput
        JPanel left_panel = new JPanel(new BorderLayout());

        //adding the panel to the frame
        super.add(left_panel, BorderLayout.WEST);

        //crating the JList, which will be in the north of the left panel
        gamesList = new JList<>(list);

        //This list is going to hold the summary of the games
        gamesList.setFont(new Font("SansSerif", Font.PLAIN, 15));
        gamesList.setVisibleRowCount(10);
        gamesList.setFixedCellWidth(350);
        gamesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //adding this list to the north of our left panel.
        left_panel.add(new JScrollPane(gamesList), BorderLayout.NORTH);
        left_panel.setBackground(c2);

        //creating another panel that will be at the south of the left panel
        //This panel will tell us the summary of a game selected
        JPanel left_south_panel = new JPanel();

        //This panel has a grid layout, so we specify the rows and columns
        left_south_panel.setLayout(new GridLayout(5, 2, 5, 5));

        //adding the buttons and labels to this panel
        left_south_panel.add(rounds_played_label);
        left_south_panel.add(rounds_played_text_field);

        //setEditable will not let the user write into the textField
        rounds_played_text_field.setEditable(false);
        left_south_panel.add(computer_strategy_lbl);
        left_south_panel.add(computer_strategy_text_field);
        computer_strategy_text_field.setEditable(false);
        left_south_panel.add(plr_sentence_lbl);
        left_south_panel.add(plr_sentence_text_field);
        plr_sentence_text_field.setEditable(false);
        left_south_panel.add(comp_sent_lbl);
        left_south_panel.add(comp_sent_txt_field);
        comp_sent_txt_field.setEditable(false);
        left_south_panel.add(win_label);
        left_south_panel.add(win_txt_field);
        win_txt_field.setEditable(false);
        left_south_panel.setBackground(c2);

        //adding the panel to the south of our left panel
        left_panel.add(left_south_panel, BorderLayout.SOUTH);

        //creating the title border for out panel
        TitledBorder title;
        title = BorderFactory.createTitledBorder("List of Games");
        left_panel.setBorder(title);

        //Now we will create our right panel
        JPanel right_panel = new JPanel(new BorderLayout());
        super.add(right_panel, BorderLayout.EAST);

        //creating panel that will be in the north of our Right panel
        JPanel right_north_panel = new JPanel();
        //The panel has GridLayout so we specify the rows and Columns
        right_north_panel.setLayout(new GridLayout(2, 1));

        //creating another panel that will go on the above panel
        JPanel right_north_top_panel = new JPanel(new FlowLayout());
        right_north_top_panel.add(computer_strategy_label);

        //We convert the arrayList to array
        Object[] strategy_Array = currentPDGame.getStrategies().toArray();

        //adding the array to the combo box
        strategies_selection_combo_box = new JComboBox<>(strategy_Array);

        //again we will not let the user to modify the Combo Box
        strategies_selection_combo_box.setEditable(false);

        //setting the default value of the combo box
        strategies_selection_combo_box.setSelectedIndex(0);

        //adding the combo box to the panel
        right_north_top_panel.add(strategies_selection_combo_box);

        //adding the button to start game
        right_north_top_panel.add(start_Btn);
        right_north_top_panel.setBackground(c1);

        //creating another panel that eill go below the above panel
        JPanel right_north_botton_panel = new JPanel(new FlowLayout());
        right_north_botton_panel.add(ask_decision_label);
        right_north_botton_panel.setBackground(c1);

        //This panel will have two buttons where the user can choose his/her decision
        right_north_botton_panel.add(silent_Btn);
        right_north_botton_panel.add(betray_Btn);


        right_north_panel.add(right_north_top_panel);
        right_north_panel.add(right_north_botton_panel);
        right_panel.add(right_north_panel, BorderLayout.NORTH);

        //creating a scroll pane that will display the results
        right_panel.add(new JScrollPane(results_Text_Area), BorderLayout.SOUTH);
        results_Text_Area.setEditable(false);

        //at the start of the game we will disable the decision choosing options and enable only the start game option
        betray_Btn.setEnabled(false);
        silent_Btn.setEnabled(false);
        start_Btn.setEnabled(true);
    }//end PDGameGUI()

    //adding actionListeners to each button
    public void addListeners() {
        start_Btn.addActionListener(this);
        silent_Btn.addActionListener(this);
        betray_Btn.addActionListener(this);
        strategies_selection_combo_box.addActionListener(this);
        gamesList.addListSelectionListener(this);
    }//end addListeners


    //This method will implement the actions depending on what button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start_Btn) {
            startGame();
        } else if (e.getSource() == silent_Btn) {
            silent_clicked();
        } else if (e.getSource() == betray_Btn) {
            betray();
        } else if (e.getSource() == strategies_selection_combo_box) {
            //getting the selected strategy
            computerStrategy = strategies_selection_combo_box.getSelectedIndex() + 1;
        }
    }//end actionPerformed

    //here we will get the summary of the selected game
    @Override
    public void valueChanged(ListSelectionEvent e) {
        String searchGame;
        if (!gamesList.isSelectionEmpty()) {

            //as we set the hash map, we will use the time and date as the key
            searchGame = (String) gamesList.getSelectedValue();
            GameStat gameStatsInfo;
            gameStatsInfo = stats.get(searchGame);
            rounds_played_text_field.setText(Integer.toString(gameStatsInfo.getRounds()));
            int plr_years = gameStatsInfo.getUserSentence();
            plr_sentence_text_field.setText(String.format("%d %s", plr_years, " years"));
            int comp_years = gameStatsInfo.getCompSentence();
            comp_sent_txt_field.setText(String.format("%d %s", comp_years, " years"));
            String compStrategy = gameStatsInfo.getCompStrategy();
            computer_strategy_text_field.setText(String.format("%s", compStrategy));
            String win = gameStatsInfo.getWinner();
            win_txt_field.setText(String.format("%s", win));
        }
    }//end valueChanged


    //This method will be called when the start game button is clicked
    public void startGame() {

        //get the input file
        currentPDGame = new PDGame("/Users/tejassatam/Desktop/PrisonersDilema/src/com/company/file.txt");
        currentPDGame.setStrategy(computerStrategy);
        gameStartTime = (new Date()).toString();
        results_Text_Area.append("***  NEW  GAME ***\n");
        silent_Btn.setEnabled(true);
        betray_Btn.setEnabled(true);
        start_Btn.setEnabled(false);
        displayOptions();
    }//end startGame

    //This functiom will be called when the user selects the to remain silent
    public void silent_clicked() {
        String roundResult = currentPDGame.playRound(1);
        results_Text_Area.append(roundResult + "\n");

        //check if we are done with 5 rounds or not
        if (currentPDGame.getStats().getRounds() == 5) {
            endGame();
        } else {
            displayOptions();
        }
    }//end silent_clicked

    // This method is executed when the user chooses to Betray
    public void betray() {
        String roundResult = currentPDGame.playRound(2);
        results_Text_Area.append(roundResult + "\n");
        if (currentPDGame.getStats().getRounds() == 5) {
            endGame();
        } else {
            displayOptions();
        }
    }//end betray

    //after start of every round we will display the options to the user
    private void displayOptions() {
        String options = "\n1. Remain Silent" + "\n" + "2. Betray your partner" + "\n\n" + "Enter your decision :\n\n";
        results_Text_Area.append(options);
    }//end displayOptions

    //This method will be called after end of 5 rounds
    private void endGame() {
        String final_Scores = currentPDGame.getScores();
        results_Text_Area.append(final_Scores + "\n");
        stats.put(gameStartTime, currentPDGame.getStats());
        list.addElement(gameStartTime);
        betray_Btn.setEnabled(false);
        silent_Btn.setEnabled(false);
        start_Btn.setEnabled(true);
    }//end endGame
}