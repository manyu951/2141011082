import java.util.HashSet;
import java.util.Set;

class Q_001 {
    public  boolean containsDuplicate(int[] nums) {
        Set<Integer> c = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(!c.add(nums[i])){
                return true;
            }
        }
        return false;
    }
    public static void  main (String[] args) {
    	int nums[] = {1,2,3,1};
    	Q_001 dup = new Q_001();
    	System.out.println(dup.containsDuplicate(nums));
    }
}
