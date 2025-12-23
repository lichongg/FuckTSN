package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.n;
import com.bumptech.glide.load.model.o;
import com.bumptech.glide.load.model.r;
import com.stub.StubApp;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d implements n<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f15493a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f15494a;

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new d(this.f15494a);
        }

        public a(Context context) {
            this.f15494a = context;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    public d(Context context) {
        this.f15493a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@NonNull Uri uri, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        if (com.bumptech.glide.load.data.mediastore.b.d(i6, i7)) {
            return new n.a<>(new com.bumptech.glide.signature.e(uri), com.bumptech.glide.load.data.mediastore.c.e(this.f15493a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull Uri uri) {
        return com.bumptech.glide.load.data.mediastore.b.a(uri);
    }
}
