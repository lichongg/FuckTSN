package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {

    /* renamed from: i, reason: collision with root package name */
    private UnifiedBannerADListener f36564i;

    /* renamed from: j, reason: collision with root package name */
    private AtomicInteger f36565j;

    /* renamed from: k, reason: collision with root package name */
    private int f36566k;

    /* renamed from: l, reason: collision with root package name */
    private LoadAdParams f36567l;

    /* renamed from: m, reason: collision with root package name */
    private UnifiedBannerView f36568m;

    /* renamed from: n, reason: collision with root package name */
    private final ADListenerAdapter f36569n;

    /* renamed from: o, reason: collision with root package name */
    private volatile ServerSideVerificationOptions f36570o;

    UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UBVI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.f36568m, (Activity) context, str, str2, str3, this.f36569n);
    }

    UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    public void a(UBVI ubvi) {
        c(this.f36566k);
        setLoadAdParams(this.f36567l);
        ubvi.setServerSideVerificationOptions(this.f36570o);
        while (this.f36565j.getAndDecrement() > 0) {
            loadAD();
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i6) {
        UnifiedBannerADListener unifiedBannerADListener = this.f36564i;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i6));
        }
    }

    void c(int i6) {
        this.f36566k = i6;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UBVI) t5).setRefresh(i6);
        }
    }

    void destroy() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UBVI) t5).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((UBVI) t5).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    void onWindowFocusChanged(boolean z5) {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UBVI) t5).onWindowFocusChanged(z5);
        }
    }

    void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f36567l = loadAdParams;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UBVI) t5).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f36569n.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f36569n.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f36570o = serverSideVerificationOptions;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UBVI) t5).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    private UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.f36565j = new AtomicInteger(0);
        this.f36566k = 30;
        this.f36567l = null;
        this.f36564i = unifiedBannerADListener;
        this.f36568m = unifiedBannerView;
        this.f36569n = new ADListenerAdapter(unifiedBannerADListener);
    }

    void loadAD() {
        if (!a()) {
            return;
        }
        if (!b()) {
            this.f36565j.incrementAndGet();
            return;
        }
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((UBVI) t5).fetchAd();
        } else {
            a("loadAD");
        }
    }
}
