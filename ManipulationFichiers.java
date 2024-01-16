public class ManipulationFichiers
{
    public static void main(String[] args)
    {
        TraitementNotes traitementNotes = new TraitementNotes("ElementsModule.txt", "Etudiants.txt", "Notes.txt");
        System.out.println(traitementNotes.nomEtudiant(1726));
        System.out.println(traitementNotes.coefficient("TC111"));
        System.out.println(traitementNotes.coefficient("lkm"));
        System.out.println(traitementNotes.coefficient("TC122"));
        System.out.println(traitementNotes.coefficient("TC112"));
        System.out.println(traitementNotes.nbrEleves("TC111"));
        System.out.println(traitementNotes.nbrEleves("TT45"));
        System.out.println(traitementNotes.moyenne(1701));
        System.out.printf("%.3f", traitementNotes.moyenne(1701));
        traitementNotes.sauvegarderResultats();

        /*
        try {
            BufferedReader reader  = new BufferedReader(new FileReader(".//src//Resource//Etudiants.txt"));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] ls = line.split(":");
                int matricule = Integer.parseInt(ls[0]);
                String nom = ls[1] + " " + ls[2];
                System.out.println(matricule + ", " + nom);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */
        /*
        System.out.println("Experimenting");
        List<String> lnames = new ArrayList<String>();
        lnames.add("Sidi");
        lnames.add("Ahmed");
        lnames.add("Chrif");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("outp.txt"));
            writer.write("experiment wrting\n");
            writer.write("Sidi Doueida writing\n");

            for(String name: lnames) writer.write(name + "\n");

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("outp.txt"));
            //System.out.println(reader.readLine());
            System.out.println("READING:");
            String line;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Map<String, Integer> map = new HashMap<>();
        //map.put("Sidi", 25);
        //System.out.println(map.get("Sidi"));

         */
    }
}
