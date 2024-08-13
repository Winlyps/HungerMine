package winlyps.realhunger;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class RealHunger extends JavaPlugin {

    private int blockCount = 0;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private class BlockListener implements org.bukkit.event.Listener {
        @EventHandler(priority = EventPriority.MONITOR)
        public void onBlockBreakEvent(BlockBreakEvent event) {
            Block block = event.getBlock();
            if (!isCrop(block.getType())) {
                blockCount++;
                if (blockCount == 30) {
                    Player player = event.getPlayer();
                    player.setFoodLevel(Math.max(0, player.getFoodLevel() - 2));
                    blockCount = 0;
                }
            }
        }

        @EventHandler(priority = EventPriority.MONITOR)
        public void onBlockPlaceEvent(BlockPlaceEvent event) {
            blockCount++;
            if (blockCount == 30) {
                Player player = event.getPlayer();
                player.setFoodLevel(Math.max(0, player.getFoodLevel() - 2));
                blockCount = 0;
            }
        }

        private boolean isCrop(Material material) {
            return material == Material.WHEAT ||
                    material == Material.CARROTS ||
                    material == Material.POTATOES ||
                    material == Material.BEETROOTS ||
                    material == Material.NETHER_WART ||
                    material == Material.COCOA ||
                    material == Material.SUGAR_CANE ||
                    material == Material.BAMBOO ||
                    material == Material.CACTUS ||
                    material == Material.SWEET_BERRY_BUSH ||
                    material == Material.KELP_PLANT ||
                    material == Material.KELP ||
                    material == Material.GLOW_BERRIES ||
                    material == Material.RED_MUSHROOM ||
                    material == Material.BROWN_MUSHROOM ||
                    material == Material.CRIMSON_FUNGUS ||
                    material == Material.WARPED_FUNGUS;
        }
    }
}



















