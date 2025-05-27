import java.util.ArrayList;
import java.util.Collections;
public class War {
    ArrayList<Integer> first_belligerent = new ArrayList<Integer>(52);
    ArrayList<Integer> second_belligerent = new ArrayList<Integer>(52);
    
    int first_belligerent_count = 0;
    int second_belligerent_count = 0;
    
    public War(){
        for(int i = 0; i < 4;i++){
            for(int l = 2; l < 15; l++){
                first_belligerent.add(l);
                second_belligerent.add(l);
            }
        }
        
        Collections.shuffle(first_belligerent);
        Collections.shuffle(second_belligerent);
    }


    public void war_game(){
        while(first_belligerent.size() > 0 && second_belligerent.size() > 0){
            war_compare(first_belligerent.remove(0),second_belligerent.remove(0),false);
    }
    System.out.println("First Belligerent: " + first_belligerent_count);
    System.out.println("Second Belligerent: " + second_belligerent_count);

    }


    private void war_compare(int first_belligerent_card, int second_belligerent_card, boolean isWar){

            if(first_belligerent_card > second_belligerent_card){
                if(isWar){first_belligerent_count+=10;}
                else{first_belligerent_count+=2;}
            }
            else if (first_belligerent_card < second_belligerent_card){
                if(isWar){second_belligerent_count+=10;}
                else{second_belligerent_count+=2;}
            }
            else if(first_belligerent_card == second_belligerent_card){
                if(first_belligerent.size() > 4 && second_belligerent.size() > 4){
                    System.out.println("\tWAR!");
                    System.out.println(first_belligerent.remove(0) + " And: " + second_belligerent.remove(0));
                    System.out.println(first_belligerent.remove(0) + " And: " + second_belligerent.remove(0));
                    System.out.println(first_belligerent.remove(0) + " And: " + second_belligerent.remove(0));
                    war_compare(first_belligerent.remove(0), second_belligerent.remove(0),true);
                }
                else{System.out.println("Not enough cards");}
            }
    }

}