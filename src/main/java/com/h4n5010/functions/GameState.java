package com.h4n5010.functions;

public enum GameState {

    LOBBY, INGAME;

    public static GameState gameState;

    public static GameState getGameState(){
        return gameState;
    }

    public static void setGameState(GameState gameState){
        GameState.gameState = gameState;
    }
}
