/*
 * Copyright © Wynntils 2021.
 * This file is released under AGPLv3. See LICENSE for full license details.
 */
package com.wynntils.features.debug;

import com.wynntils.core.Reference;
import com.wynntils.core.WynntilsMod;
import com.wynntils.core.features.DebugFeature;
import com.wynntils.mc.event.ResourcePackEvent;
import com.wynntils.wc.event.WorldStateEvent;
import com.wynntils.wc.model.WorldState.State;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ConnectionProgressFeature extends DebugFeature {
    public String getName() {
        return "Connection Progress Feature";
    }

    @Override
    protected boolean onEnable() {
        WynntilsMod.getEventBus().register(this);
        return true;
    }

    @Override
    protected void onDisable() {
        WynntilsMod.getEventBus().unregister(this);
    }

    @SubscribeEvent
    public void onResourcePack(ResourcePackEvent e) {
        Reference.LOGGER.info("Connection confirmed");
    }

    @SubscribeEvent
    public void onStateChange(WorldStateEvent e) {
        if (e.getNewState() == State.WORLD) {
            Reference.LOGGER.info("Entering world " + e.getWorldName());
        } else if (e.getOldState() == State.WORLD) {
            Reference.LOGGER.info("Leaving world");
        }
        String msg =
                switch (e.getNewState()) {
                    case NOT_CONNECTED -> "Disconnected";
                    case CONNECTING -> "Connecting";
                    case CHARACTER_SELECTION -> "In character selection";
                    case HUB -> "On Hub";
                    default -> null;
                };

        if (msg != null) {
            Reference.LOGGER.info("WorldState change: " + msg);
        }
    }
}
