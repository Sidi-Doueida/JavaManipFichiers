import java.io.*;

public class TraitementNotes
{
    private String nomFichierEM;
    private String nomFichierEtudiants;
    private String nomFichierNotes;

    public TraitementNotes(String nomFEM, String nomFEtudiants, String nomFNotes)
    {
        this.nomFichierEM = nomFEM;
        this.nomFichierEtudiants = nomFEtudiants;
        this.nomFichierNotes = nomFNotes;
    }

    public String nomEtudiant(int matricule)
    {
        String nomComplet = null;
        try {
            BufferedReader reader  = new BufferedReader(new FileReader(".//src//Resource//" + nomFichierEtudiants));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] ls = line.split(":");
                int matriculeEtudiant = Integer.parseInt(ls[0]);
                if (matriculeEtudiant == matricule)
                {
                    nomComplet = ls[1] + " " + ls[2];
                    reader.close();
                    return nomComplet;
                }
                //String nom = ls[1] + " " + ls[2];
                //System.out.println(matricule + ", " + nom);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nomComplet;
    }

    public Integer coefficient(String codeChercher)
    {
        Integer coefficent = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".//src//Resource//" + nomFichierEM));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] ls = line.split(":");
                String code = ls[0];
                if(codeChercher.equals(code))
                {
                    int coeffPosition = ls.length - 1;
                    coefficent = Integer.parseInt(ls[coeffPosition].trim());
                    reader.close();
                    return coefficent;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return coefficent;
    }

    public int nbrEleves(String codeModule)
    {
        int nbr = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".//src//Resource//" + nomFichierNotes));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] ls = line.split(":");
                String code = ls[0];
                double note = Double.parseDouble(ls[ls.length - 1].trim());
                if(code.equals(codeModule) && note >= 10.0) ++nbr;
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nbr;
    }

    public double moyenne(int matriculeCherche)
    {
        double avg = 0.0;
        int nbr_note = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".//src//Resource//" + nomFichierNotes));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] ls = line.split(":");
                int matricule = Integer.parseInt(ls[1]);
                if(matricule == matriculeCherche)
                {
                    int notePosition = ls.length - 1;
                    double note = Double.parseDouble(ls[notePosition].trim());
                    avg += note;
                    ++nbr_note;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        avg /= nbr_note;
        return avg;
    }

    //Créer une méthode sauvegarderResultats qui crée un fichier resultats.txt
    //où chaque ligne de ce fichier contient le matricule, le nom, le prénom, le
    //titre de l’élément de module et la note de l’étudiant dans l’élément.
    public void sauvegarderResultats()
    {
        String outputFile = "resultats.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(".//src//Resource//" + outputFile));
            BufferedReader readerEtud = new BufferedReader(new FileReader(".//src//Resource//" + nomFichierEtudiants));
            String lineEtud;
            while ((lineEtud = readerEtud.readLine()) != null)
            {
                writer.write(lineEtud); //matricule:nom:prenom
                String[] ls = lineEtud.split(":");
                int matEtud = Integer.parseInt(ls[0]);
                //String matEtud = ls[0];
                BufferedReader readerNote = new BufferedReader(new FileReader(".//src//Resource//" + nomFichierNotes));
                String lineNote;
                while ((lineNote = readerNote.readLine()) != null)
                {
                    //lineNote code:matricule:note
                    String[] lsNote = lineNote.split(":");
                    int matricule = Integer.parseInt(lsNote[1]);
                    //String matricule = lsNote[1];
                    if(matEtud == matricule)
                        writer.write(":" + lsNote[0] + ":" + lsNote[2]);
                }
                writer.write("\n");
                readerNote.close();

            }
            writer.close();
            //readerNote.close();
            readerEtud.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
