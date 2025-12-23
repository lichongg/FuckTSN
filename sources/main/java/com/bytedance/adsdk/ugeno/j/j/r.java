package com.bytedance.adsdk.ugeno.j.j;

import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.m.j;
import com.bytedance.adsdk.ugeno.m.tl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends j {
    private static final float av;
    private static final float az;

    /* renamed from: i, reason: collision with root package name */
    private static final float f23682i;
    private static final float ws;
    private int ae;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private float f23683g;
    private Path jy;

    /* renamed from: m, reason: collision with root package name */
    private j.C0322j f23684m;
    private int oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private Paint f23685r;
    private int tl;
    private Path up;
    private boolean vl;

    /* renamed from: w, reason: collision with root package name */
    private float f23686w;

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    @SuppressLint({"DrawAllocation"})
    public void j(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.xt.z() > 0.0f) {
                int i6 = this.oq;
                float f6 = az;
                float z5 = (i6 + (i6 * f6)) * this.xt.z();
                this.jy.reset();
                this.jy.moveTo(z5, 0.0f);
                int i7 = this.qv;
                float f7 = z5 - (i7 * f6);
                this.jy.lineTo(f7, i7);
                this.jy.lineTo(f7 + this.cw, this.qv);
                this.jy.lineTo(this.cw + z5, 0.0f);
                this.jy.close();
                float f8 = this.f23686w;
                float f9 = av * f8;
                float f10 = f8 * f23682i;
                if (!this.vl || this.f23684m == null) {
                    int i8 = this.tl;
                    linearGradient = new LinearGradient(z5, 0.0f, z5 + f9, f10, new int[]{i8, this.ae, i8}, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(z5, 0.0f, z5 + f9, f10, this.f23684m.xt, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.f23685r.setShader(linearGradient);
                Path path = this.up;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.jy, this.f23685r);
            }
        } catch (Throwable unused) {
        }
    }

    static {
        float radians = (float) Math.toRadians(30.0d);
        ws = radians;
        az = (float) Math.tan(radians);
        av = (float) Math.cos(radians);
        f23682i = (float) Math.sin(radians);
    }

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public void xt() {
        this.cw = (int) tl.j(this.xt.g().getContext(), this.f23681j.optInt("shineWidth", 30));
        String optString = this.f23681j.optString("backgroundColor", "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(optString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : optString;
        if (str.startsWith("linear")) {
            this.f23684m = com.bytedance.adsdk.ugeno.m.j.xt(str);
        } else {
            int j6 = com.bytedance.adsdk.ugeno.m.j.j(str);
            this.ae = j6;
            this.tl = com.bytedance.adsdk.ugeno.m.j.j(j6, 32);
            this.vl = false;
        }
        this.f23686w = av * this.cw;
    }

    public r(com.bytedance.adsdk.ugeno.xt.cw cwVar, JSONObject jSONObject) {
        super(cwVar, jSONObject);
        this.vl = true;
        Paint paint = new Paint();
        this.f23685r = paint;
        paint.setAntiAlias(true);
        this.up = new Path();
        this.f23683g = this.xt.tj();
        this.jy = new Path();
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
        this.oq = i6;
        this.qv = i7;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i6, i7);
            Path path = this.up;
            float f6 = this.f23683g;
            path.addRoundRect(rectF, f6, f6, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }
}
