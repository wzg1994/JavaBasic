package leetcode.demo001;

import java.util.Arrays;

/**
 * 两数之和
 * @author wangzhiguo
 */
public class twoSum {

    public static void main(String[] args) {
        /**
         * 给定 nums = [2, 7, 11, 15], target = 9
         *
         * 因为 nums[0] + nums[1] = 2 + 7 = 9
         * 所以返回 [0, 1]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/two-sum
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */

        int[] nums = {3,2,4};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[i] + nums[k] == target) {
                    System.out.println(i);
                    System.out.println(k);
                    return new int[] { i, k };
                }
            }
        }

        return nums;
    }

}
