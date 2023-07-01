package index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class free {
    public static void main(String[] args) {
        JFrame main = new JFrame("校园导航");
        Image a = Toolkit.getDefaultToolkit().getImage("data/R-C.jpg");
        main.setIconImage(a);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setLocation(800, 300);//窗口位置
        main.setSize(500, 650);

        JPanel root = new JPanel();
        main.setContentPane(root);
        JLabel txt = new JLabel("校园导航系统");
        txt.setFont(new Font("宋体", Font.BOLD, 28));//字体
        root.setLayout(null);//不使用布局管理器
        txt.setBounds(150, 50, 200, 100);
        root.add(txt);
        JButton a1 = new JButton("学校地图");
        a1.setFont(new Font("楷书", Font.PLAIN, 25));
        a1.setBounds(140, 200, 200, 100);
        root.add(a1);
        a1.addActionListener(new MyActionListener());
        JButton a2 = new JButton("导航");
        a2.setFont(new Font("楷书", Font.PLAIN, 25));
        a2.setBounds(140, 350, 200, 100);
        root.add(a2);
        a2.addActionListener(new MyActionListener1());
        main.setVisible(true);
    }

    private static class MyActionListener1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            navigation a = new navigation();
            a.set_navigation();
        }
    }

    private static class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            map a = new map(0,0,null);
        }
    }
}
