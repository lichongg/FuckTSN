package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.n;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: c, reason: collision with root package name */
    private static final String f15481c = "ResourceLoader";

    /* renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f15482a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f15483b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f15484a;

        @Override // com.bumptech.glide.load.model.o
        public n<Integer, AssetFileDescriptor> c(r rVar) {
            return new s(this.f15484a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }

        public a(Resources resources) {
            this.f15484a = resources;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f15485a;

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Integer, ParcelFileDescriptor> c(r rVar) {
            return new s(this.f15485a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }

        public b(Resources resources) {
            this.f15485a = resources;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f15486a;

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Integer, InputStream> c(r rVar) {
            return new s(this.f15486a, rVar.d(Uri.class, InputStream.class));
        }

        public c(Resources resources) {
            this.f15486a = resources;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f15487a;

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Integer, Uri> c(r rVar) {
            return new s(this.f15487a, v.c());
        }

        public d(Resources resources) {
            this.f15487a = resources;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull Integer num) {
        return true;
    }

    @Nullable
    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f15483b.getResourcePackageName(num.intValue()) + '/' + this.f15483b.getResourceTypeName(num.intValue()) + '/' + this.f15483b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException unused) {
            Log.isLoggable(f15481c, 5);
            return null;
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f15483b = resources;
        this.f15482a = nVar;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull Integer num, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        Uri d6 = d(num);
        if (d6 == null) {
            return null;
        }
        return this.f15482a.a(d6, i6, i7, fVar);
    }
}
