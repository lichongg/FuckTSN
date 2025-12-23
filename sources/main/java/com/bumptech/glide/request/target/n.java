package com.bumptech.glide.request.target;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class n<Z> extends b<Z> {

    /* renamed from: b, reason: collision with root package name */
    private final int f16258b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16259c;

    public n() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public n(int i6, int i7) {
        this.f16258b = i6;
        this.f16259c = i7;
    }

    @Override // com.bumptech.glide.request.target.p
    public final void q(@NonNull o oVar) {
        if (com.bumptech.glide.util.l.w(this.f16258b, this.f16259c)) {
            oVar.d(this.f16258b, this.f16259c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f16258b + " and height: " + this.f16259c + ", either provide dimensions in the constructor or call override()");
    }

    @Override // com.bumptech.glide.request.target.p
    public void b(@NonNull o oVar) {
    }
}
