package Middleware;

public interface IMiddleware {


    public boolean isAnswerAvailable(String userRequest);

    public String getAnswer(String userRequest);

    public void initMiddleware(String botName, String userName);
}
