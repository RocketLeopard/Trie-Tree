class TrieNode {
    private Character c;
    private Map<Character, TrieNode> children;
    private int childNum;

    public TrieNode(Character c) {
        this.c = c;
        this.children = new HashMap<>();
        childNum = 0;
    }

    public Character getC() {
        return this.c;
    }

    public int getChildNum() {
        return this.childNum;
    }

    public Map<Character, TrieNode> getChildren() {
        return this.children;
    }

    public TrieNode getChild(Character c) {
        return this.children.get(c);
    }

    public void setChild(Character c) {
        TrieNode node = new TrieNode(c);
        this.childNum++;
        this.children.put(c, node);
    }
}
