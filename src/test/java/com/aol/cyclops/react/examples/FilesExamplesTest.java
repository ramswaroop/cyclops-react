package com.aol.cyclops.react.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.jooq.lambda.Unchecked;
import org.junit.Test;

import com.aol.cyclops.control.LazyReact;

public class FilesExamplesTest {

	@Test
	public void test() throws IOException {
		
		LazyReact react = new LazyReact(100,110);
		react.fromStream(Files.walk(Paths.get(".")))
		//	 .map(Unchecked.function(Files::readAllBytes))
			.map(d->{ throw new RuntimeException("hello");})
			.map(Object::toString)
			 .recover(e->"hello world")
			// .flatMap(s->Stream.of(s.split("\n")))
			 .forEach(System.out::println);
		
	}

}
