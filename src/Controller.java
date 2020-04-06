public class Controller {
    private Repo r=new Repo();

    public void setMedieAdmitere(Candidat c)
    {
        c.setMedieAdmitere((1.0/3.0)*c.getNotaProbaBac()+(2.0/3.0)*c.getNotaAdmitere());
    }
    public void calculMedii()
    {
        for(int i =0; i<r.getNrCandidati(); i++)
        {
            if(r.getCandidat(i).getNotaAdmitere()>=5.0)
                setMedieAdmitere(r.getCandidat(i));

        }
    }

    public boolean sortareDupaNume()
    {
        Candidat aux=new Candidat();
        for (int i = 0; i < r.getNrCandidati(); i++)
        {
            for (int j = i + 1; j < r.getNrCandidati(); j++) {
                if (r.getCandidat(i).getNume().compareTo(r.getCandidat(j).getNume())>0)
                {
                    aux = r.getCandidat(i);
                    r.setCandidat(i, r.getCandidat(j));
                    r.setCandidat(j, aux) ;
                }
            }
        }
        return true;

    }

    public void resortareID()
    {
        Candidat aux=new Candidat();
        for (int i = 0; i < r.getNrCandidati(); i++)
        {
            for (int j = i + 1; j < r.getNrCandidati(); j++) {
                if (r.getCandidat(i).getId()>(r.getCandidat(j).getId()))
                {
                    aux = r.getCandidat(i);
                    r.setCandidat(i, r.getCandidat(j));
                    r.setCandidat(j, aux) ;
                }
            }
        }
    }

    public void sortareMedieAdmitere()
    {
        Candidat aux=new Candidat();
        for (int i = 0; i < r.getNrCandidati(); i++)
        {
            for (int j = i + 1; j < r.getNrCandidati(); j++) {
                if (r.getCandidat(i).getMedieAdmitere()<(r.getCandidat(j).getMedieAdmitere()))
                {
                    aux = r.getCandidat(i);
                    r.setCandidat(i, r.getCandidat(j));
                    r.setCandidat(j, aux) ;
                }
            }
        }
    }

    public void repartizareSali()
    {   int j=0;
        int nr=0;
        for(int i=0; i<r.getNrCandidati(); i++)
        {
            r.getCandidat(i).setNrSala(r.getSala(j));
            nr++;
            if(nr==31)
            {
                nr=0;
                j++;
            }
        }

    }

    public void introducereNoteAdmitere()
    {
        for(int i=0; i<r.getNrCandidati(); i++)
        {
            r.getCandidat(i).setNotaAdmitere(r.citireReal("Candidat cu ID "+i+": "));
        }
    }

    public void listaFinala()
    {   int nrLocuri=50;
        for(int i=0; i<r.getNrCandidati(); i++)
            if(nrLocuri>0)
                if(r.getCandidat(i).getMedieAdmitere()>=5.0)
                {r.getCandidat(i).setAdmis("admis");nrLocuri--;}
                else r.getCandidat(i).setAdmis("respins");
    }

    public Repo afisareCandidatiSali()
    {   Repo r1=new Repo();
        for(int i=0; i<r.getNrCandidati(); i++)
            if(r.getSala(i)==r.getCandidat(i).getNrSala())
                r1.addCandidat(r.getCandidat(i));

        return r1;
    }

    public double citireOpt(){return r.citireReal("Introduceti optiunea: ");}
    public void inscriere(){r.citireCandidat();}
    public Repo getR(){return r;}
    public void setCandidat(int i, Candidat c){r.setCandidat(i, c);}
    public void addCandidat(Candidat c){r.addCandidat(c);}
    public void readFromFile(){r.readFromFile();}
    public Candidat getCandidat(int i){return r.getCandidat(i);}
    public int getSize(){return r.getSize();}

}

