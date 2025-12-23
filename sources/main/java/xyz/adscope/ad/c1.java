package xyz.adscope.ad;

import org.json.JSONObject;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class c1 extends i2 {

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "install")
    private boolean f54904b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "linkId")
    private String f54905c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "updateTime")
    private long f54906d;

    public c1() {
    }

    public void a(boolean z5) {
        this.f54904b = z5;
    }

    public c1(JSONObject jSONObject) {
        super(jSONObject);
    }

    public void a(String str) {
        this.f54905c = str;
    }

    public String b() {
        return this.f54905c;
    }

    public long c() {
        return this.f54906d;
    }

    public String d() {
        return this.f54904b ? "1" : "0";
    }

    public void a(long j6) {
        this.f54906d = j6;
    }
}
