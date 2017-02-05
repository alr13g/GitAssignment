package edu.fsu.cs.cen4021.armory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ashleyroberts on 2/4/17.
 */
public class TheChosenOneAxe extends BasicWeapon implements Weapon{

    TheChosenOneAxe() { super(60);}
    int finalNum = 0;

    public int do_read() throws IOException
    {
        File fin = new File("conf/thechosenone.txt");

        BufferedReader br = new BufferedReader(new FileReader(fin));
        int lineNumber = 3;

        String line = br.readLine();
        String next = br.readLine();
        String third = br.readLine();

        String found = null;
        String comparison = null;

        if(line.equals(next)) {
            comparison = line;
        }

        else {
             if(line.equals(third))
                 found = next;
             else
                 found = line;
        }

       if(found == null) {

            while ((line = br.readLine()) != null) {
                lineNumber++;

                if(!comparison.equals(line)) {
                   finalNum = lineNumber;
                   break;
                }
           }
       }

       return finalNum;
    }

    @Override
    public int hit() {
        try {
            DAMAGE = do_read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DAMAGE ;
    }

    @Override
    public int hit(int armor) {
        int damage = 0;

        try {
            damage = do_read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (armor > 0 && armor < 20)
            damage = damage;
        else
            damage = damage - armor;

        if (damage < 0) {
            return 0;
        }
        return damage;
    }

}
