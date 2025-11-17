/*    */ package me.maxfield.randomdrop.listener;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import me.maxfield.randomdrop.Randomdrop;
/*    */ import me.maxfield.randomdrop.Utils.ItemUtil;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerRespawnEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ public class Listeners
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onPlayerDead(PlayerDeathEvent event) {
/* 21 */     if (event.getKeepInventory() && event.getEntity().getPlayer().getGameMode() != GameMode.SPECTATOR && event.getEntity().getPlayer().getGameMode() != GameMode.CREATIVE) {
/* 22 */       ItemUtil.dropPlayerItem(event.getEntity().getPlayer(), ItemUtil.getDropAmount());
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerRespawn(PlayerRespawnEvent event) {
/* 28 */     ArrayList<ItemStack> drop = ItemUtil.getDropList(event.getPlayer());
/* 29 */     if (!drop.isEmpty()) {
/* 30 */       event.getPlayer().sendMessage(ItemUtil.colorString(Randomdrop.getPluginConfig().getString("dropItemMessage").replace("%player%", event.getPlayer()
/* 31 */               .getName()).replace("%location%", ItemUtil.getPlayerLocation(event.getPlayer())).replace("%itemlist%", 
/* 32 */               ItemUtil.getItemsInfo(drop))));
/* 33 */       for (Player serverPlayer : Bukkit.getOnlinePlayers()) {
/* 34 */         serverPlayer.sendMessage(ItemUtil.colorString(Randomdrop.getPluginConfig().getString("dropItemMessage").replace("%player%", event.getPlayer()
/* 35 */                 .getName()).replace("%location%", ItemUtil.getPlayerLocation(event.getPlayer())).replace("%itemlist%", 
/* 36 */                 ItemUtil.getItemsInfo(drop))));
/*    */       }
/* 38 */       ItemUtil.removeDropList(event.getPlayer());
/* 39 */       ItemUtil.removePlayerLocation(event.getPlayer());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\84848\Downloads\Randomdrop-1.1.jar!\me\maxfield\randomdrop\listener\Listeners.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */