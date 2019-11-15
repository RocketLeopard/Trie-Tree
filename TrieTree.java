class TrieTree {
    private TrieNode root;
    private StringBuilder sb = new StringBuilder();

    public TrieTree() {
        // root node has not exist character
        root = new TrieNode(null);
    }

    public TrieNode getRoot() {
        return this.root;
    }

    public void insert(String word) {
        TrieNode node = this.root;

        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);

            if (!isExist(node, c)) {
                node.setChild(c);
            }

            node = node.getChild(c);
        }
    }

    public boolean isExist(TrieNode node, Character c) {
        if (node == null || c == null) {
            return false;
        }

        return node.getChild(c) != null;
    }

    public void search(String prefix) {
        if ("".equals(prefix)) {
            return;
        }

        int len = prefix.length();
        TrieNode node = this.root;
        for (int i = 0; i < len; i++) {
            char c = prefix.charAt(i);

            if (!isExist(node, c)) {
                return;
            }

            node = node.getChild(c);
        }

        // 这里需要删除前缀的最后一个字符，因为打印搜索结果的时候会包含根节点的字符
        print(prefix.substring(0, len - 1), node);
    }

    public void print(String prefix, TrieNode node) {
        if (node != null) {
            Character c = node.getC();
            if (c != null) {
                sb.append(c);
            }

            if (node.getChildNum() == 0) {
                System.out.println((prefix == null ? "" : prefix) + sb.toString());
                return;
            }

            for (Map.Entry<Character, TrieNode> child : node.getChildren().entrySet()) {
                print(prefix, child.getValue());
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public void printAll() {
        if (root.getChildNum() <= 0) {
            System.out.println("empty trie tree");
        }

        print("", root);
    }
}
