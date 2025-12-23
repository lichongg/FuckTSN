package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class d implements DynamicModule.VersionPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33239a = "d";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str2 = f33239a;
        Logger.i(str2, "The version of remote module " + str + ":" + remoteModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33212k));
        Logger.i(str2, "The version of local module " + str + ":" + localModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33213l));
        if (remoteModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33212k) >= localModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.f33213l)) {
            Logger.i(str2, "Choose remote module info.");
            return remoteModuleInfo;
        }
        Logger.i(str2, "Choose local module info.");
        return localModuleInfo;
    }
}
