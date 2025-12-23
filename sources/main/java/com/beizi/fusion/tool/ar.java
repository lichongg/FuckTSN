package com.beizi.fusion.tool;

import android.graphics.Rect;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ar {
    public static boolean a(View view) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null || !(com.beizi.fusion.c.b.a().m() || view.hasWindowFocus())) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        int height = (int) (view.getHeight() * view.getWidth() * 0.95d);
        return height > 0 && rect.height() * rect.width() >= height;
    }

    public static boolean b(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
                    Rect rect = new Rect();
                    if (view.getGlobalVisibleRect(rect)) {
                        return rect.height() * rect.width() > 0;
                    }
                    return false;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                return true;
            }
        }
        return false;
    }

    public static boolean a(View view, double d6) {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                return false;
            }
            int height = rect.height() * rect.width();
            int height2 = (int) (view.getHeight() * view.getWidth() * d6);
            if (height2 > 0 && height >= height2) {
                return true;
            }
        }
        return false;
    }
}
