package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.beizi.fusion.c.k;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class UnifiedCustomAd {

    /* renamed from: a, reason: collision with root package name */
    private k f13288a;

    public void destroy() {
        k kVar = this.f13288a;
        if (kVar != null) {
            kVar.A();
        }
    }

    public String getCustomExtraData() {
        k kVar = this.f13288a;
        if (kVar == null) {
            return null;
        }
        return kVar.t();
    }

    public String getCustomExtraJsonData() {
        k kVar = this.f13288a;
        if (kVar == null) {
            return null;
        }
        return kVar.v();
    }

    public boolean isLoaded() {
        k kVar = this.f13288a;
        if (kVar != null) {
            return kVar.z();
        }
        return false;
    }

    public void loadAd() {
        k kVar = this.f13288a;
        if (kVar != null) {
            kVar.y();
        }
    }

    public void resume() {
        k kVar = this.f13288a;
        if (kVar != null) {
            kVar.B();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        k kVar = this.f13288a;
        if (kVar == null || map == null) {
            return;
        }
        kVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        k kVar = this.f13288a;
        if (kVar == null || map == null) {
            return;
        }
        kVar.a(map);
    }

    public void setBidResponse(String str) {
        k kVar = this.f13288a;
        if (kVar == null) {
            return;
        }
        kVar.g(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        k kVar = this.f13288a;
        if (kVar == null) {
            return;
        }
        kVar.c(map);
    }

    public void showAd(@NonNull Activity activity) {
        k kVar = this.f13288a;
        if (kVar != null) {
            kVar.a(activity);
        }
    }

    public UnifiedCustomAd(Context context, String str, NativeAdListener nativeAdListener, long j6, int i6) {
        this.f13288a = new k(context, str, nativeAdListener, j6, i6);
    }
}
