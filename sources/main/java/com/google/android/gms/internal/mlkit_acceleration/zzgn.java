package com.google.android.gms.internal.mlkit_acceleration;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzgn {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzgm zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARN: Removed duplicated region for block: B:15:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    static {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_acceleration.zzgn.<clinit>():void");
    }

    private static int zzA(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i6 = zzce.zza;
        Field zzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(Buffer.class, "address");
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzD(Object obj, long j6, byte b6) {
        zzgm zzgmVar = zzf;
        long j7 = (-4) & j6;
        int i6 = zzgmVar.zza.getInt(obj, j7);
        int i7 = ((~((int) j6)) & 3) << 3;
        zzgmVar.zza.putInt(obj, j7, ((255 & b6) << i7) | (i6 & (~(255 << i7))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzE(Object obj, long j6, byte b6) {
        zzgm zzgmVar = zzf;
        long j7 = (-4) & j6;
        int i6 = (((int) j6) & 3) << 3;
        zzgmVar.zza.putInt(obj, j7, ((255 & b6) << i6) | (zzgmVar.zza.getInt(obj, j7) & (~(255 << i6))));
    }

    static double zza(Object obj, long j6) {
        return zzf.zza(obj, j6);
    }

    static float zzb(Object obj, long j6) {
        return zzf.zzb(obj, j6);
    }

    static int zzc(Object obj, long j6) {
        return zzf.zza.getInt(obj, j6);
    }

    static long zzd(Object obj, long j6) {
        return zzf.zza.getLong(obj, j6);
    }

    static Object zze(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e6) {
            throw new IllegalStateException(e6);
        }
    }

    static Object zzf(Object obj, long j6) {
        return zzf.zza.getObject(obj, j6);
    }

    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzgj());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* bridge */ /* synthetic */ void zzh(Throwable th) {
        Logger.getLogger(zzgn.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    static void zzm(Object obj, long j6, boolean z5) {
        zzf.zzc(obj, j6, z5);
    }

    static void zzn(byte[] bArr, long j6, byte b6) {
        zzf.zzd(bArr, zza + j6, b6);
    }

    static void zzo(Object obj, long j6, double d6) {
        zzf.zze(obj, j6, d6);
    }

    static void zzp(Object obj, long j6, float f6) {
        zzf.zzf(obj, j6, f6);
    }

    static void zzq(Object obj, long j6, int i6) {
        zzf.zza.putInt(obj, j6, i6);
    }

    static void zzr(Object obj, long j6, long j7) {
        zzf.zza.putLong(obj, j6, j7);
    }

    static void zzs(Object obj, long j6, Object obj2) {
        zzf.zza.putObject(obj, j6, obj2);
    }

    static /* bridge */ /* synthetic */ boolean zzt(Object obj, long j6) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j6) >>> ((int) (((~j6) & 3) << 3))) & 255)) != 0;
    }

    static /* bridge */ /* synthetic */ boolean zzu(Object obj, long j6) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j6) >>> ((int) ((j6 & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean zzv(Class cls) {
        int i6 = zzce.zza;
        try {
            Class cls2 = zzd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzw(Object obj, long j6) {
        return zzf.zzg(obj, j6);
    }

    static boolean zzx() {
        return zzh;
    }

    static boolean zzy() {
        return zzg;
    }

    private static int zzz(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private zzgn() {
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
