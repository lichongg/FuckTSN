package com.bytedance.adsdk.ugeno.j.xt;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.j.up;
import com.bytedance.adsdk.ugeno.m.tl;
import java.util.TreeMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends j {

    /* renamed from: com.bytedance.adsdk.ugeno.j.xt.xt$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23707j;

        static {
            int[] iArr = new int[up.values().length];
            f23707j = iArr;
            try {
                iArr[up.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23707j[up.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23707j[up.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23707j[up.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23707j[up.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23707j[up.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23707j[up.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23707j[up.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23707j[up.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.j.xt.j
    public void j(float f6, String str) {
        this.up.add(Keyframe.ofFloat(f6, (this.xt.startsWith(up.TRANSLATE.j()) || this.f23705r == up.BORDER_RADIUS) ? tl.j(this.f23703j, com.bytedance.adsdk.ugeno.m.cw.j(str, 0.0f)) : com.bytedance.adsdk.ugeno.m.cw.j(str, 0.0f)));
    }

    @Override // com.bytedance.adsdk.ugeno.j.xt.j
    public TypeEvaluator m() {
        return new FloatEvaluator();
    }

    @Override // com.bytedance.adsdk.ugeno.j.xt.j
    public void xt() {
        float jy;
        switch (AnonymousClass1.f23707j[this.f23705r.ordinal()]) {
            case 1:
                jy = this.ae.jy();
                break;
            case 2:
                jy = this.ae.ws();
                break;
            case 3:
                jy = this.ae.az();
                break;
            case 4:
                jy = this.ae.av();
                break;
            case 5:
                jy = this.ae.i();
                break;
            case 6:
                jy = this.ae.w();
                break;
            case 7:
                jy = this.ae.mi();
                break;
            case 8:
                jy = this.ae.kt();
                break;
            case 9:
                jy = this.ae.tj();
                break;
            default:
                jy = 0.0f;
                break;
        }
        this.up.add(Keyframe.ofFloat(0.0f, jy));
    }

    public xt(Context context, com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, TreeMap<Float, String> treeMap) {
        super(context, cwVar, str, treeMap);
    }
}
