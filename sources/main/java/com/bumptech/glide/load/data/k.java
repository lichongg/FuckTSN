package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.resource.bitmap.f0;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class k implements e<InputStream> {

    /* renamed from: b, reason: collision with root package name */
    private static final int f14951b = 5242880;

    /* renamed from: a, reason: collision with root package name */
    private final f0 f14952a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.bitmap_recycle.b f14953a;

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.f14953a);
        }

        public a(com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f14953a = bVar;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
        this.f14952a.release();
    }

    public void c() {
        this.f14952a.b();
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream a() throws IOException {
        this.f14952a.reset();
        return this.f14952a;
    }

    public k(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        f0 f0Var = new f0(inputStream, bVar);
        this.f14952a = f0Var;
        f0Var.mark(5242880);
    }
}
