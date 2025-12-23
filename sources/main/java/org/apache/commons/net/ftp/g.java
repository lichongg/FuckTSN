package org.apache.commons.net.ftp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class g implements f {
    @Override // org.apache.commons.net.ftp.f
    public String b(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine();
    }

    @Override // org.apache.commons.net.ftp.f
    public List<String> d(List<String> list) {
        return list;
    }
}
