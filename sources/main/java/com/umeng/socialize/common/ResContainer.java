package com.umeng.socialize.common;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ResContainer {
    private static ResContainer R = null;
    private static String mPackageName = "";
    private Context context;
    private Map<String, SocializeResource> mResources;
    private Map<String, Integer> map = new HashMap();

    private ResContainer(Context context) {
        this.context = null;
        this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public synchronized Map<String, SocializeResource> batch() {
        try {
            Map<String, SocializeResource> map = this.mResources;
            if (map == null) {
                return map;
            }
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                SocializeResource socializeResource = this.mResources.get(it.next());
                socializeResource.mId = getResourceId(this.context, socializeResource.mType, socializeResource.mName);
                socializeResource.mIsCompleted = true;
            }
            return this.mResources;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SocializeResource {
        public int mId;
        public boolean mIsCompleted = false;
        public String mName;
        public String mType;

        public SocializeResource(String str, String str2) {
            this.mType = str;
            this.mName = str2;
        }
    }

    public static synchronized ResContainer get(Context context) {
        ResContainer resContainer;
        synchronized (ResContainer.class) {
            try {
                if (R == null) {
                    R = new ResContainer(context);
                }
                resContainer = R;
            } catch (Throwable th) {
                throw th;
            }
        }
        return resContainer;
    }

    public static String getString(Context context, String str) {
        return context.getString(getResourceId(context, ResIdentify.RES_TYPE_STRING, str));
    }

    public int anim(String str) {
        return getResourceId(this.context, "anim", str);
    }

    public int color(String str) {
        return getResourceId(this.context, "color", str);
    }

    public int dimen(String str) {
        return getResourceId(this.context, "dimen", str);
    }

    public int drawable(String str) {
        return getResourceId(this.context, ResIdentify.RES_TYPE_DRAWABLE, str);
    }

    public int id(String str) {
        return getResourceId(this.context, "id", str);
    }

    public int layout(String str) {
        return getResourceId(this.context, ResIdentify.RES_TYPE_LAYOUT, str);
    }

    public int raw(String str) {
        return getResourceId(this.context, ResIdentify.RES_TYPE_RAW, str);
    }

    public int string(String str) {
        return getResourceId(this.context, ResIdentify.RES_TYPE_STRING, str);
    }

    public int style(String str) {
        return getResourceId(this.context, ResIdentify.RES_TYPE_STYLE, str);
    }

    public int styleable(String str) {
        return getResourceId(this.context, "styleable", str);
    }

    public static int getResourceId(Context context, String str, String str2) {
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(mPackageName)) {
            mPackageName = context.getPackageName();
        }
        int identifier = resources.getIdentifier(str2, str, mPackageName);
        if (identifier > 0) {
            return identifier;
        }
        throw new RuntimeException(UmengText.errorWithUrl(UmengText.resError(mPackageName, str, str2), UrlUtil.ALL_NO_RES));
    }

    public ResContainer(Context context, Map<String, SocializeResource> map) {
        this.mResources = map;
        this.context = context;
    }
}
