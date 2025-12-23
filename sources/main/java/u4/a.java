package u4;

import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a implements master.flame.danmaku.danmaku.parser.b<InputStream> {

    /* renamed from: d, reason: collision with root package name */
    private InputStream f54674d;

    public a(String str) {
        b(new File(str));
    }

    @Override // master.flame.danmaku.danmaku.parser.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InputStream data() {
        return this.f54674d;
    }

    public void b(File file) {
        try {
            this.f54674d = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e6) {
            e6.printStackTrace();
        }
    }

    public void c(Uri uri) {
        try {
            URL url = new URL(uri.getPath());
            url.openConnection();
            this.f54674d = new BufferedInputStream(url.openStream());
        } catch (MalformedURLException e6) {
            e6.printStackTrace();
        } catch (IOException e7) {
            e7.printStackTrace();
        }
    }

    @Override // master.flame.danmaku.danmaku.parser.b
    public void release() {
        w4.b.a(this.f54674d);
        this.f54674d = null;
    }

    public a(Uri uri) {
        d(uri);
    }

    public void d(Uri uri) {
        String scheme = uri.getScheme();
        if (!master.flame.danmaku.danmaku.parser.b.f50154a.equalsIgnoreCase(scheme) && !master.flame.danmaku.danmaku.parser.b.f50155b.equalsIgnoreCase(scheme)) {
            if (master.flame.danmaku.danmaku.parser.b.f50156c.equalsIgnoreCase(scheme)) {
                b(new File(uri.getPath()));
                return;
            }
            return;
        }
        c(uri);
    }

    public a(File file) {
        b(file);
    }

    public a(InputStream inputStream) {
        this.f54674d = inputStream;
    }
}
