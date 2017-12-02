package org.java.learn.util.tuple;

/**
 * 作用: User: duqi Date: 2017/11/19 Time: 16:36
 */
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {

    public final D forth;

    public FourTuple(A first, B second, C third, D forth) {
        super(first, second, third);
        this.forth = forth;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + "," + forth + ")";
    }
}
