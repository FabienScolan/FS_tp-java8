package java8.ex06;

import java8.data.Person;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.omg.Messaging.SyncScopeHelper;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// tag::formatAge[]
	// (exemple : [age=12])
	String formatAge(Supplier<Person> supplier) {
		// TODO
		return String.format("[age=%d]", supplier.get().getAge());
	}
	// end::formatAge[]

	@Test
    public void test_supplier_formatAge() throws Exception {
        // TODO compléter le test unitaire pour qu'il soit passant
		Supplier<Person> sup = () -> {return new Person("A", "B", 35, "test");};
		String result = formatAge(sup);

        assert result.equals("[age=35]");
    }

	@Test
	public void test_supplier_requireNonNull() throws Exception {

		expectedException.expect(NullPointerException.class);
		expectedException.expectMessage("require non null object");

		// TODO compléter le test unitaire pour qu'il soit passant
		Supplier<String> supplier = () -> {return "require non null object"; };

		// Avec un paramètre null, cette méthode déclenche un
		// NullPointerException
		Objects.requireNonNull(null, supplier);

	}

}
