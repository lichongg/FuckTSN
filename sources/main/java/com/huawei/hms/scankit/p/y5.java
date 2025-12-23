package com.huawei.hms.scankit.p;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class y5 {

    /* renamed from: a, reason: collision with root package name */
    private long f35048a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f35049b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f35050c;

    /* renamed from: d, reason: collision with root package name */
    private int f35051d;

    /* renamed from: e, reason: collision with root package name */
    private int f35052e;

    /* renamed from: f, reason: collision with root package name */
    private float f35053f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f35054g;

    /* renamed from: h, reason: collision with root package name */
    private b6 f35055h;

    private void a() {
        b6 b6Var = this.f35055h;
        if (b6Var != null) {
            b6Var.a();
        }
    }

    private int b() {
        float a6 = n6.a(1.0f);
        int red = Color.red(this.f35050c);
        int blue = Color.blue(this.f35050c);
        return Color.rgb((int) (red + ((Color.red(this.f35051d) - red) * a6) + 0.5f), (int) (Color.green(this.f35050c) + ((Color.green(this.f35051d) - r3) * a6) + 0.5f), (int) (blue + ((Color.blue(this.f35051d) - blue) * a6) + 0.5f));
    }

    public y5(@NonNull b6 b6Var, Rect rect, int i6, float f6, int[] iArr) {
        this.f35050c = 0;
        this.f35051d = 0;
        this.f35055h = b6Var;
        this.f35054g = rect;
        this.f35052e = i6;
        if (iArr != null && iArr.length >= 2) {
            this.f35050c = iArr[0];
            this.f35051d = iArr[1];
        }
        this.f35053f = f6;
        c();
    }

    private void c() {
        Rect rect;
        a();
        this.f35049b = 0L;
        this.f35048a = System.currentTimeMillis();
        b6 b6Var = this.f35055h;
        if (b6Var != null && (rect = this.f35054g) != null) {
            b6Var.a(rect, this.f35052e);
        }
    }

    public void a(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.f35055h == null || canvas == null || rect == null) {
            return;
        }
        long currentTimeMillis = this.f35049b + (System.currentTimeMillis() - this.f35048a);
        this.f35049b = currentTimeMillis;
        this.f35055h.b(currentTimeMillis);
        List<w5> c6 = this.f35055h.c();
        if (c6 == null || c6.isEmpty()) {
            return;
        }
        a(canvas, rect, c6);
        this.f35048a = System.currentTimeMillis();
    }

    private void a(Canvas canvas, Rect rect, List<w5> list) {
        for (w5 w5Var : list) {
            Paint paint = new Paint();
            if (w5Var.b() == 0) {
                w5Var.b(b());
            }
            paint.setColor(w5Var.b());
            boolean z5 = w5Var.d() > ((float) Math.max(rect.top, rect.bottom)) || w5Var.d() < ((float) Math.min(rect.top, rect.bottom));
            float f6 = 0.0f;
            if (rect.height() != 0 && rect.width() != 0 && !z5) {
                f6 = (rect.bottom - w5Var.d()) / rect.height();
            }
            int a6 = (int) (w5Var.a() * Math.abs(f6));
            if (a6 > 0) {
                paint.setAlpha(a6);
                canvas.drawCircle(w5Var.c(), w5Var.d(), w5Var.f() * this.f35053f, paint);
            }
        }
    }
}
