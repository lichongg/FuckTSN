package com.acse.ottn;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static Application f4983a;

    public static void a(Application application) {
        f4983a = application;
    }

    public static Application b() {
        return f4983a;
    }

    public static void a() {
        h4.c().b();
    }

    public static void b(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
        }
    }

    public static void c(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public static void d(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).toggleSoftInput(1, 2);
    }

    public static boolean a(Context context) {
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.processName.equals(context.getPackageName())) {
                if (next.importance == 400) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(Activity activity) {
        activity.getWindow().setSoftInputMode(3);
    }

    public static void a(View view, Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(view, 1);
    }
}
