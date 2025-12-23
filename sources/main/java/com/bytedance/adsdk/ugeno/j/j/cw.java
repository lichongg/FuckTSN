package com.bytedance.adsdk.ugeno.j.j;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import com.beizi.fusion.widget.ScrollClickView;
import com.bytedance.sdk.component.utils.vl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends j {
    private Paint ae;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuffXfermode f23678g;

    /* renamed from: m, reason: collision with root package name */
    private View f23679m;
    private LinearGradient oq;
    private Matrix qv;

    /* renamed from: r, reason: collision with root package name */
    private float f23680r;
    private Paint tl;
    private float up;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public void j(Canvas canvas) {
        try {
            if (this.xt.b() > 0.0f) {
                int b6 = (int) (this.f23680r * this.xt.b());
                int b7 = (int) (this.up * this.xt.b());
                this.ae.setXfermode(this.f23678g);
                String str = this.cw;
                switch (str.hashCode()) {
                    case -1383228885:
                        if (str.equals("bottom")) {
                            float f6 = b7;
                            canvas.drawRect(0.0f, f6, this.f23680r, this.up, this.ae);
                            this.qv.setTranslate(0.0f, f6);
                            this.oq.setLocalMatrix(this.qv);
                            this.tl.setShader(this.oq);
                            if (this.xt.b() <= 1.0f && this.xt.b() > 0.9f) {
                                this.tl.setAlpha((int) (255.0f - (this.xt.b() * 255.0f)));
                            }
                            canvas.drawRect(0.0f, 0.0f, this.f23680r, f6, this.tl);
                            break;
                        }
                        break;
                    case 115029:
                        if (str.equals("top")) {
                            float f7 = b7;
                            canvas.drawRect(0.0f, 0.0f, this.f23680r, this.up - f7, this.ae);
                            this.qv.setTranslate(0.0f, this.up - f7);
                            this.oq.setLocalMatrix(this.qv);
                            this.tl.setShader(this.oq);
                            if (this.xt.b() <= 1.0f && this.xt.b() > 0.9f) {
                                this.tl.setAlpha((int) (255.0f - (this.xt.b() * 255.0f)));
                            }
                            float f8 = this.f23680r;
                            float f9 = this.up;
                            canvas.drawRect(f8, f9, 0.0f, f9 - f7, this.tl);
                            break;
                        }
                        break;
                    case 3317767:
                        if (str.equals(ScrollClickView.DIR_LEFT)) {
                            float f10 = b6;
                            canvas.drawRect(0.0f, 0.0f, this.f23680r - f10, this.up, this.ae);
                            this.qv.setTranslate(this.f23680r - f10, 0.0f);
                            this.oq.setLocalMatrix(this.qv);
                            this.tl.setShader(this.oq);
                            if (this.xt.b() <= 1.0f && this.xt.b() > 0.9f) {
                                this.tl.setAlpha((int) (255.0f - (this.xt.b() * 255.0f)));
                            }
                            float f11 = this.f23680r;
                            canvas.drawRect(f11, this.up, f11 - f10, 0.0f, this.tl);
                            break;
                        }
                        break;
                    case 108511772:
                        if (str.equals("right")) {
                            float f12 = b6;
                            canvas.drawRect(f12, 0.0f, this.f23680r, this.up, this.ae);
                            this.qv.setTranslate(f12, this.up);
                            this.oq.setLocalMatrix(this.qv);
                            this.tl.setShader(this.oq);
                            if (this.xt.b() <= 1.0f && this.xt.b() > 0.9f) {
                                this.tl.setAlpha((int) (255.0f - (this.xt.b() * 255.0f)));
                            }
                            canvas.drawRect(0.0f, 0.0f, f12, this.up, this.tl);
                            break;
                        }
                        break;
                }
            }
        } catch (Throwable th) {
            vl.r("BaseEffectWrapper", th.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public List<PropertyValuesHolder> cw() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.bytedance.adsdk.ugeno.j.up.ALPHA.xt(), 0.0f, 1.0f));
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public void xt() {
        this.cw = this.f23681j.optString("direction", ScrollClickView.DIR_LEFT);
    }

    public cw(com.bytedance.adsdk.ugeno.xt.cw cwVar, JSONObject jSONObject) {
        super(cwVar, jSONObject);
        this.f23679m = this.xt.g();
        Paint paint = new Paint();
        this.ae = paint;
        paint.setAntiAlias(true);
        this.f23679m.setLayerType(2, null);
        this.f23678g = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.tl = new Paint();
        this.qv = new Matrix();
    }

    @Override // com.bytedance.adsdk.ugeno.j.j.j
    public void j(int i6, int i7) {
        this.f23680r = i6;
        this.up = i7;
        String str = this.cw;
        str.getClass();
        switch (str) {
            case "bottom":
                this.oq = new LinearGradient(0.0f, -this.up, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.oq = new LinearGradient(0.0f, this.up, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.oq = new LinearGradient(this.f23680r, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.oq = new LinearGradient(-this.f23680r, 0.0f, 0.0f, this.up, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }
}
