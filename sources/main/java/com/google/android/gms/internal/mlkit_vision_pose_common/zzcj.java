package com.google.android.gms.internal.mlkit_vision_pose_common;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzcj extends OutputStream {
    private long zza = 0;

    @Override // java.io.OutputStream
    public final void write(int i6) {
        this.zza++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.zza += bArr.length;
    }

    final long zza() {
        return this.zza;
    }

    zzcj() {
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr, int i6, int i7) {
        int length;
        int i8;
        if (i6 >= 0 && i6 <= (length = bArr.length) && i7 >= 0 && (i8 = i6 + i7) <= length && i8 >= 0) {
            this.zza += i7;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
