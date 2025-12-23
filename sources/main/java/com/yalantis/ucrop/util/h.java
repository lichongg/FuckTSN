package com.yalantis.ucrop.util;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h {

    /* renamed from: j, reason: collision with root package name */
    private static final int f42807j = -1;

    /* renamed from: a, reason: collision with root package name */
    private float f42808a;

    /* renamed from: b, reason: collision with root package name */
    private float f42809b;

    /* renamed from: c, reason: collision with root package name */
    private float f42810c;

    /* renamed from: d, reason: collision with root package name */
    private float f42811d;

    /* renamed from: e, reason: collision with root package name */
    private int f42812e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f42813f = -1;

    /* renamed from: g, reason: collision with root package name */
    private float f42814g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f42815h;

    /* renamed from: i, reason: collision with root package name */
    private a f42816i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        boolean a(h hVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements a {
        @Override // com.yalantis.ucrop.util.h.a
        public boolean a(h hVar) {
            return false;
        }
    }

    private float a(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        return b((float) Math.toDegrees((float) Math.atan2(f7 - f9, f6 - f8)), (float) Math.toDegrees((float) Math.atan2(f11 - f13, f10 - f12)));
    }

    private float b(float f6, float f7) {
        float f8 = (f7 % 360.0f) - (f6 % 360.0f);
        this.f42814g = f8;
        if (f8 < -180.0f) {
            this.f42814g = f8 + 360.0f;
        } else if (f8 > 180.0f) {
            this.f42814g = f8 - 360.0f;
        }
        return this.f42814g;
    }

    public float c() {
        return this.f42814g;
    }

    public h(a aVar) {
        this.f42816i = aVar;
    }

    public boolean d(@NonNull MotionEvent motionEvent) {
        h hVar;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 5) {
                        if (actionMasked == 6) {
                            this.f42813f = -1;
                        }
                    } else {
                        this.f42808a = motionEvent.getX();
                        this.f42809b = motionEvent.getY();
                        this.f42813f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                        this.f42814g = 0.0f;
                        this.f42815h = true;
                    }
                } else if (this.f42812e != -1 && this.f42813f != -1 && motionEvent.getPointerCount() > this.f42813f) {
                    float x5 = motionEvent.getX(this.f42812e);
                    float y5 = motionEvent.getY(this.f42812e);
                    float x6 = motionEvent.getX(this.f42813f);
                    float y6 = motionEvent.getY(this.f42813f);
                    if (this.f42815h) {
                        this.f42814g = 0.0f;
                        this.f42815h = false;
                        hVar = this;
                    } else {
                        a(this.f42808a, this.f42809b, this.f42810c, this.f42811d, x6, y6, x5, y5);
                        hVar = this;
                    }
                    a aVar = hVar.f42816i;
                    if (aVar != null) {
                        aVar.a(this);
                    }
                    hVar.f42808a = x6;
                    hVar.f42809b = y6;
                    hVar.f42810c = x5;
                    hVar.f42811d = y5;
                }
            } else {
                this.f42812e = -1;
            }
        } else {
            this.f42810c = motionEvent.getX();
            this.f42811d = motionEvent.getY();
            this.f42812e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
            this.f42814g = 0.0f;
            this.f42815h = true;
        }
        return true;
    }
}
