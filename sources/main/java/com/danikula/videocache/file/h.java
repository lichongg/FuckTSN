package com.danikula.videocache.file;

import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class h extends e {

    /* renamed from: c, reason: collision with root package name */
    private final long f32173c;

    @Override // com.danikula.videocache.file.e
    protected boolean b(File file, long j6, int i6) {
        return j6 <= this.f32173c;
    }

    public h(long j6) {
        if (j6 > 0) {
            this.f32173c = j6;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }
}
