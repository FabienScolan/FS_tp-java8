package java8.ex02;

import java8.data.Person;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 02 - Filter, Map
 */
public class Optional_02_Test {

	class GoodException extends RuntimeException {
	}

	Predicate<Person> adult = p -> p.getAge() > 18;
	Predicate<Person> aged = p -> p.getAge() > 80;

	@Test
	public void test_optional_filter() throws Exception {

		Person jules = new Person("Hugues", "Jules", 30, "pass");

		Optional<Person> julesOpt = Optional.ofNullable(jules);

		Optional<Person> adultPerson = julesOpt.filter(adult);

		Optional<Person> agedPerson = julesOpt.filter(aged);

		assertThat(adultPerson.isPresent(), is(true));
		assertThat(agedPerson.isPresent(), is(false));
	}

	@Test
	public void test_optional_map() throws Exception {
		Person jules = new Person("Hugues", "Jules", 30, "pass");

		Optional<Person> julesOpt = Optional.of(jules);

		Optional<Integer> julesAge = julesOpt.map((p) -> p.getAge());

		assertThat(julesAge.isPresent(), is(true));
		assertThat(julesAge.get(), is(30));

	}

	@Test(expected = GoodException.class)
	public void test_optional_ifPresent() throws Exception {
		Person jules = new Person("Hugues", "Jules", 30, "pass");

		Optional<Person> julesOpt = Optional.of(jules);

		// TODO appliquer la méthode "filter" à julesOpt avec le prédicat
		// "adult"
		Optional<Integer> res = julesOpt.filter(adult).map((p) -> p.getAge());
		// TODO chaîner avec la méthode "map" pour récupérer l'age
		// TODO utiliser la méthode isPresent pour vérifier que l'age est bien
		// 30, déclencher l'exception GoodException pour valider que la fonction
		// en paramètre de ifPresent a bien été exécutée.
		// julesOpt.filter...;
		res.ifPresent(() -> {throw new GoodException();});
	}
}
