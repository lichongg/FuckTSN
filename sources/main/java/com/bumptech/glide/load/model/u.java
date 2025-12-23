package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class u<Data> implements n<String, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f15517a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.model.o
        public n<String, AssetFileDescriptor> c(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<String, ParcelFileDescriptor> c(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c implements o<String, InputStream> {
        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<String, InputStream> c(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull String str) {
        return true;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    public u(n<Uri, Data> nVar) {
        this.f15517a = nVar;
    }

    @Nullable
    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null) {
            return f(str);
        }
        return parse;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull String str, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        Uri e6 = e(str);
        if (e6 != null && this.f15517a.b(e6)) {
            return this.f15517a.a(e6, i6, i7, fVar);
        }
        return null;
    }
}
