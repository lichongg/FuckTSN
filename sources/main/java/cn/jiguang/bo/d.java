package cn.jiguang.bo;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.jiguang.bp.i;
import cn.jiguang.internal.ActionManager;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static cn.jiguang.bp.e f2416a;

    private static JSONArray a(Throwable th) {
        try {
            if (!(th instanceof c)) {
                return null;
            }
            l lVar = new l(new k());
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(((c) th).c().getId()));
            List<cn.jiguang.bp.h> a6 = lVar.a(arrayList);
            if (a6 == null || a6.size() <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int size = a6.size();
            for (int i6 = 0; i6 < size; i6++) {
                JSONObject jSONObject = new JSONObject();
                cn.jiguang.bp.h hVar = a6.get(i6);
                if (hVar != null) {
                    if (hVar.c() != null) {
                        jSONObject.put("crashed", hVar.c());
                    }
                    if (hVar.d() != null) {
                        jSONObject.put("current", hVar.d());
                    }
                    if (hVar.b() != null) {
                        jSONObject.put(CommonNetImpl.NAME, hVar.b());
                    }
                    if (hVar.g() != null) {
                        jSONObject.put("daemon", hVar.g());
                    }
                    if (hVar.a() != null) {
                        jSONObject.put("id", hVar.a());
                    }
                    if (hVar.f() != null) {
                        jSONObject.put("priority", hVar.f());
                    }
                    if (hVar.e() != null) {
                        a(jSONObject, hVar.e());
                    }
                    if (hVar.h() != null) {
                        jSONObject.put("state", hVar.h());
                    }
                    if (jSONObject.length() > 0) {
                        jSONArray.put(jSONObject);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
            return null;
        } catch (JSONException e6) {
            cn.jiguang.bb.f.a("ExceptionParseUtils", "Error parse Exception.", e6);
            return null;
        }
    }

    public static JSONObject a(Context context, cn.jiguang.bp.i iVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (iVar.b() != null) {
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_SID, iVar.b().toString());
            }
            jSONObject.put("did", cn.jiguang.bz.h.a(context));
            if (iVar.c() != null) {
                jSONObject.put("init", iVar.c());
            }
            Date a6 = iVar.a();
            if (a6 != null) {
                jSONObject.put("started", cn.jiguang.bz.f.a(a6));
            }
            i.a e6 = iVar.e();
            if (e6 != null) {
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, e6.name().toLowerCase(Locale.ROOT));
            }
            if (iVar.f() != null) {
                jSONObject.put(RtspHeaders.Values.SEQ, iVar.f());
            }
            int d6 = iVar.d();
            if (d6 > 0) {
                jSONObject.put("errors", d6);
            }
            if (iVar.g() != null) {
                jSONObject.put("duration", iVar.g());
            }
            if (iVar.h() != null) {
                jSONObject.put("timestamp", cn.jiguang.bz.f.a(iVar.h()));
            }
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.bb.f.a("ExceptionParseUtils", "Error parse SentrySessionEnvelopeItem.", th);
            return null;
        }
    }

    public static void b(Context context, Throwable th) {
        try {
            for (cn.jiguang.bp.d dVar : new j(new k()).a(th)) {
                if (dVar.e() != null && dVar.e().a() != null) {
                    List<cn.jiguang.bp.f> a6 = dVar.e().a();
                    boolean z5 = false;
                    for (int i6 = 0; i6 < a6.size(); i6++) {
                        cn.jiguang.bp.f fVar = a6.get(i6);
                        if (fVar != null) {
                            String a7 = cn.jiguang.bu.c.a(fVar.c());
                            if (!TextUtils.isEmpty(a7)) {
                                if (dVar.f() != null && TextUtils.equals("ANR", dVar.f().a())) {
                                    z5 = true;
                                }
                                cn.jiguang.bq.a.a().a(context, a7, z5 ? "EX_ANR" : "EX_CRASH");
                                cn.jiguang.bb.f.i("ExceptionParseUtils", "sdk exception occurred, anr " + z5);
                                return;
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.bb.f.i("ExceptionParseUtils", "count ex failed, " + th2.getMessage());
        }
    }

    private static JSONArray c(Context context, Throwable th) {
        try {
            List<cn.jiguang.bp.d> a6 = new j(new k()).a(th);
            if (a6 == null || a6.size() <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int size = a6.size();
            for (int i6 = 0; i6 < size; i6++) {
                JSONObject jSONObject = new JSONObject();
                cn.jiguang.bp.d dVar = a6.get(i6);
                if (dVar != null) {
                    a(jSONObject, dVar.f());
                    if (dVar.c() != null) {
                        jSONObject.put(bi.f40962e, dVar.c());
                    }
                    if (dVar.d() != null) {
                        jSONObject.put(CrashHianalyticsData.THREAD_ID, dVar.d());
                    }
                    if (dVar.a() != null) {
                        jSONObject.put("type", dVar.a());
                    }
                    if (dVar.b() != null) {
                        jSONObject.put("value", dVar.b());
                    }
                    if (dVar.e() != null) {
                        a(jSONObject, dVar.e());
                    }
                    if (jSONObject.length() > 0) {
                        jSONArray.put(jSONObject);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
            return null;
        } catch (JSONException e6) {
            cn.jiguang.bb.f.a("ExceptionParseUtils", "Error parse Exception.", e6);
            return null;
        }
    }

    public static JSONObject a(Context context, Throwable th) {
        cn.jiguang.bp.c a6;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray c6 = c(context, th);
            if (c6 == null || c6.length() <= 0) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("values", c6);
            jSONObject.put("exception", jSONObject2);
            if ((th instanceof c) && (a6 = ((c) th).a()) != null && a6.a().equalsIgnoreCase("UncaughtExceptionHandler")) {
                jSONObject.put("level", "fatal");
            }
            JSONArray a7 = a(th);
            if (a7 != null && a7.length() > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("values", a7);
                jSONObject.put("threads", jSONObject3);
            }
            jSONObject.put("timestamp", cn.jiguang.bz.f.a(cn.jiguang.bz.f.c()));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(Constants.JumpUrlConstants.SRC_TYPE_APP, cn.jiguang.bu.c.a(context));
            jSONObject4.put("os", cn.jiguang.bu.c.d(context));
            jSONObject4.put(ConstantHelper.LOG_DE, cn.jiguang.bu.c.c(context));
            jSONObject.put("contexts", jSONObject4);
            jSONObject.put("dist", Integer.toString(cn.jiguang.a.a.f1445c));
            jSONObject.put("environment", "production");
            jSONObject.put("platform", "java");
            cn.jiguang.bp.e eVar = new cn.jiguang.bp.e();
            f2416a = eVar;
            jSONObject.put("event_id", eVar.toString());
            jSONObject.put("sdk", cn.jiguang.bu.c.a());
            jSONObject.put(au.f40908m, cn.jiguang.bu.c.b(context));
            return jSONObject;
        } catch (JSONException e6) {
            cn.jiguang.bb.f.a("ExceptionParseUtils", "Error parse SentryEventEnvelopeItem.", e6);
            return null;
        }
    }

    public static JSONObject a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", "application/json");
            jSONObject.put("type", str);
            return jSONObject;
        } catch (JSONException e6) {
            cn.jiguang.bb.f.a("ExceptionParseUtils", "Error parse SentryEnvelopeItemHeader.", e6);
            return null;
        }
    }

    public static JSONObject a(boolean z5) {
        cn.jiguang.bp.e eVar;
        try {
            JSONObject jSONObject = new JSONObject();
            if (z5 && (eVar = f2416a) != null) {
                jSONObject.put("event_id", eVar.toString());
            }
            JSONObject jSONObject2 = new JSONObject();
            ActionManager.getInstance().wrapSdkVersionInfo(jSONObject2);
            jSONObject2.put("core_sdk_ver", cn.jiguang.a.a.f1444b);
            jSONObject.put("sdks", jSONObject2);
            return jSONObject;
        } catch (JSONException e6) {
            cn.jiguang.bb.f.a("ExceptionParseUtils", "Error parse SentryEnvelopeHeader.", e6);
            return null;
        }
    }

    private static void a(JSONObject jSONObject, cn.jiguang.bp.c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (cVar.a() != null) {
                jSONObject2.put("type", cVar.a());
            }
            if (cVar.b() != null) {
                jSONObject2.put("handled", cVar.b());
            }
            jSONObject.put("mechanism", jSONObject2);
        } catch (JSONException e6) {
            cn.jiguang.bb.f.a("ExceptionParseUtils", "Error parse writeMechanism.", e6);
        }
    }

    private static void a(JSONObject jSONObject, cn.jiguang.bp.f fVar) {
        if (fVar == null) {
            return;
        }
        try {
            if (fVar.n() != null) {
                jSONObject.put(AMPSConstants.AdType.AD_TYPE_NATIVE, fVar.n());
            }
            if (fVar.a() != null) {
                jSONObject.put("filename", fVar.a());
            }
            if (fVar.b() != null) {
                jSONObject.put("function", fVar.b());
            }
            if (fVar.h() != null) {
                jSONObject.put("in_app", fVar.h());
            }
            if (fVar.d() != null) {
                jSONObject.put("lineno", fVar.d());
            }
            if (fVar.c() != null) {
                jSONObject.put(bi.f40962e, fVar.c());
            }
            if (fVar.i() != null) {
                jSONObject.put(WiseOpenHianalyticsData.UNION_PACKAGE, fVar.i());
            }
            if (fVar.f() != null) {
                jSONObject.put("abs_path", fVar.f());
            }
            if (fVar.e() != null) {
                jSONObject.put("colno", fVar.e());
            }
            if (fVar.g() != null) {
                jSONObject.put("context_line", fVar.g());
            }
            if (fVar.j() != null) {
                jSONObject.put("platform", fVar.j());
            }
            if (fVar.k() != null) {
                jSONObject.put("image_addr", fVar.k());
            }
            if (fVar.l() != null) {
                jSONObject.put("symbol_addr", fVar.l());
            }
            if (fVar.m() != null) {
                jSONObject.put("instruction_addr", fVar.m());
            }
            if (fVar.o() != null) {
                jSONObject.put("raw_function", fVar.o());
            }
        } catch (JSONException e6) {
            cn.jiguang.bb.f.a("ExceptionParseUtils", "Error parse StackFrame.", e6);
        }
    }

    private static void a(JSONObject jSONObject, cn.jiguang.bp.g gVar) {
        if (gVar == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (gVar.a() != null && gVar.a().size() > 0) {
                if (gVar.b() != null) {
                    jSONObject2.put("snapshot", gVar.b());
                }
                int size = gVar.a().size();
                JSONArray jSONArray = new JSONArray();
                for (int i6 = 0; i6 < size; i6++) {
                    JSONObject jSONObject3 = new JSONObject();
                    cn.jiguang.bp.f fVar = gVar.a().get(i6);
                    if (fVar != null) {
                        a(jSONObject3, fVar);
                        if (jSONObject3.length() > 0) {
                            jSONArray.put(jSONObject3);
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject2.put("frames", jSONArray);
                }
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("stacktrace", jSONObject2);
            }
        } catch (JSONException e6) {
            cn.jiguang.bb.f.a("ExceptionParseUtils", "Error parse StackTrace.", e6);
        }
    }
}
