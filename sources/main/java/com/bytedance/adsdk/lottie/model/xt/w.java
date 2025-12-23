package com.bytedance.adsdk.lottie.model.xt;

import android.graphics.Paint;
import com.bytedance.adsdk.lottie.j.j.kt;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class w implements cw {
    private final j ae;
    private final List<com.bytedance.adsdk.lottie.model.j.xt> cw;

    /* renamed from: g, reason: collision with root package name */
    private final float f23488g;

    /* renamed from: j, reason: collision with root package name */
    private final String f23489j;

    /* renamed from: m, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.j.xt f23490m;
    private final boolean oq;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.j.j f23491r;
    private final xt tl;
    private final com.bytedance.adsdk.lottie.model.j.r up;
    private final com.bytedance.adsdk.lottie.model.j.xt xt;

    public enum j {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap j() {
            int i6 = AnonymousClass1.f23492j[ordinal()];
            return i6 != 1 ? i6 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    public enum xt {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join j() {
            int i6 = AnonymousClass1.xt[ordinal()];
            if (i6 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i6 == 2) {
                return Paint.Join.MITER;
            }
            if (i6 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.xt.cw
    public com.bytedance.adsdk.lottie.j.j.cw j(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar) {
        return new kt(tlVar, cwVar, this);
    }

    /* renamed from: com.bytedance.adsdk.lottie.model.xt.w$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23492j;
        static final /* synthetic */ int[] xt;

        static {
            int[] iArr = new int[xt.values().length];
            xt = iArr;
            try {
                iArr[xt.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xt[xt.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xt[xt.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[j.values().length];
            f23492j = iArr2;
            try {
                iArr2[j.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23492j[j.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23492j[j.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public j ae() {
        return this.ae;
    }

    public com.bytedance.adsdk.lottie.model.j.r cw() {
        return this.up;
    }

    public float g() {
        return this.f23488g;
    }

    public String j() {
        return this.f23489j;
    }

    public com.bytedance.adsdk.lottie.model.j.xt m() {
        return this.xt;
    }

    public boolean oq() {
        return this.oq;
    }

    public com.bytedance.adsdk.lottie.model.j.xt r() {
        return this.f23490m;
    }

    public xt tl() {
        return this.tl;
    }

    public List<com.bytedance.adsdk.lottie.model.j.xt> up() {
        return this.cw;
    }

    public com.bytedance.adsdk.lottie.model.j.j xt() {
        return this.f23491r;
    }

    public w(String str, com.bytedance.adsdk.lottie.model.j.xt xtVar, List<com.bytedance.adsdk.lottie.model.j.xt> list, com.bytedance.adsdk.lottie.model.j.j jVar, com.bytedance.adsdk.lottie.model.j.r rVar, com.bytedance.adsdk.lottie.model.j.xt xtVar2, j jVar2, xt xtVar3, float f6, boolean z5) {
        this.f23489j = str;
        this.xt = xtVar;
        this.cw = list;
        this.f23491r = jVar;
        this.up = rVar;
        this.f23490m = xtVar2;
        this.ae = jVar2;
        this.tl = xtVar3;
        this.f23488g = f6;
        this.oq = z5;
    }
}
