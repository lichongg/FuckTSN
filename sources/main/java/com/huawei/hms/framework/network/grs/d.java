package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, c> f33423a = new ConcurrentHashMap(16);

    /* renamed from: b, reason: collision with root package name */
    private static final Object f33424b = new Object();

    public static c a(GrsBaseInfo grsBaseInfo, Context context) {
        c cVar;
        String str;
        synchronized (f33424b) {
            try {
                int uniqueCode = grsBaseInfo.uniqueCode();
                Map<String, c> map = f33423a;
                cVar = map.get(context.getPackageName() + uniqueCode);
                if (cVar == null) {
                    Logger.i("GrsClientManager", "grsClientImpl == null, and new GrsClientImpl");
                    cVar = new c(context, grsBaseInfo);
                    str = context.getPackageName() + uniqueCode;
                } else if (!cVar.o(new c(grsBaseInfo))) {
                    Logger.i("GrsClientManager", "The app_name, ser_country, reg_country and issue_country is equal, but other not.");
                    cVar = new c(context, grsBaseInfo);
                    str = context.getPackageName() + uniqueCode;
                }
                map.put(str, cVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }
}
