package com.test.security.testsecurity.validate;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 图片验证码类
 */
public class ImageCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime expiredTime;

    public ImageCode(BufferedImage image, String code, int expired) {
        this.image = image;
        this.code = code;
        this.expiredTime = LocalDateTime.now().plusSeconds(expired);
    }
}
