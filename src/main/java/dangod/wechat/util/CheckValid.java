package dangod.wechat.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Component
public class CheckValid {
    /**
     * 验证消息是否从微信服务器发来
     *
     * @param token
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public boolean check(String token, String signature, String timestamp, String nonce){
        // 将token、timestamp、nonce三个参数进行字典序排序
        String[] dict = new String[] {token, timestamp, nonce};
        Arrays.sort(dict);
        //将三个参数字符串拼接成一个字符串
        StringBuilder str = new StringBuilder();
        for (String s : dict) {
            str.append(s);
        }

        MessageDigest md;
        String tmpStr = null;
        //进行sha1加密
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(str.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return tmpStr != null && tmpStr.equals(signature.toUpperCase());
    }
    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}
