package com.tencent.open;

import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class GuildApi extends BaseApi {
    public static final int CREATE_GUILD_ERROR_ALREADY_EXIST = -1;
    public static final int JOIN_GUILD_ERROR_NOT_EXIST = -1;

    public GuildApi(QQToken qQToken) {
        super(qQToken);
    }
}
