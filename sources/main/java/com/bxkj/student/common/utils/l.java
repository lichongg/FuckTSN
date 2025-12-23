package com.bxkj.student.common.utils;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.idl.face.platform.FaceEnvironment;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class l {
    public static int a(Resources res, String key) {
        int identifier = res.getIdentifier(key, "dimen", FaceEnvironment.OS);
        if (identifier > 0) {
            return res.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @TargetApi(19)
    public static void b(Activity activity, int color) {
        activity.getWindow().addFlags(67108864);
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ((ViewGroup) viewGroup.findViewById(R.id.content)).getChildAt(0).setFitsSystemWindows(true);
        View view = new View(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a(activity.getResources(), "status_bar_height"));
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(color);
        viewGroup.addView(view);
    }

    @TargetApi(19)
    public static void c(Activity activity, int res) {
        activity.getWindow().addFlags(67108864);
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ((ViewGroup) viewGroup.findViewById(R.id.content)).getChildAt(0).setFitsSystemWindows(true);
        View view = new View(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a(activity.getResources(), "status_bar_height"));
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(res);
        viewGroup.addView(view);
    }

    public static void d(Activity activity) {
        activity.getWindow().addFlags(67108864);
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) activity.findViewById(R.id.content)).getChildAt(0);
        viewGroup.setFitsSystemWindows(true);
        viewGroup.setClipToPadding(true);
    }
}
