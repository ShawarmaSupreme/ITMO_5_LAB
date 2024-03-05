package Client.DataManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Client.ErrorCheckers.InfinityLoopCheck.loopChecker;

public class ExecuteScript {
    public static void scriptReader(String scriptFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(scriptFile))) {
            String line;
            boolean f = true;
            while ((line = reader.readLine()) != null && f) {
                Pattern pattern = Pattern.compile("(\\S+)\\s*\\{(.*?)\\}");
                Matcher matcher = pattern.matcher(line);
                String[] argumentArray = null;
                String command;
                if (matcher.find()) {
                    if (line.split(" ").length != 1) {
                        command = matcher.group(1);
                        String arguments = matcher.group(2);
                        argumentArray = arguments.split(", ");
                    } else {
                        command = line;
                    }

//                    if (!loopChecker(command, argumentArray[0])) readCom(command, argumentArray);
//                    else {
//                        System.out.println("!!!!!!!!! Обнаружен цикл скриптов !!!!!!!!!".toUpperCase());
//                        return;
//                    }
                } else {
                    System.out.println("Неизвестная команда: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("!!!!!!!!! Файл не найден !!!!!!!!!".toUpperCase());
        } catch (IOException e) {
            System.out.println("!!!!!!!!! Ошибка чтения файла !!!!!!!!!".toUpperCase());
        } catch (Exception e) {
            System.out.println("!!!!!!!!! Файл поврежден !!!!!!!!!".toUpperCase());
        }
    }
}