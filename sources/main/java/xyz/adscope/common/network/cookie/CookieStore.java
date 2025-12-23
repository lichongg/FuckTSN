package xyz.adscope.common.network.cookie;

import java.net.HttpCookie;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface CookieStore {
    public static final CookieStore DEFAULT = new CookieStore() { // from class: xyz.adscope.common.network.cookie.CookieStore.1
        @Override // xyz.adscope.common.network.cookie.CookieStore
        public List<HttpCookie> get(URI uri) {
            return Collections.EMPTY_LIST;
        }

        @Override // xyz.adscope.common.network.cookie.CookieStore
        public void clear() {
        }

        @Override // xyz.adscope.common.network.cookie.CookieStore
        public void remove(HttpCookie httpCookie) {
        }

        @Override // xyz.adscope.common.network.cookie.CookieStore
        public void add(URI uri, HttpCookie httpCookie) {
        }
    };

    void add(URI uri, HttpCookie httpCookie);

    void clear();

    List<HttpCookie> get(URI uri);

    void remove(HttpCookie httpCookie);
}
