package com.bytedance.adsdk.ugeno.j.j;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.acse.ottn.adapter.AutoScrollViewPager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends j {
    private String ae;
    private float cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f23687g;
    private PorterDuffXfermode jy;

    /* renamed from: m, reason: collision with root package name */
    private float f23688m;
    private Path oq;
    private Path qv;

    /* renamed from: r, reason: collision with root package name */
    private float f23689r;
    private boolean tl;
    private Paint up;
    private Path vl;

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public void j(Canvas canvas) {
        int hl;
        int hl2;
        if (this.xt.hl() > 0.0f) {
            hl = (int) (this.cw * this.xt.hl());
            hl2 = (int) (this.f23689r * this.xt.hl());
            this.up.setXfermode(this.jy);
            String str = this.ae;
            str.getClass();
            switch (str) {
                case "bottom":
                    canvas.drawRect(0.0f, hl2, this.cw, this.f23689r, this.up);
                    break;
                case "center":
                    this.oq.reset();
                    this.qv.reset();
                    this.vl.reset();
                    Path.Direction direction = Path.Direction.CW;
                    this.oq.addCircle(this.cw / 2.0f, this.f23689r / 2.0f, hl, direction);
                    Path path = this.qv;
                    float f6 = this.cw;
                    path.addRect(f6 / 2.0f, 0.0f, f6, this.f23689r, direction);
                    Path path2 = this.qv;
                    Path path3 = this.oq;
                    Path.Op op = Path.Op.DIFFERENCE;
                    path2.op(path3, op);
                    this.vl.addRect(0.0f, 0.0f, this.cw / 2.0f, this.f23689r, direction);
                    this.vl.op(this.oq, op);
                    canvas.drawPath(this.qv, this.up);
                    canvas.drawPath(this.vl, this.up);
                    break;
                case "top":
                    canvas.drawRect(0.0f, 0.0f, this.cw, this.f23689r - hl2, this.up);
                    break;
                case "left":
                    canvas.drawRect(0.0f, 0.0f, this.cw - hl, this.f23689r, this.up);
                    break;
                case "right":
                    canvas.drawRect(hl, 0.0f, this.cw, this.f23689r, this.up);
                    break;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public void xt() {
        this.f23688m = (float) this.f23681j.optDouble("start", 0.0d);
        this.ae = this.f23681j.optString("direction", AutoScrollViewPager.f4187g);
    }

    public up(com.bytedance.adsdk.ugeno.xt.cw cwVar, JSONObject jSONObject) {
        super(cwVar, jSONObject);
        this.tl = true;
        this.f23687g = true;
        Paint paint = new Paint();
        this.up = paint;
        paint.setAntiAlias(true);
        this.xt.g().setLayerType(2, null);
        this.jy = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.oq = new Path();
        this.qv = new Path();
        this.vl = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public List<PropertyValuesHolder> cw() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(r(), this.f23688m, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public void j(int i6, int i7) {
        if (i6 > 0 && this.tl) {
            this.cw = i6;
            this.tl = false;
        }
        if (i7 <= 0 || !this.f23687g) {
            return;
        }
        this.f23689r = i7;
        this.f23687g = false;
    }
}
