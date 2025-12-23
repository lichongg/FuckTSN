package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.a;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d implements a.InterfaceC0153a {

    /* renamed from: c, reason: collision with root package name */
    private final long f15083c;

    /* renamed from: d, reason: collision with root package name */
    private final c f15084d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15085a;

        a(String str) {
            this.f15085a = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            return new File(this.f15085a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15086a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15087b;

        b(String str, String str2) {
            this.f15086a = str;
            this.f15087b = str2;
        }

        @Override // com.bumptech.glide.load.engine.cache.d.c
        public File a() {
            return new File(this.f15086a, this.f15087b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        File a();
    }

    public d(String str, long j6) {
        this(new a(str), j6);
    }

    public d(String str, String str2, long j6) {
        this(new b(str, str2), j6);
    }

    @Override // com.bumptech.glide.load.engine.cache.a.InterfaceC0153a
    public com.bumptech.glide.load.engine.cache.a build() {
        File a6 = this.f15084d.a();
        if (a6 == null) {
            return null;
        }
        if (a6.isDirectory() || a6.mkdirs()) {
            return e.c(a6, this.f15083c);
        }
        return null;
    }

    public d(c cVar, long j6) {
        this.f15083c = j6;
        this.f15084d = cVar;
    }
}
