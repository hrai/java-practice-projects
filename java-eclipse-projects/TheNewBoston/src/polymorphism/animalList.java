
package polymorphism;

public class animalList {
    private animal[] list = new animal[10];
    private int i = 0;

    public void add(animal a){
        if(i<list.length){
            list[i]=a;
            System.out.println("Animal added at index "+i);
            i++;
        }
    }

}
