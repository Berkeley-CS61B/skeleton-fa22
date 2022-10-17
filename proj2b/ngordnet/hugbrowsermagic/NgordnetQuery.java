package ngordnet.hugbrowsermagic;

import java.util.List;

/**
 * Created by hug.
 */
public record NgordnetQuery(List<String> words,
        int startYear,
        int endYear,
        int k) {
}
