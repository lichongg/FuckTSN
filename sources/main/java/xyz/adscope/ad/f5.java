package xyz.adscope.ad;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class f5 extends t {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "bundle")
    private String f55133a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "ver")
    private String f55134b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = CommonNetImpl.NAME)
    private String f55135c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "install")
    private long f55136d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "update")
    private long f55137e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = "appId")
    private String f55138f;

    public void a(long j6) {
        this.f55136d = j6;
    }

    public void b(String str) {
        this.f55133a = str;
    }

    public void a(String str) {
        this.f55138f = str;
    }

    public void b(long j6) {
        this.f55137e = j6;
    }

    public void c(String str) {
        this.f55135c = str;
    }

    public void d(String str) {
        this.f55134b = str;
    }
}
