package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c implements com.bumptech.glide.load.data.d<InputStream> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f14960d = "MediaStoreThumbFetcher";

    /* renamed from: a, reason: collision with root package name */
    private final Uri f14961a;

    /* renamed from: b, reason: collision with root package name */
    private final e f14962b;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f14963c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements d {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f14964b = {"_data"};

        /* renamed from: c, reason: collision with root package name */
        private static final String f14965c = "kind = 1 AND image_id = ?";

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f14966a;

        a(ContentResolver contentResolver) {
            this.f14966a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.d
        public Cursor query(Uri uri) {
            return this.f14966a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f14964b, f14965c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements d {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f14967b = {"_data"};

        /* renamed from: c, reason: collision with root package name */
        private static final String f14968c = "kind = 1 AND video_id = ?";

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f14969a;

        b(ContentResolver contentResolver) {
            this.f14969a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.d
        public Cursor query(Uri uri) {
            return this.f14969a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f14967b, f14968c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public static c e(Context context, Uri uri) {
        return d(context, uri, new a(context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return d(context, uri, new b(context.getContentResolver()));
    }

    private InputStream g() throws FileNotFoundException {
        InputStream d6 = this.f14962b.d(this.f14961a);
        int a6 = d6 != null ? this.f14962b.a(this.f14961a) : -1;
        return a6 != -1 ? new g(d6, a6) : d6;
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f14963c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @VisibleForTesting
    c(Uri uri, e eVar) {
        this.f14961a = uri;
        this.f14962b = eVar;
    }

    private static c d(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.b.e(context).m().g(), dVar, com.bumptech.glide.b.e(context).g(), context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.d
    public void c(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        try {
            InputStream g6 = g();
            this.f14963c = g6;
            aVar.d(g6);
        } catch (FileNotFoundException e6) {
            Log.isLoggable(f14960d, 3);
            aVar.e(e6);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
