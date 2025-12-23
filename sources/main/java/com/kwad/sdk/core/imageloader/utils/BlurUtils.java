package com.kwad.sdk.core.imageloader.utils;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class BlurUtils {
    public static Bitmap stackBlur(Bitmap bitmap, @IntRange(from = 1, to = 180) int i6, boolean z5) {
        Bitmap copy;
        int i7;
        int i8 = i6;
        if (z5) {
            copy = bitmap;
        } else {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            copy = bitmap.copy(config, true);
        }
        if (i8 <= 0) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i9 = width * height;
        int[] iArr = new int[i9];
        copy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i10 = width - 1;
        int i11 = height - 1;
        int i12 = i8 + i8;
        int i13 = i12 + 1;
        int[] iArr2 = new int[i9];
        int[] iArr3 = new int[i9];
        int[] iArr4 = new int[i9];
        int[] iArr5 = new int[Math.max(width, height)];
        int i14 = (i12 + 2) >> 1;
        int i15 = i14 * i14;
        int i16 = i15 * 256;
        int[] iArr6 = new int[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            iArr6[i17] = i17 / i15;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i13, 3);
        int i18 = i8 + 1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i19 < height) {
            int[] iArr8 = iArr6;
            int i22 = -i8;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            while (i22 <= i8) {
                int[] iArr9 = iArr4;
                Bitmap bitmap2 = copy;
                int i32 = iArr[i20 + Math.min(i10, Math.max(i22, 0))];
                int[] iArr10 = iArr7[i22 + i8];
                iArr10[0] = (i32 & 16711680) >> 16;
                iArr10[1] = (i32 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i32 & 255;
                int abs = i18 - Math.abs(i22);
                int i33 = iArr10[0];
                i31 += i33 * abs;
                int i34 = iArr10[1];
                i23 += i34 * abs;
                int i35 = iArr10[2];
                i24 += abs * i35;
                if (i22 > 0) {
                    i28 += i33;
                    i29 += i34;
                    i30 += i35;
                } else {
                    i25 += i33;
                    i26 += i34;
                    i27 += i35;
                }
                i22++;
                iArr4 = iArr9;
                copy = bitmap2;
            }
            int[] iArr11 = iArr4;
            Bitmap bitmap3 = copy;
            int i36 = i8;
            int i37 = 0;
            while (i37 < width) {
                iArr2[i20] = iArr8[i31];
                iArr3[i20] = iArr8[i23];
                iArr11[i20] = iArr8[i24];
                int i38 = i31 - i25;
                int i39 = i23 - i26;
                int i40 = i24 - i27;
                int[] iArr12 = iArr7[((i36 - i8) + i13) % i13];
                int i41 = i25 - iArr12[0];
                int i42 = i26 - iArr12[1];
                int i43 = i27 - iArr12[2];
                if (i19 == 0) {
                    i7 = i37;
                    iArr5[i7] = Math.min(i37 + i8 + 1, i10);
                } else {
                    i7 = i37;
                }
                int i44 = iArr[i21 + iArr5[i7]];
                int i45 = (i44 & 16711680) >> 16;
                iArr12[0] = i45;
                int i46 = (i44 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[1] = i46;
                int i47 = i44 & 255;
                iArr12[2] = i47;
                int i48 = i28 + i45;
                int i49 = i29 + i46;
                int i50 = i30 + i47;
                i31 = i38 + i48;
                i23 = i39 + i49;
                i24 = i40 + i50;
                i36 = (i36 + 1) % i13;
                int[] iArr13 = iArr7[i36 % i13];
                int i51 = iArr13[0];
                i25 = i41 + i51;
                int i52 = iArr13[1];
                i26 = i42 + i52;
                int i53 = iArr13[2];
                i27 = i43 + i53;
                i28 = i48 - i51;
                i29 = i49 - i52;
                i30 = i50 - i53;
                i20++;
                i37 = i7 + 1;
            }
            i21 += width;
            i19++;
            iArr6 = iArr8;
            iArr4 = iArr11;
            copy = bitmap3;
        }
        int[] iArr14 = iArr6;
        int[] iArr15 = iArr4;
        Bitmap bitmap4 = copy;
        int i54 = 0;
        while (i54 < width) {
            int i55 = -i8;
            int i56 = i54;
            int i57 = i55 * width;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = 0;
            int i65 = 0;
            int i66 = 0;
            while (i55 <= i8) {
                int max = Math.max(0, i57) + i56;
                int[] iArr16 = iArr7[i55 + i6];
                iArr16[0] = iArr2[max];
                iArr16[1] = iArr3[max];
                iArr16[2] = iArr15[max];
                int abs2 = i18 - Math.abs(i55);
                i66 += iArr2[max] * abs2;
                i58 += iArr3[max] * abs2;
                i59 += iArr15[max] * abs2;
                if (i55 > 0) {
                    i63 += iArr16[0];
                    i64 += iArr16[1];
                    i65 += iArr16[2];
                } else {
                    i60 += iArr16[0];
                    i61 += iArr16[1];
                    i62 += iArr16[2];
                }
                if (i55 < i11) {
                    i57 += width;
                }
                i55++;
                i8 = i6;
            }
            int i67 = i66;
            int i68 = i56;
            int i69 = i6;
            for (int i70 = 0; i70 < height; i70++) {
                iArr[i68] = (iArr[i68] & ViewCompat.MEASURED_STATE_MASK) | (iArr14[i67] << 16) | (iArr14[i58] << 8) | iArr14[i59];
                int i71 = i67 - i60;
                int i72 = i58 - i61;
                int i73 = i59 - i62;
                int[] iArr17 = iArr7[((i69 - i6) + i13) % i13];
                int i74 = i60 - iArr17[0];
                int i75 = i61 - iArr17[1];
                int i76 = i62 - iArr17[2];
                int i77 = i68;
                if (i56 == 0) {
                    iArr5[i70] = Math.min(i70 + i18, i11) * width;
                }
                int i78 = i56 + iArr5[i70];
                int i79 = iArr2[i78];
                iArr17[0] = i79;
                int i80 = iArr3[i78];
                iArr17[1] = i80;
                int i81 = iArr15[i78];
                iArr17[2] = i81;
                int i82 = i63 + i79;
                int i83 = i64 + i80;
                int i84 = i65 + i81;
                i67 = i71 + i82;
                i58 = i72 + i83;
                i59 = i73 + i84;
                i69 = (i69 + 1) % i13;
                int[] iArr18 = iArr7[i69];
                int i85 = iArr18[0];
                i60 = i74 + i85;
                int i86 = iArr18[1];
                i61 = i75 + i86;
                int i87 = iArr18[2];
                i62 = i76 + i87;
                i63 = i82 - i85;
                i64 = i83 - i86;
                i65 = i84 - i87;
                i68 = i77 + width;
            }
            i54 = i56 + 1;
            i8 = i6;
        }
        bitmap4.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap4;
    }
}
