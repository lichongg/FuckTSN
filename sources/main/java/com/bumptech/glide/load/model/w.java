package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class w<Data> implements n<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f15521b = Collections.unmodifiableSet(new HashSet(Arrays.asList(master.flame.danmaku.danmaku.parser.b.f50156c, "android.resource", "content")));

    /* renamed from: a, reason: collision with root package name */
    private final c<Data> f15522a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f15523a;

        @Override // com.bumptech.glide.load.model.w.c
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.a(this.f15523a, uri);
        }

        @Override // com.bumptech.glide.load.model.o
        public n<Uri, AssetFileDescriptor> c(r rVar) {
            return new w(this);
        }

        public a(ContentResolver contentResolver) {
            this.f15523a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f15524a;

        @Override // com.bumptech.glide.load.model.w.c
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.i(this.f15524a, uri);
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> c(r rVar) {
            return new w(this);
        }

        public b(ContentResolver contentResolver) {
            this.f15524a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c<Data> {
        com.bumptech.glide.load.data.d<Data> a(Uri uri);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f15525a;

        @Override // com.bumptech.glide.load.model.w.c
        public com.bumptech.glide.load.data.d<InputStream> a(Uri uri) {
            return new com.bumptech.glide.load.data.n(this.f15525a, uri);
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new w(this);
        }

        public d(ContentResolver contentResolver) {
            this.f15525a = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull Uri uri, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.e(uri), this.f15522a.a(uri));
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull Uri uri) {
        return f15521b.contains(uri.getScheme());
    }

    public w(c<Data> cVar) {
        this.f15522a = cVar;
    }
}
