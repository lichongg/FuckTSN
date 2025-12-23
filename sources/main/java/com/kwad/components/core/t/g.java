package com.kwad.components.core.t;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    public static void destroyActivity(Context context, Window window) {
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        destroyWebViewInTree(decorView);
        fixInputMethodManagerLeak(context, decorView);
    }

    private static synchronized void destroyWebViewInTree(View view) {
        synchronized (g.class) {
            if (view == null) {
                return;
            }
            if (view instanceof WebView) {
                try {
                    ((WebView) view).destroy();
                } catch (Throwable unused) {
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    destroyWebViewInTree(viewGroup.getChildAt(i6));
                }
            }
        }
    }

    private static void fixInputMethodManagerLeak(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || Build.VERSION.SDK_INT >= 29 || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i6 = 0; i6 < 3; i6++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i6]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (!(obj instanceof View)) {
                    continue;
                } else if (!context.equals(((View) obj).getContext())) {
                    return;
                } else {
                    declaredField.set(inputMethodManager, null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void destroyFragment(Context context, View view) {
        destroyWebViewInTree(view);
        fixInputMethodManagerLeak(context, view);
    }
}
