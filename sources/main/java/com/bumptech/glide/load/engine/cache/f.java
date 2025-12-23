package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.engine.cache.d;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes3.dex */
public final class f extends d {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements d.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15097a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15098b;

        a(Context context, String str) {
            this.f15097a = context;
            this.f15098b = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            File externalCacheDir = this.f15097a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.f15098b != null ? new File(externalCacheDir, this.f15098b) : externalCacheDir;
        }
    }

    public f(Context context) {
        this(context, a.InterfaceC0153a.f15076b, a.InterfaceC0153a.f15075a);
    }

    public f(Context context, int i6) {
        this(context, a.InterfaceC0153a.f15076b, i6);
    }

    public f(Context context, String str, int i6) {
        super(new a(context, str), i6);
    }
}
