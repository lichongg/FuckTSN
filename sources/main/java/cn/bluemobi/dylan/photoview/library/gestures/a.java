package cn.bluemobi.dylan.photoview.library.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements d {

    /* renamed from: h, reason: collision with root package name */
    private static final String f1348h = "CupcakeGestureDetector";

    /* renamed from: a, reason: collision with root package name */
    protected e f1349a;

    /* renamed from: b, reason: collision with root package name */
    float f1350b;

    /* renamed from: c, reason: collision with root package name */
    float f1351c;

    /* renamed from: d, reason: collision with root package name */
    final float f1352d;

    /* renamed from: e, reason: collision with root package name */
    final float f1353e;

    /* renamed from: f, reason: collision with root package name */
    private VelocityTracker f1354f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1355g;

    @Override // cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean c() {
        return false;
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.d
    public void a(e eVar) {
        this.f1349a = eVar;
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean b() {
        return this.f1355g;
    }

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1353e = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1352d = viewConfiguration.getScaledTouchSlop();
    }

    float d(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    float e(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        boolean z5 = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3 && (velocityTracker = this.f1354f) != null) {
                        velocityTracker.recycle();
                        this.f1354f = null;
                    }
                } else {
                    float d6 = d(motionEvent);
                    float e6 = e(motionEvent);
                    float f6 = d6 - this.f1350b;
                    float f7 = e6 - this.f1351c;
                    if (!this.f1355g) {
                        if (Math.sqrt((f6 * f6) + (f7 * f7)) >= this.f1352d) {
                            z5 = true;
                        }
                        this.f1355g = z5;
                    }
                    if (this.f1355g) {
                        this.f1349a.e(f6, f7);
                        this.f1350b = d6;
                        this.f1351c = e6;
                        VelocityTracker velocityTracker2 = this.f1354f;
                        if (velocityTracker2 != null) {
                            velocityTracker2.addMovement(motionEvent);
                        }
                    }
                }
            } else {
                if (this.f1355g && this.f1354f != null) {
                    this.f1350b = d(motionEvent);
                    this.f1351c = e(motionEvent);
                    this.f1354f.addMovement(motionEvent);
                    this.f1354f.computeCurrentVelocity(1000);
                    float xVelocity = this.f1354f.getXVelocity();
                    float yVelocity = this.f1354f.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f1353e) {
                        this.f1349a.c(this.f1350b, this.f1351c, -xVelocity, -yVelocity);
                    }
                }
                VelocityTracker velocityTracker3 = this.f1354f;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f1354f = null;
                }
            }
        } else {
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f1354f = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            } else {
                i.a.a().i(f1348h, "Velocity tracker is null");
            }
            this.f1350b = d(motionEvent);
            this.f1351c = e(motionEvent);
            this.f1355g = false;
        }
        return true;
    }
}
