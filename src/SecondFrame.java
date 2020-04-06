import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class SecondFrame extends JFrame {


    private JPanel pan;
    private JTable t;

    public SecondFrame(Repo r, int n, String s) throws InterruptedException {
            super(s);
            this.setVisible(true);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setSize(600, 600);
            setLayout(new FlowLayout());


             String[][] data2=new String[11][100];

               for(int i=0; i<n; i++) {
            data2[i][0]=Integer.toString(r.getCandidat(i).getId());
            data2[i][1]=r.getCandidat(i).getNume();
            data2[i][2]=r.getCandidat(i).getPrenume();
            data2[i][3]=r.getCandidat(i).getCnp();
            data2[i][4]=Double.toString(r.getCandidat(i).getMedieBac());
            data2[i][5]=Double.toString(r.getCandidat(i).getNotaProbaBac());
            data2[i][6]=r.getCandidat(i).getDisciplina();
            data2[i][7]=Double.toString(r.getCandidat(i).getNotaAdmitere());
            data2[i][8]=Double.toString(r.getCandidat(i).getMedieAdmitere());
            data2[i][9]=r.getCandidat(i).getNrSala();
            data2[i][10]=r.getCandidat(i).getAdmis();
        }


               String[] columnNames = { "ID", "Nume", "Prenume", "CNP", "MedieBac", "NotaMedieBac", "Disciplina","Nota Admitere", "Medie Admitere", "Sala", "Status"};

               t= new JTable(data2, columnNames);//  t.setBounds(30, 40, 200, 300);
       // t.getAutoResizeMode();
               t.setPreferredScrollableViewportSize(new Dimension(550, 100));
               t.setFillsViewportHeight(true);
               JScrollPane sp=new JScrollPane(t);
                 add(sp);
                 t.getAutoResizeMode();




    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
