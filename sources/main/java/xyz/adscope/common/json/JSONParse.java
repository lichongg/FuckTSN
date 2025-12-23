package xyz.adscope.common.json;

import org.json.JSONObject;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.json.inter.IJSONParse;
import xyz.adscope.common.json.util.JsonResolver;
import xyz.adscope.common.json.util.JsonUtil;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class JSONParse implements IJSONParse {
    @Override // xyz.adscope.common.json.inter.IJSONParse
    public <T> T fromJson(String str, Class<T> cls) {
        try {
            return (T) JsonUtil.fromJson(new JSONObject(str), cls);
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
            return null;
        }
    }

    @Override // xyz.adscope.common.json.inter.IJSONParse
    public <T> T fromJsonAnnotation(String str, Class<T> cls) {
        try {
            return (T) JsonResolver.fromJson(str, (Class) cls);
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
            return null;
        }
    }

    @Override // xyz.adscope.common.json.inter.IJSONParse
    public String toJson(Object obj) {
        try {
            return obj.toString();
        } catch (Exception e6) {
            LogUtil.e(CommonConstants.TAG, "e : " + e6);
            return null;
        }
    }
}
