package uabc.edu.mx.gui.desktop;

import uabc.edu.mx.libreria.Lugar;
import uabc.edu.mx.libreria.Objeto;
import uabc.edu.mx.libreria.Posicion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

public class EspacioApplication extends JDialog {
    private Lugar miLugar = new Lugar("Mi lugar");
    private Random random = new Random();
    private JPanel contentPane;

    private JButton buttonAddObject;
    private JPanel panelPrincipal;



    public EspacioApplication() {
        setContentPane(contentPane);
        setModal(true);


        buttonAddObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Objeto unObjeto = new Objeto("miObjeto" + random.nextInt(10000), new Posicion(random.nextInt(1000),random.nextInt(500)), miLugar);
                miLugar.getLosObjetos().add(unObjeto);
                System.out.print(miLugar);

                Image image = null;
                try {
                    image = ImageIO.read(new File("mouse.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                panelPrincipal.getGraphics().clearRect(0,0, 1000, 500);

                for (int i = 0; i < miLugar.getLosObjetos().size(); i++) {
                    //panelPrincipal.getGraphics().drawRect(miLugar.getLosObjetos().get(i).getLaPosicion().getX(), miLugar.getLosObjetos().get(i).getLaPosicion().getY(), 20, 20);
                    panelPrincipal.getGraphics().drawImage(image,miLugar.getLosObjetos().get(i).getLaPosicion().getX(), miLugar.getLosObjetos().get(i).getLaPosicion().getY(),100,100,null);
                }
            }
        });

        panelPrincipal.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Image image = null;
                try {
                    image = ImageIO.read(new File("mouse.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                panelPrincipal.getGraphics().clearRect(0,0, 1000, 500);

                for (int i = 0; i < miLugar.getLosObjetos().size(); i++) {
                    //panelPrincipal.getGraphics().drawRect(miLugar.getLosObjetos().get(i).getLaPosicion().getX(), miLugar.getLosObjetos().get(i).getLaPosicion().getY(), 20, 20);
                    panelPrincipal.getGraphics().drawImage(image,miLugar.getLosObjetos().get(i).getLaPosicion().getX(), miLugar.getLosObjetos().get(i).getLaPosicion().getY(),100,100,null);
                }
            }
        });


        panelPrincipal.addComponentListener(new ComponentAdapter() {
        });
    }

    public static void main(String[] args) {
        EspacioApplication dialog = new EspacioApplication();
        dialog.setBounds(300,100,300,100);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
