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
import megamek.common.ToHitData;
import megamek.common.actions.WeaponAttackAction;
import megamek.common.alphaStrike.AlphaStrikeElement;
import megamek.common.weapons.AttackHandler;
import megamek.common.weapons.GRHandler;
import megamek.common.weapons.gaussrifles.GaussWeapon;
import megamek.server.GameManager;

/**
 * @author Rumia
 * @since Feb 25, 2024
 */
public class PBallista extends GaussWeapon {
    private static final long serialVersionUID = -8454131645293473685L;

    public PBallista() {
        super();

        name = "Pirate Ballista Gauss Cannon";
        setInternalName("PBallista");
        addLookupName("Pirate Ballista");
        sortingName = "Gauss C";
        heat = 1;
        damage = 11;
        ammoType = AmmoType.T_BALLISTA;
        shortRange = 5;
        mediumRange = 12;
        longRange = 17;
        extremeRange = 24;
        tonnage = 13.0;
        criticals = 6;
        bv = 166;
        cost = 225000;
        shortAV = 13;
        medAV = 13;
        longAV = 13;
        maxRange = RANGE_LONG;
        explosionDamage = 22;
        rulesRefs = "219, TM";
        flags = flags.andNot(F_PROTO_WEAPON);
        techAdvancement.setTechBase(TECH_BASE_IS)
                .setIntroLevel(false)
                .setUnofficial(false)
                .setTechRating(RATING_E)
                .setAvailability(RATING_E, RATING_F)
                .setISAdvancement(3053, 3062, DATE_NONE, DATE_NONE, DATE_NONE)
                .setISApproximate(false, false, false, false, false)
                .setPrototypeFactions(F_PER)
                .setProductionFactions(F_PER);
    }

    @Override
    protected AttackHandler getCorrectHandler(ToHitData toHit, WeaponAttackAction waa, Game game,
                                              GameManager manager) {
        return new GRHandler(toHit, waa, game, manager);
    }

    @Override
    public double getBattleForceDamage(int range) {
        if (range == AlphaStrikeElement.SHORT_RANGE) {
            return 1.15;
        } else if (range < AlphaStrikeElement.EXTREME_RANGE) {
            return 1.35;
        } else {
            return 0;
        }
    }
}
