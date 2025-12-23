package com.huawei.hms.scankit.p;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class z2 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f35066a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f35067b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, 205, 12, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 213, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, 45, 18, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 83, 185}, new int[]{83, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, org.apache.commons.net.ftp.l.f50687n, 48, 90, 188}, new int[]{15, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 244, 9, 233, 71, 168, 2, 188, 160, 153, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 253, 79, 108, 82, 27, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR}, new int[]{52, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 88, 205, 109, 39, 176, 21, 155, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 251, 223, 155, 21, 5, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 37, 151, 170, 53, 75, 34, 249, 121, 17, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, 110, 213, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 250, 162, 181, 102, 120, 84, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 220, 251, 80, 182, org.apache.commons.net.ftp.l.f50690q, 18, 2, 4, 68, 33, 101, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 95, 119, 115, 44, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 184, 59, 25, org.apache.commons.net.ftp.l.f50687n, 98, 81, 112}, new int[]{77, 193, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, 242, 8, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, org.apache.commons.net.ftp.l.f50688o, 5, 9, 5}, new int[]{245, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR, 223, 96, 32, 117, 22, org.apache.commons.net.telnet.f.f51103s, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, org.apache.commons.net.telnet.f.f51103s, 231, 205, 188, org.apache.commons.net.telnet.f.f51104t, 87, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 240, 82, 44, 176, 87, 187, 147, 160, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 69, 213, 92, 253, org.apache.commons.net.ftp.l.f50687n, 19}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 9, 223, org.apache.commons.net.telnet.f.f51103s, 12, 17, 220, 208, 100, 29, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 54, 228, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK, 218, org.apache.commons.net.ftp.l.O, 117, 203, 29, 232, 144, org.apache.commons.net.telnet.f.f51103s, 22, 150, 201, 117, 62, 207, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 13, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, Opcodes.RET, 50, 144, 210, 39, 118, 202, 188, 201, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, 143, 108, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 37, 185, 112, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS, 230, 245, 63, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 250, 106, 185, 221, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, Opcodes.FCMPL, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 248, 180, org.apache.commons.net.ftp.l.O, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 158, 177, 68, 122, 93, 213, 15, 160, org.apache.commons.net.ftp.l.f50689p, org.apache.commons.net.telnet.f.f51105u, 66, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, 153, 185, 202, 167, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 25, 220, 232, 96, 210, 231, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 223, org.apache.commons.net.telnet.f.f51102r, 181, 241, 59, 52, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR, 25, 49, 232, 211, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, 64, 54, 108, 153, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 63, 96, 103, 82, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS}};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f35068c = new int[256];

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f35069d = new int[255];

    public static String a(String str, d7 d7Var) {
        if (str.length() != d7Var.a()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(d7Var.a() + d7Var.b());
        sb.append(str);
        int d6 = d7Var.d();
        if (d6 == 1) {
            sb.append(a(str, d7Var.b()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[d6];
            int[] iArr2 = new int[d6];
            int[] iArr3 = new int[d6];
            int i6 = 0;
            while (i6 < d6) {
                int i7 = i6 + 1;
                iArr[i6] = d7Var.a(i7);
                iArr2[i6] = d7Var.b(i7);
                iArr3[i6] = 0;
                if (i6 > 0) {
                    iArr3[i6] = iArr3[i6 - 1] + iArr[i6];
                }
                i6 = i7;
            }
            for (int i8 = 0; i8 < d6; i8++) {
                StringBuilder sb2 = new StringBuilder(iArr[i8]);
                for (int i9 = i8; i9 < d7Var.a(); i9 += d6) {
                    sb2.append(str.charAt(i9));
                }
                String a6 = a(sb2.toString(), iArr2[i8]);
                int i10 = i8;
                int i11 = 0;
                while (i10 < iArr2[i8] * d6) {
                    sb.setCharAt(d7Var.a() + i10, a6.charAt(i11));
                    i10 += d6;
                    i11++;
                }
            }
        }
        return sb.toString();
    }

    static {
        int i6 = 1;
        for (int i7 = 0; i7 < 255; i7++) {
            int[] iArr = f35069d;
            if (w7.a(iArr, i7)) {
                iArr[i7] = i6;
            }
            int[] iArr2 = f35068c;
            if (w7.a(iArr2, i6)) {
                iArr2[i6] = i7;
            }
            i6 *= 2;
            if (i6 >= 256) {
                i6 ^= 301;
            }
        }
    }

    private static String a(CharSequence charSequence, int i6) {
        return a(charSequence, 0, charSequence.length(), i6);
    }

    private static String a(CharSequence charSequence, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11 = 0;
        while (true) {
            int[] iArr = f35066a;
            if (i11 >= iArr.length) {
                i11 = -1;
                break;
            }
            if (iArr[i11] == i8) {
                break;
            }
            i11++;
        }
        if (i11 >= 0) {
            int[] iArr2 = f35067b[i11];
            char[] cArr = new char[i8];
            for (int i12 = 0; i12 < i8; i12++) {
                cArr[i12] = 0;
            }
            for (int i13 = i6; i13 < i6 + i7; i13++) {
                int i14 = i8 - 1;
                int charAt = cArr[i14] ^ charSequence.charAt(i13);
                while (i14 > 0) {
                    if (charAt != 0 && (i10 = iArr2[i14]) != 0) {
                        char c6 = cArr[i14 - 1];
                        int[] iArr3 = f35069d;
                        int[] iArr4 = f35068c;
                        cArr[i14] = (char) (iArr3[(iArr4[charAt] + iArr4[i10]) % 255] ^ c6);
                    } else {
                        cArr[i14] = cArr[i14 - 1];
                    }
                    i14--;
                }
                if (charAt != 0 && (i9 = iArr2[0]) != 0) {
                    int[] iArr5 = f35069d;
                    int[] iArr6 = f35068c;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[i9]) % 255];
                } else {
                    cArr[0] = 0;
                }
            }
            char[] cArr2 = new char[i8];
            for (int i15 = 0; i15 < i8; i15++) {
                cArr2[i15] = cArr[(i8 - i15) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i8);
    }
}
