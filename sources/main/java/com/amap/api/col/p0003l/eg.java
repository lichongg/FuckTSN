package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class eg extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    Bitmap f6071a;

    /* renamed from: b, reason: collision with root package name */
    Bitmap f6072b;

    /* renamed from: c, reason: collision with root package name */
    Bitmap f6073c;

    /* renamed from: d, reason: collision with root package name */
    Bitmap f6074d;

    /* renamed from: e, reason: collision with root package name */
    Bitmap f6075e;

    /* renamed from: f, reason: collision with root package name */
    Bitmap f6076f;

    /* renamed from: g, reason: collision with root package name */
    ImageView f6077g;

    /* renamed from: h, reason: collision with root package name */
    IAMapDelegate f6078h;

    /* renamed from: i, reason: collision with root package name */
    boolean f6079i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (!eg.this.f6079i) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                eg egVar = eg.this;
                egVar.f6077g.setImageBitmap(egVar.f6072b);
            } else if (motionEvent.getAction() == 1) {
                try {
                    eg egVar2 = eg.this;
                    egVar2.f6077g.setImageBitmap(egVar2.f6071a);
                    eg.this.f6078h.setMyLocationEnabled(true);
                    Location myLocation = eg.this.f6078h.getMyLocation();
                    if (myLocation == null) {
                        return false;
                    }
                    LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                    eg.this.f6078h.showMyLocationOverlay(myLocation);
                    IAMapDelegate iAMapDelegate = eg.this.f6078h;
                    iAMapDelegate.moveCamera(p.h(latLng, iAMapDelegate.getZoomLevel()));
                } catch (Throwable th) {
                    v5.p(th, "LocationView", "onTouch");
                    th.printStackTrace();
                }
            }
            return false;
        }
    }

    public final void b(boolean z5) {
        this.f6079i = z5;
        try {
            if (z5) {
                this.f6077g.setImageBitmap(this.f6071a);
            } else {
                this.f6077g.setImageBitmap(this.f6073c);
            }
            this.f6077g.invalidate();
        } catch (Throwable th) {
            v5.p(th, "LocationView", "showSelect");
            th.printStackTrace();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public eg(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f6079i = false;
        this.f6078h = iAMapDelegate;
        try {
            Bitmap l6 = b3.l(context, "location_selected.png");
            this.f6074d = l6;
            this.f6071a = b3.m(l6, ga.f6364a);
            Bitmap l7 = b3.l(context, "location_pressed.png");
            this.f6075e = l7;
            this.f6072b = b3.m(l7, ga.f6364a);
            Bitmap l8 = b3.l(context, "location_unselected.png");
            this.f6076f = l8;
            this.f6073c = b3.m(l8, ga.f6364a);
            ImageView imageView = new ImageView(context);
            this.f6077g = imageView;
            imageView.setImageBitmap(this.f6071a);
            this.f6077g.setClickable(true);
            this.f6077g.setPadding(0, 20, 20, 0);
            this.f6077g.setOnTouchListener(new a());
            addView(this.f6077g);
        } catch (Throwable th) {
            v5.p(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f6071a;
            if (bitmap != null) {
                b3.B(bitmap);
            }
            Bitmap bitmap2 = this.f6072b;
            if (bitmap2 != null) {
                b3.B(bitmap2);
            }
            if (this.f6072b != null) {
                b3.B(this.f6073c);
            }
            this.f6071a = null;
            this.f6072b = null;
            this.f6073c = null;
            Bitmap bitmap3 = this.f6074d;
            if (bitmap3 != null) {
                b3.B(bitmap3);
                this.f6074d = null;
            }
            Bitmap bitmap4 = this.f6075e;
            if (bitmap4 != null) {
                b3.B(bitmap4);
                this.f6075e = null;
            }
            Bitmap bitmap5 = this.f6076f;
            if (bitmap5 != null) {
                b3.B(bitmap5);
                this.f6076f = null;
            }
        } catch (Throwable th) {
            v5.p(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }
}
