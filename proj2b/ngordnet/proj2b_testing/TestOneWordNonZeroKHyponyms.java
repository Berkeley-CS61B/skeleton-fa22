package ngordnet.proj2b_testing;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/** Tests the case where the list of words is one word long, and k is bigger than 1.
 *  For these tests, we create a single studentHandler and reuse it throughout the tests to
 *  allow for faster execution. The first test may take up a minute or more to run while
 *  your handler is instantiated.
 */
public class TestOneWordNonZeroKHyponyms {
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

    /** Tests finding all hyponyms of dash (k = 0) for startYear = 2007, endYear = 2007.
     *  Note: The startYear and endYear should have no effect since k = 0.  */
    @Test
    public void testDashK0in2007() {

        List<String> words = List.of("dash");

        NgordnetQuery nq = new NgordnetQuery(words, 2007, 2007, 0);
        String actual = studentHandler.handle(nq);

        String expected = "[bolt, break, dah, dash, elan, fast_break, flair, hyphen, panache, sprint, style]";
        assertEquals(expected, actual);
    }

    /** Tests finding top hyponym of dash (k = 1) for startYear = 2007, endYear = 2007.
     *  The result should just be ["style"] since potato is the most popular hyponym of dash in 2007 */
    @Test
    public void testDashK1in2007() {
        List<String> words = List.of("dash");

        NgordnetQuery nq = new NgordnetQuery(words, 2007, 2007, 1);
        String actual = studentHandler.handle(nq);

        // The most popular dash in 2007 was style.
        String expected = "[style]";
        assertEquals(expected, actual);
    }

    /** Tests finding top hyponyms of dash (k = 3) for startYear = 2007, endYear = 2007.*/
    @Test
    public void testDashK3in2007() {
        List<String> words = List.of("dash");

        NgordnetQuery nq = new NgordnetQuery(words, 2007, 2007, 3);
        String actual = studentHandler.handle(nq);

        // The three most popular dash hyponyms were bolt, break, and style in alphabetical order
        String expected = "[bolt, break, style]";
        assertEquals(expected, actual);
    }

    /** Tests finding top hyponyms of dash (k = 3) for startYear = 1700, endYear = 1703.*/
    @Test
    public void testDashK3in1700to1703() {

        List<String> words = List.of("dash");

        NgordnetQuery nq = new NgordnetQuery(words, 1700, 1703, 3);
        String actual = studentHandler.handle(nq);

        // The three most popular dash hyponyms were break, dash, and style in alphabetical order
        String expected = "[break, dash, style]";
        assertEquals(expected, actual);
    }

    /** Finds the most popular hyponym from 2007 for the word dog, which happens to be "dog" */
    @Test
    public void testDogK1in2007() {
        List<String> words = List.of("dog");

        NgordnetQuery nq = new NgordnetQuery(words, 2007, 2007, 1);
        String actual = studentHandler.handle(nq);

        /** The three most popular words */
        String expected = "[dog]";
        assertEquals(expected, actual);
    }
}
