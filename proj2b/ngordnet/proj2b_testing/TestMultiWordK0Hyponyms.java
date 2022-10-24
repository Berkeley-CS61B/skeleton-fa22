package ngordnet.proj2b_testing;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/** Tests the case where the list of words is length greater than 1, but k is still zero. */
public class TestMultiWordK0Hyponyms {
    // this case doesn't use the NGrams dataset at all, so the choice of files is irrelevant
    public static final String WORDS_FILE = "data/ngrams/very_short.csv";
    public static final String TOTAL_COUNTS_FILE = "data/ngrams/total_counts.csv";
    public static final String SMALL_SYNSET_FILE = "data/wordnet/synsets16.txt";
    public static final String SMALL_HYPONYM_FILE = "data/wordnet/hyponyms16.txt";
    public static final String LARGE_SYNSET_FILE = "data/wordnet/synsets.txt";
    public static final String LARGE_HYPONYM_FILE = "data/wordnet/hyponyms.txt";

    /** This is an example from the spec.*/
    @Test
    public void testOccurrenceAndChangeK0() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("occurrence", "change");

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[alteration, change, increase, jump, leap, modification, saltation, transition]";
        assertEquals(expected, actual);
    }

    /** This is an example from the spec on the full hyponyms and synsets file.*/
    @Test
    public void testBowlGalleryK0() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);
        List<String> words = List.of("bowl", "gallery");

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[amphitheater, amphitheatre]";
        assertEquals(expected, actual);
    }

    /** This is another example from the spec where the user enters female, animal. */
    @Test
    public void testFemaleAnimalK0() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);
        List<String> words = List.of("female", "animal");

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "You have to fill in this text yourself. Hint: COPY FROM THE SPEC!";
        assertEquals(expected, actual);
    }

    /** This is another example from the spec where the user enters female, leader. */
    @Test
    public void testFemaleLeaderK0() {
        System.out.println("NOTE: For the female, leader test, you have to fill in the expected text AND List<String> words yourself, otherwise this test will likely crash due to a null pointer exception");

        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);
        List<String> words = null; // <-- replace with the appropriate list of words!

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "You have to fill in this text yourself. Hint: COPY FROM THE SPEC!";
        assertEquals(expected, actual);
    }

    @Test
    public void testEnergyLightSparkleK0() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);
        List<String> words = List.of("energy", "light", "sparkle"); // <-- replace with the appropriate list of words!

        NgordnetQuery nq = new NgordnetQuery(words, 0, 0, 0);
        String actual = studentHandler.handle(nq);
        String expected = "[light, scintillation, spark, sparkle, twinkle]";
        assertEquals(expected, actual);
    }
}
