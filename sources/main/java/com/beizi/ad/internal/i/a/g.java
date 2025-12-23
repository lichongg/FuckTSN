package com.beizi.ad.internal.i.a;

import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g extends e {

    /* renamed from: a, reason: collision with root package name */
    private final long f12205a;

    @Override // com.beizi.ad.internal.i.a.e, com.beizi.ad.internal.i.a.a
    public /* bridge */ /* synthetic */ void a(File file) throws IOException {
        super.a(file);
    }

    @Override // com.beizi.ad.internal.i.a.e
    protected boolean a(File file, long j6, int i6) {
        return j6 <= this.f12205a;
    }

    public g(long j6) {
        if (j6 > 0) {
            this.f12205a = j6;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }
}
