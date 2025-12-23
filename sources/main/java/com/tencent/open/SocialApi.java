package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocialApi {

    /* renamed from: a, reason: collision with root package name */
    private SocialApiIml f40447a;

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f40447a.ask(activity, bundle, iUiListener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f40447a.gift(activity, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f40447a.invite(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f40447a.story(activity, bundle, iUiListener);
    }

    public SocialApi(QQToken qQToken) {
        this.f40447a = new SocialApiIml(qQToken);
    }
}
