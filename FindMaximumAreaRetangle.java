import java.util.Stack;

public class FindMaximumAreaRetangle {
    public static void main(String[] args) {
      find(new int[]{1,2,3,4,1});  
    }

    public static void find(int[] array) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int currentArea = 0;
        int i = 0;
        for (i = 0; i < array.length;) {
            
            if (stack.isEmpty() || array[stack.peek()] <= array[i]) {
                stack.push(i++);
            }else {
               int top = stack.pop();
               if (stack.isEmpty()) {
                   currentArea = array[top] * i;
               }else {
                   currentArea = array[top] * (i - stack.peek() -1);
               }
               if(currentArea > maxArea) {
                   maxArea = currentArea;
               }
            }
        }
        while(stack.isEmpty() == false) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                currentArea = array[top] * i;
            }else {
                currentArea = array[top] * (i - stack.peek() -1);
            }
            if(currentArea > maxArea) {
                maxArea = currentArea;
            } 
        }
        System.out.println(String.format("maximum area is %s", maxArea));
    }
    
}