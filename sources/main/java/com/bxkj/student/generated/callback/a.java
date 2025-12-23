package com.bxkj.student.generated.callback;

import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final InterfaceC0207a f17852a;

    /* renamed from: b, reason: collision with root package name */
    final int f17853b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.generated.callback.a$a, reason: collision with other inner class name */
    public interface InterfaceC0207a {
        void _internalCallbackOnClick(int sourceId, View callbackArg_0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View callbackArg_0) {
        this.f17852a._internalCallbackOnClick(this.f17853b, callbackArg_0);
    }

    public a(InterfaceC0207a listener, int sourceId) {
        this.f17852a = listener;
        this.f17853b = sourceId;
    }
}
