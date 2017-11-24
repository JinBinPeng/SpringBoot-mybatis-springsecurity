package com.pjb.springsecurity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by yangyibo on 17/1/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {
    private String title;
    private String content;
    private String etraInfo;
}
