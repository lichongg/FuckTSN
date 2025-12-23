package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b<T extends AdResultData, R extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.j.c {
    public a aig;
    private long aih;
    private com.kwad.sdk.core.j.b dn;
    private com.kwad.components.core.widget.a.b fg;
    public AdInfo mAdInfo;

    @NonNull
    protected T mAdResultData;

    @NonNull
    public R mAdTemplate;

    @NonNull
    public Context mContext;
    private bv mTimerHelper;
    protected boolean oR;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public b(@NonNull Context context) {
        this(context, null);
    }

    static /* synthetic */ long a(b bVar, long j6) {
        long j7 = bVar.aih + j6;
        bVar.aih = j7;
        return j7;
    }

    private static c b(ViewGroup viewGroup) {
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    public static void c(ViewGroup viewGroup) {
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    protected abstract void bw();

    protected float getHWRatio() {
        return 0.0f;
    }

    protected abstract int getLayoutId();

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.e.FK() && com.kwad.sdk.core.config.e.FJ() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0647a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.a.InterfaceC0647a
                public final void ab() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.oR) {
                            long Sn = bVar.getTimerHelper().Sn();
                            b.a(b.this, Sn);
                            com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, Sn, (JSONObject) null);
                            b.this.oR = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0647a
                public final void ay() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.oR) {
                            long Sn = bVar.getTimerHelper().Sn();
                            b.a(b.this, Sn);
                            com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, Sn, (JSONObject) null);
                            b.this.oR = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0647a
                public final void c(View view) {
                    if (!b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.aig != null) {
                            bVar.oR = true;
                            bVar.W();
                            b.this.getTimerHelper().startTiming();
                        }
                    }
                    b bVar2 = b.this;
                    if (!bVar2.oR) {
                        bVar2.getTimerHelper().startTiming();
                    }
                    b.this.oR = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0647a
                public final void aa() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0647a
                public final void onWindowFocusChanged(boolean z5) {
                }
            });
            aVar.vU();
            return;
        }
        c b6 = b(viewGroup);
        if (b6 == null) {
            b6 = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b6);
        }
        b6.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.c.a
            public final void fs() {
                b.this.W();
            }
        });
        b6.setNeedCheckingShow(true);
    }

    private void initView() {
        m.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bw();
        this.fg = new com.kwad.components.core.widget.a.b(this, 70);
    }

    protected void W() {
        a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.aig) != null) {
            aVar.onAdShow();
        }
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0675a c0675a = new a.C0675a();
        R r5 = this.mAdTemplate;
        FeedType fromInt = FeedType.fromInt(r5.type, r5.defaultType);
        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        c0675a.templateId = String.valueOf(fromInt.getType());
        c0675a.awW = String.valueOf(fromInt.getFeedDefaultType() == null ? 0 : fromInt.getFeedDefaultType().getDefaultType());
        bVar.b(c0675a);
        bVar.w(getHeight(), getWidth());
        com.kwad.components.core.t.b.sY().a(this.mAdTemplate, null, bVar);
    }

    public final void ba(int i6) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.mI = i6;
        a.C0675a c0675a = new a.C0675a();
        R r5 = this.mAdTemplate;
        FeedType fromInt = FeedType.fromInt(r5.type, r5.defaultType);
        c0675a.templateId = String.valueOf(fromInt.getType());
        c0675a.awW = String.valueOf(fromInt.getFeedDefaultType() == null ? 0 : fromInt.getFeedDefaultType().getDefaultType());
        aVar.Pk = c0675a;
        int i7 = this.mAdTemplate.swipeAngle;
        if (i7 != 0) {
            aVar.ayv = i7;
        }
        if (getTouchCoords() != null) {
            aVar.mK = getTouchCoords();
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, aVar, (JSONObject) null);
        a aVar2 = this.aig;
        if (aVar2 != null) {
            aVar2.onAdClicked();
        }
    }

    public void d(@NonNull T t5) {
        this.mAdResultData = t5;
        R r5 = (R) com.kwad.sdk.core.response.b.c.r(t5);
        this.mAdTemplate = r5;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(r5);
        a(this);
    }

    public final boolean fq() {
        int i6 = this.mAdInfo.status;
        return (i6 == 2 || i6 == 3) ? false : true;
    }

    public long getStayTime() {
        return this.aih + getTimerHelper().getTime();
    }

    public bv getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bv();
        }
        return this.mTimerHelper;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar = this.aig;
        if (aVar != null) {
            aVar.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.aig;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    public void setInnerAdInteractionListener(a aVar) {
        this.aig = aVar;
    }

    public void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.dn = bVar;
    }

    public final void vV() {
        a aVar = this.aig;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void vW() {
        com.kwad.sdk.core.adlog.c.bR(this.mAdTemplate);
        a aVar = this.aig;
        if (aVar != null) {
            aVar.onDislikeClicked();
        }
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mContext = context;
        initView();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void aa() {
        super.aa();
        this.fg.a(this);
        this.fg.a(this.dn);
        this.fg.wi();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ab() {
        super.ab();
        this.fg.wj();
        this.fg.b(this);
        cq();
    }

    public void setMargin(int i6) {
        setPadding(i6, i6, i6, i6);
        if (!com.kwad.sdk.core.config.e.Gh()) {
            setBackgroundColor(-1);
        }
    }

    public final void c(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
        bVar.f(getTouchCoords());
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, bVar, (JSONObject) null);
        a aVar = this.aig;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public void bt() {
    }

    public void bu() {
    }

    public void cq() {
    }
}
