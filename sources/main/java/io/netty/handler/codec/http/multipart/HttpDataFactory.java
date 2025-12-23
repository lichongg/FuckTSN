package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.http.HttpRequest;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface HttpDataFactory {
    void cleanAllHttpData();

    @Deprecated
    void cleanAllHttpDatas();

    void cleanRequestHttpData(HttpRequest httpRequest);

    @Deprecated
    void cleanRequestHttpDatas(HttpRequest httpRequest);

    Attribute createAttribute(HttpRequest httpRequest, String str);

    Attribute createAttribute(HttpRequest httpRequest, String str, long j6);

    Attribute createAttribute(HttpRequest httpRequest, String str, String str2);

    FileUpload createFileUpload(HttpRequest httpRequest, String str, String str2, String str3, String str4, Charset charset, long j6);

    void removeHttpDataFromClean(HttpRequest httpRequest, InterfaceHttpData interfaceHttpData);

    void setMaxLimit(long j6);
}
