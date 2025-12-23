package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.beizi.fusion.c.i;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RewardedVideoAd {

    /* renamed from: a, reason: collision with root package name */
    private i f13282a;

    /* renamed from: b, reason: collision with root package name */
    private String f13283b;

    /* renamed from: c, reason: collision with root package name */
    private String f13284c;

    public void destroy() {
        i iVar = this.f13282a;
        if (iVar != null) {
            iVar.B();
        }
    }

    public String getCustomExtraData() {
        i iVar = this.f13282a;
        if (iVar == null) {
            return null;
        }
        return iVar.t();
    }

    public String getCustomExtraJsonData() {
        i iVar = this.f13282a;
        if (iVar == null) {
            return null;
        }
        return iVar.v();
    }

    public int getECPM() {
        i iVar = this.f13282a;
        if (iVar != null) {
            return iVar.A();
        }
        return -1;
    }

    public String getExtra() {
        return this.f13284c;
    }

    public String getUserId() {
        return this.f13283b;
    }

    public boolean isLoaded() {
        i iVar = this.f13282a;
        if (iVar != null) {
            return iVar.y();
        }
        return false;
    }

    public void loadAd() {
        i iVar = this.f13282a;
        if (iVar != null) {
            iVar.z();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        i iVar = this.f13282a;
        if (iVar == null || map == null) {
            return;
        }
        iVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        i iVar = this.f13282a;
        if (iVar == null || map == null) {
            return;
        }
        iVar.a(map);
    }

    public void setBidResponse(String str) {
        i iVar = this.f13282a;
        if (iVar == null) {
            return;
        }
        iVar.g(str);
    }

    public void setExtra(String str) {
        i iVar = this.f13282a;
        if (iVar != null) {
            iVar.i(str);
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        i iVar = this.f13282a;
        if (iVar != null) {
            iVar.a(rewardedVideoAdListener);
        }
    }

    public void setSpaceParam(Map<String, Object> map) {
        i iVar = this.f13282a;
        if (iVar == null) {
            return;
        }
        iVar.c(map);
    }

    public void setUserId(String str) {
        i iVar = this.f13282a;
        if (iVar != null) {
            iVar.h(str);
        }
    }

    public void showAd(@NonNull Activity activity) {
        i iVar = this.f13282a;
        if (iVar != null) {
            iVar.a(activity);
        }
    }

    public RewardedVideoAd(Context context, String str, RewardedVideoAdListener rewardedVideoAdListener, long j6, int i6) {
        this.f13282a = new i(context, str, rewardedVideoAdListener, j6, i6);
    }
}
