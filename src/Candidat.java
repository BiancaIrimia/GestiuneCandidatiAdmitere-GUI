import java.text.DecimalFormat;

public class Candidat {
    private String nume;
    private String prenume;
    private String cnp;
    private int id;
    private String disciplina;
    private double medieBac;
    private double notaProbaBac;
    private double notaAdmitere;
    private double medieAdmitere;
    private String admis;
    private String nrSala;
    private DecimalFormat df = new DecimalFormat("#.##");


    public Candidat(){
        this.nume="";
        this.prenume="";
        this.cnp="";
        this.id=0;
        this.disciplina="";
        this.medieBac=0;
        this.notaProbaBac=0;
        this.notaAdmitere=0;
        this.medieAdmitere=0;
        this.admis="";
        this.nrSala="";
    }

    public Candidat(String nume, String prenume, String cnp, int id, String disciplina, double medieBac, double notaProbaBac, double notaAdmitere, double medieAdmitere, String admis,String nrSala)
    {
        this.nume=nume;
        this.prenume=prenume;
        this.cnp=cnp;
        this.id=id;
        this.disciplina=disciplina;
        this.medieBac=medieBac;
        this.notaProbaBac=notaProbaBac;
        this.notaAdmitere=notaAdmitere;
        this.medieAdmitere=medieAdmitere;
        this.admis=admis;
        this.nrSala=nrSala;
    }

    public String getNume(){return nume;}
    public String getPrenume(){return prenume;}
    public String getCnp(){return cnp;}
    public int getId(){return id;}
    public String getDisciplina(){return disciplina;}
    public double getMedieBac(){return medieBac;}
    public double getNotaProbaBac(){return notaProbaBac;}
    public double getNotaAdmitere(){return notaAdmitere;}
    public double getMedieAdmitere(){return medieAdmitere;}
    public String getAdmis(){return admis;}
    public String getNrSala(){return nrSala;}

    public void setNume(String nume){this.nume=nume;}
    public void setPrenume(String prenume){this.prenume=prenume;}
    public void setCnp(String cnp){this.cnp=cnp;}
    public void setId(int id){this.id=id;}
    public void setDisciplina(String disciplina){this.disciplina=disciplina;}
    public void setMedieBac(double medieBac){this.medieBac=medieBac;}
    public void setNotaProbaBac(double notaProbaBac){this.notaProbaBac=notaProbaBac;}
    public void setNotaAdmitere(double notaAdmitere){this.notaAdmitere=notaAdmitere;}
    public void setMedieAdmitere(double medieAdmitere){this.medieAdmitere=medieAdmitere;}
    public void setAdmis(String admis){this.admis=admis;}
    public void setNrSala(String nrSala){this.nrSala=nrSala;}


    @Override
    public String toString() {
        String s="";

        s+=id+"  "+nume+ " "+prenume+" "+cnp+"  "+medieBac+"  "+ notaProbaBac+" "+disciplina+ " "+notaAdmitere+ "  "+df.format(medieAdmitere)+" "+ nrSala+ "  "+ admis;
        return s;
    }
}
