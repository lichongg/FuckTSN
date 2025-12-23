package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.col.p0003l.eh;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class k3 extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f6664a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f6665b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f6666c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f6667d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f6668e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f6669f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f6670g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f6671h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f6672i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f6673j;

    /* renamed from: k, reason: collision with root package name */
    private Bitmap f6674k;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap f6675l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f6676m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f6677n;

    /* renamed from: o, reason: collision with root package name */
    private IAMapDelegate f6678o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (k3.this.f6678o.getZoomLevel() < k3.this.f6678o.getMaxZoomLevel() && k3.this.f6678o.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    k3.this.f6676m.setImageBitmap(k3.this.f6668e);
                } else if (motionEvent.getAction() == 1) {
                    k3.this.f6676m.setImageBitmap(k3.this.f6664a);
                    try {
                        k3.this.f6678o.animateCamera(p.a());
                    } catch (RemoteException e6) {
                        v5.p(e6, "ZoomControllerView", "zoomin ontouch");
                        e6.printStackTrace();
                    }
                }
                return false;
            }
            return false;
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th) {
                v5.p(th, "ZoomControllerView", "zoomout ontouch");
                th.printStackTrace();
            }
            if (k3.this.f6678o.getZoomLevel() > k3.this.f6678o.getMinZoomLevel() && k3.this.f6678o.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    k3.this.f6677n.setImageBitmap(k3.this.f6669f);
                } else if (motionEvent.getAction() == 1) {
                    k3.this.f6677n.setImageBitmap(k3.this.f6666c);
                    k3.this.f6678o.animateCamera(p.l());
                }
                return false;
            }
            return false;
        }

        b() {
        }
    }

    public final void c(float f6) {
        try {
            if (f6 < this.f6678o.getMaxZoomLevel() && f6 > this.f6678o.getMinZoomLevel()) {
                this.f6676m.setImageBitmap(this.f6664a);
                this.f6677n.setImageBitmap(this.f6666c);
            } else if (f6 == this.f6678o.getMinZoomLevel()) {
                this.f6677n.setImageBitmap(this.f6667d);
                this.f6676m.setImageBitmap(this.f6664a);
            } else if (f6 == this.f6678o.getMaxZoomLevel()) {
                this.f6676m.setImageBitmap(this.f6665b);
                this.f6677n.setImageBitmap(this.f6666c);
            }
        } catch (Throwable th) {
            v5.p(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    public final void e(boolean z5) {
        if (z5) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public k3(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f6678o = iAMapDelegate;
        try {
            Bitmap l6 = b3.l(context, "zoomin_selected.png");
            this.f6670g = l6;
            this.f6664a = b3.m(l6, ga.f6364a);
            Bitmap l7 = b3.l(context, "zoomin_unselected.png");
            this.f6671h = l7;
            this.f6665b = b3.m(l7, ga.f6364a);
            Bitmap l8 = b3.l(context, "zoomout_selected.png");
            this.f6672i = l8;
            this.f6666c = b3.m(l8, ga.f6364a);
            Bitmap l9 = b3.l(context, "zoomout_unselected.png");
            this.f6673j = l9;
            this.f6667d = b3.m(l9, ga.f6364a);
            Bitmap l10 = b3.l(context, "zoomin_pressed.png");
            this.f6674k = l10;
            this.f6668e = b3.m(l10, ga.f6364a);
            Bitmap l11 = b3.l(context, "zoomout_pressed.png");
            this.f6675l = l11;
            this.f6669f = b3.m(l11, ga.f6364a);
            ImageView imageView = new ImageView(context);
            this.f6676m = imageView;
            imageView.setImageBitmap(this.f6664a);
            this.f6676m.setClickable(true);
            ImageView imageView2 = new ImageView(context);
            this.f6677n = imageView2;
            imageView2.setImageBitmap(this.f6666c);
            this.f6677n.setClickable(true);
            this.f6676m.setOnTouchListener(new a());
            this.f6677n.setOnTouchListener(new b());
            this.f6676m.setPadding(0, 0, 20, -2);
            this.f6677n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.f6676m);
            addView(this.f6677n);
        } catch (Throwable th) {
            v5.p(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    public final void b() {
        try {
            removeAllViews();
            b3.B(this.f6664a);
            b3.B(this.f6665b);
            b3.B(this.f6666c);
            b3.B(this.f6667d);
            b3.B(this.f6668e);
            b3.B(this.f6669f);
            this.f6664a = null;
            this.f6665b = null;
            this.f6666c = null;
            this.f6667d = null;
            this.f6668e = null;
            this.f6669f = null;
            Bitmap bitmap = this.f6670g;
            if (bitmap != null) {
                b3.B(bitmap);
                this.f6670g = null;
            }
            Bitmap bitmap2 = this.f6671h;
            if (bitmap2 != null) {
                b3.B(bitmap2);
                this.f6671h = null;
            }
            Bitmap bitmap3 = this.f6672i;
            if (bitmap3 != null) {
                b3.B(bitmap3);
                this.f6672i = null;
            }
            Bitmap bitmap4 = this.f6673j;
            if (bitmap4 != null) {
                b3.B(bitmap4);
                this.f6670g = null;
            }
            Bitmap bitmap5 = this.f6674k;
            if (bitmap5 != null) {
                b3.B(bitmap5);
                this.f6674k = null;
            }
            Bitmap bitmap6 = this.f6675l;
            if (bitmap6 != null) {
                b3.B(bitmap6);
                this.f6675l = null;
            }
            this.f6676m = null;
            this.f6677n = null;
        } catch (Throwable th) {
            v5.p(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public final void d(int i6) {
        try {
            eh.c cVar = (eh.c) getLayoutParams();
            if (i6 == 1) {
                cVar.f6111e = 16;
            } else if (i6 == 2) {
                cVar.f6111e = 80;
            }
            setLayoutParams(cVar);
        } catch (Throwable th) {
            v5.p(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }
}
