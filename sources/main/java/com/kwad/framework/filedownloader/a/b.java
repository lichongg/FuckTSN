package com.kwad.framework.filedownloader.a;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface b {
    void addHeader(String str, String str2);

    String bn(String str);

    void execute();

    InputStream getInputStream();

    int getResponseCode();

    Map<String, List<String>> xQ();

    Map<String, List<String>> xR();

    void xS();
}
