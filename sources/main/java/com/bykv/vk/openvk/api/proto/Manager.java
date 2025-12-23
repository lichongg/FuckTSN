package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface Manager {
    Loader createLoader(Context context);

    Bridge getBridge(int i6);

    ValueSet values();
}
