package xyz.adscope.ad;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.au;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class h5 extends t {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = Constants.JumpUrlConstants.SRC_TYPE_APP)
    private f5 f55203a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = au.f40908m)
    private p5 f55204b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = ConstantHelper.LOG_DE)
    private k5 f55205c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "regs")
    private m5 f55206d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)
    private g5 f55207e;

    public void a(f5 f5Var) {
        this.f55203a = f5Var;
    }

    public void a(p5 p5Var) {
        this.f55204b = p5Var;
    }

    public void a(k5 k5Var) {
        this.f55205c = k5Var;
    }

    public void a(m5 m5Var) {
        this.f55206d = m5Var;
    }

    public void a(g5 g5Var) {
        this.f55207e = g5Var;
    }
}
