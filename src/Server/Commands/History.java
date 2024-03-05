package Server.Commands;

import static Server.CommandsManager.history;

public class History {
    public static void getHistory() {
        for (String element : history) {
           if (element != null) System.out.println(element);
        }
    }

    public static void addToHistory(){
        history.add(History.class.getSimpleName());
        if (history.size() > 15) history.poll();
    }
}