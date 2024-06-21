package com.ursite.pdo;

import java.util.ArrayList;

public class PlayerConnected {
  String userName;
  ArrayList<String> playerList;

  public PlayerConnected(String userName, ArrayList<String> playerList) {
    this.userName = userName;
    this.playerList = playerList;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public ArrayList<String> getPlayerList() {
    return playerList;
  }

  public void setPlayerList(ArrayList<String> playerList) {
    this.playerList = playerList;
  }
}
