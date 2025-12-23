package com.beizi.ad.internal.h;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.beizi.ad.internal.f.c;
import com.beizi.fusion.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class u {
    public static ImageView a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.banner_da_close);
        com.beizi.ad.internal.h a6 = com.beizi.ad.internal.h.a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b(context, 18), b(context, 18), 8388661);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, a6.j()), (int) TypedValue.applyDimension(1, 0.0f, a6.j()), (int) TypedValue.applyDimension(1, 0.0f, a6.j()), (int) TypedValue.applyDimension(1, 5.0f, a6.j()));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public static AppCompatTextView b(Context context) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.button_close_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(R.string.beizi_skip_ad);
        com.beizi.ad.internal.h a6 = com.beizi.ad.internal.h.a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, a6.j()), (int) TypedValue.applyDimension(1, 10.0f, a6.j()), (int) TypedValue.applyDimension(1, 42.0f, a6.j()), (int) TypedValue.applyDimension(1, 10.0f, a6.j()));
        appCompatTextView.setLayoutParams(layoutParams);
        return appCompatTextView;
    }

    public static AppCompatTextView a(Context context, int i6, int i7, int i8, int i9) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.button_close_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(R.string.beizi_skip_ad);
        com.beizi.ad.internal.h a6 = com.beizi.ad.internal.h.a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, i6 + 5, a6.j()), (int) TypedValue.applyDimension(1, i7 + 10, a6.j()), (int) TypedValue.applyDimension(1, i8 + 42, a6.j()), (int) TypedValue.applyDimension(1, i9 + 10, a6.j()));
        appCompatTextView.setLayoutParams(layoutParams);
        return appCompatTextView;
    }

    public static FrameLayout b(Context context, c.a aVar) {
        try {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setVisibility(4);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            if (aVar != null) {
                if (aVar.b() == c.a.f11937a) {
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(85, 42, 17));
                    imageView.setVisibility(0);
                    i.a(context).a(aVar.a()).a(imageView);
                    frameLayout.addView(imageView);
                    return frameLayout;
                }
                if (aVar.b() == c.a.f11938b) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                    appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
                    appCompatTextView.setTextSize(2, 12.0f);
                    appCompatTextView.setGravity(17);
                    appCompatTextView.setText(aVar.a());
                    appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, 42, 17));
                    frameLayout.addView(appCompatTextView);
                }
            }
            return frameLayout;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static FrameLayout a(Context context, c.a aVar) {
        try {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setVisibility(4);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            if (aVar != null) {
                if (aVar.b() == c.a.f11937a) {
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(42, 42, 17));
                    imageView.setVisibility(0);
                    i.a(context).a(aVar.a()).a(imageView);
                    frameLayout.addView(imageView);
                    return frameLayout;
                }
                if (aVar.b() == c.a.f11938b) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                    appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
                    appCompatTextView.setTextSize(2, 12.0f);
                    appCompatTextView.setGravity(17);
                    appCompatTextView.setText(aVar.a());
                    appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, 42, 17));
                    frameLayout.addView(appCompatTextView);
                }
            }
            return frameLayout;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Context b(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent != null) {
            boolean z5 = parent instanceof View;
            ViewParent viewParent = parent;
            if (z5) {
                while (viewParent.getParent() != null && (viewParent.getParent() instanceof View)) {
                    viewParent = viewParent.getParent();
                }
                return ((View) viewParent).getContext();
            }
        }
        if (view.getContext() instanceof MutableContextWrapper) {
            return ((MutableContextWrapper) view.getContext()).getBaseContext();
        }
        return view.getContext();
    }

    public static int[] b(Activity activity) {
        int[] a6 = a(activity);
        a(activity, a6);
        return a6;
    }

    public static int b(Context context, int i6) {
        return (int) ((i6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static AppCompatImageView a(Context context, boolean z5) {
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        appCompatImageView.setImageResource(z5 ? R.drawable.voice_off : R.drawable.voice_on);
        com.beizi.ad.internal.h a6 = com.beizi.ad.internal.h.a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388659);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, a6.j()), (int) TypedValue.applyDimension(1, 15.0f, a6.j()), (int) TypedValue.applyDimension(1, 15.0f, a6.j()), (int) TypedValue.applyDimension(1, 15.0f, a6.j()));
        appCompatImageView.setLayoutParams(layoutParams);
        return appCompatImageView;
    }

    public static int b(Context context, float f6) {
        return (int) ((f6 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static AppCompatTextView a(Context context, int i6, int i7, int i8, int i9, int i10) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.button_count_down_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        com.beizi.ad.internal.h a6 = com.beizi.ad.internal.h.a();
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(Integer.toString(i6));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, a6.j()), -2, 53);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, i7 + 5, a6.j()), (int) TypedValue.applyDimension(1, i8 + 10, a6.j()), (int) TypedValue.applyDimension(1, i9 + 5, a6.j()), (int) TypedValue.applyDimension(1, i10 + 10, a6.j()));
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.h.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        return appCompatTextView;
    }

    public static AppCompatTextView a(Context context, int i6) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.button_count_down_interstitial_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.button_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        com.beizi.ad.internal.h a6 = com.beizi.ad.internal.h.a();
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(Integer.toString(i6));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, a6.j()), -2, 53);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 0.0f, a6.j()), (int) TypedValue.applyDimension(1, 0.0f, a6.j()), (int) TypedValue.applyDimension(1, 0.0f, a6.j()), (int) TypedValue.applyDimension(1, 0.0f, a6.j()));
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.h.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        return appCompatTextView;
    }

    public static void a(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public static int[] a(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return new int[]{point.x, point.y};
    }

    public static void a(Activity activity, int[] iArr) {
        float f6 = activity.getResources().getDisplayMetrics().density;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr[i6] = (int) ((iArr[i6] / f6) + 0.5f);
        }
    }

    public static int a(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
