
public class AddAndSearchWord {

    static class Trie {
        Trie[] child = new Trie[26];
        boolean isEnd = false;
    }

    Trie root;

    public AddAndSearchWord() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie node = root;
        for (char ch : word.toCharArray()) {
            int indx = ch - 'a';
            if (node.child[indx] == null) {
                node.child[indx] = new Trie();
            }
            node = node.child[indx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, Trie node) {
        if (i == word.length()) return node.isEnd;

        char ch = word.charAt(i);
        if (ch != '.') {
            int indx = ch - 'a';
            Trie child = node.child[indx];
            if (child == null) return false;
            return dfs(word, i + 1, child);
        } else {
            for (int j = 0; j < 26; j++) {
                if (node.child[j] != null) {
                    if (dfs(word, i + 1, node.child[j])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // ✅ Main function for testing
    public static void main(String[] args) {
    AddAndSearchWord dict = new  AddAndSearchWord();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");

        System.out.println(dict.search("pad"));  // false
        System.out.println(dict.search("bad"));  // true
        System.out.println(dict.search(".ad"));  // true
        System.out.println(dict.search("b.."));  // true
    }
}

