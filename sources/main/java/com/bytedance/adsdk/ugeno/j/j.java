package com.bytedance.adsdk.ugeno.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.j.cw;
import com.bytedance.adsdk.ugeno.j.j.j;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends AnimatorListenerAdapter {
    private com.bytedance.adsdk.ugeno.j.j.j ae;
    private ValueAnimator cw;

    /* renamed from: g, reason: collision with root package name */
    private xt f23673g;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.xt.cw f23674j;

    /* renamed from: m, reason: collision with root package name */
    private int f23675m = 1;

    /* renamed from: r, reason: collision with root package name */
    private Context f23676r;
    private String tl;
    private int up;
    private cw xt;

    public void j() {
        ValueAnimator valueAnimator = this.cw;
        if (valueAnimator == null || this.up == -2 || this.f23675m == 0) {
            return;
        }
        valueAnimator.start();
    }

    public void cw() {
        ValueAnimator valueAnimator = this.cw;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public ValueAnimator r() {
        String key;
        com.bytedance.adsdk.ugeno.j.xt.j cwVar;
        cw cwVar2 = this.xt;
        if (cwVar2 == null || this.f23674j == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> xt = cwVar2.xt();
        ArrayList arrayList = new ArrayList();
        if (xt != null && !xt.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : xt.entrySet()) {
                if (entry != null) {
                    key = entry.getKey();
                    String cw = up.j(key).cw();
                    cw.getClass();
                    switch (cw) {
                        case "int":
                            cwVar = new com.bytedance.adsdk.ugeno.j.xt.cw(this.f23676r, this.f23674j, key, entry.getValue());
                            break;
                        case "float":
                            cwVar = new com.bytedance.adsdk.ugeno.j.xt.xt(this.f23676r, this.f23674j, key, entry.getValue());
                            break;
                        case "point":
                            cwVar = new com.bytedance.adsdk.ugeno.j.xt.r(this.f23676r, this.f23674j, key, entry.getValue());
                            break;
                        default:
                            cwVar = null;
                            break;
                    }
                    if (cwVar != null) {
                        arrayList.addAll(cwVar.up());
                    }
                }
            }
        }
        JSONObject j6 = this.xt.j();
        if (j6 != null) {
            com.bytedance.adsdk.ugeno.j.j.j j7 = j.C0321j.j(this.f23674j, j6);
            this.ae = j7;
            if (j7 != null) {
                arrayList.addAll(j7.cw());
            }
        }
        final View g6 = this.f23674j.g();
        if (g6 == null) {
            return null;
        }
        final cw.j ae = this.xt.ae();
        if (ae != null) {
            g6.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.j.j.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = g6.getWidth();
                    int height = g6.getHeight();
                    g6.setPivotX(r.j(ae.f23672j, width));
                    g6.setPivotY(r.j(ae.xt, height));
                }
            });
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(g6, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.up = r.j(this.xt.r());
        ofPropertyValuesHolder.setDuration(this.xt.cw());
        int i6 = this.up;
        if (i6 != -2) {
            ofPropertyValuesHolder.setRepeatCount(i6);
        }
        this.f23675m = this.xt.oq();
        this.tl = this.xt.g();
        ofPropertyValuesHolder.setStartDelay(this.xt.m());
        ofPropertyValuesHolder.setRepeatMode(r.j(this.xt.up()));
        ofPropertyValuesHolder.setInterpolator(r.xt(this.xt.tl()));
        ofPropertyValuesHolder.addListener(this);
        this.cw = ofPropertyValuesHolder;
        return ofPropertyValuesHolder;
    }

    public String up() {
        return this.tl;
    }

    public void xt() {
        ValueAnimator valueAnimator = this.cw;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public j(Context context, com.bytedance.adsdk.ugeno.xt.cw cwVar, cw cwVar2) {
        this.f23674j = cwVar;
        this.xt = cwVar2;
        this.f23676r = context;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        xt xtVar = this.f23673g;
        if (xtVar != null) {
            xtVar.xt();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        xt xtVar = this.f23673g;
        if (xtVar != null) {
            xtVar.j();
        }
    }

    public void j(xt xtVar) {
        this.f23673g = xtVar;
    }

    public void j(Canvas canvas) {
        com.bytedance.adsdk.ugeno.j.j.j jVar = this.ae;
        if (jVar != null) {
            jVar.j(canvas);
        }
    }

    public void j(int i6, int i7) {
        com.bytedance.adsdk.ugeno.j.j.j jVar = this.ae;
        if (jVar != null) {
            jVar.j(i6, i7);
        }
    }
}
