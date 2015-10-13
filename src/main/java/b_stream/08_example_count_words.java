package b_stream;

import java.util.stream.Stream;

class CountWords {

    public static void main(String[] args) {
        // count the number of words with more than 3 letters.

        Stream<String> words = Stream.of("This", "eBook", "is", "for", "the", "use", "of", "anyone", "anywhere", "at", "no",
                "cost", "and", "with", "almost", "no", "restrictions", "whatsoever.", "", "You", "may", "copy", "it,",
                "give", "it", "away", "or", "re-use", "it", "under", "the", "terms", "of", "the", "Project",
                "Gutenberg", "License", "included", "with", "this", "eBook", "or", "online", "at", "www.gutenberg.net");

        System.out.println(words.filter(w -> w.length() > 3).count());
    }
}
