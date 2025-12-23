package com.beizi.fusion.b;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f13292a;

    public static AdSpacesBean a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(context);
            if (!responseInfo.isInit()) {
                responseInfo.init();
            }
            Manager manager = responseInfo.getManager();
            if (manager != null) {
                List<AdSpacesBean> adSpaces = manager.getAdSpaces();
                if (adSpaces != null && adSpaces.size() > 0) {
                    for (int i6 = 0; i6 < adSpaces.size(); i6++) {
                        AdSpacesBean adSpacesBean = adSpaces.get(i6);
                        if (str.equals(adSpacesBean.getSpaceId())) {
                            return adSpacesBean;
                        }
                    }
                }
                a(2);
                return null;
            }
            a(1);
        }
        return null;
    }

    public static int a() {
        int i6 = f13292a;
        a(0);
        return i6;
    }

    public static void a(int i6) {
        f13292a = i6;
    }
}
