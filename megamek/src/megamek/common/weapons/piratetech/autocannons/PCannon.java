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

import megamek.common.AmmoType;
import megamek.common.alphaStrike.AlphaStrikeElement;
import megamek.common.Mounted;
import megamek.common.weapons.autocannons.LBXACWeapon;

/**
 * @author Rumia
 * @since Feb 25, 2024
 */
public class PCannon extends CannonWeapon {
  private static final long serialVersionUID = -6873790245999096707L;

  public PCannon() {
      super();
      this.name = "Pirate Cannon";
      this.setInternalName("PCannon");
      this.addLookupName("Pirate Cannon");
      this.heat = 3;
      this.toHitModifier = 1;
      this.damage = 12;
      this.rackSize = 1;
      this.shortRange = 5;
      this.mediumRange = 11;
      this.longRange = 17;
      this.extremeRange = 23;
      this.tonnage = 10.0;
      this.criticals = 6;
      this.bv = 166;
      this.cost = 150000;
      this.shortAV = 10;
      this.medAV = 10;
      this.maxRange = RANGE_MED;
      rulesRefs = "207, TM";
      techAdvancement.setTechBase(TECH_BASE_IS)
          .setTechRating(RATING_C)
          .setAvailability(RATING_C)
          .setISAdvancement(3047)
          .setISApproximate(false, false, false, false, false);
    }

  @Override
  public double getBattleForceDamage(int range, Mounted fcs) {
    return (range <= AlphaStrikeElement.LONG_RANGE) ? 0.63 : 0;
  }
}
