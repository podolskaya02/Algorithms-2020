package lesson4;

import java.util.*;
import kotlin.NotImplementedError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Префиксное дерево для строк
 */
public class Trie extends AbstractSet<String> implements Set<String> {

    private static class Node {
        Map<Character, Node> children = new LinkedHashMap<>();
    }

    private Node root = new Node();

    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root.children.clear();
        size = 0;
    }

    private String withZero(String initial) {
        return initial + (char) 0;
    }

    @Nullable
    private Node findNode(String element) {
        Node current = root;
        for (char character : element.toCharArray()) {
            if (current == null) return null;
            current = current.children.get(character);
        }
        return current;
    }

    @Override
    public boolean contains(Object o) {
        String element = (String) o;
        return findNode(withZero(element)) != null;
    }

    @Override
    public boolean add(String element) {
        Node current = root;
        boolean modified = false;
        for (char character : withZero(element).toCharArray()) {
            Node child = current.children.get(character);
            if (child != null) {
                current = child;
            } else {
                modified = true;
                Node newChild = new Node();
                current.children.put(character, newChild);
                current = newChild;
            }
        }
        if (modified) {
            size++;
        }
        return modified;
    }

    @Override
    public boolean remove(Object o) {
        String element = (String) o;
        Node current = findNode(element);
        if (current == null) return false;
        if (current.children.remove((char) 0) != null) {
            size--;
            return true;
        }
        return false;
    }

    /**
     * Итератор для префиксного дерева
     *
     * Спецификация: {@link Iterator} (Ctrl+Click по Iterator)
     *
     * Сложная
     */
    @NotNull
    @Override
    public Iterator<String> iterator() {
        return  new TrieIterator();
    }

    public class TrieIterator implements Iterator<String> {
        private LinkedList<String> list = new LinkedList<>();
        private String string;

        private TrieIterator() {
            if (root != null) toLinkedList("", root);
        }

        void toLinkedList(String string, Node root) {
            for (char c: root.children.keySet()) {
                if (c != (char) 0)
                    toLinkedList(string + c, root.children.get(c));
                else list.add(string);
            }
        }

        @Override
        // Трудоемкость - О(1) ; Ресурсоемкость - О(1)
        public boolean hasNext() {
            return !list.isEmpty();
        }

        @Override
        public String next() {
            // Трудоемкость - О(1) ; Ресурсоемкость - О(1)
            if (list.isEmpty())
                throw new IllegalStateException();
            string = list.pollFirst(); // возвращает и удаляет первый элемент этого списка или возвращает null, если этот список пуст.
            return string;
        }

        @Override
        public void remove() {
            // Трудоемкость - О(n), n - длина string ; Ресурсоемкость - О(1)
            if (string == null) throw new IllegalStateException();
            else {
                Trie.this.remove(string);
                string = null;
            }
        }

    }

}
