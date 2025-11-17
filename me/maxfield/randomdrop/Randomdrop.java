/*    */ package me.maxfield.randomdrop;
/*    */ import me.maxfield.randomdrop.command.MainCommand;
/*    */ import me.maxfield.randomdrop.listener.Listeners;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public final class Randomdrop extends JavaPlugin {
/* 10 */   private Listeners listeners = new Listeners();
/*    */   
/*    */   private static Randomdrop randomdrop;
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 16 */     randomdrop = this;
/* 17 */     Bukkit.getPluginManager().registerEvents((Listener)this.listeners, (Plugin)this);
/* 18 */     getCommand("randomdrop").setExecutor((CommandExecutor)new MainCommand());
/* 19 */     getConfig().options().copyDefaults(true);
/* 20 */     saveConfig();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onDisable() {}
/*    */ 
/*    */   
/*    */   public static FileConfiguration getPluginConfig() {
/* 29 */     return randomdrop.getConfig();
/*    */   }
/*    */ }


/* Location:              C:\Users\84848\Downloads\Randomdrop-1.1.jar!\me\maxfield\randomdrop\Randomdrop.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */