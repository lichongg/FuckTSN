package com.bytedance.adsdk.ugeno.j.xt;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.j.up;
import java.util.TreeMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends j {
    @Override // com.bytedance.adsdk.ugeno.j.xt.j
    public void j(float f6, String str) {
        this.up.add(this.f23705r == up.BACKGROUND_COLOR ? Keyframe.ofInt(f6, com.bytedance.adsdk.ugeno.m.j.j(str)) : Keyframe.ofInt(f6, com.bytedance.adsdk.ugeno.m.cw.j(str, 0)));
    }

    @Override // com.bytedance.adsdk.ugeno.j.xt.j
    public TypeEvaluator m() {
        return this.f23705r == up.BACKGROUND_COLOR ? new ArgbEvaluator() : new IntEvaluator();
    }

    @Override // com.bytedance.adsdk.ugeno.j.xt.j
    public void xt() {
        if (this.f23705r == up.BACKGROUND_COLOR) {
            this.up.add(Keyframe.ofInt(0.0f, this.ae.c()));
        }
    }

    public cw(Context context, com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, TreeMap<Float, String> treeMap) {
        super(context, cwVar, str, treeMap);
    }
}
