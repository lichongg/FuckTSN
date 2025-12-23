package xyz.adscope.ad;

import android.view.MotionEvent;
import android.view.View;
import xyz.adscope.ad.i4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class f7 implements i4 {

    /* renamed from: a, reason: collision with root package name */
    private final i4.b f55149a = new i4.b();

    @Override // xyz.adscope.ad.i4
    public void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f55149a.o();
            this.f55149a.b(motionEvent.getX(), motionEvent.getY());
            this.f55149a.a(motionEvent.getRawX(), motionEvent.getRawY());
        } else {
            if (action != 1) {
                return;
            }
            this.f55149a.p();
            this.f55149a.d(motionEvent.getX(), motionEvent.getY());
            this.f55149a.c(motionEvent.getRawX(), motionEvent.getRawY());
        }
    }

    f7() {
    }

    @Override // xyz.adscope.ad.i4
    public void a(View view) {
        this.f55149a.a(view);
    }

    @Override // xyz.adscope.ad.i4
    public void a(View view, View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f55149a.o();
            float[] a6 = a(view, view2, new float[]{motionEvent.getX(), motionEvent.getY(), motionEvent.getRawX(), motionEvent.getRawY()});
            if (a6 == null || a6.length != 4) {
                return;
            }
            this.f55149a.b(a6[0], a6[1]);
            this.f55149a.a(a6[2], a6[3]);
            return;
        }
        if (action != 1) {
            return;
        }
        this.f55149a.p();
        float[] a7 = a(view, view2, new float[]{motionEvent.getX(), motionEvent.getY(), motionEvent.getRawX(), motionEvent.getRawY()});
        if (a7 == null || a7.length != 4) {
            return;
        }
        this.f55149a.b(a7[0], a7[1]);
        this.f55149a.a(a7[2], a7[3]);
    }

    private float[] a(View view, View view2, float[] fArr) {
        if (view == null || view2 == null || fArr == null || fArr.length != 4) {
            return fArr;
        }
        view.getLocationOnScreen(new int[2]);
        int width = view.getWidth();
        float f6 = (int) ((fArr[0] * 100.0d) / width);
        float height = (int) ((fArr[1] * 100.0d) / view.getHeight());
        int width2 = view2.getWidth();
        int height2 = view2.getHeight();
        view2.getLocationOnScreen(new int[2]);
        float f7 = (width2 * f6) / 100.0f;
        float f8 = (height2 * height) / 100.0f;
        return new float[]{f7, f8, r6[0] + f7, r6[1] + f8};
    }

    @Override // xyz.adscope.ad.i4
    public i4.b a() {
        return this.f55149a;
    }
}
