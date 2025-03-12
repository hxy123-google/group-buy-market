package org.example.types.annotations;

import java.lang.annotation.*;

/**
 * ClassName: DCCValue
 * Package: org.example.types.annotations
 * Description:
 *
 * @Author Hxy
 * @Create 2025/3/12 20:48
 * @Version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface DCCValue {
    String value();
}
