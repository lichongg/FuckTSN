package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.ProtocolException;
import java.io.IOException;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f extends i {

    /* renamed from: u, reason: collision with root package name */
    private static final char[] f39436u = {'.', 'H', 'E', 'A', 'D', 'E', 'R'};

    /* renamed from: v, reason: collision with root package name */
    private static final char[] f39437v = {'.', 'T', 'E', 'X', 'T'};

    /* renamed from: t, reason: collision with root package name */
    private l[] f39438t;

    public f(com.sun.mail.iap.f fVar) throws IOException, ProtocolException {
        super(fVar);
        l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.sun.mail.imap.protocol.l K(com.sun.mail.iap.g[] r7, int r8, java.lang.Class r9) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            r1 = 0
            r2 = 0
        L6:
            int r3 = r7.length
            if (r2 < r3) goto La
            return r0
        La:
            r3 = r7[r2]
            if (r3 == 0) goto L36
            boolean r4 = r3 instanceof com.sun.mail.imap.protocol.f
            if (r4 == 0) goto L36
            com.sun.mail.imap.protocol.f r3 = (com.sun.mail.imap.protocol.f) r3
            int r3 = r3.E()
            if (r3 == r8) goto L1b
            goto L36
        L1b:
            r3 = r7[r2]
            com.sun.mail.imap.protocol.f r3 = (com.sun.mail.imap.protocol.f) r3
            r4 = 0
        L20:
            com.sun.mail.imap.protocol.l[] r5 = r3.f39438t
            int r6 = r5.length
            if (r4 < r6) goto L26
            goto L36
        L26:
            r5 = r5[r4]
            boolean r5 = r9.isInstance(r5)
            if (r5 == 0) goto L33
            com.sun.mail.imap.protocol.l[] r7 = r3.f39438t
            r7 = r7[r4]
            return r7
        L33:
            int r4 = r4 + 1
            goto L20
        L36:
            int r2 = r2 + 1
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.f.K(com.sun.mail.iap.g[], int, java.lang.Class):com.sun.mail.imap.protocol.l");
    }

    private boolean M(char[] cArr) {
        int length = cArr.length;
        int i6 = this.f39207a;
        int i7 = 0;
        while (i7 < length) {
            int i8 = i6 + 1;
            int i9 = i7 + 1;
            if (Character.toUpperCase((char) this.f39210d[i6]) != cArr[i7]) {
                return false;
            }
            i7 = i9;
            i6 = i8;
        }
        return true;
    }

    public l J(Class cls) {
        int i6 = 0;
        while (true) {
            l[] lVarArr = this.f39438t;
            if (i6 >= lVarArr.length) {
                return null;
            }
            if (cls.isInstance(lVarArr[i6])) {
                return this.f39438t[i6];
            }
            i6++;
        }
    }

    public l I(int i6) {
        return this.f39438t[i6];
    }

    public int L() {
        return this.f39438t.length;
    }

    public f(i iVar) throws IOException, ProtocolException {
        super(iVar);
        l();
    }

    private void l() throws ParsingException {
        byte[] bArr;
        int i6;
        B();
        if (this.f39210d[this.f39207a] == 40) {
            Vector vector = new Vector();
            Object obj = null;
            do {
                int i7 = this.f39207a + 1;
                this.f39207a = i7;
                if (i7 < this.f39209c) {
                    byte b6 = this.f39210d[i7];
                    if (b6 != 66) {
                        if (b6 != 73) {
                            if (b6 != 82) {
                                if (b6 != 85) {
                                    if (b6 != 69) {
                                        if (b6 == 70) {
                                            char[] cArr = FLAGS.name;
                                            if (M(cArr)) {
                                                this.f39207a += cArr.length;
                                                obj = new FLAGS(this);
                                            }
                                        }
                                    } else {
                                        char[] cArr2 = e.f39423l;
                                        if (M(cArr2)) {
                                            this.f39207a += cArr2.length;
                                            obj = new e(this);
                                        }
                                    }
                                } else {
                                    char[] cArr3 = v.f39508c;
                                    if (M(cArr3)) {
                                        this.f39207a += cArr3.length;
                                        obj = new v(this);
                                    }
                                }
                            } else {
                                char[] cArr4 = r.f39496c;
                                if (M(cArr4)) {
                                    this.f39207a += cArr4.length;
                                    obj = new r(this);
                                } else {
                                    char[] cArr5 = q.f39493c;
                                    if (M(cArr5)) {
                                        this.f39207a += cArr5.length;
                                        char[] cArr6 = f39436u;
                                        if (M(cArr6)) {
                                            this.f39207a += cArr6.length;
                                        } else {
                                            char[] cArr7 = f39437v;
                                            if (M(cArr7)) {
                                                this.f39207a += cArr7.length;
                                            }
                                        }
                                        obj = new q(this);
                                    }
                                }
                            }
                        } else {
                            char[] cArr8 = k.f39464c;
                            if (M(cArr8)) {
                                this.f39207a += cArr8.length;
                                obj = new k(this);
                            }
                        }
                    } else {
                        char[] cArr9 = c.f39396e;
                        if (M(cArr9)) {
                            byte[] bArr2 = this.f39210d;
                            int i8 = this.f39207a;
                            if (bArr2[i8 + 4] == 91) {
                                this.f39207a = i8 + cArr9.length;
                                obj = new c(this);
                            } else {
                                char[] cArr10 = d.f39401r;
                                if (M(cArr10)) {
                                    this.f39207a += cArr10.length;
                                } else {
                                    this.f39207a += cArr9.length;
                                }
                                obj = new d(this);
                            }
                        }
                    }
                    if (obj != null) {
                        vector.addElement(obj);
                    }
                    bArr = this.f39210d;
                    i6 = this.f39207a;
                } else {
                    throw new ParsingException("error in FETCH parsing, ran off end of buffer, size " + this.f39209c);
                }
            } while (bArr[i6] != 41);
            this.f39207a = i6 + 1;
            l[] lVarArr = new l[vector.size()];
            this.f39438t = lVarArr;
            vector.copyInto(lVarArr);
            return;
        }
        throw new ParsingException("error in FETCH parsing, missing '(' at index " + this.f39207a);
    }
}
