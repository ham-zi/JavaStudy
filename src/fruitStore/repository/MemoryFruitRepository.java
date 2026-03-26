package fruitStore.repository;

import fruitStore.vo.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MemoryFruitRepository implements FruitRepository{
    private final List<Fruit> fruits = new ArrayList<>();
    private Fruit fruit;



    @Override
    public void registerFruit(String name,String variety, int price, int count) {
       fruit = Fruit.fruit(name, variety, price, count);
       fruits.add(fruit);
    }


    @Override
    public List<Fruit> getFruits() {
        return fruits;
    }

    @Override
    public void removeFruit(Fruit fruit) {
        fruits.remove(fruit);
    }

}
