package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.amap.api.services.core.AMapException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class e {

    /* renamed from: o, reason: collision with root package name */
    private static final String f16020o = new String();

    /* renamed from: a, reason: collision with root package name */
    private final String f16021a;

    /* renamed from: b, reason: collision with root package name */
    private final h f16022b;

    /* renamed from: c, reason: collision with root package name */
    private int f16023c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f16024d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16025e;

    /* renamed from: f, reason: collision with root package name */
    private String f16026f;

    /* renamed from: g, reason: collision with root package name */
    private final List<TypeSpec> f16027g;

    /* renamed from: h, reason: collision with root package name */
    private final Set<String> f16028h;

    /* renamed from: i, reason: collision with root package name */
    private final Set<String> f16029i;

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, c> f16030j;

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, c> f16031k;

    /* renamed from: l, reason: collision with root package name */
    private final Set<String> f16032l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f16033m;

    /* renamed from: n, reason: collision with root package name */
    int f16034n;

    e(Appendable appendable) {
        this(appendable, "  ", Collections.EMPTY_SET);
    }

    private void g() throws IOException {
        for (int i6 = 0; i6 < this.f16023c; i6++) {
            this.f16022b.a(this.f16021a);
        }
    }

    private boolean l(String str, String str2) throws IOException {
        String substring = str2.substring(1);
        if (substring.isEmpty() || !Character.isJavaIdentifierStart(substring.charAt(0))) {
            return false;
        }
        String str3 = str + "." + o(substring);
        String str4 = str + ".*";
        if (!this.f16029i.contains(str3) && !this.f16029i.contains(str4)) {
            return false;
        }
        d(substring);
        return true;
    }

    private static String o(String str) {
        n.b(Character.isJavaIdentifierStart(str.charAt(0)), "not an identifier: %s", str);
        for (int i6 = 1; i6 <= str.length(); i6++) {
            if (!SourceVersion.isIdentifier(str.substring(0, i6))) {
                return str.substring(0, i6 - 1);
            }
        }
        return str;
    }

    public e B() {
        return C(1);
    }

    public void f(d dVar) throws IOException {
        this.f16033m = true;
        this.f16025e = true;
        try {
            a(dVar);
            b(com.snail.antifake.deviceid.e.f37542d);
        } finally {
            this.f16025e = false;
        }
    }

    public e r() {
        return s(1);
    }

    String t(c cVar) {
        c cVar2 = cVar;
        boolean z5 = false;
        while (cVar2 != null) {
            c y5 = y(cVar2.I());
            boolean z6 = y5 != null;
            if (Objects.equals(y5, cVar2)) {
                return n.j(".", cVar.J().subList(cVar2.J().size() - 1, cVar.J().size()));
            }
            cVar2 = cVar2.v();
            z5 = z6;
        }
        if (z5) {
            return cVar.f16013x;
        }
        if (Objects.equals(this.f16026f, cVar.E())) {
            this.f16032l.add(cVar.K().I());
            return n.j(".", cVar.J());
        }
        if (!this.f16024d) {
            p(cVar);
        }
        return cVar.f16013x;
    }

    e(Appendable appendable, String str, Set<String> set) {
        this(appendable, str, Collections.EMPTY_MAP, set);
    }

    private void i(Object obj) throws IOException {
        if (obj instanceof TypeSpec) {
            ((TypeSpec) obj).b(this, null, Collections.EMPTY_SET);
            return;
        }
        if (obj instanceof a) {
            ((a) obj).c(this, true);
        } else if (obj instanceof d) {
            a((d) obj);
        } else {
            d(String.valueOf(obj));
        }
    }

    private c y(String str) {
        for (int size = this.f16027g.size() - 1; size >= 0; size--) {
            Iterator<TypeSpec> it = this.f16027g.get(size).f15987o.iterator();
            while (it.hasNext()) {
                if (Objects.equals(it.next().f15974b, str)) {
                    return z(size, str);
                }
            }
        }
        if (this.f16027g.size() > 0 && Objects.equals(this.f16027g.get(0).f15974b, str)) {
            return c.x(this.f16026f, str, new String[0]);
        }
        c cVar = this.f16030j.get(str);
        if (cVar != null) {
            return cVar;
        }
        return null;
    }

    private c z(int i6, String str) {
        c x5 = c.x(this.f16026f, this.f16027g.get(0).f15974b, new String[0]);
        for (int i7 = 1; i7 <= i6; i7++) {
            x5 = x5.D(this.f16027g.get(i7).f15974b);
        }
        return x5.D(str);
    }

    Map<String, c> A() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f16031k);
        linkedHashMap.keySet().removeAll(this.f16032l);
        return linkedHashMap;
    }

    public e C(int i6) {
        n.b(this.f16023c - i6 >= 0, "cannot unindent %s from %s", Integer.valueOf(i6), Integer.valueOf(this.f16023c));
        this.f16023c -= i6;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [com.bumptech.glide.repackaged.com.squareup.javapoet.l] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.bumptech.glide.repackaged.com.squareup.javapoet.l] */
    public e a(d dVar) throws IOException {
        char c6;
        int i6;
        ListIterator<String> listIterator = dVar.f16016a.listIterator();
        c cVar = null;
        int i7 = 0;
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            next.getClass();
            switch (next.hashCode()) {
                case 1152:
                    if (next.equals("$$")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1176:
                    if (next.equals("$<")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1178:
                    if (next.equals("$>")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1192:
                    if (next.equals("$L")) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1194:
                    if (next.equals("$N")) {
                        c6 = 4;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1199:
                    if (next.equals("$S")) {
                        c6 = 5;
                        break;
                    }
                    c6 = 65535;
                    break;
                case AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS /* 1200 */:
                    if (next.equals("$T")) {
                        c6 = 6;
                        break;
                    }
                    c6 = 65535;
                    break;
                case AMapException.CODE_AMAP_SERVICE_UNKNOWN_ERROR /* 1203 */:
                    if (next.equals("$W")) {
                        c6 = 7;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1207:
                    if (next.equals("$[")) {
                        c6 = '\b';
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1209:
                    if (next.equals("$]")) {
                        c6 = '\t';
                        break;
                    }
                    c6 = 65535;
                    break;
                default:
                    c6 = 65535;
                    break;
            }
            switch (c6) {
                case 0:
                    d("$");
                    continue;
                case 1:
                    B();
                    continue;
                case 2:
                    r();
                    continue;
                case 3:
                    i6 = i7 + 1;
                    i(dVar.f16017b.get(i7));
                    break;
                case 4:
                    i6 = i7 + 1;
                    d((String) dVar.f16017b.get(i7));
                    break;
                case 5:
                    i6 = i7 + 1;
                    String str = (String) dVar.f16017b.get(i7);
                    d(str != null ? n.l(str, this.f16021a) : "null");
                    break;
                case 6:
                    i6 = i7 + 1;
                    ?? r32 = (l) dVar.f16017b.get(i7);
                    boolean n6 = r32.n();
                    c cVar2 = r32;
                    if (n6) {
                        r32.i(this);
                        cVar2 = r32.r();
                    }
                    if ((cVar2 instanceof c) && listIterator.hasNext() && !dVar.f16016a.get(listIterator.nextIndex()).startsWith("$")) {
                        c cVar3 = cVar2;
                        if (this.f16028h.contains(cVar3.f16013x)) {
                            n.d(cVar == null, "pending type for static import?!", new Object[0]);
                            cVar = cVar3;
                            break;
                        }
                    }
                    cVar2.h(this);
                    break;
                case 7:
                    this.f16022b.c(this.f16023c + 2);
                    continue;
                case '\b':
                    n.d(this.f16034n == -1, "statement enter $[ followed by statement enter $[", new Object[0]);
                    this.f16034n = 0;
                    continue;
                case '\t':
                    n.d(this.f16034n != -1, "statement exit $] has no matching statement enter $[", new Object[0]);
                    if (this.f16034n > 0) {
                        C(2);
                    }
                    this.f16034n = -1;
                    continue;
                default:
                    if (cVar != null) {
                        if (next.startsWith(".") && l(cVar.f16013x, next)) {
                            cVar = null;
                            break;
                        } else {
                            cVar.h(this);
                            cVar = null;
                        }
                    }
                    d(next);
                    continue;
            }
            i7 = i6;
        }
        return this;
    }

    e d(String str) throws IOException {
        String[] split = str.split(com.snail.antifake.deviceid.e.f37542d, -1);
        int length = split.length;
        int i6 = 0;
        boolean z5 = true;
        while (i6 < length) {
            String str2 = split[i6];
            if (!z5) {
                if ((this.f16024d || this.f16025e) && this.f16033m) {
                    g();
                    this.f16022b.a(this.f16024d ? " *" : "//");
                }
                this.f16022b.a(com.snail.antifake.deviceid.e.f37542d);
                this.f16033m = true;
                int i7 = this.f16034n;
                if (i7 != -1) {
                    if (i7 == 0) {
                        s(2);
                    }
                    this.f16034n++;
                }
            }
            if (!str2.isEmpty()) {
                if (this.f16033m) {
                    g();
                    if (this.f16024d) {
                        this.f16022b.a(" * ");
                    } else if (this.f16025e) {
                        this.f16022b.a("// ");
                    }
                }
                this.f16022b.a(str2);
                this.f16033m = false;
            }
            i6++;
            z5 = false;
        }
        return this;
    }

    public void j(Set<Modifier> set) throws IOException {
        k(set, Collections.EMPTY_SET);
    }

    public e n() throws IOException {
        this.f16022b.c(this.f16023c + 2);
        return this;
    }

    public Map<String, c> q() {
        return this.f16030j;
    }

    public e s(int i6) {
        this.f16023c += i6;
        return this;
    }

    public e u() {
        String str = this.f16026f;
        String str2 = f16020o;
        n.d(str != str2, "package already set: %s", str);
        this.f16026f = str2;
        return this;
    }

    public e v() {
        this.f16027g.remove(r0.size() - 1);
        return this;
    }

    public e w(String str) {
        String str2 = this.f16026f;
        n.d(str2 == f16020o, "package already set: %s", str2);
        this.f16026f = (String) n.c(str, "packageName == null", new Object[0]);
        return this;
    }

    public e x(TypeSpec typeSpec) {
        this.f16027g.add(typeSpec);
        return this;
    }

    e(Appendable appendable, String str, Map<String, c> map, Set<String> set) {
        this.f16024d = false;
        this.f16025e = false;
        this.f16026f = f16020o;
        this.f16027g = new ArrayList();
        this.f16031k = new LinkedHashMap();
        this.f16032l = new LinkedHashSet();
        this.f16034n = -1;
        this.f16022b = new h(appendable, str, 100);
        this.f16021a = (String) n.c(str, "indent == null", new Object[0]);
        this.f16030j = (Map) n.c(map, "importedTypes == null", new Object[0]);
        this.f16029i = (Set) n.c(set, "staticImports == null", new Object[0]);
        this.f16028h = new LinkedHashSet();
        for (String str2 : set) {
            this.f16028h.add(str2.substring(0, str2.lastIndexOf(46)));
        }
    }

    private void p(c cVar) {
        c K;
        String I;
        c put;
        if (!cVar.E().isEmpty() && (put = this.f16031k.put((I = (K = cVar.K()).I()), K)) != null) {
            this.f16031k.put(I, put);
        }
    }

    public e b(String str) throws IOException {
        return d(str);
    }

    public e c(String str, Object... objArr) throws IOException {
        return a(d.c(str, objArr));
    }

    public void e(List<a> list, boolean z5) throws IOException {
        String str;
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            it.next().c(this, z5);
            if (z5) {
                str = " ";
            } else {
                str = com.snail.antifake.deviceid.e.f37542d;
            }
            b(str);
        }
    }

    public void h(d dVar) throws IOException {
        if (dVar.b()) {
            return;
        }
        b("/**\n");
        this.f16024d = true;
        try {
            a(dVar);
            this.f16024d = false;
            b(" */\n");
        } catch (Throwable th) {
            this.f16024d = false;
            throw th;
        }
    }

    public void k(Set<Modifier> set, Set<Modifier> set2) throws IOException {
        if (!set.isEmpty()) {
            Iterator it = EnumSet.copyOf((Collection) set).iterator();
            while (it.hasNext()) {
                Modifier modifier = (Modifier) it.next();
                if (!set2.contains(modifier)) {
                    d(modifier.name().toLowerCase(Locale.US));
                    d(" ");
                }
            }
        }
    }

    public void m(List<m> list) throws IOException {
        String str;
        if (list.isEmpty()) {
            return;
        }
        b("<");
        boolean z5 = true;
        for (m mVar : list) {
            if (!z5) {
                b(", ");
            }
            c("$L", mVar.f16124w);
            boolean z6 = true;
            for (l lVar : mVar.f16125x) {
                if (z6) {
                    str = " extends $T";
                } else {
                    str = " & $T";
                }
                c(str, lVar);
                z6 = false;
            }
            z5 = false;
        }
        b(">");
    }
}
