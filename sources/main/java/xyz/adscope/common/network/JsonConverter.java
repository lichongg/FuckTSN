package xyz.adscope.common.network;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.Type;
import xyz.adscope.common.R;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.network.simple.Converter;
import xyz.adscope.common.network.simple.SimpleResponse;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class JsonConverter implements Converter {

    /* renamed from: a, reason: collision with root package name */
    private Context f56476a;

    public JsonConverter(Context context) {
        this.f56476a = context;
    }

    @Override // xyz.adscope.common.network.simple.Converter
    public <S, F> SimpleResponse<S, F> convert(Type type, Type type2, Response response, boolean z5) {
        String string;
        String typeName;
        int code = response.code();
        String string2 = response.body().string();
        LogUtil.i(CommonConstants.TAG, "JsonConverter response code : " + code + " , serverJson : " + string2);
        String str = null;
        if (code >= 200 && code < 300) {
            if (Build.VERSION.SDK_INT >= 28) {
                typeName = type.getTypeName();
                typeName.equals("java.lang.String");
            }
        } else if (code == 302) {
            string2 = response.toString();
        } else {
            if (code >= 400 && code < 500) {
                string = this.f56476a.getString(R.string.adscope_server_unknown_exception);
            } else if (code >= 500) {
                string = this.f56476a.getString(R.string.adscope_server_not_response);
            } else {
                string2 = null;
            }
            string2 = null;
            str = string;
        }
        return SimpleResponse.newBuilder().code(response.code()).headers(response.headers()).fromCache(z5).succeed(string2).failed(str).build();
    }
}
