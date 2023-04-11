import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static int[] heroesHealth = {280, 270, 250, 350, 700, 200, 270, 300};
    public static int[] heroesDamage = {10, 15, 20, 0, 5, 7, 10, 18};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic", "Golem", "LuckyHero", "Berserk", "thor"};
    public static int roundNumber = 0;


    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            playRound();
        }
    }
    public static void thorSkill() {

        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[7] > 0) {
                Random random = new Random();
                boolean isBlind = random.nextBoolean();
                if (isBlind) {
                    bossDamage = 0;
                } else {
                    bossDamage = 50;
                }
            }
        }

    }
    public static void berserkSkill() {
        int berserkDamage = heroesDamage[6];
        int shield = bossDamage/3;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesDamage[6]>30){
                heroesDamage[6] = berserkDamage;
            }
            if (heroesHealth[6] > 0) {
                heroesHealth[6] += shield;
                if (heroesDamage[6] <= 30){
                    heroesDamage[6] += shield;
                }
                break;
            }
        }
    }
    public static void luckySkill(){
        Random random = new Random();
        boolean godge;
        godge = random.nextBoolean();
        for (int i = 0; i < heroesHealth.length; i++) {
            if (godge = true){
                heroesHealth[5] = heroesHealth[4] + 50;
            }
            else {
                heroesHealth[4] -=bossDamage;
            }
        }

    }
    public static void medicHeal() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesAttackType[i].equals("Medic")) {
                continue;
            } else if (heroesHealth[i] < 100 && heroesHealth[i] > 0 && heroesHealth[3] > 0) {
                heroesHealth[i] += 50;
                System.out.println("Медик вылечил:" + heroesAttackType[i]);
                break;
            }
        }
    }


        public static void chooseBossWeakness () {
            Random random = new Random();
            int randomIndex = random.nextInt(heroesAttackType.length); // 0,1,2
            bossDefence = heroesAttackType[randomIndex];
        }

        public static void playRound () {
            roundNumber++;
            chooseBossWeakness();
            heroesHit();
            thorSkill();
            berserkSkill();
            luckySkill();
            bossHitsGolemTakes();
            bossHits();
            medicHeal();
            printStatistics();

        }

        public static void heroesHit () {
            for (int i = 0; i < heroesDamage.length; i++) {
                if (heroesHealth[i] > 0 && bossHealth > 0) {
                    int damage = heroesDamage[i];
                    if (bossDefence == heroesAttackType[i]) {
                        Random random = new Random();
                        int coeff = random.nextInt(8) + 2; // 2,3,4,5,6,7,8,9
                        damage = damage * coeff;
                        System.out.println("Critical damage: " + damage);
                    }
                    if (bossHealth - damage < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth -= damage;
                    }
                }
            }
        }

        public static void bossHits () {
            for (int i = 0; i < heroesHealth.length; i++) {
                if (heroesHealth[i] > 0) {
                    if (heroesHealth[i] - bossDamage < 0) {
                        heroesHealth[i] = 0;
                    } else {
                        heroesHealth[i] -= bossDamage ; // heroesHealth[i] = heroesHealth[i] - bossDamage;
                    }
                }
            }
        }
        public static void bossHitsGolemTakes(){
            for (int i = 0; i <heroesHealth.length; i++) {
                if (heroesHealth[i] > 0) {
                    if (heroesHealth[i] - bossDamage < 0) {
                        heroesHealth[i] = 0;
                    }

                    if (heroesHealth[4] > 0) {
                        int golemDamageTaken = bossDamage / 5;
                        heroesHealth[4] -= golemDamageTaken;
                        heroesHealth[i] -= bossDamage - golemDamageTaken;
                    } else {
                        heroesHealth[i] -= bossDamage;
                    }
                }
            }
        }
        public static boolean isGameFinished () {
            if (bossHealth <= 0) {
                System.out.println("Heroes won!!!");
                return true;
            }
        /*if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;*/
            boolean allHeroesDead = true;
            for (int i = 0; i < heroesHealth.length; i++) {
                if (heroesHealth[i] > 0) {
                    allHeroesDead = false;
                    break;
                }
            }
            if (allHeroesDead) {
                System.out.println("Boss won!!!");
            }
            return allHeroesDead;
        }

        public static void printStatistics () {
            System.out.println("ROUND " + roundNumber + " ---------------");
        /*String defence;
        if (bossDefence == null) {
            defence = "No defence";
        } else {
            defence = bossDefence;
        }*/
            System.out.println("Boss health: " + bossHealth + " damage: " + bossDamage + " weakness: "
                    + (bossDefence == null ? "No defence" : bossDefence));
            for (int i = 0; i < heroesHealth.length; i++) {
                System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i]
                        + " damage: " + heroesDamage[i]);
            }
        }

    }

