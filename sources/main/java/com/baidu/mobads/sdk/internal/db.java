package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.kwad.sdk.core.scene.URLPackage;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class db implements w {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cy f10988a;

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(JSONObject jSONObject) {
    }

    db(cy cyVar) {
        this.f10988a = cyVar;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10988a.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f10988a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10988a.H));
        hashMap.put("novel_id", this.f10988a.I);
        this.f10988a.a(cy.f10978u, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10988a.f());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10988a.g()));
        hashMap.put("entry", Integer.valueOf(this.f10988a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10988a.H));
        hashMap.put("novel_id", this.f10988a.I);
        hashMap.put("novel_info", jSONObject);
        this.f10988a.a(cy.f10980w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10988a.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10988a.g()));
        hashMap.put("entry", Integer.valueOf(this.f10988a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10988a.H));
        hashMap.put("novel_id", this.f10988a.I);
        hashMap.put("novel_info", jSONObject);
        this.f10988a.a(cy.f10979v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f10988a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10988a.H));
        hashMap.put("novel_id", this.f10988a.I);
        hashMap.put("isnight", Boolean.valueOf(this.f10988a.x()));
        this.f10988a.a(cy.f10982y, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i6) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10988a.f());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10988a.g()));
        hashMap.put("entry", Integer.valueOf(this.f10988a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10988a.H));
        hashMap.put("novel_id", this.f10988a.I);
        hashMap.put("backgroundColor", Integer.valueOf(i6));
        this.f10988a.a(cy.f10983z, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i6 = this.f10988a.i("get_cuid");
        String i7 = this.f10988a.i("get_imei");
        String i8 = this.f10988a.i("get_oaid");
        try {
            jSONObject.put("cuid", i6);
            jSONObject.put("imei", i7);
            jSONObject.put("oaid", i8);
            return jSONObject;
        } catch (JSONException e6) {
            e6.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(long j6) {
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        CPUNovelAd.CpuNovelListener cpuNovelListener2;
        cpuNovelListener = this.f10988a.K;
        if (cpuNovelListener != null) {
            cpuNovelListener2 = this.f10988a.K;
            cpuNovelListener2.onReadTime(j6);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, int i6) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10988a.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10988a.g()));
        hashMap.put("entry", Integer.valueOf(this.f10988a.G));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10988a.H));
        hashMap.put("novel_id", this.f10988a.I);
        hashMap.put("count_down", Integer.valueOf(i6));
        this.f10988a.a(cy.A, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(boolean z5) {
        SoftReference softReference;
        SoftReference softReference2;
        softReference = this.f10988a.L;
        if (softReference != null) {
            softReference2 = this.f10988a.L;
            RelativeLayout relativeLayout = (RelativeLayout) softReference2.get();
            if (relativeLayout != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("novel_activity", (Activity) this.f10988a.f10729i);
                hashMap.put("interstitial_container", null);
                hashMap.put("banner_container", relativeLayout);
                hashMap.put("entry", Integer.valueOf(this.f10988a.G));
                hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10988a.H));
                hashMap.put("novel_id", this.f10988a.I);
                hashMap.put("isnight", Boolean.valueOf(this.f10988a.x()));
                this.f10988a.a(cy.f10983z, hashMap);
            }
        }
    }
}
