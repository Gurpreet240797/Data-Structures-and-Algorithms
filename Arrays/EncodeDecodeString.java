package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EncodeDecodeString {
    public static void main(String args[]) {
        Scanner keyword = new Scanner(System.in);
        String[] strArr = keyword.nextLine().split(" ");
        int length = strArr.length;

        String encoded = encode(strArr);
        String[] decoded = decode(encoded, length);

        System.out.println("Encoded Message: " + Arrays.toString(strArr));
        System.out.println("Decoded Message: " + Arrays.toString(decoded));
    }

    public static String encode(String[] strArr) {
        String res = "";
        for (String str : strArr) {
            res += str.length() + "/" + str;
        }
        return res;
    }

    public static String[] decode(String str, int length) {
        String[] res = new String[length];
        int index = 0;
        String sb = "";
        int len = 0;

        for (int i=1; i<str.length(); i++) {
            if (str.charAt(i) == '/') {
                len = Integer.parseInt(String.valueOf(str.charAt(i-1)));
            } else if (len > 0) {
                sb = sb + str.charAt(i);
                len--;
            } else {
                res[index] = sb;
                if (index < length) index += 1;
                sb = "";
            }
        }
        res[index] =  sb;
        return res;
    }
}
