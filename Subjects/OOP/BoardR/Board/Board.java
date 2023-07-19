package BoardR.Board;


import BoardR.Loggers.Logger;

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

    public void displayHistory() {
        for (BoardItem item : items) {
            System.out.println(item.getHistory());
        }
    }
    public void displayHistory(Logger logger) { // accept a Logger type
        for (BoardItem item : items) {
            // call the log() method and give it a string. (the viewHistory() method returns a String)
            logger.log(item.getHistory());
        }
    }

//    public void add(BoardItem item){
//        this.items.add(item);
//    }
}
