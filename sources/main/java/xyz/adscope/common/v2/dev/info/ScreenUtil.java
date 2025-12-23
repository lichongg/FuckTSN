package xyz.adscope.common.v2.dev.info;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ScreenUtil {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Calculate {
        public static boolean checkViewVisibilityCoverage(View view, int i6) {
            view.getLocationOnScreen(new int[2]);
            if (view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
                Rect rect = new Rect();
                if (!view.getGlobalVisibleRect(rect)) {
                    return false;
                }
                int height = rect.height() * rect.width();
                int height2 = view.getHeight() * view.getWidth();
                if (height2 > 0 && height * 100 >= i6 * height2) {
                    return true;
                }
            }
            return false;
        }

        private static boolean coverOverPercent(View view, double d6) {
            View view2 = view;
            while (view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup.getVisibility() == 0) {
                    for (int indexOfChild = viewGroup.indexOfChild(view2) + 1; indexOfChild < viewGroup.getChildCount(); indexOfChild++) {
                        View childAt = viewGroup.getChildAt(indexOfChild);
                        if (childAt.getVisibility() == 0) {
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            Rect rect2 = new Rect();
                            childAt.getGlobalVisibleRect(rect2);
                            if (Rect.intersects(rect, rect2) && (((Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left)) * (Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top))) * 1.0d) / ((view.getMeasuredWidth() * view.getMeasuredHeight()) * 1.0d) > d6) {
                                return true;
                            }
                        }
                    }
                    view2 = viewGroup;
                }
            }
            return false;
        }

        public static boolean checkViewVisibilityCoverageStrict(View view, double d6) {
            if (view == null || view.getVisibility() != 0) {
                return false;
            }
            Rect rect = new Rect();
            return view.getGlobalVisibleRect(rect) && rectAreaOverPercent(rect, view.getMeasuredWidth() * view.getMeasuredHeight(), d6) && !coverOverPercent(view, d6);
        }

        public static int dip2px(Context context, float f6) {
            float density = ScreenUtil.getDensity(context);
            if (density > 0.0f) {
                return (int) ((f6 * density) + 0.5f);
            }
            return 0;
        }

        public static int px2dip(Context context, float f6) {
            float density = ScreenUtil.getDensity(context);
            if (density > 0.0f) {
                return (int) ((f6 / density) + 0.5f);
            }
            return 0;
        }

        private static boolean rectAreaOverPercent(Rect rect, int i6, double d6) {
            if (((rect.width() * rect.height()) * 1.0d) / (i6 * 1.0d) > d6) {
                return true;
            }
            return false;
        }
    }

    public static float getDensity(Context context) {
        if (context == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || windowManager.getDefaultDisplay() == null) {
            return 0.0f;
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static int getDensityDpi(Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || windowManager.getDefaultDisplay() == null) {
            return 0;
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    public static int getOrientation(Context context) {
        Configuration configuration;
        if (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public static int getScreenHeightDp(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return Calculate.px2dip(context, displayMetrics.heightPixels);
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public static int getScreenWidthDp(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return Calculate.px2dip(context, displayMetrics.widthPixels);
    }

    private ScreenUtil() {
    }
}
