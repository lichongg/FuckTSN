package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.c.h;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NativeUnifiedAd {

    /* renamed from: a, reason: collision with root package name */
    private h f13280a;

    public void destroy() {
        h hVar = this.f13280a;
        if (hVar != null) {
            hVar.B();
        }
    }

    public String getCustomExtraData() {
        h hVar = this.f13280a;
        if (hVar == null) {
            return null;
        }
        return hVar.t();
    }

    public String getCustomExtraJsonData() {
        h hVar = this.f13280a;
        if (hVar == null) {
            return null;
        }
        return hVar.v();
    }

    public int getECPM() {
        h hVar = this.f13280a;
        if (hVar != null) {
            return hVar.A();
        }
        return -1;
    }

    public boolean isLoaded() {
        h hVar = this.f13280a;
        if (hVar != null) {
            return hVar.z();
        }
        return false;
    }

    public void loadAd() {
        h hVar = this.f13280a;
        if (hVar != null) {
            hVar.y();
        }
    }

    public void resume() {
        h hVar = this.f13280a;
        if (hVar != null) {
            hVar.C();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        h hVar = this.f13280a;
        if (hVar == null || map == null) {
            return;
        }
        hVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        h hVar = this.f13280a;
        if (hVar == null || map == null) {
            return;
        }
        hVar.a(map);
    }

    public void setBidResponse(String str) {
        h hVar = this.f13280a;
        if (hVar == null) {
            return;
        }
        hVar.g(str);
    }

    public void setHideAdLogo(boolean z5) {
        h hVar = this.f13280a;
        if (hVar != null) {
            hVar.b(z5);
        }
    }

    public void setHideDownloadInfo(boolean z5) {
        h hVar = this.f13280a;
        if (hVar != null) {
            hVar.c(z5);
        }
    }

    public void setSpaceParam(Map<String, Object> map) {
        h hVar = this.f13280a;
        if (hVar == null) {
            return;
        }
        hVar.c(map);
    }

    public NativeUnifiedAd(Context context, String str, NativeUnifiedAdListener nativeUnifiedAdListener, long j6, int i6) {
        this.f13280a = new h(context, str, nativeUnifiedAdListener, j6, i6);
    }
}
