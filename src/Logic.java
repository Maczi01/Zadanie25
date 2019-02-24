import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Logic {

    LoadData ld = new LoadData();

    public List<Player> createList() {
        List<Player> gracze = new ArrayList<>();
        return gracze;
    }

    public Player createrPlayer(){
        Player p = new Player();
        return p;
    }

    public List<Player> addToList(List<Player> listagraczy) {
        String name = " ";
        Integer score = null;
        do {
            Player player = createrPlayer();
            name = ld.loadNames();
            if(!isStop(name)){
                score = ld.loadPoints();
            }
            player.setName(name);
            player.setScore(score);
            if (!isStop(name))
                listagraczy.add(player);
        } while (!isStop(name));
        return listagraczy;
    }

    public boolean isStop(String line) {
        final String STOP = "STOP";
        if (!line.equalsIgnoreCase(STOP)) {
            return false;
        }
        return true;
    }
}
