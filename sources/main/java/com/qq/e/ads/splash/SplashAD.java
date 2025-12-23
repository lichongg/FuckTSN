package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {

    /* renamed from: i, reason: collision with root package name */
    private volatile ViewGroup f36697i;

    /* renamed from: j, reason: collision with root package name */
    private volatile SplashADListener f36698j;

    /* renamed from: k, reason: collision with root package name */
    private volatile ADRewardListener f36699k;

    /* renamed from: l, reason: collision with root package name */
    private volatile LoadAdParams f36700l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f36701m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f36702n;

    /* renamed from: o, reason: collision with root package name */
    private volatile boolean f36703o;

    /* renamed from: p, reason: collision with root package name */
    private volatile int f36704p;

    /* renamed from: q, reason: collision with root package name */
    private volatile byte[] f36705q;

    /* renamed from: r, reason: collision with root package name */
    private volatile ServerSideVerificationOptions f36706r;

    /* renamed from: s, reason: collision with root package name */
    private int f36707s;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.qq.e.ads.splash.SplashAD$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(SplashAD splashAD, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.f36698j == null) {
                return;
            }
            int type = aDEvent.getType();
            switch (type) {
                case 100:
                    Long l6 = (Long) aDEvent.getParam(Long.class);
                    if (l6 != null) {
                        SplashAD.this.f36698j.onADLoaded(l6.longValue());
                        break;
                    }
                    break;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.f36698j.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        break;
                    }
                    break;
                case 102:
                    SplashAD.this.f36698j.onADPresent();
                    break;
                case 103:
                    SplashAD.this.f36698j.onADExposure();
                    break;
                case 104:
                    if (SplashAD.this.f36699k != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("transId", str);
                        SplashAD.this.f36699k.onReward(hashMap);
                        break;
                    }
                    break;
                case 105:
                    SplashAD.this.f36698j.onADClicked();
                    break;
                case 106:
                    SplashAD.this.f36698j.onADDismissed();
                    break;
                default:
                    switch (type) {
                        case 112:
                            Long l7 = (Long) aDEvent.getParam(Long.class);
                            if (l7 != null) {
                                SplashAD.this.f36698j.onADTick(l7.longValue());
                                break;
                            }
                            break;
                        case 113:
                            if (SplashAD.this.f36698j instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f36698j).onZoomOut();
                                break;
                            }
                            break;
                        case 114:
                            if (SplashAD.this.f36698j instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f36698j).onZoomOutPlayFinish();
                                break;
                            }
                            break;
                    }
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    private void fetchAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, false);
    }

    private void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, true);
    }

    public void fetchAdOnly() {
        a(false);
    }

    public void fetchFullScreenAdOnly() {
        a(true);
    }

    public void setDeveloperLogo(int i6) {
        T t5 = this.f36545a;
        if (t5 == 0) {
            this.f36704p = i6;
        } else {
            ((NSPVI) t5).setDeveloperLogo(i6);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        b(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        b(viewGroup, true);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i6) {
        this.f36701m = false;
        this.f36698j = splashADListener;
        this.f36707s = i6;
        a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NSPVI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    public String getAdNetWorkName() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((NSPVI) t5).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public Bitmap getZoomOutBitmap() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            return ((NSPVI) t5).getZoomOutBitmap();
        }
        a("getZoomOutBitmap");
        return null;
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t5 = this.f36545a;
        if (t5 == 0) {
            this.f36705q = bArr;
        } else {
            ((NSPVI) t5).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((NSPVI) t5).setLoadAdParams(loadAdParams);
        } else {
            this.f36700l = loadAdParams;
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f36699k = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f36706r = serverSideVerificationOptions;
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((NSPVI) t5).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void zoomOutAnimationFinish() {
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((NSPVI) t5).zoomOutAnimationFinish();
        } else {
            a("zoomOutAnimationFinish");
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i6, String str2) {
        this.f36701m = false;
        this.f36698j = splashADListener;
        this.f36707s = i6;
        a(context, str, str2);
    }

    private void a(ViewGroup viewGroup, boolean z5) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(4001);
            return;
        }
        T t5 = this.f36545a;
        if (t5 == 0) {
            this.f36703o = z5;
            this.f36697i = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t5;
        if (z5) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i6) {
        if (this.f36698j != null) {
            this.f36698j.onNoAD(AdErrorConvertor.formatErrorCode(i6));
        }
    }

    public void preLoad() {
        if (!a()) {
            return;
        }
        if (!b()) {
            this.f36701m = true;
            return;
        }
        T t5 = this.f36545a;
        if (t5 != 0) {
            ((NSPVI) t5).preload();
        } else {
            a("preLoad");
        }
    }

    private void a(boolean z5) {
        if (a()) {
            if (!b()) {
                this.f36703o = z5;
                this.f36702n = true;
                return;
            }
            T t5 = this.f36545a;
            if (t5 == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t5;
            if (z5) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void b(ViewGroup viewGroup, boolean z5) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(4001);
            return;
        }
        T t5 = this.f36545a;
        if (t5 == 0) {
            this.f36697i = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t5;
        if (z5) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    public void a(NSPVI nspvi) {
        if (this.f36700l != null) {
            nspvi.setLoadAdParams(this.f36700l);
        }
        if (this.f36704p != 0) {
            nspvi.setDeveloperLogo(this.f36704p);
        }
        if (this.f36705q != null) {
            nspvi.setDeveloperLogo(this.f36705q);
        }
        nspvi.setFetchDelay(this.f36707s);
        nspvi.setAdListener(new ADListenerAdapter(this, null));
        nspvi.setServerSideVerificationOptions(this.f36706r);
        if ((this.f36698j instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.f36698j).isSupportZoomOut()) {
            nspvi.setSupportZoomOut(true);
        }
        if (this.f36697i != null) {
            if (this.f36703o) {
                fetchFullScreenAndShowIn(this.f36697i);
            } else {
                fetchAndShowIn(this.f36697i);
            }
        }
        if (this.f36701m) {
            nspvi.preload();
            this.f36701m = false;
        }
        if (this.f36702n) {
            if (this.f36703o) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.f36702n = false;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Deprecated
    public void setAdLogoMargin(int i6, int i7) {
    }
}
