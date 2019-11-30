package Utils;

import java.util.Scanner;


public class IOUtils {

    private static final String USERNAME_KEY = "-p";

    static Scanner scan = new Scanner(System.in);

    public static String getUserInput(String userName) {
        System.out.print("[" + userName + "] ");
        String text = scan.next();
        return text;
    }

    public static String getUserName(String[] args) {
        String username = "";

        for(int i = 0; i < args.length; i += 2)
        {
            String key = args[i];
            String value = args[i+1];

            switch (key)
            {
                case USERNAME_KEY : username = value; break;
            }
        }

        if (username.equals("")) {
            System.exit(0);
        }
        return username;
    }
}
