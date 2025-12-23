package cn.jpush.android.webview.bridge;

import android.text.TextUtils;
import android.webkit.WebView;
import cn.jpush.android.helper.Logger;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Method> f3972a;

    /* renamed from: b, reason: collision with root package name */
    private String f3973b;

    /* renamed from: c, reason: collision with root package name */
    private String f3974c;

    public String a() {
        return this.f3974c;
    }

    public c(String str, Class cls) {
        String a6;
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception("injected name can not be null");
            }
            this.f3973b = str;
            this.f3972a = new HashMap<>();
            Method[] declaredMethods = cls.getDeclaredMethods();
            StringBuilder sb = new StringBuilder("javascript:(function(b){console.log(\"");
            sb.append(this.f3973b);
            sb.append(" initialization begin\");var a={queue:[],callback:function(){var d=Array.prototype.slice.call(arguments,0);var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : declaredMethods) {
                if (method.getModifiers() == 9 && (a6 = a(method)) != null) {
                    this.f3972a.put(a6, method);
                    sb.append(String.format(Locale.ENGLISH, "a.%s=", method.getName()));
                }
            }
            sb.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            sb.append(this.f3973b);
            sb.append(" call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++){var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\"){var d=a.queue.length;a.queue[d]=c;f[h]=d}}var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));if(g.code!=200){throw\"");
            sb.append(this.f3973b);
            sb.append(" call error, code:\"+g.code+\", message:\"+g.result}return g.result};Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            sb.append(this.f3973b);
            sb.append("=a;console.log(\"");
            sb.append(this.f3973b);
            sb.append(" initialization end\")})(window);");
            this.f3974c = sb.toString();
            Logger.d("JsCallJava", "----------" + sb.toString());
        } catch (Exception e6) {
            Logger.e("JsCallJava", "init js error:" + e6.getMessage());
        }
    }

    public String a(WebView webView, String str) {
        StringBuilder sb;
        String sb2;
        if (TextUtils.isEmpty(str)) {
            sb2 = "call data empty";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("method");
                JSONArray jSONArray = jSONObject.getJSONArray("types");
                JSONArray jSONArray2 = jSONObject.getJSONArray("args");
                int length = jSONArray.length();
                Object[] objArr = new Object[length + 1];
                int i6 = 0;
                objArr[0] = webView;
                int i7 = 0;
                while (true) {
                    Object obj = null;
                    if (i6 >= length) {
                        break;
                    }
                    String optString = jSONArray.optString(i6);
                    if (ResIdentify.RES_TYPE_STRING.equals(optString)) {
                        string = string + "_S";
                        int i8 = i6 + 1;
                        if (!jSONArray2.isNull(i6)) {
                            obj = jSONArray2.getString(i6);
                        }
                        objArr[i8] = obj;
                    } else if ("number".equals(optString)) {
                        string = string + "_N";
                        i7 = (i7 * 10) + i6 + 1;
                    } else if ("boolean".equals(optString)) {
                        string = string + "_B";
                        objArr[i6 + 1] = Boolean.valueOf(jSONArray2.getBoolean(i6));
                    } else if ("object".equals(optString)) {
                        string = string + "_O";
                        int i9 = i6 + 1;
                        if (!jSONArray2.isNull(i6)) {
                            obj = jSONArray2.getJSONObject(i6);
                        }
                        objArr[i9] = obj;
                    } else {
                        string = string + "_P";
                    }
                    i6++;
                }
                Method method = this.f3972a.get(string);
                if (method == null) {
                    return a(str, 500, "not found method(" + string + ") with valid parameters");
                }
                if (i7 > 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    while (i7 > 0) {
                        int i10 = i7 - ((i7 / 10) * 10);
                        Class<?> cls = parameterTypes[i10];
                        if (cls == Integer.TYPE) {
                            objArr[i10] = Integer.valueOf(jSONArray2.getInt(i10 - 1));
                        } else if (cls == Long.TYPE) {
                            objArr[i10] = Long.valueOf(Long.parseLong(jSONArray2.getString(i10 - 1)));
                        } else {
                            objArr[i10] = Double.valueOf(jSONArray2.getDouble(i10 - 1));
                        }
                        i7 /= 10;
                    }
                }
                return a(str, 200, method.invoke(null, objArr));
            } catch (Exception e6) {
                e = e6;
                if (e.getCause() != null) {
                    sb = new StringBuilder();
                    sb.append("method execute error:");
                    e = e.getCause();
                } else {
                    sb = new StringBuilder();
                    sb.append("method execute error:");
                }
                sb.append(e.getMessage());
                sb2 = sb.toString();
            }
        }
        return a(str, 500, sb2);
    }

    private String a(String str, int i6, Object obj) {
        String valueOf;
        if (obj == null) {
            valueOf = "null";
        } else if (obj instanceof String) {
            valueOf = "\"" + ((Object) ((String) obj).replace("\"", "\\\"")) + "\"";
        } else {
            valueOf = ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof JSONObject)) ? String.valueOf(obj) : "";
        }
        String format = String.format(Locale.ENGLISH, "{\"code\": %d, \"result\": %s}", Integer.valueOf(i6), valueOf);
        Logger.d("JsCallJava", this.f3973b + " call json: " + str + " result:" + format);
        return format;
    }

    private String a(Method method) {
        StringBuilder sb;
        String str;
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        if (length < 1 || parameterTypes[0] != WebView.class) {
            Logger.w("JsCallJava", "method(" + name + ") must use webview to be first parameter, will be pass");
            return null;
        }
        for (int i6 = 1; i6 < length; i6++) {
            Class<?> cls = parameterTypes[i6];
            if (cls == String.class) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_S";
            } else if (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_N";
            } else if (cls == Boolean.TYPE) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_B";
            } else if (cls == JSONObject.class) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_O";
            } else {
                sb = new StringBuilder();
                sb.append(name);
                str = "_P";
            }
            sb.append(str);
            name = sb.toString();
        }
        return name;
    }
}
