package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzda extends zzdd {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    zzda(byte[] bArr, int i6, int i7) {
        super(null);
        int length = bArr.length;
        if (((length - i7) | i7) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i7)));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i7;
    }

    public final void zzc(byte[] bArr, int i6, int i7) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i7);
            this.zzd += i7;
        } catch (IndexOutOfBoundsException e6) {
            throw new zzdb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i7)), e6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzl(byte[] bArr, int i6, int i7) throws IOException {
        zzc(bArr, 0, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzb(byte b6) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i6 = this.zzd;
            this.zzd = i6 + 1;
            bArr[i6] = b6;
        } catch (IndexOutOfBoundsException e6) {
            throw new zzdb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzd(int i6, boolean z5) throws IOException {
        zzq(i6 << 3);
        zzb(z5 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zze(int i6, zzcs zzcsVar) throws IOException {
        zzq((i6 << 3) | 2);
        zzq(zzcsVar.zzd());
        zzcsVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzf(int i6, int i7) throws IOException {
        zzq((i6 << 3) | 5);
        zzg(i7);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzg(int i6) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i7 = this.zzd;
            int i8 = i7 + 1;
            this.zzd = i8;
            bArr[i7] = (byte) (i6 & 255);
            int i9 = i7 + 2;
            this.zzd = i9;
            bArr[i8] = (byte) ((i6 >> 8) & 255);
            int i10 = i7 + 3;
            this.zzd = i10;
            bArr[i9] = (byte) ((i6 >> 16) & 255);
            this.zzd = i7 + 4;
            bArr[i10] = (byte) ((i6 >> 24) & 255);
        } catch (IndexOutOfBoundsException e6) {
            throw new zzdb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzh(int i6, long j6) throws IOException {
        zzq((i6 << 3) | 1);
        zzi(j6);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzi(long j6) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i6 = this.zzd;
            int i7 = i6 + 1;
            this.zzd = i7;
            bArr[i6] = (byte) (((int) j6) & 255);
            int i8 = i6 + 2;
            this.zzd = i8;
            bArr[i7] = (byte) (((int) (j6 >> 8)) & 255);
            int i9 = i6 + 3;
            this.zzd = i9;
            bArr[i8] = (byte) (((int) (j6 >> 16)) & 255);
            int i10 = i6 + 4;
            this.zzd = i10;
            bArr[i9] = (byte) (((int) (j6 >> 24)) & 255);
            int i11 = i6 + 5;
            this.zzd = i11;
            bArr[i10] = (byte) (((int) (j6 >> 32)) & 255);
            int i12 = i6 + 6;
            this.zzd = i12;
            bArr[i11] = (byte) (((int) (j6 >> 40)) & 255);
            int i13 = i6 + 7;
            this.zzd = i13;
            bArr[i12] = (byte) (((int) (j6 >> 48)) & 255);
            this.zzd = i6 + 8;
            bArr[i13] = (byte) (((int) (j6 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e6) {
            throw new zzdb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzj(int i6, int i7) throws IOException {
        zzq(i6 << 3);
        zzk(i7);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzk(int i6) throws IOException {
        if (i6 >= 0) {
            zzq(i6);
        } else {
            zzs(i6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzm(int i6, String str) throws IOException {
        zzq((i6 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i6 = this.zzd;
        try {
            int zzw = zzdd.zzw(str.length() * 3);
            int zzw2 = zzdd.zzw(str.length());
            if (zzw2 != zzw) {
                zzq(zzgs.zzc(str));
                byte[] bArr = this.zzb;
                int i7 = this.zzd;
                this.zzd = zzgs.zzb(str, bArr, i7, this.zzc - i7);
                return;
            }
            int i8 = i6 + zzw2;
            this.zzd = i8;
            int zzb = zzgs.zzb(str, this.zzb, i8, this.zzc - i8);
            this.zzd = i6;
            zzq((zzb - i6) - zzw2);
            this.zzd = zzb;
        } catch (zzgr e6) {
            this.zzd = i6;
            zzA(str, e6);
        } catch (IndexOutOfBoundsException e7) {
            throw new zzdb(e7);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzo(int i6, int i7) throws IOException {
        zzq((i6 << 3) | i7);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzp(int i6, int i7) throws IOException {
        zzq(i6 << 3);
        zzq(i7);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzq(int i6) throws IOException {
        while ((i6 & (-128)) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i7 = this.zzd;
                this.zzd = i7 + 1;
                bArr[i7] = (byte) ((i6 | 128) & 255);
                i6 >>>= 7;
            } catch (IndexOutOfBoundsException e6) {
                throw new zzdb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e6);
            }
        }
        byte[] bArr2 = this.zzb;
        int i8 = this.zzd;
        this.zzd = i8 + 1;
        bArr2[i8] = (byte) i6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzr(int i6, long j6) throws IOException {
        zzq(i6 << 3);
        zzs(j6);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdd
    public final void zzs(long j6) throws IOException {
        boolean z5;
        z5 = zzdd.zzc;
        if (!z5 || this.zzc - this.zzd < 10) {
            while ((j6 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i6 = this.zzd;
                    this.zzd = i6 + 1;
                    bArr[i6] = (byte) ((((int) j6) | 128) & 255);
                    j6 >>>= 7;
                } catch (IndexOutOfBoundsException e6) {
                    throw new zzdb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e6);
                }
            }
            byte[] bArr2 = this.zzb;
            int i7 = this.zzd;
            this.zzd = i7 + 1;
            bArr2[i7] = (byte) j6;
            return;
        }
        while (true) {
            int i8 = (int) j6;
            if ((j6 & (-128)) == 0) {
                byte[] bArr3 = this.zzb;
                int i9 = this.zzd;
                this.zzd = i9 + 1;
                zzgn.zzn(bArr3, i9, (byte) i8);
                return;
            }
            byte[] bArr4 = this.zzb;
            int i10 = this.zzd;
            this.zzd = i10 + 1;
            zzgn.zzn(bArr4, i10, (byte) ((i8 | 128) & 255));
            j6 >>>= 7;
        }
    }
}
