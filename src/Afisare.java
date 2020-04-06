import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Afisare extends JFrame{
    private JList list;
    private static String[] candidati=new String[100];

    public Afisare(Repo r, String s)
    {


        super(s);
        this.setSize(400, 400);
        this.setLocation(600, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        candidati[0]="Id Prenume, Nume    CNP     NB NPB  disciplina NA MA Sala";
        for(int i=0; i<r.getSize(); i++)
            candidati[i+1]=r.getCandidat(i).toString();

        list=new JList(candidati);
        list.setVisibleRowCount(20);
        add(new JScrollPane(list));
    }
}