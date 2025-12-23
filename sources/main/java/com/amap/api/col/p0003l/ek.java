package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.tencent.bugly.BuglyStrategy;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ek extends View {

    /* renamed from: a, reason: collision with root package name */
    private String f6112a;

    /* renamed from: b, reason: collision with root package name */
    private int f6113b;

    /* renamed from: c, reason: collision with root package name */
    private IAMapDelegate f6114c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f6115d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f6116e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f6117f;

    /* renamed from: g, reason: collision with root package name */
    private IPoint f6118g;

    /* renamed from: h, reason: collision with root package name */
    private float f6119h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f6120i;

    public final void a() {
        this.f6115d = null;
        this.f6116e = null;
        this.f6117f = null;
        this.f6112a = null;
        this.f6118g = null;
    }

    public final void d(boolean z5) {
        if (z5) {
            setVisibility(0);
            e();
        } else {
            c("");
            b(0);
            setVisibility(8);
        }
    }

    private void b(int i6) {
        this.f6113b = i6;
    }

    private void c(String str) {
        this.f6112a = str;
    }

    public final void e() {
        IAMapDelegate iAMapDelegate = this.f6114c;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float preciseLevel = this.f6114c.getPreciseLevel(engineIDWithType);
            this.f6114c.getGeoCenter(engineIDWithType, this.f6118g);
            if (this.f6118g == null) {
                return;
            }
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) r0).x, ((Point) r0).y, 20);
            float mapZoomScale = this.f6114c.getMapZoomScale();
            double cos = (float) ((((Math.cos((pixelsToLatLong.f9904y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, preciseLevel) * 256.0d));
            int i6 = this.f6120i[(int) preciseLevel];
            int i7 = (int) (i6 / (cos * mapZoomScale));
            String u5 = b3.u(i6);
            b(i7);
            c(u5);
            pixelsToLatLong.recycle();
            invalidate();
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        Point waterMarkerPositon;
        String str = this.f6112a;
        if (str == null || "".equals(str) || this.f6113b == 0 || (waterMarkerPositon = this.f6114c.getWaterMarkerPositon()) == null) {
            return;
        }
        Paint paint = this.f6116e;
        String str2 = this.f6112a;
        paint.getTextBounds(str2, 0, str2.length(), this.f6117f);
        int i6 = waterMarkerPositon.x;
        int height = (waterMarkerPositon.y - this.f6117f.height()) + 5;
        canvas.drawText(this.f6112a, ((this.f6113b - this.f6117f.width()) / 2) + i6, height, this.f6116e);
        float f6 = i6;
        float height2 = height + (this.f6117f.height() - 5);
        canvas.drawLine(f6, height2 - (this.f6119h * 2.0f), f6, height2 + ga.f6364a, this.f6115d);
        canvas.drawLine(f6, height2, this.f6113b + i6, height2, this.f6115d);
        int i7 = this.f6113b;
        canvas.drawLine(i6 + i7, height2 - (this.f6119h * 2.0f), i6 + i7, height2 + ga.f6364a, this.f6115d);
    }

    public ek(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f6112a = "";
        this.f6113b = 0;
        this.f6119h = 0.0f;
        this.f6120i = new int[]{10000000, 5000000, 2000000, 1000000, 500000, 200000, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, KSImageLoader.InnerImageLoadingListener.MAX_DURATION, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
        this.f6114c = iAMapDelegate;
        this.f6115d = new Paint();
        this.f6117f = new Rect();
        this.f6115d.setAntiAlias(true);
        this.f6115d.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f6115d.setStrokeWidth(ga.f6364a * 2.0f);
        this.f6115d.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.f6116e = paint;
        paint.setAntiAlias(true);
        this.f6116e.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f6116e.setTextSize(ga.f6364a * 20.0f);
        this.f6119h = v2.a(context, 1.0f);
        this.f6118g = new IPoint();
    }
}
