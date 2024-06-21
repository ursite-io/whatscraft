package com.ursite;

import com.ursite.pdo.PlayerConnected;

import com.google.gson.Gson;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerConnectedListener implements Listener {
     @EventHandler
     public void onPlayerJoin(PlayerJoinEvent event) {
          try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
               String userConnected = event.getPlayer().getName();
               ArrayList<String> userList = new ArrayList<String>();

               for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    if (player.getName() != userConnected) {
                         userList.add(player.getName());
                    }
               }

               PlayerConnected username = new PlayerConnected(userConnected, userList);

               Gson gson = new Gson();
               String json = gson.toJson(username);
               StringEntity body = new StringEntity(json);

               // System.out.println(json);

               HttpPost request = new HttpPost("http://127.0.0.1:3000/dev/whatscraft/sendMessage");
               request.setEntity(body);
               request.addHeader("Accept", "application/json");
               request.setHeader("Content-type", "application/json");

               try (CloseableHttpResponse response = httpClient.execute(request)) {
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                         String result = EntityUtils.toString(entity);
                         // System.out.println(result);
                    }
               }

          } catch (Exception e) {
               e.printStackTrace();
          }
     }
}