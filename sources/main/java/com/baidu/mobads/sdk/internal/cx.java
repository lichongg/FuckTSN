package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class cx implements w {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f10972a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f10973b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f10974c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ct f10975d;

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(JSONObject jSONObject) {
    }

    cx(ct ctVar, int i6, int i7, String str) {
        this.f10975d = ctVar;
        this.f10972a = i6;
        this.f10973b = i7;
        this.f10974c = str;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(boolean z5) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10975d.e());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10975d.f()));
        hashMap.put("entry", Integer.valueOf(this.f10972a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10973b));
        hashMap.put("novel_id", this.f10974c);
        hashMap.put("novel_info", jSONObject);
        this.f10975d.a(cy.f10980w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10975d.e());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f10972a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10973b));
        hashMap.put("novel_id", this.f10974c);
        this.f10975d.a(cy.f10978u, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10975d.e());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10975d.f()));
        hashMap.put("entry", Integer.valueOf(this.f10972a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10973b));
        hashMap.put("novel_id", this.f10974c);
        hashMap.put("novel_info", jSONObject);
        this.f10975d.a(cy.f10979v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f10972a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10973b));
        hashMap.put("novel_id", this.f10974c);
        this.f10975d.a(cy.f10982y, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i6) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10975d.e());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10975d.f()));
        hashMap.put("entry", Integer.valueOf(this.f10972a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10973b));
        hashMap.put("novel_id", this.f10974c);
        hashMap.put("backgroundColor", Integer.valueOf(i6));
        this.f10975d.a(cy.f10983z, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i6 = this.f10975d.i("get_cuid");
        String i7 = this.f10975d.i("get_imei");
        String i8 = this.f10975d.i("get_oaid");
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
        this.f10975d.f10731k.a("单次阅读器打开时长 = " + j6);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, int i6) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f10975d.e());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f10975d.f()));
        hashMap.put("entry", Integer.valueOf(this.f10972a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10973b));
        hashMap.put("novel_id", this.f10974c);
        hashMap.put("count_down", Integer.valueOf(i6));
        this.f10975d.a(cy.A, hashMap);
    }
}
