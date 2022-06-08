package front;

public class Styles {

    public static Styles style;

    //  My styles for graph nodes and edges.
    public String getStyleSheet() {
        return styleSheet;
    }

    private static final String styleSheet =
            "edge {" +
                    "	size: 4px;" +
                    "	fill-color: #804;" +
                    "	fill-mode: dyn-plain;" +
                    "}" +
                    "node {" +
                    "	size: 30px;" +
                    "	fill-color: #808080;" +
                    "}";


//    public String getStyleEdge() {
//        return styleEdge;
//    }
//
//    private static final String styleEdge =
//            "edge {" +
//                    "	size: 2px;" +
//                    "	fill-color:yellow;" +
//                    "	fill-mode: dyn-plain;" +
//                    "}";


    private static final String styleI =  "node {" +
            "	size: 20px;" +
            "	fill-color: #00a86b;" +
            "}";


    public String getStyleI() {
        return styleI;
    }
}
