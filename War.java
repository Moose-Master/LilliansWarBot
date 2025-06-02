import java.util.ArrayList;
import java.util.Collections;
public class War {
    ArrayList<String> first_belligerent = new ArrayList<String>(52);
    ArrayList<String> second_belligerent = new ArrayList<String>(52);
    
    int first_belligerent_count = 0;
    int second_belligerent_count = 0;
    String[] suits = {"♠","♥","♦","♣"};
    
    Logger logger = new Logger();
    NiceNums nnums = new NiceNums();
    //nnums.niceNums.get();
    public War(){
        for(int i = 0; i < 4;i++){
            for(int l = 2; l < 15; l++){
                first_belligerent.add(suits[i] + l);
                second_belligerent.add(suits[i] + l);
            }
        }
        
        Collections.shuffle(first_belligerent);
        Collections.shuffle(second_belligerent);
        logger.write("First Belligerent \t\t Second Belligerent");
    }


    public void war_game(){
        while(first_belligerent.size() > 0 && second_belligerent.size() > 0){
            war_compare(first_belligerent.remove(0),second_belligerent.remove(0),false);
    }
    System.out.println("First Belligerent: " + first_belligerent_count);
    System.out.println("Second Belligerent: " + second_belligerent_count);
    logger.write("\t\t\tFirst Belligerent: " + first_belligerent_count);
    logger.write("\t\t\tSecond Belligerent: " + second_belligerent_count);
    logger.close();
    }


    private void war_compare(String first_belligerent_cardS, String second_belligerent_cardS, boolean isWar){
            
            int first_belligerent_card = Integer.parseInt(first_belligerent_cardS.substring(1));
            int second_belligerent_card = Integer.parseInt(second_belligerent_cardS.substring(1));

            first_belligerent_cardS = first_belligerent_cardS.substring(0,1) + nnums.niceNums.get(first_belligerent_card);
            second_belligerent_cardS = second_belligerent_cardS.substring(0,1) + nnums.niceNums.get(second_belligerent_card);
            
            logger.write("\t\t\t\t" + first_belligerent_cardS + "\tVS\t" + second_belligerent_cardS);
            
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
                    logger.write("\t\t\t\t\tWAR!");
                    
                    for(int l = 0; l < 3; l ++){
                    first_belligerent_cardS = first_belligerent.remove(0);
                    second_belligerent_cardS = second_belligerent.remove(0);

                    first_belligerent_card = Integer.parseInt(first_belligerent_cardS.substring(1));
                    second_belligerent_card = Integer.parseInt(second_belligerent_cardS.substring(1));

                    first_belligerent_cardS = first_belligerent_cardS.substring(0,1) + nnums.niceNums.get(first_belligerent_card);
                    second_belligerent_cardS = second_belligerent_cardS.substring(0,1) + nnums.niceNums.get(second_belligerent_card);
            
                    logger.write("\t\t\t\t" + first_belligerent_cardS + "\t  \t" + second_belligerent_cardS);
                    }
                    
                    war_compare(first_belligerent.remove(0), second_belligerent.remove(0),true);
                }
                else{
                    System.out.println("Not enough cards");
                    logger.write("\t\t\tNot Enough Card for war");
                }
            }
    }

}