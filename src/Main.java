import javax.sound.sampled.Line;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        Map<String, Integer> map = createMap();
        addToMap(map);

        Map<String, Integer> newMap = sortByValue(map);
        saveData(newMap);
    }

    static Map sortByValue(Map unsortedMap)  {
        Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

    static Map<String, Integer> createMap() {
        Map<String, Integer> wyniki = new TreeMap<>();
        return wyniki;
    }

    static Map<String, Integer> addToMap(Map<String, Integer> map) {
        String name = " ";
        do {
            name = loadNames();
            if(!isStop(name))
            map.put(name,loadPoints());
        }
        while (!isStop(name));
        return map;
    }

    static boolean isStop(String line){
        final String STOP = "STOP";
        if(!line.equalsIgnoreCase(STOP)) {
            return false;
        }
        return true;
    }

    static String loadNames() {
        String line;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj dane gracza");
        line = scanner.nextLine();
        return line;
    }

    static Integer loadPoints() {
        String line;
        Integer num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj punkty gracza");
        line = scanner.nextLine();
        num = checkIfParsingIsPossible(line);
        return num;
    }

    static Integer checkIfParsingIsPossible(String line) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        int num = 0;
        while(!check){
            try {
                num = Integer.parseInt(line);
                check = true;
            }
            catch (NumberFormatException e){
                System.out.println("Zly format wyniku");
                System.out.println("Podaj wynik");
                line = scanner.nextLine();
            }
        }
        return num;
    }

    static void saveData(Map<String, Integer> map) throws IOException {
        FileWriter fileWriter = new FileWriter("plik.csv");
        BufferedWriter bfw = new BufferedWriter(fileWriter);

        Set <String> zbiorGraczy = map.keySet();
        for (String s  : zbiorGraczy) {
            int l = map.get(s);
            bfw.write(s + ";" + l);
            bfw.newLine();
        }
        bfw.close();
        System.out.println("Zapisano do pliku plik.csv");
    }
}
