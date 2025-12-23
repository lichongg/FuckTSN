package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.p;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private com.hp.hpl.sparta.e f50417a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: net.sourceforge.pinyin4j.b$b, reason: collision with other inner class name */
    private static class C0979b {

        /* renamed from: a, reason: collision with root package name */
        static final b f50418a = new b(null);

        private C0979b() {
        }
    }

    private b() {
        c();
    }

    static b a() {
        return C0979b.f50418a;
    }

    private void c() {
        try {
            d(p.b("", i.a("/pinyindb/pinyin_gwoyeu_mapping.xml")));
        } catch (ParseException e6) {
            e6.printStackTrace();
        } catch (FileNotFoundException e7) {
            e7.printStackTrace();
        } catch (IOException e8) {
            e8.printStackTrace();
        }
    }

    private void d(com.hp.hpl.sparta.e eVar) {
        this.f50417a = eVar;
    }

    com.hp.hpl.sparta.e b() {
        return this.f50417a;
    }
}
