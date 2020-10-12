import java.util.HashSet;
import java.util.Set;

public class AmazonTwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 45, 46, 46};

        System.out.println(getCountTwoSumUnique(nums, 47));
    }
    private static int getCountTwoSumUnique(int[] nums, int target){
        //if(nums.length <= 1)
        //    return 0;

        int ans = 0;

        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();

        for(int num : nums){
            if(set.contains(target - num) && !seen.contains(num)){
                ans++;
                seen.add(target - num);
                seen.add(num);
            }
            else if(!set.contains(num)){
                set.add(num);
            }
        }
        return ans;
    }
}
