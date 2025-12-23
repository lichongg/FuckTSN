package com.danikula.videocache;

import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    public final File f32158a;

    /* renamed from: b, reason: collision with root package name */
    public final com.danikula.videocache.file.c f32159b;

    /* renamed from: c, reason: collision with root package name */
    public final com.danikula.videocache.file.a f32160c;

    /* renamed from: d, reason: collision with root package name */
    public final com.danikula.videocache.sourcestorage.c f32161d;

    File a(String str) {
        return new File(this.f32158a, this.f32159b.generate(str));
    }

    f(File file, com.danikula.videocache.file.c cVar, com.danikula.videocache.file.a aVar, com.danikula.videocache.sourcestorage.c cVar2) {
        this.f32158a = file;
        this.f32159b = cVar;
        this.f32160c = aVar;
        this.f32161d = cVar2;
    }
}
