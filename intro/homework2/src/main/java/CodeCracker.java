import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class CodeCracker {
    Map<String, String> dictionary = Map.ofEntries(
            entry("a", "!"),
            entry("b", ")"),
            entry("c", "\""),
            entry("d", "("),
            entry("e", "£"),
            entry("f", "*"),
            entry("g", "%"),
            entry("h", "&"),
            entry("i", ">"),
            entry("j", "<"),
            entry("k", "@"),
            entry("l", "a"),
            entry("m", "b"),
            entry("n", "c"),
            entry("o", "d"),
            entry("p", "e"),
            entry("q", "f"),
            entry("r", "g"),
            entry("s", "h"),
            entry("t", "i"),
            entry("u", "j"),
            entry("v", "k"),
            entry("w", "l"),
            entry("x", "m"),
            entry("y", "n"),
            entry("z", "o")
    );

    String encrypt(String message) {
        return splitter(message)
                .map(key -> dictionary.getOrDefault(key, key))
                .collect(Collectors.joining(""));
    }

    String decrypt(String message) {
        return splitter(message)
                .map(value -> dictionary.containsValue(value) ? key(dictionary, value) : value)
                .collect(Collectors.joining(""));
    }

    private Stream<String> splitter(String message) {
        return Arrays.stream(message.split(""));
    }

    public String key(Map<String, String> map, String value) {
        return map
                .entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey).toList().get(0);
    }
}
