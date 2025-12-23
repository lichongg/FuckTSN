package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.engine.cache.d;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g extends d {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements d.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15099a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15100b;

        a(Context context, String str) {
            this.f15099a = context;
            this.f15100b = str;
        }

        @Nullable
        private File b() {
            File cacheDir = this.f15099a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f15100b != null ? new File(cacheDir, this.f15100b) : cacheDir;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            File b6 = b();
            if (b6 != null && b6.exists()) {
                return b6;
            }
            File externalCacheDir = this.f15099a.getExternalCacheDir();
            if (externalCacheDir != null && externalCacheDir.canWrite()) {
                if (this.f15100b != null) {
                    return new File(externalCacheDir, this.f15100b);
                }
                return externalCacheDir;
            }
            return b6;
        }
    }

    public g(Context context) {
        this(context, a.InterfaceC0153a.f15076b, 262144000L);
    }

    public g(Context context, long j6) {
        this(context, a.InterfaceC0153a.f15076b, j6);
    }

    public g(Context context, String str, long j6) {
        super(new a(context, str), j6);
    }
}
