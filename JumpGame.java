import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JumpGame {


    public boolean canJump(int[] nums) {
        if (nums.length > 0 && nums[0]>= nums.length -1) {
            return true;
        } else { //array.length > value
            int value = nums[0];
            boolean result = false;
            while(value > 0 && result == false) {
                result = canJump(Arrays.copyOfRange(nums, value, nums.length));
                value--;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();

        System.out.println(jumpGame.canJump(new int[]{2,3,1,1,4}));

        System.out.println(jumpGame.canJump(new int[]{3,2,1,0,4}));

        System.out.println(jumpGame.canJump(new int[]{2,0}));
        System.out.println(jumpGame.canJump(new int[]{1,3,3}));
        System.out.println(jumpGame.canJump(new int[]{
            2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,
            1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,
            3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,
            9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6
        }));
    }
}