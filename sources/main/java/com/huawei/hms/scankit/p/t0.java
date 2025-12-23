package com.huawei.hms.scankit.p;

import com.baidu.idl.face.platform.utils.FileUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.base.Ascii;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t0 extends g5 {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f34818e = {52, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 97, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT, 49, 304, 112, 37, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, 100, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 73, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, 25, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 88, 13, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 76, 28, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 67, 322, 19, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, 82, 7, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC, 70, 22, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500, 193, FileUtils.S_IRWXU, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 400, 208, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 168, 162, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, 42};

    /* renamed from: a, reason: collision with root package name */
    private final boolean f34819a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f34820b;

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f34821c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f34822d;

    public t0() {
        this(false);
    }

    private static boolean b(int[] iArr) {
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 : iArr) {
            if (i8 < i6) {
                i6 = i8;
            }
            if (i8 > i7) {
                i7 = i8;
            }
        }
        return i7 / i6 > 6;
    }

    private static int c(int[] iArr) {
        int length = iArr.length;
        if (b(iArr)) {
            return -1;
        }
        int i6 = 0;
        while (true) {
            int i7 = Integer.MAX_VALUE;
            for (int i8 : iArr) {
                if (i8 < i7 && i8 > i6) {
                    i7 = i8;
                }
            }
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                int i13 = iArr[i12];
                if (i13 > i7) {
                    i11 |= 1 << ((length - 1) - i12);
                    i9++;
                    i10 += i13;
                }
            }
            if (i9 == 3) {
                for (int i14 = 0; i14 < length && i9 > 0; i14++) {
                    int i15 = iArr[i14];
                    if (i15 > i7) {
                        i9--;
                        if (i15 * 2 >= i10) {
                            return -1;
                        }
                    }
                }
                return i11;
            }
            if (i9 <= 3) {
                return -1;
            }
            i6 = i7;
        }
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i6, r rVar, Map<l1, ?> map) throws a {
        int[] iArr = this.f34822d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f34821c;
        sb.setLength(0);
        int[] a6 = a(rVar, iArr);
        int c6 = rVar.c(a6[1]);
        int e6 = rVar.e();
        while (true) {
            g5.a(rVar, c6, iArr);
            int c7 = c(iArr);
            if (c7 < 0) {
                throw a.a();
            }
            char a7 = a(c7);
            sb.append(a7);
            int i7 = c6;
            for (int i8 : iArr) {
                i7 += i8;
            }
            int c8 = rVar.c(i7);
            if (a7 == '*') {
                sb.setLength(sb.length() - 1);
                int i9 = 0;
                for (int i10 : iArr) {
                    i9 += i10;
                }
                int i11 = (c8 - c6) - i9;
                if (c8 == e6 || i11 * 5 >= i9) {
                    return a(sb, a6, c6, i9, i6);
                }
                throw a.a();
            }
            c6 = c8;
        }
    }

    public t0(boolean z5) {
        this(z5, false);
    }

    public t0(boolean z5, boolean z6) {
        this.f34819a = z5;
        this.f34820b = z6;
        this.f34821c = new StringBuilder(20);
        this.f34822d = new int[9];
    }

    private s6 a(StringBuilder sb, int[] iArr, int i6, int i7, int i8) throws a {
        String sb2;
        if (this.f34819a) {
            int length = sb.length() - 1;
            int i9 = 0;
            for (int i10 = 0; i10 < length; i10++) {
                i9 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f34821c.charAt(i10));
            }
            if (sb.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i9 % 43)) {
                sb.setLength(length);
            } else {
                throw a.a();
            }
        }
        if (sb.length() != 0) {
            if (this.f34820b) {
                sb2 = a(sb);
            } else {
                sb2 = sb.toString();
            }
            float f6 = i8;
            return new s6(sb2, null, new u6[]{new u6(iArr[0], f6), new u6(i6 + i7, f6)}, BarcodeFormat.CODE_39);
        }
        throw a.a();
    }

    private static int[] a(r rVar, int[] iArr) throws a {
        int e6 = rVar.e();
        int c6 = rVar.c(0);
        int length = iArr.length;
        int i6 = c6;
        boolean z5 = false;
        int i7 = 0;
        while (c6 < e6) {
            if (rVar.b(c6) != z5) {
                if (i7 >= 0 && i7 < iArr.length) {
                    iArr[i7] = iArr[i7] + 1;
                } else {
                    throw a.a();
                }
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (c(iArr) == 148 && rVar.a(Math.max(0, i6 - ((c6 - i6) / 5)), i6, false, true)) {
                        return new int[]{i6, c6};
                    }
                    i6 += iArr[0] + iArr[1];
                    int i8 = i7 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i8);
                    iArr[i8] = 0;
                    iArr[i7] = 0;
                    i7--;
                }
                iArr[i7] = 1;
                z5 = !z5;
            }
            c6++;
        }
        throw a.a();
    }

    private static char a(int i6) throws a {
        int i7 = 0;
        while (true) {
            int[] iArr = f34818e;
            if (i7 >= iArr.length) {
                if (i6 == 148) {
                    return '*';
                }
                throw a.a();
            }
            if (iArr[i7] == i6) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i7);
            }
            i7++;
        }
    }

    private static String a(CharSequence charSequence) throws a {
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i6 = 0;
        while (i6 < length) {
            char charAt = charSequence.charAt(i6);
            if (charAt != '+' && charAt != '$' && charAt != '%' && charAt != '/') {
                sb.append(charAt);
            } else {
                i6++;
                sb.append(a(charAt, charSequence.charAt(i6)));
            }
            i6++;
        }
        return sb.toString();
    }

    private static char a(char c6, char c7) throws a {
        int i6;
        if (c6 != '$') {
            if (c6 != '%') {
                if (c6 != '+') {
                    if (c6 != '/') {
                        return (char) 0;
                    }
                    if (c7 < 'A' || c7 > 'O') {
                        if (c7 == 'Z') {
                            return ':';
                        }
                        throw a.a();
                    }
                    i6 = c7 - ' ';
                } else {
                    if (c7 < 'A' || c7 > 'Z') {
                        throw a.a();
                    }
                    i6 = c7 + ' ';
                }
            } else if (c7 >= 'A' && c7 <= 'E') {
                i6 = c7 - '&';
            } else if (c7 >= 'F' && c7 <= 'J') {
                i6 = c7 - 11;
            } else if (c7 >= 'K' && c7 <= 'O') {
                i6 = c7 + 16;
            } else {
                if (c7 < 'P' || c7 > 'T') {
                    if (c7 == 'U') {
                        return (char) 0;
                    }
                    if (c7 == 'V') {
                        return '@';
                    }
                    if (c7 == 'W') {
                        return '`';
                    }
                    if (c7 == 'X' || c7 == 'Y' || c7 == 'Z') {
                        return Ascii.MAX;
                    }
                    throw a.a();
                }
                i6 = c7 + '+';
            }
        } else {
            if (c7 < 'A' || c7 > 'Z') {
                throw a.a();
            }
            i6 = c7 - '@';
        }
        return (char) i6;
    }
}
