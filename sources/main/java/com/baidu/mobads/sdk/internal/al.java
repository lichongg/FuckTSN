package com.baidu.mobads.sdk.internal;

import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.ShakeViewContainer;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class al implements ShakeViewContainer {

    /* renamed from: a, reason: collision with root package name */
    private RelativeLayout f10577a;

    /* renamed from: b, reason: collision with root package name */
    private IOAdEventListener f10578b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements IOAdEvent {

        /* renamed from: a, reason: collision with root package name */
        private final String f10579a;

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public int getCode() {
            return 0;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public Map<String, Object> getData() {
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public Object getTarget() {
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public String getMessage() {
            return this.f10579a;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public String getType() {
            return "native_shake";
        }

        a(String str) {
            this.f10579a = str;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public void setTarget(Object obj) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.ShakeViewContainer
    public void destroy() {
        IOAdEventListener iOAdEventListener = this.f10578b;
        if (iOAdEventListener != null) {
            iOAdEventListener.run(new a("destroy"));
        }
        this.f10578b = null;
        this.f10577a = null;
    }

    @Override // com.baidu.mobads.sdk.api.ShakeViewContainer
    public RelativeLayout getContainer() {
        return this.f10577a;
    }

    @Override // com.baidu.mobads.sdk.api.ShakeViewContainer
    public void pause() {
        IOAdEventListener iOAdEventListener = this.f10578b;
        if (iOAdEventListener != null) {
            iOAdEventListener.run(new a("pause"));
        }
    }

    @Override // com.baidu.mobads.sdk.api.ShakeViewContainer
    public void resume() {
        IOAdEventListener iOAdEventListener = this.f10578b;
        if (iOAdEventListener != null) {
            iOAdEventListener.run(new a("resume"));
        }
    }

    public al(RelativeLayout relativeLayout, IOAdEventListener iOAdEventListener) {
        this.f10577a = relativeLayout;
        this.f10578b = iOAdEventListener;
    }
}
