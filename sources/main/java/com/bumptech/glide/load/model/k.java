package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class k implements n<Uri, File> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f15444a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements o<Uri, File> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f15445a;

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Uri, File> c(r rVar) {
            return new k(this.f15445a);
        }

        public a(Context context) {
            this.f15445a = context;
        }

        @Override // com.bumptech.glide.load.model.o
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements com.bumptech.glide.load.data.d<File> {

        /* renamed from: c, reason: collision with root package name */
        private static final String[] f15446c = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final Context f15447a;

        /* renamed from: b, reason: collision with root package name */
        private final Uri f15448b;

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<File> a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super File> aVar) {
            Cursor query = this.f15447a.getContentResolver().query(this.f15448b, f15446c, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                    query.close();
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(r0)) {
                aVar.d(new File(r0));
                return;
            }
            aVar.e(new FileNotFoundException("Failed to find file path for: " + this.f15448b));
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        b(Context context, Uri uri) {
            this.f15447a = context;
            this.f15448b = uri;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<File> a(@NonNull Uri uri, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.signature.e(uri), new b(this.f15444a, uri));
    }

    public k(Context context) {
        this.f15444a = context;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@NonNull Uri uri) {
        return com.bumptech.glide.load.data.mediastore.b.b(uri);
    }
}
