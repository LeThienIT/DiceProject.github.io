package data;

import java.util.Random;

public class Dice {
    private int[] dsSoCham = new int[100];
    public Dice(int tiLe20){
        for (int i = 0; i < 20; i++){
            dsSoCham[i] = tiLe20;
        }
        int soTT = 0;
        for (int j = 1; j <7 ; j ++){
            if (j != tiLe20){
                for (int k =0 ; k < 16 ; k++){
                    int location = 20 + 16 * soTT + k ;
                    dsSoCham[location] = j;
                }
                soTT++;
            }
        }
    }
    public int Roll(){
        Random generator = new Random();
        int i = generator.nextInt(100);
        return dsSoCham[(generator.nextInt(100))];
    }
}
