
package polymorphism;

/* when we 'abstract', it prevents creation of object
 * from the class which is set to abstract so the class
 * is used only for polymorphism and inheritance.
 * In this case, food class cannot be used to create
 * any object. (tutorial 57)
 */
abstract public class food {

    void eat(){
        System.out.println("this is food");
    }

    /*abstract method in a superclass is a method
     which is overridden
    * when it is inherited by a sub class.
    * Also, abstract methods needn't have any body.
     * (tutorial 59)
    */
   public abstract void test();

    

}
