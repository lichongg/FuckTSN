package cn.jpush.android.r;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import cn.jpush.android.helper.Logger;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3774a = false;

    /* renamed from: b, reason: collision with root package name */
    private String f3775b = "";

    /* renamed from: c, reason: collision with root package name */
    private WindowManager f3776c;

    public static int a(Context context) {
        int i6 = 48;
        if (context != null) {
            try {
                i6 = context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS));
            } catch (Throwable th) {
                Logger.w("InAppWinManager", "get status bar height error, " + th.getMessage());
            }
        }
        Logger.d("InAppWinManager", "status bar height: " + i6);
        return i6;
    }

    private WindowManager b(Context context) {
        if (context != null) {
            return (WindowManager) context.getSystemService("window");
        }
        Logger.w("InAppWinManager", "getWindowManager context is null");
        return null;
    }

    private WindowManager.LayoutParams a(Context context, cn.jpush.android.t.a aVar) {
        if (aVar == null || context == null) {
            return null;
        }
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(aVar.c(), aVar.d(), 1003, aVar.a() | 131112, -3);
            layoutParams.x = 0;
            layoutParams.y = a(context);
            layoutParams.dimAmount = 0.3f;
            layoutParams.gravity = aVar.b();
            layoutParams.windowAnimations = 0;
            return layoutParams;
        } catch (Throwable th) {
            Logger.w("InAppWinManager", "[getLayoutParams] error." + th.getMessage());
            return null;
        }
    }

    public void b(Context context, cn.jpush.android.u.b bVar) {
        try {
            if (bVar == null || context == null) {
                Logger.w("InAppWinManager", "destroy param is null, wrapper: " + bVar);
                return;
            }
            View e6 = bVar.e();
            if (e6 != null) {
                if (this.f3776c != null && a(bVar)) {
                    this.f3776c.removeViewImmediate(e6);
                    this.f3774a = false;
                    Logger.d("InAppWinManager", "[destroy] - window manager removeViewImmediate view succeed.");
                }
                bVar.c();
            }
            this.f3775b = "";
        } catch (Throwable th) {
            Logger.w("InAppWinManager", "notify inapp destroy failed, " + th.getMessage());
        }
    }

    public boolean a(Context context, cn.jpush.android.u.b bVar) {
        try {
            this.f3775b = "";
            if (bVar == null) {
                Logger.w("InAppWinManager", "notify inapp show failed, wrapper is null");
                return false;
            }
            cn.jpush.android.t.a k6 = bVar.k();
            View e6 = bVar.e();
            if (e6 == null) {
                Logger.w("InAppWinManager", "notify inapp show failed, wbView is null");
                return false;
            }
            this.f3776c = b(context);
            if (context instanceof Activity) {
                this.f3775b = context.getClass().getCanonicalName();
                context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (this.f3776c == null) {
                Logger.w("InAppWinManager", "notify inapp show failed, wm is null");
                return false;
            }
            WindowManager.LayoutParams a6 = a(context, k6);
            if (a6 == null) {
                Logger.w("InAppWinManager", "notify inapp show failed, layout param is null");
                return false;
            }
            this.f3776c.addView(e6, a6);
            bVar.h();
            this.f3774a = true;
            return true;
        } catch (Throwable th) {
            Logger.w("InAppWinManager", "notify inapp show failed, " + th.getMessage());
            return false;
        }
    }

    public boolean b(cn.jpush.android.u.b bVar) {
        return (bVar == null || bVar.e() == null) ? false : true;
    }

    public boolean a(cn.jpush.android.u.b bVar) {
        if (bVar != null && bVar.e() != null) {
            boolean isShown = bVar.e().isShown();
            Logger.d("InAppWinManager", "webview is displayed, status: " + isShown + ", isDisplayed: " + this.f3774a);
            if (isShown && this.f3774a) {
                return true;
            }
        }
        return false;
    }

    public boolean a(String str) {
        Logger.d("InAppWinManager", "[checkShouldDestroy], showActivityName: " + this.f3775b + ", curActivityName: " + str);
        return TextUtils.equals(str, this.f3775b);
    }
}
