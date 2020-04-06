import javax.swing.*;
import java.awt.event.*;

public class App extends JFrame{
    private JPanel mainPanel;
    private JButton inscriereButton;
    private JButton setareNoteAdmitereButton;
    private JButton button4;
    private JButton button5;
    private JButton calculMediiButton;
    private JTextField textField1;
    private Controller c=new Controller();



    public App(String nume)
    {
        super(nume);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(6000, 6000);
        this.setLocation(600, 300);
        this.pack();
        c.readFromFile();
        c.repartizareSali();
        inscriereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewFrame nf=new NewFrame("Adaugare candidat");
                if(nf.getCandidat().getNume()!="")
                {nf.getCandidat().setId(c.getSize()+1);
                c.setMedieAdmitere(nf.getCandidat());
                c.addCandidat(nf.getCandidat());}
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try { c.resortareID();
                    SecondFrame af=new SecondFrame(c.getR(),c.getSize(), "Afisare candidati dupa ID");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.sortareDupaNume();
                try {
                    SecondFrame af=new SecondFrame(c.getR(), c.getSize(), "Afisare candidati in ordine alfabetica");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setareNoteAdmitereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.sortareMedieAdmitere();
                    SecondFrame sf=new SecondFrame(c.getR(), c.getSize(), "mm");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        calculMediiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.calculMedii();
                c.listaFinala();
                JOptionPane.showMessageDialog(null, "Mediile au fost calculate!");
            }
        });
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String []args)
    {
        App frame=new App("gestiune admitere");
        frame.setVisible(true);
    }
}
