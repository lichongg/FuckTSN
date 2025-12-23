package com.bxkj.base.generated.callback;

import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final InterfaceC0186a f16503a;

    /* renamed from: b, reason: collision with root package name */
    final int f16504b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.base.generated.callback.a$a, reason: collision with other inner class name */
    public interface InterfaceC0186a {
        void _internalCallbackOnClick(int i6, View view);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f16503a._internalCallbackOnClick(this.f16504b, view);
    }

    public a(InterfaceC0186a interfaceC0186a, int i6) {
        this.f16503a = interfaceC0186a;
        this.f16504b = i6;
    }
}
