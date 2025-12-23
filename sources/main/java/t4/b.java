package t4;

import java.io.InputStream;
import master.flame.danmaku.danmaku.loader.IllegalDataException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b implements s4.a {

    /* renamed from: b, reason: collision with root package name */
    private static b f54613b;

    /* renamed from: a, reason: collision with root package name */
    private u4.a f54614a;

    public static b c() {
        if (f54613b == null) {
            f54613b = new b();
        }
        return f54613b;
    }

    @Override // s4.a
    public void a(String str) throws IllegalDataException {
        try {
            this.f54614a = new u4.a(str);
        } catch (Exception e6) {
            throw new IllegalDataException(e6);
        }
    }

    @Override // s4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u4.a getDataSource() {
        return this.f54614a;
    }

    @Override // s4.a
    public void load(InputStream inputStream) {
        this.f54614a = new u4.a(inputStream);
    }

    private b() {
    }
}
