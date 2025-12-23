package com.bytedance.sdk.openadsdk.core;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes4.dex */
public class uf {
    private static int cw(View view, int i6) {
        if (i6 == 3) {
            return (int) (com.bytedance.sdk.openadsdk.core.rn.ed.r(StubApp.getOrigApplicationContext(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    public static String j(int i6) {
        switch (i6) {
            case 1:
                return "view不可见";
            case 2:
            case 5:
            default:
                return "";
            case 3:
                return "view可见区域比例不够";
            case 4:
                return "屏幕关闭";
            case 6:
                return "view可见宽高不够";
            case 7:
                return "show检测发生崩溃";
            case 8:
                return "设置为了不需要检测";
            case 9:
                return "没有在检测";
            case 10:
                return "没有在检测，已show";
        }
    }

    private static int r(View view, int i6) {
        if (i6 == 3) {
            return com.bytedance.sdk.openadsdk.core.rn.ed.up(StubApp.getOrigApplicationContext(view.getContext().getApplicationContext())) / 2;
        }
        return 20;
    }

    private static boolean xt(View view) {
        return view != null && view.isShown();
    }

    private static boolean xt(View view, int i6) {
        return view.getWidth() >= cw(view, i6) && view.getHeight() >= r(view, i6);
    }

    public static boolean xt(View view, int i6, int i7) {
        return j(view, i6, i7) == 0;
    }

    private static boolean j(View view, int i6) {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null) {
            if (!view.getGlobalVisibleRect(new Rect()) && (!v.xt().rn() || !j(view, new Rect(), (Point) null))) {
                return false;
            }
            long height = r1.height() * r1.width();
            long height2 = view.getHeight() * view.getWidth();
            if (height2 > 0 && height * 100 >= i6 * height2) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(View view, Rect rect, Point point) {
        if (view == null) {
            return false;
        }
        int right = view.getRight() - view.getLeft();
        int bottom = view.getBottom() - view.getTop();
        if (right <= 0 || bottom <= 0) {
            return false;
        }
        rect.set(0, 0, right, bottom);
        if (point != null) {
            point.set(-view.getScrollX(), -view.getScrollY());
        }
        return view.getParent() == null || view.getParent().getChildVisibleRect(view, rect, point);
    }

    public static int j(View view, int i6, int i7) throws Throwable {
        if (!com.bytedance.sdk.openadsdk.core.rn.oq.j()) {
            return 4;
        }
        if (!xt(view)) {
            return 1;
        }
        if (xt(view, i7)) {
            return !j(view, i6) ? 3 : 0;
        }
        return 6;
    }

    public static boolean j(View view) {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            return j(view, 20);
        }
        return false;
    }
}
