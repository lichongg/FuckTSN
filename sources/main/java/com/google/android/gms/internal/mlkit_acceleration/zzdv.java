package com.google.android.gms.internal.mlkit_acceleration;

import com.google.android.gms.internal.mlkit_acceleration.zzdr;
import com.google.android.gms.internal.mlkit_acceleration.zzdv;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzdv<MessageType extends zzdv<MessageType, BuilderType>, BuilderType extends zzdr<MessageType, BuilderType>> extends zzcc<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzge zzc = zzge.zzc();

    protected static zzdv zzD(zzdv zzdvVar, byte[] bArr, zzdi zzdiVar) throws zzed {
        zzdv zzc = zzc(zzdvVar, bArr, 0, bArr.length, zzdiVar);
        zzb(zzc);
        return zzc;
    }

    final zzdv zzB() {
        return (zzdv) zzo(4, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfa
    public final /* synthetic */ zzez zzF() {
        return (zzdr) zzo(5, null, null);
    }

    public final boolean zzN() {
        byte byteValue = ((Byte) zzo(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzfi.zza().zzb(getClass()).zzl(this);
        zzo(2, true != zzl ? null : this, null);
        return zzl;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfb
    public final /* synthetic */ zzfa zzP() {
        return (zzdv) zzo(6, null, null);
    }

    protected abstract Object zzo(int i6, Object obj, Object obj2);

    protected final zzdr zzy() {
        return (zzdr) zzo(5, null, null);
    }

    public final zzdr zzz() {
        zzdr zzdrVar = (zzdr) zzo(5, null, null);
        zzdrVar.zzk(this);
        return zzdrVar;
    }

    static zzdv zzA(Class cls) {
        Map map = zzb;
        zzdv zzdvVar = (zzdv) map.get(cls);
        if (zzdvVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzdvVar = (zzdv) map.get(cls);
            } catch (ClassNotFoundException e6) {
                throw new IllegalStateException("Class initialization cannot fail.", e6);
            }
        }
        if (zzdvVar != null) {
            return zzdvVar;
        }
        zzdv zzdvVar2 = (zzdv) ((zzdv) zzgn.zze(cls)).zzo(6, null, null);
        if (zzdvVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzdvVar2);
        return zzdvVar2;
    }

    protected static zzdv zzC(zzdv zzdvVar, InputStream inputStream, zzdi zzdiVar) throws zzed {
        zzcy zzcwVar;
        int i6 = zzcy.zzd;
        if (inputStream == null) {
            byte[] bArr = zzeb.zzd;
            int length = bArr.length;
            zzcwVar = zzcy.zzH(bArr, 0, 0, false);
        } else {
            zzcwVar = new zzcw(inputStream, 4096, null);
        }
        zzdv zzB = zzdvVar.zzB();
        try {
            zzfm zzb2 = zzfi.zza().zzb(zzB.getClass());
            zzb2.zzh(zzB, zzcz.zzq(zzcwVar), zzdiVar);
            zzb2.zzf(zzB);
            zzb(zzB);
            return zzB;
        } catch (zzed e6) {
            e = e6;
            if (e.zzl()) {
                e = new zzed(e);
            }
            e.zzh(zzB);
            throw e;
        } catch (zzgc e7) {
            zzed zza = e7.zza();
            zza.zzh(zzB);
            throw zza;
        } catch (IOException e8) {
            if (e8.getCause() instanceof zzed) {
                throw ((zzed) e8.getCause());
            }
            zzed zzedVar = new zzed(e8);
            zzedVar.zzh(zzB);
            throw zzedVar;
        } catch (RuntimeException e9) {
            if (e9.getCause() instanceof zzed) {
                throw ((zzed) e9.getCause());
            }
            throw e9;
        }
    }

    protected static Object zzH(zzfa zzfaVar, String str, Object[] objArr) {
        return new zzfk(zzfaVar, str, objArr);
    }

    private static zzdv zzb(zzdv zzdvVar) throws zzed {
        if (zzdvVar == null || zzdvVar.zzN()) {
            return zzdvVar;
        }
        zzed zza = new zzgc(zzdvVar).zza();
        zza.zzh(zzdvVar);
        throw zza;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzfi.zza().zzb(getClass()).zzk(this, (zzdv) obj);
    }

    final void zzJ() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzL(int i6) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    final boolean zzO() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    protected static zzea zzE() {
        return zzfj.zze();
    }

    static Object zzG(Method method, Object obj, Object... objArr) {
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

    protected static void zzK(Class cls, zzdv zzdvVar) {
        zzdvVar.zzJ();
        zzb.put(cls, zzdvVar);
    }

    private final int zza(zzfm zzfmVar) {
        return zzfi.zza().zzb(getClass()).zza(this);
    }

    private static zzdv zzc(zzdv zzdvVar, byte[] bArr, int i6, int i7, zzdi zzdiVar) throws zzed {
        zzdv zzB = zzdvVar.zzB();
        try {
            zzfm zzb2 = zzfi.zza().zzb(zzB.getClass());
            zzb2.zzi(zzB, bArr, 0, i7, new zzcf(zzdiVar));
            zzb2.zzf(zzB);
            return zzB;
        } catch (zzed e6) {
            zzed zzedVar = e6;
            if (zzedVar.zzl()) {
                zzedVar = new zzed(zzedVar);
            }
            zzedVar.zzh(zzB);
            throw zzedVar;
        } catch (zzgc e7) {
            zzed zza = e7.zza();
            zza.zzh(zzB);
            throw zza;
        } catch (IOException e8) {
            if (e8.getCause() instanceof zzed) {
                throw ((zzed) e8.getCause());
            }
            zzed zzedVar2 = new zzed(e8);
            zzedVar2.zzh(zzB);
            throw zzedVar2;
        } catch (IndexOutOfBoundsException unused) {
            zzed zzj = zzed.zzj();
            zzj.zzh(zzB);
            throw zzj;
        }
    }

    public final int hashCode() {
        if (!zzO()) {
            int i6 = this.zza;
            if (i6 == 0) {
                int zzw = zzw();
                this.zza = zzw;
                return zzw;
            }
            return i6;
        }
        return zzw();
    }

    public final String toString() {
        return zzfc.zza(this, super.toString());
    }

    protected final void zzI() {
        zzfi.zza().zzb(getClass()).zzf(this);
        zzJ();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfa
    public final void zzM(zzdd zzddVar) throws IOException {
        zzfi.zza().zzb(getClass()).zzj(this, zzde.zza(zzddVar));
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcc
    final int zzt(zzfm zzfmVar) {
        if (zzO()) {
            int zza = zzfmVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i6 = this.zzd & Integer.MAX_VALUE;
        if (i6 == Integer.MAX_VALUE) {
            int zza2 = zzfmVar.zza(this);
            if (zza2 >= 0) {
                this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
                return zza2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
        }
        return i6;
    }

    final int zzw() {
        return zzfi.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfa
    public final int zzx() {
        if (zzO()) {
            int zza = zza(null);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i6 = this.zzd & Integer.MAX_VALUE;
        if (i6 != Integer.MAX_VALUE) {
            return i6;
        }
        int zza2 = zza(null);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }
}
