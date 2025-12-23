package com.bxkj.student.v2.common.ad;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bxkj.base.v2.base.p;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.orhanobut.logger.j;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import xyz.adscope.amps.ad.reward.AMPSRewardVideoAd;
import xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.config.AMPSRequestParameters;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class AdManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AdManager f20633a = new AdManager();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements AMPSRewardVideoLoadEventListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f20634a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<AMPSRewardVideoAd> f20635b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f20636c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f20637d;

        @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
        public void onAmpsAdCached() {
            j.d("onAmpsAdCached", new Object[0]);
        }

        @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
        public void onAmpsAdDismiss() {
            j.d("onAmpsAdDismiss", new Object[0]);
        }

        @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
        public void onAmpsAdLoad() {
            j.d("onAmpsAdLoad", new Object[0]);
            this.f20634a.b();
            AMPSRewardVideoAd aMPSRewardVideoAd = this.f20635b.element;
            if (aMPSRewardVideoAd != null) {
                aMPSRewardVideoAd.show(this.f20636c);
            }
        }

        @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
        public void onAmpsAdRewardArrived(boolean z5, int i6, Map<String, ? extends Object> map) {
            j.d("onAmpsAdRewardArrived", new Object[0]);
            this.f20637d.invoke();
            AMPSRewardVideoAd aMPSRewardVideoAd = this.f20635b.element;
            if (aMPSRewardVideoAd != null) {
                aMPSRewardVideoAd.destroy();
            }
        }

        @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
        public void onAmpsAdShow() {
            j.d("onAmpsAdShow", new Object[0]);
        }

        @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
        public void onAmpsAdVideoClick() {
            j.d("onAmpsAdVideoClick", new Object[0]);
        }

        @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
        public void onAmpsAdVideoComplete() {
            j.d("onAmpsAdVideoComplete", new Object[0]);
        }

        @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
        public void onAmpsAdVideoError() {
            j.d("onAmpsAdVideoError", new Object[0]);
            this.f20634a.b();
            ContextExtKt.m(this.f20636c, "加载失败，请重试！");
        }

        a(p pVar, Ref.ObjectRef<AMPSRewardVideoAd> objectRef, FragmentActivity fragmentActivity, Function0<n1> function0) {
            this.f20634a = pVar;
            this.f20635b = objectRef;
            this.f20636c = fragmentActivity;
            this.f20637d = function0;
        }

        @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
        public void onAmpsAdFailed(AMPSError aMPSError) {
            this.f20634a.b();
            ContextExtKt.m(this.f20636c, "加载失败，请重试！");
            j.d("onAmpsAdFailed=" + aMPSError, new Object[0]);
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, xyz.adscope.amps.ad.reward.AMPSRewardVideoAd, xyz.adscope.amps.base.AMPSBaseAd] */
    public final void a(@NotNull final FragmentActivity activity, @NotNull Function0<n1> onAdRewardArrived) {
        g0.p(activity, "activity");
        g0.p(onAdRewardArrived, "onAdRewardArrived");
        p pVar = new p(activity);
        pVar.e("加载中...");
        pVar.h();
        AMPSRequestParameters build = new AMPSRequestParameters.Builder().setSpaceId(com.bxkj.student.v2.common.data.a.f20654d).setTimeOut(10000).setAdCount(1).build();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? aMPSRewardVideoAd = new AMPSRewardVideoAd(activity, build, new a(pVar, objectRef, activity, onAdRewardArrived));
        objectRef.element = aMPSRewardVideoAd;
        aMPSRewardVideoAd.loadAd();
        activity.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.student.v2.common.ad.AdManager$showAd$2
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                AMPSRewardVideoAd aMPSRewardVideoAd2 = objectRef.element;
                if (aMPSRewardVideoAd2 != null) {
                    aMPSRewardVideoAd2.destroy();
                }
                activity.getLifecycle().removeObserver(this);
            }
        });
    }

    private AdManager() {
    }
}
