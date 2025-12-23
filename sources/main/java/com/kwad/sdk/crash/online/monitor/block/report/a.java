package com.kwad.sdk.crash.online.monitor.block.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends d {
    public static int Nv = 1;
    private static volatile a aPV;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public synchronized BlockReportAction f(@NonNull Cursor cursor) {
        try {
        } catch (JSONException e6) {
            c.printStackTrace(e6);
            return new BlockReportAction("");
        }
        return new BlockReportAction(new JSONObject(cursor.getString(0)));
    }

    private a(Context context) {
        super(new com.kwad.sdk.crash.online.monitor.block.a.a(context, Nv));
    }

    public static a cc(Context context) {
        if (aPV == null) {
            synchronized (a.class) {
                try {
                    if (aPV == null) {
                        aPV = new a(context);
                    }
                } finally {
                }
            }
        }
        return aPV;
    }

    @Override // com.kwad.sdk.core.report.d
    public final String Ip() {
        return "ksad_block_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String[] Iq() {
        return new String[]{"aLog"};
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "perfMonitor.BlockReportDBManager";
    }
}
