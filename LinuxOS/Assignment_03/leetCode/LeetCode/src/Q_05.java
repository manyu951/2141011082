import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;;
class Q_05 {
	public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramsMap = new HashMap<>();

        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if (anagramsMap.containsKey(sortedWord)) {
                anagramsMap.get(sortedWord).add(word);
            } else {
                List<String> group = new ArrayList<>();
                group.add(word);
                anagramsMap.put(sortedWord, group);
            }
        }

        return new ArrayList<>(anagramsMap.values());
    }
	public static void main (String[] args) {
    	String strs[] = {"eat","tea","tan","ate","nat","bat"};
    	Q_05 ans = new Q_05();
    	System.out.println(ans.groupAnagrams(strs));
    }
}