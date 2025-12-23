package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.n;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: c, reason: collision with root package name */
    private static final String f15396c = "android_asset";

    /* renamed from: d, reason: collision with root package name */
    private static final String f15397d = "file:///android_asset/";

    /* renamed from: e, reason: collision with root package name */
    private static final int f15398e = 22;

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f15399a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0161a<Data> f15400b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.load.model.a$a, reason: collision with other inner class name */
    public interface InterfaceC0161a<Data> {
        com.bumptech.glide.load.data.d<Data> a(AssetManager assetManager, String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements o<Uri, ParcelFileDescriptor>, InterfaceC0161a<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f15401a;

        @Override // com.bumptech.glide.load.model.a.InterfaceC0161a
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.h(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> c(r rVar) {
            return new a(this.f15401a, this);
        }

        public b(AssetManager assetManager) {
            this.f15401a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c implements o<Uri, InputStream>, InterfaceC0161a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f15402a;

        @Override // com.bumptech.glide.load.model.a.InterfaceC0161a
        public com.bumptech.glide.load.data.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.m(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new a(this.f15402a, this);
        }

        public c(AssetManager assetManager) {
            this.f15402a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull Uri uri) {
        return master.flame.danmaku.danmaku.parser.b.f50156c.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && f15396c.equals(uri.getPathSegments().get(0));
    }

    public a(AssetManager assetManager, InterfaceC0161a<Data> interfaceC0161a) {
        this.f15399a = assetManager;
        this.f15400b = interfaceC0161a;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull Uri uri, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.e(uri), this.f15400b.a(this.f15399a, uri.toString().substring(f15398e)));
    }
}
