package fruitStore.repository;

import fruitStore.vo.Fruit;

import java.util.List;

public interface FruitRepository {
    public void registerFruit(String name,String variety, int price, int count);
    public List<Fruit>getFruits();
    public void removeFruit(Fruit fruit);
}
