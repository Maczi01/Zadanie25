import javax.sound.sampled.Line;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Logic l = new Logic();
        SaveData sd = new SaveData();
        List<Player> listagraczy = l.createList();
        l.addToList(listagraczy);
        sd.makeFile(listagraczy);
    }
}
