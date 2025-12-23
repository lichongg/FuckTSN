package t4;

import android.net.Uri;
import java.io.InputStream;
import master.flame.danmaku.danmaku.loader.IllegalDataException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a implements s4.a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f54611b;

    /* renamed from: a, reason: collision with root package name */
    private u4.b f54612a;

    public static s4.a c() {
        if (f54611b == null) {
            synchronized (a.class) {
                try {
                    if (f54611b == null) {
                        f54611b = new a();
                    }
                } finally {
                }
            }
        }
        return f54611b;
    }

    @Override // s4.a
    public void a(String str) throws IllegalDataException {
        try {
            this.f54612a = new u4.b(Uri.parse(str));
        } catch (Exception e6) {
            throw new IllegalDataException(e6);
        }
    }

    @Override // s4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u4.b getDataSource() {
        return this.f54612a;
    }

    @Override // s4.a
    public void load(InputStream inputStream) throws IllegalDataException {
        try {
            this.f54612a = new u4.b(inputStream);
        } catch (Exception e6) {
            throw new IllegalDataException(e6);
        }
    }

    private a() {
    }
}
