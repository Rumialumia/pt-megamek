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
import megamek.common.Game;
import megamek.common.Mounted;
import megamek.common.ToHitData;
import megamek.common.actions.WeaponAttackAction;
import megamek.common.alphaStrike.AlphaStrikeElement;
import megamek.common.weapons.AttackHandler;
import megamek.common.weapons.HGRHandler;
import megamek.common.weapons.gaussrifles.GaussWeapon;
import megamek.server.GameManager;

/**
 * @author Rumia
 * @since Feb 25, 2024
 */
public class PHBallista extends GaussWeapon {
    private static final long serialVersionUID = -2379383217525139478L;

    public PHBallista() {
        super();

        name = "Pirate Heavy Ballista Gauss Cannon";
        setInternalName("PHeavyBallista");
        addLookupName("Pirate Heavy Ballista");
        sortingName = "Gauss D";
        heat = 2;
        damage = DAMAGE_VARIABLE;
        ammoType = AmmoType.T_BALLISTA_HEAVY;
        shortRange = 4;
        mediumRange = 9;
        longRange = 14;
        extremeRange = 18;
        damageShort = 19;
        damageMedium = 16;
        damageLong = 7;
        tonnage = 15.0;
        criticals = 10;
        bv = 312;
        cost = 350000;
        shortAV = 20;
        medAV = 15;
        longAV = 5;
        maxRange = RANGE_LONG;
        explosionDamage = 38;
        rulesRefs = "218, TM";
        techAdvancement.setTechBase(TECH_BASE_IS)
                .setIntroLevel(false)
                .setUnofficial(false)
                .setTechRating(RATING_E)
                .setAvailability(RATING_X, RATING_X, RATING_E, RATING_D)
                .setISAdvancement(3059, 3067, DATE_NONE, DATE_NONE, DATE_NONE)
                .setISApproximate(true, false, false, false, false)
                .setPrototypeFactions(F_PER)
                .setProductionFactions(F_PER);
    }

    @Override
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
    protected AttackHandler getCorrectHandler(ToHitData toHit, WeaponAttackAction waa, Game game,
                                              GameManager manager) {
        return new HGRHandler(toHit, waa, game, manager);
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
