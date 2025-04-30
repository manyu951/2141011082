import java.util.Arrays;
class Q_002 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] SortedS = s.toCharArray();
        char[] SortedT = t.toCharArray();
        Arrays.sort(SortedS);
        Arrays.sort(SortedT);
        return Arrays.equals(SortedS, SortedT);
    }
}