package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d<T> implements i<T> {

    /* renamed from: c, reason: collision with root package name */
    private final Collection<? extends i<T>> f14920c;

    @SafeVarargs
    public d(@NonNull i<T>... iVarArr) {
        if (iVarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f14920c = Arrays.asList(iVarArr);
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public u<T> a(@NonNull Context context, @NonNull u<T> uVar, int i6, int i7) {
        Iterator<? extends i<T>> it = this.f14920c.iterator();
        u<T> uVar2 = uVar;
        while (it.hasNext()) {
            u<T> a6 = it.next().a(context, uVar2, i6, i7);
            if (uVar2 != null && !uVar2.equals(uVar) && !uVar2.equals(a6)) {
                uVar2.recycle();
            }
            uVar2 = a6;
        }
        return uVar2;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        Iterator<? extends i<T>> it = this.f14920c.iterator();
        while (it.hasNext()) {
            it.next().b(messageDigest);
        }
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f14920c.equals(((d) obj).f14920c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f14920c.hashCode();
    }

    public d(@NonNull Collection<? extends i<T>> collection) {
        if (!collection.isEmpty()) {
            this.f14920c = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
