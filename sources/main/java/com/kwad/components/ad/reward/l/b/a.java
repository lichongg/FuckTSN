package com.kwad.components.ad.reward.l.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private c Bd = new c();
    private C0585a Be = new C0585a();
    private final b Bf = new b(com.kwad.components.ad.reward.a.b.hB());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.reward.l.b.a$a, reason: collision with other inner class name */
    static class C0585a extends com.kwad.components.ad.reward.l.b {
        public C0585a() {
            this.AZ = "安装应用";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends com.kwad.components.ad.reward.l.b {
        public b(int i6) {
            StringBuilder sb = new StringBuilder();
            sb.append(i6);
            this.AZ = String.format("进阶奖励：安装并激活APP %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i6);
            this.Ba = String.format("进阶奖励：安装并激活APP %ss", sb2.toString());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c extends com.kwad.components.ad.reward.l.b {
        public c() {
            this.AZ = "基础奖励：观看视频";
            this.Ba = "基础奖励：需再观看%ss视频";
        }
    }

    private void kM() {
        if (this.Bd.isCompleted() && this.Be.isCompleted() && this.Bf.isCompleted()) {
            kC();
        } else {
            kD();
        }
    }

    private void kO() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallUncompleted");
        this.Be.kD();
        kM();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.Be.isCompleted() && this.Bf.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> kA() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.Bd);
        arrayList.add(this.Bf);
        return arrayList;
    }

    public final void kK() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markWatchVideoCompleted");
        this.Bd.kC();
        kM();
    }

    public final boolean kL() {
        return this.Bd.isCompleted();
    }

    public final void kN() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallCompleted");
        this.Be.kC();
        kM();
    }

    public final void kP() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markUseAppCompleted");
        this.Bf.kC();
        kM();
    }

    public final boolean kQ() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "isInstallCompleted");
        return this.Be.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.Bd.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.Bf.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.a(jSONObject, "mWatchVideoTask", this.Bd);
        aa.a(jSONObject, "mInstallAppTask", this.Be);
        aa.a(jSONObject, "mUseAppTask", this.Bf);
        return jSONObject;
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (as.aq(context, com.kwad.sdk.core.response.b.a.ay(e.el(adTemplate)))) {
            aVar.kN();
        } else {
            aVar.kO();
        }
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int kB() {
        Iterator<com.kwad.components.ad.reward.l.c> it = kA().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i6++;
            }
        }
        return i6;
    }
}
