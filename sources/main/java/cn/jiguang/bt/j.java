package cn.jiguang.bt;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class j extends k {

    /* renamed from: a, reason: collision with root package name */
    private String f2555a;

    /* renamed from: b, reason: collision with root package name */
    private String f2556b;

    /* renamed from: c, reason: collision with root package name */
    private int f2557c;

    /* renamed from: d, reason: collision with root package name */
    private int f2558d;

    public void a(HttpRequest httpRequest, boolean z5) {
        int length;
        this.f2555a = z5 ? "POST" : "GET";
        if (!z5) {
            String[] split = httpRequest.getUrl().split(" \\?");
            this.f2556b = split[0];
            if (split.length > 1) {
                length = split[1].getBytes().length;
            }
            e();
        }
        this.f2556b = httpRequest.getUrl();
        length = httpRequest.getParas().length;
        this.f2557c = length;
        e();
    }

    public j(Context context) {
        super(context, "NET_HTTP");
    }

    public void a(HttpResponse httpResponse) {
        f();
        d(httpResponse.getStatusCode());
        if (httpResponse.getStatusCode() == -1) {
            c(httpResponse.getResponseCode());
        }
        if (TextUtils.isEmpty(httpResponse.getResponseBody())) {
            return;
        }
        this.f2558d = httpResponse.getResponseBody().getBytes().length;
    }

    @Override // cn.jiguang.bt.k
    JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("method", this.f2555a);
        jSONObject.put("url", this.f2556b);
        jSONObject.put("request_byte", this.f2557c);
        jSONObject.put("response_byte", this.f2558d);
        return jSONObject;
    }
}
