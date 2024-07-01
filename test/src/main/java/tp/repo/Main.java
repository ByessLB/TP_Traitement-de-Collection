package tp.repo;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /*
     * Todo :
     * Créer un framwork qui traite une colleciton d'objets
     * (exemple : Personne :{nom, age, email})
     * Ce framework devra fournir des fonctionnalités pour filtrer, trier et effectuer
     * diverses opérations d'agrégation sur la collection,
     * similaires à ce que vous pourriez trouver dans une base de données ou une bibliothèques de traitement de données.
     * Utiliser les génériques pour permettre au framework de fonctionner avec n'importe quel type d'objet.
     */
    // @SuppressWarnings("unchecked") // Supprime les avertissemnts non vérifiés
    public static void main(String[] args) {

        // @SuppressWarnings("rawtypes") // Supprime les avertissements liés oux types génériques non vérifiés
        Repository personRepository = buildRepository();

        // Affiche la liste des personnes
        personRepository.findAll().forEach(System.out::println);

        // Affiche les personnes agées de moins 25ans
        List<Personne> sous25 = personRepository.findByCritere(personne -> ((Personne) personne).getAge() < 25);
        sous25.forEach(System.out::println);
        System.out.println("\n");

        // Classement des personnes
        List<Personne> trier = personRepository.sorted((P1, P2) -> ((Personne) P1).getNom().compareTo(((Personne) P2).getNom()));
        trier.stream().forEach(System.out::println);
        System.out.println("\n");

        // Juste l'email
        List<String> emails = (List<String>) personRepository.findAll().stream().filter(personne -> personne instanceof Personne).map(personne -> ((Personne) personne).getEmail()).collect(Collectors.toList());
        emails.stream().forEach(System.out::println);
        System.out.println("\n");

        // calculer la moyenne d'age
        double moyenne = personRepository.findAll().stream().mapToInt(personne -> ((Personne) personne).getAge()).average().orElse(0);
        System.out.println("moyenne = " + moyenne);
        System.out.println("\n");

        // Calculer la somme des ages
        int somme = personRepository.findAll().stream().mapToInt(personne -> ((Personne) personne).getAge()).sum();
        System.out.println("somme = " + somme);
    }


    static Repository<Personne> buildRepository() {
        Repository<Personne> personRepository = new Repository<>();

        personRepository.add(new Personne("John Doe", 30, "john.doe@exemple.com"));
        personRepository.add(new Personne("Jane Doe", 26, "jane.doe@exemple.com"));
        personRepository.add(new Personne("Sam Smith", 43, "sam.smith@exemple.com"));
        personRepository.add(new Personne("Bertrand Thomson", 22, "beber.thomson@exemple.com"));
        personRepository.add(new Personne("Didier Desfraises", 24, "dd.dfraises@exemple.com"));
        personRepository.add(new Personne("Tony Parké", 36, "tony.p@exemple.com"));
        personRepository.add(new Personne("Jamie Morgan", 39, "jm@exemple.com"));
        personRepository.add(new Personne("Drew Barry", 27, "db@exemple.com"));
        personRepository.add(new Personne("Jean Michel", 20, "jeam.mich@exemple.com"));
        personRepository.add(new Personne("Jean Luc", 47, "jean.c@exemple.com"));

        return personRepository;
    }
}