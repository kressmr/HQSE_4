package Middleware;

import java.text.SimpleDateFormat;
import java.util.*;

interface Command {
    String runCommand();
}

public class CustomAnswer implements IMiddleware {

    Map<String, Command> answers;
    String botName;
    String userName;

    public CustomAnswer () {

        answers  = new HashMap<>();
        init();
    }

    private void init() {
        /*ArrayList<String> test = new ArrayList<String>();
        test.add("Salut "+ this.userName + "! Nous sommes Jeudi 25 octobre et il est 14h30. ");
        answers.put("@" + this.botName, test);*/



        answers = new HashMap<String, Command>();

        answers.put("@" + this.botName, new Command() {
            public String runCommand() { return answerBotTagged(); };
        });
    }

    @Override
    public boolean isAnswerAvailable(String userRequest) {
        if (answers.containsKey(userRequest)) {
            return true;
        }
        return false;
    }

    @Override
    public String getAnswer(String userRequest) {
        return answers.get(userRequest).runCommand();
    }

    @Override
    public void initMiddleware(String botName, String userName) {

        this.botName = botName;
        this.userName = userName;

        init();
    }

    private String answerBotTagged() {
        String answer;
        String pattern1 = "EEEEE dd MMMMM HH:mm";
        String pattern2 = "HH:mm";
        Locale fr = new Locale("fr", "FR");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1, fr);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2, fr);


        Date dateBase = new Date();
        String datePart1 = simpleDateFormat1.format(dateBase);
        String datePart2 = simpleDateFormat2.format(dateBase);
        answer = "Salut " + this.userName + "! Nous sommes " + datePart1 + " et il est " + datePart2 + ".";
        return answer;
    }
}
