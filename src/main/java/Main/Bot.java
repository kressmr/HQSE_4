package Main;

import Middleware.CustomAnswer;
import Middleware.IMiddleware;
import Utils.IOUtils;

public class Bot {

    private String botName;
    private String userName;
    private IMiddleware middleware;

    public Bot(String userName) {
        this.userName = userName;
        this.botName = "hello";

        init();
    }

    public Bot(String userName, String botName) {
        this.userName = userName;
        this.botName = botName;

        init();
    }

    private void init() {
        middleware = new CustomAnswer();
        middleware.initMiddleware(this.botName, this.userName);
    }

    public void run() {
        while(true) {
            String userText = IOUtils.getUserInput(this.userName);
            //displayMsg(this.userName, userText);
            answer(userText);

        }

    }

    private void displayMsg(String name, String text) {
        System.out.println("[" + name + "] " + text);
    }

    private void answer(String userText) {
        if (middleware.isAnswerAvailable(userText)) {
            displayMsg(this.botName, middleware.getAnswer(userText));
            return;
        }
    }
}
