package com.baidu.mobads.sdk.internal.a;

import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface a extends IOAdEvent {
    @NonNull
    IAdInterListener getDelegator();

    Object handleEvent(String str, String str2, Object[] objArr);
}
