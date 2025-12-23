package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.RouteInfo;
import java.lang.reflect.Method;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class as extends RouteInfo {

    /* renamed from: a, reason: collision with root package name */
    private y f10638a;

    private void b() {
        RouteInfo routeInfo;
        try {
            Method declaredMethod = Class.forName(z.ar + getPath()).getDeclaredMethod("getRoutesMap", null);
            declaredMethod.setAccessible(true);
            HashMap hashMap = (HashMap) declaredMethod.invoke(null, null);
            if (hashMap == null || hashMap.size() <= 0 || (routeInfo = (RouteInfo) hashMap.get(getPath())) == null) {
                return;
            }
            this.f10638a = (y) routeInfo.getDestination().getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
        }
    }

    public Object a() {
        return this.f10638a;
    }

    public as(String str) {
        setPath(str);
        b();
    }
}
