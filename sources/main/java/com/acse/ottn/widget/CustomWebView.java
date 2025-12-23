package com.acse.ottn.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CustomWebView extends WebView {
    public CustomWebView(Context context) {
        super(a(context));
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(a(context), attributeSet);
    }

    public static Context a(Context context) {
        return Build.VERSION.SDK_INT < 23 ? context.createConfigurationContext(new Configuration()) : context;
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i6) {
        super(a(context), attributeSet, i6);
    }
}
