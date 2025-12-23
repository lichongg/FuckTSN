package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.j;
import com.bumptech.glide.load.engine.u;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i extends com.bumptech.glide.util.h<com.bumptech.glide.load.c, u<?>> implements j {

    /* renamed from: e, reason: collision with root package name */
    private j.a f15103e;

    @Override // com.bumptech.glide.load.engine.cache.j
    @SuppressLint({"InlinedApi"})
    public void a(int i6) {
        if (i6 >= 40) {
            b();
        } else if (i6 >= 20 || i6 == 15) {
            o(getMaxSize() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.j
    public void f(@NonNull j.a aVar) {
        this.f15103e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.h
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public int k(@Nullable u<?> uVar) {
        return uVar == null ? super.k(null) : uVar.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.h
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(@NonNull com.bumptech.glide.load.c cVar, @Nullable u<?> uVar) {
        j.a aVar = this.f15103e;
        if (aVar == null || uVar == null) {
            return;
        }
        aVar.d(uVar);
    }

    public i(long j6) {
        super(j6);
    }

    @Override // com.bumptech.glide.load.engine.cache.j
    @Nullable
    public /* bridge */ /* synthetic */ u d(@NonNull com.bumptech.glide.load.c cVar, @Nullable u uVar) {
        return (u) super.m(cVar, uVar);
    }

    @Override // com.bumptech.glide.load.engine.cache.j
    @Nullable
    public /* bridge */ /* synthetic */ u e(@NonNull com.bumptech.glide.load.c cVar) {
        return (u) super.n(cVar);
    }
}
