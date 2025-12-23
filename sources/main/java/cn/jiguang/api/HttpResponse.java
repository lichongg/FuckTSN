package cn.jiguang.api;

import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class HttpResponse {
    public byte[] body;
    public Map<String, String> headers;
    public int statusCode;

    public HttpResponse(int i6, Map<String, String> map, byte[] bArr) {
        this.statusCode = i6;
        this.headers = map;
        this.body = bArr;
    }
}
