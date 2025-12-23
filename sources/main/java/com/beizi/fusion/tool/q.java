package com.beizi.fusion.tool;

import android.content.Context;
import com.acse.ottn.l3;
import com.baidu.idl.face.platform.FaceEnvironment;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class q {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.fusion.tool.q$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final q f13734a = new q(null);
    }

    /* synthetic */ q(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static final q a() {
        return a.f13734a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
    
        if (r0.equals("cancro") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b() {
        /*
            r6 = this;
            java.lang.String r0 = "ro.hardware"
            java.lang.String r0 = r6.a(r0)
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            java.lang.String r0 = r0.toLowerCase()
            r0.getClass()
            int r2 = r0.hashCode()
            r3 = 2
            r4 = 1
            r5 = -1
            switch(r2) {
                case -1367724016: goto L5f;
                case -822798509: goto L54;
                case 109271: goto L49;
                case 3570999: goto L3e;
                case 3613077: goto L33;
                case 100361430: goto L28;
                case 937844646: goto L1d;
                default: goto L1b;
            }
        L1b:
            r1 = -1
            goto L68
        L1d:
            java.lang.String r1 = "android_x86"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L26
            goto L1b
        L26:
            r1 = 6
            goto L68
        L28:
            java.lang.String r1 = "intel"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L31
            goto L1b
        L31:
            r1 = 5
            goto L68
        L33:
            java.lang.String r1 = "vbox"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3c
            goto L1b
        L3c:
            r1 = 4
            goto L68
        L3e:
            java.lang.String r1 = "ttvm"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L47
            goto L1b
        L47:
            r1 = 3
            goto L68
        L49:
            java.lang.String r1 = "nox"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L52
            goto L1b
        L52:
            r1 = 2
            goto L68
        L54:
            java.lang.String r1 = "vbox86"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5d
            goto L1b
        L5d:
            r1 = 1
            goto L68
        L5f:
            java.lang.String r2 = "cancro"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L68
            goto L1b
        L68:
            switch(r1) {
                case 0: goto L6c;
                case 1: goto L6c;
                case 2: goto L6c;
                case 3: goto L6c;
                case 4: goto L6c;
                case 5: goto L6c;
                case 6: goto L6c;
                default: goto L6b;
            }
        L6b:
            return r3
        L6c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.tool.q.b():int");
    }

    private int c() {
        String a6 = a("ro.build.flavor");
        if (a6 == null) {
            return 0;
        }
        String lowerCase = a6.toLowerCase();
        return (lowerCase.contains("vbox") || lowerCase.contains("sdk_gphone")) ? 1 : 2;
    }

    private int d() {
        String a6 = a("ro.product.model");
        if (a6 == null) {
            return 0;
        }
        String lowerCase = a6.toLowerCase();
        return (lowerCase.contains("google_sdk") || lowerCase.contains("emulator") || lowerCase.contains("android sdk built for x86")) ? 1 : 2;
    }

    private q() {
    }

    private int e() {
        String a6 = a("ro.product.manufacturer");
        if (a6 == null) {
            return 0;
        }
        String lowerCase = a6.toLowerCase();
        return (lowerCase.contains("genymotion") || lowerCase.contains("netease")) ? 1 : 2;
    }

    private int f() {
        String a6 = a("ro.product.board");
        if (a6 == null) {
            return 0;
        }
        String lowerCase = a6.toLowerCase();
        return (lowerCase.contains(FaceEnvironment.OS) || lowerCase.contains("goldfish")) ? 1 : 2;
    }

    private int g() {
        String a6 = a("ro.board.platform");
        if (a6 == null) {
            return 0;
        }
        return a6.toLowerCase().contains(FaceEnvironment.OS) ? 1 : 2;
    }

    private int h() {
        String a6 = a("gsm.version.baseband");
        if (a6 == null) {
            return 0;
        }
        return a6.contains(d.a("MS4wLjAuMA==")) ? 1 : 2;
    }

    public boolean a(Context context) {
        int i6;
        if (context == null) {
            return true;
        }
        int b6 = b();
        if (b6 == 0) {
            i6 = 1;
        } else {
            if (b6 == 1) {
                return true;
            }
            i6 = 0;
        }
        int c6 = c();
        if (c6 == 0) {
            i6++;
        } else if (c6 == 1) {
            return true;
        }
        int d6 = d();
        if (d6 == 0) {
            i6++;
        } else if (d6 == 1) {
            return true;
        }
        int e6 = e();
        if (e6 == 0) {
            i6++;
        } else if (e6 == 1) {
            return true;
        }
        int f6 = f();
        if (f6 == 0) {
            i6++;
        } else if (f6 == 1) {
            return true;
        }
        int g6 = g();
        if (g6 == 0) {
            i6++;
        } else if (g6 == 1) {
            return true;
        }
        int h6 = h();
        if (h6 == 0) {
            i6 += 2;
        } else if (h6 == 1) {
            return true;
        }
        if (!c(context)) {
            i6++;
        }
        if (!b(context)) {
            i6++;
        }
        if (!d(context)) {
            i6++;
        }
        return i6 > 3;
    }

    private boolean b(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.camera");
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private boolean c(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private boolean d(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private String a(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod(l3.f4736f, String.class).invoke(null, str);
            if (invoke != null) {
                return (String) invoke;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
