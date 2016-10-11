import com.sun.prism.*;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

class P2 {
    P2(double x,double y) {this.x=(int)x; this.y=(int)y;}

    public int x,y;
}

public class Pane extends JPanel implements ActionListener{

    private JButton next;


    private Color basicColor;

    private int Nx=20,Ny=5,Nz=10;
    private int R = 5;
    private static final double SCALE = 1.5;
    private static double DX = 20*SCALE,DYz=14.142 * 2 * SCALE,DYx=11.1 * 2 * SCALE,DZ=20*SCALE;
    private static double ORIGX = 50, ORIGY = 600;
    private static final int W = 1000,H = 800;


    public int w() { return W; }
    public int h() { return H; }

    class ColorField {
        public Color c;
        public VectorField v;
        int lw;
        ColorField(VectorField v,Color c,int lw) {this.v=v;this.c=c;this.lw=lw;}
    }

    public java.util.List<ColorField> flist;

    public Pane(int nx,int ny,int nz) {
        this(nx,ny,nz,Color.black);
    }

    public Pane(int nx,int ny,int nz,Color c) {
        this(nx,ny,nz,c,5);
    }

    public Pane(int nx,int ny,int nz,Color basicColor,int radius){

        this.R = radius;
        this.basicColor = new Color(basicColor.getRed(),basicColor.getGreen(),basicColor.getBlue());

        flist = new java.util.LinkedList<ColorField>();

        Nx = nx; Ny =ny; Nz = nz;
        setBounds(0,0,W,H);
        setVisible(true);
        setLayout(null);
        repaint();

        next = new JButton("Next");
        next.setBounds((W-100)/2,H-100,100,30);
        next.addActionListener(this);
      //  add(next);

    }

    //
    //                 *
    //               /
    //ORIGY  *------*----
    //     ix*DX+iy*DY
    private P2 index2point(double ix,double iy, double iz) {
        return new P2( ix * DX + ORIGX  + iy*DYx,  ORIGY - iz*DZ - iy*DYz  );

    }

    private double layerScale(int iy) {
        return (double)(Ny-iy)/Ny;
    }


    private Color layerColor(int iy) {
        double sc = layerScale(iy);
        int R = (int)(basicColor.getRed()*sc);
        int G = (int)(basicColor.getGreen()*sc);
        int B = (int)(basicColor.getBlue()*sc);
        int A = (int)(255*sc);

        return new Color(R,G,B,A);

    }

    public void actionPerformed (ActionEvent e){
        Object source = e.getSource();
        if (source == next){
            Graphics g = this.getGraphics();
            drawing(g);
        }
    }


    private void drawFields(Graphics g) {
        java.util.Iterator<ColorField> it = flist.iterator();

        while(it.hasNext()) {
            ColorField v = it.next();
            drawVectorField(v,g);
        }

    }

    private void drawGrid(Graphics g) {
        for(int iy=Ny-1;iy>=0;iy--) {

            g.setColor(layerColor(iy) );
            int r = (int) (R * layerScale(iy));
            for(int ix=0; ix<Nx;ix++) {
                for(int iz=0;iz<Nz;iz++) {

                    P2 p2= index2point(ix,iy,iz);
                    g.fillOval(p2.x-r,p2.y-r,2*r,2*r);
                }

            }

        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
     //   g.drawRect(50,50,50,50);
     //  g.drawRect(100,50,50,50);
     //   g.drawRect(150,50,50,50);
     //   g.drawRect(200,50,50,50);
     //   g.drawRect(250,50,50,50);

        drawGrid(g);
        drawFields(g);



    }

    public void addField(VectorField v,Color c) {
        addField(v,c,5);
    }

    public void addField(VectorField v,Color c,int lw) {
        flist.add(new ColorField(v,c,lw));
    }


    private void drawVectorField(ColorField cf, Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new java.awt.BasicStroke(cf.lw));
    //    g2.draw(new java.awt.geom.Line2D.Float(30, 20, 80, 90));

        for(int iy=Ny-1;iy>=0;iy--) {

            g.setColor( new Color(cf.c.getRed(),cf.c.getGreen(),cf.c.getBlue(), (int) (255*layerScale(iy)) ) );

//
//  int r = (int) (R * layerScale(iy));
            for(int ix=0; ix<Nx;ix++) {
                for(int iz=0;iz<Nz;iz++) {
                    P3 d= cf.v.f[ix][iy][iz];
                    P2 A = index2point(ix,iy,iz);
                    P2 B = index2point(ix + d.x,iy+d.y,iz+d.z);
                    g.drawLine(A.x,A.y,B.x,B.y);
                //    P2 p2= index2point(ix,iy,iz);
                //    g.fillOval(p2.x,p2.y,r,r);
                }

            }

        }

    }

    private int times = 0;
    public void drawing(Graphics g){
        if(times<5){
            g.setColor(Color.RED);
            g.fillOval(50+times*50, 50, 50, 50);
            times++;
        }
    }

}
