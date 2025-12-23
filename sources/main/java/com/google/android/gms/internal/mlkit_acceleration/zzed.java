package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzed extends IOException {
    private zzfa zza;
    private boolean zzb;

    public zzed(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.zza = null;
    }

    final void zzk() {
        this.zzb = true;
    }

    public zzed(String str) {
        super(str);
        this.zza = null;
    }

    static zzec zza() {
        return new zzec("Protocol message tag had invalid wire type.");
    }

    static zzed zzb() {
        return new zzed("Protocol message end-group tag did not match expected tag.");
    }

    static zzed zzc() {
        return new zzed("Protocol message contained an invalid tag (zero).");
    }

    static zzed zzd() {
        return new zzed("Protocol message had invalid UTF-8.");
    }

    static zzed zze() {
        return new zzed("CodedInputStream encountered a malformed varint.");
    }

    static zzed zzf() {
        return new zzed("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzed zzg() {
        return new zzed("Failed to parse the message.");
    }

    static zzed zzi() {
        return new zzed("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzed zzj() {
        return new zzed("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzed zzh(zzfa zzfaVar) {
        this.zza = zzfaVar;
        return this;
    }

    final boolean zzl() {
        return this.zzb;
    }
}
