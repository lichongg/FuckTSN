package xyz.adscope.ad;

import com.qq.e.comm.managers.setting.GlobalSetting;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class m5 extends t {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = GlobalSetting.COPPA)
    private int f55420a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = GlobalSetting.GDPR)
    private int f55421b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = GlobalSetting.CCPA)
    private int f55422c;

    public void a(int i6) {
        this.f55422c = i6;
    }

    public void b(int i6) {
        this.f55420a = i6;
    }

    public void c(int i6) {
        this.f55421b = i6;
    }
}
