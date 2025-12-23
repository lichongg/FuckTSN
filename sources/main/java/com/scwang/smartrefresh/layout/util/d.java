package com.scwang.smartrefresh.layout.util;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {
    public static boolean c(View view) {
        return view.canScrollVertically(1);
    }

    public static boolean e(View view) {
        return view.canScrollVertically(-1);
    }

    public static boolean g(View view, float f6, float f7, float f8) {
        float f9 = -f8;
        return f6 >= f9 && f7 >= f9 && f6 < ((float) view.getWidth()) + f8 && f7 < ((float) view.getHeight()) + f8;
    }

    public static void h(ViewGroup viewGroup, View view, float[] fArr) {
        fArr[0] = fArr[0] + (viewGroup.getScrollX() - view.getLeft());
        fArr[1] = fArr[1] + (viewGroup.getScrollY() - view.getTop());
    }

    public static boolean a(View view, MotionEvent motionEvent) {
        if (!c(view) && e(view) && view.getVisibility() == 0) {
            return true;
        }
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF = new PointF();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = viewGroup.getChildAt(i6);
                if (f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return a(childAt, obtain);
                }
            }
        }
        return false;
    }

    public static boolean b(View view, MotionEvent motionEvent) {
        if (e(view) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return b(childAt, obtain);
                }
            }
            return true;
        }
        return true;
    }

    public static boolean d(View view, MotionEvent motionEvent) {
        if (c(view) && view.getVisibility() == 0) {
            return true;
        }
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF = new PointF();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = viewGroup.getChildAt(i6);
                if (f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return d(childAt, obtain);
                }
            }
        }
        return false;
    }

    public static boolean f(ViewGroup viewGroup, View view, float f6, float f7, PointF pointF) {
        if (view.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f6, f7};
        h(viewGroup, view, fArr);
        boolean g6 = g(view, fArr[0], fArr[1], 0.0f);
        if (g6 && pointF != null) {
            pointF.set(fArr[0] - f6, fArr[1] - f7);
        }
        return g6;
    }
}
