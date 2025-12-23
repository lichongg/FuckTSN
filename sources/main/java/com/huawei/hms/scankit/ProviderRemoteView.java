package com.huawei.hms.scankit;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ProviderRemoteView extends LinearLayout {
    public ProviderRemoteView(Context context, boolean z5, boolean z6) {
        super(context);
        a(z5, z6);
    }

    private void a(boolean z5, boolean z6) {
        if (z5) {
            LayoutInflater.from(getContext()).inflate(R.layout.scankit_zxl_capture_customed, this);
        } else if (z6) {
            LayoutInflater.from(getContext()).inflate(R.layout.scankit_zxl_capture, this);
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.scankit_zxl_capture_new, this);
        }
    }

    public ProviderRemoteView(Context context, boolean z5) {
        this(context, z5, true);
    }
}
