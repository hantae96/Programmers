import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        List<Character> moo = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("end"))
                return;

            boolean mustOneMoo = false;
            int mooCount = 0;
            int jaaCount = 0;
            char prevChar = '\0';

            boolean isSucess = true;
            for (int i = 0; i < input.length(); i++) {
                if (moo.contains(input.charAt(i))) {
                    mustOneMoo = true;
                    mooCount++;
                    jaaCount = 0;
                } else {
                    mooCount = 0;
                    jaaCount++;
                }

                if (mooCount == 3 || jaaCount == 3) {
                    isSucess = false;
                    break;
                }

                if (i > 0) {
                    if (prevChar == input.charAt(i)) {
                        if (prevChar != 'e' && prevChar != 'o') {
                            isSucess = false;
                            break;
                        }
                    }
                }

                prevChar = input.charAt(i);
            }

            if (!mustOneMoo || !isSucess) {
                System.out.printf("<%s> is not acceptable.\n",input);
            } else {
                System.out.printf("<%s> is acceptable.\n",input);
            }
        }
    }
}
