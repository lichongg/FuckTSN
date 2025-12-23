package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzcz implements zzfl {
    private final zzcy zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final zzcs zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzt(Object obj, zzfm zzfmVar, zzdi zzdiVar) throws IOException {
        zzS(3);
        zzP(obj, zzfmVar, zzdiVar);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzu(Object obj, zzfm zzfmVar, zzdi zzdiVar) throws IOException {
        zzS(2);
        zzQ(obj, zzfmVar, zzdiVar);
    }

    private final void zzP(Object obj, zzfm zzfmVar, zzdi zzdiVar) throws IOException {
        int i6 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzfmVar.zzh(obj, this, zzdiVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzed.zzg();
            }
        } finally {
            this.zzc = i6;
        }
    }

    private final void zzQ(Object obj, zzfm zzfmVar, zzdi zzdiVar) throws IOException {
        zzcy zzcyVar = this.zza;
        int zzn = zzcyVar.zzn();
        if (zzcyVar.zza >= zzcyVar.zzb) {
            throw new zzed("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zze = this.zza.zze(zzn);
        this.zza.zza++;
        zzfmVar.zzh(obj, this, zzdiVar);
        this.zza.zzz(0);
        r4.zza--;
        this.zza.zzA(zze);
    }

    private final void zzR(int i6) throws IOException {
        if (this.zza.zzd() != i6) {
            throw zzed.zzj();
        }
    }

    private final void zzS(int i6) throws IOException {
        if ((this.zzb & 7) != i6) {
            throw zzed.zza();
        }
    }

    private static final void zzT(int i6) throws IOException {
        if ((i6 & 3) != 0) {
            throw zzed.zzg();
        }
    }

    private static final void zzU(int i6) throws IOException {
        if ((i6 & 7) != 0) {
            throw zzed.zzg();
        }
    }

    public static zzcz zzq(zzcy zzcyVar) {
        zzcz zzczVar = zzcyVar.zzc;
        return zzczVar != null ? zzczVar : new zzcz(zzcyVar);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzA(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzep) {
            zzep zzepVar = (zzep) list;
            int i7 = this.zzb & 7;
            if (i7 != 1) {
                if (i7 != 2) {
                    throw zzed.zza();
                }
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzepVar.zzf(this.zza.zzo());
                } while (this.zza.zzd() < zzd);
                return;
            }
            do {
                zzepVar.zzf(this.zza.zzo());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 != 1) {
                if (i8 != 2) {
                    throw zzed.zza();
                }
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzB(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzdp) {
            zzdp zzdpVar = (zzdp) list;
            int i7 = this.zzb & 7;
            if (i7 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzdpVar.zze(this.zza.zzc());
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i7 != 5) {
                throw zzed.zza();
            }
            do {
                zzdpVar.zze(this.zza.zzc());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            if (i8 != 5) {
                throw zzed.zza();
            }
            do {
                list.add(Float.valueOf(this.zza.zzc()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    @Deprecated
    public final void zzC(List list, zzfm zzfmVar, zzdi zzdiVar) throws IOException {
        int zzm;
        int i6 = this.zzb;
        if ((i6 & 7) != 3) {
            throw zzed.zza();
        }
        do {
            Object zze = zzfmVar.zze();
            zzP(zze, zzfmVar, zzdiVar);
            zzfmVar.zzf(zze);
            list.add(zze);
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == i6);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzD(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzdw) {
            zzdw zzdwVar = (zzdw) list;
            int i7 = this.zzb & 7;
            if (i7 != 0) {
                if (i7 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar = this.zza;
                int zzd = zzcyVar.zzd() + zzcyVar.zzn();
                do {
                    zzdwVar.zzf(this.zza.zzh());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzdwVar.zzf(this.zza.zzh());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 != 0) {
                if (i8 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar2 = this.zza;
                int zzd2 = zzcyVar2.zzd() + zzcyVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzE(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzep) {
            zzep zzepVar = (zzep) list;
            int i7 = this.zzb & 7;
            if (i7 != 0) {
                if (i7 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar = this.zza;
                int zzd = zzcyVar.zzd() + zzcyVar.zzn();
                do {
                    zzepVar.zzf(this.zza.zzp());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzepVar.zzf(this.zza.zzp());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 != 0) {
                if (i8 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar2 = this.zza;
                int zzd2 = zzcyVar2.zzd() + zzcyVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzF(List list, zzfm zzfmVar, zzdi zzdiVar) throws IOException {
        int zzm;
        int i6 = this.zzb;
        if ((i6 & 7) != 2) {
            throw zzed.zza();
        }
        do {
            Object zze = zzfmVar.zze();
            zzQ(zze, zzfmVar, zzdiVar);
            zzfmVar.zzf(zze);
            list.add(zze);
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == i6);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzG(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzdw) {
            zzdw zzdwVar = (zzdw) list;
            int i7 = this.zzb & 7;
            if (i7 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzdwVar.zzf(this.zza.zzk());
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i7 != 5) {
                throw zzed.zza();
            }
            do {
                zzdwVar.zzf(this.zza.zzk());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            if (i8 != 5) {
                throw zzed.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzk()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzH(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzep) {
            zzep zzepVar = (zzep) list;
            int i7 = this.zzb & 7;
            if (i7 != 1) {
                if (i7 != 2) {
                    throw zzed.zza();
                }
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzepVar.zzf(this.zza.zzt());
                } while (this.zza.zzd() < zzd);
                return;
            }
            do {
                zzepVar.zzf(this.zza.zzt());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 != 1) {
                if (i8 != 2) {
                    throw zzed.zza();
                }
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzt()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzI(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzdw) {
            zzdw zzdwVar = (zzdw) list;
            int i7 = this.zzb & 7;
            if (i7 != 0) {
                if (i7 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar = this.zza;
                int zzd = zzcyVar.zzd() + zzcyVar.zzn();
                do {
                    zzdwVar.zzf(this.zza.zzl());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzdwVar.zzf(this.zza.zzl());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 != 0) {
                if (i8 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar2 = this.zza;
                int zzd2 = zzcyVar2.zzd() + zzcyVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzl()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzJ(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzep) {
            zzep zzepVar = (zzep) list;
            int i7 = this.zzb & 7;
            if (i7 != 0) {
                if (i7 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar = this.zza;
                int zzd = zzcyVar.zzd() + zzcyVar.zzn();
                do {
                    zzepVar.zzf(this.zza.zzu());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzepVar.zzf(this.zza.zzu());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 != 0) {
                if (i8 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar2 = this.zza;
                int zzd2 = zzcyVar2.zzd() + zzcyVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzu()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    public final void zzK(List list, boolean z5) throws IOException {
        int zzm;
        int i6;
        if ((this.zzb & 7) != 2) {
            throw zzed.zza();
        }
        if ((list instanceof zzei) && !z5) {
            zzei zzeiVar = (zzei) list;
            do {
                zzeiVar.zzi(zzp());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            do {
                list.add(z5 ? zzs() : zzr());
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzL(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzdw) {
            zzdw zzdwVar = (zzdw) list;
            int i7 = this.zzb & 7;
            if (i7 != 0) {
                if (i7 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar = this.zza;
                int zzd = zzcyVar.zzd() + zzcyVar.zzn();
                do {
                    zzdwVar.zzf(this.zza.zzn());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzdwVar.zzf(this.zza.zzn());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 != 0) {
                if (i8 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar2 = this.zza;
                int zzd2 = zzcyVar2.zzd() + zzcyVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzM(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzep) {
            zzep zzepVar = (zzep) list;
            int i7 = this.zzb & 7;
            if (i7 != 0) {
                if (i7 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar = this.zza;
                int zzd = zzcyVar.zzd() + zzcyVar.zzn();
                do {
                    zzepVar.zzf(this.zza.zzv());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzepVar.zzf(this.zza.zzv());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 != 0) {
                if (i8 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar2 = this.zza;
                int zzd2 = zzcyVar2.zzd() + zzcyVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzv()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final boolean zzO() throws IOException {
        int i6;
        if (this.zza.zzC() || (i6 = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i6);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final int zzc() throws IOException {
        int i6 = this.zzd;
        if (i6 != 0) {
            this.zzb = i6;
            this.zzd = 0;
        } else {
            i6 = this.zza.zzm();
            this.zzb = i6;
        }
        if (i6 == 0 || i6 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i6 >>> 3;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzv(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzch) {
            zzch zzchVar = (zzch) list;
            int i7 = this.zzb & 7;
            if (i7 != 0) {
                if (i7 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar = this.zza;
                int zzd = zzcyVar.zzd() + zzcyVar.zzn();
                do {
                    zzchVar.zze(this.zza.zzD());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzchVar.zze(this.zza.zzD());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 != 0) {
                if (i8 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar2 = this.zza;
                int zzd2 = zzcyVar2.zzd() + zzcyVar2.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzD()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzw(List list) throws IOException {
        int zzm;
        if ((this.zzb & 7) != 2) {
            throw zzed.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzC()) {
                return;
            } else {
                zzm = this.zza.zzm();
            }
        } while (zzm == this.zzb);
        this.zzd = zzm;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzx(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzdf) {
            zzdf zzdfVar = (zzdf) list;
            int i7 = this.zzb & 7;
            if (i7 != 1) {
                if (i7 != 2) {
                    throw zzed.zza();
                }
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzdfVar.zze(this.zza.zzb());
                } while (this.zza.zzd() < zzd);
                return;
            }
            do {
                zzdfVar.zze(this.zza.zzb());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 != 1) {
                if (i8 != 2) {
                    throw zzed.zza();
                }
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            do {
                list.add(Double.valueOf(this.zza.zzb()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzy(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzdw) {
            zzdw zzdwVar = (zzdw) list;
            int i7 = this.zzb & 7;
            if (i7 != 0) {
                if (i7 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar = this.zza;
                int zzd = zzcyVar.zzd() + zzcyVar.zzn();
                do {
                    zzdwVar.zzf(this.zza.zzf());
                } while (this.zza.zzd() < zzd);
                zzR(zzd);
                return;
            }
            do {
                zzdwVar.zzf(this.zza.zzf());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 != 0) {
                if (i8 != 2) {
                    throw zzed.zza();
                }
                zzcy zzcyVar2 = this.zza;
                int zzd2 = zzcyVar2.zzd() + zzcyVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfl
    public final void zzz(List list) throws IOException {
        int zzm;
        int i6;
        if (list instanceof zzdw) {
            zzdw zzdwVar = (zzdw) list;
            int i7 = this.zzb & 7;
            if (i7 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd = this.zza.zzd() + zzn;
                do {
                    zzdwVar.zzf(this.zza.zzg());
                } while (this.zza.zzd() < zzd);
                return;
            }
            if (i7 != 5) {
                throw zzed.zza();
            }
            do {
                zzdwVar.zzf(this.zza.zzg());
                if (this.zza.zzC()) {
                    return;
                } else {
                    i6 = this.zza.zzm();
                }
            } while (i6 == this.zzb);
        } else {
            int i8 = this.zzb & 7;
            if (i8 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd2 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < zzd2);
                return;
            }
            if (i8 != 5) {
                throw zzed.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    zzm = this.zza.zzm();
                }
            } while (zzm == this.zzb);
            i6 = zzm;
        }
        this.zzd = i6;
    }

    private zzcz(zzcy zzcyVar) {
        byte[] bArr = zzeb.zzd;
        this.zza = zzcyVar;
        zzcyVar.zzc = this;
    }
}
