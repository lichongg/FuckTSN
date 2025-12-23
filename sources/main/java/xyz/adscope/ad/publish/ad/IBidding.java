package xyz.adscope.ad.publish.ad;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IBidding {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Adn {
        public static final String ADN_BD = "1018";
        public static final String ADN_BZ = "6666";
        public static final String ADN_CSJ = "1013";
        public static final String ADN_GDT = "1012";
        public static final String ADN_GM = "1022";
        public static final String ADN_HW = "1020";
        public static final String ADN_JD = "1021";
        public static final String ADN_KS = "1019";
        public static final String ADN_OTHER = "9999";
        public static final String ADN_QM = "1030";
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class BidLoseReason {
        public static final String LOAD_TIME_OUT = "2";
        public static final String LOW_PRICE = "1";
        public static final String OTHER = "999";
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class BiddingPriceBuilder {
        public static final String ADN_ID = "adnId";
        public static final String EXPECT_PRICE = "expectPrice";
        public static final String LOSS_REASON = "lossReason";
        public static final String SEC_HIGHEST_PRICE = "secHighPrice";
        public static final String WIN_PRICE = "winPrice";

        public static Map<String, String> buildLoseNoticeMap(int i6, int i7, String str, String str2, int i8) {
            HashMap hashMap = new HashMap();
            hashMap.put("winPrice", String.valueOf(i6));
            hashMap.put(SEC_HIGHEST_PRICE, String.valueOf(i7));
            hashMap.put("lossReason", str2);
            hashMap.put("adnId", str);
            hashMap.put(EXPECT_PRICE, String.valueOf(i8));
            return hashMap;
        }

        public static Map<String, String> buildWinNoticeMap(int i6, int i7, String str, int i8) {
            HashMap hashMap = new HashMap();
            hashMap.put("winPrice", String.valueOf(i6));
            hashMap.put(SEC_HIGHEST_PRICE, String.valueOf(i7));
            hashMap.put("adnId", str);
            hashMap.put(EXPECT_PRICE, String.valueOf(i8));
            return hashMap;
        }
    }

    int getECPM();

    void notifyBidLose(Map<String, String> map);

    void notifyBidWin(Map<String, String> map);
}
