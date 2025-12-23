package s4;

import java.io.InputStream;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import master.flame.danmaku.danmaku.parser.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface a {
    void a(String str) throws IllegalDataException;

    b<?> getDataSource();

    void load(InputStream inputStream) throws IllegalDataException;
}
