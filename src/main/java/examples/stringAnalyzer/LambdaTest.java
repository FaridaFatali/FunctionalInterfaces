package examples.stringAnalyzer;

public class LambdaTest {
    public static void main(String[] args) {
        String[] strList01 = { "tomorrow", "toto", "to", "ticktock", "the", "hello", "heat" };

        AnalyzerTool stringTool = new AnalyzerTool();
        String searchStr = "to";

        System.out.println("Searching for: " + searchStr);

        System.out.println("\n*** Contains ***");
        StringAnalyzer sa = (t, s) -> t.contains(s);
        System.out.println("tomorrow has to: " + sa.analyze("tomorrow", searchStr));

        stringTool.showResult(strList01, searchStr, (t, s) -> t.contains(s));

        System.out.println("\n*** Starts With ***");
        stringTool.showResult(strList01, searchStr, (t, s) -> t.startsWith(s));

        System.out.println("\n*** Equals ***");
        stringTool.showResult(strList01, searchStr, (t, s) -> t.equals(s));

        System.out.println("\n*** Ends With ***");
        stringTool.showResult(strList01, searchStr, (t, s) -> t.endsWith(s));

        sa = (a, b) -> a.endsWith(b);
        sa = (String a, String b) -> a.endsWith(b);

        System.out.println("\nWhich one is longer");

    }
}
