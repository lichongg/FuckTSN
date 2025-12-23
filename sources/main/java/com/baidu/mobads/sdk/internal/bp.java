package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.ca;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class bp {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10767a = "ContainerFactoryBuilder";

    /* renamed from: e, reason: collision with root package name */
    private static IXAdContainerFactory f10768e;

    /* renamed from: c, reason: collision with root package name */
    private Context f10770c;

    /* renamed from: d, reason: collision with root package name */
    private Class<?> f10771d;

    /* renamed from: b, reason: collision with root package name */
    public double f10769b = 0.1d;

    /* renamed from: f, reason: collision with root package name */
    private bu f10772f = bu.a();

    public void b() {
        f10768e = null;
    }

    public IXAdContainerFactory a() {
        if (f10768e == null) {
            try {
                f10768e = (IXAdContainerFactory) this.f10771d.getDeclaredConstructor(Context.class).newInstance(this.f10770c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.analytics.pro.bi.bg, "9.40");
                f10768e.initConfig(jSONObject);
                this.f10769b = f10768e.getRemoteVersion();
                f10768e.onTaskDistribute(bd.f10704a, MobadsPermissionSettings.getPermissionInfo());
                f10768e.initCommonModuleObj(t.a());
            } catch (Throwable th) {
                this.f10772f.b(f10767a, th.getMessage());
                throw new ca.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return f10768e;
    }

    public bp(Class<?> cls, Context context) {
        this.f10771d = null;
        this.f10771d = cls;
        this.f10770c = context;
    }
}
