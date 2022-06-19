package blogStudy;

import java.util.*;

public class 제네릭 {

    public static void main(String[] args) {

//        AnimalList<LandAnimal> landAnimal = new AnimalList<>(); // Java SE 7부터 생략 가능
//
//        landAnimal.add(new LandAnimal());
//        landAnimal.add(new Cat());
//        landAnimal.add(new Dog());
//
//        for(int i = 0; i < landAnimal.size(); i++)
//        {
//            landAnimal.get(i).crying();
//        }

        AnimalList<Cat> catList = new AnimalList<>();
        catList.add(new Cat());
        AnimalList<Dog> dogList = new AnimalList<>();
        dogList.add(new Dog());

        AnimalList.cryingAnimalList(catList);
        AnimalList.cryingAnimalList(dogList);
    }

}



class LandAnimal
{
    public void crying()
    {
        System.out.println("육지동물");
    }
}

class Cat extends LandAnimal
{
    public void crying()
    {
        System.out.println("냐옹냐옹");
    }
}


class Dog extends LandAnimal
{
    public void crying()
    {
        System.out.println("멍멍");
    }
}


class Sparrow
{
    public void crying()
    {
        System.out.println("짹짹");
    }
}

class AnimalList<T extends LandAnimal>
{

    ArrayList<T> al = new ArrayList<T>();

    public static void cryingAnimalList(AnimalList<? extends LandAnimal> al) {
        LandAnimal la = al.get(0);
        la.crying();
    }

    void add(T animal)
    {
        al.add(animal);
    }

    T get(int index)
    {
        return al.get(index);
    }

    boolean remove(T animal)
    {
        return al.remove(animal);
    }

    int size()
    {
        return al.size();
    }

}






