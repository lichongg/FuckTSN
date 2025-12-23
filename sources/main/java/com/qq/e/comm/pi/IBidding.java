package com.qq.e.comm.pi;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IBidding extends IBiddingLoss {
    public static final String ADN_ID = "adnId";
    public static final String EXPECT_COST_PRICE = "expectCostPrice";
    public static final String HIGHEST_LOSS_PRICE = "highestLossPrice";
    public static final String LOSS_REASON = "lossReason";
    public static final String WIN_PRICE = "winPrice";

    @Deprecated
    void sendLossNotification(int i6, int i7, String str);

    @Deprecated
    void sendWinNotification(int i6);

    void sendWinNotification(Map<String, Object> map);

    void setBidECPM(int i6);
}
