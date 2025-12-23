package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class w3 extends ContextThemeWrapper {

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f7498f = {"android.widget", "android.webkit", "android.app"};

    /* renamed from: a, reason: collision with root package name */
    private Resources f7499a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutInflater f7500b;

    /* renamed from: c, reason: collision with root package name */
    private ClassLoader f7501c;

    /* renamed from: d, reason: collision with root package name */
    private b f7502d;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater.Factory f7503e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements LayoutInflater.Factory {
        a() {
        }

        @Override // android.view.LayoutInflater.Factory
        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return w3.this.b(str, context, attributeSet);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public HashSet<String> f7505a = new HashSet<>();

        /* renamed from: b, reason: collision with root package name */
        public HashMap<String, Constructor<?>> f7506b = new HashMap<>();

        public b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View b(java.lang.String r12, android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r11 = this;
            com.amap.api.col.3l.w3$b r0 = r11.f7502d
            java.util.HashSet<java.lang.String> r0 = r0.f7505a
            boolean r0 = r0.contains(r12)
            r1 = 0
            if (r0 == 0) goto Lc
            return r1
        Lc:
            com.amap.api.col.3l.w3$b r0 = r11.f7502d
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r0 = r0.f7506b
            java.lang.Object r0 = r0.get(r12)
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L8b
            java.lang.String r5 = "api.navi"
            boolean r5 = r12.contains(r5)     // Catch: java.lang.Throwable -> L2a
            if (r5 == 0) goto L2c
            java.lang.ClassLoader r5 = r11.f7501c     // Catch: java.lang.Throwable -> L2a
            java.lang.Class r5 = r5.loadClass(r12)     // Catch: java.lang.Throwable -> L2a
            goto L53
        L2a:
            goto L68
        L2c:
            java.lang.String[] r5 = com.amap.api.col.p0003l.w3.f7498f     // Catch: java.lang.Throwable -> L2a
            int r6 = r5.length     // Catch: java.lang.Throwable -> L2a
            r7 = 0
        L30:
            if (r7 >= r6) goto L52
            r8 = r5[r7]     // Catch: java.lang.Throwable -> L2a
            java.lang.ClassLoader r9 = r11.f7501c     // Catch: java.lang.Throwable -> L4f
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r10.<init>()     // Catch: java.lang.Throwable -> L4f
            r10.append(r8)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r8 = "."
            r10.append(r8)     // Catch: java.lang.Throwable -> L4f
            r10.append(r12)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Throwable -> L4f
            java.lang.Class r5 = r9.loadClass(r8)     // Catch: java.lang.Throwable -> L4f
            goto L53
        L4f:
            int r7 = r7 + 1
            goto L30
        L52:
            r5 = r1
        L53:
            if (r5 != 0) goto L56
            goto L66
        L56:
            java.lang.Class<android.view.ViewStub> r6 = android.view.ViewStub.class
            if (r5 == r6) goto L66
            java.lang.ClassLoader r6 = r5.getClassLoader()     // Catch: java.lang.Throwable -> L65
            java.lang.ClassLoader r7 = r11.f7501c     // Catch: java.lang.Throwable -> L65
            if (r6 == r7) goto L63
            goto L66
        L63:
            r6 = 1
            goto L6a
        L65:
        L66:
            r6 = 0
            goto L6a
        L68:
            r5 = r1
            goto L66
        L6a:
            if (r6 != 0) goto L74
            com.amap.api.col.3l.w3$b r13 = r11.f7502d
            java.util.HashSet<java.lang.String> r13 = r13.f7505a
            r13.add(r12)
            return r1
        L74:
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L8a
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r4] = r7     // Catch: java.lang.Throwable -> L8a
            java.lang.Class<android.util.AttributeSet> r7 = android.util.AttributeSet.class
            r6[r3] = r7     // Catch: java.lang.Throwable -> L8a
            java.lang.reflect.Constructor r0 = r5.getConstructor(r6)     // Catch: java.lang.Throwable -> L8a
            com.amap.api.col.3l.w3$b r5 = r11.f7502d     // Catch: java.lang.Throwable -> L8a
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r5 = r5.f7506b     // Catch: java.lang.Throwable -> L8a
            r5.put(r12, r0)     // Catch: java.lang.Throwable -> L8a
            goto L8b
        L8a:
        L8b:
            if (r0 == 0) goto L9b
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L9b
            r12[r4] = r13     // Catch: java.lang.Throwable -> L9b
            r12[r3] = r14     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r12 = r0.newInstance(r12)     // Catch: java.lang.Throwable -> L9b
            android.view.View r12 = (android.view.View) r12     // Catch: java.lang.Throwable -> L9b
            r1 = r12
        L9b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.w3.b(java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources = this.f7499a;
        return resources != null ? resources : super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.f7500b == null) {
            LayoutInflater layoutInflater = (LayoutInflater) super.getSystemService(str);
            if (layoutInflater != null) {
                this.f7500b = layoutInflater.cloneInContext(this);
            }
            this.f7500b.setFactory(this.f7503e);
            this.f7500b = this.f7500b.cloneInContext(this);
        }
        return this.f7500b;
    }

    public w3(Context context, int i6, ClassLoader classLoader) {
        super(context, i6);
        this.f7502d = new b();
        this.f7503e = new a();
        this.f7499a = x3.b();
        this.f7501c = classLoader;
    }
}
