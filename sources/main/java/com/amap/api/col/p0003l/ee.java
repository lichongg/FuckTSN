package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ee extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    Bitmap f6036a;

    /* renamed from: b, reason: collision with root package name */
    Bitmap f6037b;

    /* renamed from: c, reason: collision with root package name */
    Bitmap f6038c;

    /* renamed from: d, reason: collision with root package name */
    ImageView f6039d;

    /* renamed from: e, reason: collision with root package name */
    IAMapDelegate f6040e;

    /* renamed from: f, reason: collision with root package name */
    Matrix f6041f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th) {
                v5.p(th, "CompassView", "onTouch");
                th.printStackTrace();
            }
            if (!ee.this.f6040e.isMaploaded()) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                ee eeVar = ee.this;
                eeVar.f6039d.setImageBitmap(eeVar.f6037b);
            } else if (motionEvent.getAction() == 1) {
                ee eeVar2 = ee.this;
                eeVar2.f6039d.setImageBitmap(eeVar2.f6036a);
                CameraPosition cameraPosition = ee.this.f6040e.getCameraPosition();
                ee.this.f6040e.animateCamera(p.f(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
            }
            return false;
        }

        a() {
        }
    }

    public final void b(boolean z5) {
        if (!z5) {
            setVisibility(8);
        } else {
            setVisibility(0);
            c();
        }
    }

    public final void c() {
        try {
            IAMapDelegate iAMapDelegate = this.f6040e;
            if (iAMapDelegate == null || this.f6039d == null) {
                return;
            }
            int engineIDWithType = iAMapDelegate.getGLMapEngine() != null ? this.f6040e.getGLMapEngine().getEngineIDWithType(1) : 0;
            float cameraDegree = this.f6040e.getCameraDegree(engineIDWithType);
            float mapAngle = this.f6040e.getMapAngle(engineIDWithType);
            if (this.f6041f == null) {
                this.f6041f = new Matrix();
            }
            this.f6041f.reset();
            this.f6041f.postRotate(-mapAngle, this.f6039d.getDrawable().getBounds().width() / 2.0f, this.f6039d.getDrawable().getBounds().height() / 2.0f);
            this.f6041f.postScale(1.0f, (float) Math.cos((cameraDegree * 3.141592653589793d) / 180.0d), this.f6039d.getDrawable().getBounds().width() / 2.0f, this.f6039d.getDrawable().getBounds().height() / 2.0f);
            this.f6039d.setImageMatrix(this.f6041f);
        } catch (Throwable th) {
            v5.p(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }

    public ee(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f6041f = new Matrix();
        this.f6040e = iAMapDelegate;
        try {
            Bitmap l6 = b3.l(context, "maps_dav_compass_needle_large.png");
            this.f6038c = l6;
            this.f6037b = b3.m(l6, ga.f6364a * 0.8f);
            Bitmap m6 = b3.m(this.f6038c, ga.f6364a * 0.7f);
            this.f6038c = m6;
            Bitmap bitmap = this.f6037b;
            if (bitmap != null && m6 != null) {
                this.f6036a = Bitmap.createBitmap(bitmap.getWidth(), this.f6037b.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.f6036a);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(this.f6038c, (this.f6037b.getWidth() - this.f6038c.getWidth()) / 2.0f, (this.f6037b.getHeight() - this.f6038c.getHeight()) / 2.0f, paint);
                ImageView imageView = new ImageView(context);
                this.f6039d = imageView;
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                this.f6039d.setImageBitmap(this.f6036a);
                this.f6039d.setClickable(true);
                c();
                this.f6039d.setOnTouchListener(new a());
                addView(this.f6039d);
            }
        } catch (Throwable th) {
            v5.p(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f6036a;
            if (bitmap != null) {
                b3.B(bitmap);
            }
            Bitmap bitmap2 = this.f6037b;
            if (bitmap2 != null) {
                b3.B(bitmap2);
            }
            Bitmap bitmap3 = this.f6038c;
            if (bitmap3 != null) {
                b3.B(bitmap3);
            }
            Matrix matrix = this.f6041f;
            if (matrix != null) {
                matrix.reset();
                this.f6041f = null;
            }
            this.f6038c = null;
            this.f6036a = null;
            this.f6037b = null;
        } catch (Throwable th) {
            v5.p(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }
}
