package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.m;
import com.bumptech.glide.load.model.n;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class a<Model> implements n<Model, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final n<com.bumptech.glide.load.model.g, InputStream> f15488a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final m<Model, com.bumptech.glide.load.model.g> f15489b;

    protected a(n<com.bumptech.glide.load.model.g, InputStream> nVar) {
        this(nVar, null);
    }

    protected abstract String f(Model model, int i6, int i7, com.bumptech.glide.load.f fVar);

    protected a(n<com.bumptech.glide.load.model.g, InputStream> nVar, @Nullable m<Model, com.bumptech.glide.load.model.g> mVar) {
        this.f15488a = nVar;
        this.f15489b = mVar;
    }

    private static List<com.bumptech.glide.load.c> c(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.bumptech.glide.load.model.g(it.next()));
        }
        return arrayList;
    }

    @Override // com.bumptech.glide.load.model.n
    @Nullable
    public n.a<InputStream> a(@NonNull Model model, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        m<Model, com.bumptech.glide.load.model.g> mVar = this.f15489b;
        com.bumptech.glide.load.model.g b6 = mVar != null ? mVar.b(model, i6, i7) : null;
        if (b6 == null) {
            String f6 = f(model, i6, i7, fVar);
            if (TextUtils.isEmpty(f6)) {
                return null;
            }
            com.bumptech.glide.load.model.g gVar = new com.bumptech.glide.load.model.g(f6, e(model, i6, i7, fVar));
            m<Model, com.bumptech.glide.load.model.g> mVar2 = this.f15489b;
            if (mVar2 != null) {
                mVar2.c(model, i6, i7, gVar);
            }
            b6 = gVar;
        }
        List<String> d6 = d(model, i6, i7, fVar);
        n.a<InputStream> a6 = this.f15488a.a(b6, i6, i7, fVar);
        return (a6 == null || d6.isEmpty()) ? a6 : new n.a<>(a6.f15456a, c(d6), a6.f15458c);
    }

    protected List<String> d(Model model, int i6, int i7, com.bumptech.glide.load.f fVar) {
        return Collections.EMPTY_LIST;
    }

    @Nullable
    protected com.bumptech.glide.load.model.h e(Model model, int i6, int i7, com.bumptech.glide.load.f fVar) {
        return com.bumptech.glide.load.model.h.f15434b;
    }
}
