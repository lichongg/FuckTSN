package com.bytedance.pangle.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.bytedance.pangle.plugin.Plugin;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public interface IPluginActivity {
    void _requestPermissions(String[] strArr, int i6);

    void attachBaseContext(Context context);

    String getPluginPkgName();

    void onCreate(Bundle bundle);

    void setPluginProxyActivity(xt xtVar, Plugin plugin);

    void setProxyTheme2Plugin(int i6);
}
