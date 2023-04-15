package kg.game.OOP.general;

import kg.game.OOP.objects.Boss;
import kg.game.OOP.objects.Hero;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.setHealth(900);
        boss.setDamage(100);
        boss.setTypeOfDefend("Magical");
        System.out.println("Health: " + boss.getHealth() + " damage: " + boss.getDamage() + " type of defend: " + boss.getTypeOfDefend());

        System.out.println("Heroes");
        Hero[] heroes=createHeroes();
        for (int i = 0; i < heroes.length; i++) {
            System.out.println("Health:"+heroes[i].getHealth()+" damage:"+heroes[i].getDamage()+" superpower:"+heroes[i].getSuperPower());
        }


    }
    public static Hero[] createHeroes(){
        Hero falconEye  = new Hero(150,100);
        Hero ironMan = new Hero(400,250,"Laser ray");
        Hero captainAmerica = new Hero(300,200,"Shield");

        Hero[] heroes = new Hero[3];
        for (int i = 0; i < heroes.length; i++) {
            heroes[0] = falconEye;
            heroes[1] = ironMan;
            heroes[2] = captainAmerica;
        }
        return heroes;
    }
}


