package com.acse.ottn;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class u0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f5366a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static int f5367b = -1;

    public static int a(Context context) {
        int i6 = f5367b;
        if (i6 != -1) {
            return i6;
        }
        WindowManager windowManager = (WindowManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i7 = displayMetrics.heightPixels;
        f5367b = i7;
        f5366a = displayMetrics.widthPixels;
        return i7;
    }

    public static int b(Context context) {
        int i6 = f5366a;
        if (i6 != -1) {
            return i6;
        }
        WindowManager windowManager = (WindowManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i7 = displayMetrics.widthPixels;
        f5366a = i7;
        f5367b = displayMetrics.heightPixels;
        return i7;
    }

    public static int c(Context context) {
        int identifier = StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS);
        if (identifier > 0) {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int c(Context context, float f6) {
        return (int) ((f6 / StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int d(Context context, float f6) {
        return (int) ((f6 * StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int a(Context context, int i6) {
        return BitmapFactory.decodeResource(StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources(), i6).getWidth();
    }

    public static int b(Context context, float f6) {
        return (int) ((f6 / StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, float f6) {
        return (int) ((f6 * StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().density) + 0.5f);
    }
}
