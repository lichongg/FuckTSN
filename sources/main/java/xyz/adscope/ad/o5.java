package xyz.adscope.ad;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class o5 extends t {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "tagid")
    private String f55752a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "sdk")
    private String f55753b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "sdkver")
    private String f55754c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)
    private n5 f55755d;

    public void a(String str) {
        this.f55753b = str;
    }

    public void a(n5 n5Var) {
        this.f55755d = n5Var;
    }

    public void b(String str) {
        this.f55754c = str;
    }

    public void c(String str) {
        this.f55752a = str;
    }
}
