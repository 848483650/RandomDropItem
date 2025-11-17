/*    */ package me.maxfield.randomdrop.command;
/*    */ 
/*    */ import me.maxfield.randomdrop.Randomdrop;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class MainCommand
/*    */   implements CommandExecutor {
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
/* 15 */     if (!(sender instanceof Player)) {
/* 16 */       sender.sendMessage("本指令只有游戏里面可以使用");
/* 17 */       return true;
/*    */     } 
/* 19 */     if (sender.isOp()) {
/* 20 */       if (args.length > 0) {
/* 21 */         if (args[0].equalsIgnoreCase("reload")) {
/* 22 */           ((Randomdrop)Randomdrop.getPlugin(Randomdrop.class)).reloadConfig();
/* 23 */           sender.sendMessage("" + ChatColor.GREEN + "重新加载配置成功！");
/* 24 */           return true;
/* 25 */         }  if (args[0].equalsIgnoreCase("add")) {
/* 26 */           ItemStack itemStack = ((Player)sender).getItemInHand();
/* 27 */           if (itemStack.getType() != Material.AIR) {
/* 28 */             String configItemList = Randomdrop.getPluginConfig().getString("notDropItemList");
/* 29 */             if (!configItemList.contains(itemStack.getType().name())) {
/* 30 */               StringBuffer stringBuffer = new StringBuffer(configItemList);
/* 31 */               stringBuffer.append(" " + itemStack.getType().name());
/* 32 */               Randomdrop.getPluginConfig().set("notDropItemList", stringBuffer.toString());
/* 33 */               ((Randomdrop)Randomdrop.getPlugin(Randomdrop.class)).saveConfig();
/* 34 */               sender.sendMessage("" + ChatColor.GREEN + "添加成功！");
/*    */             } else {
/* 36 */               String newConfig = configItemList.replace(itemStack.getType().name(), "");
/* 37 */               Randomdrop.getPluginConfig().set("notDropItemList", newConfig);
/* 38 */               ((Randomdrop)Randomdrop.getPlugin(Randomdrop.class)).saveConfig();
/* 39 */               sender.sendMessage("" + ChatColor.GREEN + "删除成功！");
/*    */             } 
/*    */           } else {
/* 42 */             sender.sendMessage("" + ChatColor.RED + "请在手上拿着物品");
/*    */           } 
/* 44 */           return true;
/*    */         } 
/* 46 */         sender.sendMessage("" + ChatColor.RED + "/randomdrop reload或者add");
/* 47 */         return true;
/*    */       } 
/*    */     } else {
/*    */       
/* 51 */       sender.sendMessage("" + ChatColor.RED + "您没有权限使用这个指令");
/* 52 */       return true;
/*    */     } 
/* 54 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\84848\Downloads\Randomdrop-1.1.jar!\me\maxfield\randomdrop\command\MainCommand.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */