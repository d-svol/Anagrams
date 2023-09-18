import com.foxminded.foxstudent105614.anagram.AnagramGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramGeneratorTest {

	@Test
	void createAnagram_shouldThrowIllegalArgumentException_whenInputIsNull() {
		assertThrows(IllegalArgumentException.class, () -> new AnagramGenerator(null));
	}

	@Test
	void createAnagram_shouldReturnEmptyString_whenInputIsEmpty() {
		AnagramGenerator emptyAnagramGenerator = new AnagramGenerator("");
		String result = emptyAnagramGenerator.createAnagram();
		assertEquals("", result);
	}

	@Test
	void createAnagram_shouldReturnEmptyString_whenInputIsSingleSpace() {
		AnagramGenerator singleSpaceAnagramGenerator = new AnagramGenerator(" ");
		String result = singleSpaceAnagramGenerator.createAnagram();
		assertEquals("", result);
	}

	@Test
	void createAnagram_shouldReturnEmptyString_whenInputContainsSeveralSpace() {
		AnagramGenerator severalSpacesAnagramGenerator = new AnagramGenerator("   ");
		String result = severalSpacesAnagramGenerator.createAnagram();
		assertEquals("", result);
	}

	@Test
	void createAnagram_shouldReturnSameCharacter_whenInputIsSingleCharacter() {
		AnagramGenerator singleCharAnagramGenerator = new AnagramGenerator("A");
		String result = singleCharAnagramGenerator.createAnagram();
		assertEquals("A", result);
	}

	@Test
	void createAnagram_shouldReturnSameCharacter_whenInputIsMultipleSameLetters() {
		AnagramGenerator sameLetterAnagramGenerator = new AnagramGenerator("AAA");
		String result = sameLetterAnagramGenerator.createAnagram();
		assertEquals("AAA", result);
	}

	@Test
	void createAnagram_shouldReturnAnagramAndPreserveCharacter_whenInputIsMixedCaseCharacter() {
		AnagramGenerator mixedCamelCaseGenerator = new AnagramGenerator("aA Bb");
		String result = mixedCamelCaseGenerator.createAnagram();
		assertEquals("Aa bB", result);
	}

	@Test
	void createAnagram_shouldReturnReversed_whenInputContainsDifferentLetters() {
		AnagramGenerator wordAnagramGenerator = new AnagramGenerator("Hello");
		String result = wordAnagramGenerator.createAnagram();
		assertEquals("olleH", result);
	}

	@Test
	void createAnagram_shouldReturnInputAsIs_whenInputContainsOnlyCharacters() {
		AnagramGenerator symbolsAnagramGenerator = new AnagramGenerator("!@#");
		String result = symbolsAnagramGenerator.createAnagram();
		assertEquals("!@#", result);
	}

	@Test
	void createAnagram_shouldReturnAnagram_whenInputIsTwoWords() {
		AnagramGenerator differentWordsGenerator = new AnagramGenerator("Hello world");
		String differentWordAnagram = differentWordsGenerator.createAnagram();
		assertEquals("olleH dlrow", differentWordAnagram);
	}
}
