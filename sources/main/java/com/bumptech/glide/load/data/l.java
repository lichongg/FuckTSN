package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f14954d = "LocalUriFetcher";

    /* renamed from: a, reason: collision with root package name */
    private final Uri f14955a;

    /* renamed from: b, reason: collision with root package name */
    private final ContentResolver f14956b;

    /* renamed from: c, reason: collision with root package name */
    private T f14957c;

    protected abstract void d(T t5) throws IOException;

    protected abstract T e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t5 = this.f14957c;
        if (t5 != null) {
            try {
                d(t5);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void c(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T e6 = e(this.f14955a, this.f14956b);
            this.f14957c = e6;
            aVar.d(e6);
        } catch (FileNotFoundException e7) {
            Log.isLoggable(f14954d, 3);
            aVar.e(e7);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public l(ContentResolver contentResolver, Uri uri) {
        this.f14956b = contentResolver;
        this.f14955a = uri;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
