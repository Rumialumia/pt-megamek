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
package megamek.common.weapons.piratetech.autocannons;

import megamek.common.SimpleTechLevel;
import megamek.common.weapons.autocannons.RACWeapon;

/**
 * @author Rumia
 * @since Feb 25, 2024
 */
public class PTISRAC10 extends RACWeapon {
    private static final long serialVersionUID = 7256023025545151994L;

    public PTISRAC10() {
        super();
        this.name = "Rotary AC/10";
        this.setInternalName("ISRotaryAC10");
        this.addLookupName("IS Rotary AC/10");
        this.addLookupName("ISRAC10");
        this.heat = 3;
        this.damage = 10;
        this.rackSize = 10;
        this.shortRange = 3;
        this.mediumRange = 6;
        this.longRange = 9;
        this.extremeRange = 12;
        this.tonnage = 14.0;
        this.criticals = 9;
        this.bv = 287;
        this.cost = 500000;
        this.shortAV = 36;
        this.medAV = 36;
        this.maxRange = RANGE_MED;
        this.explosionDamage = damage;
        rulesRefs = "207, TM";
        techAdvancement.setTechBase(TECH_BASE_IS)
            .setStaticTechLevel(SimpleTechLevel.STANDARD)
            .setTechRating(RATING_E)
            .setAvailability(RATING_X, RATING_X, RATING_E, RATING_D)
            .setISAdvancement(3062, 3068, 3078, DATE_NONE, DATE_NONE)
            .setISApproximate(true, false, false, false, false)
            .setPrototypeFactions(F_FS)
            .setProductionFactions(F_FS);
    }
}
