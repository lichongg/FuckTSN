package org.apache.commons.net.tftp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends a {

    /* renamed from: v, reason: collision with root package name */
    public static final int f51197v = 5;

    /* renamed from: t, reason: collision with root package name */
    private long f51199t = 0;

    /* renamed from: u, reason: collision with root package name */
    private long f51200u = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f51198s = 5;

    public void J(int i6) {
        if (i6 < 1) {
            this.f51198s = 1;
        } else {
            this.f51198s = i6;
        }
    }

    public long A() {
        return this.f51200u;
    }

    public int D(String str, int i6, OutputStream outputStream, InetAddress inetAddress) throws IOException {
        return E(str, i6, outputStream, inetAddress, 69);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x015d, code lost:
    
        if (r13 == (r11 != 0 ? r11 - 1 : 65535)) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x01ca, code lost:
    
        r7.i(r13);
        r12 = r12 + r14;
        r22 = r2;
        r19.f51199t += r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x01d8, code lost:
    
        if (r14 == 512) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01da, code lost:
    
        r(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01e0, code lost:
    
        return r12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01e9 A[LOOP:1: B:8:0x0037->B:28:0x01e9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01ca A[EDGE_INSN: B:29:0x01ca->B:30:0x01ca BREAK  A[LOOP:1: B:8:0x0037->B:28:0x01e9], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r19v0, types: [org.apache.commons.net.tftp.a, org.apache.commons.net.tftp.c] */
    /* JADX WARN: Type inference failed for: r7v1, types: [org.apache.commons.net.tftp.b, org.apache.commons.net.tftp.f] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int E(java.lang.String r20, int r21, java.io.OutputStream r22, java.net.InetAddress r23, int r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.tftp.c.E(java.lang.String, int, java.io.OutputStream, java.net.InetAddress, int):int");
    }

    public void H(String str, int i6, InputStream inputStream, InetAddress inetAddress) throws IOException {
        I(str, i6, inputStream, inetAddress, 69);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x013a, code lost:
    
        if (r12 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0140, code lost:
    
        r3 = 4;
        r4 = 512;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0146, code lost:
    
        if (r4 <= 0) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0148, code lost:
    
        r13 = r10.read(r17.f51195j, r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x014e, code lost:
    
        if (r13 <= 0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0150, code lost:
    
        r3 = r3 + r13;
        r4 = r4 - r13;
        r11 = r11 + r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0154, code lost:
    
        if (r11 >= 512) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0156, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x013f, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x016b A[LOOP:1: B:8:0x003b->B:28:0x016b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013a A[EDGE_INSN: B:29:0x013a->B:30:0x013a BREAK  A[LOOP:1: B:8:0x003b->B:28:0x016b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void I(java.lang.String r18, int r19, java.io.InputStream r20, java.net.InetAddress r21, int r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.tftp.c.I(java.lang.String, int, java.io.InputStream, java.net.InetAddress, int):void");
    }

    public int y() {
        return this.f51198s;
    }

    public long z() {
        return this.f51199t;
    }

    public int B(String str, int i6, OutputStream outputStream, String str2) throws UnknownHostException, IOException {
        return E(str, i6, outputStream, InetAddress.getByName(str2), 69);
    }

    public int C(String str, int i6, OutputStream outputStream, String str2, int i7) throws UnknownHostException, IOException {
        return E(str, i6, outputStream, InetAddress.getByName(str2), i7);
    }

    public void F(String str, int i6, InputStream inputStream, String str2) throws UnknownHostException, IOException {
        I(str, i6, inputStream, InetAddress.getByName(str2), 69);
    }

    public void G(String str, int i6, InputStream inputStream, String str2, int i7) throws UnknownHostException, IOException {
        I(str, i6, inputStream, InetAddress.getByName(str2), i7);
    }
}
