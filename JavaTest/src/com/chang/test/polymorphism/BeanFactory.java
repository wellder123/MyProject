package com.chang.test.polymorphism;

/**
 * 多态+静态工厂的模拟
 * @author Administrator
 *
 */
public class BeanFactory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Animal a = Dog.getInstance();
        chooseAnimal(a);
	}
	
	public static void chooseAnimal(Animal a){
		a.run();
	}

}

class Dog implements Animal{
	private static Dog d = new Dog("a");
	
	public static Dog getInstance(){
		return d;
	}
	
	public Dog(String s){
		System.out.println(s+" dog is generated...");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("A dog is running...");
	}
}

class Cat implements Animal {
    private static Cat c = new Cat();
	
	public static Cat getInstance(){
		return c;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("A cat is running...");
	}
}
