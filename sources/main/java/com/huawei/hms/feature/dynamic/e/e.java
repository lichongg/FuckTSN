package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class e implements DynamicModule.VersionPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33240a = "e";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        if (remoteModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33212k) > 0) {
            Logger.i(f33240a, "Prefer remote: The version of remote module " + str + ":" + remoteModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33212k));
            return remoteModuleInfo;
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        if (localModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33213l) > 0) {
            Logger.i(f33240a, "Choose local: The version of local module " + str + ":" + localModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33213l));
            return localModuleInfo;
        }
        Logger.i(f33240a, "Cannot get module info in remote or local.");
        return new Bundle();
    }
}
