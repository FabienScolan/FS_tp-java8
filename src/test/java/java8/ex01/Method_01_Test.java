package java8.ex01;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

	// tag::IDao[]
	interface IDao {
		List<Person> findAll();

		default int sumAge() {
			int result = 0;
			for (Person p : findAll()) {
				result += p.getAge();
			}
			return result;

		}
	}
	// end::IDao[]

	class DaoA implements IDao {

		List<Person> people = Data.buildPersonList(20);

		@Override
		public List<Person> findAll() {
			return people;
		}

	}

	class DaoB implements IDao {

		List<Person> people = Data.buildPersonList(100);

		@Override
		public List<Person> findAll() {
			return people;
		}

	}

	@Test
	public void test_daoA_sumAge() throws Exception {

		DaoA daoA = new DaoA();

		// TODO invoquer la méthode sumAge pour que le test soit passant
		int result = 0;
		for (Person p : daoA.people) {
			result += p.getAge();
		}
		assert result == daoA.sumAge();
	}

	@Test
	public void test_daoB_sumAge() throws Exception {

		DaoB daoB = new DaoB();

		// TODO invoquer la méthode sumAge pour que le test soit passant
		int result = 0;
		for (Person p : daoB.people) {
			result += p.getAge();
		}
		assert result == daoB.sumAge();

	}
}
