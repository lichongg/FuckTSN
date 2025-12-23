package cn.jpush.android.ab;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.TagAliasReceiver;
import com.acse.ottn.l3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f3348a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f3349b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Long, a> f3350c = new ConcurrentHashMap<>();

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f3351a;

        /* renamed from: b, reason: collision with root package name */
        public int f3352b;

        /* renamed from: c, reason: collision with root package name */
        public long f3353c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<String> f3354d;

        /* renamed from: e, reason: collision with root package name */
        public Map<String, Object> f3355e;

        /* renamed from: f, reason: collision with root package name */
        public String f3356f;

        /* renamed from: g, reason: collision with root package name */
        public int f3357g = -1;

        /* renamed from: h, reason: collision with root package name */
        public int f3358h = -1;

        /* renamed from: i, reason: collision with root package name */
        public int f3359i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f3360j;

        public a(int i6, int i7, long j6, ArrayList<String> arrayList, Map<String, Object> map, String str) {
            this.f3360j = 0;
            this.f3351a = i6;
            this.f3352b = i7;
            this.f3353c = j6;
            this.f3354d = arrayList;
            if (i6 == 1 && arrayList == null) {
                this.f3354d = new ArrayList<>();
            }
            this.f3355e = map;
            if (i6 == 3 && map == null) {
                this.f3355e = new HashMap();
            }
            this.f3356f = str;
            this.f3360j = 1;
        }

        public String toString() {
            return "TagAliasCacheBean{protoType=" + this.f3351a + ", actionType=" + this.f3352b + ", seqID=" + this.f3353c + ", tags=" + this.f3354d + ", pros=" + this.f3355e + ", alias='" + this.f3356f + "', totalPage=" + this.f3357g + ", currPage=" + this.f3358h + ", retryCount=" + this.f3359i + '}';
        }
    }

    public int a(int i6, int i7) {
        if (i6 != 0) {
            if (i7 == 17) {
                try {
                    return JPushInterface.ErrorCode.ERROR_CODE_ALIAS_LIMIT;
                } catch (Throwable unused) {
                    return JPushInterface.ErrorCode.ERROR_CODE_INVALIDREQ;
                }
            }
            if (i7 == 100) {
                return JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE;
            }
            if (i7 == 1013) {
                return JPushInterface.ErrorCode.ERROR_CODE_APPKEY_NOT_AUTH_TO_SET_PROPERTY;
            }
            if (i7 == 1014) {
                return JPushInterface.ErrorCode.ERROR_CODE_PROPERTY_ERROR;
            }
            switch (i7) {
                case 1:
                case 2:
                    return JPushInterface.ErrorCode.ERROR_CODE_TOO_BUSY;
                case 3:
                    return JPushInterface.ErrorCode.ERROR_CODE_BLACKLIST;
                case 4:
                    return JPushInterface.ErrorCode.ERROR_CODE_INVALIDUSER;
                case 5:
                    return JPushInterface.ErrorCode.ERROR_CODE_INVALIDREQ;
                case 6:
                    return JPushInterface.ErrorCode.ERROR_CODE_INTERNEL_SERVER_ERROR;
                case 7:
                case 8:
                    return JPushInterface.ErrorCode.ERROR_CODE_GET_FAILED;
                case 9:
                    return JPushInterface.ErrorCode.ERROR_CODE_TOO_MANY_TAGS;
            }
        }
        return i7;
    }

    private boolean b(Context context, a aVar) {
        Context context2;
        String str;
        String str2;
        Logger.d("TagAliasNewProtoRetryHelper", "action - onSendAgain, tagAliasCacheNode:" + aVar);
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "onSendAgain - tagAliasCacheNode was null");
            return false;
        }
        int i6 = aVar.f3351a;
        if (i6 == 1) {
            context2 = context;
            str = b.a(context2, aVar.f3354d, aVar.f3353c, aVar.f3352b, aVar.f3357g, aVar.f3358h);
        } else {
            context2 = context;
            if (i6 == 2) {
                str = b.a(context2, aVar.f3356f, aVar.f3353c, i6);
            } else if (i6 == 3) {
                str = b.a(context2, (Map<String, Object>) null, aVar.f3353c, aVar.f3352b);
            } else {
                if (i6 != 4) {
                    Logger.d("TagAliasNewProtoRetryHelper", "unsupport proto type");
                    return false;
                }
                str = "PROTO_TYPE_PUSH_STATUS";
            }
        }
        if (str == null) {
            return false;
        }
        if (aVar.f3359i > 200) {
            this.f3350c.remove(Long.valueOf(aVar.f3353c));
            b.a(context2, aVar.f3351a, JPushInterface.ErrorCode.ERROR_CODE_TOO_BUSY, aVar.f3353c, aVar.f3352b);
            str2 = "same tag/alias request times greate than 200";
        } else {
            int i7 = aVar.f3351a;
            if (i7 == 3) {
                b.a(context2, aVar.f3353c, str, aVar.f3352b);
            } else if (i7 == 4) {
                b.a(context2, aVar.f3353c, aVar.f3352b);
            } else {
                b.a(context2, i7, aVar.f3353c, str);
            }
            aVar.f3359i++;
            this.f3350c.put(Long.valueOf(aVar.f3353c), aVar);
            str2 = "send request success";
        }
        Logger.d("TagAliasNewProtoRetryHelper", str2);
        return true;
    }

    public int a(long j6) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasTimeOut :" + j6);
        a remove = this.f3350c.remove(Long.valueOf(j6));
        Logger.d("TagAliasNewProtoRetryHelper", "onTagAliasTimeOut,removed cachenode:" + remove);
        if (remove != null) {
            return remove.f3351a;
        }
        return 0;
    }

    public Intent a(Context context, long j6, int i6, Intent intent) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onProsResponse, seqID:" + j6 + ",errorCode:" + i6 + ",intent:" + intent);
        a aVar = this.f3350c.get(Long.valueOf(j6));
        StringBuilder sb = new StringBuilder();
        sb.append("tagAliasCacheNode:");
        sb.append(aVar);
        Logger.d("TagAliasNewProtoRetryHelper", sb.toString());
        this.f3350c.remove(Long.valueOf(j6));
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return intent;
        }
        if (a(context, i6, aVar)) {
            Logger.d("TagAliasNewProtoRetryHelper", "retry action was sended");
            return null;
        }
        if (i6 != 0) {
            int a6 = a(aVar.f3351a, i6);
            intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, a6);
            Logger.d("TagAliasNewProtoRetryHelper", "mapped errorCode:" + a6);
        }
        return intent;
    }

    public Intent a(Context context, long j6, int i6, JSONObject jSONObject, Intent intent) {
        String str;
        String str2;
        Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasResponse, seqID:" + j6 + ",errorCode:" + i6 + ",intent:" + intent);
        a aVar = this.f3350c.get(Long.valueOf(j6));
        StringBuilder sb = new StringBuilder();
        sb.append("tagAliasCacheNode:");
        sb.append(aVar);
        Logger.d("TagAliasNewProtoRetryHelper", sb.toString());
        this.f3350c.remove(Long.valueOf(j6));
        if (jSONObject == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "responseJson was null");
            return intent;
        }
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return intent;
        }
        if (!a(context, i6, aVar)) {
            if (i6 != 0) {
                if (i6 == 100) {
                    long optLong = jSONObject.optLong("wait", -1L);
                    Logger.ww("TagAliasNewProtoRetryHelper", "set tag/alias action will freeze " + optLong + " seconds");
                    if (optLong > 0) {
                        cn.jpush.android.cache.a.a(context, optLong);
                    }
                }
                int a6 = a(aVar.f3351a, i6);
                intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, a6);
                Logger.d("TagAliasNewProtoRetryHelper", "mapped errorCode:" + a6);
                return intent;
            }
            aVar.f3359i = 0;
            if (aVar.f3352b == 5) {
                aVar.f3357g = jSONObject.optInt("total", -1);
                aVar.f3358h = jSONObject.optInt("curr", -1);
                a(jSONObject, aVar);
            }
            if (a(context, aVar)) {
                aVar.f3358h++;
                Logger.d("TagAliasNewProtoRetryHelper", "load next page, currpage:" + aVar.f3358h + ",totalPage:" + aVar.f3357g);
                if (a(context, aVar.f3351a, aVar.f3353c, aVar.f3352b)) {
                    return null;
                }
                str2 = b(context, aVar) ? "get next page request was sended" : "retry action was sended";
            }
            int i7 = aVar.f3352b;
            if (i7 == 5) {
                int i8 = aVar.f3351a;
                if (i8 == 1) {
                    if (aVar.f3354d.size() > 0) {
                        intent.putStringArrayListExtra("tags", aVar.f3354d);
                        return intent;
                    }
                } else if (i8 == 2 && (str = aVar.f3356f) != null) {
                    intent.putExtra("alias", str);
                    return intent;
                }
            } else if (i7 == 6) {
                if (aVar.f3351a == 1) {
                    intent.putExtra("validated", jSONObject.optBoolean("validated", false));
                    return intent;
                }
                Logger.w("TagAliasNewProtoRetryHelper", "unsupport  proto type");
            }
            return intent;
        }
        Logger.d("TagAliasNewProtoRetryHelper", str2);
        return null;
    }

    public a a(Context context, long j6, int i6) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onPushStatusResponse, seqID:" + j6 + ",errorCode:" + i6);
        a aVar = this.f3350c.get(Long.valueOf(j6));
        StringBuilder sb = new StringBuilder();
        sb.append("tagAliasCacheNode:");
        sb.append(aVar);
        Logger.d("TagAliasNewProtoRetryHelper", sb.toString());
        this.f3350c.remove(Long.valueOf(j6));
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return aVar;
        }
        if (!a(context, i6, aVar)) {
            return aVar;
        }
        Logger.d("TagAliasNewProtoRetryHelper", "retry action was sended");
        return null;
    }

    private a a(JSONObject jSONObject, a aVar) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onUpdateCacheNode,responseJson:" + jSONObject + ",tagAliasCacheNode:" + aVar);
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return null;
        }
        if (TextUtils.equals(jSONObject.optString("op"), l3.f4736f)) {
            if (aVar.f3351a == 1) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("tags");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                            arrayList.add(optJSONArray.getString(i6));
                        }
                        if (arrayList.size() > 0) {
                            aVar.f3354d.addAll(arrayList);
                            return aVar;
                        }
                    }
                } catch (Throwable th) {
                    Logger.e("TagAliasNewProtoRetryHelper", "parse tag list failed - error:" + th);
                    return aVar;
                }
            } else {
                String optString = jSONObject.optString("alias");
                if (optString != null) {
                    aVar.f3356f = optString;
                }
            }
        }
        return aVar;
    }

    public static c a() {
        if (f3348a == null) {
            synchronized (f3349b) {
                try {
                    if (f3348a == null) {
                        f3348a = new c();
                    }
                } finally {
                }
            }
        }
        return f3348a;
    }

    public void a(int i6, int i7, long j6, ArrayList<String> arrayList, String str, Map<String, Object> map) {
        a aVar = new a(i6, i7, j6, arrayList, map, str);
        Logger.d("TagAliasNewProtoRetryHelper", "action - createNewCacheNode, tagAliasCacheNode:" + aVar);
        this.f3350c.put(Long.valueOf(j6), aVar);
    }

    public void a(Context context) {
        try {
            ConcurrentHashMap<Long, a> concurrentHashMap = this.f3350c;
            if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
                return;
            }
            Iterator<Map.Entry<Long, a>> it = this.f3350c.entrySet().iterator();
            while (it.hasNext()) {
                b(context, it.next().getValue());
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i6) {
        ConcurrentHashMap<Long, a> concurrentHashMap = this.f3350c;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<Long, a>> it = this.f3350c.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null && value.f3351a == i6) {
                return false;
            }
        }
        return true;
    }

    protected boolean a(Context context, int i6, long j6, int i7) {
        if ((i6 != 1 && i6 != 2 && i6 != 3 && i6 != 4) || !cn.jpush.android.cache.a.k(context)) {
            return false;
        }
        Logger.w("TagAliasNewProtoRetryHelper", "tag/alias action was freezed");
        b.a(context, i6, JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE, j6, i7);
        return true;
    }

    private boolean a(Context context, int i6, a aVar) {
        int i7;
        Logger.d("TagAliasNewProtoRetryHelper", "action - CheckAndSendAgain, errorCode:" + i6 + ",tagAliasCacheNode:" + aVar);
        if (i6 != 1 || (i7 = aVar.f3359i) != 0) {
            return false;
        }
        aVar.f3359i = i7 + 1;
        if (a(context, aVar.f3351a, aVar.f3353c, aVar.f3352b)) {
            return true;
        }
        return b(context, aVar);
    }

    private boolean a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "tagAlias cache was null";
        } else {
            Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasResponse, tagAliasCacheNode:" + aVar);
            if (aVar.f3358h < aVar.f3357g) {
                return true;
            }
            str = "all tags info was loaded";
        }
        Logger.d("TagAliasNewProtoRetryHelper", str);
        return false;
    }
}
