package com.acse.ottn;

import android.webkit.JavascriptInterface;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class x0 {

    /* renamed from: a, reason: collision with root package name */
    public a f5476a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(JSONObject jSONObject, l0 l0Var);
    }

    public void a(a aVar) {
        this.f5476a = aVar;
    }

    @JavascriptInterface
    public void copy(Object obj, l0 l0Var) {
        this.f5476a.a((JSONObject) obj, l0Var);
    }
}
