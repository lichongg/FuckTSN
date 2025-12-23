package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzo extends zzm {
    static final int zza = Integer.numberOfLeadingZeros(31);
    static final zzp zzb = new zzo();

    zzo() {
        super("CharMatcher.whitespace()");
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzp
    public final boolean zza(char c6) {
        if ("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c6) >>> zza) == c6) {
            return true;
        }
        return false;
    }
}
