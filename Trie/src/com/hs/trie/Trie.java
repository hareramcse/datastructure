package com.hs.trie;

public class Trie {
	TrieNode root;

	void insert(String key) {
		TrieNode pCrawl = root;
		
		for (int level = 0; level < key.length(); level++) {
			int index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null) {
				pCrawl.children[index] = new TrieNode();
			}
			pCrawl = pCrawl.children[index];
		}
		pCrawl.isEndOfWord = true;
	}

	boolean search(String key) {
		TrieNode pCrawl = root;

		for (int level = 0; level < key.length(); level++) {
			int index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null) {
				return false;
			}
			pCrawl = pCrawl.children[index];
		}
		return (pCrawl != null && pCrawl.isEndOfWord);
	}

	public static void main(String args[]) {
		Trie trie = new Trie();
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the" };

		String output[] = { "Not present in trie", "Present in trie" };

		trie.root = new TrieNode();

		// Construct trie
		for (int i = 0; i < keys.length; i++)
			trie.insert(keys[i]);

		// Search for different keys
		if (trie.search("the") == true)
			System.out.println("the --- " + output[1]);
		else
			System.out.println("the --- " + output[0]);

		if (trie.search("these") == true)
			System.out.println("these --- " + output[1]);
		else
			System.out.println("these --- " + output[0]);

		if (trie.search("their") == true)
			System.out.println("their --- " + output[1]);
		else
			System.out.println("their --- " + output[0]);

		if (trie.search("thaw") == true)
			System.out.println("thaw --- " + output[1]);
		else
			System.out.println("thaw --- " + output[0]);
	}
}