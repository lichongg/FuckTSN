package cn.bluemobi.dylan.photoview.library.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(5)
/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends a {

    /* renamed from: k, reason: collision with root package name */
    private static final int f1356k = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f1357i;

    /* renamed from: j, reason: collision with root package name */
    private int f1358j;

    @Override // cn.bluemobi.dylan.photoview.library.gestures.a
    float d(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f1358j);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.a
    float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f1358j);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public b(Context context) {
        super(context);
        this.f1357i = -1;
        this.f1358j = 0;
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.a, cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int i6 = 0;
        if (action != 0) {
            int i7 = 1;
            if (action != 1 && action != 3) {
                if (action == 6) {
                    int a6 = cn.bluemobi.dylan.photoview.library.a.a(motionEvent.getAction());
                    if (motionEvent.getPointerId(a6) == this.f1357i) {
                        if (a6 != 0) {
                            i7 = 0;
                        }
                        this.f1357i = motionEvent.getPointerId(i7);
                        this.f1350b = motionEvent.getX(i7);
                        this.f1351c = motionEvent.getY(i7);
                    }
                }
            } else {
                this.f1357i = -1;
            }
        } else {
            this.f1357i = motionEvent.getPointerId(0);
        }
        int i8 = this.f1357i;
        if (i8 != -1) {
            i6 = i8;
        }
        this.f1358j = motionEvent.findPointerIndex(i6);
        return super.onTouchEvent(motionEvent);
    }
}
