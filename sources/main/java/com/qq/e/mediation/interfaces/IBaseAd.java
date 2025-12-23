package com.qq.e.mediation.interfaces;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public interface IBaseAd {
    int getECPM();

    Map<String, Object> getExtraInfo();

    String getReqId();

    void sendLossNotification(int i6, int i7, String str);

    void sendWinNotification(int i6);

    void setBidECPM(int i6);

    void setPayload(String str);
}
