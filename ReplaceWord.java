 import java.util.*;

// ✅ Class to replace words in sentence using Trie
public class ReplaceWord {

    // Trie Node definition
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    // Trie implementation
    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        // Insert a word into Trie
        void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        // Get the shortest prefix root from Trie for the word
        String getPrefix(String word) {
            TrieNode node = root;
            StringBuilder sb = new StringBuilder();

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) break;
                sb.append(ch);
                node = node.children[idx];
                if (node.isEnd) return sb.toString();
            }

            return word;
        }
    }

    // ✅ LeetCode replaceWords() function
    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        // Step 1: Insert all dictionary roots into the Trie
        for (String root : dictionary) {
            trie.insert(root);
        }

        // Step 2: Process sentence words
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = trie.getPrefix(words[i]); // Replace with shortest root if available
        }

        return String.join(" ", words); // Join words into final sentence
    }

    // ✅ Main function for testing
    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";

        String result = replaceWords(dictionary, sentence);
        System.out.println("Replaced Sentence:\n" + result);
    }
}
 
