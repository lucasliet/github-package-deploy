package dev.lucasliet.hello_world;

import java.util.List;

public class HelloWorld {
	public static void main(String[] args) {
		var words = List.of("Hello"," ","Dear"," ","World");
		words.stream().map(word -> word.toUpperCase()).forEach(System.out::print);
	}
}