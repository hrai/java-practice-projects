package assignment1;
import java.io.*;

public class Movie implements Serializable {
	
	private String name;
	private int length;

	//Constructor with arguments
	public Movie(String name, int length) {
		this.name = name;
		this.length = length;
	}

	//Getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public String toString() {
		return "The name of the movie is " + name + ".";
	}
}
