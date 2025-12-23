package com.kwad.sdk.c.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.kwad.sdk.utils.z;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static int avc;
    private static long avd;

    public static int J(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public static int a(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f6) {
        return a(2, f6, context);
    }

    public static boolean d(Activity activity) {
        return b(activity.getWindow());
    }

    private static View e(@NonNull Activity activity) {
        return c(activity.getWindow());
    }

    public static int f(@NonNull Activity activity) {
        return e(activity).getWidth();
    }

    @Deprecated
    public static int getScreenHeight(@Nullable Context context) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i6;
        int i7;
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            }
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            windowInsets = currentWindowMetrics.getWindowInsets();
            systemBars = WindowInsets.Type.systemBars();
            insets = windowInsets.getInsets(systemBars);
            int height = bounds.height();
            i6 = insets.top;
            i7 = insets.bottom;
            return (height - i6) - i7;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Deprecated
    public static int getScreenWidth(@Nullable Context context) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i6;
        int i7;
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.widthPixels;
            }
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            windowInsets = currentWindowMetrics.getWindowInsets();
            systemBars = WindowInsets.Type.systemBars();
            insets = windowInsets.getInsets(systemBars);
            int width = bounds.width();
            i6 = insets.left;
            i7 = insets.right;
            return (width - i6) - i7;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void H(View view) {
        if (view == null || ((View) view.getParent()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
    }

    @Nullable
    public static int[] I(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        iArr[0] = iArr[0] + (width / 2);
        iArr[1] = iArr[1] + (height / 2);
        return iArr;
    }

    private static int a(int i6, float f6, Context context) {
        float applyDimension = TypedValue.applyDimension(2, f6, context.getResources().getDisplayMetrics());
        int i7 = (int) (applyDimension >= 0.0f ? applyDimension + 0.5f : applyDimension - 0.5f);
        if (i7 != 0) {
            return i7;
        }
        if (f6 == 0.0f) {
            return 0;
        }
        return f6 > 0.0f ? 1 : -1;
    }

    private static boolean b(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    @Deprecated
    public static int bi(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static void d(View view, int i6, int i7) {
        View view2;
        if (view == null || i6 == 0 || i7 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i6 > i7) {
                layoutParams.width = -1;
                layoutParams.height = -1;
            } else {
                layoutParams.width = (int) ((i6 / (i7 * 1.0f)) * height);
                layoutParams.height = height;
            }
        } else if (i7 > i6) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i7 / (i6 * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void e(View view, int i6, int i7) {
        View view2;
        if (view == null || i6 == 0 || i7 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i6 > i7) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i7 / (i6 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i6 / (i7 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void f(View view, int i6, int i7) {
        View view2;
        if (view == null || i6 == 0 || i7 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width <= height || i6 > i7) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i7 / (i6 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i6 / (i7 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static int getStatusBarHeight(@Nullable Context context) {
        int i6 = avc;
        if (i6 > 0 || context == null) {
            return i6;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS);
        if (identifier > 0) {
            avc = context.getResources().getDimensionPixelSize(identifier);
        } else {
            try {
                avc = context.getResources().getDimensionPixelSize(((Integer) z.getField("com.android.internal.R$dimen", "status_bar_height")).intValue());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (avc <= 0) {
            avc = a(context, 25.0f);
        }
        return avc;
    }

    public static void m(View view, int i6) {
        if (view == null || i6 == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i6;
        view.setLayoutParams(layoutParams);
    }

    public static void n(View view, int i6) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i6;
        }
    }

    public static boolean DE() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (Math.abs(uptimeMillis - avd) < 500) {
            avd = uptimeMillis;
            return true;
        }
        avd = uptimeMillis;
        return false;
    }

    public static boolean G(View view) {
        if ((view.getSystemUiVisibility() & 1024) == 1024) {
            return true;
        }
        return false;
    }

    public static void b(View view, int i6, int i7, int i8, int i9) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i6, i7, i8, 0);
            view.requestLayout();
        }
    }

    public static int bh(@Nullable Context context) {
        return px2dip(context, getStatusBarHeight(context));
    }

    public static float bj(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static View c(@NonNull Window window) {
        return window.getDecorView().findViewById(R.id.content);
    }

    public static int g(@NonNull Activity activity) {
        return e(activity).getHeight();
    }

    @ColorInt
    public static int getColor(Context context, @ColorRes int i6) {
        return context.getResources().getColor(i6);
    }

    public static int h(Context context, int i6) {
        return context.getResources().getDimensionPixelSize(i6);
    }

    public static int px2dip(Context context, float f6) {
        return (int) ((f6 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(View.OnClickListener onClickListener, View... viewArr) {
        for (View view : viewArr) {
            view.setOnClickListener(onClickListener);
        }
    }

    public static View a(ViewGroup viewGroup, int i6, boolean z5) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i6, viewGroup, true);
    }

    public static void a(View view, float f6, float f7) {
        View view2;
        if (view == null || f6 == 0.0f || f7 == 0.0f || (view2 = (View) view.getParent()) == null) {
            return;
        }
        float width = view2.getWidth();
        float height = view2.getHeight();
        if (width == 0.0f || height == 0.0f) {
            return;
        }
        float f8 = height / width;
        float f9 = f7 / f6;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (f9 > f8) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) (width * f9);
        } else {
            layoutParams.height = (int) height;
            layoutParams.width = (int) (height / f9);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void a(TextView textView, String str, Bitmap bitmap) {
        String str2 = str + " ";
        TextPaint paint = textView.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getContext().getResources(), bitmap);
        int intrinsicWidth = (bitmapDrawable.getIntrinsicWidth() * ceil) / bitmapDrawable.getIntrinsicHeight();
        bitmapDrawable.setBounds(0, a(textView.getContext(), 1.0f), intrinsicWidth, ceil);
        float width = textView.getWidth();
        if (paint.measureText(str2) > width) {
            int i6 = 0;
            int i7 = 1;
            int i8 = 1;
            boolean z5 = false;
            while (true) {
                float measureText = paint.measureText(str2.substring(i6, i7));
                if (measureText < width) {
                    if (i8 == textView.getMaxLines()) {
                        float f6 = measureText + intrinsicWidth;
                        if (paint.measureText(" ") + f6 < width && f6 + paint.measureText("...") + paint.measureText(" ") < width) {
                            if (z5) {
                                str2 = str2.substring(0, i7) + "... ";
                                break;
                            }
                        } else {
                            i7--;
                            z5 = true;
                        }
                    }
                    i7++;
                } else {
                    i6 = i7 - 1;
                    i8++;
                }
                if (i7 > str2.length() || i8 > textView.getMaxLines()) {
                    break;
                }
            }
        }
        String str3 = str2 + "*";
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(new com.kwad.sdk.core.view.a(textView.getContext(), bitmap), str3.length() - 1, str3.length(), 33);
        textView.setText(spannableString);
    }
}
