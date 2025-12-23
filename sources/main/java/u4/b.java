package u4;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b implements master.flame.danmaku.danmaku.parser.b<JSONArray> {

    /* renamed from: d, reason: collision with root package name */
    private JSONArray f54675d;

    /* renamed from: e, reason: collision with root package name */
    private InputStream f54676e;

    public b(String str) throws JSONException {
        c(str);
    }

    private void b(InputStream inputStream) throws JSONException {
        if (inputStream == null) {
            throw new NullPointerException("input stream cannot be null!");
        }
        this.f54676e = inputStream;
        c(w4.b.d(inputStream));
    }

    @Override // master.flame.danmaku.danmaku.parser.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONArray data() {
        return this.f54675d;
    }

    @Override // master.flame.danmaku.danmaku.parser.b
    public void release() {
        w4.b.a(this.f54676e);
        this.f54676e = null;
        this.f54675d = null;
    }

    public b(InputStream inputStream) throws JSONException {
        b(inputStream);
    }

    private void c(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            this.f54675d = new JSONArray(str);
        }
    }

    public b(URL url) throws JSONException, IOException {
        this(url.openStream());
    }

    public b(File file) throws FileNotFoundException, JSONException {
        b(new FileInputStream(file));
    }

    public b(Uri uri) throws IOException, JSONException {
        String scheme = uri.getScheme();
        if (!master.flame.danmaku.danmaku.parser.b.f50154a.equalsIgnoreCase(scheme) && !master.flame.danmaku.danmaku.parser.b.f50155b.equalsIgnoreCase(scheme)) {
            if (master.flame.danmaku.danmaku.parser.b.f50156c.equalsIgnoreCase(scheme)) {
                b(new FileInputStream(uri.getPath()));
                return;
            }
            return;
        }
        b(new URL(uri.getPath()).openStream());
    }
}
