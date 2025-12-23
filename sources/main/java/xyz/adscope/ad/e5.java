package xyz.adscope.ad;

import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class e5 extends t {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "linkId")
    private String f55124a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "install")
    private String f55125b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "updateTime")
    private long f55126c;

    public void a(String str) {
        this.f55125b = str;
    }

    public void a(long j6) {
        this.f55126c = j6;
    }

    public void b(String str) {
        this.f55124a = str;
    }
}
