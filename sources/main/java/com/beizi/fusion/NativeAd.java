package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.c.g;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NativeAd {

    /* renamed from: a, reason: collision with root package name */
    private g f13279a;

    public void destroy() {
        g gVar = this.f13279a;
        if (gVar != null) {
            gVar.z();
        }
    }

    public String getCustomExtraData() {
        g gVar = this.f13279a;
        if (gVar == null) {
            return null;
        }
        return gVar.t();
    }

    public String getCustomExtraJsonData() {
        g gVar = this.f13279a;
        if (gVar == null) {
            return null;
        }
        return gVar.v();
    }

    public int getECPM() {
        g gVar = this.f13279a;
        if (gVar != null) {
            return gVar.y();
        }
        return -1;
    }

    public void loadAd(float f6, float f7) {
        g gVar = this.f13279a;
        if (gVar != null) {
            gVar.a(f6, f7);
        }
    }

    public void pause() {
        g gVar = this.f13279a;
        if (gVar != null) {
            gVar.B();
        }
    }

    public void resume() {
        g gVar = this.f13279a;
        if (gVar != null) {
            gVar.A();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        g gVar = this.f13279a;
        if (gVar == null || map == null) {
            return;
        }
        gVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        g gVar = this.f13279a;
        if (gVar == null || map == null) {
            return;
        }
        gVar.a(map);
    }

    public void setBidResponse(String str) {
        g gVar = this.f13279a;
        if (gVar == null) {
            return;
        }
        gVar.g(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        g gVar = this.f13279a;
        if (gVar == null) {
            return;
        }
        gVar.c(map);
    }

    public NativeAd(Context context, String str, NativeAdListener nativeAdListener, long j6, int i6) {
        this.f13279a = new g(context, str, nativeAdListener, j6, i6);
    }
}
