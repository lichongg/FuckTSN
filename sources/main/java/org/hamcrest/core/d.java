package org.hamcrest.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d<T> extends org.hamcrest.b<T> {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f51284d = Pattern.compile("%([0-9]+)");

    /* renamed from: a, reason: collision with root package name */
    private final String f51285a;

    /* renamed from: b, reason: collision with root package name */
    private final org.hamcrest.j<T> f51286b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f51287c;

    @Factory
    public static <T> org.hamcrest.j<T> d(String str, org.hamcrest.j<T> jVar, Object... objArr) {
        return new d(str, jVar, objArr);
    }

    @Override // org.hamcrest.b, org.hamcrest.j
    public void b(Object obj, org.hamcrest.g gVar) {
        this.f51286b.b(obj, gVar);
    }

    @Override // org.hamcrest.j
    public boolean c(Object obj) {
        return this.f51286b.c(obj);
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        Matcher matcher = f51284d.matcher(this.f51285a);
        int i6 = 0;
        while (matcher.find()) {
            gVar.b(this.f51285a.substring(i6, matcher.start()));
            gVar.c(this.f51287c[Integer.parseInt(matcher.group(1))]);
            i6 = matcher.end();
        }
        if (i6 < this.f51285a.length()) {
            gVar.b(this.f51285a.substring(i6));
        }
    }

    public d(String str, org.hamcrest.j<T> jVar, Object[] objArr) {
        this.f51285a = str;
        this.f51286b = jVar;
        this.f51287c = (Object[]) objArr.clone();
    }
}
