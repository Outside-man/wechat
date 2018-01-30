package dangod.wechat.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Text {
    String MsgType = "text";
}
