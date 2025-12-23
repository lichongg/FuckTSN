package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbi implements ValueEncoderContext {
    private boolean zza = false;
    private boolean zzb = false;
    private FieldDescriptor zzc;
    private final zzbe zzd;

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(double d6) throws IOException {
        zzb();
        this.zzd.zza(this.zzc, d6, this.zzb);
        return this;
    }

    final void zza(FieldDescriptor fieldDescriptor, boolean z5) {
        this.zza = false;
        this.zzc = fieldDescriptor;
        this.zzb = z5;
    }

    private final void zzb() {
        if (this.zza) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.zza = true;
    }

    zzbi(zzbe zzbeVar) {
        this.zzd = zzbeVar;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(float f6) throws IOException {
        zzb();
        this.zzd.zzb(this.zzc, f6, this.zzb);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(int i6) throws IOException {
        zzb();
        this.zzd.zzd(this.zzc, i6, this.zzb);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(long j6) throws IOException {
        zzb();
        this.zzd.zze(this.zzc, j6, this.zzb);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(@Nullable String str) throws IOException {
        zzb();
        this.zzd.zzc(this.zzc, str, this.zzb);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(boolean z5) throws IOException {
        zzb();
        this.zzd.zzd(this.zzc, z5 ? 1 : 0, this.zzb);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(@NonNull byte[] bArr) throws IOException {
        zzb();
        this.zzd.zzc(this.zzc, bArr, this.zzb);
        return this;
    }
}
