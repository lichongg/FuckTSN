package com.bxkj.base.util;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class m {
    public static void a(TextView textView, String str) {
        Spanned fromHtml;
        if (Build.VERSION.SDK_INT < 24) {
            textView.setText(Html.fromHtml(str));
        } else {
            fromHtml = Html.fromHtml(str, 0);
            textView.setText(fromHtml);
        }
    }
}
