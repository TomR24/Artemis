/*
 * Copyright © Wynntils 2021.
 * This file is released under AGPLv3. See LICENSE for full license details.
 */
package com.wynntils.core.features.properties;

/**
 * How much impact on gameplay a feature has. For example, a more important feature like a minimap
 * would have a larger impact than a smaller feature like blocking health pots. Subjective.
 */
public enum GameplayImpact {
    SMALL,
    MEDIUM,
    LARGE,
    EXTREME
}
