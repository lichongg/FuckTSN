package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class bk implements aa.a {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ bj f10741c;

    bk(bj bjVar) {
        this.f10741c = bjVar;
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onFailure() {
        this.f10741c.f10731k.a(bj.f10722b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.f10741c.i();
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onSuccess() {
        this.f10741c.f10731k.a(bj.f10722b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.f10741c.h();
    }
}
