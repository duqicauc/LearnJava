package org.java.learn.spring.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作用:
 * User: duqi
 * Date: 2017/9/1
 * Time: 13:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Name {

    private String firstName;
    private String lastName;
}
