package com.danikula.videocache.file;

import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends e {

    /* renamed from: c, reason: collision with root package name */
    private final int f32172c;

    @Override // com.danikula.videocache.file.e
    protected boolean b(File file, long j6, int i6) {
        return i6 <= this.f32172c;
    }

    public g(int i6) {
        if (i6 > 0) {
            this.f32172c = i6;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }
}
