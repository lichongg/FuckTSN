package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.n;
import com.bumptech.glide.load.model.o;
import com.bumptech.glide.load.model.r;
import com.bumptech.glide.load.resource.bitmap.o0;
import com.stub.StubApp;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e implements n<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f15495a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f15496a;

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new e(this.f15496a);
        }

        public a(Context context) {
            this.f15496a = context;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    private boolean e(com.bumptech.glide.load.f fVar) {
        Long l6 = (Long) fVar.c(o0.f15649g);
        return l6 != null && l6.longValue() == -1;
    }

    public e(Context context) {
        this.f15495a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.bumptech.glide.load.model.n
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@NonNull Uri uri, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        if (com.bumptech.glide.load.data.mediastore.b.d(i6, i7) && e(fVar)) {
            return new n.a<>(new com.bumptech.glide.signature.e(uri), com.bumptech.glide.load.data.mediastore.c.f(this.f15495a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull Uri uri) {
        return com.bumptech.glide.load.data.mediastore.b.c(uri);
    }
}
