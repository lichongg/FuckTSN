package s0;

import android.content.Context;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

@ATSApi("alog")
/* loaded from: D:\Downloads\app\classes4.dex */
public interface a {
    @ATSMethod(1)
    void a(Context context, JSONObject jSONObject);

    @ATSMethod(2)
    void b(ScheduledExecutorService scheduledExecutorService);

    @ATSMethod(17)
    void cw();

    @ATSMethod(10)
    void cw(String str, String str2);

    @ATSMethod(3)
    void j();

    @ATSMethod(4)
    void j(int i6);

    @ATSMethod(5)
    void j(Context context, String str, String str2);

    @ATSMethod(6)
    void j(String str);

    @ATSMethod(8)
    void j(String str, String str2);

    @ATSMethod(13)
    void j(String str, String str2, Throwable th);

    @ATSMethod(12)
    void j(String str, Throwable th);

    @ATSMethod(11)
    void r(String str, String str2);

    @ATSMethod(14)
    void up(String str, String str2);

    @ATSMethod(7)
    void xt();

    @ATSMethod(9)
    void xt(String str, String str2);

    @ATSMethod(15)
    void xt(String str, String str2, Throwable th);

    @ATSMethod(16)
    void xt(String str, Throwable th);
}
