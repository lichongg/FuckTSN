package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.c.j;
import com.kuaishou.weapon.p0.g;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SplashAd {

    /* renamed from: a, reason: collision with root package name */
    private j f13285a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f13286b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13287c = false;

    public void loadAd(int i6, int i7) {
        j jVar = this.f13285a;
        if (jVar == null || this.f13286b == null) {
            return;
        }
        jVar.b(i6);
        this.f13285a.c(i7);
        this.f13285a.a(this.f13286b);
    }

    public void cancel(Context context) {
        j jVar = this.f13285a;
        if (jVar != null) {
            jVar.j();
        }
    }

    public String getCustomExtraData() {
        j jVar = this.f13285a;
        if (jVar == null) {
            return null;
        }
        return jVar.t();
    }

    public String getCustomExtraJsonData() {
        j jVar = this.f13285a;
        if (jVar == null) {
            return null;
        }
        return jVar.v();
    }

    public int getECPM() {
        j jVar = this.f13285a;
        if (jVar != null) {
            return jVar.B();
        }
        return -1;
    }

    public Map getExtraData() {
        j jVar = this.f13285a;
        if (jVar == null) {
            return null;
        }
        return jVar.D();
    }

    public void reportNotShow() {
        j jVar = this.f13285a;
        if (jVar != null) {
            jVar.C();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        j jVar = this.f13285a;
        if (jVar == null || map == null) {
            return;
        }
        jVar.b(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        j jVar = this.f13285a;
        if (jVar == null || map == null) {
            return;
        }
        jVar.a(map);
    }

    public void setBidResponse(String str) {
        j jVar = this.f13285a;
        if (jVar == null) {
            return;
        }
        jVar.g(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        j jVar = this.f13285a;
        if (jVar == null) {
            return;
        }
        jVar.c(map);
    }

    public void setSupportRegionClick(boolean z5) {
        j jVar = this.f13285a;
        if (jVar != null) {
            jVar.a(z5);
        }
    }

    public void show(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        if (this.f13287c || viewGroup == null || this.f13285a == null || (viewGroup2 = this.f13286b) == null) {
            return;
        }
        try {
            if (!(viewGroup2.getContext() instanceof Activity)) {
                this.f13285a.a(viewGroup.getContext());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        viewGroup.addView(this.f13286b);
        this.f13285a.A();
        this.f13287c = true;
    }

    @RequiresPermission(g.f36041a)
    public SplashAd(Context context, View view, String str, AdListener adListener, long j6) {
        this.f13285a = new j(context, str, view, adListener, j6);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f13286b = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    @Deprecated
    public void loadAd() {
        ViewGroup viewGroup;
        j jVar = this.f13285a;
        if (jVar == null || (viewGroup = this.f13286b) == null) {
            return;
        }
        jVar.a(viewGroup);
    }
}
