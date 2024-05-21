/*
 * MegaMek - Copyright (C) 2004, 2005 Ben Mazur (bmazur@sev.org)
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */
package megamek.common.weapons.piratetech.lasers;

import megamek.common.SimpleTechLevel;
import megamek.common.weapons.lasers.LaserWeapon;

/**
 * @author Meows
 * @since Feb 26, 2024
 */
public class PTISMBinaryLaserCannon extends LaserWeapon {
    private static final long serialVersionUID = -6849916948609019186L;

    public PTISMBinaryLaserCannon() {
        super();
        name = "Medium Binary Laser (Blazer) Cannon";
        setInternalName(name);
        addLookupName("IS Medium Binary Laser Cannon");
        addLookupName("ISMBlazer");
        addLookupName("ISMBinaryLaserCannon");
        addLookupName("ISMBinaryLaser");
        addLookupName("Medium Blazer Cannon");
        heat = 5;
        damage = 8;
        shortRange = 3;
        mediumRange = 6;
        longRange = 9;
        extremeRange = 12;
        waterShortRange = 2;
        waterMediumRange = 4;
        waterLongRange = 6;
        waterExtremeRange = 8;
        tonnage = 1.5;
        criticals = 2;
        bv = 82;
        cost = 80000;
        shortAV = 12;
        medAV = 12;
        maxRange = RANGE_SHORT;
        // Tech Progression tweaked to combine IntOps with TRO Prototypes/3145 NTNU RS
        rulesRefs = "319, TO";
        techAdvancement.setTechBase(TECH_BASE_IS)
                .setTechRating(RATING_D)
                .setAvailability(RATING_X, RATING_E, RATING_E, RATING_D)
                .setISAdvancement(2812, DATE_NONE, 3077)
                .setPrototypeFactions(F_FW)
                .setProductionFactions(F_WB).setStaticTechLevel(SimpleTechLevel.STANDARD);
    }
}
