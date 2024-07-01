## TP : Traitement d'une collection d'objets

- Créer un framework qui traite une collection d'objets (Exemple : Personne{nom, age, email})
- Le framework doit permettre de faire les opérations suivantes :
    - Ajouter un objet à la collection
    - Supprimer un objet de la collection
    - Afficher la liste d'objet de la collection
    - Trier les objets de la collection par critère
    - Trier les objets de la collection en utilisant un comparateur
    - Trouver un objet de la collection en fonction d'un critère
- Utiliser les génériques pour permettre au framework de fonctionner avec n'importe quel type d'objet.

### Création d'une entité : Personne

1. Attributs : 
- nom : String
- age : Int
- email : String
2. Constructeur :
- Le constructeur `Personne` prend trois arguments (`nom`, `age` et `email`) et initialise les attributs correspondants avec ces valeurs.
3. Méthodes d'accès (Getters) :
- `getNom()` : Renvoie le nom de la personne.
- `getAge()` : Renvoie l'âge de la personne.
- `getEmail()` : Renvoie l'email de la personne.
4. Méthodes de modification (Setters) :
- `setNom(String nom)` : Modifie le nom de la personne.
- `setAge(int age)` : Modifie l'âge de la personne.
- `setEmail(String email)` : Modifie l'email de la personne.
5. Méthode toString() :
- La méthode `toString()` et une méthode standard de Java qui renvoie une représentation sous for de chaîne de caractères de l'objet.

### Création de l'interface Critère

1. Définition de l'interface :
- L'interface `Critère` est définie avec un seul membre : la méthode `test(T item)`.
- Cette méthode prend un argument de type `T` (générique) et renvoie un booléen(`true` ou `false`).
2. Utilisation :
- L'interface `Critère` peut être utilisée pour définir des critères de filtrage ou de test sur une collection d'objets.
- Par exemple, on peut définir un critère pour filtrer les personnes dont l'age est inférieur à 25 ans.

### Création d'une classe Repository

1. Définition de la classe :
- La classe `Repository<T>` est un **généric** (paramétrée par un type `T`) qui représente un conteneur pour stocker des éléments de type `T`.
2. Attributs :
- `items` : Un attribut privé de type `List<T>` qui stocke les éléments dans une liste.
3. Méthodes :
- `add(T item)` : Ajoute un élément à la liste.
- `remove(T item)` : Supprime un élément de la liste.
- `findAll()` : Renvoie la liste complète d'éléments.
- `findByCritere(Critere<T> critere)` : Renvoie une liste filtrée en utilisant un critère spécifié par l'interface `Critere<T>`.
- `sorted(Comparator<T> comparator)` : Renvoie une liste triée en utilisant un comparateur donné.
- `FindFirstByCritere(Critere<T> critere)` : Renvoie un `Optional<T>` contenant le premier élément de la liste qui satisfait le critère donné.
4. Utilisation :
- La classe `Repository<T>` peut être utilisée pour stocker et manipuler des collections d'objets de type `T`.
- Par exemple, on peut créer une classe `PersonneRepository` qui hérite de la classe `Repository<Personne>` et utilise les méthodes de la classe `Repository` pour stocker et manipuler des personnes.

### Initialisation du programme

- Création d'une instance de `Repository<Personne>` (un conteneur pour stocker des objets de type `Personne`).
- Elle effectue différentes opérations sur la liste de personnes srtockées dans le Repository.
1. Opérations réalisées :
- Afficher la liste complète des personnes :
    - La méthode `findAll()` renvoie la liste complète stockés dans le repository.
    - Utilisation : `personRepository.findAll().forEach(System.out::println);`
-Filtrage des personnes de moins de 25 ans :
    - La méthode `find ByCritere(critere<T> critere)` filtre la liste d'éléments en utilisant un critère spécifié par l'interface `Critere<T>`.
    - Utilisation : `List<Presonne> sous25 = personRepository.findByCritere(personne -> personne.getAge() < 25);`
- Tri des personnes par nom :
    - La méthode `sorted(Comparator<T> comparator)` trie la liste d'éléments en utilisant un comparateur donné.
    - Utilisation : `List<Personne> trier = personRepository.sorted((P1, P2) -> P1.getNom().compareTo(P2.getNom()));`
- Extraction des adress e-mail des personnes :
    - Utilisation de `java.util.stream.Collectors.toList()` pour collecter les résultats dans une liste.
    - Utilisation : `List<String> emails = personRepository.findAll().stream().filter(personne -> personne instanceof Personne).map(Personne::getEmail).collect(Collectors.toList());`
- Calcul de la moyenne d'âge :
    - Utilisation de `java.util.OptionalDouble` pour gérer le cas où la liste est vide.
    - Utilisation : `double moyenne = personRepository.findAll().stream().mapToInt(personne -> personne.getAge()).average().orElse(0);`
- Calcul de la somme des âges :
    - Utilisation de `java.util.stream.IntStream.sum()` pour calculer la somme des âges.
    - Utilisation : `int samme = personRepository.findAll().stream().mapToInt(personne -> personne.getAge()).sum();`
2. Méthode `buildRepository` :
- Cette méthode crée une instance de `Repository<Personne>` et ajoute des personnes fictives.

En résumé, le programme illustre la création d'un framework générique pour gérer une collection d'objets, en utilisant des fonctionnalités de filtrage, de tri et d'agrégation."# TP_Traitement-de-Collection" 
