package org.java.learn.util.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作用: User: duqi Date: 2017/11/21 Time: 10:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {

    private Long userId;
    private String userName;
}
