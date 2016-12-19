package org.java.learn.java8;

import com.google.common.base.Joiner;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 有了Java 8，很多之前需要Guava的地方，现在可以直接使用JDK提供的接口
 *
 * 参考文章1：https://www.mkyong.com/java8/java-8-stringjoiner-example/
 * 参考文章2：https://blog.jooq.org/2014/05/02/java-8-friday-lets-deprecate-those-legacy-libs/
 *
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/12/19
 * Time: 13:29
 */
public class GuavaExample {

    public static void main(String[] args) {
        //case 1 com.google.guava.base.Joiner
        //原来使用Guava中的接口可以这么写
        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harray", null, "Ron", "Hermione"));

        //现在使用Java 8的API可以这么写
        String res = Stream.of("Harray", null, "Ron", "Hermione")
            .filter(Objects::nonNull)
            .collect(Collectors.joining("; "));
        System.out.println(res);

        //case 2 com.google.common.base.Optional -> java.util.Optional
        //case 3 com.google.common.base.Predicate -> java.util.Function.Predicate
        //case 4 com.google.common.base.Supplier -> java.util.Function.Supplier

        //如果你在之前的项目中大量使用了guava库的接口，在升级到Java 8后可以考虑将其中的一些换成JDK 8提供的API
    }
}
