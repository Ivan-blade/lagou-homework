package com.Ivan.task01;

import java.io.Serializable;

/**
 * @author 夏殿千歌序
 * @date 2020/5/19 14:58
 * @description
 */
public class SnoException extends Exception{

    private static final long serialVersionUID = 3725708588147260226L;

    public SnoException() {
    }

    public SnoException(String message) {
        super(message);
    }
}
