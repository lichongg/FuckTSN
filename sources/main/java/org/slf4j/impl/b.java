package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class b implements org.slf4j.a {

    /* renamed from: b, reason: collision with root package name */
    static final String f51763b = "null";

    /* renamed from: c, reason: collision with root package name */
    static final int f51764c = 23;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<String, org.slf4j.c> f51765a = new ConcurrentHashMap();

    static String c(String str) {
        if (str == null) {
            return "null";
        }
        int length = str.length();
        if (length <= 23) {
            return str;
        }
        StringBuilder sb = new StringBuilder(26);
        int i6 = 0;
        int i7 = 0;
        do {
            int indexOf = str.indexOf(46, i6);
            if (indexOf == -1) {
                int i8 = length - i6;
                if (i7 == 0 || i7 + i8 > 23) {
                    return b(str);
                }
                sb.append((CharSequence) str, i6, length);
                return sb.toString();
            }
            sb.append(str.charAt(i6));
            if (indexOf - i6 > 1) {
                sb.append('*');
            }
            sb.append('.');
            i6 = indexOf + 1;
            i7 = sb.length();
        } while (i7 <= 23);
        return b(str);
    }

    b() {
    }

    private static String b(String str) {
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            int i6 = lastIndexOf + 1;
            if (length - i6 <= 23) {
                return str.substring(i6);
            }
        }
        return '*' + str.substring(length - 22);
    }

    @Override // org.slf4j.a
    public org.slf4j.c a(String str) {
        String c6 = c(str);
        org.slf4j.c cVar = this.f51765a.get(c6);
        if (cVar == null) {
            a aVar = new a(c6);
            org.slf4j.c putIfAbsent = this.f51765a.putIfAbsent(c6, aVar);
            if (putIfAbsent == null) {
                return aVar;
            }
            return putIfAbsent;
        }
        return cVar;
    }
}
