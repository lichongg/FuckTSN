package com.kwad.components.ad.reward.l.a;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.l.c;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private b Bb = new b();
    private final C0584a Bc = new C0584a(e.FC());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.reward.l.a.a$a, reason: collision with other inner class name */
    static class C0584a extends com.kwad.components.ad.reward.l.b {
        public C0584a(int i6) {
            StringBuilder sb = new StringBuilder();
            sb.append(i6);
            this.AZ = String.format("进阶奖励：浏览详情页 %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i6);
            this.Ba = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends com.kwad.components.ad.reward.l.b {
        public b() {
            this.AZ = "基础奖励：观看视频";
            this.Ba = "基础奖励：需再观看%ss视频";
        }
    }

    private void kM() {
        if (this.Bc.isCompleted()) {
            kC();
        } else {
            kD();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.Bc.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<c> kA() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.Bb);
        arrayList.add(this.Bc);
        return arrayList;
    }

    public final void kK() {
        com.kwad.sdk.core.d.c.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.Bb.kC();
        kM();
    }

    public final boolean kL() {
        return this.Bb.isCompleted();
    }

    public final void markOpenNsCompleted() {
        com.kwad.sdk.core.d.c.d("LandPageOpenTask", "markOpenNsCompleted");
        this.Bc.kC();
        kM();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.Bb.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.Bc.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.a(jSONObject, "mWatchVideoTask", this.Bb);
        aa.a(jSONObject, "mOpenNsTask", this.Bc);
        return jSONObject;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int kB() {
        Iterator<c> it = kA().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i6++;
            }
        }
        return i6;
    }
}
