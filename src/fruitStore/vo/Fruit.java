package fruitStore.vo;

public class Fruit {

    private final String name;
    private final String variety;
    private final int price;
    private int count;

    private Fruit(String name, String variety, int price, int count) {
        this.name = name;
        this.variety = variety;
        this.price = price;
        this.count = count;
    }

    public static Fruit fruit(String name, String variety, int price, int count) {
        return new Fruit(name, variety, price, count);
    }

    public String getName() {
        return name;
    }

    public String getVariety() {
        return variety;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void discountFruit(int stock) {
        count -= stock;
    }

    public int countIsZero() {
        if(count == 0) {
            return 1;
        } else {return 0;}
    }

}
