package org.hamcrest;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class a implements g {
    protected abstract void g(char c6);

    protected void h(String str) {
        for (int i6 = 0; i6 < str.length(); i6++) {
            g(str.charAt(i6));
        }
    }

    private <T> g j(String str, String str2, String str3, Iterator<T> it) {
        return i(str, str2, str3, new org.hamcrest.internal.d(it));
    }

    private void l(char c6) {
        if (c6 == '\t') {
            h("\\t");
            return;
        }
        if (c6 == '\n') {
            h("\\n");
            return;
        }
        if (c6 == '\r') {
            h("\\r");
        } else if (c6 != '\"') {
            g(c6);
        } else {
            h("\\\"");
        }
    }

    private void m(String str) {
        g('\"');
        for (int i6 = 0; i6 < str.length(); i6++) {
            l(str.charAt(i6));
        }
        g('\"');
    }

    @Override // org.hamcrest.g
    public g c(Object obj) {
        if (obj == null) {
            h("null");
            return this;
        }
        if (obj instanceof String) {
            m((String) obj);
            return this;
        }
        if (obj instanceof Character) {
            g('\"');
            l(((Character) obj).charValue());
            g('\"');
            return this;
        }
        if (obj instanceof Short) {
            g(v0.f47961e);
            h(k(obj));
            h("s>");
            return this;
        }
        if (obj instanceof Long) {
            g(v0.f47961e);
            h(k(obj));
            h("L>");
            return this;
        }
        if (obj instanceof Float) {
            g(v0.f47961e);
            h(k(obj));
            h("F>");
            return this;
        }
        if (obj.getClass().isArray()) {
            j("[", ", ", "]", new org.hamcrest.internal.a(obj));
            return this;
        }
        g(v0.f47961e);
        h(k(obj));
        g(v0.f47962f);
        return this;
    }

    private g i(String str, String str2, String str3, Iterator<? extends l> it) {
        h(str);
        boolean z5 = false;
        while (it.hasNext()) {
            if (z5) {
                h(str2);
            }
            f(it.next());
            z5 = true;
        }
        h(str3);
        return this;
    }

    private String k(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception unused) {
            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
        }
    }

    @Override // org.hamcrest.g
    public g a(String str, String str2, String str3, Iterable<? extends l> iterable) {
        return i(str, str2, str3, iterable.iterator());
    }

    @Override // org.hamcrest.g
    public g b(String str) {
        h(str);
        return this;
    }

    @Override // org.hamcrest.g
    public <T> g d(String str, String str2, String str3, T... tArr) {
        return e(str, str2, str3, Arrays.asList(tArr));
    }

    @Override // org.hamcrest.g
    public <T> g e(String str, String str2, String str3, Iterable<T> iterable) {
        return j(str, str2, str3, iterable.iterator());
    }

    @Override // org.hamcrest.g
    public g f(l lVar) {
        lVar.describeTo(this);
        return this;
    }
}
