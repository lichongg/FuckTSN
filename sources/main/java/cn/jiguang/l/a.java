package cn.jiguang.l;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.bz.l;
import cn.jiguang.v.c;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f3068a = {102, 120, 94, 71, 57, 37, 117, 49, 1, 0, 52, Byte.MAX_VALUE, 54, 32, 16};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f3069b = {83, 65, 109, 40, 57, 97, 66, 79, 122, 39, 120, 116, 68, 15, 120, 122, 102};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f3070c = {120, SignedBytes.MAX_POWER_OF_TWO, 0, 52, 60, 54, Byte.MAX_VALUE, 85, 73, 126, 96, 54, 98, 88, 79, 110};

    /* renamed from: cn.jiguang.l.a$a, reason: collision with other inner class name */
    private static class C0048a {

        /* renamed from: a, reason: collision with root package name */
        HandlerThread f3071a;

        /* renamed from: b, reason: collision with root package name */
        Handler f3072b;

        /* renamed from: c, reason: collision with root package name */
        private int f3073c;

        /* renamed from: d, reason: collision with root package name */
        private String f3074d;

        private void b(byte[] bArr, int i6, int i7) {
            if (bArr == null || bArr.length < 3) {
                return;
            }
            byte[] bArr2 = {bArr[0], bArr[1], bArr[2], 0};
            Thread currentThread = Thread.currentThread();
            while (i6 < i7) {
                byte b6 = (byte) i6;
                bArr2[3] = b6;
                if (b6 != bArr[3]) {
                    String b7 = a.b(bArr2);
                    if (!b7.equalsIgnoreCase(this.f3074d)) {
                        this.f3072b.removeCallbacksAndMessages(null);
                        Message obtainMessage = this.f3072b.obtainMessage(1);
                        obtainMessage.obj = currentThread;
                        Bundle bundle = new Bundle();
                        bundle.putString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, b7);
                        obtainMessage.setData(bundle);
                        this.f3072b.sendMessageDelayed(obtainMessage, this.f3073c);
                        c.a(new String[]{l.b(a.f3068a) + b7}, 0);
                    }
                }
                i6++;
            }
        }

        C0048a(String str, int i6) {
            this.f3073c = i6;
            this.f3074d = str;
            HandlerThread handlerThread = new HandlerThread("jg_ptm_thread");
            this.f3071a = handlerThread;
            handlerThread.start();
            this.f3072b = new Handler(this.f3071a.getLooper(), new Handler.Callback() { // from class: cn.jiguang.l.a.a.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    Thread thread;
                    if (message == null || message.what != 1 || (thread = (Thread) message.obj) == null) {
                        return false;
                    }
                    thread.interrupt();
                    return false;
                }
            });
        }

        void a(byte[] bArr, int i6, int i7) {
            b(bArr, i6, i7);
            this.f3071a.quit();
        }
    }

    private static cn.jiguang.k.a a(String str, boolean z5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        cn.jiguang.k.a aVar = new cn.jiguang.k.a();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < bytes.length - 1) {
            int i9 = i6 + 1;
            if (bytes[i9] == 32) {
                int i10 = i9 - i7;
                if (i10 > 1) {
                    String str2 = new String(bytes, i7, i10);
                    if (i8 == 0) {
                        aVar.f3064a = str2;
                    } else if (i8 == 1) {
                        aVar.f3065b = str2;
                    } else if (i8 == 2) {
                        aVar.f3066c = str2;
                    } else if (i8 == 3) {
                        if (!z5) {
                            aVar.f3067d = str2;
                            return aVar;
                        }
                    } else if (i8 == 4 && z5) {
                        aVar.f3067d = str2;
                        return aVar;
                    }
                    i8++;
                }
                i7 = i6 + 2;
            }
            i6 = i9;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bArr[0] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[1] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[2] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[3] & 255);
        return stringBuffer.toString();
    }

    public static String a(int i6) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i6 & 255);
        stringBuffer.append('.');
        stringBuffer.append((i6 >> 8) & 255);
        stringBuffer.append('.');
        stringBuffer.append((i6 >> 16) & 255);
        stringBuffer.append('.');
        stringBuffer.append((i6 >> 24) & 255);
        return stringBuffer.toString();
    }

    private static byte[] b() {
        byte[] bArr = new byte[50];
        bArr[0] = 126;
        bArr[1] = 40;
        bArr[2] = 0;
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        bArr[8] = 0;
        bArr[9] = 0;
        bArr[10] = 0;
        bArr[11] = 0;
        bArr[12] = 32;
        bArr[13] = 67;
        bArr[14] = 75;
        for (int i6 = 15; i6 < 45; i6++) {
            bArr[i6] = 65;
        }
        bArr[45] = 0;
        bArr[46] = 0;
        bArr[47] = BinaryMemcacheOpcodes.SASL_AUTH;
        bArr[48] = 0;
        bArr[49] = 1;
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce A[Catch: all -> 0x0056, TryCatch #2 {all -> 0x0056, blocks: (B:3:0x0003, B:5:0x001d, B:22:0x0059, B:16:0x0055, B:20:0x0052, B:24:0x005e, B:26:0x008a, B:31:0x00b8, B:34:0x00bf, B:35:0x00c8, B:37:0x00ce, B:40:0x00db, B:43:0x00e1, B:46:0x00e9, B:49:0x00f3, B:60:0x00f8, B:62:0x0093), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<cn.jiguang.k.a> a(java.lang.String r11, android.net.DhcpInfo r12) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.l.a.a(java.lang.String, android.net.DhcpInfo):java.util.List");
    }

    public static void a(String str, byte[] bArr) {
        new C0048a(str, 300).a(bArr, 0, 255);
    }

    public static byte[] a(long j6) {
        return new byte[]{(byte) (j6 & 255), (byte) ((j6 >> 8) & 255), (byte) ((j6 >> 16) & 255), (byte) ((j6 >> 24) & 255)};
    }
}
