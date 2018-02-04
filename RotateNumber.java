import java.util.HashMap;

//give a number, rotate 180 and check if the roated number same as the original one.

public class RotateNumber {


    private String number;
    public static void public static void main(String[] args) {
        
    }
    public Map map;

    public Rotate(String number) {
        this.number = number;
        map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("5", "5");
        map.put("6", "9");
        map.put("8", "8");
        map.put("9", "6");
    }
      // 1, 2, 3, 4, 5, 6, 7, 8, 9, 0
//rotate 1, 2, n, n, 5, 9, n, 8, 6, 0

    public String rotate(char n) {
        return map.get(""+ n);
    }

    public boolean isEqualsTo(String compare) {

        String rotate = "";
        for (int i = 0; i < number.length(); i++) {
            String rotated = number.charAt(i);
            if (rotated == null) {
                return false;
            } 
        }
        return rotate.equals(compare);

    }

}