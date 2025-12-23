package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Modifier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class n {

    /* renamed from: a, reason: collision with root package name */
    static final Modifier f16126a;

    static void k(Set<Modifier> set, Modifier... modifierArr) {
        int i6 = 0;
        for (Modifier modifier : modifierArr) {
            if ((modifier != null || f16126a != null) && set.contains(modifier)) {
                i6++;
            }
        }
        b(i6 == 1, "modifiers %s must contain one of %s", set, Arrays.toString(modifierArr));
    }

    static {
        Modifier modifier;
        try {
            modifier = Modifier.valueOf("DEFAULT");
        } catch (IllegalArgumentException unused) {
            modifier = null;
        }
        f16126a = modifier;
    }

    static String a(char c6) {
        if (c6 == '\f') {
            return "\\f";
        }
        if (c6 == '\r') {
            return "\\r";
        }
        if (c6 == '\"') {
            return "\"";
        }
        if (c6 == '\'') {
            return "\\'";
        }
        if (c6 == '\\') {
            return "\\\\";
        }
        switch (c6) {
            case '\b':
                return "\\b";
            case '\t':
                return "\\t";
            case '\n':
                return "\\n";
            default:
                return Character.isISOControl(c6) ? String.format("\\u%04x", Integer.valueOf(c6)) : Character.toString(c6);
        }
    }

    static void b(boolean z5, String str, Object... objArr) {
        if (!z5) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    static <T> T c(T t5, String str, Object... objArr) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    static void d(boolean z5, String str, Object... objArr) {
        if (!z5) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    static boolean e(Collection<Modifier> collection) {
        Modifier modifier = f16126a;
        return modifier != null && collection.contains(modifier);
    }

    static <T> List<T> f(Collection<T> collection) {
        return Collections.unmodifiableList(new ArrayList(collection));
    }

    static <K, V> Map<K, V> g(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    static <K, V> Map<K, List<V>> h(Map<K, List<V>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                linkedHashMap.put(entry.getKey(), f(entry.getValue()));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    static <T> Set<T> i(Collection<T> collection) {
        return Collections.unmodifiableSet(new LinkedHashSet(collection));
    }

    static String l(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\"');
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '\'') {
                sb.append("'");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else {
                sb.append(a(charAt));
                if (charAt == '\n' && i6 + 1 < str.length()) {
                    sb.append("\"\n");
                    sb.append(str2);
                    sb.append(str2);
                    sb.append("+ \"");
                }
            }
        }
        sb.append('\"');
        return sb.toString();
    }

    static <T> Set<T> m(Set<T> set, Set<T> set2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set);
        linkedHashSet.addAll(set2);
        return linkedHashSet;
    }

    static String j(String str, List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i6 = 1; i6 < list.size(); i6++) {
            sb.append(str);
            sb.append(list.get(i6));
        }
        return sb.toString();
    }
}
