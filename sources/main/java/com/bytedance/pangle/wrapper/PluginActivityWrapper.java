package com.bytedance.pangle.wrapper;

import android.app.Activity;
import android.app.Application;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.Keep;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.FieldUtils;

@Keep
/* loaded from: D:\Downloads\app\classes4.dex */
public class PluginActivityWrapper extends GenerateActivityWrapper {
    private static final int OBJECT_TAG = Integer.MAX_VALUE;

    public PluginActivityWrapper(Activity activity, PluginContext pluginContext) {
        this.mOriginActivity = activity;
        this.pluginContext = pluginContext;
        try {
            if (!activity.isDestroyed()) {
                int i6 = Build.VERSION.SDK_INT;
                if (i6 >= 29) {
                    this.mOriginActivity.registerActivityLifecycleCallbacks(new com.bytedance.pangle.j() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.1
                    });
                } else if (i6 >= 24) {
                    setTag();
                } else {
                    registerApplicationLifecycleCallbacks();
                }
            }
        } catch (Exception unused) {
            registerApplicationLifecycleCallbacks();
        }
        try {
            FieldUtils.writeField(this, "mBase", pluginContext);
            if (!com.bytedance.pangle.util.g.j()) {
                FieldUtils.writeField(FieldUtils.getField(ContextWrapper.class, "mBase"), this, pluginContext);
            }
        } catch (IllegalAccessException unused2) {
        }
        try {
            FieldUtils.writeField(this, "mApplication", activity.getApplication());
        } catch (IllegalAccessException unused3) {
        }
        com.bytedance.pangle.util.j.j(this, activity);
    }

    private void setTag() {
        View decorView;
        String pluginPackageName;
        Window window = this.mOriginActivity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (pluginPackageName = this.pluginContext.getPluginPackageName()) == null) {
            return;
        }
        decorView.setTag(pluginPackageName.hashCode(), new com.bytedance.pangle.j() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.3
        });
    }

    private void registerApplicationLifecycleCallbacks() {
        final Application appApplication = Zeus.getAppApplication();
        if (appApplication == null) {
            return;
        }
        appApplication.registerActivityLifecycleCallbacks(new com.bytedance.pangle.j() { // from class: com.bytedance.pangle.wrapper.PluginActivityWrapper.2
            @Override // com.bytedance.pangle.j, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                super.onActivityDestroyed(activity);
                if (activity == PluginActivityWrapper.this.mOriginActivity) {
                    appApplication.unregisterActivityLifecycleCallbacks(this);
                }
            }
        });
    }
}
