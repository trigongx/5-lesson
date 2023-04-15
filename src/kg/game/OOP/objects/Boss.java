package kg.game.OOP.objects;

public class Boss {
     private int health;
     private int damage;
     private String typeOfDefend;

     public int getDamage() {
          return damage;
     }

     public void setDamage(int damage) {
          this.damage = damage;
     }

     public int getHealth() {
          return health;
     }

     public void setHealth(int health) {
          this.health = health;
     }

     public String getTypeOfDefend() {
          return typeOfDefend;
     }

     public void setTypeOfDefend(String typeOfDefend) {
          this.typeOfDefend = typeOfDefend;
     }
}
