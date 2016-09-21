package com.pspl;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Created by shwetaswarnkar on 16/08/16.
 */
public class PersonTest {

	public static void main(String args[]) {

		List<Person> persons = new ArrayList();
		Person person = new Person("Shweta" , LocalDate.of(1983, Month.AUGUST,14), Person.Sex.FEMALE,33);
		persons.add(person);

		person = new Person("Sangita" , LocalDate.of(1987, Month.FEBRUARY,14), Person.Sex.FEMALE,28);
		persons.add(person);

		person = new Person("Baban" , LocalDate.of(1985, Month.AUGUST,6), Person.Sex.MALE,30);
		persons.add(person);

		person = new Person("Aditi" , LocalDate.of(1989, Month.MARCH,16), Person.Sex.FEMALE,25);
		persons.add(person);

		person = new Person("Ronit" , LocalDate.of(1992, Month.APRIL,14), Person.Sex.MALE,24);
		persons.add(person);

		person = new Person("Prashant" , LocalDate.of(1987, Month.MARCH,28), Person.Sex.MALE,25);
		persons.add(person);

		persons.stream().filter(p -> p.getGender() == Person.Sex.MALE ).forEach(p -> System.out.print(p.getName() +"\n"));

		double averageAge = persons.stream().filter(person1 -> person1.getGender() == Person.Sex.FEMALE).
				mapToInt(Person ::getAge).average().getAsDouble();

		System.out.println("Average Age : "+averageAge);

		Map<Person.Sex, List<Person>> personList = persons.parallelStream().
				collect(Collectors.groupingBy(Person::getGender));


		ConcurrentMap<Person.Sex, List<Person>> byGender =
				persons
						.parallelStream()
						.collect(
								Collectors.groupingByConcurrent(Person::getGender));

	}

}
