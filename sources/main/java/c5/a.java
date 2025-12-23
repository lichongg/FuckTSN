package c5;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.net.g;
import org.apache.commons.net.util.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends g {

    /* renamed from: v, reason: collision with root package name */
    public static final int f1072v = 79;

    /* renamed from: w, reason: collision with root package name */
    private static final String f1073w = "/W ";

    /* renamed from: u, reason: collision with root package name */
    private transient char[] f1074u = new char[1024];

    public InputStream a0(boolean z5, String str) throws IOException {
        return b0(z5, str, null);
    }

    public String query(boolean z5, String str) throws IOException {
        StringBuilder sb = new StringBuilder(this.f1074u.length);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a0(z5, str), q()));
        while (true) {
            try {
                char[] cArr = this.f1074u;
                int read = bufferedReader.read(cArr, 0, cArr.length);
                if (read <= 0) {
                    bufferedReader.close();
                    return sb.toString();
                }
                sb.append(this.f1074u, 0, read);
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        }
    }

    public InputStream Z(boolean z5) throws IOException {
        return a0(z5, "");
    }

    public InputStream b0(boolean z5, String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder(64);
        if (z5) {
            sb.append(f1073w);
        }
        sb.append(str);
        sb.append(g.f50795q);
        byte[] bytes = sb.toString().getBytes(b.a(str2).name());
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(this.f50805i, 1024));
        dataOutputStream.write(bytes, 0, bytes.length);
        dataOutputStream.flush();
        return this.f50804h;
    }

    public a() {
        N(79);
    }

    public String query(boolean z5) throws IOException {
        return query(z5, "");
    }
}
