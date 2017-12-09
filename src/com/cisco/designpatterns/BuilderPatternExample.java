package com.cisco.designpatterns;
/**
 * 1) Make a static nested class called Builder inside the class whose object will be build by Builder. In this example its Cake.

2) Builder class will have exactly same set of fields as original class.
3) Builder class will expose method for adding ingredients e.g. sugar() in this example. each method will return same Builder object. Builder will be enriched with each method call.

4) Builder.build() method will copy all builder field values into actual class and return object of Item class.
5) Item class (class for which we are creating Builder) should have private constructor to create its object from build() method and prevent outsider to access its constructor.


Read more: http://javarevisited.blogspot.com/2012/06/builder-design-pattern-in-java-example.html#ixzz50Ys60ah3
 * @author mkarni
 *
 */
public class BuilderPatternExample {

	public static void main(String[] args) {
		// Builder is a static class inside Cake having methods which take ingredients and return Builder object
		//At the end call build of Builder to call outter class's constructor passing its own reference to create Cake object.
		Cake cake = new Cake.Builder().bakingPowder(1).sugar(10).build();
		//

	}
	
	 

}

class Cake{
	private int sugar;
	private int butter;
	private int eggs;
	private int vannila;
	private int flour;
	private float bakingPowder;
	private double milk;
	private int cherry;
	
	
	private Cake(Builder builder){
		this.sugar = builder.getSugar();
		this.butter = builder.getButter();
		this.eggs = builder.getEggs();
		this.vannila = builder.getVannila();
		this.flour = builder.getFlour();
	}
	
	public static class Builder{
		
		private int sugar;
		private int butter;
		private int eggs;
		private int vannila;
		private int flour;
		private float bakingPowder;
		private double milk;
		private int cherry;
		
		public int getSugar() {
			return sugar;
		}
		public Builder sugar(int sugar) {
			this.sugar = sugar;
			return this;
		}
		public int getButter() {
			return butter;
		}
		public Builder butter(int butter) {
			this.butter = butter;
			return this;
		}
		public int getEggs() {
			return eggs;
		}
		public Builder eggs(int eggs) {
			this.eggs = eggs;
			return this;
		}
		public int getVannila() {
			return vannila;
		}
		public Builder vannila(int vannila) {
			this.vannila = vannila;
			return this;
		}
		public int getFlour() {
			return flour;
		}
		public Builder flour(int flour) {
			this.flour = flour;
			return this;
		}
		public float getBakingPowder() {
			return bakingPowder;
		}
		public Builder bakingPowder(float bakingPowder) {
			this.bakingPowder = bakingPowder;
			return this;
		}
		public double getMilk() {
			return milk;
		}
		public Builder milk(double milk) {
			this.milk = milk;
			return this;
		}
		public int getCherry() {
			return cherry;
		}
		public Builder cherry(int cherry) {
			this.cherry = cherry;
			return this;
		}
		
		public Cake build(){
			return new Cake(this);
		}
		
	}
	
	@Override
    public String toString() {
        return "Cake{" + "sugar=" + sugar + ", butter=" + butter + ", eggs=" + eggs + ", vanila=" + vannila + ", flour=" + flour + ", bakingpowder=" + bakingPowder + ", milk=" + milk + ", cherry=" + cherry + '}';

    } 

//Read more: http://javarevisited.blogspot.com/2012/06/builder-design-pattern-in-java-example.html#ixzz50YrMDASq
	
}
