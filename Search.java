public class Search {

    public search(int[] nums, int target) {

        int biggest = nums[0];
        int start = nums[0];
        int biggestPosition = nums.length;
        int biggest = nums[biggestPosition];
        for (int i =1; i < nums.length; i++) {
            if (nums[i] < biggest) {
                biggestPosition = i;
                biggest = nums[i];
                break;
            }
            biggest = nums[i];
        }

        if (target >= start && target <= biggest) {
            binarySearch(nums, k, 0, biggestPosition);
        } else {
            binarySearch(nums, k, biggestPosition, nums.length);
        }

    }

    public int binarySearch(int[] nums, int target, int startPosition, int endPosition) {
        int mid = nums.length /2;
        if (startPosition == endPosition){
            if (nums[startPosition] == target) {
                return startPosition;
            } else {
                return -1;
            }
        }
        if (target >= nums[startPosition] && target <= nums[endPosition - mid]) {
            return binarySearch(nums, target, startPosition, endPosition - mid);
        } else {
            return binarySearch(nums, target, startPosition, endPosition)
        }
    }
}