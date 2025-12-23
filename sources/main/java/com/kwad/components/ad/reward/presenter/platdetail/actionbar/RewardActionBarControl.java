package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class RewardActionBarControl {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private g tm;
    private b xY;

    @Nullable
    private d yc;

    @Nullable
    private c yd;
    private final long yf;

    @NonNull
    private a ye = new a(0);
    private Handler iK = new Handler(Looper.getMainLooper());
    private boolean yg = false;
    private boolean yh = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ShowActionBarResult {
        SHOW_NATIVE_DEFAULT,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_ORDER,
        SHOW_NATIVE_ORDER,
        SHOW_NATIVE_JINNIU,
        SHOW_NATIVE_PLAYABLE_PORTRAIT,
        SHOW_NATIVE_LIVE_SUBSCRIBE,
        SHOW_NATIVE_ORIGIN_LIVE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        private List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> ym;
        private ShowActionBarResult yn;

        private a() {
            this.ym = new CopyOnWriteArrayList();
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view) {
            com.kwad.sdk.core.d.c.d("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
            this.yn = showActionBarResult;
            Iterator<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> it = this.ym.iterator();
            while (it.hasNext()) {
                it.next().a(showActionBarResult, view);
            }
        }

        public final void c(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.ym.add(aVar);
        }

        public final void d(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.ym.remove(aVar);
        }

        /* synthetic */ a(byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(boolean z5, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void e(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        boolean f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    private ShowActionBarResult Q(boolean z5) {
        c cVar;
        if (com.kwad.components.ad.reward.a.b.i(this.mAdInfo) && (cVar = this.yd) != null) {
            cVar.e(this.ye);
            return ShowActionBarResult.SHOW_ORDER;
        }
        if (!com.kwad.sdk.core.response.b.b.cy(this.mAdTemplate) || com.kwad.sdk.core.response.b.a.bd(this.mAdInfo) || this.yc == null) {
            R(z5);
            return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
        }
        com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar success in " + this.yf);
        return this.yc.f(this.ye) ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(boolean z5) {
        if (this.xY != null) {
            com.kwad.sdk.core.d.c.d("ActionBarControl", "showNativeActionBar");
            this.yh = true;
            this.xY.a(z5, this.ye);
        }
    }

    static /* synthetic */ boolean a(RewardActionBarControl rewardActionBarControl, boolean z5) {
        rewardActionBarControl.yg = true;
        return true;
    }

    public final void jq() {
        if (this.yg) {
            com.kwad.sdk.core.d.c.i("ActionBarControl", "showWebActionBar time out on pageStatus");
        } else {
            this.iK.removeCallbacksAndMessages(null);
            Q(true);
        }
    }

    @Nullable
    public final ShowActionBarResult jr() {
        return this.ye.yn;
    }

    public RewardActionBarControl(g gVar, Context context, AdTemplate adTemplate) {
        long j6;
        this.tm = gVar;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.b.cx(adTemplate) > 0) {
            j6 = com.kwad.sdk.core.response.b.b.cx(adTemplate);
        } else {
            j6 = 1000;
        }
        this.yf = j6 > 0 ? j6 : 1000L;
    }

    public final void P(boolean z5) {
        ShowActionBarResult Q = Q(z5);
        com.kwad.sdk.core.d.c.d("ActionBarControl", "showActionBarOnVideoStart result: " + Q);
        if (Q != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.iK.postDelayed(new bg() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                RewardActionBarControl.a(RewardActionBarControl.this, true);
                com.kwad.sdk.core.d.c.d("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.yc != null && !RewardActionBarControl.this.yh && RewardActionBarControl.this.yc.f(RewardActionBarControl.this.ye)) {
                    com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.yf);
                } else {
                    com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.yf);
                    com.kwad.components.core.p.a.se().j(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.yf);
                    com.kwad.components.ad.reward.monitor.c.a(RewardActionBarControl.this.tm.mAdTemplate, RewardActionBarControl.this.tm.rS, "play_card", com.kwad.sdk.core.response.b.b.cw(RewardActionBarControl.this.tm.mAdTemplate), RewardActionBarControl.this.yf, 1);
                    RewardActionBarControl.this.R(true);
                }
            }
        }, this.yf);
    }

    @MainThread
    public final void a(b bVar) {
        this.xY = bVar;
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.ye.d(aVar);
    }

    @MainThread
    public final void a(d dVar) {
        this.yc = dVar;
    }

    @MainThread
    public final void a(@Nullable c cVar) {
        this.yd = cVar;
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.ye.c(aVar);
    }

    public static void a(final com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar, final View view, final ShowActionBarResult showActionBarResult) {
        if (aVar != null) {
            view.post(new bg() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.components.ad.reward.presenter.platdetail.actionbar.a.this.a(showActionBarResult, view);
                }
            });
        }
    }
}
