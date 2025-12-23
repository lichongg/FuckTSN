package com.bumptech.glide.load.model;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.model.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f15411b = "data:image";

    /* renamed from: c, reason: collision with root package name */
    private static final String f15412c = ";base64";

    /* renamed from: a, reason: collision with root package name */
    private final a<Data> f15413a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<Data> {
        Class<Data> a();

        void close(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final String f15414a;

        /* renamed from: b, reason: collision with root package name */
        private final a<Data> f15415b;

        /* renamed from: c, reason: collision with root package name */
        private Data f15416c;

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f15415b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            try {
                this.f15415b.close(this.f15416c);
            } catch (IOException unused) {
            }
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data decode = this.f15415b.decode(this.f15414a);
                this.f15416c = decode;
                aVar.d(decode);
            } catch (IllegalArgumentException e6) {
                aVar.e(e6);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        b(String str, a<Data> aVar) {
            this.f15414a = str;
            this.f15415b = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final a<InputStream> f15417a = new a();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements a<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.model.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.e.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream decode(String str) {
                if (!str.startsWith(e.f15411b)) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, indexOf).endsWith(e.f15412c)) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }

            @Override // com.bumptech.glide.load.model.e.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Model, InputStream> c(@NonNull r rVar) {
            return new e(this.f15417a);
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    @Override // com.bumptech.glide.load.model.n
    public n.a<Data> a(@NonNull Model model, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.e(model), new b(model.toString(), this.f15413a));
    }

    public e(a<Data> aVar) {
        this.f15413a = aVar;
    }

    @Override // com.bumptech.glide.load.model.n
    public boolean b(@NonNull Model model) {
        return model.toString().startsWith(f15411b);
    }
}
