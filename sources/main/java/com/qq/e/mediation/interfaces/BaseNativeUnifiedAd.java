package com.qq.e.mediation.interfaces;

import android.content.Context;
import com.qq.e.comm.adevent.ADListener;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class BaseNativeUnifiedAd implements IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;

    public int getAdapterPriority() {
        return -1;
    }

    public abstract void loadData(int i6);

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setCategories(List<String> list);

    public abstract void setECPMLevel(String str);

    public abstract void setMaxVideoDuration(int i6);

    public abstract void setMinVideoDuration(int i6);

    public BaseNativeUnifiedAd(Context context, String str, String str2, String str3) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i6) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i6) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setPayload(String str) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i6, int i7, String str) {
    }
}
