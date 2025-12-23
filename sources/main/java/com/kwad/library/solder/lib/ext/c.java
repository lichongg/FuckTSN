package com.kwad.library.solder.lib.ext;

import android.os.Build;
import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private final int aqS;
    private final String arg;
    private final String arh;
    private final String ari;
    private final String arj;
    private final String ark;
    private final String arl;
    private final String arm;
    private final boolean arn;
    private final boolean aro;
    private final boolean arp;
    private ExecutorService arq;
    private String arr;
    private byte[] ars;
    private boolean art;
    private int aru;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private static final String arv;
        private String arm;
        private boolean arp;
        private ExecutorService arq;
        private String arr;
        private byte[] ars;
        private boolean art;
        private int arw;
        private int aqS = 3;
        private String arg = "sodler";
        private String arh = "code-cache";
        private String ari = "lib";
        private String arj = "temp";
        private String arl = arv;
        private String ark = ".tmp";
        private boolean aro = false;
        private boolean arn = false;

        public final a bk(boolean z5) {
            this.art = false;
            return this;
        }

        private static boolean Ax() {
            int i6 = Build.VERSION.SDK_INT;
            return i6 == 30 || i6 == 31 || i6 == 32;
        }

        public final c Ay() {
            return new c(this.arn, this.aro, this.arm, this.arg, this.arh, this.ari, this.arj, this.ark, this.arl, this.aqS, this.arr, this.ars, this.art, this.arp, this.arq, this.arw, (byte) 0);
        }

        public final a a(ExecutorService executorService) {
            this.arq = executorService;
            return this;
        }

        public final a bZ(@NonNull String str) {
            this.arg = str;
            return this;
        }

        public final a bl(boolean z5) {
            this.arp = z5;
            return this;
        }

        public final a cj(int i6) {
            if (i6 > 0) {
                this.aqS = i6;
            }
            return this;
        }

        public final a ck(int i6) {
            this.arw = i6;
            return this;
        }

        static {
            String str;
            if (Ax()) {
                str = "base-1_apk";
            } else {
                str = "base-1.apk";
            }
            arv = str;
        }
    }

    /* synthetic */ c(boolean z5, boolean z6, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i6, String str8, byte[] bArr, boolean z7, boolean z8, ExecutorService executorService, int i7, byte b6) {
        this(z5, z6, str, str2, str3, str4, str5, str6, str7, i6, str8, bArr, z7, z8, executorService, i7);
    }

    private c(boolean z5, boolean z6, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i6, String str8, byte[] bArr, boolean z7, boolean z8, ExecutorService executorService, int i7) {
        this.aqS = i6;
        this.arg = str2;
        this.arh = str3;
        this.ari = str4;
        this.arj = str5;
        this.ark = str6;
        this.arl = str7;
        this.arm = str;
        this.arn = z5;
        this.aro = z6;
        this.arr = str8;
        this.ars = bArr;
        this.art = z7;
        this.arp = z8;
        this.arq = executorService;
        this.aru = i7;
    }

    public final int An() {
        return this.aru;
    }

    public final String Ao() {
        return this.arg;
    }

    public final String Ap() {
        return this.arh;
    }

    public final String Aq() {
        return this.ari;
    }

    public final String Ar() {
        return this.arj;
    }

    public final String As() {
        return this.ark;
    }

    public final String At() {
        return this.arl;
    }

    public final boolean Au() {
        return this.aro;
    }

    public final boolean Av() {
        return this.arp;
    }

    public final ExecutorService Aw() {
        return this.arq;
    }

    public final int getRetryCount() {
        return this.aqS;
    }
}
