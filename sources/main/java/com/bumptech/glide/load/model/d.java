package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d implements n<File, ByteBuffer> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15409a = "ByteBufferFileLoader";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements com.bumptech.glide.load.data.d<ByteBuffer> {

        /* renamed from: a, reason: collision with root package name */
        private final File f15410a;

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super ByteBuffer> aVar) {
            try {
                aVar.d(com.bumptech.glide.util.a.a(this.f15410a));
            } catch (IOException e6) {
                Log.isLoggable(d.f15409a, 3);
                aVar.e(e6);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        a(File file) {
            this.f15410a = file;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements o<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<File, ByteBuffer> c(@NonNull r rVar) {
            return new d();
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<ByteBuffer> a(@NonNull File file, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.e(file), new a(file));
    }
}
