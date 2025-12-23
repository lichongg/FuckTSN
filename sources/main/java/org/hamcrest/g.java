package org.hamcrest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f51301a = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements g {
        public String toString() {
            return "";
        }

        @Override // org.hamcrest.g
        public g b(String str) {
            return this;
        }

        @Override // org.hamcrest.g
        public g c(Object obj) {
            return this;
        }

        @Override // org.hamcrest.g
        public g f(l lVar) {
            return this;
        }

        @Override // org.hamcrest.g
        public g a(String str, String str2, String str3, Iterable<? extends l> iterable) {
            return this;
        }

        @Override // org.hamcrest.g
        public <T> g d(String str, String str2, String str3, T... tArr) {
            return this;
        }

        @Override // org.hamcrest.g
        public <T> g e(String str, String str2, String str3, Iterable<T> iterable) {
            return this;
        }
    }

    g a(String str, String str2, String str3, Iterable<? extends l> iterable);

    g b(String str);

    g c(Object obj);

    <T> g d(String str, String str2, String str3, T... tArr);

    <T> g e(String str, String str2, String str3, Iterable<T> iterable);

    g f(l lVar);
}
