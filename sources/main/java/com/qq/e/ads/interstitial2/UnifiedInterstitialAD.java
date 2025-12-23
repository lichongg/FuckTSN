package com.qq.e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {

    /* renamed from: i, reason: collision with root package name */
    private AtomicInteger f36629i;

    /* renamed from: j, reason: collision with root package name */
    private AtomicInteger f36630j;

    /* renamed from: k, reason: collision with root package name */
    private volatile VideoOption f36631k;

    /* renamed from: l, reason: collision with root package name */
    private volatile int f36632l;

    /* renamed from: m, reason: collision with root package name */
    private volatile int f36633m;

    /* renamed from: n, reason: collision with root package name */
    private volatile LoadAdParams f36634n;

    /* renamed from: o, reason: collision with root package name */
    private UnifiedInterstitialADListener f36635o;

    /* renamed from: p, reason: collision with root package name */
    private ServerSideVerificationOptions f36636p;

    /* renamed from: q, reason: collision with root package name */
    private final ADListenerAdapter f36637q;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UIADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.f36637q);
    }

    public void show() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).show();
        } else {
            a(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW);
        }
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f36629i = new AtomicInteger(0);
        this.f36630j = new AtomicInteger(0);
        this.f36635o = unifiedInterstitialADListener;
        this.f36637q = new ADListenerAdapter(this.f36635o);
        a(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    public void a(UIADI uiadi) {
        setVideoOption(this.f36631k);
        setMinVideoDuration(this.f36632l);
        setMaxVideoDuration(this.f36633m);
        setLoadAdParams(this.f36634n);
        setServerSideVerificationOptions(this.f36636p);
        while (this.f36629i.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.f36630j.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i6) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.f36635o;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i6));
        }
    }

    public void close() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).close();
        }
    }

    public void destroy() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((UIADI) t5).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((UIADI) t5).getAdPatternType();
        }
        a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((UIADI) t5).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f36634n = loadAdParams;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).setLoadAdParams(this.f36634n);
        }
    }

    public void setMaxVideoDuration(int i6) {
        this.f36633m = i6;
        if (this.f36633m > 0 && this.f36632l > this.f36633m) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).setMaxVideoDuration(i6);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f36637q.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i6) {
        this.f36632l = i6;
        if (this.f36633m > 0 && this.f36632l > this.f36633m) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).setMinVideoDuration(i6);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f36637q.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.f36637q.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f36636p = serverSideVerificationOptions;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f36631k = videoOption;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).setVideoOption(videoOption);
        }
    }

    public void show(Activity activity) {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).show(activity);
        } else {
            a(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW);
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.f36629i = new AtomicInteger(0);
        this.f36630j = new AtomicInteger(0);
        this.f36635o = unifiedInterstitialADListener;
        this.f36637q = new ADListenerAdapter(this.f36635o);
        a(activity, str, str2);
    }

    public void loadAD() {
        if (!a()) {
            return;
        }
        if (!b()) {
            this.f36629i.incrementAndGet();
            return;
        }
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).loadAd();
        } else {
            a("loadAD");
        }
    }

    public void loadFullScreenAD() {
        if (!a()) {
            return;
        }
        if (!b()) {
            this.f36630j.incrementAndGet();
            return;
        }
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UIADI) t5).loadFullScreenAD();
        } else {
            a("loadFullScreenAD");
        }
    }
}
