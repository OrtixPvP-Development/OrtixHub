package com.ortixpvp.hub.api.frozedtab.runnable;

import com.ortixpvp.hub.api.frozedtab.adapter.TabAdapter;
import com.ortixpvp.hub.api.frozedtab.entry.TabEntry;
import com.ortixpvp.hub.api.frozedtab.latency.TabLatency;
import com.ortixpvp.hub.api.frozedtab.layout.TabLayout_v1_8;
import com.ortixpvp.hub.api.frozedtab.skin.Skin;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Ryzeon
 * Project: TabAPI
 * Date: 11/12/2020 @ 10:08
 */

@AllArgsConstructor
public class TabRunnable_v1_8 implements Runnable {
    private TabAdapter adapter;

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (TabLayout_v1_8.getLayoutMapping().containsKey(player.getUniqueId())) {
                TabLayout_v1_8 layout = TabLayout_v1_8.getLayoutMapping().get(player.getUniqueId());

                for (TabEntry entry : adapter.getLines(player)) {
                    layout.update(entry.getColumn(), entry.getRow(), entry.getText(), entry.getPing(), entry.getSkin());
                }

                for (int row = 0; row < 20; row++) {
                    for (int column = 0; column < 3; column++) {
                        if (layout.getByLocation(adapter.getLines(player), column, row) == null) {
                            layout.update(column, row, "", TabLatency.NO_BAR.getValue(), Skin.DEFAULT_SKIN);
                        }
                    }
                }
            }
        }
    }
}
