package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import java.util.HashSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class c {
    private static final HashSet<String> ae;
    private static final HashSet<String> tl;

    /* renamed from: j, reason: collision with root package name */
    private static final boolean f28001j = com.bytedance.sdk.openadsdk.core.rn.ch.av();
    private static final boolean xt = j();
    private static int cw = -1;

    /* renamed from: r, reason: collision with root package name */
    private static int f28003r = -1;
    private static int up = -1;

    /* renamed from: m, reason: collision with root package name */
    private static Handler f28002m = null;

    public static void j(final Context context, final com.bytedance.sdk.component.jy.cw cwVar) {
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.xt(context, cwVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(com.bytedance.sdk.component.jy.cw cwVar) {
        if (cwVar == null) {
            return;
        }
        cwVar.setWebChromeClient(null);
        cwVar.setWebViewClient(null);
        View view = cwVar.getView();
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
        cwVar.removeAllViews();
        try {
            cwVar.destroy();
        } catch (Throwable unused) {
        }
    }

    private static boolean j() {
        return f28001j;
    }

    public static void xt(Context context, com.bytedance.sdk.component.jy.cw cwVar) {
        if (context == null || cwVar == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            try {
                cwVar.loadUrl("about:blank");
                if (up > 0) {
                    View rootView = cwVar.getView().getRootView();
                    if (rootView instanceof ViewGroup) {
                        View childAt = ((ViewGroup) rootView).getChildAt(0);
                        childAt.setDrawingCacheEnabled(true);
                        Bitmap createBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                        childAt.setDrawingCacheEnabled(false);
                        ImageView imageView = new ImageView(activity);
                        imageView.setImageBitmap(createBitmap);
                        imageView.setVisibility(0);
                        ((ViewGroup) rootView).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        ae = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        tl = hashSet2;
    }

    public static void j(final com.bytedance.sdk.component.jy.cw cwVar) {
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.cw(com.bytedance.sdk.component.jy.cw.this);
            }
        });
    }
}
