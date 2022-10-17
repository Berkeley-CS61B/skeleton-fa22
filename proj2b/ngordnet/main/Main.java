package ngordnet.main;

import ngordnet.hugbrowsermagic.HugNgordnetServer;
import ngordnet.ngrams.NGramMap;

public class Main {
    public static void main(String[] args) {
        HugNgordnetServer hns = new HugNgordnetServer();
        String wordFile = "./data/ngrams/top_49887_words.csv";
        String countFile = "./data/ngrams/total_counts.csv";

        String synsetFile = "./data/wordnet/synsets.txt";
        String hyponymFile = "./data/wordnet/hyponyms.txt";

        NGramMap ngm = new NGramMap(wordFile, countFile);

        hns.startUp();
        hns.register("history", new HistoryHandler(ngm));
        hns.register("historytext", new HistoryTextHandler(ngm));
    }
}
