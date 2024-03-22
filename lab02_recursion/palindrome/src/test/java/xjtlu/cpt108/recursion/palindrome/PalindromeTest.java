package xjtlu.cpt108.recursion.palindrome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PalindromeTest {

	protected static Stream<Arguments> data() {
		return Stream.of(//
				Arguments.of("", false) //
				, Arguments.of("a", true) //
				, Arguments.of("abc", false) //
				, Arguments.of("This is not a palindrome!", false) //
				, Arguments.of("abcba", true) //
				, Arguments.of("abcdba", false) //
				, Arguments.of("bird rib", true) //
				, Arguments.of("Never odd or even", true) //
				, Arguments.of("Race car", true) //
				, Arguments.of("Eva, can I see bees in a cave?", true) //
				, Arguments.of("Step on no pets!", true) //
				, Arguments.of(12321, true) //
				, Arguments.of(90109, true) //
				, Arguments.of(90119, false) //
				, Arguments.of(1231, false) //

		);
	}

	@ParameterizedTest(name = "run #{index} with [arguments={arguments}]")
	@MethodSource(value = "data")
	public void testRecursive(Object str, boolean expectedAns) {
		Palindrome palindrome = new Palindrome();

		String s = str.toString();

		System.out.printf("%s: %s\n", str, palindrome.verifyRecursive(s));
		if (expectedAns) {
			assertTrue(palindrome.verifyRecursive(s));
		} else {
			assertFalse(palindrome.verifyRecursive(s));
		}

	}

	@ParameterizedTest(name = "run #{index} with [arguments={arguments}]")
	@MethodSource(value = "data")
	public void testIterative(Object str, boolean expectedAns) {
		Palindrome palindrome = new Palindrome();

		String s = str.toString();

		System.out.printf("%s: %s\n", str, palindrome.verifyIterative(s));
		if (expectedAns) {
			assertTrue(palindrome.verifyIterative(s));
		} else {
			assertFalse(palindrome.verifyIterative(s));
		}

	}

}
