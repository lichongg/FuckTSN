package com.qq.e.ads.banner2;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class ADListenerAdapter implements ADListener {

    /* renamed from: a, reason: collision with root package name */
    private final UnifiedBannerADListener f36561a;

    /* renamed from: b, reason: collision with root package name */
    private NegativeFeedbackListener f36562b;

    /* renamed from: c, reason: collision with root package name */
    private ADRewardListener f36563c;

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedBannerADListener unifiedBannerADListener;
        String str;
        if (aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        if (type == 100) {
            UnifiedBannerADListener unifiedBannerADListener2 = this.f36561a;
            if (unifiedBannerADListener2 != null) {
                unifiedBannerADListener2.onADReceive();
                return;
            }
            return;
        }
        if (type == 101) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            if (num == null || (unifiedBannerADListener = this.f36561a) == null) {
                return;
            }
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        if (type == 303) {
            UnifiedBannerADListener unifiedBannerADListener3 = this.f36561a;
            if (unifiedBannerADListener3 != null) {
                unifiedBannerADListener3.onADLeftApplication();
                return;
            }
            return;
        }
        if (type == 304) {
            NegativeFeedbackListener negativeFeedbackListener = this.f36562b;
            if (negativeFeedbackListener != null) {
                negativeFeedbackListener.onComplainSuccess();
                return;
            }
            return;
        }
        switch (type) {
            case 103:
                UnifiedBannerADListener unifiedBannerADListener4 = this.f36561a;
                if (unifiedBannerADListener4 != null) {
                    unifiedBannerADListener4.onADExposure();
                    break;
                }
                break;
            case 104:
                if (this.f36563c != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("transId", str);
                    this.f36563c.onReward(hashMap);
                    break;
                }
                break;
            case 105:
                UnifiedBannerADListener unifiedBannerADListener5 = this.f36561a;
                if (unifiedBannerADListener5 != null) {
                    unifiedBannerADListener5.onADClicked();
                    break;
                }
                break;
            case 106:
                UnifiedBannerADListener unifiedBannerADListener6 = this.f36561a;
                if (unifiedBannerADListener6 != null) {
                    unifiedBannerADListener6.onADClosed();
                    break;
                }
                break;
        }
    }

    public void setAdRewardListener(ADRewardListener aDRewardListener) {
        this.f36563c = aDRewardListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f36562b = negativeFeedbackListener;
    }

    ADListenerAdapter(UnifiedBannerADListener unifiedBannerADListener) {
        this.f36561a = unifiedBannerADListener;
    }
}
