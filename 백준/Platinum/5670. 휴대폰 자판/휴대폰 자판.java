import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while((line = br.readLine()) != null){
            int N = Integer.parseInt(line);
            Trie trie = new Trie();
            List<String> list = new ArrayList<>();
            int sum = 0;
            for(int n = 0 ; n<N ; n++) {
                String word = br.readLine();
                trie.insert(word);
                list.add(word);
            }
            for(String w : list){
                sum += find(trie.root, w, 0, 0, trie.root);
            }
            double avg = (double) sum / N;
            System.out.printf("%.2f\n", avg);
        }

    } // end of main

    public static int find(Node node, String word, int idx, int cnt, Node root) {
        if (idx == word.length()) return cnt;

        Node next = node.childNodes.get(word.charAt(idx));

        if (node == root || node.childNodes.size() > 1 || node.endOfWord) cnt++;

        return find(next, word, idx + 1, cnt, root);
    }



    public static class Node{
        Map<Character, Node> childNodes = new HashMap<>();
        boolean endOfWord;
    }

    public static class Trie{
        private Node root;
        Trie(){
            root = new Node();
        }

        public void insert(String word){
            Node node = this.root;

            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                node.childNodes.putIfAbsent(c, new Node());
                node = node.childNodes.get(c);
            }
            node.endOfWord = true;
        }

    }
}
