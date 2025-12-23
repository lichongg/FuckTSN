package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.u;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class j0 implements com.bumptech.glide.load.g<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final u f15620a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f15621b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements u.b {

        /* renamed from: a, reason: collision with root package name */
        private final f0 f15622a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.util.d f15623b;

        @Override // com.bumptech.glide.load.resource.bitmap.u.b
        public void a() {
            this.f15622a.b();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.u.b
        public void b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) throws IOException {
            IOException b6 = this.f15623b.b();
            if (b6 != null) {
                if (bitmap == null) {
                    throw b6;
                }
                eVar.d(bitmap);
                throw b6;
            }
        }

        a(f0 f0Var, com.bumptech.glide.util.d dVar) {
            this.f15622a = f0Var;
            this.f15623b = dVar;
        }
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull InputStream inputStream, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        f0 f0Var;
        boolean z5;
        if (inputStream instanceof f0) {
            f0Var = (f0) inputStream;
            z5 = false;
        } else {
            f0Var = new f0(inputStream, this.f15621b);
            z5 = true;
        }
        com.bumptech.glide.util.d c6 = com.bumptech.glide.util.d.c(f0Var);
        try {
            com.bumptech.glide.load.engine.u<Bitmap> g6 = this.f15620a.g(new com.bumptech.glide.util.i(c6), i6, i7, fVar, new a(f0Var, c6));
            c6.release();
            if (z5) {
                f0Var.release();
            }
            return g6;
        } finally {
        }
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.f fVar) {
        return this.f15620a.p(inputStream);
    }

    public j0(u uVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f15620a = uVar;
        this.f15621b = bVar;
    }
}
