package com.bytedance.adsdk.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.m;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.component.sdk.annotation.RawRes;
import com.stub.StubApp;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes3.dex */
public class LottieAnimationView extends ImageView {

    /* renamed from: j, reason: collision with root package name */
    private static final String f23172j = "LottieAnimationView";
    private static final oq<Throwable> xt = new oq<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.1
        @Override // com.bytedance.adsdk.lottie.oq
        public void j(Throwable th) {
            if (com.bytedance.adsdk.lottie.up.g.j(th)) {
                com.bytedance.adsdk.lottie.up.up.j("Unable to load composition.", th);
            } else {
                com.bytedance.adsdk.lottie.up.up.j("Unable to parse composition:", th);
            }
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private JSONArray f23173a;
    private final tl ae;
    private m av;
    private jy<m> az;
    private int ch;
    private final oq<m> cw;

    /* renamed from: f, reason: collision with root package name */
    private int f23174f;

    /* renamed from: g, reason: collision with root package name */
    @RawRes
    private int f23175g;

    /* renamed from: h, reason: collision with root package name */
    private j f23176h;

    /* renamed from: i, reason: collision with root package name */
    private final Handler f23177i;
    private final Set<r> jy;
    private long kt;

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f23178l;

    /* renamed from: m, reason: collision with root package name */
    private int f23179m;
    private Handler mi;
    private boolean oq;

    /* renamed from: p, reason: collision with root package name */
    private xt f23180p;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    private final oq<Throwable> f23181r;

    /* renamed from: s, reason: collision with root package name */
    private String f23182s;
    private com.bytedance.adsdk.lottie.model.layer.m tj;
    private String tl;
    private oq<Throwable> up;

    /* renamed from: v, reason: collision with root package name */
    private int f23183v;
    private boolean vl;

    /* renamed from: w, reason: collision with root package name */
    private int f23184w;
    private final Set<Object> ws;

    /* renamed from: x, reason: collision with root package name */
    private int f23185x;

    private static class cw extends View.BaseSavedState {
        public static final Parcelable.Creator<cw> CREATOR = new Parcelable.Creator<cw>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.cw.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public cw createFromParcel(Parcel parcel) {
                return new cw(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public cw[] newArray(int i6) {
                return new cw[i6];
            }
        };
        int ae;
        float cw;

        /* renamed from: j, reason: collision with root package name */
        String f23201j;

        /* renamed from: m, reason: collision with root package name */
        int f23202m;

        /* renamed from: r, reason: collision with root package name */
        boolean f23203r;
        String up;
        int xt;

        cw(Parcelable parcelable) {
            super(parcelable);
        }

        private cw(Parcel parcel) {
            super(parcel);
            this.f23201j = parcel.readString();
            this.cw = parcel.readFloat();
            this.f23203r = parcel.readInt() == 1;
            this.up = parcel.readString();
            this.f23202m = parcel.readInt();
            this.ae = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeString(this.f23201j);
            parcel.writeFloat(this.cw);
            parcel.writeInt(this.f23203r ? 1 : 0);
            parcel.writeString(this.up);
            parcel.writeInt(this.f23202m);
            parcel.writeInt(this.ae);
        }
    }

    public interface j {
        void j(Map<String, Object> map);

        void xt(Map<String, Object> map);
    }

    private enum r {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public interface xt {
        void j(String str, JSONArray jSONArray);
    }

    static /* synthetic */ int up(LottieAnimationView lottieAnimationView) {
        int i6 = lottieAnimationView.f23184w;
        lottieAnimationView.f23184w = i6 + 1;
        return i6;
    }

    static /* synthetic */ int w(LottieAnimationView lottieAnimationView) {
        int i6 = lottieAnimationView.f23174f;
        lottieAnimationView.f23174f = i6 - 1;
        return i6;
    }

    public void setAnimation(@RawRes int i6) {
        this.f23175g = i6;
        this.tl = null;
        setCompositionTask(j(i6));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        j(str, (String) null);
    }

    public void setMaxFrame(int i6) {
        this.ae.xt(i6);
    }

    public void setMinFrame(int i6) {
        this.ae.j(i6);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f6) {
        j(f6, true);
    }

    /* renamed from: com.bytedance.adsdk.lottie.LottieAnimationView$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23196j;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f23196j = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23196j[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23196j[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23196j[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        this.f23177i.postDelayed(this.f23178l, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void az() {
        /*
            r9 = this;
            com.bytedance.adsdk.lottie.m r0 = r9.av
            if (r0 == 0) goto Lda
            com.bytedance.adsdk.lottie.tl r0 = r9.ae
            if (r0 == 0) goto Lda
            com.bytedance.adsdk.lottie.kt r0 = r0.ch()
            com.bytedance.adsdk.lottie.m r1 = r9.av
            com.bytedance.adsdk.lottie.m$r r1 = r1.tl()
            if (r1 == 0) goto Lda
            if (r0 == 0) goto Lda
            int r2 = r1.f23340j
            java.lang.String r3 = "TMe"
            if (r2 >= 0) goto L2a
            java.lang.String r0 = "--==--- timer fail, ke is invalid: "
            java.lang.String r1 = java.lang.String.valueOf(r2)
            java.lang.String r0 = r0.concat(r1)
            com.bytedance.sdk.component.utils.vl.j(r3, r0)
            return
        L2a:
            int[] r4 = r1.up
            r5 = -1
            if (r4 == 0) goto L3a
            int r6 = r4.length
            r7 = 2
            if (r6 < r7) goto L3a
            r6 = 0
            r6 = r4[r6]
            r7 = 1
            r4 = r4[r7]
            goto L3c
        L3a:
            r4 = -1
            r6 = -1
        L3c:
            java.lang.String r7 = r1.cw
            java.lang.String r7 = r0.j(r7)
            java.lang.String r8 = r1.f23342r
            java.lang.String r0 = r0.j(r8)
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.NumberFormatException -> L53
            int r5 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L51
            goto L58
        L51:
            r0 = move-exception
            goto L55
        L53:
            r0 = move-exception
            r7 = -1
        L55:
            com.bytedance.sdk.component.utils.vl.j(r0)
        L58:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r8 = "--==--- prepare timer, startS: "
            r0.<init>(r8)
            r0.append(r7)
            java.lang.String r8 = ", lenS: "
            r0.append(r8)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.utils.vl.j(r3, r0)
            java.lang.String r0 = r1.xt
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lc7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r8 = "--==--- timer, id:"
            r0.<init>(r8)
            java.lang.String r8 = r1.xt
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.utils.vl.j(r3, r0)
            java.lang.String r0 = r1.xt
            com.bytedance.adsdk.lottie.model.layer.m r0 = r9.cw(r0)
            if (r0 == 0) goto Lda
            java.lang.String r8 = "--==--- timer success"
            com.bytedance.sdk.component.utils.vl.j(r3, r8)
            java.lang.String r3 = r1.f23341m
            r9.f23182s = r3
            org.json.JSONArray r1 = r1.ae
            r9.f23173a = r1
            r9.tj = r0
            r9.f23174f = r7
            int r1 = r7 - r5
            r9.f23183v = r1
            r9.f23185x = r6
            r9.ch = r4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r3 = r9.f23174f
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.j(r1)
            com.bytedance.adsdk.lottie.LottieAnimationView$3 r0 = new com.bytedance.adsdk.lottie.LottieAnimationView$3
            r0.<init>()
            r9.j(r0)
            goto Lda
        Lc7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "--==--- timer fail, id is invalid: "
            r0.<init>(r2)
            java.lang.String r1 = r1.xt
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.utils.vl.j(r3, r0)
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.LottieAnimationView.az():void");
    }

    private void cw(Matrix matrix, float f6, float f7, float f8, float f9) {
        matrix.postTranslate((f6 - f8) / 2.0f, (f7 - f9) / 2.0f);
    }

    private void g() {
        setSaveEnabled(false);
        this.vl = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        j(0.0f, false);
        j(false, StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        setIgnoreDisabledSystemAnimations(false);
        this.ae.j(Boolean.valueOf(com.bytedance.adsdk.lottie.up.g.j(getContext()) != 0.0f));
        oq();
        qv();
        jy();
    }

    private m.j getArea() {
        m a6;
        tl tlVar = this.ae;
        if (tlVar == null || (a6 = tlVar.a()) == null) {
            return null;
        }
        return a6.oq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m.xt getGlobalConfig() {
        m a6;
        tl tlVar = this.ae;
        if (tlVar == null || (a6 = tlVar.a()) == null) {
            return null;
        }
        return a6.vl();
    }

    private m.cw getGlobalEvent() {
        m a6;
        tl tlVar = this.ae;
        if (tlVar == null || (a6 = tlVar.a()) == null) {
            return null;
        }
        return a6.qv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        m a6;
        tl tlVar = this.ae;
        if (tlVar == null || (a6 = tlVar.a()) == null) {
            return null;
        }
        return a6.g();
    }

    private void i() {
        this.f23177i.removeCallbacksAndMessages(null);
    }

    private void jy() {
        j(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                kt ch;
                final long elapsedRealtime = SystemClock.elapsedRealtime() - LottieAnimationView.this.kt;
                LottieAnimationView.this.xt(this);
                String playDelayedELExpressTimeS = LottieAnimationView.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (ch = LottieAnimationView.this.ae.ch()) != null) {
                    try {
                        int parseInt = Integer.parseInt(ch.j(playDelayedELExpressTimeS)) * 1000;
                        if (LottieAnimationView.this.kt > 0) {
                            long elapsedRealtime2 = (LottieAnimationView.this.kt + parseInt) - SystemClock.elapsedRealtime();
                            com.bytedance.sdk.component.utils.vl.j("TMe", "--==-- lottie delayed time: ".concat(String.valueOf(elapsedRealtime2)));
                            if (elapsedRealtime2 > 0) {
                                LottieAnimationView.this.ae();
                                LottieAnimationView.this.setVisibility(8);
                                if (LottieAnimationView.this.mi == null) {
                                    LottieAnimationView.this.mi = new Handler(Looper.getMainLooper());
                                }
                                LottieAnimationView.this.mi.removeCallbacksAndMessages(null);
                                LottieAnimationView.this.mi.postDelayed(new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.bytedance.sdk.component.utils.vl.j("TMe", "--==-- lottie real start play");
                                        LottieAnimationView.this.setVisibility(0);
                                        LottieAnimationView.this.j();
                                        LottieAnimationView.this.j(elapsedRealtime);
                                    }
                                }, elapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                    }
                }
                LottieAnimationView.this.j(elapsedRealtime);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void mi() {
        boolean up = up();
        setImageDrawable(null);
        setImageDrawable(this.ae);
        if (up) {
            this.ae.ws();
        }
    }

    private void oq() {
        j(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LottieAnimationView.this.xt(this);
                LottieAnimationView.this.az();
                LottieAnimationView.this.vl();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void qv() {
        j(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Map<String, Object> map;
                int i6;
                Object animatedValue = valueAnimator.getAnimatedValue();
                if ((animatedValue instanceof Float) && ((Float) animatedValue).floatValue() >= 0.98f) {
                    LottieAnimationView.up(LottieAnimationView.this);
                    m.xt globalConfig = LottieAnimationView.this.getGlobalConfig();
                    if (globalConfig != null && (i6 = globalConfig.f23349r) > 0 && i6 > LottieAnimationView.this.f23184w) {
                        LottieAnimationView.this.az();
                        LottieAnimationView.this.j();
                        LottieAnimationView.this.setProgress(0.0f);
                        return;
                    }
                    LottieAnimationView.this.xt(this);
                    if (LottieAnimationView.this.f23176h != null) {
                        if (globalConfig == null || (map = globalConfig.cw) == null) {
                            map = null;
                        }
                        LottieAnimationView.this.f23176h.xt(map);
                    }
                }
            }
        });
    }

    private void r(Matrix matrix, float f6, float f7, float f8, float f9) {
        if (f8 >= f6 || f9 >= f7) {
            if (f8 / f9 >= f6 / f7) {
                float f10 = f6 / f8;
                matrix.preScale(f10, f10);
                matrix.postTranslate(0.0f, (f7 - (f9 * f10)) / 2.0f);
                return;
            } else {
                float f11 = f7 / f9;
                matrix.preScale(f11, f11);
                matrix.postTranslate((f6 - (f8 * f11)) / 2.0f, 0.0f);
                return;
            }
        }
        if (f8 / f9 >= f6 / f7) {
            float f12 = f6 / f8;
            matrix.preScale(f12, f12);
            matrix.postTranslate(0.0f, (f7 - (f9 * f12)) / 2.0f);
        } else {
            float f13 = f7 / f9;
            matrix.preScale(f13, f13);
            matrix.postTranslate((f6 - (f8 * f13)) / 2.0f, 0.0f);
        }
    }

    private void setCompositionTask(jy<m> jyVar) {
        this.jy.add(r.SET_ANIMATION);
        w();
        ws();
        this.az = jyVar.j(this.cw).cw(this.f23181r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl() {
        final m.xt globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.up <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.f23348m) && globalConfig.ae == null) {
            return;
        }
        int i6 = globalConfig.up;
        if (i6 > getMaxFrame()) {
            i6 = (int) getMaxFrame();
        }
        final float maxFrame = i6 / getMaxFrame();
        j(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if ((animatedValue instanceof Float) && ((Float) animatedValue).floatValue() >= maxFrame) {
                    LottieAnimationView.this.xt(this);
                    if (LottieAnimationView.this.f23180p != null) {
                        xt xtVar = LottieAnimationView.this.f23180p;
                        m.xt xtVar2 = globalConfig;
                        xtVar.j(xtVar2.f23348m, xtVar2.ae);
                    }
                }
            }
        });
    }

    private void w() {
        this.av = null;
        this.ae.qv();
    }

    private void ws() {
        jy<m> jyVar = this.az;
        if (jyVar != null) {
            jyVar.xt(this.cw);
            this.az.r(this.f23181r);
        }
    }

    private void xt(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float width2 = this.ae.getBounds().width();
        float height2 = this.ae.getBounds().height();
        if (width == 0.0f || height == 0.0f || width2 == 0.0f || height2 == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i6 = AnonymousClass5.f23196j[getScaleType().ordinal()];
        if (i6 == 1) {
            j(matrix, width, height, width2, height2);
        } else if (i6 == 2) {
            xt(matrix, width, height, width2, height2);
        } else if (i6 == 3) {
            cw(matrix, width, height, width2, height2);
        } else if (i6 == 4) {
            r(matrix, width, height, width2, height2);
        }
        matrix.mapRect(rectF, rectF2);
    }

    @MainThread
    public void ae() {
        this.qv = false;
        this.ae.p();
    }

    public boolean getClipToCompositionBounds() {
        return this.ae.r();
    }

    public m getComposition() {
        return this.av;
    }

    public long getDuration() {
        m mVar = this.av;
        if (mVar != null) {
            return (long) mVar.up();
        }
        return 0L;
    }

    public int getFrame() {
        return this.ae.kt();
    }

    public String getImageAssetsFolder() {
        return this.ae.up();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.ae.m();
    }

    public float getMaxFrame() {
        return this.ae.av();
    }

    public float getMinFrame() {
        return this.ae.az();
    }

    public w getPerformanceTracker() {
        return this.ae.g();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.ae.h();
    }

    public mi getRenderMode() {
        return this.ae.ae();
    }

    public int getRepeatCount() {
        return this.ae.f();
    }

    public int getRepeatMode() {
        return this.ae.tj();
    }

    public float getSpeed() {
        return this.ae.i();
    }

    @MainThread
    public void m() {
        this.jy.add(r.PLAY_OPTION);
        this.ae.l();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i6;
        if (!(parcelable instanceof cw)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        cw cwVar = (cw) parcelable;
        super.onRestoreInstanceState(cwVar.getSuperState());
        this.tl = cwVar.f23201j;
        Set<r> set = this.jy;
        r rVar = r.SET_ANIMATION;
        if (!set.contains(rVar) && !TextUtils.isEmpty(this.tl)) {
            setAnimation(this.tl);
        }
        this.f23175g = cwVar.xt;
        if (!this.jy.contains(rVar) && (i6 = this.f23175g) != 0) {
            setAnimation(i6);
        }
        if (!this.jy.contains(r.SET_PROGRESS)) {
            j(cwVar.cw, false);
        }
        if (!this.jy.contains(r.PLAY_OPTION) && cwVar.f23203r) {
            j();
        }
        if (!this.jy.contains(r.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(cwVar.up);
        }
        if (!this.jy.contains(r.SET_REPEAT_MODE)) {
            setRepeatMode(cwVar.f23202m);
        }
        if (this.jy.contains(r.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(cwVar.ae);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.vl ? ae.j(getContext(), str) : ae.j(getContext(), str, (String) null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z5) {
        this.ae.up(z5);
    }

    public void setCacheComposition(boolean z5) {
        this.vl = z5;
    }

    public void setClipToCompositionBounds(boolean z5) {
        this.ae.j(z5);
    }

    public void setComposition(m mVar) {
        boolean z5 = up.f23548j;
        this.ae.setCallback(this);
        this.av = mVar;
        this.oq = true;
        boolean j6 = this.ae.j(mVar, StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        this.oq = false;
        if (getDrawable() != this.ae || j6) {
            if (!j6) {
                mi();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<Object> it = this.ws.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.ae.ae(str);
    }

    public void setFailureListener(oq<Throwable> oqVar) {
        this.up = oqVar;
    }

    public void setFallbackResource(int i6) {
        this.f23179m = i6;
    }

    public void setFontAssetDelegate(com.bytedance.adsdk.lottie.cw cwVar) {
        this.ae.j(cwVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.ae.j(map);
    }

    public void setFrame(int i6) {
        this.ae.cw(i6);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z5) {
        this.ae.ae(z5);
    }

    public void setImageAssetDelegate(com.bytedance.adsdk.lottie.r rVar) {
        this.ae.j(rVar);
    }

    public void setImageAssetsFolder(String str) {
        this.ae.j(str);
    }

    public void setLottieAnimListener(j jVar) {
        this.f23176h = jVar;
    }

    public void setLottieClicklistener(xt xtVar) {
        this.f23180p = xtVar;
    }

    public void setMaintainOriginalImageBounds(boolean z5) {
        this.ae.xt(z5);
    }

    public void setMaxFrame(String str) {
        this.ae.cw(str);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f6) {
        this.ae.xt(f6);
    }

    public void setMinAndMaxFrame(String str) {
        this.ae.r(str);
    }

    public void setMinFrame(String str) {
        this.ae.xt(str);
    }

    public void setMinProgress(float f6) {
        this.ae.j(f6);
    }

    public void setOutlineMasksAndMattes(boolean z5) {
        this.ae.r(z5);
    }

    public void setPerformanceTrackingEnabled(boolean z5) {
        this.ae.cw(z5);
    }

    public void setRenderMode(mi miVar) {
        this.ae.j(miVar);
    }

    public void setRepeatCount(int i6) {
        this.jy.add(r.SET_REPEAT_COUNT);
        this.ae.up(i6);
    }

    public void setRepeatMode(int i6) {
        this.jy.add(r.SET_REPEAT_MODE);
        this.ae.r(i6);
    }

    public void setSafeMode(boolean z5) {
        this.ae.m(z5);
    }

    public void setSpeed(float f6) {
        this.ae.cw(f6);
    }

    public void setTextDelegate(kt ktVar) {
        this.ae.j(ktVar);
    }

    public void setUseCompositionFrameRate(boolean z5) {
        this.ae.tl(z5);
    }

    public void setViewDelegate(tj tjVar) {
        this.ae.j(tjVar);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        tl tlVar;
        if (!this.oq && drawable == (tlVar = this.ae) && tlVar.v()) {
            ae();
        } else if (!this.oq && (drawable instanceof tl)) {
            tl tlVar2 = (tl) drawable;
            if (tlVar2.v()) {
                tlVar2.p();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public boolean up() {
        return this.ae.v();
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.cw = new oq<m>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.6
            @Override // com.bytedance.adsdk.lottie.oq
            public void j(m mVar) {
                LottieAnimationView.this.setComposition(mVar);
            }
        };
        this.f23181r = new oq<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.7
            @Override // com.bytedance.adsdk.lottie.oq
            public void j(Throwable th) {
                if (LottieAnimationView.this.f23179m != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.f23179m);
                }
                (LottieAnimationView.this.up == null ? LottieAnimationView.xt : LottieAnimationView.this.up).j(th);
            }
        };
        this.f23179m = 0;
        this.ae = new tl(this);
        this.oq = false;
        this.qv = false;
        this.vl = true;
        this.jy = new HashSet();
        this.ws = new HashSet();
        this.f23177i = new Handler(Looper.getMainLooper());
        this.f23184w = 0;
        this.kt = 0L;
        this.f23178l = new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.utils.vl.j("TMe", "--==--- timer callback, timer: " + LottieAnimationView.this.f23174f + ", " + LottieAnimationView.this.f23183v);
                if (LottieAnimationView.this.f23174f > LottieAnimationView.this.f23183v) {
                    LottieAnimationView.w(LottieAnimationView.this);
                    com.bytedance.adsdk.lottie.model.layer.m mVar = LottieAnimationView.this.tj;
                    StringBuilder sb = new StringBuilder();
                    sb.append(LottieAnimationView.this.f23174f);
                    mVar.j(sb.toString());
                    LottieAnimationView.this.invalidate();
                    LottieAnimationView.this.av();
                    return;
                }
                if (LottieAnimationView.this.f23185x < 0 || LottieAnimationView.this.ch < 0) {
                    com.bytedance.sdk.component.utils.vl.j("TMe", "--==--- timer end, frame invalid: " + LottieAnimationView.this.f23185x + "," + LottieAnimationView.this.ch);
                } else {
                    com.bytedance.sdk.component.utils.vl.j("TMe", "--==--- timer end, play anim, startframe: " + LottieAnimationView.this.f23185x);
                    LottieAnimationView.this.xt();
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setFrame(lottieAnimationView.f23185x);
                    LottieAnimationView.this.j(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (LottieAnimationView.this.getFrame() < LottieAnimationView.this.ch - 1 || LottieAnimationView.this.getFrame() >= LottieAnimationView.this.ch + 2) {
                                return;
                            }
                            com.bytedance.sdk.component.utils.vl.j("TMe", "--==--- timer end, play anim, endframe: " + LottieAnimationView.this.ch);
                            LottieAnimationView.this.xt(this);
                            LottieAnimationView.this.ae();
                        }
                    });
                }
                if ((!TextUtils.isEmpty(LottieAnimationView.this.f23182s) || (LottieAnimationView.this.f23173a != null && LottieAnimationView.this.f23173a.length() > 0)) && LottieAnimationView.this.f23180p != null) {
                    LottieAnimationView.this.f23180p.j(LottieAnimationView.this.f23182s, LottieAnimationView.this.f23173a);
                }
            }
        };
        g();
    }

    private com.bytedance.adsdk.lottie.model.layer.m cw(String str) {
        com.bytedance.adsdk.lottie.model.layer.r cw2;
        tl tlVar = this.ae;
        if (tlVar == null || (cw2 = tlVar.cw()) == null) {
            return null;
        }
        return j(cw2, str);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof tl) && ((tl) drawable).ae() == mi.SOFTWARE) {
            this.ae.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        tl tlVar = this.ae;
        if (drawable2 == tlVar) {
            super.invalidateDrawable(tlVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.qv) {
            this.ae.vl();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
        Handler handler = this.mi;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        r();
        cw();
        m();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        cw cwVar = new cw(super.onSaveInstanceState());
        cwVar.f23201j = this.tl;
        cwVar.xt = this.f23175g;
        cwVar.cw = this.ae.h();
        cwVar.f23203r = this.ae.x();
        cwVar.up = this.ae.up();
        cwVar.f23202m = this.ae.tj();
        cwVar.ae = this.ae.f();
        return cwVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        if (r3 <= (r4 + r0.tl)) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.LottieAnimationView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        ws();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        ws();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i6) {
        ws();
        super.setImageResource(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j6) {
        Map<String, Object> map;
        m.xt globalConfig = getGlobalConfig();
        if (this.f23176h != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(j6));
            if (globalConfig != null && (map = globalConfig.xt) != null && !map.isEmpty()) {
                hashMap.putAll(globalConfig.xt);
            }
            this.f23176h.j(hashMap);
        }
    }

    public void setAnimation(String str) {
        this.tl = str;
        this.f23175g = 0;
        setCompositionTask(xt(str));
    }

    public void cw() {
        this.ae.w();
    }

    public void r() {
        this.ae.mi();
    }

    private g j(String str) {
        tl tlVar;
        m a6;
        Map<String, g> i6;
        if (TextUtils.isEmpty(str) || (tlVar = this.ae) == null || (a6 = tlVar.a()) == null || (i6 = a6.i()) == null) {
            return null;
        }
        return i6.get(str);
    }

    private void xt(Matrix matrix, float f6, float f7, float f8, float f9) {
        if (f8 < f6 && f9 < f7) {
            matrix.postTranslate((f6 - f8) / 2.0f, (f7 - f9) / 2.0f);
            return;
        }
        if (f8 / f9 >= f6 / f7) {
            float f10 = f6 / f8;
            matrix.preScale(f10, f10);
            matrix.postTranslate(0.0f, (f7 - (f9 * f10)) / 2.0f);
        } else {
            float f11 = f7 / f9;
            matrix.preScale(f11, f11);
            matrix.postTranslate((f6 - (f8 * f11)) / 2.0f, 0.0f);
        }
    }

    private void j(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i6 = iArr2[0];
            final int i7 = iArr2[1];
            if (i6 < 0 || i7 < 0) {
                return;
            }
            com.bytedance.sdk.component.utils.vl.j("TMe", "--==--- inel enter, play anim, startframe: ".concat(String.valueOf(i6)));
            i();
            j();
            setFrame(i6);
            j(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.12
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (LottieAnimationView.this.getFrame() < i7 - 1 || LottieAnimationView.this.getFrame() >= i7 + 2) {
                        return;
                    }
                    com.bytedance.sdk.component.utils.vl.j("TMe", "--==--- inel enter, play anim end, endframe: " + i7 + ", realFrame: " + LottieAnimationView.this.getFrame());
                    LottieAnimationView.this.xt(this);
                    LottieAnimationView.this.ae();
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    private jy<m> xt(final String str) {
        if (isInEditMode()) {
            return new jy<>(new Callable<vl<m>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public vl<m> call() throws Exception {
                    return LottieAnimationView.this.vl ? ae.cw(LottieAnimationView.this.getContext(), str) : ae.cw(LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        return this.vl ? ae.xt(getContext(), str) : ae.xt(getContext(), str, (String) null);
    }

    @MainThread
    public void xt() {
        this.jy.add(r.PLAY_OPTION);
        this.ae.ws();
    }

    public void xt(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ae.xt(animatorUpdateListener);
    }

    private void j(String str, String str2, JSONArray jSONArray) {
        xt xtVar;
        m.cw globalEvent = getGlobalEvent();
        if (globalEvent != null && str != null) {
            if (TextUtils.isEmpty(str2) && !str.contains("CSJNO")) {
                str2 = globalEvent.f23332j;
            }
            if ((jSONArray == null || jSONArray.length() <= 0) && !str.contains("CSJLELNO")) {
                jSONArray = globalEvent.cw;
            }
        }
        if ((!TextUtils.isEmpty(str2) || (jSONArray != null && jSONArray.length() > 0)) && (xtVar = this.f23180p) != null) {
            xtVar.j(str2, jSONArray);
        }
    }

    public void xt(Animator.AnimatorListener animatorListener) {
        this.ae.xt(animatorListener);
    }

    private void j(m.j jVar) {
        jVar.up = com.bytedance.adsdk.lottie.up.g.j("x", jVar.f23333j, getWidth());
        jVar.f23334m = com.bytedance.adsdk.lottie.up.g.j("y", jVar.xt, getHeight());
        jVar.ae = com.bytedance.adsdk.lottie.up.g.j((String) null, jVar.cw, getWidth());
        jVar.tl = com.bytedance.adsdk.lottie.up.g.j((String) null, jVar.f23335r, getHeight());
    }

    private com.bytedance.adsdk.lottie.model.layer.cw j(MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.r cw2;
        tl tlVar = this.ae;
        if (tlVar == null || (cw2 = tlVar.cw()) == null) {
            return null;
        }
        return j(cw2, motionEvent);
    }

    private com.bytedance.adsdk.lottie.model.layer.cw j(com.bytedance.adsdk.lottie.model.layer.r rVar, MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.cw j6;
        for (com.bytedance.adsdk.lottie.model.layer.cw cwVar : rVar.ws()) {
            if (cwVar instanceof com.bytedance.adsdk.lottie.model.layer.r) {
                if (cwVar.oq() && cwVar.tl() > 0.0f) {
                    RectF rectF = new RectF();
                    cwVar.j(rectF, cwVar.m(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (j6 = j((com.bytedance.adsdk.lottie.model.layer.r) cwVar, motionEvent)) != null) {
                        return j6;
                    }
                }
            } else if (cwVar.oq() && cwVar.tl() > 0.0f) {
                RectF rectF2 = new RectF();
                tl tlVar = this.ae;
                if (tlVar != null && tlVar.tl()) {
                    cwVar.j(rectF2, cwVar.m(), true);
                    RectF la = this.ae.la();
                    if (la != null) {
                        j(rectF2, la);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    cwVar.j(rectF3, cwVar.m(), true);
                    xt(rectF2, rectF3);
                }
                if (j(motionEvent, rectF2)) {
                    return cwVar;
                }
            }
        }
        return null;
    }

    private boolean j(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            if (x5 >= rectF.left && x5 <= rectF.right && y5 >= rectF.top && y5 <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void j(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        if (width == 0.0f || height == 0.0f || width2 == 0.0f || height2 == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i6 = AnonymousClass5.f23196j[getScaleType().ordinal()];
        if (i6 == 1) {
            j(matrix, width, height, width2, height2);
        } else if (i6 == 2) {
            xt(matrix, width, height, width2, height2);
        } else if (i6 == 3) {
            cw(matrix, width, height, width2, height2);
        } else if (i6 == 4) {
            r(matrix, width, height, width2, height2);
        }
        matrix.mapRect(rectF);
    }

    private void j(Matrix matrix, float f6, float f7, float f8, float f9) {
        if (f8 / f9 >= f6 / f7) {
            float f10 = f7 / f9;
            matrix.preScale(f10, f10);
            matrix.postTranslate(-(((f8 * f10) - f6) / 2.0f), 0.0f);
        } else {
            float f11 = f6 / f8;
            matrix.preScale(f11, f11);
            matrix.postTranslate(0.0f, -(((f9 * f11) - f7) / 2.0f));
        }
    }

    public void j(boolean z5, Context context) {
        this.ae.j(z5, context);
    }

    private jy<m> j(@RawRes final int i6) {
        if (isInEditMode()) {
            return new jy<>(new Callable<vl<m>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.13
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public vl<m> call() throws Exception {
                    return LottieAnimationView.this.vl ? ae.xt(LottieAnimationView.this.getContext(), i6) : ae.xt(LottieAnimationView.this.getContext(), i6, (String) null);
                }
            }, true);
        }
        return this.vl ? ae.j(getContext(), i6) : ae.j(getContext(), i6, (String) null);
    }

    public void j(String str, String str2) {
        j(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void j(InputStream inputStream, String str) {
        setCompositionTask(ae.j(inputStream, str));
    }

    private com.bytedance.adsdk.lottie.model.layer.m j(com.bytedance.adsdk.lottie.model.layer.r rVar, String str) {
        for (com.bytedance.adsdk.lottie.model.layer.cw cwVar : rVar.ws()) {
            if (cwVar instanceof com.bytedance.adsdk.lottie.model.layer.r) {
                com.bytedance.adsdk.lottie.model.layer.m j6 = j((com.bytedance.adsdk.lottie.model.layer.r) cwVar, str);
                if (j6 != null) {
                    return j6;
                }
            } else if (TextUtils.equals(str, cwVar.qv()) && (cwVar instanceof com.bytedance.adsdk.lottie.model.layer.m)) {
                return (com.bytedance.adsdk.lottie.model.layer.m) cwVar;
            }
        }
        return null;
    }

    @MainThread
    public void j() {
        if (this.kt == 0) {
            this.kt = SystemClock.elapsedRealtime();
        }
        this.jy.add(r.PLAY_OPTION);
        this.ae.vl();
    }

    public void j(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ae.j(animatorUpdateListener);
    }

    public void j(Animator.AnimatorListener animatorListener) {
        this.ae.j(animatorListener);
    }

    @Deprecated
    public void j(boolean z5) {
        this.ae.up(z5 ? -1 : 0);
    }

    public Bitmap j(String str, Bitmap bitmap) {
        return this.ae.j(str, bitmap);
    }

    private void j(@FloatRange(from = 0.0d, to = 1.0d) float f6, boolean z5) {
        if (z5) {
            this.jy.add(r.SET_PROGRESS);
        }
        this.ae.r(f6);
    }
}
