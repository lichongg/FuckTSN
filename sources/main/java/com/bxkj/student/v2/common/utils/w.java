package com.bxkj.student.v2.common.utils;

import android.content.Context;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20952a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final String f20953b = "wxc9214f296e1fba92";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        public final void a(@NotNull Context mContext, @NotNull String userName, @Nullable String str) {
            g0.p(mContext, "mContext");
            g0.p(userName, "userName");
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(mContext, w.f20953b);
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = userName;
            req.path = str;
            req.miniprogramType = 0;
            createWXAPI.sendReq(req);
        }
    }
}
