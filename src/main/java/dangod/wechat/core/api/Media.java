package dangod.wechat.core.api;

import java.io.File;

public interface Media {
    String sendTemp(String type, File file);

    String sendPermVideo(String type, File file, String title, String introduction);

    String sendPerm(String type, File file);
}
