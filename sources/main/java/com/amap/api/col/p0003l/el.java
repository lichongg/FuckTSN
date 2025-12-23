package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.stub.StubApp;
import java.io.File;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class el extends View {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f6121a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f6122b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f6123c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f6124d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f6125e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f6126f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f6127g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f6128h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6129i;

    /* renamed from: j, reason: collision with root package name */
    private int f6130j;

    /* renamed from: k, reason: collision with root package name */
    private int f6131k;

    /* renamed from: l, reason: collision with root package name */
    private int f6132l;

    /* renamed from: m, reason: collision with root package name */
    private int f6133m;

    /* renamed from: n, reason: collision with root package name */
    private int f6134n;

    /* renamed from: o, reason: collision with root package name */
    private int f6135o;

    /* renamed from: p, reason: collision with root package name */
    private int f6136p;

    /* renamed from: q, reason: collision with root package name */
    private int f6137q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6138r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f6139s;

    /* renamed from: t, reason: collision with root package name */
    private Context f6140t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f6141u;

    /* renamed from: v, reason: collision with root package name */
    private float f6142v;

    /* renamed from: w, reason: collision with root package name */
    private float f6143w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f6144x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f6145y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends b8 {
        a() {
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            el.this.e(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME, 0);
            el.this.e(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME, 1);
            if ("".equals(r2.b(el.this.f6140t, "amap_web_logo", "md5_day", ""))) {
                if (el.this.f6123c == null || el.this.f6124d == null) {
                    r2.c(el.this.f6140t, "amap_web_logo", "md5_day", "0b718b5f291b09d2b62be725dfb977b3");
                    r2.c(el.this.f6140t, "amap_web_logo", "md5_night", "4b1405462a5c910de0e0723ffd96c018");
                    return;
                }
                r2.c(el.this.f6140t, "amap_web_logo", "md5_day", m4.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME));
                String a6 = m4.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME);
                if (!"".equals(a6)) {
                    r2.c(el.this.f6140t, "amap_web_logo", "md5_night", a6);
                }
                el.this.p(true);
            }
        }
    }

    public final void c(int i6) {
        this.f6135o = 0;
        this.f6132l = i6;
        l();
    }

    public final void i(int i6) {
        this.f6135o = 1;
        this.f6137q = i6;
        l();
    }

    public final void m(int i6) {
        this.f6135o = 1;
        this.f6136p = i6;
        l();
    }

    private Bitmap r() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        return (!this.f6145y || (bitmap3 = this.f6125e) == null) ? this.f6129i ? (!this.f6139s || (bitmap2 = this.f6124d) == null) ? this.f6122b : bitmap2 : (!this.f6139s || (bitmap = this.f6123c) == null) ? this.f6121a : bitmap : bitmap3;
    }

    private void s() {
        int i6 = this.f6135o;
        if (i6 == 0) {
            u();
        } else if (i6 == 2) {
            t();
        }
        this.f6133m = this.f6136p;
        int height = (getHeight() - this.f6137q) - this.f6130j;
        this.f6134n = height;
        if (this.f6133m < 0) {
            this.f6133m = 0;
        }
        if (height < 0) {
            this.f6134n = 0;
        }
    }

    private void t() {
        if (this.f6144x) {
            this.f6136p = (int) (getWidth() * this.f6142v);
        } else {
            this.f6136p = (int) ((getWidth() * this.f6142v) - this.f6131k);
        }
        this.f6137q = (int) (getHeight() * this.f6143w);
    }

    private void u() {
        int i6 = this.f6132l;
        if (i6 == 1) {
            this.f6136p = (getWidth() - this.f6131k) / 2;
        } else if (i6 == 2) {
            this.f6136p = (getWidth() - this.f6131k) - 10;
        } else {
            this.f6136p = 10;
        }
        this.f6137q = 8;
    }

    public final void b() {
        try {
            Bitmap bitmap = this.f6121a;
            if (bitmap != null) {
                b3.B(bitmap);
                this.f6121a = null;
            }
            Bitmap bitmap2 = this.f6122b;
            if (bitmap2 != null) {
                b3.B(bitmap2);
                this.f6122b = null;
            }
            this.f6121a = null;
            this.f6122b = null;
            Bitmap bitmap3 = this.f6126f;
            if (bitmap3 != null) {
                b3.B(bitmap3);
                this.f6126f = null;
            }
            Bitmap bitmap4 = this.f6127g;
            if (bitmap4 != null) {
                b3.B(bitmap4);
                this.f6127g = null;
            }
            Bitmap bitmap5 = this.f6123c;
            if (bitmap5 != null) {
                b3.B(bitmap5);
            }
            this.f6123c = null;
            Bitmap bitmap6 = this.f6124d;
            if (bitmap6 != null) {
                b3.B(bitmap6);
            }
            this.f6124d = null;
            Bitmap bitmap7 = this.f6125e;
            if (bitmap7 != null) {
                bitmap7.recycle();
            }
            this.f6128h = null;
        } catch (Throwable th) {
            v5.p(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public final void d(int i6, float f6) {
        if (this.f6141u) {
            this.f6135o = 2;
            float max = Math.max(0.0f, Math.min(f6, 1.0f));
            if (i6 == 0) {
                this.f6142v = max;
                this.f6144x = true;
            } else if (i6 == 1) {
                this.f6142v = 1.0f - max;
                this.f6144x = false;
            } else if (i6 == 2) {
                this.f6143w = 1.0f - max;
            }
            l();
        }
    }

    public final void e(String str, int i6) {
        try {
            if (this.f6141u && new File(str).exists()) {
                if (i6 == 0) {
                    Bitmap bitmap = this.f6123c;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    this.f6126f = decodeFile;
                    this.f6123c = b3.m(decodeFile, ga.f6364a);
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    b3.B(bitmap);
                    return;
                }
                if (i6 == 1) {
                    Bitmap bitmap2 = this.f6124d;
                    Bitmap decodeFile2 = BitmapFactory.decodeFile(str);
                    this.f6126f = decodeFile2;
                    this.f6124d = b3.m(decodeFile2, ga.f6364a);
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    b3.B(bitmap2);
                }
            }
        } catch (Throwable th) {
            v5.p(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }

    public final void f(boolean z5) {
        if (this.f6141u) {
            try {
                this.f6129i = z5;
                if (z5) {
                    this.f6128h.setColor(-1);
                } else {
                    this.f6128h.setColor(ViewCompat.MEASURED_STATE_MASK);
                }
            } catch (Throwable th) {
                v5.p(th, "WaterMarkerView", "changeBitmap");
                th.printStackTrace();
            }
        }
    }

    public final Point h() {
        return new Point(this.f6133m, this.f6134n - 2);
    }

    public final void j(boolean z5) {
        if (this.f6141u) {
            this.f6145y = z5;
            if (!z5) {
                this.f6131k = this.f6121a.getWidth();
                this.f6130j = this.f6121a.getHeight();
                return;
            }
            Bitmap bitmap = this.f6125e;
            if (bitmap != null) {
                this.f6131k = bitmap.getWidth();
                this.f6130j = this.f6125e.getHeight();
            }
        }
    }

    public final void n(boolean z5) {
        this.f6141u = z5;
    }

    public final float o(int i6) {
        float f6;
        if (!this.f6141u) {
            return 0.0f;
        }
        if (i6 == 0) {
            return this.f6142v;
        }
        if (i6 == 1) {
            f6 = this.f6142v;
        } else {
            if (i6 != 2) {
                return 0.0f;
            }
            f6 = this.f6143w;
        }
        return 1.0f - f6;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        try {
            if (this.f6141u && getWidth() != 0 && getHeight() != 0 && this.f6122b != null) {
                if (!this.f6138r) {
                    s();
                    this.f6138r = true;
                }
                canvas.drawBitmap(r(), this.f6133m, this.f6134n, this.f6128h);
            }
        } catch (Throwable th) {
            v5.p(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }

    public final void p(boolean z5) {
        if (this.f6141u && this.f6139s != z5) {
            this.f6139s = z5;
            if (!z5) {
                this.f6131k = this.f6121a.getWidth();
                this.f6130j = this.f6121a.getHeight();
                return;
            }
            if (this.f6129i) {
                Bitmap bitmap = this.f6124d;
                if (bitmap != null) {
                    this.f6131k = bitmap.getWidth();
                    this.f6130j = this.f6124d.getHeight();
                    return;
                }
                return;
            }
            Bitmap bitmap2 = this.f6123c;
            if (bitmap2 != null) {
                this.f6131k = bitmap2.getWidth();
                this.f6130j = this.f6123c.getHeight();
            }
        }
    }

    public final boolean q() {
        return this.f6129i;
    }

    public el(Context context) {
        super(context);
        InputStream inputStream;
        InputStream open;
        this.f6128h = new Paint();
        this.f6129i = false;
        this.f6130j = 0;
        this.f6131k = 0;
        this.f6132l = 0;
        this.f6133m = 10;
        this.f6134n = 0;
        this.f6135o = 0;
        this.f6136p = 10;
        this.f6137q = 8;
        this.f6138r = false;
        this.f6139s = false;
        this.f6141u = true;
        this.f6142v = 0.0f;
        this.f6143w = 0.0f;
        this.f6144x = true;
        this.f6145y = false;
        InputStream inputStream2 = null;
        try {
            this.f6140t = StubApp.getOrigApplicationContext(context.getApplicationContext());
            open = v2.b(context).open("ap.data");
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            this.f6126f = decodeStream;
            this.f6121a = b3.m(decodeStream, ga.f6364a);
            open.close();
            inputStream2 = v2.b(context).open("ap1.data");
            Bitmap decodeStream2 = BitmapFactory.decodeStream(inputStream2);
            this.f6127g = decodeStream2;
            this.f6122b = b3.m(decodeStream2, ga.f6364a);
            inputStream2.close();
            this.f6131k = this.f6122b.getWidth();
            this.f6130j = this.f6122b.getHeight();
            this.f6128h.setAntiAlias(true);
            this.f6128h.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.f6128h.setStyle(Paint.Style.STROKE);
            AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = context.getFilesDir() + "/icon_web_day.data";
            AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = context.getFilesDir() + "/icon_web_night.data";
            z2.a().b(new a());
            try {
                open.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                inputStream2.close();
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = inputStream2;
            inputStream2 = open;
            try {
                v5.p(th, "WaterMarkerView", "create");
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
            } finally {
            }
        }
    }

    public final void l() {
        if (getWidth() != 0 && getHeight() != 0) {
            s();
            postInvalidate();
        }
    }
}
