package xyz.adscope.ad;

import xyz.adscope.common.v2.encrypt.impl.AesUtil;
import xyz.adscope.common.v2.model.IBaseMacrosMappingModel;
import xyz.adscope.common.v2.model.annotation.MacrosReplace;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class h1 extends IBaseMacrosMappingModel {

    /* renamed from: a, reason: collision with root package name */
    @MacrosReplace(macros = "__WIN_PRICE__")
    private final String f55187a;

    /* renamed from: b, reason: collision with root package name */
    @MacrosReplace(macros = "__HIGHEST_LOSS_PRICE__")
    private final String f55188b;

    /* renamed from: c, reason: collision with root package name */
    @MacrosReplace(macros = "__LOSS_REASON__")
    private final String f55189c;

    /* renamed from: d, reason: collision with root package name */
    @MacrosReplace(macros = "__ADN_ID__")
    private final String f55190d;

    /* renamed from: e, reason: collision with root package name */
    @MacrosReplace(macros = "__EXPECT_PRICE__")
    private final String f55191e;

    /* renamed from: f, reason: collision with root package name */
    @MacrosReplace(macros = "__PRICE__")
    private final String f55192f;

    /* renamed from: g, reason: collision with root package name */
    @MacrosReplace(macros = "__SRC_PRICE__")
    private final String f55193g;

    public h1(String str, String str2, String str3, String str4, String str5) {
        this.f55187a = str;
        this.f55188b = str2;
        this.f55189c = str3;
        this.f55190d = str4;
        this.f55191e = str5;
        this.f55193g = str;
        this.f55192f = AesUtil.encryptCFB(str);
    }
}
