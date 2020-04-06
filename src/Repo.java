import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.PrintWriter;

public class Repo {
    private Vector v=new Vector<Candidat>();
    private String sali[]={"Mihail Kogalniceanu", "Aula", "A322", "A321", "A320", "A323", "A222", "A223"};

    public Repo(){}
    public int getSize(){return v.size();}
    public Repo(Vector<Candidat> v){this.v=v;}
    public String[] getSali(){return sali;}
    public String getSala(int i){return sali[i];}

    public double citireReal(String sir){
        try{
            System.out.print(sir);
            Scanner scn = new Scanner(System.in);
            double n = scn.nextDouble();
            return n;
        }
        catch(Exception exp){	//cautam erori si apelam recursiv
            System.out.print("Nu ai introdus o valoarea buna \n");
            return citireReal(sir);
        }
    }

    public String citireString(String sir){
        try{
            System.out.print(sir);
            Scanner scn = new Scanner(System.in);
            String s= scn.nextLine();
            return s;
        }
        catch(Exception exp){	//cautam erori si apelam recursiv
            System.out.print("Nu ai introdus o valoarea buna \n");
            return citireString(sir);
        }
    }

    public Candidat citireCandidat()
    {
        Candidat c=new Candidat();
        c.setNume(citireString("Nume: "));
        c.setCnp(citireString("CNP: "));
        c.setDisciplina(citireString("Disciplina: "));
        c.setMedieBac(citireReal("Medie bac: "));
        c.setNotaProbaBac(citireReal("Nota proba bac: "));
        c.setId(v.size()+1);
        v.add(c);
        System.out.println(v);
        return c;
    }

    public void writetoFile() {
        try{
            File file=new File("Candidati.txt");
            if(!file.exists())
                file.createNewFile();

            PrintWriter pw=new PrintWriter(file);
            pw.print(citireCandidat()+"; ");
            pw.println();
            pw.close();
            System.out.println("done");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            Scanner x = new Scanner(new File("CandidatiIn.txt"));

            while (x.hasNext()) {

                String nume = x.next();
                String prenume=x.next();
                String cnp=x.next();
                String disciplina=x.next();
                double medieBac=Double.parseDouble(x.next());
                double notaProbaBac=Double.parseDouble(x.next());
                double notaad=Double.parseDouble(x.next());
                v.add(new Candidat(nume, prenume, cnp, v.size()+1, disciplina,  medieBac,notaProbaBac, notaad, 0.0,"", "" ));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Vector<Candidat> getCandidati(){return v;}
    public int getNrCandidati(){return v.size();}
    public Candidat getCandidat(int i){return (Candidat) v.get(i);}
    public void setCandidat(int i, Candidat c){this.v.set(i, c);}
    public void addCandidat(Candidat c){this.v.add(c);}


    @Override
    public String toString()
    {
        String s="";
        for(int i=0; i<v.size(); i++)
            s+=v.get(i)+"\n";
        return s;
    }

}
