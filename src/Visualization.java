import java.util.ArrayList;
import java.util.List;

public class Visualization{
    private int timesTable;
    private List<Dot> dotList;
    private int numDots;

    public Visualization(int times, int dots){
        timesTable = times;
        numDots = dots;
        setDotList();
    }

    private void setDotList(){
        dotList = new ArrayList<>();
        int dist = 400/(numDots/2);
        int tempDist, mult;

        if(numDots%2 != 0){ numDots += 1; }

        tempDist = 0;
        dotList.add(new Dot(1, 0, 200));
        for(int i = 2; i <= numDots; i++){
            if(i <= numDots/2){
                tempDist += dist;
                dotList.add(new Dot(i));
                dotList.get(i-1).setX(tempDist);
            }
            else if(i == (numDots/2)+1){ dotList.add(new Dot(i, 400, 200)); }
            else{
                tempDist -= dist;
                dotList.add(new Dot(i));
                dotList.get(i-1).setX(tempDist);
            }
        }
        mult = -1;
        tempDist = 200;
        for(int j = 1; j < numDots; j++){
            if(tempDist == 0 || tempDist == 400){ mult *= -1; }
            tempDist += dist*mult;
            dotList.get(j).setY(tempDist);
        }
    }

    public int[] getDot(int i){
        return new int[] { dotList.get(i).getX(), dotList.get(i).getY() };
    }
}
