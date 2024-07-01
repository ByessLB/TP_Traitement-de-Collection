package tp.repo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Repository<T> {
    private List<T> items = new ArrayList<>();

    // Ajouter un élément à la liste
    public void add(T item) {
        items.add(item);
    }

    // Supprimer un élément de la liste
    public void remove(T item) {
        items.remove(item);
    }

    // Renvoie une copie de la liste complète
    public List<T> findAll() {
        return new ArrayList<>(items);
    }

    // Renvoie une liste filtrée par critère
    public List<T> findByCritere(Critere<T> critere) {
        return items.stream().filter(critere::test).collect(Collectors.toList());
    }

    // Renvoie une liste triée en utilisant un comparateur donné
    public <U extends Comparable<U>> List<T> sorted(Comparator<T> comparator) {
        return items.stream().sorted(comparator).collect(Collectors.toList());
    }

    // Optional : trouver la 1ère personne en fonction du critère donné
    public Optional<T> findFirstByCritere(Critere<T> critere) {
        return items.stream().filter(critere::test).findFirst();
    }
}
