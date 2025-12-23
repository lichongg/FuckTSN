package com.bytedance.sdk.openadsdk;

import android.content.res.Resources;
import android.os.Bundle;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface TTPluginListener {
    Bundle config();

    void onPluginListener(int i6, ClassLoader classLoader, Resources resources, Bundle bundle);

    String packageName();
}
