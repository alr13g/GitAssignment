package edu.fsu.cs.cen4021.armory;

/**
 * Created by ashleyroberts on 2/4/17.
 */
class SimpleMagicalStaff extends BasicWeapon implements Weapon {

    SimpleMagicalStaff() {
        super(80);
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    public int hit(int armor) {

        double twentyPrecent = armor * .2;
        double new_armor = armor - twentyPrecent;

        int damage = (int)(DAMAGE - new_armor);

        if (damage < 0) {
            return 0;
        }
        return damage;
    }

}
