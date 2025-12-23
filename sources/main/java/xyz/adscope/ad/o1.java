package xyz.adscope.ad;

import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class o1 extends t {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "timestamp")
    private long f55750a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "coordinate")
    private String f55751b;

    public o1(long j6, String str) {
        this.f55751b = str;
        this.f55750a = j6;
    }
}
