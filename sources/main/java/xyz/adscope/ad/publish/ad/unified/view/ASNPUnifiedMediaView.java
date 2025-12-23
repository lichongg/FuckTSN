package xyz.adscope.ad.publish.ad.unified.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import xyz.adscope.ad.publish.ad.unified.UnifiedMediaConfig;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPUnifiedMediaView extends FrameLayout {
    public ASNPUnifiedMediaView(Context context) {
        super(context);
    }

    public ASNPUnifiedMediaView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ASNPUnifiedMediaView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    public void setMediaConfig(UnifiedMediaConfig unifiedMediaConfig) {
        setTag(ResIdentify.getIDIdentify(getContext(), "scope_unified_media_config"), unifiedMediaConfig);
    }

    public ASNPUnifiedMediaView(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }
}
