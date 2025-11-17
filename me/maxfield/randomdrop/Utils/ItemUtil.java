/*     */ package me.maxfield.randomdrop.Utils;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Random;
/*     */ import me.maxfield.randomdrop.Randomdrop;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ 
/*     */ public class ItemUtil
/*     */ {
/*  17 */   private static HashMap<Player, ArrayList<ItemStack>> playerItemList = new HashMap<>();
/*  18 */   private static HashMap<Player, String> playerLocation = new HashMap<>();
/*  19 */   private static final FileConfiguration config = Randomdrop.getPluginConfig();
/*  20 */   private static final int dropAmount = config.getInt("dropAmount");
/*     */ 
/*     */   
/*     */   public static void dropPlayerItem(Player player, int dropAmount) {
/*  24 */     PlayerInventory playerInventory = player.getInventory();
/*     */     
/*  26 */     ArrayList<ItemStack> drop = new ArrayList<>();
/*     */     
/*  28 */     for (int dropA = dropAmount; dropA > 0; dropA--) {
/*  29 */       int slot = (new Random()).nextInt(playerInventory.getSize());
/*  30 */       ItemStack itemStack = player.getInventory().getItem(slot);
/*  31 */       if (itemStack != null && 
/*  32 */         itemStack.getType() != Material.AIR && 
/*  33 */         !Randomdrop.getPluginConfig().getString("notDropItemList").contains(itemStack.getType().name())) {
/*  34 */         player.getWorld().dropItem(player.getLocation(), itemStack);
/*  35 */         drop.add(itemStack);
/*  36 */         player.getInventory().setItem(slot, new ItemStack(Material.AIR));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  41 */     if (!drop.isEmpty()) {
/*  42 */       Location location = player.getLocation();
/*  43 */       int lX = (int)location.getX();
/*  44 */       int lY = (int)location.getY();
/*  45 */       int lZ = (int)location.getZ();
/*  46 */       addPlayerLocation(player, player.getLocation().getWorld().getName() + " X:" + player.getLocation().getWorld().getName() + " Y:" + lX + " Z:" + lY);
/*  47 */       addDropList(player, drop);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getItemsInfo(ArrayList<ItemStack> itemStacks) {
/*  52 */     StringBuilder stringBuilder = new StringBuilder();
/*  53 */     for (ItemStack itemStack : itemStacks) {
/*  54 */       stringBuilder.append(getItemInfo(itemStack) + " ");
/*     */     }
/*  56 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static String colorString(String string) {
/*  60 */     string = ChatColor.translateAlternateColorCodes('&', string);
/*  61 */     return string;
/*     */   }
/*     */   public static String getItemInfo(ItemStack itemStack) {
/*     */     String name;
/*  65 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  67 */     if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
/*  68 */       name = itemStack.getItemMeta().getDisplayName();
/*     */     } else {
/*  70 */       name = itemStack.getType().name();
/*     */     } 
/*  72 */     int amount = itemStack.getAmount();
/*  73 */     stringBuilder.append(ChatColor.YELLOW).append(name).append(" x" + amount).append("\n");
/*  74 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static int getDropAmount() {
/*  78 */     return dropAmount;
/*     */   }
/*     */   
/*     */   public static HashMap<Player, ArrayList<ItemStack>> getPlayerItemList() {
/*  82 */     return playerItemList;
/*     */   }
/*     */   
/*     */   public static ArrayList<ItemStack> getDropList(Player player) {
/*  86 */     ArrayList<ItemStack> list = new ArrayList<>();
/*  87 */     if (playerItemList.containsKey(player)) {
/*  88 */       list = playerItemList.get(player);
/*     */     }
/*     */     
/*  91 */     return list;
/*     */   }
/*     */   
/*     */   public static void addDropList(Player player, ArrayList<ItemStack> drops) {
/*  95 */     if (!playerItemList.containsKey(player)) {
/*  96 */       playerItemList.put(player, drops);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removeDropList(Player player) {
/* 102 */     if (playerItemList.containsKey(player)) {
/* 103 */       playerItemList.remove(player);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addPlayerLocation(Player player, String location) {
/* 109 */     if (!playerLocation.containsKey(player)) {
/* 110 */       playerLocation.put(player, location);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getPlayerLocation(Player player) {
/* 115 */     if (playerLocation.containsKey(player)) {
/* 116 */       return playerLocation.get(player);
/*     */     }
/* 118 */     return "Error001";
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removePlayerLocation(Player player) {
/* 123 */     if (playerLocation.containsKey(player)) {
/* 124 */       playerLocation.remove(player);
/*     */     }
/*     */   }
/*     */   
/*     */   public static HashMap<Player, String> getPlayerLocation() {
/* 129 */     return playerLocation;
/*     */   }
/*     */ }


/* Location:              C:\Users\84848\Downloads\Randomdrop-1.1.jar!\me\maxfield\randomdrop\Utils\ItemUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */