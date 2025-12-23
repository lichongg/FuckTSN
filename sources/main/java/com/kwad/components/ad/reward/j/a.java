package com.kwad.components.ad.reward.j;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static int a(Activity activity) {
        TextView e6;
        if (activity != null && !activity.isFinishing()) {
            View findViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
            if ((findViewById instanceof ViewGroup) && (e6 = e((ViewGroup) findViewById)) != null) {
                return b(e6);
            }
        }
        return -1;
    }

    private static TextView e(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt instanceof ViewGroup) {
                TextView e6 = e((ViewGroup) childAt);
                if (e6 != null) {
                    return e6;
                }
            } else if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (a(textView)) {
                    return textView;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    @SuppressLint({"InternalInsetResource"})
    private static int b(TextView textView) {
        if (textView == null) {
            return -1;
        }
        int[] iArr = new int[2];
        textView.getLocationOnScreen(iArr);
        return iArr[1];
    }

    private static boolean a(TextView textView) {
        return textView != null && "topBarCallLabel".equals(textView.getContentDescription());
    }
}
