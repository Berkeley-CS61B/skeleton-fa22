package ngordnet.proj2b_testing;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/** Tests the case where the list of words is multiple words, and k is bigger than 1.
 *  For these tests, we create a single studentHandler and reuse it throughout the tests to
 *  allow for faster execution. The first test may take up a minute or more to run while
 *  your handler is instantiated.
 */
public class TestMultiWordNonZeroKHyponyms {
    public static final String WORDS_FILE = "data/ngrams/top_14377_words.csv";
    public static final String TOTAL_COUNTS_FILE = "data/ngrams/total_counts.csv";
    public static final String SYNSET_FILE = "data/wordnet/synsets.txt";
    public static final String HYPONYM_FILE = "data/wordnet/hyponyms.txt";

    private static final NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
            WORDS_FILE, TOTAL_COUNTS_FILE, SYNSET_FILE, HYPONYM_FILE);

    @Before
    public void warnUser() {
        System.out.println("Note, this test uses top_14377_words.csv, not top_49887_words.csv!");
    }

    /** Tests finding all hyponyms of child, animal (k = 0) for startYear = 2007, endYear = 2007.
     *  Note: The startYear and endYear should have no effect since k = 0.  */
    @Test
    public void testChildAnimalK0in2007() {

        List<String> words = List.of("child", "animal");

        NgordnetQuery nq = new NgordnetQuery(words, 2007, 2007, 0);
        String actual = studentHandler.handle(nq);

        String expected = "[baby, kid, monkey, nestling, orphan, suckling, yearling]";
        assertEquals(expected, actual);
    }

    /** Tests finding all hyponyms of child, animal (k = 1) for startYear = 2007, endYear = 2007. */
    @Test
    public void testChildAnimalK1in2007() {

        List<String> words = List.of("child", "animal");

        NgordnetQuery nq = new NgordnetQuery(words, 2007, 2007, 1);
        String actual = studentHandler.handle(nq);

        String expected = "[baby]";
        assertEquals(expected, actual);
    }

    /** Tests finding all hyponyms of child, animal (k = 3) for startYear = 2007, endYear = 2007. */
    @Test
    public void testChildAnimalK3in2007() {

        List<String> words = List.of("child", "animal");

        NgordnetQuery nq = new NgordnetQuery(words, 2007, 2007, 3);
        String actual = studentHandler.handle(nq);

        String expected = "[baby, kid, monkey]";
        assertEquals(expected, actual);
    }


    @Test
    public void testMapFunctionK10() {
        List<String> words = List.of("map", "function");

        NgordnetQuery nq = new NgordnetQuery(words, 1900, 2020, 10);
        String actual = studentHandler.handle(nq);
        String expected = "[expansion, function, identity, map, operator, sec, series, sin, transformation, translation]";
        assertEquals(expected, actual);
    }


    @Test
    public void testEnergyLightSparkleK1() {
        List<String> words = List.of("energy", "light", "sparkle");

        NgordnetQuery nq = new NgordnetQuery(words, 1900, 2020, 1);
        String actual = studentHandler.handle(nq);
        String expected = "[light]";
        assertEquals(expected, actual);
    }

    @Test
    public void testEnergyLightBeamK3() {
        List<String> words = List.of("energy", "light", "beam");

        NgordnetQuery nq = new NgordnetQuery(words, 1900, 2020, 3);
        String actual = studentHandler.handle(nq);
        String expected = "[beam, ray, shaft]";
        assertEquals(expected, actual);
    }

}
