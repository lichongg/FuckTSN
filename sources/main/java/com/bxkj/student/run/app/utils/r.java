package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.idl.face.platform.FaceEnvironment;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f20344a;

        /* renamed from: b, reason: collision with root package name */
        public int f20345b;

        public a() {
        }

        public a(int widthPixels, int heightPixels) {
            this.f20344a = widthPixels;
            this.f20345b = heightPixels;
        }
    }

    public static float b(Context context) {
        new DisplayMetrics();
        return context.getResources().getDisplayMetrics().density;
    }

    public static int c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static a d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new a(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static int e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static void h(ListView listView) {
        ListAdapter adapter;
        if (listView == null || (adapter = listView.getAdapter()) == null) {
            return;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < adapter.getCount(); i7++) {
            View view = adapter.getView(i7, null, listView);
            view.measure(0, 0);
            i6 += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = i6 + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(layoutParams);
    }

    public static int a(Context context, float dpValue) {
        return (int) ((dpValue * b(context)) + 0.5f);
    }

    public static int f() {
        return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", FaceEnvironment.OS));
    }

    public static int g(Context context, float pxValue) {
        return (int) ((pxValue / b(context)) + 0.5f);
    }
}
