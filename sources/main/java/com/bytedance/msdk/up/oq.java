package com.bytedance.msdk.up;

import android.content.Context;
import android.os.Looper;
import com.bytedance.msdk.tl.x;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq implements com.bytedance.sdk.component.tl.j.r {
    @Override // com.bytedance.sdk.component.tl.j.r
    public com.bytedance.sdk.component.tl.j.j.xt ae() {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean cw() {
        return false;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public com.bytedance.sdk.component.tl.j.xt j(JSONObject jSONObject) {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean jy() {
        return false;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public int oq() {
        return 2;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public com.bytedance.sdk.component.tl.xt.cw qv() {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean r() {
        return true;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public com.bytedance.sdk.component.tl.j.tl vl() {
        return null;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean ws() {
        return false;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public String xt() {
        return "mediation_log";
    }

    public static String cw(String str) {
        return com.bytedance.msdk.tl.j.xt(str, com.bytedance.msdk.tl.xt.j());
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public void j(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public String up() {
        return "gromore-no-webview";
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public String xt(String str) {
        return com.bytedance.msdk.tl.j.j(str, com.bytedance.msdk.tl.xt.j());
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public Looper az() {
        return com.bytedance.sdk.component.oq.xt.j.j().xt().getLooper();
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public Executor g() {
        return com.bytedance.msdk.j.up.m.m();
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean j() {
        return false;
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public Executor tl() {
        return com.bytedance.msdk.j.up.m.m();
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public boolean j(Context context) {
        return x.j(context);
    }

    @Override // com.bytedance.sdk.component.tl.j.r
    public String j(String str) {
        return cw(str);
    }
}
