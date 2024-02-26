/*
 * MegaMek - Copyright (C) 2004, 2005 Ben Mazur (bmazur@sev.org)
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
package megamek.common.weapons.piratetech.autocannons;

import megamek.common.Mounted;
import megamek.common.SimpleTechLevel;
import megamek.common.weapons.autocannons.HVACWeapon;

/**
 * @author Jason Tighe
 * @since Sep 25, 2004
 */
public class ISHVAC20 extends HVACWeapon {
  private static final long serialVersionUID = 4958849713169213573L;

  public ISHVAC20() {
    super();
    name = "HVAC/20";
    setInternalName("Hyper Velocity Auto Cannon/20");
    addLookupName("IS Hyper Velocity Auto Cannon/20");
    addLookupName("ISHVAC20");
    addLookupName("IS Hyper Velocity Autocannon/20");
    heat = 12;
    damage = 20;
    rackSize = 20;
    shortRange = 4;
    mediumRange = 8;
    longRange = 12;
    extremeRange = 16;
    tonnage = 16.0;
    criticals = 9;
    bv = 253;
    cost = 345000;
    shortAV = 15;
    medAV = 15;
    longAV = 15;
    maxRange = RANGE_LONG;
    explosionDamage = 20;
    rulesRefs = "285, TO";
    // Tech Progression tweaked to combine IntOps with TRO Prototypes/3145 NTNU RS
    techAdvancement.setTechBase(TECH_BASE_IS)
        .setTechRating(RATING_D)
        .setAvailability(RATING_X, RATING_X, RATING_F, RATING_E)
        .setISAdvancement(3059, 3079)
        .setPrototypeFactions(F_CC).setProductionFactions(F_CC)
        .setStaticTechLevel(SimpleTechLevel.ADVANCED);
  }

  @Override
  public double getBattleForceDamage(int range, Mounted ignore) {
    return 1;
  }

}
