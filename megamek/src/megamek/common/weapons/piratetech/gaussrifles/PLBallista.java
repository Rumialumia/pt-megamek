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
import megamek.common.weapons.AttackHandler;
import megamek.common.weapons.GRHandler;
import megamek.common.weapons.gaussrifles.GaussWeapon;
import megamek.server.GameManager;

/**
 * @author Rumia
 * @since Feb 25, 2024
 */
public class PLBallista extends GaussWeapon {
    private static final long serialVersionUID = 8971550996626387100L;

    public PLBallista() {
        super();
        name = "Pirate Light Ballista Gauss Cannon";
        setInternalName("PLightBallista");
        addLookupName("Pirate Light Ballista");
        sortingName = "Gauss B";
        heat = 1;
        damage = 6;
        ammoType = AmmoType.T_BALLISTA_LIGHT;
        shortRange = 6;
        mediumRange = 13;
        longRange = 19;
        extremeRange = 26;
        tonnage = 10.0;
        criticals = 3;
        bv = 159;
        cost = 275000;
        shortAV = 8;
        medAV = 8;
        longAV = 8;
        extAV = 8;
        maxRange = RANGE_EXT;
        explosionDamage = 12;
        rulesRefs = "219, TM";
        techAdvancement.setTechBase(TECH_BASE_IS)
                .setIntroLevel(false)
                .setUnofficial(false)
                .setTechRating(RATING_E)
                .setAvailability(RATING_E, RATING_E, RATING_E, RATING_D)
                .setISAdvancement(3054, 3065, DATE_NONE, DATE_NONE, DATE_NONE)
                .setISApproximate(true, false, false, false, false)
                .setPrototypeFactions(F_PER)
                .setProductionFactions(F_PER);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * megamek.common.weapons.Weapon#getCorrectHandler(megamek.common.ToHitData,
     * megamek.common.actions.WeaponAttackAction, megamek.common.Game,
     * megamek.server.Server)
     */
    @Override
    protected AttackHandler getCorrectHandler(ToHitData toHit, WeaponAttackAction waa, Game game,
                                              GameManager manager) {
        return new GRHandler(toHit, waa, game, manager);
    }

}
