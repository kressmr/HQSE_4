package Main;

import Utils.IOUtils;


public class Main {
    public static void main(String[] args) {

        Bot bot = new Bot(IOUtils.getUserName(args));
        bot.run();
    }
}
