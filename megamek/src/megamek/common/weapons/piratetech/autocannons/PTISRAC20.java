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
public class PTISRAC20 extends RACWeapon {
    private static final long serialVersionUID = 1212976417295270466L;

    public PTISRAC20() {
        super();
        this.name = "Rotary AC/20";
        this.setInternalName("ISRotaryAC20");
        this.addLookupName("IS Rotary AC/20");
        this.addLookupName("ISRAC20");
        this.heat = 7;
        this.damage = 20;
        this.rackSize = 20;
        this.shortRange = 2;
        this.mediumRange = 4;
        this.longRange = 6;
        this.extremeRange = 8;
        this.tonnage = 16.0;
        this.criticals = 12;
        this.bv = 314;
        this.cost = 800000;
        this.shortAV = 57;
        this.medAV = 57;
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
