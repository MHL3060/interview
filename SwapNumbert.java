public class SwapNumber {


    public void swapNumber() {
        int a = 6;
        int b = 5;
        System.out.println("before a = " + a + ", b= " + b);
        a = a - b; // 1
        b = a + b; // 6 (a - b) + b
        a = b - a; // 5 (a - b) + b  - (a - b) = a - b + b - a + b  
        System.out.println("before a = " + a + ", b= " + b);
    }

    public static void main(String[] args) {
        SwapNumber swap = new SwapNumber();
        swap.swapNumber();
    }
}