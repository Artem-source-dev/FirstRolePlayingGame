public class BatlleLogic  {
    public void fight(Character Hero, Character Enemy, Main.FightCallback fightCallback) {
        Runnable runnable = () -> {
            int turn = 1;
            boolean isFightEnded = false;
            while (!isFightEnded) {
                System.out.println("---Turn" + turn + "---");
                if (turn++ % 2 != 0) {
                    isFightEnded = makeHit(Enemy, Hero, fightCallback);
                } else {
                    isFightEnded = makeHit(Hero, Enemy, fightCallback);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    private Boolean makeHit(Character defender, Character attacker, Main.FightCallback fightCallback) {
        int hit = attacker.attack();
        int defenderHealth = defender.getHealth() - hit;
        if (hit != 0) {
            System.out.println(String.format("%s do hit at %d point!", attacker.getName(), hit));
            System.out.println(String.format("%s have  %d health points...", defender.getName(), defenderHealth));

        } else {
            System.out.println(String.format("%s miss", attacker.getName()));
        }
        if (defenderHealth <= 0 && defender instanceof Hero) {
            System.out.println("Died");
            fightCallback.fightLost();
           return true;
        } else if(defenderHealth <= 0) {
            System.out.println(String.format("Enemy died! You ger %d exp and %d gold ", defender.getExp(), defender.getGold()));
            attacker.setExp(attacker.getExp() + defender.getExp());
            attacker.setGold(attacker.getGold() + defender.getGold());
            fightCallback.fightWin();
            return true;
        } else {
            defender.setHealth(defenderHealth);
            return false;
        }

    }
}
