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

import megamek.common.AmmoType;
import megamek.common.Compute;
import megamek.common.Game;
import megamek.common.SimpleTechLevel;
import megamek.common.ToHitData;
import megamek.common.actions.WeaponAttackAction;
import megamek.common.alphaStrike.AlphaStrikeElement;
import megamek.common.weapons.AttackHandler;
import megamek.common.weapons.LBXHandler;
import megamek.common.weapons.gaussrifles.GaussWeapon;
import megamek.server.GameManager;

/**
 * @author Meows
 * @since Feb 26, 2024
 */
public class PTISSilverBulletLightGauss extends GaussWeapon {
    private static final long serialVersionUID = -6873790245999096707L;

    public PTISSilverBulletLightGauss() {
        super();
        name = "Silver Bullet Light Gauss Rifle";
        setInternalName("ISSBLGR");
        addLookupName("IS Silver Bullet Light Gauss Rifle");
        addLookupName("ISSBLGaussRifle");
        sortingName = "Gauss LX";
        heat = 1;
        damage = 8;
        rackSize = 8;
        minimumRange = 3;
        shortRange = 8;
        mediumRange = 17;
        longRange = 25;
        extremeRange = 34;
        tonnage = 12.0;
        criticals = 5;
        bv = 98;
        cost = 320000;
        shortAV = 5; // Due to LBXHandler
        medAV = 5;   // Due to LBXHandler
        longAV = 5;  // Due to LBXHandler
        maxRange = RANGE_LONG;
        ammoType = AmmoType.T_SBLGAUSS;
        // SB Gauss rifles can neither benefit from a targeting computer nor
        // do they add to its mass and size (TacOps pp. 314/5); thus, the
        // "direct fire" flag inherited from the superclass needs to go again.
        flags = flags.or(F_NO_AIM).andNot(F_DIRECT_FIRE);
        atClass = CLASS_LBX_AC;
        explosionDamage = 16;
        rulesRefs = "314, TO";
        //Tech Progression tweaked to combine IntOps with TRO Prototypes/3145 NTNU RS
        techAdvancement.setTechBase(TECH_BASE_IS).setTechRating(RATING_E)
                .setAvailability(RATING_X, RATING_X, RATING_F, RATING_E)
                .setISAdvancement(3051, DATE_NONE, 3080,DATE_NONE, DATE_NONE)
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
        return new LBXHandler(toHit, waa, game, manager);
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
    public int getBattleForceClass() {
        return BFCLASS_FLAK;
    }
}
