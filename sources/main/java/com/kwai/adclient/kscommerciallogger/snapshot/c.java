package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {
    private final String bfc;
    private final LinkedList<d> bfd;
    private int bfe;
    private final int bff;
    private long bfg;

    c(String str) {
        this(str, 10);
    }

    public final synchronized long Tr() {
        return this.bfg;
    }

    public synchronized d hP(String str) {
        d dVar;
        try {
            if (this.bfd.size() >= this.bff) {
                this.bfd.removeFirst();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            int i6 = this.bfe;
            this.bfe = i6 + 1;
            sb.append(i6);
            dVar = new d(sb.toString());
            this.bfd.addLast(dVar);
            this.bfg = System.currentTimeMillis();
        } catch (Throwable th) {
            throw th;
        }
        return dVar;
    }

    synchronized JSONObject hQ(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<d> it = this.bfd.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().Tq());
                }
                jSONObject.put("session_id", str);
                jSONObject.put("segment_name", this.bfc);
                jSONObject.put("spans", jSONArray);
                this.bfg = System.currentTimeMillis();
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    c(String str, int i6) {
        this.bfc = str == null ? "" : str;
        this.bfd = new LinkedList<>();
        this.bff = Math.min(i6, 30);
        this.bfg = System.currentTimeMillis();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.bfc.equals(((c) obj).bfc);
    }

    final String getName() {
        return this.bfc;
    }

    public int hashCode() {
        return Objects.hash(this.bfc);
    }
}
