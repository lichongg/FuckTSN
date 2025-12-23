package com.bytedance.pangle.service;

import android.app.IntentService;
import android.content.ComponentName;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Keep
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class PluginIntentService extends IntentService implements j {
    private static final String TAG = "PluginService";

    public PluginIntentService(String str) {
        super(str);
    }

    @Override // com.bytedance.pangle.service.j
    public void attach(Plugin plugin) {
        boolean z5;
        attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName));
        try {
            FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
            FieldUtils.writeField(this, "mClassName", getClass().getName());
            FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
            if (getApplicationInfo().targetSdkVersion < 5) {
                z5 = true;
            } else {
                z5 = false;
            }
            FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(z5));
        } catch (Exception e6) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e6);
        }
    }

    protected Object createActivityManagerProxy() throws ClassNotFoundException {
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new InvocationHandler() { // from class: com.bytedance.pangle.service.PluginIntentService.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                String name = method.getName();
                name.getClass();
                if (!name.equals("getForegroundServiceType")) {
                    if (!name.equals("stopServiceToken")) {
                        return null;
                    }
                    com.bytedance.pangle.service.j.j xt = com.bytedance.pangle.service.j.j.xt();
                    PluginIntentService pluginIntentService = PluginIntentService.this;
                    return Boolean.valueOf(xt.j(new ComponentName(pluginIntentService, pluginIntentService.getClass().getName())));
                }
                return 0;
            }
        });
    }
}
