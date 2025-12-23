package xyz.adscope.ad;

import org.json.JSONArray;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class p5 extends t {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "id")
    private String f55798a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "data")
    private JSONArray f55799b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "forbidSensor")
    private int f55800c;

    public void a(String str) {
        this.f55798a = str;
    }

    public void a(JSONArray jSONArray) {
        this.f55799b = jSONArray;
    }

    public void a(int i6) {
        this.f55800c = i6;
    }
}
