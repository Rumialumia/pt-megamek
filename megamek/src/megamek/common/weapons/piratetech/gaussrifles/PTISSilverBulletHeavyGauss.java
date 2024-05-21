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
package megamek.common.weapons.piratetech.gaussrifles;

import megamek.common.*;
import megamek.common.alphaStrike.AlphaStrikeElement;
import megamek.common.actions.WeaponAttackAction;
import megamek.common.weapons.AttackHandler;
import megamek.common.weapons.LBXHandler;
import megamek.common.weapons.PTHSBGRHandler;
import megamek.common.weapons.gaussrifles.GaussWeapon;
import megamek.server.GameManager;

/**
 * @author Meows
 * @since Feb 26, 2024
 */
public class PTISSilverBulletHeavyGauss extends GaussWeapon {
    private static final long serialVersionUID = -6873790245999096707L;

    public PTISSilverBulletHeavyGauss() {
        super();
        name = "Silver Bullet Heavy Gauss Rifle";
        setInternalName("ISSBHGR");
        addLookupName("IS Silver Bullet Heavy Gauss Rifle");
        addLookupName("ISSBHGaussRifle");
        sortingName = "Gauss HX";
        heat = 2;
        damage = DAMAGE_VARIABLE;
        damageShort = 25;
        damageMedium = 20;
        damageLong = 10;
        minimumRange = 3;
        shortRange = 6;
        mediumRange = 12;
        longRange = 19;
        extremeRange = 24;
        tonnage = 20.0;
        criticals = 11;
        bv = 238;
        cost = 810000;
        shortAV = 13; // Due to LBXHandler
        medAV = 13;   // Due to LBXHandler
        longAV = 13;  // Due to LBXHandler
        maxRange = RANGE_LONG;
        ammoType = AmmoType.T_SBHGAUSS;
        // SB Gauss rifles can neither benefit from a targeting computer nor
        // do they add to its mass and size (TacOps pp. 314/5); thus, the
        // "direct fire" flag inherited from the superclass needs to go again.
        flags = flags.or(F_NO_AIM).andNot(F_DIRECT_FIRE);
        atClass = CLASS_LBX_AC;
        explosionDamage = 30;
        rulesRefs = "314, TO";
        //Tech Progression tweaked to combine IntOps with TRO Prototypes/3145 NTNU RS
        techAdvancement.setTechBase(TECH_BASE_IS).setTechRating(RATING_E)
                .setAvailability(RATING_X, RATING_X, RATING_F, RATING_E)
                .setISAdvancement(3065, DATE_NONE, 3081,DATE_NONE, DATE_NONE)
                .setPrototypeFactions(F_FS, F_LC)
                .setProductionFactions(F_FC)
                .setStaticTechLevel(SimpleTechLevel.STANDARD);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * megamek.common.weapons.Weapon#getCorrectHandler(megamek.common.ToHitData,
     * megamek.common.actions.WeaponAttackAction, megamek.common.Game)
     */
    @Override
    protected AttackHandler getCorrectHandler(ToHitData toHit, WeaponAttackAction waa, Game game,
                                              GameManager manager) {
        return new PTHSBGRHandler(toHit, waa, game, manager);
    }

    public int getDamage(int range) {
      if (range <= shortRange) {
        return damageShort;
      }

      if (range <= mediumRange) {
        return damageMedium;
      }

      return damageLong;
    }

    @Override
    public double getBattleForceDamage(int range) {
        double damage = 0;
        if (range <= getLongRange()) {
            damage = Compute.calculateClusterHitTableAmount(7, getRackSize()) / 10.0;
            damage *= 1.05; // -1 to hit
            if ((range == AlphaStrikeElement.SHORT_RANGE) && (getMinimumRange() > 0)) {
                damage = adjustBattleForceDamageForMinRange(damage);
            }
        }
        return damage;
    }

    @Override
    public double getBattleForceDamage(int range, Mounted fcs) {
      if (range == AlphaStrikeElement.LONG_RANGE) {
        return 1;
      } else if (range == AlphaStrikeElement.MEDIUM_RANGE) {
        return 2;
      } else if (range == AlphaStrikeElement.SHORT_RANGE) {
        return 1.65;
      } else {
        return 0;
      }
  }
}
