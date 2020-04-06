import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewFrame extends JFrame {

    private JTextField textField3;
    private JPanel panel;
    private JButton adaugareCandidatButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private Candidat ca=new Candidat();
    private int ok1=0, ok2=0, ok3=0, ok4=0, ok5=0, ok6=0, ok7=0;


    public NewFrame(String nume) {
        super(nume);
        this.setContentPane(panel);
        this.setSize(400, 400);
        this.setLocation(600, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        textField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cnp = textField3.getText();   //receive input from text field
                ca.setCnp(cnp);
                ok1=1;
            }
        });

        textField4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String mediebac = textField4.getText();
                    ca.setMedieBac(Double.valueOf(mediebac));
                    ok2=1;
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, "Media este formata din cifre... incerca din nou");
                }
            }
        });

        textField5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String notabac = "";
                try {
                    notabac = textField5.getText();
                    double medie = Double.valueOf(notabac);
                    if (medie < 1.00 || medie > 10.00)
                        JOptionPane.showMessageDialog(null, medie, "Notele sunt de la 1 la 10.", JOptionPane.PLAIN_MESSAGE);
                    else {ca.setNotaProbaBac(medie);
                    ok3=1;}
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, notabac, "Asta nu e un numar.", JOptionPane.PLAIN_MESSAGE);
                }
            }

        });
        textField6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField6.getText();
                if (input.equals("matematica") || input.equals("informatica"))
                {ca.setDisciplina(input);
                    ok4=1;}
                else JOptionPane.showMessageDialog(null, "Disciplinele sunt matematica/informatica.");
            }
        });

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int ok=0;
            String input=textField1.getText();
            String nume=input;
            char[] ch=input.toCharArray();
            for(int i=0;i<ch.length;i++){
                    if(ch[i]>='0' && ch[i]<='9')
                         ok=1;
            }
            if(ok==1)
                JOptionPane.showMessageDialog(null, "Numele nu poate fi format din cifre.");
            else {ok5=1; ca.setNume(nume);};

            }

        });
        textField2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int ok=0;
                String input=textField2.getText();
                String prenume=input;
                char[] ch=input.toCharArray();
                for(int i=0;i<ch.length;i++){
                    if(ch[i]>='0' && ch[i]<='9')
                        ok=1;
                }
                if(ok==1)
                    JOptionPane.showMessageDialog(null, "Numele nu poate fi format din cifre.");
                else {ca.setPrenume(prenume); ok6=1;};


            }
        });
        adaugareCandidatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ok1==1 && ok2==1 && ok3==1&&ok4==1&&ok4==1&&ok6==1)
                     JOptionPane.showMessageDialog(null, "Adaugare reusita!");
                else
                    JOptionPane.showMessageDialog(null, "Adaugarea nu a putut fi efectuata!");


                setVisible(false); //you can't see me!
                dispose();//DESTROOOOY
            }
        });


        textField7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String notabac = "";
                try {
                    notabac = textField5.getText();
                    double medie = Double.valueOf(notabac);
                    if (medie < 1.00 || medie > 10.00)
                        JOptionPane.showMessageDialog(null, medie, "Notele sunt de la 1 la 10.", JOptionPane.PLAIN_MESSAGE);
                    else {ca.setNotaProbaBac(medie); ok7=1;};

                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, notabac, "Asta nu e un numar.", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    public Candidat getCandidat(){return ca;}
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
