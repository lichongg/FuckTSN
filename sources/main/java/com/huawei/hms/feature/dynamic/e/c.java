package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class c implements DynamicModule.VersionPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33238a = "c";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        DynamicModule.LoadingException loadingException;
        Bundle bundle;
        try {
            bundle = DynamicModule.getRemoteModuleInfo(context, str);
            loadingException = null;
        } catch (DynamicModule.LoadingException e6) {
            if (e6.getBundle() != null) {
                loadingException = new DynamicModule.LoadingException(e6.getMessage(), e6.getBundle());
            } else {
                loadingException = new DynamicModule.LoadingException(e6.getMessage());
            }
            Logger.w(f33238a, "Get remote module info failed: " + e6.getMessage() + ". try to query local.");
            bundle = new Bundle();
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str2 = f33238a;
        Logger.i(str2, "The version of remote module " + str + ":" + bundle.getInt(com.huawei.hms.feature.dynamic.b.f33212k));
        Logger.i(str2, "The version of local module " + str + ":" + localModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33213l));
        if (localModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33213l) > 0 && localModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33213l) >= bundle.getInt(com.huawei.hms.feature.dynamic.b.f33212k)) {
            Logger.i(str2, "Choose local module info.");
            return localModuleInfo;
        }
        if (loadingException != null && bundle.getInt(com.huawei.hms.feature.dynamic.b.f33212k) == 0) {
            throw loadingException;
        }
        Logger.i(str2, "Choose remote module info.");
        return bundle;
    }
}
