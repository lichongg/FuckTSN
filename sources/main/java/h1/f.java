package h1;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.FragmentActivity;
import com.baidu.idl.face.platform.FaceEnvironment;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class f {
    public static AppCompatActivity b(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return b(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    public static Activity l(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return l(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static int d(Context context, boolean z5) {
        return z5 ? context.getResources().getDisplayMetrics().heightPixels + c(context) : context.getResources().getDisplayMetrics().heightPixels;
    }

    public static WindowManager g(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public static void k(Context context, boolean z5, boolean z6) {
        AppCompatActivity b6;
        ActionBar supportActionBar;
        if (z5 && (b6 = b(context)) != null && (supportActionBar = b6.getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.hide();
        }
        if (z6) {
            if (!(context instanceof FragmentActivity)) {
                l(context).getWindow().addFlags(1024);
                l(context).getWindow().addFlags(512);
            } else {
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                fragmentActivity.getWindow().addFlags(1024);
                fragmentActivity.getWindow().addFlags(512);
            }
        }
    }

    public static void o(Context context, boolean z5, boolean z6) {
        AppCompatActivity b6;
        ActionBar supportActionBar;
        if (z5 && (b6 = b(context)) != null && (supportActionBar = b6.getSupportActionBar()) != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.show();
        }
        if (z6) {
            if (!(context instanceof FragmentActivity)) {
                l(context).getWindow().clearFlags(1024);
                l(context).getWindow().clearFlags(512);
            } else {
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                fragmentActivity.getWindow().clearFlags(1024);
                fragmentActivity.getWindow().clearFlags(512);
            }
        }
    }

    public static int a(Context context, float f6) {
        return (int) TypedValue.applyDimension(1, f6, context.getResources().getDisplayMetrics());
    }

    public static int c(Context context) {
        if (!h(context)) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", FaceEnvironment.OS));
    }

    public static int e(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static double f(Context context) {
        return Math.ceil(context.getResources().getDisplayMetrics().density * 25.0f);
    }

    public static boolean h(Context context) {
        Display defaultDisplay = g(context).getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        if (point2.x == point.x && point2.y == point.y) {
            return false;
        }
        return true;
    }

    public static void i(Context context) {
        l(context).getWindow().getDecorView().setSystemUiVisibility(4098);
    }

    public static void j(Context context) {
        l(context).getWindow().addFlags(1024);
    }

    public static void m(Context context) {
        l(context).getWindow().getDecorView().setSystemUiVisibility(0);
    }

    public static void n(Context context) {
        l(context).getWindow().clearFlags(1024);
    }

    public static int p(Context context, float f6) {
        return (int) TypedValue.applyDimension(2, f6, context.getResources().getDisplayMetrics());
    }
}
