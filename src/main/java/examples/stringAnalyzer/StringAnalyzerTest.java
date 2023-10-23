package examples.stringAnalyzer;

public class StringAnalyzerTest {
    private static String[] strList = {"tomorrow", "toto", "to", "ticktock", "the", "hello", "heat"};
    private static String searchStr = "to";

    public static void main(String[] args) {
        System.out.println("Search for: " + searchStr);
        search1();
        search2(strList, searchStr, new ContainsAnalyzer());

        ContainsAnalyzer contains = new ContainsAnalyzer();
        search2(strList, searchStr, contains);

        search2(strList, searchStr, new StringAnalyzer() {
            @Override
            public boolean analyze(String target, String searchStr) {
                return target.contains(searchStr);
            }
        });

        StringAnalyzer sa = (String target, String search) -> target.contains(search);
        search2(strList, searchStr, sa);

        search2(strList, searchStr, (String target, String search) -> {
            return target.contains(search);
        });

        System.out.println("\nStarts with:");
        StringAnalyzer sa2 = (target, search) -> target.endsWith(search);
        search2(strList, searchStr, sa2);

        System.out.println("\nEnds with:");
        StringAnalyzer sa3 = (target, search) -> target.startsWith(search);
        search2(strList, searchStr, sa3);

        System.out.println("\nLength:");
        StringAnalyzer sa4 = (target, search) -> target.length() > search.length();
        search2(strList, searchStr, sa4);
    }

    public static void search1() {
        System.out.println("\nin search1():");
        StringAnalyzer contains = new ContainsAnalyzer();
        System.out.println("*** Contains ***");
        for (String currentStr : strList) {
            if (contains.analyze(currentStr, searchStr)) {
                System.out.println("Match: " + currentStr);
            }
        }
    }

    public static void search2(String[] strList, String searchStr, StringAnalyzer analyzer) {
        System.out.println("\nin search2():");
        System.out.println("*** Contains ***");
        for (String currentStr : strList) {
            if (analyzer.analyze(currentStr, searchStr)) {
                System.out.println("Match: " + currentStr);
            }
        }
    }
}
