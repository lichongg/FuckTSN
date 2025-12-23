package com.bytedance.sdk.openadsdk.ch.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTNativeAd.EasyPlayWidgetListener f27749j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f27749j == null) {
            return null;
        }
        ValueSet k6 = a.j(sparseArray).k();
        switch (k6.intValue(-99999987)) {
            case 144101:
                this.f27749j.onInfo((JSONObject) k6.objectValue(0, JSONObject.class));
                return null;
            case 144102:
                return this.f27749j.getEstimatedInteractionArea();
            case 144103:
                this.f27749j.onCanRenderSuccess((JSONObject) k6.objectValue(0, JSONObject.class));
                return null;
            case 144104:
                this.f27749j.onCanRenderFail((JSONObject) k6.objectValue(0, JSONObject.class));
                return null;
            case 144105:
                this.f27749j.onClose();
                return null;
            default:
                return null;
        }
    }

    public xt(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        this.f27749j = easyPlayWidgetListener;
    }
}
