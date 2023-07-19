package BoardR;


import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardItem> items = new ArrayList<BoardItem>();


    public void addItem(BoardItem item){
        items.add(item);

    }
    public int totalItems(){
        return items.size();
    }
    //clear
    private void clear(){
        items.clear();
    }

    //size
    public int getSize(){
        return items.size();
    }


//    public void add(BoardItem item){
//        this.items.add(item);
//    }
}
