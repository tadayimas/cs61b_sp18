public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> cdeque = new ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {
            cdeque.addLast(word.charAt(i));
        }

        return cdeque;
    }

    public boolean isPalindrome(String word) {
        Deque d = wordToDeque(word);
        String dreverse = "";
        for (int i = 0; i < word.length(); i++) {
            dreverse += d.removeLast();
        }

        return word.equals(dreverse);

    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = wordToDeque(word);
        for (int i = 0; i < word.length()/2; i++) {
            char front = (char) d.removeFirst();
            char back = (char) d.removeLast();
            if(!cc.equalChars(front, back)) {
                return false;
            }
        }
        return true;
    }

}
