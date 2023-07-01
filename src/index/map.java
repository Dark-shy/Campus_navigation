package index;

import javax.swing.*;
import java.awt.*;

public class map {
    int m;
    int n;
    int[] path;
    public map(int m,int n,int[] path){
        this.m = m;
        this.n = n;
        this.path=path;
        put_map();
    }
    public void put_map() {
        JFrame main = new JFrame("学校地图");
        //logo
        Image a = Toolkit.getDefaultToolkit().getImage("data/R-C.jpg");
        main.setIconImage(a);
        //点击X后
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //背景
        Image bg = new ImageIcon("data/img.png").getImage();
        draw pan=new draw(bg,m,n,path);
        main.add(pan);
        main.setLocation(800, 300);//窗口位置
        main.setSize(1024, 724);
        main.setVisible(true);
    }
}

class draw extends JPanel {
    //地点的坐标信息
    int[] x = {60, 70, 255, 320, 660, 480, 780, 900, 666, 540};
    int[] y = {130, 230, 315, 555, 555, 235, 425, 290, 144, 120};
    int m;
    int n;
    int[] path;
    Image image;

    public draw(Image image, int m, int n,int[] path) {
        this.image = image;
        this.m = m;
        this.n = n;
        this.path=path;
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,getWidth(),getHeight(), null);
        if(m!=n){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(159, 99, 140));
            Stroke stroke=new BasicStroke(5.5f);//设置线宽为3.0
            g2d.setStroke(stroke);
            int i=path[n];
            g.drawLine(x[n],y[n],x[i],y[i]);
            while (i!=m){
                g.drawLine(x[i],y[i],x[path[i]],y[path[i]]);
            i=path[i];
            }
        }
    }
}