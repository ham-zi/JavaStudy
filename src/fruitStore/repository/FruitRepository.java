package fruitStore.repository;

import fruitStore.vo.Fruit;

import java.util.List;

public interface FruitRepository {
    public void registerFruit(Fruit fruit);
    public List<Fruit>getFruits();
    public void removeFruit(Fruit fruit);
}
