import javax.swing.*; 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;


public class A  {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
   // private static final int W = 1000, H =800;
    int Nx=20,Ny=5,Nz=10;

    VectorField E,B;

    private Pane pane;

    A() {
        pane = new Pane(Nx,Ny,Nz,new Color(128,128,128),5);
       // B = new Pane(Nx,Ny,Nz);
        new PaneFrame(pane);
      //  new PaneFrame(B);
        E = new VectorField(Nx,Ny,Nz);
        B = new VectorField(Nx,Ny,Nz);

        E.randomInit();
        B.randomInit();

      //  pane.flist.add(E);
        pane.addField(E,Color.red,2);
        pane.addField(B,Color.green,2);

    }


    private void createAndShowGUI() {
        //Create and set up the window.
       // JFrame frame = new JFrame("HelloWorldSwing");
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    /*    setResizable(true);
        setVisible(true);
        setBounds(0,0,pane.w(),pane.h());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); repaint();
      */
        //Add the ubiquitous "Hello World" label.
      //  JLabel label = new JLabel("Hello World");

     //   label.setBounds(500,100,100,200);
     //   label.setVisible(true);
     //   add(label);
        //Display the window.
        //frame.pack();
        //frame.setVisible(true);


        //add(pane);
    }

    public static void main(String[] args) {

        new A();
           //  new A().createAndShowGUI();
	    //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
  //          public void run() {
    //            createAndShowGUI();
      //      }
       // });
    }
}



