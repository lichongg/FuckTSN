package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f16014c = Pattern.compile("\\$(?<argumentName>[\\w_]+):(?<typeChar>[\\w]).*");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f16015d = Pattern.compile("[a-z]+[\\w_]*");

    /* renamed from: a, reason: collision with root package name */
    final List<String> f16016a;

    /* renamed from: b, reason: collision with root package name */
    final List<Object> f16017b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final List<String> f16018a;

        /* renamed from: b, reason: collision with root package name */
        final List<Object> f16019b;

        /* synthetic */ b(a aVar) {
            this();
        }

        public b d(String str, Object... objArr) {
            b("$[", new Object[0]);
            b(str, objArr);
            b(";\n$]", new Object[0]);
            return this;
        }

        private b() {
            this.f16018a = new ArrayList();
            this.f16019b = new ArrayList();
        }

        private void c(String str, char c6, Object obj) {
            if (c6 == 'L') {
                this.f16019b.add(e(obj));
                return;
            }
            if (c6 == 'N') {
                this.f16019b.add(f(obj));
            } else if (c6 == 'S') {
                this.f16019b.add(g(obj));
            } else {
                if (c6 != 'T') {
                    throw new IllegalArgumentException(String.format("invalid format string: '%s'", str));
                }
                this.f16019b.add(h(obj));
            }
        }

        private String f(Object obj) {
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof j) {
                return ((j) obj).f16089a;
            }
            if (obj instanceof f) {
                return ((f) obj).f16036b;
            }
            if (obj instanceof i) {
                return ((i) obj).f16067a;
            }
            if (obj instanceof TypeSpec) {
                return ((TypeSpec) obj).f15974b;
            }
            throw new IllegalArgumentException("expected name but was " + obj);
        }

        private String g(Object obj) {
            if (obj != null) {
                return String.valueOf(obj);
            }
            return null;
        }

        private l h(Object obj) {
            if (obj instanceof l) {
                return (l) obj;
            }
            if (obj instanceof TypeMirror) {
                return l.l((TypeMirror) obj);
            }
            if (obj instanceof Element) {
                return l.l(((Element) obj).asType());
            }
            if (obj instanceof Type) {
                return l.j((Type) obj);
            }
            throw new IllegalArgumentException("expected type but was " + obj);
        }

        private boolean m(char c6) {
            return c6 == '$' || c6 == '>' || c6 == '<' || c6 == '[' || c6 == ']' || c6 == 'W';
        }

        public b a(d dVar) {
            this.f16018a.addAll(dVar.f16016a);
            this.f16019b.addAll(dVar.f16017b);
            return this;
        }

        public b b(String str, Object... objArr) {
            int i6;
            char charAt;
            boolean z5;
            int i7;
            int[] iArr = new int[objArr.length];
            int i8 = 0;
            boolean z6 = false;
            int i9 = 0;
            boolean z7 = false;
            while (true) {
                int i10 = 1;
                if (i8 >= str.length()) {
                    break;
                }
                if (str.charAt(i8) != '$') {
                    int indexOf = str.indexOf(36, i8 + 1);
                    if (indexOf == -1) {
                        indexOf = str.length();
                    }
                    this.f16018a.add(str.substring(i8, indexOf));
                    i8 = indexOf;
                } else {
                    int i11 = i8 + 1;
                    int i12 = i11;
                    while (true) {
                        boolean z8 = i12 < str.length();
                        Object[] objArr2 = new Object[i10];
                        objArr2[0] = str;
                        n.b(z8, "dangling format characters in '%s'", objArr2);
                        i6 = i12 + 1;
                        charAt = str.charAt(i12);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i12 = i6;
                        i10 = 1;
                    }
                    if (m(charAt)) {
                        n.b(i11 == i12, "$$, $>, $<, $[, $], and $W may not have an index", new Object[0]);
                        this.f16018a.add("$" + charAt);
                    } else {
                        if (i11 < i12) {
                            int parseInt = Integer.parseInt(str.substring(i11, i12)) - 1;
                            if (objArr.length > 0) {
                                int length = parseInt % objArr.length;
                                iArr[length] = iArr[length] + 1;
                            }
                            i7 = i9;
                            i9 = parseInt;
                            z5 = true;
                        } else {
                            z5 = z7;
                            i7 = i9 + 1;
                            z6 = true;
                        }
                        n.b(i9 >= 0 && i9 < objArr.length, "index %d for '%s' not in range (received %s arguments)", Integer.valueOf(i9 + 1), str.substring(i8, i12 + 1), Integer.valueOf(objArr.length));
                        n.b((z5 && z6) ? false : true, "cannot mix indexed and positional parameters", new Object[0]);
                        c(str, charAt, objArr[i9]);
                        this.f16018a.add("$" + charAt);
                        i9 = i7;
                        z7 = z5;
                    }
                    i8 = i6;
                }
            }
            if (z6) {
                n.b(i9 >= objArr.length, "unused arguments: expected %s, received %s", Integer.valueOf(i9), Integer.valueOf(objArr.length));
            }
            if (z7) {
                ArrayList arrayList = new ArrayList();
                for (int i13 = 0; i13 < objArr.length; i13++) {
                    if (iArr[i13] == 0) {
                        arrayList.add("$" + (i13 + 1));
                    }
                }
                n.b(arrayList.isEmpty(), "unused argument%s: %s", arrayList.size() == 1 ? "" : "s", n.j(", ", arrayList));
            }
            return this;
        }

        public b i(String str, Object... objArr) {
            b(str + " {\n", objArr);
            l();
            return this;
        }

        public d j() {
            return new d(this, null);
        }

        public b l() {
            this.f16018a.add("$>");
            return this;
        }

        public b o() {
            this.f16018a.add("$<");
            return this;
        }

        public b k() {
            o();
            b("}\n", new Object[0]);
            return this;
        }

        public b n(String str, Object... objArr) {
            o();
            b("} " + str + " {\n", objArr);
            l();
            return this;
        }

        private Object e(Object obj) {
            return obj;
        }
    }

    /* synthetic */ d(b bVar, a aVar) {
        this(bVar);
    }

    private d(b bVar) {
        this.f16016a = n.f(bVar.f16018a);
        this.f16017b = n.f(bVar.f16019b);
    }

    public static b a() {
        return new b(null);
    }

    public static d c(String str, Object... objArr) {
        return new b(null).b(str, objArr).j();
    }

    public boolean b() {
        return this.f16016a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            new e(stringWriter).a(this);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
