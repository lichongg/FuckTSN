package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.model.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b<Data> implements n<byte[], Data> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0163b<Data> f15403a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements o<byte[], ByteBuffer> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bumptech.glide.load.model.b$a$a, reason: collision with other inner class name */
        class C0162a implements InterfaceC0163b<ByteBuffer> {
            C0162a() {
            }

            @Override // com.bumptech.glide.load.model.b.InterfaceC0163b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            @Override // com.bumptech.glide.load.model.b.InterfaceC0163b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<byte[], ByteBuffer> c(@NonNull r rVar) {
            return new b(new C0162a());
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.load.model.b$b, reason: collision with other inner class name */
    public interface InterfaceC0163b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f15405a;

        /* renamed from: b, reason: collision with root package name */
        private final InterfaceC0163b<Data> f15406b;

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f15406b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            aVar.d(this.f15406b.b(this.f15405a));
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        c(byte[] bArr, InterfaceC0163b<Data> interfaceC0163b) {
            this.f15405a = bArr;
            this.f15406b = interfaceC0163b;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d implements o<byte[], InputStream> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements InterfaceC0163b<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.model.b.InterfaceC0163b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.b.InterfaceC0163b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<byte[], InputStream> c(@NonNull r rVar) {
            return new b(new a());
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull byte[] bArr) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull byte[] bArr, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.e(bArr), new c(bArr, this.f15403a));
    }

    public b(InterfaceC0163b<Data> interfaceC0163b) {
        this.f15403a = interfaceC0163b;
    }
}
