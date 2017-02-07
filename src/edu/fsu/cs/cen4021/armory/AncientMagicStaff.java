package edu.fsu.cs.cen4021.armory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

/**
 * Created by ashleyroberts on 2/4/17.
 */
public class AncientMagicStaff extends BasicWeapon implements Weapon {


    AncientMagicStaff() {
        super(50);
    }

    ArrayList<Integer> ancient = new ArrayList<Integer>();


    public int deserialize_staff() throws IOException {
        try{
            FileInputStream file = new FileInputStream("conf/ancientstaff.obj");
            ObjectInputStream in = new ObjectInputStream(file);
            ancient = (ArrayList<Integer>) in.readObject();
            in.close();
            file.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }

        int new_val;


        for(int i=0; i< ancient.size(); i++)
        {
            new_val = ancient.get(i) * ancient.get(i);
            ancient.set(i, new_val);
        }

        ancient.remove(2);
        ancient.remove(5);

        Collections.reverse(ancient);

        int finalVal = ancient.get(1) + ancient.get(3) + ancient.get(7);

        return finalVal;

    }

    @Override
    public int hit() {

        try {
            DAMAGE = deserialize_staff();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return DAMAGE;
    }

    @Override
    public int hit(int armor) {
        int damage = 0;

        double twentyfivePrecent = armor * .25;
        double new_armor = armor - twentyfivePrecent;

        try {
            damage = deserialize_staff();
        } catch (IOException e) {
            e.printStackTrace();
        }

        damage = (int)(damage - new_armor);

        if (damage < 0) {
            return 0;
        }
        return damage;
    }


}
