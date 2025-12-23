package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.base.Ascii;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class v0 extends g5 {

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f34885c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f34886d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f34887e;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f34888a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private final int[] f34889b = new int[6];

    private static int b(int[] iArr) {
        int i6 = 0;
        for (int i7 : iArr) {
            i6 += i7;
        }
        int length = iArr.length;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int round = Math.round((iArr[i9] * 9.0f) / i6);
            if (round < 1 || round > 4) {
                return -1;
            }
            if ((i9 & 1) == 0) {
                for (int i10 = 0; i10 < round; i10++) {
                    i8 = (i8 << 1) | 1;
                }
            } else {
                i8 <<= round;
            }
        }
        return i8;
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i6, r rVar, Map<l1, ?> map) throws a {
        int c6 = rVar.c(a(rVar)[1]);
        int e6 = rVar.e();
        int[] iArr = this.f34889b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f34888a;
        sb.setLength(0);
        while (true) {
            g5.a(rVar, c6, iArr);
            int b6 = b(iArr);
            if (b6 < 0) {
                throw a.a();
            }
            char a6 = a(b6);
            sb.append(a6);
            int i7 = c6;
            for (int i8 : iArr) {
                i7 += i8;
            }
            int c7 = rVar.c(i7);
            if (a6 == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i9 = 0;
                for (int i10 : iArr) {
                    i9 += i10;
                }
                if (c7 == e6 || !rVar.b(c7)) {
                    throw a.a();
                }
                if (sb.length() < 2) {
                    throw a.a();
                }
                a(sb);
                sb.setLength(sb.length() - 2);
                float f6 = i6;
                return new s6(b(sb), null, new u6[]{new u6(r14[0], f6), new u6(c6 + ((i9 * 10) / 9), f6)}, BarcodeFormat.CODE_93);
            }
            c6 = c7;
        }
    }

    static {
        int[] iArr = {MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 322, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, 290, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, 424, org.apache.commons.net.nntp.h.f50924w, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 404, 402, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION, 360, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU, 354, 308, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, 332, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE, 300, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, org.apache.commons.net.nntp.h.C, 434, 428, org.apache.commons.net.nntp.h.f50926y, 406, TTAdConstant.IMAGE_LIST_SIZE_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, MediaPlayer.MEDIA_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 302, 468, 466, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS, org.apache.commons.net.nntp.h.A, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, 474, 470, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY, org.apache.commons.net.ftp.l.f50696w};
        f34886d = iArr;
        f34887e = iArr[47];
    }

    private static String b(CharSequence charSequence) throws a {
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i6 = 0;
        while (i6 < length) {
            char charAt = charSequence.charAt(i6);
            if (charAt < 'a' || charAt > 'd') {
                sb.append(charAt);
            } else if (i6 < length - 1) {
                i6++;
                sb.append(a(charAt, charSequence.charAt(i6)));
            } else {
                throw a.a();
            }
            i6++;
        }
        return sb.toString();
    }

    private int[] a(r rVar) throws a {
        int e6 = rVar.e();
        int c6 = rVar.c(0);
        Arrays.fill(this.f34889b, 0);
        int[] iArr = this.f34889b;
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
                    if (b(iArr) == f34887e) {
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
            int[] iArr = f34886d;
            if (i7 < iArr.length) {
                if (iArr[i7] == i6) {
                    return f34885c[i7];
                }
                i7++;
            } else {
                throw a.a();
            }
        }
    }

    private static char a(char c6, char c7) throws a {
        int i6;
        switch (c6) {
            case 'a':
                if (c7 >= 'A' && c7 <= 'Z') {
                    i6 = c7 - '@';
                    break;
                } else {
                    throw a.a();
                }
            case 'b':
                if (c7 >= 'A' && c7 <= 'E') {
                    i6 = c7 - '&';
                    break;
                } else if (c7 >= 'F' && c7 <= 'J') {
                    i6 = c7 - 11;
                    break;
                } else if (c7 >= 'K' && c7 <= 'O') {
                    i6 = c7 + 16;
                    break;
                } else if (c7 >= 'P' && c7 <= 'S') {
                    i6 = c7 + '+';
                    break;
                } else {
                    if (c7 < 'T' || c7 > 'Z') {
                        throw a.a();
                    }
                    return Ascii.MAX;
                }
                break;
            case 'c':
                if (c7 >= 'A' && c7 <= 'O') {
                    i6 = c7 - ' ';
                    break;
                } else {
                    if (c7 == 'Z') {
                        return ':';
                    }
                    throw a.a();
                }
            case 'd':
                if (c7 >= 'A' && c7 <= 'Z') {
                    i6 = c7 + ' ';
                    break;
                } else {
                    throw a.a();
                }
            default:
                return (char) 0;
        }
        return (char) i6;
    }

    private static void a(CharSequence charSequence) throws a {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    private static void a(CharSequence charSequence, int i6, int i7) throws a {
        int i8 = 0;
        int i9 = 1;
        for (int i10 = i6 - 1; i10 >= 0; i10--) {
            i8 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i10)) * i9;
            i9++;
            if (i9 > i7) {
                i9 = 1;
            }
        }
        if (charSequence.charAt(i6) != f34885c[i8 % 47]) {
            throw a.a();
        }
    }
}
