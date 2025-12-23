package org.junit.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.FilterFactory;
import org.junit.runners.model.InitializationError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class JUnitCommandLineParseResult {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f51491a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<Class<?>> f51492b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<Throwable> f51493c = new ArrayList();

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0096, code lost:
    
        return new java.lang.String[0];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String[] i(java.lang.String... r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            int r2 = r8.length
            if (r1 == r2) goto L94
            r2 = r8[r1]
            java.lang.String r3 = "--"
            boolean r4 = r2.equals(r3)
            if (r4 == 0) goto L17
            int r1 = r1 + 1
            int r0 = r8.length
            java.lang.String[] r8 = r7.b(r8, r1, r0)
            return r8
        L17:
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L8e
            java.lang.String r3 = "--filter="
            boolean r3 = r2.startsWith(r3)
            java.lang.String r4 = "--filter"
            if (r3 != 0) goto L4f
            boolean r3 = r2.equals(r4)
            if (r3 == 0) goto L2e
            goto L4f
        L2e:
            java.util.List<java.lang.Throwable> r3 = r7.f51493c
            org.junit.runner.JUnitCommandLineParseResult$CommandLineParserError r4 = new org.junit.runner.JUnitCommandLineParseResult$CommandLineParserError
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "JUnit knows nothing about the "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = " option"
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4.<init>(r2)
            r3.add(r4)
            goto L8a
        L4f:
            boolean r3 = r2.equals(r4)
            if (r3 == 0) goto L79
            int r1 = r1 + 1
            int r3 = r8.length
            if (r1 >= r3) goto L5d
            r2 = r8[r1]
            goto L85
        L5d:
            java.util.List<java.lang.Throwable> r8 = r7.f51493c
            org.junit.runner.JUnitCommandLineParseResult$CommandLineParserError r1 = new org.junit.runner.JUnitCommandLineParseResult$CommandLineParserError
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = " value not specified"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            r8.add(r1)
            goto L94
        L79:
            r3 = 61
            int r3 = r2.indexOf(r3)
            int r3 = r3 + 1
            java.lang.String r2 = r2.substring(r3)
        L85:
            java.util.List<java.lang.String> r3 = r7.f51491a
            r3.add(r2)
        L8a:
            int r1 = r1 + 1
            goto L2
        L8e:
            int r0 = r8.length
            java.lang.String[] r8 = r7.b(r8, r1, r0)
            return r8
        L94:
            java.lang.String[] r8 = new java.lang.String[r0]
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.runner.JUnitCommandLineParseResult.i(java.lang.String[]):java.lang.String[]");
    }

    void j(String[] strArr) {
        for (String str : strArr) {
            try {
                this.f51492b.add(org.junit.internal.a.a(str));
            } catch (ClassNotFoundException e6) {
                this.f51493c.add(new IllegalArgumentException("Could not find class [" + str + "]", e6));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CommandLineParserError extends Exception {
        private static final long serialVersionUID = 1;

        public CommandLineParserError(String str) {
            super(str);
        }
    }

    private f a(f fVar) {
        try {
            Iterator<String> it = this.f51491a.iterator();
            while (it.hasNext()) {
                fVar = fVar.g(c.e(fVar, it.next()));
            }
            return fVar;
        } catch (FilterFactory.FilterNotCreatedException e6) {
            return d(e6);
        }
    }

    private String[] b(String[] strArr, int i6, int i7) {
        ArrayList arrayList = new ArrayList();
        while (i6 != i7) {
            arrayList.add(strArr[i6]);
            i6++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private f d(Throwable th) {
        return f.e(JUnitCommandLineParseResult.class, th);
    }

    public static JUnitCommandLineParseResult g(String[] strArr) {
        JUnitCommandLineParseResult jUnitCommandLineParseResult = new JUnitCommandLineParseResult();
        jUnitCommandLineParseResult.h(strArr);
        return jUnitCommandLineParseResult;
    }

    public f c(a aVar) {
        if (!this.f51493c.isEmpty()) {
            return d(new InitializationError(this.f51493c));
        }
        List<Class<?>> list = this.f51492b;
        return a(f.c(aVar, (Class[]) list.toArray(new Class[list.size()])));
    }

    public List<Class<?>> e() {
        return Collections.unmodifiableList(this.f51492b);
    }

    public List<String> f() {
        return Collections.unmodifiableList(this.f51491a);
    }

    JUnitCommandLineParseResult() {
    }

    private void h(String[] strArr) {
        j(i(strArr));
    }
}
