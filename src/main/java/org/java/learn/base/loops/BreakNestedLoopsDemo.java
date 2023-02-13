package org.java.learn.base.loops;

public class BreakNestedLoopsDemo {

    public static void main(String[] args) {
        withBreakKeyword();
    }

    private static void withBreakKeyword() {
        StringBuilder result = new StringBuilder();
        for (int outterCounter = 0; outterCounter < 3; outterCounter++) {
            result.append("outCounter").append(outterCounter).append("\n");
            for (int innerCounter = 0; innerCounter < 4; innerCounter++) {
                result.append("\t" + "innerCounter").append(innerCounter);
                if (innerCounter == 1) {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
