package com.bumptech.glide.load.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class x<Data> implements n<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f15526b = Collections.unmodifiableSet(new HashSet(Arrays.asList(master.flame.danmaku.danmaku.parser.b.f50154a, master.flame.danmaku.danmaku.parser.b.f50155b)));

    /* renamed from: a, reason: collision with root package name */
    private final n<g, Data> f15527a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements o<Uri, InputStream> {
        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new x(rVar.d(g.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull Uri uri, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return this.f15527a.a(new g(uri.toString()), i6, i7, fVar);
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull Uri uri) {
        return f15526b.contains(uri.getScheme());
    }

    public x(n<g, Data> nVar) {
        this.f15527a = nVar;
    }
}
