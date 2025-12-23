package com.bytedance.pangle.activity;

import android.R;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatViewInflater;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.api.m;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
class cw {
    /* JADX WARN: Multi-variable type inference failed */
    static void j(xt xtVar, Bundle bundle) {
        List<String> list;
        if (!Zeus.hasInit()) {
            m.up(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. AppApplication == null.");
            xtVar.zeusSuperOnCreate(null);
            xtVar.finish();
            return;
        }
        Intent intent = xtVar.getIntent();
        String pluginPkgName = xtVar.getPluginPkgName();
        Plugin plugin = xtVar.getPlugin();
        if (plugin == null) {
            m.up(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. plugin == null");
            xtVar.zeusSuperOnCreate(null);
            xtVar.finish();
            return;
        }
        intent.setExtrasClassLoader(plugin.mClassLoader);
        IntentUtils.j(intent);
        String stringExtra = intent.getStringExtra("targetPlugin");
        if (TextUtils.isEmpty(stringExtra) && (list = ComponentManager.stubActivity2TargetActivities.get(xtVar.getClass().getName())) != null && list.size() == 1) {
            stringExtra = list.get(0);
            intent.putExtra("targetPlugin", stringExtra);
        }
        if (!plugin.isLoaded() || TextUtils.isEmpty(stringExtra)) {
            try {
                xtVar.zeusSuperOnCreate(null);
                ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
                xtVar.finish();
                return;
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
        ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
        if (activityInfo == null) {
            ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
            xtVar.zeusSuperOnCreate(null);
            xtVar.finish();
        }
        int i6 = -1;
        try {
            IPluginActivity iPluginActivity = (IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
            FieldUtils.writeField(iPluginActivity, "mApplication", xtVar.getApplication());
            xtVar.setTargetActivity(iPluginActivity);
            iPluginActivity.setPluginProxyActivity(xtVar, plugin);
            i6 = activityInfo.theme;
            xtVar.zeusSuperSetTheme(i6);
            TypedArray obtainStyledAttributes = ((Activity) xtVar).getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent});
            if (obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(0), false)) {
                j((Activity) xtVar);
            }
            obtainStyledAttributes.recycle();
            iPluginActivity.attachBaseContext(xtVar.getBaseContext());
            try {
                int requestedOrientation = ((Activity) xtVar).getRequestedOrientation();
                int i7 = activityInfo.screenOrientation;
                if (requestedOrientation != i7) {
                    ((Activity) xtVar).setRequestedOrientation(i7);
                }
            } catch (IllegalStateException unused) {
            }
            iPluginActivity.onCreate(bundle);
        } catch (Exception e7) {
            throw new RuntimeException(e7 instanceof IllegalStateException ? "activityTheme:".concat(String.valueOf(i6)) : "", e7);
        }
    }

    static void j(xt xtVar, Context context) {
        if (!Zeus.hasInit()) {
            m.up(ZeusLogger.TAG_INIT, "ProxyActivityUtils.attachBaseContext. AppApplication == null.");
            xtVar.zeusSuperAttachBaseContext(context);
            return;
        }
        String pluginPkgName = xtVar.getPluginPkgName();
        boolean loadPlugin = PluginManager.getInstance().loadPlugin(pluginPkgName);
        try {
            xtVar.setPlugin(PluginManager.getInstance().getPlugin(pluginPkgName));
            if (loadPlugin) {
                xtVar.zeusSuperAttachBaseContext(ZeusTransformUtils.wrapperContext(context, pluginPkgName));
                FieldUtils.writeField(xtVar, "mResources", (Object) null);
            } else {
                xtVar.zeusSuperAttachBaseContext(context);
            }
        } catch (Exception e6) {
            throw new RuntimeException(e6);
        }
    }

    static void j(Activity activity, View view) {
        Object readField;
        if (view == null) {
            return;
        }
        try {
            Object readField2 = FieldUtils.readField(view, "mListenerInfo");
            if (readField2 != null && (readField = FieldUtils.readField(readField2, "mOnClickListener")) != null) {
                String name = readField.getClass().getName();
                if (!name.startsWith(AppCompatViewInflater.class.getName())) {
                    if (name.startsWith(View.class.getName())) {
                    }
                }
                view.setOnClickListener(new j(activity, view.getId(), (String) FieldUtils.readField(readField, "mMethodName")));
            }
        } catch (Exception e6) {
            ZeusLogger.errReport(ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(String.valueOf(view)));
            m.j(e6);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i6 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i6 >= viewGroup.getChildCount()) {
                return;
            }
            j(activity, viewGroup.getChildAt(i6));
            i6++;
        }
    }

    private static Class j() {
        Class<?> cls = null;
        for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
            if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                cls = cls2;
            }
        }
        return cls;
    }

    private static void j(Activity activity) {
        try {
            MethodUtils.getAccessibleMethod(Activity.class, "convertToTranslucent", j(), ActivityOptions.class).invoke(activity, null, MethodUtils.getAccessibleMethod(Activity.class, "getActivityOptions", new Class[0]).invoke(activity, null));
        } catch (Throwable unused) {
        }
    }
}
