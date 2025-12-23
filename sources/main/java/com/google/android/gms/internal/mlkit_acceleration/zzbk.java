package com.google.android.gms.internal.mlkit_acceleration;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzbk {
    protected int zza;
    protected ByteBuffer zzb;
    final zzbm zzc = zzbm.zza();
    private int zzd;
    private int zze;

    protected final int zza(int i6) {
        if (i6 < this.zze) {
            return this.zzb.getShort(this.zzd + i6);
        }
        return 0;
    }

    protected final int zzb(int i6) {
        int i7 = i6 + this.zza;
        return i7 + this.zzb.getInt(i7) + 4;
    }

    protected final int zzc(int i6) {
        int i7 = i6 + this.zza;
        return this.zzb.getInt(i7 + this.zzb.getInt(i7));
    }

    protected final String zzd(int i6) {
        char[] cArr;
        int i7;
        int i8;
        int i9;
        ByteBuffer byteBuffer = this.zzb;
        int i10 = i6 + byteBuffer.getInt(i6);
        int i11 = byteBuffer.getInt(i10);
        int i12 = i10 + 4;
        if (byteBuffer.hasArray()) {
            byte[] array = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + i12;
            int length = array.length;
            if ((arrayOffset | i11 | ((length - arrayOffset) - i11)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(arrayOffset), Integer.valueOf(i11)));
            }
            int i13 = arrayOffset + i11;
            cArr = new char[i11];
            int i14 = 0;
            while (arrayOffset < i13) {
                byte b6 = array[arrayOffset];
                if (!zzbl.zzd(b6)) {
                    break;
                }
                arrayOffset++;
                cArr[i14] = (char) b6;
                i14++;
            }
            i7 = i14;
            while (arrayOffset < i13) {
                int i15 = arrayOffset + 1;
                byte b7 = array[arrayOffset];
                if (zzbl.zzd(b7)) {
                    cArr[i7] = (char) b7;
                    i7++;
                    arrayOffset = i15;
                    while (arrayOffset < i13) {
                        byte b8 = array[arrayOffset];
                        if (zzbl.zzd(b8)) {
                            arrayOffset++;
                            cArr[i7] = (char) b8;
                            i7++;
                        }
                    }
                } else {
                    if (zzbl.zzf(b7)) {
                        if (i15 >= i13) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        i9 = i7 + 1;
                        arrayOffset += 2;
                        zzbl.zzc(b7, array[i15], cArr, i7);
                    } else if (zzbl.zze(b7)) {
                        if (i15 >= i13 - 1) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        i9 = i7 + 1;
                        int i16 = arrayOffset + 2;
                        arrayOffset += 3;
                        zzbl.zzb(b7, array[i15], array[i16], cArr, i7);
                    } else {
                        if (i15 >= i13 - 2) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        byte b9 = array[i15];
                        int i17 = arrayOffset + 3;
                        byte b10 = array[arrayOffset + 2];
                        arrayOffset += 4;
                        zzbl.zza(b7, b9, b10, array[i17], cArr, i7);
                        i7 += 2;
                    }
                    i7 = i9;
                }
            }
        } else {
            if ((i12 | i11 | ((byteBuffer.limit() - i12) - i11)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i12), Integer.valueOf(i11)));
            }
            int i18 = i12 + i11;
            cArr = new char[i11];
            int i19 = 0;
            while (i12 < i18) {
                byte b11 = byteBuffer.get(i12);
                if (!zzbl.zzd(b11)) {
                    break;
                }
                i12++;
                cArr[i19] = (char) b11;
                i19++;
            }
            i7 = i19;
            while (i12 < i18) {
                int i20 = i12 + 1;
                byte b12 = byteBuffer.get(i12);
                if (zzbl.zzd(b12)) {
                    cArr[i7] = (char) b12;
                    i7++;
                    i12 = i20;
                    while (i12 < i18) {
                        byte b13 = byteBuffer.get(i12);
                        if (zzbl.zzd(b13)) {
                            i12++;
                            cArr[i7] = (char) b13;
                            i7++;
                        }
                    }
                } else {
                    if (zzbl.zzf(b12)) {
                        if (i20 >= i18) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        i8 = i7 + 1;
                        i12 += 2;
                        zzbl.zzc(b12, byteBuffer.get(i20), cArr, i7);
                    } else if (zzbl.zze(b12)) {
                        if (i20 >= i18 - 1) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        i8 = i7 + 1;
                        int i21 = i12 + 2;
                        i12 += 3;
                        zzbl.zzb(b12, byteBuffer.get(i20), byteBuffer.get(i21), cArr, i7);
                    } else {
                        if (i20 >= i18 - 2) {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                        byte b14 = byteBuffer.get(i20);
                        int i22 = i12 + 3;
                        byte b15 = byteBuffer.get(i12 + 2);
                        i12 += 4;
                        zzbl.zza(b12, b14, b15, byteBuffer.get(i22), cArr, i7);
                        i7 += 2;
                    }
                    i7 = i8;
                }
            }
        }
        return new String(cArr, 0, i7);
    }

    protected final void zze(int i6, ByteBuffer byteBuffer) {
        short s5;
        this.zzb = byteBuffer;
        if (byteBuffer != null) {
            this.zza = i6;
            int i7 = i6 - byteBuffer.getInt(i6);
            this.zzd = i7;
            s5 = this.zzb.getShort(i7);
        } else {
            s5 = 0;
            this.zza = 0;
            this.zzd = 0;
        }
        this.zze = s5;
    }
}
