package com.qq.e.ads.interstitial2;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.a;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class ADListenerAdapter implements ADListener {

    /* renamed from: a, reason: collision with root package name */
    private final UnifiedInterstitialADListener f36625a;

    /* renamed from: b, reason: collision with root package name */
    private UnifiedInterstitialMediaListener f36626b;

    /* renamed from: c, reason: collision with root package name */
    private com.qq.e.comm.listeners.ADRewardListener f36627c;

    /* renamed from: d, reason: collision with root package name */
    private NegativeFeedbackListener f36628d;

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedInterstitialADListener unifiedInterstitialADListener;
        String str;
        if (aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        if (type == 109) {
            UnifiedInterstitialADListener unifiedInterstitialADListener2 = this.f36625a;
            if (unifiedInterstitialADListener2 == null || !a.b(unifiedInterstitialADListener2)) {
                return;
            }
            this.f36625a.onRenderSuccess();
            return;
        }
        if (type == 110) {
            UnifiedInterstitialADListener unifiedInterstitialADListener3 = this.f36625a;
            if (unifiedInterstitialADListener3 == null || !a.a(unifiedInterstitialADListener3)) {
                return;
            }
            this.f36625a.onRenderFail();
            return;
        }
        if (type == 201) {
            UnifiedInterstitialADListener unifiedInterstitialADListener4 = this.f36625a;
            if (unifiedInterstitialADListener4 != null) {
                unifiedInterstitialADListener4.onVideoCached();
                return;
            }
            return;
        }
        if (type == 202) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener = this.f36626b;
            if (unifiedInterstitialMediaListener != null) {
                unifiedInterstitialMediaListener.onVideoStart();
                return;
            }
            return;
        }
        if (type == 204) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener2 = this.f36626b;
            if (unifiedInterstitialMediaListener2 != null) {
                unifiedInterstitialMediaListener2.onVideoPause();
                return;
            }
            return;
        }
        if (type == 206) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener3 = this.f36626b;
            if (unifiedInterstitialMediaListener3 != null) {
                unifiedInterstitialMediaListener3.onVideoComplete();
                return;
            }
            return;
        }
        if (type == 207) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener4 = this.f36626b;
            if (unifiedInterstitialMediaListener4 == null || num == null) {
                return;
            }
            unifiedInterstitialMediaListener4.onVideoError(AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        switch (type) {
            case 100:
                UnifiedInterstitialADListener unifiedInterstitialADListener5 = this.f36625a;
                if (unifiedInterstitialADListener5 != null) {
                    unifiedInterstitialADListener5.onADReceive();
                    break;
                }
                break;
            case 101:
                Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                if (num2 != null && (unifiedInterstitialADListener = this.f36625a) != null) {
                    unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(num2.intValue()));
                    break;
                }
                break;
            case 102:
                UnifiedInterstitialADListener unifiedInterstitialADListener6 = this.f36625a;
                if (unifiedInterstitialADListener6 != null) {
                    unifiedInterstitialADListener6.onADOpened();
                    break;
                }
                break;
            case 103:
                UnifiedInterstitialADListener unifiedInterstitialADListener7 = this.f36625a;
                if (unifiedInterstitialADListener7 != null) {
                    unifiedInterstitialADListener7.onADExposure();
                    break;
                }
                break;
            case 104:
                if (this.f36627c != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("transId", str);
                    this.f36627c.onReward(hashMap);
                    break;
                }
                break;
            case 105:
                UnifiedInterstitialADListener unifiedInterstitialADListener8 = this.f36625a;
                if (unifiedInterstitialADListener8 != null) {
                    unifiedInterstitialADListener8.onADClicked();
                    break;
                }
                break;
            case 106:
                UnifiedInterstitialADListener unifiedInterstitialADListener9 = this.f36625a;
                if (unifiedInterstitialADListener9 != null) {
                    unifiedInterstitialADListener9.onADClosed();
                    break;
                }
                break;
            default:
                switch (type) {
                    case 209:
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener5 = this.f36626b;
                        if (unifiedInterstitialMediaListener5 != null) {
                            unifiedInterstitialMediaListener5.onVideoInit();
                            break;
                        }
                        break;
                    case 210:
                        Integer num3 = (Integer) aDEvent.getParam(Integer.class);
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener6 = this.f36626b;
                        if (unifiedInterstitialMediaListener6 != null && num3 != null) {
                            unifiedInterstitialMediaListener6.onVideoReady(num3.intValue());
                            break;
                        }
                        break;
                    case 211:
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener7 = this.f36626b;
                        if (unifiedInterstitialMediaListener7 != null) {
                            unifiedInterstitialMediaListener7.onVideoLoading();
                            break;
                        }
                        break;
                    default:
                        switch (type) {
                            case 301:
                                UnifiedInterstitialMediaListener unifiedInterstitialMediaListener8 = this.f36626b;
                                if (unifiedInterstitialMediaListener8 != null) {
                                    unifiedInterstitialMediaListener8.onVideoPageOpen();
                                    break;
                                }
                                break;
                            case 302:
                                UnifiedInterstitialMediaListener unifiedInterstitialMediaListener9 = this.f36626b;
                                if (unifiedInterstitialMediaListener9 != null) {
                                    unifiedInterstitialMediaListener9.onVideoPageClose();
                                    break;
                                }
                                break;
                            case 303:
                                UnifiedInterstitialADListener unifiedInterstitialADListener10 = this.f36625a;
                                if (unifiedInterstitialADListener10 != null) {
                                    unifiedInterstitialADListener10.onADLeftApplication();
                                    break;
                                }
                                break;
                            case 304:
                                NegativeFeedbackListener negativeFeedbackListener = this.f36628d;
                                if (negativeFeedbackListener != null) {
                                    negativeFeedbackListener.onComplainSuccess();
                                    break;
                                }
                                break;
                        }
                }
        }
    }

    public void setAdRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.f36627c = aDRewardListener;
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f36626b = unifiedInterstitialMediaListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f36628d = negativeFeedbackListener;
    }

    ADListenerAdapter(UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this.f36625a = unifiedInterstitialADListener;
    }
}
