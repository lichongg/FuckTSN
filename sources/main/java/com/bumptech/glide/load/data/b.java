package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f14923d = "AssetPathFetcher";

    /* renamed from: a, reason: collision with root package name */
    private final String f14924a;

    /* renamed from: b, reason: collision with root package name */
    private final AssetManager f14925b;

    /* renamed from: c, reason: collision with root package name */
    private T f14926c;

    protected abstract void d(T t5) throws IOException;

    protected abstract T e(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t5 = this.f14926c;
        if (t5 == null) {
            return;
        }
        try {
            d(t5);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void c(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T e6 = e(this.f14925b, this.f14924a);
            this.f14926c = e6;
            aVar.d(e6);
        } catch (IOException e7) {
            Log.isLoggable(f14923d, 3);
            aVar.e(e7);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public b(AssetManager assetManager, String str) {
        this.f14925b = assetManager;
        this.f14924a = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
