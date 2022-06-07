package front;

import back.sectionA.SituationA;
import back.sectionB.SituationB;
import back.sectionC.SituationC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JLabel label;

    public int Randomizer(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public MyFrame() {
        SituationA situationA = new SituationA();



        button1 = new JButton();
        button1.setBounds(10, 30, 120, 40);
        button1.addActionListener(e -> situationA.CreateGraph(Randomizer(18, 30), Randomizer(1, 16)));
        button1.setText("Situation A");
        button1.setFocusable(false);
        button1.setFont(new Font("Comic Sans", Font.BOLD, 17));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.GRAY);
        button1.setBorder(BorderFactory.createCompoundBorder());

        button2 = new JButton();
        button2.setBounds(10, 90, 120, 40);
        button2.addActionListener(e -> situationA.CreateGraph(18, 6));
        button2.setText("Situation B");
        button2.setFocusable(false);
        button2.setFont(new Font("Comic Sans", Font.BOLD, 16));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.GRAY);
        button2.setBorder(BorderFactory.createCompoundBorder());

        button3 = new JButton();
        button3.setBounds(10, 150, 120, 40);
        button3.addActionListener(e -> situationA.CreateGraph(18, 6));
        button3.setText("Situation C");
        button3.setFocusable(false);
        button3.setFont(new Font("Comic Sans", Font.BOLD, 16));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.GRAY);
        button3.setBorder(BorderFactory.createCompoundBorder());

        button4 = new JButton();
        button4.setBounds(10, 210, 120, 40);
        button4.addActionListener(e -> situationA.CreateGraph(18, 6));
        button4.setText("Situation D");
        button4.setFocusable(false);
        button4.setFont(new Font("Comic Sans", Font.BOLD, 16));
        button4.setForeground(Color.WHITE);
        button4.setBackground(Color.GRAY);
        button4.setBorder(BorderFactory.createCompoundBorder());

        button5 = new JButton();
        button5.setBounds(10, 270, 120, 40);
        button5.addActionListener(e -> situationA.CreateGraph(18, 6));
        button5.setText("Situation E");
        button5.setFocusable(false);
        button5.setFont(new Font("Comic Sans", Font.BOLD, 16));
        button5.setForeground(Color.WHITE);
        button5.setBackground(Color.GRAY);
        button5.setBorder(BorderFactory.createCompoundBorder());

        button6 = new JButton();
        button6.setBounds(10, 400, 120, 50);
        button6.addActionListener(e -> situationA.CleanUp());
        button6.setText("CLEAN");
        button6.setFocusable(false);
        button6.setFont(new Font("Comic Sans", Font.BOLD, 16));
        button6.setForeground(Color.WHITE);
        button6.setBackground(Color.pink);
        button6.setBorder(BorderFactory.createCompoundBorder());


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000, 500);
        this.setVisible(true);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
