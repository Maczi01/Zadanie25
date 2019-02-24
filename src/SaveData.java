import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class SaveData {

    public void makeFile(List<Player> list) throws IOException {
        sorting(list);
        FileWriter fileWriter = new FileWriter("plik.csv");
        BufferedWriter bfw = new BufferedWriter(fileWriter);
        for (Player p : list) {
            int l = p.getScore();
            String n = p.getName();
            bfw.write(n + ";" + l);
            bfw.newLine();
        }
        bfw.close();
        System.out.println("Zapisano do pliku plik.csv");
    }

    public void sorting(List<Player>unsortedList){
        Collections.sort(unsortedList);
    }


}
