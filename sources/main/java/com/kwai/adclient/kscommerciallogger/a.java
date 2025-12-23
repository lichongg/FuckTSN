package com.kwai.adclient.kscommerciallogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private com.kwai.adclient.kscommerciallogger.a.a bej;
    private com.kwai.adclient.kscommerciallogger.a.b bek;
    private JSONObject bel;
    private boolean bem;
    private boolean isDebug;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a, reason: collision with other inner class name */
    static final class C0714a {
        private static a ben;

        public static a Te() {
            if (ben == null) {
                ben = new a((byte) 0);
            }
            return ben;
        }
    }

    /* synthetic */ a(byte b6) {
        this();
    }

    public final void a(@NonNull com.kwai.adclient.kscommerciallogger.a.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.a.b bVar, @Nullable JSONObject jSONObject, boolean z5, boolean z6) {
        this.bej = aVar;
        this.bek = bVar;
        this.bel = jSONObject;
        this.isDebug = z5;
        this.bem = z6;
    }

    private a() {
        this.isDebug = false;
        this.bem = false;
    }

    private void b(@NonNull c cVar) {
        if (this.bej != null) {
            if (cVar.Ti() != null) {
                String str = cVar.Ti().value;
            }
            if (cVar.Tj() != null) {
                cVar.Tj().getValue();
            }
            cVar.Tm();
            b.z(cVar.Tk());
            b.z(cVar.Tl());
        }
    }

    public final JSONObject Tf() {
        return this.bel;
    }

    public final boolean Tg() {
        return this.bem;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public static a Te() {
        return C0714a.Te();
    }

    public final void a(c cVar) {
        if (cVar == null) {
            return;
        }
        b(cVar);
        com.kwai.adclient.kscommerciallogger.a.b bVar = this.bek;
        if (bVar != null) {
            bVar.M(cVar.Th(), cVar.toString());
        }
    }
}
