package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdb extends IOException {
    zzdb() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzdb(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    zzdb(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
