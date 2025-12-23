package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f<Data> implements n<File, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f15419b = "FileLoader";

    /* renamed from: a, reason: collision with root package name */
    private final d<Data> f15420a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a<Data> implements o<File, Data> {

        /* renamed from: a, reason: collision with root package name */
        private final d<Data> f15421a;

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public final n<File, Data> c(@NonNull r rVar) {
            return new f(this.f15421a);
        }

        public a(d<Data> dVar) {
            this.f15421a = dVar;
        }

        @Override // com.bumptech.glide.load.model.o
        public final void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b extends a<ParcelFileDescriptor> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements d<ParcelFileDescriptor> {
            @Override // com.bumptech.glide.load.model.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            @Override // com.bumptech.glide.load.model.f.d
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor open(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            a() {
            }

            @Override // com.bumptech.glide.load.model.f.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }
        }

        public b() {
            super(new a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final File f15422a;

        /* renamed from: b, reason: collision with root package name */
        private final d<Data> f15423b;

        /* renamed from: c, reason: collision with root package name */
        private Data f15424c;

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f15423b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            Data data = this.f15424c;
            if (data != null) {
                try {
                    this.f15423b.close(data);
                } catch (IOException unused) {
                }
            }
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data open = this.f15423b.open(this.f15422a);
                this.f15424c = open;
                aVar.d(open);
            } catch (FileNotFoundException e6) {
                Log.isLoggable(f.f15419b, 3);
                aVar.e(e6);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        c(File file, d<Data> dVar) {
            this.f15422a = file;
            this.f15423b = dVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d<Data> {
        Class<Data> a();

        void close(Data data) throws IOException;

        Data open(File file) throws FileNotFoundException;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class e extends a<InputStream> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements d<InputStream> {
            @Override // com.bumptech.glide.load.model.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.f.d
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream open(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }

            a() {
            }

            @Override // com.bumptech.glide.load.model.f.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }
        }

        public e() {
            super(new a());
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull File file, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.e(file), new c(file, this.f15420a));
    }

    public f(d<Data> dVar) {
        this.f15420a = dVar;
    }
}
