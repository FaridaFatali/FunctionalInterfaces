package examples.stringAnalyzer;

@FunctionalInterface
public interface StringAnalyzer {
    boolean analyze(String target, String searchStr);
}
