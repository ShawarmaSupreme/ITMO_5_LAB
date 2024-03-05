package Client.ErrorCheckers;

import java.util.HashMap;
import java.util.Map;

public class InfinityLoopCheck {
    private static Map<String, Integer> recursionFlag = new HashMap<>();
    public static boolean loopChecker(String command, String path){
        boolean flag = false;
        if (command.equals("8") || command.equals("execute_script")){
            if (!recursionFlag.containsKey(path)){
                recursionFlag.put(path, 1);
            } else
                recursionFlag.put(path, 2);
            if (recursionFlag.get(path) > 1)
                flag = true;
        }
        return flag;
    }
}