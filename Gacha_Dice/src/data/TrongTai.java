package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class TrongTai {
    private List<Player> listPlayer = new ArrayList<>(4);
    public TrongTai(Vector<Player> listPlayer){
            this.listPlayer = listPlayer;
    }
    public int[] Random1st(){
        int[] Random = new int[2];
        java.util.Random generator = new Random();
        Random[0] = generator.nextInt(4) ;
        Random[1] = generator.nextInt(4);
        return Random;
    }
    public void tinhDiem(Player player, int score){
        player.setScore(score + player.getScore());
        if (player.getScore() > 21){
            player.setScore(0);
        }
        if (player.getScore() == 21){
            player.setIsWin(true);
        }
    }
    public Player checkOver(){
        for (int i = 0; i < 4; i ++){
            if ((listPlayer.get(i)).getIsWin() == true){
                return listPlayer.get(i);
            }
        }
        return null;
    }
}
