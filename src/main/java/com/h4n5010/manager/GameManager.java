package com.h4n5010.manager;

import com.h4n5010.functions.GameState;

public class GameManager {

    /**
     *
     */
    public static void start(){
        GameState.setGameState(GameState.INGAME);
    }
}
