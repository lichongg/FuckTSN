package com.kwad.components.ad.reward.l;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.aa;
import java.util.Observable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b extends Observable implements c, com.kwad.sdk.core.b {
    private boolean AY = false;
    protected String AZ;
    protected String Ba;

    private boolean kG() {
        return this.AY;
    }

    public final void kC() {
        if (this.AY) {
            return;
        }
        this.AY = true;
        kH();
    }

    public final void kD() {
        if (this.AY) {
            this.AY = false;
            kH();
        }
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String kE() {
        return this.AZ;
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String kF() {
        return this.Ba;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.AY = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "selfCompleted", this.AY);
        return jSONObject;
    }

    private void kH() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.AY));
    }

    public boolean isCompleted() {
        return kG();
    }
}
