package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicImpl(IKsAdSDK.class)
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsAdSDKImpl implements IKsAdSDK {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.KsAdSDKImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final KsAdSDKImpl asg = new KsAdSDKImpl(null);
    }

    /* synthetic */ KsAdSDKImpl(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void init(Context context, SdkConfig sdkConfig) {
        l Cf = l.Cf();
        Cf.init(context, sdkConfig);
        if (!Cf.Cg()) {
            Cf.start();
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void start() {
        l Cf = l.Cf();
        if (Cf.Cg()) {
            Cf.start();
        }
    }

    private KsAdSDKImpl() {
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void re(Object obj) {
        if (obj instanceof Throwable) {
            l.Cf();
            l.k((Throwable) obj);
        }
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    @Keep
    public static KsAdSDKImpl get() {
        return a.asg;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(@NonNull Map<String, String> map) {
        l.Cf();
        l.e(map);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Object dM(String str, Object... objArr) {
        l.Cf();
        return l.f(str, objArr);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        l.Cf();
        l.deleteCache();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        return l.Cf().getAdManager();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getApiVersion() {
        return l.Cf().getApiVersion();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getApiVersionCode() {
        return l.Cf().getApiVersionCode();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppId() {
        l.Cf();
        return l.getAppId();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        l.Cf();
        return l.getAppInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        l.Cf();
        return l.getAppName();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Context getContext() {
        l.Cf();
        return l.getContext();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        l.Cf();
        return l.getDeviceInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        l.Cf();
        return l.getDid();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        l.Cf();
        return l.getNetworkInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRD(String str) {
        l.Cf();
        return l.cl(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRM(String str) {
        l.Cf();
        return l.ck(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKType() {
        l.Cf();
        return 1;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getSDKVersion() {
        l.Cf();
        return l.getSDKVersion();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        l.Cf();
        return BuildConfig.VERSION_CODE;
    }

    public SdkConfig getSdkConfig() {
        l.Cf();
        return l.getSdkConfig();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        l.Cf();
        return l.isDebugLogEnable();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        return (T) l.Cf().newComponentProxy(cls, obj);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T> T newInstance(Class<T> cls) {
        l.Cf();
        return (T) l.newInstance(cls);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void pauseCurrentPlayer() {
        l.Cf();
        l.pauseCurrentPlayer();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        l.Cf();
        l.resumeCurrentPlayer();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void sR(String str, Map<String, String> map, String str2) {
        l.Cf();
        l.b(str, map, str2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAdxEnable(boolean z5) {
        l.Cf().setAdxEnable(z5);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersion(String str) {
        l.Cf().setApiVersion(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersionCode(int i6) {
        l.Cf().setApiVersionCode(i6);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAppTag(String str) {
        l.Cf().setAppTag(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setInitStartTime(long j6) {
        l.Cf().setInitStartTime(j6);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z5) {
        l.Cf().setIsExternal(z5);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLaunchTime(long j6) {
        l.Cf().setLaunchTime(j6);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimation(boolean z5, @RawRes int i6) {
        l.Cf();
        l.setLoadingLottieAnimation(z5, i6);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimationColor(boolean z5, @ColorInt int i6) {
        l.Cf();
        l.setLoadingLottieAnimationColor(z5, i6);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setPersonalRecommend(boolean z5) {
        l.Cf().setPersonalRecommend(z5);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setProgrammaticRecommend(boolean z5) {
        l.Cf().setProgrammaticRecommend(z5);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setThemeMode(int i6) {
        l.Cf();
        l.setThemeMode(i6);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        l.Cf().unInit();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i6, Map<String, Object> map) {
    }
}
