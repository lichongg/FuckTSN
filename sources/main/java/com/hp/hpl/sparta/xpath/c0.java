package com.hp.hpl.sparta.xpath;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class c0 {

    /* renamed from: d, reason: collision with root package name */
    private static final int f32876d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static Hashtable f32877e = new Hashtable();

    /* renamed from: a, reason: collision with root package name */
    private Stack f32878a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f32879b;

    /* renamed from: c, reason: collision with root package name */
    private String f32880c;

    private c0(boolean z5, t[] tVarArr) {
        this.f32878a = new Stack();
        for (t tVar : tVarArr) {
            this.f32878a.addElement(tVar);
        }
        this.f32879b = z5;
        this.f32880c = null;
    }

    private String a() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration elements = this.f32878a.elements();
        boolean z5 = true;
        while (elements.hasMoreElements()) {
            t tVar = (t) elements.nextElement();
            if (!z5 || this.f32879b) {
                stringBuffer.append('/');
                if (tVar.c()) {
                    stringBuffer.append('/');
                }
            }
            stringBuffer.append(tVar.toString());
            z5 = false;
        }
        return stringBuffer.toString();
    }

    public static c0 b(String str) throws XPathException {
        c0 c0Var;
        synchronized (f32877e) {
            try {
                c0Var = (c0) f32877e.get(str);
                if (c0Var == null) {
                    c0Var = new c0(str);
                    f32877e.put(str, c0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0Var;
    }

    public static c0 c(boolean z5, t[] tVarArr) {
        c0 c0Var = new c0(z5, tVarArr);
        String c0Var2 = c0Var.toString();
        synchronized (f32877e) {
            try {
                c0 c0Var3 = (c0) f32877e.get(c0Var2);
                if (c0Var3 != null) {
                    return c0Var3;
                }
                f32877e.put(c0Var2, c0Var);
                return c0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object clone() {
        int size = this.f32878a.size();
        t[] tVarArr = new t[size];
        Enumeration elements = this.f32878a.elements();
        for (int i6 = 0; i6 < size; i6++) {
            tVarArr[i6] = (t) elements.nextElement();
        }
        return new c0(this.f32879b, tVarArr);
    }

    public String d() throws XPathException {
        k b6 = ((t) this.f32878a.peek()).b();
        if (b6 instanceof d) {
            return ((d) b6).b();
        }
        throw new XPathException(this, "has no indexing attribute name (must end with predicate of the form [@attrName]");
    }

    public String e() throws XPathException {
        k b6 = ((t) this.f32878a.peek()).b();
        if (b6 instanceof c) {
            return ((c) b6).b();
        }
        return null;
    }

    public Enumeration f() {
        return this.f32878a.elements();
    }

    public boolean g() {
        return this.f32879b;
    }

    public boolean h() {
        return ((t) this.f32878a.peek()).d();
    }

    public String toString() {
        if (this.f32880c == null) {
            this.f32880c = a();
        }
        return this.f32880c;
    }

    public static boolean i(String str) throws XPathException, IOException {
        return b(str).h();
    }

    private c0(String str) throws XPathException {
        this(str, new InputStreamReader(new ByteArrayInputStream(str.getBytes())));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004f A[Catch: IOException -> 0x003a, TryCatch #0 {IOException -> 0x003a, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:8:0x0041, B:9:0x004b, B:11:0x004f, B:13:0x0055, B:15:0x005b, B:23:0x006a, B:24:0x0073, B:27:0x003e), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[EDGE_INSN: B:18:0x0066->B:19:0x0066 BREAK  A[LOOP:0: B:9:0x004b->B:15:0x005b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[Catch: IOException -> 0x003a, TryCatch #0 {IOException -> 0x003a, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:8:0x0041, B:9:0x004b, B:11:0x004f, B:13:0x0055, B:15:0x005b, B:23:0x006a, B:24:0x0073, B:27:0x003e), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private c0(java.lang.String r6, java.io.Reader r7) throws com.hp.hpl.sparta.xpath.XPathException {
        /*
            r5 = this;
            r5.<init>()
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r5.f32878a = r0
            r5.f32880c = r6     // Catch: java.io.IOException -> L3a
            com.hp.hpl.sparta.xpath.s r6 = new com.hp.hpl.sparta.xpath.s     // Catch: java.io.IOException -> L3a
            r6.<init>(r7)     // Catch: java.io.IOException -> L3a
            r7 = 47
            r6.b(r7)     // Catch: java.io.IOException -> L3a
            r0 = 46
            r6.b(r0)     // Catch: java.io.IOException -> L3a
            r0 = 58
            r6.d(r0, r0)     // Catch: java.io.IOException -> L3a
            r0 = 95
            r6.d(r0, r0)     // Catch: java.io.IOException -> L3a
            int r0 = r6.a()     // Catch: java.io.IOException -> L3a
            r1 = 1
            r2 = 0
            if (r0 != r7) goto L3e
            r5.f32879b = r1     // Catch: java.io.IOException -> L3a
            int r0 = r6.a()     // Catch: java.io.IOException -> L3a
            if (r0 != r7) goto L3c
            r6.a()     // Catch: java.io.IOException -> L3a
            r0 = 1
            goto L41
        L3a:
            r6 = move-exception
            goto L74
        L3c:
            r0 = 0
            goto L41
        L3e:
            r5.f32879b = r2     // Catch: java.io.IOException -> L3a
            goto L3c
        L41:
            java.util.Stack r3 = r5.f32878a     // Catch: java.io.IOException -> L3a
            com.hp.hpl.sparta.xpath.t r4 = new com.hp.hpl.sparta.xpath.t     // Catch: java.io.IOException -> L3a
            r4.<init>(r5, r0, r6)     // Catch: java.io.IOException -> L3a
            r3.push(r4)     // Catch: java.io.IOException -> L3a
        L4b:
            int r0 = r6.f32892a     // Catch: java.io.IOException -> L3a
            if (r0 != r7) goto L66
            int r0 = r6.a()     // Catch: java.io.IOException -> L3a
            if (r0 != r7) goto L5a
            r6.a()     // Catch: java.io.IOException -> L3a
            r0 = 1
            goto L5b
        L5a:
            r0 = 0
        L5b:
            java.util.Stack r3 = r5.f32878a     // Catch: java.io.IOException -> L3a
            com.hp.hpl.sparta.xpath.t r4 = new com.hp.hpl.sparta.xpath.t     // Catch: java.io.IOException -> L3a
            r4.<init>(r5, r0, r6)     // Catch: java.io.IOException -> L3a
            r3.push(r4)     // Catch: java.io.IOException -> L3a
            goto L4b
        L66:
            r7 = -1
            if (r0 != r7) goto L6a
            return
        L6a:
            com.hp.hpl.sparta.xpath.XPathException r7 = new com.hp.hpl.sparta.xpath.XPathException     // Catch: java.io.IOException -> L3a
            java.lang.String r0 = "at end of XPATH expression"
            java.lang.String r1 = "end of expression"
            r7.<init>(r5, r0, r6, r1)     // Catch: java.io.IOException -> L3a
            throw r7     // Catch: java.io.IOException -> L3a
        L74:
            com.hp.hpl.sparta.xpath.XPathException r7 = new com.hp.hpl.sparta.xpath.XPathException
            r7.<init>(r5, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.xpath.c0.<init>(java.lang.String, java.io.Reader):void");
    }
}
