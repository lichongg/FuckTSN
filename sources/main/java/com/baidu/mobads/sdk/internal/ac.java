package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.ca;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class ac implements ca.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aa f10559a;

    ac(aa aaVar) {
        this.f10559a = aaVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ca.c
    public void a(boolean z5) {
        IXAdContainerFactory iXAdContainerFactory;
        if (z5) {
            try {
                ca caVar = h.f11035a;
                if (caVar != null) {
                    this.f10559a.f10547b = caVar.i();
                    iXAdContainerFactory = this.f10559a.f10547b;
                    if (iXAdContainerFactory != null) {
                        this.f10559a.k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.f10559a.a("加载dex异常");
                return;
            }
        }
        h.f11035a = null;
        this.f10559a.a("加载dex失败");
    }
}
