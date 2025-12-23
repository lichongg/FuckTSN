package com.kwad.components.core.o.b.a;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class d implements IEnvironment {
    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isDebug() {
        return false;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final void addOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        if (context == null || offlineOnAudioConflictListener == null) {
            return;
        }
        com.kwad.components.core.t.a.aC(context).a(offlineOnAudioConflictListener);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getAppVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getBiz() {
        return com.kwad.sdk.i.asd;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getKpf() {
        return "ANDROID_PHONE";
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getKpn() {
        return "UNIVERSE.AD.LIVE";
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isDevelopEnable() {
        return com.kwad.components.core.a.oz.booleanValue();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isTKCrashCollectEnable() {
        return com.kwad.sdk.core.config.c.aBt.getValue().booleanValue();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String localIpAddress() {
        if (!com.kwad.components.core.a.oz.booleanValue()) {
            return "10.118.8.111";
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return "10.118.8.111";
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final void removeOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        if (context == null || offlineOnAudioConflictListener == null) {
            return;
        }
        com.kwad.components.core.t.a.aC(context).b(offlineOnAudioConflictListener);
    }

    d() {
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getAppId() {
        return ServiceProvider.getAppId();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final Context getContext() {
        return ServiceProvider.getContext();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getDeviceId() {
        return br.getDeviceId();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final double getLatitude(Context context) {
        com.kwad.sdk.internal.api.a aVar;
        com.kwad.sdk.utils.c.a cL = bd.cL(context);
        if (cL != null && (aVar = cL.bcT) != null) {
            return aVar.getLatitude();
        }
        return 0.0d;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final double getLongitude(Context context) {
        com.kwad.sdk.internal.api.a aVar;
        com.kwad.sdk.utils.c.a cL = bd.cL(context);
        if (cL != null && (aVar = cL.bcT) != null) {
            return aVar.getLongitude();
        }
        return 0.0d;
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getOperator(Context context) {
        return String.valueOf(ao.df(context));
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getOsVersion() {
        return br.getOsVersion();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getProcessName(Context context) {
        return SystemUtil.getProcessName(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final int getStatusBarHeight(Context context) {
        return com.kwad.sdk.c.a.a.getStatusBarHeight(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final String getUserAgent() {
        return com.kwad.sdk.core.network.p.getUserAgent();
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isArm64(Context context) {
        return AbiUtil.isArm64(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean isInMainProcess(Context context) {
        return SystemUtil.isInMainProcess(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IEnvironment
    public final boolean requestAudioFocus(Context context, boolean z5) {
        return com.kwad.components.core.t.a.aC(context).aQ(z5);
    }
}
