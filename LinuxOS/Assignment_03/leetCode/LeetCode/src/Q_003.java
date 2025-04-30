import java.util.HashMap;
import java.util.Map;
class Q_003 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> store = new HashMap<>();
        int arr[] = {0,0};
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(store.containsKey(temp)){
                arr[0]=store.get(temp);
                arr[1]=i;
                return arr;
            }
            store.put(nums[i],i);
        }
        arr[0]=0;
        arr[1]=1;
        return arr;
    }
}