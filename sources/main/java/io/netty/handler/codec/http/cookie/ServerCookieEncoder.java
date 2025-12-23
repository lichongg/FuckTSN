package io.netty.handler.codec.http.cookie;

import io.netty.handler.codec.DateFormatter;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ServerCookieEncoder extends CookieEncoder {
    public static final ServerCookieEncoder STRICT = new ServerCookieEncoder(true);
    public static final ServerCookieEncoder LAX = new ServerCookieEncoder(false);

    public String encode(String str, String str2) {
        return encode(new DefaultCookie(str, str2));
    }

    public String encode(Cookie cookie) {
        String name = ((Cookie) ObjectUtil.checkNotNull(cookie, "cookie")).name();
        String value = cookie.value() != null ? cookie.value() : "";
        validateCookie(name, value);
        StringBuilder stringBuilder = CookieUtil.stringBuilder();
        if (cookie.wrap()) {
            CookieUtil.addQuoted(stringBuilder, name, value);
        } else {
            CookieUtil.add(stringBuilder, name, value);
        }
        if (cookie.maxAge() != Long.MIN_VALUE) {
            CookieUtil.add(stringBuilder, CookieHeaderNames.MAX_AGE, cookie.maxAge());
            Date date = new Date((cookie.maxAge() * 1000) + System.currentTimeMillis());
            stringBuilder.append("Expires");
            stringBuilder.append('=');
            DateFormatter.append(date, stringBuilder);
            stringBuilder.append(';');
            stringBuilder.append(' ');
        }
        if (cookie.path() != null) {
            CookieUtil.add(stringBuilder, CookieHeaderNames.PATH, cookie.path());
        }
        if (cookie.domain() != null) {
            CookieUtil.add(stringBuilder, CookieHeaderNames.DOMAIN, cookie.domain());
        }
        if (cookie.isSecure()) {
            CookieUtil.add(stringBuilder, CookieHeaderNames.SECURE);
        }
        if (cookie.isHttpOnly()) {
            CookieUtil.add(stringBuilder, CookieHeaderNames.HTTPONLY);
        }
        return CookieUtil.stripTrailingSeparator(stringBuilder);
    }

    private ServerCookieEncoder(boolean z5) {
        super(z5);
    }

    private static List<String> dedup(List<String> list, Map<String, Integer> map) {
        boolean[] zArr = new boolean[list.size()];
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            zArr[it.next().intValue()] = true;
        }
        ArrayList arrayList = new ArrayList(map.size());
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (zArr[i6]) {
                arrayList.add(list.get(i6));
            }
        }
        return arrayList;
    }

    public List<String> encode(Cookie... cookieArr) {
        if (((Cookie[]) ObjectUtil.checkNotNull(cookieArr, "cookies")).length == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(cookieArr.length);
        HashMap hashMap = (!this.strict || cookieArr.length <= 1) ? null : new HashMap();
        boolean z5 = false;
        for (int i6 = 0; i6 < cookieArr.length; i6++) {
            Cookie cookie = cookieArr[i6];
            arrayList.add(encode(cookie));
            if (hashMap != null) {
                z5 |= hashMap.put(cookie.name(), Integer.valueOf(i6)) != null;
            }
        }
        return z5 ? dedup(arrayList, hashMap) : arrayList;
    }

    public List<String> encode(Collection<? extends Cookie> collection) {
        if (((Collection) ObjectUtil.checkNotNull(collection, "cookies")).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        HashMap hashMap = (!this.strict || collection.size() <= 1) ? null : new HashMap();
        boolean z5 = false;
        int i6 = 0;
        for (Cookie cookie : collection) {
            arrayList.add(encode(cookie));
            if (hashMap != null) {
                int i7 = i6 + 1;
                z5 |= hashMap.put(cookie.name(), Integer.valueOf(i6)) != null;
                i6 = i7;
            }
        }
        return z5 ? dedup(arrayList, hashMap) : arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0084 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.String> encode(java.lang.Iterable<? extends io.netty.handler.codec.http.cookie.Cookie> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "cookies"
            java.lang.Object r9 = io.netty.util.internal.ObjectUtil.checkNotNull(r9, r0)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
            boolean r0 = r9.hasNext()
            if (r0 != 0) goto L15
            java.util.List r9 = java.util.Collections.EMPTY_LIST
            return r9
        L15:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Object r1 = r9.next()
            io.netty.handler.codec.http.cookie.Cookie r1 = (io.netty.handler.codec.http.cookie.Cookie) r1
            boolean r2 = r8.strict
            if (r2 == 0) goto L30
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L30
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            goto L31
        L30:
            r2 = 0
        L31:
            java.lang.String r3 = r8.encode(r1)
            r0.add(r3)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L4f
            java.lang.String r1 = r1.name()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            java.lang.Object r1 = r2.put(r1, r5)
            if (r1 == 0) goto L4d
            r1 = 1
            r5 = 1
            goto L51
        L4d:
            r1 = 1
            goto L50
        L4f:
            r1 = 0
        L50:
            r5 = 0
        L51:
            boolean r6 = r9.hasNext()
            if (r6 == 0) goto L7d
            java.lang.Object r6 = r9.next()
            io.netty.handler.codec.http.cookie.Cookie r6 = (io.netty.handler.codec.http.cookie.Cookie) r6
            java.lang.String r7 = r8.encode(r6)
            r0.add(r7)
            if (r2 == 0) goto L51
            java.lang.String r6 = r6.name()
            int r7 = r1 + 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r2.put(r6, r1)
            if (r1 == 0) goto L78
            r1 = 1
            goto L79
        L78:
            r1 = 0
        L79:
            r1 = r1 | r5
            r5 = r1
            r1 = r7
            goto L51
        L7d:
            if (r5 == 0) goto L84
            java.util.List r9 = dedup(r0, r2)
            return r9
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.cookie.ServerCookieEncoder.encode(java.lang.Iterable):java.util.List");
    }
}
