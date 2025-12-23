package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.beizi.fusion.c.f;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class InterstitialAd {

    /* renamed from: a, reason: collision with root package name */
    private f f13278a;

    public InterstitialAd(Context context, String str, InterstitialAdListener interstitialAdListener, long j6) {
        this.f13278a = new f(context, str, interstitialAdListener, j6, 0);
    }

    public void destroy() {
        f fVar = this.f13278a;
        if (fVar != null) {
            fVar.B();
        }
    }

    public String getCustomExtraData() {
        f fVar = this.f13278a;
        if (fVar == null) {
            return null;
        }
        return fVar.t();
    }

    public String getCustomExtraJsonData() {
        f fVar = this.f13278a;
        if (fVar == null) {
            return null;
        }
        return fVar.v();
    }

    public int getECPM() {
        f fVar = this.f13278a;
        if (fVar != null) {
            return fVar.A();
        }
        return -1;
    }

    public boolean isLoaded() {
        f fVar = this.f13278a;
        if (fVar != null) {
            return fVar.y();
        }
        return false;
    }

    public void loadAd() {
        f fVar = this.f13278a;
        if (fVar != null) {
            fVar.z();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        f fVar = this.f13278a;
        if (fVar == null || map == null) {
            return;
        }
        fVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        f fVar = this.f13278a;
        if (fVar == null || map == null) {
            return;
        }
        fVar.a(map);
    }

    public void setAdVersion(int i6) {
        f fVar = this.f13278a;
        if (fVar != null) {
            fVar.b(i6);
        }
    }

    public void setBidResponse(String str) {
        f fVar = this.f13278a;
        if (fVar == null) {
            return;
        }
        fVar.g(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        f fVar = this.f13278a;
        if (fVar == null) {
            return;
        }
        fVar.c(map);
    }

    public void showAd(@NonNull Activity activity) {
        f fVar = this.f13278a;
        if (fVar != null) {
            fVar.a(activity);
        }
    }

    public InterstitialAd(Context context, String str, InterstitialAdListener interstitialAdListener, long j6, int i6) {
        this.f13278a = new f(context, str, interstitialAdListener, j6, i6);
    }
}
