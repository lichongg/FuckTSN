package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.stub.StubApp;
import java.lang.ref.SoftReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class a {

    /* renamed from: j, reason: collision with root package name */
    private static SoftReference<Toast> f26851j;

    private static Toast j(Context context) {
        if (context != null) {
            SoftReference<Toast> softReference = new SoftReference<>(Toast.makeText(StubApp.getOrigApplicationContext(context.getApplicationContext()), "", 0));
            f26851j = softReference;
            return softReference.get();
        }
        SoftReference<Toast> softReference2 = f26851j;
        if (softReference2 != null) {
            return softReference2.get();
        }
        return null;
    }

    public static void xt(Context context, String str, int i6, int i7, int i8, int i9) {
        Toast j6 = j(context);
        if (j6 != null) {
            j6.setDuration(i6);
            j6.setGravity(i7, i8, i9);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(j(context, 10.0f));
            gradientDrawable.setColor(Color.parseColor("#CC161823"));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackground(gradientDrawable);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(j(context, 20.0f), j(context, 12.0f), j(context, 20.0f), j(context, 12.0f));
            TextView textView = new TextView(context);
            textView.setTextColor(-1);
            textView.setText(str);
            textView.setTextSize(2, 14.0f);
            linearLayout.addView(textView);
            j6.setView(linearLayout);
            j6.show();
            return;
        }
        vl.j("TToast", "toast msg: ".concat(String.valueOf(str)));
    }

    public static Toast j(Context context, String str, int i6, int i7, int i8, int i9) {
        Toast toast = new Toast(context);
        toast.setDuration(i6);
        toast.setGravity(i7, i8, i9);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(j(context, 10.0f));
        gradientDrawable.setColor(Color.parseColor("#CC161823"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(j(context, 20.0f), j(context, 12.0f), j(context, 20.0f), j(context, 12.0f));
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        return toast;
    }

    public static void j(Context context, String str, int i6) {
        xt(context, str, i6, 80, 0, j(context, 40.0f));
    }

    private static int j(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
