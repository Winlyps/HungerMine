package winlyps.realhunger;

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
            blockCount++;
            if (blockCount == 15) {
                Player player = event.getPlayer();
                player.setFoodLevel(Math.max(0, player.getFoodLevel() - 2));
                blockCount = 0;
            }
        }

        @EventHandler(priority = EventPriority.MONITOR)
        public void onBlockPlaceEvent(BlockPlaceEvent event) {
            blockCount++;
            if (blockCount == 15) {
                Player player = event.getPlayer();
                player.setFoodLevel(Math.max(0, player.getFoodLevel() - 2));
                blockCount = 0;
            }
        }
    }
}



















