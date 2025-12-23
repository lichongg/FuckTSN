package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> implements NFBI {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;

    /* renamed from: i, reason: collision with root package name */
    private final RewardVideoADListener f36685i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f36686j;

    /* renamed from: k, reason: collision with root package name */
    private LoadAdParams f36687k;

    /* renamed from: l, reason: collision with root package name */
    private ServerSideVerificationOptions f36688l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f36689m;

    /* renamed from: n, reason: collision with root package name */
    private final ADListenerAdapter f36690n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private NegativeFeedbackListener f36691a;
        public RewardVideoADListener adListener;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(NegativeFeedbackListener negativeFeedbackListener) {
            this.f36691a = negativeFeedbackListener;
        }

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type != 100) {
                if (type != 201) {
                    if (type != 206) {
                        if (type != 304) {
                            switch (type) {
                                case 102:
                                    this.adListener.onADShow();
                                    break;
                                case 103:
                                    this.adListener.onADExpose();
                                    break;
                                case 104:
                                    String str = (String) aDEvent.getParam(String.class);
                                    if (str != null) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("transId", str);
                                        Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                                        if (num != null) {
                                            hashMap.put(ServerSideVerificationOptions.ACTION, num);
                                        }
                                        this.adListener.onReward(hashMap);
                                        break;
                                    }
                                    break;
                                case 105:
                                    this.adListener.onADClick();
                                    break;
                                case 106:
                                    this.adListener.onADClose();
                                    break;
                                case 107:
                                    Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                                    if (num2 != null) {
                                        this.adListener.onError(AdErrorConvertor.formatErrorCode(num2.intValue()));
                                        break;
                                    }
                                    break;
                            }
                            return;
                        }
                        NegativeFeedbackListener negativeFeedbackListener = this.f36691a;
                        if (negativeFeedbackListener != null) {
                            negativeFeedbackListener.onComplainSuccess();
                            return;
                        }
                        return;
                    }
                    this.adListener.onVideoComplete();
                    return;
                }
                this.adListener.onVideoCached();
                return;
            }
            this.adListener.onADLoad();
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RVADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, this.f36690n);
    }

    public void showAD() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((RVADI) t5).showAD();
        } else {
            a("showAD");
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z5) {
        this(rewardVideoADListener, z5);
        a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    public void a(RVADI rvadi) {
        rvadi.setVolumeOn(this.f36689m);
        rvadi.setLoadAdParams(this.f36687k);
        rvadi.setServerSideVerificationOptions(this.f36688l);
        if (this.f36686j) {
            loadAD();
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i6) {
        RewardVideoADListener rewardVideoADListener = this.f36685i;
        if (rewardVideoADListener != null) {
            rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i6));
        }
    }

    public String getAdNetWorkName() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((RVADI) t5).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getRewardAdType() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((RVADI) t5).getRewardAdType();
        }
        a("getRewardAdType");
        return 0;
    }

    public int getVideoDuration() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((RVADI) t5).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((RVADI) t5).hasShown();
        }
        a("hasShown");
        return false;
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f36687k = loadAdParams;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((RVADI) t5).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f36690n.a(negativeFeedbackListener);
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f36688l = serverSideVerificationOptions;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((RVADI) t5).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAD(Activity activity) {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((RVADI) t5).showAD(activity);
        } else {
            a("showAD");
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z5, String str2) {
        this(rewardVideoADListener, z5);
        a(context, str, str2);
    }

    public void loadAD() {
        if (!a()) {
            return;
        }
        if (!b()) {
            this.f36686j = true;
            return;
        }
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((RVADI) t5).loadAD();
        } else {
            a("loadAD");
        }
    }

    private RewardVideoAD(RewardVideoADListener rewardVideoADListener, boolean z5) {
        this.f36687k = null;
        this.f36689m = z5;
        this.f36685i = rewardVideoADListener;
        this.f36690n = new ADListenerAdapter(rewardVideoADListener);
    }
}
