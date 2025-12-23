package com.bytedance.adsdk.ugeno.j.j;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends j {
    private static final int ae = Color.parseColor("#7ed321");
    private int cw;

    /* renamed from: m, reason: collision with root package name */
    private Paint f23690m;

    /* renamed from: r, reason: collision with root package name */
    private int f23691r;
    private int up;

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public void j(Canvas canvas) {
        try {
            if (this.xt.hh() > 0.0f) {
                this.f23690m.setColor(this.cw);
                this.f23690m.setAlpha((int) ((1.0f - this.xt.hh()) * 255.0f));
                ((ViewGroup) this.xt.g().getParent()).setClipChildren(true);
                canvas.drawCircle(this.f23691r, this.up, Math.min(r0, r2) * 2 * this.xt.hh(), this.f23690m);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public void xt() {
        this.cw = com.bytedance.adsdk.ugeno.m.j.j(this.f23681j.optString("backgroundColor"), ae);
    }

    public xt(com.bytedance.adsdk.ugeno.xt.cw cwVar, JSONObject jSONObject) {
        super(cwVar, jSONObject);
        Paint paint = new Paint();
        this.f23690m = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public List<PropertyValuesHolder> cw() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(r(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public void j(int i6, int i7) {
        this.f23691r = i6 / 2;
        this.up = i7 / 2;
    }
}
