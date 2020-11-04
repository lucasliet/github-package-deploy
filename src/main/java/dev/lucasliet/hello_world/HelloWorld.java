package dev.lucasliet.hello_world;

import java.util.List;

public class HelloWorld {
	public static void main(String[] args) {
		List<String> words = List.of("Hello"," ", "dear", " ", "World");
		words.stream().map(word -> word.toUpperCase()).forEach(System.out::print);;
	}
}
