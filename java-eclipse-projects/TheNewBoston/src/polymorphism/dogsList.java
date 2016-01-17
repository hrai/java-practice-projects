
package polymorphism;

public class dogsList {

    private dog[] d = new dog[10];
    private int i = 0;

    public void add(dog name){
        if(i<d.length){
            d[i]=name;
            System.out.println("The added dog's name is "+d[i]);
            i++;
        }
    }


}
