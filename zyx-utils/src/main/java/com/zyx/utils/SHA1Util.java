package com.zyx.utils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.utils
 * Create by XiaoWei on 2016/12/15
 */
public class SHA1Util {
    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";
//        static String Original = "a=200001&b=newbucket&k=AKIDUfLUEUigQiXqm7CVSspKJnuaiIKtxqAv&e=1438669115&t=1436077115&r=11162&f=";
    static String Original = "a=%s&b=%s&k=%s&e=%s&t=%s&r=%s&f=";
    static String TENCENT_COS_APPID = "10074647";
    static String TENCENT_COS_BUCKET = "zhaowei";
    static String TENCENT_COS_SECRET_ID = "AKIDGQOCsMwoxmXM2af64udBammbHrKc7twr";
    static String TENCENT_COS_SECRET_KEY = "rX1KRL3Y4YwDJDvRluqaAkCSWUJxOdje";

    public static byte[] HmacSHA1Encrypt(String secretKey, String EncryptText)
            throws Exception {
        byte[] data = secretKey.getBytes(ENCODING);
        SecretKey secretKeyInstance = new SecretKeySpec(data, MAC_NAME);
        Mac mac = Mac.getInstance(MAC_NAME);
        mac.init(secretKeyInstance);
        byte[] text = EncryptText.getBytes(ENCODING);
        return mac.doFinal(text);
    }

    public static String getSignOriginal() {

        return String.format(Original,
                TENCENT_COS_APPID,
                TENCENT_COS_BUCKET,
                TENCENT_COS_SECRET_ID,
                String.valueOf(getFurureLinuxDate()),
                String.valueOf(getLinuxDateSimple()), getRandomTenStr());
    }

    public static long getFurureLinuxDate() {
        try {
            String futureTime = "2017/02/15 00:00:00";
            Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    .parse(futureTime);
            long unixTimestamp = date.getTime() / 1000L;
            return unixTimestamp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static long getLinuxDateSimple() {
        try {
            long unixTimestamp = System.currentTimeMillis() / 1000L;
            return unixTimestamp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static String getRandomTenStr() {
        String randomstr = null;
        randomstr = String.valueOf(new Random().nextInt(8) + 1);
        int random = new Random().nextInt(3) + 5;
        for (int i = 0; i < random; i++) {
            randomstr += String.valueOf(new Random().nextInt(9));
        }
        return randomstr;
    }

    public String getTencentSign() {
        try {

            String Original = getSignOriginal();

            byte[] HmacSHA1 = HmacSHA1Encrypt(
                    TENCENT_COS_SECRET_KEY, Original);

            byte[] all = new byte[HmacSHA1.length
                    + Original.getBytes(ENCODING).length];

            System.arraycopy(HmacSHA1, 0, all, 0, HmacSHA1.length);

            System.arraycopy(Original.getBytes(ENCODING), 0, all,
                    HmacSHA1.length, Original.getBytes(ENCODING).length);


            String SignData = Base64Util.encode(all);

            return SignData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "get sign failed";
    }

    public static void main(String[] args) {
//        String orginal2="a=200001&b=newbucket&k=AKIDUfLUEUigQiXqm7CVSspKJnuaiIKtxqAv&e=1438669115&t=1436077115&r=11162&f=";
//        String orginal1="a=200001&b=newbucket&k=AKIDUfLUEUigQiXqm7CVSspKJnuaiIKtxqAv&e=1438669115&t=1436077115&r=11162&f=";
//        String OldString="vxzLR6vzMNhBMUVzMTWKUB+LMeVhPTIwMDAwMSZrPUFLSURVZkxVRVVpZ1FpWHFtN0 NWU3NwS0pudWFpSUt0eHFBdiZlPTE0Mzc5OTU3MDQmdD0xNDM3OTk1NjQ0JnI9MjA4 MTY2MDQyMSZmPSZiPW5ld2J1Y2tldA==";
        SHA1Util sha1Uti=new SHA1Util();
        System.out.println(sha1Uti.getTencentSign());
    }

}
