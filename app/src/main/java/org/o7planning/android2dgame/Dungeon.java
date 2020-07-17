package org.o7planning.android2dgame;

import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private Map[][] rooms;
    private int roomX, roomY;
    private GameSurface gameSurface;
    //public List<Character> currentMonsterList;

    public Dungeon(GameSurface gameSurface) {
        this.gameSurface = gameSurface;
        //this.currentMonsterList = new ArrayList<Character>();
    }

    public void populateMapArray(Map[][] rooms) {
        this.rooms = rooms;
        roomX = 2;
        roomY = 0;
    }


    public Map getCurrentRoom(){
        return this.rooms[this.roomX][this.roomY];
    }

    public void draw(Canvas canvas) {
        Map currRoom = getCurrentRoom();
        if(currRoom != null) {
            currRoom.draw(canvas);
        }
    }

    public void transitionVertical(int direction){ //Direction should be +1 for upwards room change, -1 for downwards
        if(this.roomY + direction >= 0  && this.roomY + direction < this.rooms[0].length) {
            //this.getCurrentRoom().monsterList = new ArrayList<Character>(this.currentMonsterList);
            this.roomY += direction;
            //this.currentMonsterList = new ArrayList<Character>(this.getCurrentRoom().monsterList);
            Log.d("Dungeon","Vertical Transition: " + direction);
        }
    }

    public void transitionHorizontal(int direction){ //Direction should be +1 for right room change, -1 for left
        if(this.roomX + direction >= 0  && this.roomX + direction < this.rooms[0].length) {
            //this.getCurrentRoom().monsterList = new ArrayList<Character>(this.currentMonsterList);
            this.roomX += direction;
            //this.currentMonsterList = new ArrayList<Character>(this.getCurrentRoom().monsterList);
            Log.d("Dungeon","Horizontal Transition: " + direction);
        }
    }




}
