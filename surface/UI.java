package surface;

import fuction.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI{
    public void surface() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("梦鸿租车系统");
        jFrame.setBounds(500, 250, 500, 400);
        jFrame.setVisible(true);
        Container conn = jFrame.getContentPane();
        conn.setLayout(null);
        JButton into = new JButton("进入");
        into.setBounds(200,150,100,30);
        JLabel L1 = new JLabel("梦鸿租车系统");
        conn.add(L1);
        L1.setBounds(200,50,100,20);
        into.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                Menu.menu();
            }
        });
        jFrame.add(into);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void menu(){
        UI ui = new UI();
        ui.surface();
    }
}
