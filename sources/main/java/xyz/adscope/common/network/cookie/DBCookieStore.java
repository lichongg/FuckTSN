package xyz.adscope.common.network.cookie;

import android.content.Context;
import android.text.TextUtils;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import master.flame.danmaku.danmaku.parser.b;
import xyz.adscope.common.network.cookie.db.CookieDao;
import xyz.adscope.common.network.cookie.db.Field;
import xyz.adscope.common.network.cookie.db.Where;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DBCookieStore implements CookieStore, Field {

    /* renamed from: a, reason: collision with root package name */
    private Lock f56604a;

    /* renamed from: b, reason: collision with root package name */
    private CookieDao f56605b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.cookie.DBCookieStore$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Context f56606a;

        /* synthetic */ Builder(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        private Builder(Context context) {
            this.f56606a = context;
        }

        public DBCookieStore build() {
            return new DBCookieStore(this, null);
        }
    }

    /* synthetic */ DBCookieStore(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private void a() {
        List<Cookie> list;
        int count = this.f56605b.count();
        if (count <= 888 || (list = this.f56605b.getList(null, null, Integer.toString(count - 888), null)) == null) {
            return;
        }
        this.f56605b.delete(list);
    }

    private DBCookieStore(Builder builder) {
        this.f56604a = new ReentrantLock();
        this.f56605b = new CookieDao(builder.f56606a);
        Where.Builder newBuilder = Where.newBuilder();
        Where.Options options = Where.Options.EQUAL;
        this.f56605b.delete(newBuilder.add(Field.EXPIRY, options, -1).or(Field.EXPIRY, options, 0).build().toString());
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context, null);
    }

    @Override // xyz.adscope.common.network.cookie.CookieStore
    public void add(URI uri, HttpCookie httpCookie) {
        this.f56604a.lock();
        if (uri != null && httpCookie != null) {
            try {
                this.f56605b.replace(Cookie.toCookie(a(uri).toString(), httpCookie));
                a();
            } finally {
                this.f56604a.unlock();
            }
        }
    }

    @Override // xyz.adscope.common.network.cookie.CookieStore
    public void clear() {
        this.f56604a.lock();
        try {
            this.f56605b.deleteAll();
        } finally {
            this.f56604a.unlock();
        }
    }

    @Override // xyz.adscope.common.network.cookie.CookieStore
    public List<HttpCookie> get(URI uri) {
        this.f56604a.lock();
        try {
            URI a6 = a(uri);
            Where.Builder newBuilder = Where.newBuilder();
            String host = a6.getHost();
            if (!TextUtils.isEmpty(host)) {
                Where.Builder newBuilder2 = Where.newBuilder();
                Where.Options options = Where.Options.EQUAL;
                Where.Builder or = newBuilder2.add(Field.DOMAIN, options, host).or(Field.DOMAIN, options, "." + host);
                int indexOf = host.indexOf(".");
                int lastIndexOf = host.lastIndexOf(".");
                if (indexOf > 0) {
                    if (lastIndexOf > indexOf) {
                        String substring = host.substring(indexOf, host.length());
                        if (!TextUtils.isEmpty(substring)) {
                            or.or(Field.DOMAIN, options, substring);
                        }
                    }
                    int i6 = indexOf + 1;
                    if (lastIndexOf > i6) {
                        String substring2 = host.substring(i6, host.length());
                        if (!TextUtils.isEmpty(substring2)) {
                            or.or(Field.DOMAIN, options, substring2);
                        }
                    }
                }
                newBuilder.set(or.build().toString());
            }
            String path = a6.getPath();
            if (!TextUtils.isEmpty(path)) {
                Where.Builder newBuilder3 = Where.newBuilder();
                Where.Options options2 = Where.Options.EQUAL;
                Where.Builder orNull = newBuilder3.add(Field.PATH, options2, path).or(Field.PATH, options2, "/").orNull(Field.PATH);
                int lastIndexOf2 = path.lastIndexOf("/");
                while (lastIndexOf2 > 0) {
                    path = path.substring(0, lastIndexOf2);
                    orNull.or(Field.PATH, Where.Options.EQUAL, path);
                    lastIndexOf2 = path.lastIndexOf("/");
                }
                orNull.bracket();
                newBuilder.and(orNull.build());
            }
            newBuilder.or(Field.URL, Where.Options.EQUAL, a6.toString());
            List<Cookie> list = this.f56605b.getList(newBuilder.build().toString(), null, null, null);
            ArrayList arrayList = new ArrayList();
            for (Cookie cookie : list) {
                if (!Cookie.isExpired(cookie)) {
                    arrayList.add(Cookie.toHttpCookie(cookie));
                }
            }
            this.f56604a.unlock();
            return arrayList;
        } catch (Throwable th) {
            this.f56604a.unlock();
            throw th;
        }
    }

    @Override // xyz.adscope.common.network.cookie.CookieStore
    public void remove(HttpCookie httpCookie) {
        this.f56604a.lock();
        try {
            Where.Builder newBuilder = Where.newBuilder();
            Where.Options options = Where.Options.EQUAL;
            Where.Builder add = newBuilder.add(Field.NAME, options, httpCookie.getName());
            String domain = httpCookie.getDomain();
            if (!TextUtils.isEmpty(domain)) {
                add.and(Field.DOMAIN, options, domain);
            }
            String path = httpCookie.getPath();
            if (!TextUtils.isEmpty(path)) {
                if (path.length() > 1 && path.endsWith("/")) {
                    path = path.substring(0, path.length() - 1);
                }
                add.and(Field.PATH, options, path);
            }
            this.f56605b.delete(add.build().toString());
            this.f56604a.unlock();
        } catch (Throwable th) {
            this.f56604a.unlock();
            throw th;
        }
    }

    private static URI a(URI uri) {
        try {
            return new URI(b.f50154a, uri.getHost(), uri.getPath(), null, null);
        } catch (URISyntaxException unused) {
            return uri;
        }
    }
}
