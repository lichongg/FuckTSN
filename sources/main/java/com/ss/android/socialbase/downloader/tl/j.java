package com.ss.android.socialbase.downloader.tl;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bytedance.sdk.component.utils.vl;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.ss.android.socialbase.downloader.ae.r;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.g.g;
import com.ss.android.socialbase.downloader.g.up;
import com.ss.android.socialbase.downloader.r.az;
import com.ss.android.socialbase.downloader.r.l;
import com.ss.android.socialbase.downloader.up.tl;
import com.ss.android.socialbase.downloader.xt.m;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j {
    public static void j(r rVar, com.ss.android.socialbase.downloader.up.j jVar, int i6) {
        if (rVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.ae.cw j6 = rVar.j();
            if (j6 == null) {
                return;
            }
            l up = rVar.up();
            boolean cw = m.cw(i6);
            if (!cw && !(cw = j(j6.st(), i6)) && up != null && (up instanceof com.ss.android.socialbase.downloader.r.r)) {
                cw = j(((com.ss.android.socialbase.downloader.r.r) up).j(), i6);
            }
            if (cw) {
                try {
                    az r5 = rVar.r();
                    if (r5 != null) {
                        r5.j(j6, jVar, i6);
                    }
                } catch (Throwable th) {
                    vl.j(th);
                }
                j(up, j6, jVar, i6);
                j(com.ss.android.socialbase.downloader.downloader.cw.m(), j6, jVar, i6);
            }
        } catch (Throwable th2) {
            vl.j(th2);
        }
    }

    private static boolean j(int[] iArr, int i6) {
        if (iArr != null && iArr.length > 0) {
            for (int i7 : iArr) {
                if (i6 == i7) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void j(l lVar, com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar, int i6) {
        if (lVar == null) {
            return;
        }
        try {
            String xt = lVar.xt();
            if (TextUtils.isEmpty(xt)) {
                xt = "default";
            }
            JSONObject j6 = j(xt, cwVar, jVar, i6);
            if (j6 == null) {
                j6 = new JSONObject();
            }
            lVar.j(j6);
        } catch (Throwable unused) {
        }
    }

    public static void j(xt xtVar, com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar, int i6) {
        if (xtVar == null || !cwVar.aq() || TextUtils.isEmpty(cwVar.rr())) {
            return;
        }
        try {
            JSONObject j6 = j(cwVar.rr(), cwVar, jVar, i6);
            if (j6 == null) {
                j6 = new JSONObject();
            }
            if (i6 == -1) {
                j6.put(NotificationCompat.CATEGORY_STATUS, jVar.j());
            } else {
                j(i6, j6, cwVar);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    private static void j(int i6, JSONObject jSONObject, com.ss.android.socialbase.downloader.ae.cw cwVar) throws JSONException {
        String str;
        if (i6 == -5) {
            str = "download_uncomplete";
        } else if (i6 == -4) {
            str = "download_cancel";
        } else if (i6 == -3) {
            double gs = cwVar.gs();
            if (gs >= 0.0d) {
                jSONObject.put("download_speed", gs);
            }
            str = "download_success";
        } else if (i6 == -2) {
            str = "download_pause";
        } else if (i6 == 0) {
            str = "download_create";
        } else if (i6 == 2) {
            str = "download_start";
        } else if (i6 != 6) {
            str = "";
        } else {
            str = "download_first_start";
        }
        jSONObject.put(NotificationCompat.CATEGORY_STATUS, str);
    }

    public static String j(String str) {
        try {
            if (TextUtils.isDigitsOnly(str)) {
                return String.valueOf(Long.valueOf(str).longValue() % 100);
            }
            return "";
        } catch (Exception e6) {
            vl.j(e6);
            return "";
        }
    }

    private static JSONObject j(String str, com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar, int i6) {
        JSONObject jSONObject;
        String str2;
        Object obj;
        Object obj2;
        int i7;
        Object obj3;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e6) {
            e = e6;
        }
        try {
            w oq = com.ss.android.socialbase.downloader.downloader.cw.oq();
            if (oq == null) {
                str2 = "";
                obj = str2;
                obj2 = obj;
                i7 = 0;
            } else {
                str2 = oq.xt();
                obj = j(str2);
                obj2 = oq.j();
                i7 = oq.cw();
            }
            if (jVar == null || !(jVar instanceof tl)) {
                obj3 = "";
            } else {
                obj3 = ((tl) jVar).r();
            }
            jSONObject.put("event_page", str);
            jSONObject.put("app_id", obj2);
            jSONObject.put("device_id", str2);
            jSONObject.put("device_id_postfix", obj);
            jSONObject.put("update_version", i7);
            jSONObject.put("download_status", i6);
            if (cwVar != null) {
                jSONObject.put("setting_tag", com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).cw("setting_tag"));
                jSONObject.put("download_id", cwVar.ae());
                jSONObject.put(CommonNetImpl.NAME, cwVar.tl());
                jSONObject.put("url", cwVar.oq());
                jSONObject.put("save_path", cwVar.qv());
                jSONObject.put("download_time", cwVar.hu());
                jSONObject.put("cur_bytes", cwVar.uq());
                jSONObject.put("total_bytes", cwVar.ka());
                jSONObject.put("network_quality", cwVar.wo());
                jSONObject.put("only_wifi", cwVar.x() ? 1 : 0);
                jSONObject.put("need_https_degrade", cwVar.d() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", cwVar.kt() ? 1 : 0);
                jSONObject.put(TKDownloadReason.KSAD_TK_MD5, cwVar.rn() == null ? "" : cwVar.rn());
                jSONObject.put("chunk_count", cwVar.kj());
                jSONObject.put("is_force", cwVar.ri() ? 1 : 0);
                jSONObject.put("retry_count", cwVar.c());
                jSONObject.put("cur_retry_time", cwVar.fx());
                jSONObject.put("need_retry_delay", cwVar.wi() ? 1 : 0);
                jSONObject.put("need_reuse_first_connection", cwVar.ln() ? 1 : 0);
                jSONObject.put("default_http_service_backup", cwVar.az() ? 1 : 0);
                jSONObject.put("retry_delay_status", cwVar.rs().ordinal());
                jSONObject.put("backup_url_used", cwVar.hh() ? 1 : 0);
                jSONObject.put("download_byte_error_retry_status", cwVar.ik().ordinal());
                jSONObject.put("forbidden_handler_status", cwVar.jl().ordinal());
                jSONObject.put("need_independent_process", cwVar.xp() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", cwVar.cw() != null ? cwVar.cw() : "");
                jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, cwVar.h() != null ? cwVar.h() : "");
                jSONObject.put("add_listener_to_same_task", cwVar.uc() ? 1 : 0);
                jSONObject.put("backup_url_count", cwVar.ja() != null ? cwVar.ja().size() : 0);
                jSONObject.put("cur_backup_url_index", cwVar.ja() != null ? cwVar.mi() : -1);
                jSONObject.put("forbidden_urls", cwVar.rh() != null ? cwVar.rh().toString() : "");
                jSONObject.put("task_id", TextUtils.isEmpty(cwVar.nu()) ? "" : cwVar.nu());
                try {
                    String oq2 = cwVar.oq();
                    if (TextUtils.isEmpty(oq2)) {
                        str3 = "";
                        str4 = str3;
                        str5 = str4;
                    } else {
                        Uri parse = Uri.parse(oq2);
                        str4 = parse.getHost();
                        str5 = parse.getPath();
                        str3 = parse.getLastPathSegment();
                        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str3)) {
                            try {
                                str5 = str5.substring(0, str5.length() - str3.length());
                            } catch (Throwable th) {
                                vl.j(th);
                            }
                        }
                    }
                    jSONObject.put("url_host", str4);
                    jSONObject.put("url_path", str5);
                    jSONObject.put("url_last_path_segment", str3);
                } catch (Throwable th2) {
                    vl.j(th2);
                }
            }
            jSONObject.put("error_code", jVar != null ? jVar.j() : 0);
            jSONObject.put("error_msg", jVar != null ? jVar.xt() : "");
            jSONObject.put("request_log", obj3);
            return jSONObject;
        } catch (JSONException e7) {
            e = e7;
            jSONObject2 = jSONObject;
            vl.j(e);
            return jSONObject2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:8|(4:63|64|65|(14:67|11|(3:44|(1:(2:53|(1:55)(2:56|57)))|50)|14|(2:18|19)|22|23|24|(1:26)|27|28|(1:39)|31|(2:36|37)(1:34)))|10|11|(0)|44|(1:46)|(0)|14|(3:16|18|19)|22|23|24|(0)|27|28|(0)|39|31|(0)|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0111, code lost:
    
        com.bytedance.sdk.component.utils.vl.j(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4 A[Catch: JSONException -> 0x00f6, all -> 0x0130, TryCatch #1 {JSONException -> 0x00f6, blocks: (B:24:0x00aa, B:26:0x00e4, B:27:0x00f9), top: B:23:0x00aa, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0058 A[Catch: all -> 0x0130, TRY_LEAVE, TryCatch #0 {all -> 0x0130, blocks: (B:65:0x0030, B:67:0x0034, B:14:0x007c, B:16:0x0092, B:22:0x00a5, B:24:0x00aa, B:26:0x00e4, B:27:0x00f9, B:36:0x0122, B:39:0x011a, B:43:0x0111, B:44:0x0046, B:46:0x004c, B:53:0x0058, B:57:0x0065, B:60:0x006a, B:62:0x0076, B:70:0x002d, B:64:0x0027), top: B:8:0x0025, inners: #1, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void j(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.g.ae r11, java.lang.String r12, java.lang.String r13, long r14, java.lang.String r16, int r17, java.io.IOException r18, com.ss.android.socialbase.downloader.ae.cw r19) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.tl.j.j(com.ss.android.socialbase.downloader.g.ae, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.ae.cw):void");
    }

    public static void j(com.ss.android.socialbase.downloader.jy.j jVar, com.ss.android.socialbase.downloader.ae.cw cwVar, String str, g gVar, boolean z5, boolean z6, com.ss.android.socialbase.downloader.up.j jVar2, long j6, long j7, boolean z7, long j8, long j9, long j10, JSONObject jSONObject) {
        j("download_io", jVar.xt("monitor_download_io"), jVar, cwVar, str, null, null, gVar, z5, z6, jVar2, j6, j7, z7, j8, j9, j10, null);
    }

    public static void j(com.ss.android.socialbase.downloader.jy.j jVar, com.ss.android.socialbase.downloader.ae.cw cwVar, String str, String str2, String str3, boolean z5, g gVar, com.ss.android.socialbase.downloader.up.j jVar2, long j6, long j7) {
        j("segment_io", jVar.xt("monitor_segment_io"), jVar, cwVar, str, str2, str3, gVar, z5, false, jVar2, j6, j7, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    private static void j(String str, int i6, com.ss.android.socialbase.downloader.jy.j jVar, com.ss.android.socialbase.downloader.ae.cw cwVar, String str2, String str3, String str4, g gVar, boolean z5, boolean z6, com.ss.android.socialbase.downloader.up.j jVar2, long j6, long j7, boolean z7, long j8, long j9, long j10, JSONObject jSONObject) {
        String str5;
        int i7;
        int i8;
        if (i6 <= 0 || j7 <= 0) {
            return;
        }
        try {
            Uri parse = Uri.parse(str2);
            String host = parse.getHost();
            String path = parse.getPath();
            String lastPathSegment = parse.getLastPathSegment();
            int i9 = 0;
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            String str6 = null;
            if (z5) {
                i9 = 1;
            } else if (z6) {
                i9 = 2;
            } else if (jVar2 != null) {
                i9 = !com.ss.android.socialbase.downloader.az.m.cw(com.ss.android.socialbase.downloader.downloader.cw.nd()) ? 1049 : jVar2.j();
                str6 = jVar2.xt();
            }
            JSONObject jSONObject2 = new JSONObject();
            String str7 = "";
            if (gVar != null) {
                i8 = !(gVar instanceof up) ? 1 : 0;
                String j11 = gVar.j("X-Cache");
                int contains = !TextUtils.isEmpty(j11) ? j11.toLowerCase().contains("hit") : -1;
                jVar.j("monitor_sla", 1);
                if (gVar instanceof com.ss.android.socialbase.downloader.g.j) {
                    str7 = ((com.ss.android.socialbase.downloader.g.j) gVar).m();
                }
                i7 = contains;
                str5 = str6;
            } else {
                str5 = str6;
                i7 = -1;
                i8 = -1;
            }
            double d6 = j6 / 1048576.0d;
            double d7 = j7;
            double nanos = d7 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject2.put("setting_tag", jVar.cw("setting_tag"));
            jSONObject2.put("url_host", host);
            jSONObject2.putOpt("host_ip", str3);
            jSONObject2.putOpt("host_real_ip", str4);
            jSONObject2.put("url_path", path);
            jSONObject2.put("url_last_path_segment", lastPathSegment);
            jSONObject2.put("net_lib", i8);
            jSONObject2.put("hit_cdn_cache", i7);
            jSONObject2.put("status_code", i9);
            jSONObject2.put("request_log", str7);
            if (str5 != null) {
                jSONObject2.put("error_msg", com.ss.android.socialbase.downloader.az.m.j(str5, jVar.j("exception_msg_length", 500)));
            }
            jSONObject2.put("download_sec", nanos);
            jSONObject2.put("download_mb", d6);
            if (nanos > 0.0d) {
                jSONObject2.put("download_speed", d6 / nanos);
            }
            if (z7) {
                jSONObject2.put("rw_read_time", j8 / d7);
                jSONObject2.put("rw_write_time", j9 / d7);
                jSONObject2.put("rw_sync_time", j10 / d7);
            }
            jSONObject2.put(Constants.PARAM_PKG_NAME, cwVar.la());
            jSONObject2.put(CommonNetImpl.NAME, cwVar.g());
            if (i6 != 1) {
                if (i6 == 3) {
                }
                if (i6 != 2 || i6 == 3) {
                    com.ss.android.socialbase.downloader.downloader.cw.ol().j(cwVar.ae(), str, jSONObject2);
                }
                return;
            }
            com.ss.android.socialbase.downloader.downloader.cw.m();
            if (i6 != 2) {
            }
            com.ss.android.socialbase.downloader.downloader.cw.ol().j(cwVar.ae(), str, jSONObject2);
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public static void j(com.ss.android.socialbase.downloader.ae.cw cwVar, List<com.ss.android.socialbase.downloader.qv.g> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.qv.g.j(list));
            jSONObject.put("cur_bytes", cwVar.uq());
            jSONObject.put("total_bytes", cwVar.ka());
            cw ol = com.ss.android.socialbase.downloader.downloader.cw.ol();
            if (ol != null) {
                ol.j(cwVar.ae(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }
}
