package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.google.android.gms.internal.mlkit_vision_mediapipe.zzkk;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzkr<MessageType extends zzkr<MessageType, BuilderType>, BuilderType extends zzkk<MessageType, BuilderType>> extends zziv<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzmx zzc = zzmx.zzc();

    protected static final boolean zzG(zzkr zzkrVar, boolean z5) {
        byte byteValue = ((Byte) zzkrVar.zzb(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzmf.zza().zzb(zzkrVar.getClass()).zzk(zzkrVar);
        if (z5) {
            zzkrVar.zzb(2, true != zzk ? null : zzkrVar, null);
        }
        return zzk;
    }

    protected static zzkr zzu(zzkr zzkrVar, byte[] bArr) throws zzlb {
        int length = bArr.length;
        int i6 = zzkb.zzb;
        int i7 = zzmf.zza;
        zzkr zzf = zzf(zzkrVar, bArr, 0, length, zzkb.zza);
        zze(zzf);
        return zzf;
    }

    protected static zzkr zzv(zzkr zzkrVar, byte[] bArr, zzkb zzkbVar) throws zzlb {
        zzkr zzf = zzf(zzkrVar, bArr, 0, bArr.length, zzkbVar);
        zze(zzf);
        return zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlw
    public final /* synthetic */ zzlv zzJ() {
        return (zzkk) zzb(5, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlw
    public final /* synthetic */ zzlv zzK() {
        zzkk zzkkVar = (zzkk) zzb(5, null, null);
        zzkkVar.zzh(this);
        return zzkkVar;
    }

    protected abstract Object zzb(int i6, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlx
    public final /* synthetic */ zzlw zzm() {
        return (zzkr) zzb(6, null, null);
    }

    protected final zzkk zzo() {
        return (zzkk) zzb(5, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlx
    public final boolean zzp() {
        return zzG(this, true);
    }

    public final zzkk zzq() {
        zzkk zzkkVar = (zzkk) zzb(5, null, null);
        zzkkVar.zzh(this);
        return zzkkVar;
    }

    final zzkr zzt() {
        return (zzkr) zzb(4, null, null);
    }

    protected static Object zzB(zzlw zzlwVar, String str, Object[] objArr) {
        return new zzmh(zzlwVar, str, objArr);
    }

    private static zzkr zze(zzkr zzkrVar) throws zzlb {
        if (zzkrVar == null || zzG(zzkrVar, true)) {
            return zzkrVar;
        }
        throw new zzmv(zzkrVar).zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzkr zzf(zzkr zzkrVar, byte[] bArr, int i6, int i7, zzkb zzkbVar) throws zzlb {
        if (i7 == 0) {
            return zzkrVar;
        }
        zzkr zzt = zzkrVar.zzt();
        try {
            zzmi zzb2 = zzmf.zza().zzb(zzt.getClass());
            zzb2.zzh(zzt, bArr, 0, i7, new zzjd(zzkbVar));
            zzb2.zzf(zzt);
            return zzt;
        } catch (zzlb e6) {
            throw e6;
        } catch (zzmv e7) {
            throw e7.zza();
        } catch (IOException e8) {
            if (e8.getCause() instanceof zzlb) {
                throw ((zzlb) e8.getCause());
            }
            throw new zzlb(e8);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzlb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    static zzkr zzs(Class cls) {
        Map map = zzb;
        zzkr zzkrVar = (zzkr) map.get(cls);
        if (zzkrVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkrVar = (zzkr) map.get(cls);
            } catch (ClassNotFoundException e6) {
                throw new IllegalStateException("Class initialization cannot fail.", e6);
            }
        }
        if (zzkrVar != null) {
            return zzkrVar;
        }
        zzkr zzkrVar2 = (zzkr) ((zzkr) zznd.zze(cls)).zzb(6, null, null);
        if (zzkrVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzkrVar2);
        return zzkrVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzmf.zza().zzb(getClass()).zzj(this, (zzkr) obj);
    }

    final void zzD() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzF(int i6) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    final boolean zzH() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    static Object zzA(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e6);
        } catch (InvocationTargetException e7) {
            Throwable cause = e7.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    protected static void zzE(Class cls, zzkr zzkrVar) {
        zzkrVar.zzD();
        zzb.put(cls, zzkrVar);
    }

    private final int zzc(zzmi zzmiVar) {
        return zzmf.zza().zzb(getClass()).zza(this);
    }

    protected static zzkv zzw() {
        return zzki.zzf();
    }

    protected static zzkw zzx() {
        return zzks.zzf();
    }

    protected static zzkx zzy() {
        return zzll.zze();
    }

    protected static zzky zzz() {
        return zzmg.zze();
    }

    public final int hashCode() {
        if (!zzH()) {
            int i6 = this.zza;
            if (i6 == 0) {
                int zzl = zzl();
                this.zza = zzl;
                return zzl;
            }
            return i6;
        }
        return zzl();
    }

    public final String toString() {
        return zzly.zza(this, super.toString());
    }

    protected final void zzC() {
        zzmf.zza().zzb(getClass()).zzf(this);
        zzD();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlw
    public final void zzL(zzjw zzjwVar) throws IOException {
        zzmf.zza().zzb(getClass()).zzi(this, zzjx.zza(zzjwVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziv
    final int zzi(zzmi zzmiVar) {
        if (zzH()) {
            int zza = zzmiVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i6 = this.zzd & Integer.MAX_VALUE;
        if (i6 == Integer.MAX_VALUE) {
            int zza2 = zzmiVar.zza(this);
            if (zza2 >= 0) {
                this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
                return zza2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
        }
        return i6;
    }

    final int zzl() {
        return zzmf.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlw
    public final int zzn() {
        if (zzH()) {
            int zzc = zzc(null);
            if (zzc >= 0) {
                return zzc;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzc);
        }
        int i6 = this.zzd & Integer.MAX_VALUE;
        if (i6 != Integer.MAX_VALUE) {
            return i6;
        }
        int zzc2 = zzc(null);
        if (zzc2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zzc2;
            return zzc2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zzc2);
    }
}
