package Server.Models;

import java.util.Stack;

public class IDstack {
    public static Stack<Integer> idStack = new Stack<>();
    public static int addID() {
        int IDticket;
        if (idStack.size() == 1){
            IDticket = idStack.pop();
            idStack.push(IDticket + 1);
            return IDticket;
        } else {
            return idStack.pop();
        }
    }
    public static int lookID() {
        int IDticket;
        if (idStack.size() == 1){
            IDticket = idStack.pop();
            idStack.push(IDticket);
            return IDticket;
        } else {
            return idStack.pop();
        }
    }
}
