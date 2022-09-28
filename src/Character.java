public abstract class Character implements Fighter{
    protected String name;
    protected int health;
    protected int gold;
    protected int agility;
    protected int exp;
    public int power;




    public Character(String name, int health, int gold, int agility, int exp, int power) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.agility = agility;
        this.exp = exp;
        this.power = power;
    }

    public int attack() {
        if (agility * 3 > getRandomValue()) return power;
        else return 0;
    }


    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
    }

    public int getAgility() {
        return agility;
    }

    public int getExp() {
        return exp;
    }

    public int getPower() {
        return power;
    }

    public void setName(String name) {
        name = name;
    }

    public void setHealth(int health) {
        health = health;
    }

    public void setGold(int gold) {
        gold = gold;
    }

    public void setAgility(int agility) {
        agility = agility;
    }

    public void setExp(int exp) {
        exp = exp;
    }

    public void setPower(int power) {
        power = power;
    }
    @Override
    public String toString() {
        return String.format("%s health: %d", name, health);
    }
}
