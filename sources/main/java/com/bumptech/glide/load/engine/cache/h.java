package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.engine.cache.d;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class h extends d {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements d.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15101a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15102b;

        a(Context context, String str) {
            this.f15101a = context;
            this.f15102b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            File cacheDir = this.f15101a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f15102b != null ? new File(cacheDir, this.f15102b) : cacheDir;
        }
    }

    public h(Context context) {
        this(context, a.InterfaceC0153a.f15076b, 262144000L);
    }

    public h(Context context, long j6) {
        this(context, a.InterfaceC0153a.f15076b, j6);
    }

    public h(Context context, String str, long j6) {
        super(new a(context, str), j6);
    }
}
