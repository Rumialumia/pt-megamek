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
package megamek.common.weapons.piratetech.misc;

import megamek.common.AmmoType;
import megamek.common.Game;
import megamek.common.Mounted;
import megamek.common.ToHitData;
import megamek.common.actions.WeaponAttackAction;
import megamek.common.alphaStrike.AlphaStrikeElement;
import megamek.common.weapons.AmmoWeapon;
import megamek.common.weapons.AttackHandler;
import megamek.common.weapons.PTPBurnBarrelHandler;
import megamek.common.weapons.PlasmaCannonHandler;
import megamek.common.weapons.PlasmaRifleHandler;
import megamek.server.GameManager;

/**
 * @author Rumia
 * @since March 2nd, 2024
 */
public class PTPBurnBarrel extends AmmoWeapon {
    private static final long serialVersionUID = -7919371014161089388L;

    public PTPBurnBarrel() {
        name = "Burn Barrel (P)";
        setInternalName("PBurnBarrel");
        heat = 5;
        damage = DAMAGE_VARIABLE;
        rackSize = 2;
        ammoType = AmmoType.T_BURNBARREL;
        minimumRange = WEAPON_NA;
        shortRange = 5;
        mediumRange = 10;
        longRange = 15;
        extremeRange = 20;
        tonnage = 4.0;
        criticals = 3;
        flags = flags.or(F_MECH_WEAPON).or(F_TANK_WEAPON).or(F_AERO_WEAPON)
                .or(F_PLASMA).or(F_PROTO_WEAPON).or(F_DIRECT_FIRE).or(F_BALLISTIC);
        bv = 146;
        cost = 320000;
        shortAV = 10;
        medAV = 10;
        maxRange = RANGE_MED;
        atClass = CLASS_PLASMA;
        rulesRefs = "234, TM";
        techAdvancement.setTechBase(TECH_BASE_IS)
              .setIntroLevel(false)
              .setUnofficial(false)
              .setTechRating(RATING_B)
              .setAvailability(RATING_C)
              .setISAdvancement(3047)
              .setISApproximate(true);
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
        return new PTPBurnBarrelHandler(toHit, waa, game, manager);
    }

    @Override
    public int getAlphaStrikeHeatDamage(int rangeband) {
        return (rangeband <= AlphaStrikeElement.RANGE_BAND_MEDIUM) ? 3 : 0;
    }
}
