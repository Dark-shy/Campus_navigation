package index;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 导航窗口，进行路线选择
public class navigation {
    String[] place = {"运动场", "活动中心", "工科楼", "教1~3", "教5~6",
            "图书馆", "博苑广场", "学生公寓群", "餐厅", "行政楼"};
    //地点选择框
    JComboBox<String> options1 = new JComboBox<>();
    JComboBox<String> options2 = new JComboBox<>();

    void set_navigation() {
        JFrame main = new JFrame("校园导航");
        Image a = Toolkit.getDefaultToolkit().getImage("data/R-C.jpg");
        main.setIconImage(a);
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        main.setLocation(921, 497);//窗口位置
        main.setSize(250, 325);

        JPanel root = new JPanel();
        main.setContentPane(root);
        root.setLayout(null);
        //选择项
        for (String s : place) {
            options1.addItem(s);
        }
        for (String s : place) {
            options2.addItem(s);
        }
        options1.setBounds(24, 120, 80, 30);
        options2.setBounds(134, 120, 80, 30);
        root.add(options1);
        root.add(options2);
        JLabel b = new JLabel(new ImageIcon("data/img_1.png"));
        b.setBounds(105, 125, 30, 25);
        root.add(b);
        //确认
        JButton yes = new JButton("确认");
        yes.setBounds(75, 185, 80, 30);
        yes.addActionListener(new MyActionListener());
        root.add(yes);
        main.setVisible(true);
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (options1.getSelectedIndex() == options2.getSelectedIndex()) {
                JOptionPane.showMessageDialog(null, "已在目的地");
            } else {
                Optimal_path path = new Optimal_path(options1.getSelectedIndex(), options2.getSelectedIndex(), place);
            }
        }
    }
}
