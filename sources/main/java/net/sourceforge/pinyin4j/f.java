package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.p;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private com.hp.hpl.sparta.e f50422a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* synthetic */ f(a aVar) {
        this();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static final f f50423a = new f(null);

        private b() {
        }
    }

    private f() {
        c();
    }

    static f a() {
        return b.f50423a;
    }

    private void c() {
        try {
            d(p.b("", i.a("/pinyindb/pinyin_mapping.xml")));
        } catch (ParseException e6) {
            e6.printStackTrace();
        } catch (FileNotFoundException e7) {
            e7.printStackTrace();
        } catch (IOException e8) {
            e8.printStackTrace();
        }
    }

    private void d(com.hp.hpl.sparta.e eVar) {
        this.f50422a = eVar;
    }

    com.hp.hpl.sparta.e b() {
        return this.f50422a;
    }
}
