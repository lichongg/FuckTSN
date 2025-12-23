package n0;

import android.content.Context;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.R;
import com.bxkj.student.run.app.utils.d0;
import com.bxkj.student.v2.common.data.i;
import com.orhanobut.logger.j;
import com.tencent.bugly.BuglyStrategy;
import java.util.ArrayList;
import kotlin.collections.n;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final C0977a f50398a = new C0977a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nVoiceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceUtils.kt\ncom/bxkj/student/v2/common/utils/voice/VoiceUtils$Companion\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,225:1\n37#2,2:226\n37#2,2:228\n*S KotlinDebug\n*F\n+ 1 VoiceUtils.kt\ncom/bxkj/student/v2/common/utils/voice/VoiceUtils$Companion\n*L\n81#1:226,2\n200#1:228,2\n*E\n"})
    /* renamed from: n0.a$a, reason: collision with other inner class name */
    public static final class C0977a {
        public /* synthetic */ C0977a(v vVar) {
            this();
        }

        private C0977a() {
        }

        public final void a(@NotNull Context mContext, long j6, double d6, int i6) {
            char c6;
            Integer valueOf = Integer.valueOf(R.raw.f17643s);
            Integer valueOf2 = Integer.valueOf(R.raw.num_0);
            g0.p(mContext, "mContext");
            int o5 = b.f16998d.a().o();
            if (o5 == 3 || j6 == 0) {
                return;
            }
            if (j6 > 216000000) {
                j.d("超过60个小时，无法语音播报", new Object[0]);
                return;
            }
            if (d6 > 60000.0d) {
                j.d("超过60Km，无法语音播报", new Object[0]);
                return;
            }
            long j7 = 60;
            if (o5 != 0) {
                if (o5 == 1) {
                    j7 = 120;
                } else if (o5 == 2) {
                    j7 = 300;
                }
            }
            if (j6 % j7 == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(R.raw.dingdong));
                arrayList.add(Integer.valueOf(R.raw.active_for));
                if (c0.f16887a.k(i.f20657a.B(), "runType") != 5) {
                    String c7 = com.bxkj.student.run.app.utils.i.c(d6);
                    g0.m(c7);
                    String[] strArr = (String[]) u.m5(c7, new String[]{"."}, false, 0, 6, null).toArray(new String[0]);
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + Integer.parseInt(strArr[0]), ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    String str = strArr[1];
                    if (!g0.g("0", str)) {
                        arrayList.add(Integer.valueOf(R.raw.dot));
                        char[] charArray = str.toCharArray();
                        g0.o(charArray, "toCharArray(...)");
                        for (char c8 : charArray) {
                            arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + String.valueOf(c8), ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                        }
                    }
                    arrayList.add(Integer.valueOf(R.raw.kilometer));
                    int i7 = (i6 / BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH) % 10;
                    if (i7 > 0) {
                        arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i7, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                        arrayList.add(valueOf);
                    }
                    int i8 = (i6 / 10000) % 10;
                    if (i8 > 0) {
                        arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i8, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                        arrayList.add(Integer.valueOf(R.raw.f17644w));
                    } else if (i7 > 0) {
                        arrayList.add(valueOf2);
                    }
                    int i9 = (i6 / 1000) % 10;
                    if (i9 > 0) {
                        arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i9, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                        arrayList.add(Integer.valueOf(R.raw.f17642k));
                    } else if (i8 > 0) {
                        arrayList.add(valueOf2);
                    }
                    int i10 = (i6 / 100) % 10;
                    if (i10 > 0) {
                        c6 = 1;
                        arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i10, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                        arrayList.add(Integer.valueOf(R.raw.f17641b));
                    } else {
                        c6 = 1;
                        if (i9 > 0) {
                            arrayList.add(valueOf2);
                        }
                    }
                    int i11 = (i6 / 10) % 10;
                    if (i11 > 0) {
                        arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i11, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                        arrayList.add(valueOf);
                    } else if (i10 > 0) {
                        arrayList.add(valueOf2);
                    }
                    int i12 = i6 % 10;
                    if (i12 > 0) {
                        arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + i12, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    }
                    if (i6 > 0 && arrayList.size() > 0 && ((Number) arrayList.get(arrayList.size() - 1)).intValue() == 2131886108) {
                        arrayList.remove(arrayList.size() - 1);
                    } else if (i6 == 0) {
                        arrayList.add(valueOf2);
                    }
                    arrayList.add(Integer.valueOf(R.raw.step));
                    j.d("文字=" + i7 + "十" + i8 + "万" + i9 + "千" + i10 + "百" + i11 + "十" + i12 + "个", new Object[0]);
                    arrayList.add(Integer.valueOf(R.raw.duration));
                } else {
                    c6 = 1;
                }
                String g6 = com.bxkj.student.run.app.utils.i.g(j6);
                g0.m(g6);
                String[] strArr2 = (String[]) u.m5(g6, new String[]{":"}, false, 0, 6, null).toArray(new String[0]);
                int parseInt = Integer.parseInt(strArr2[0]);
                if (parseInt > 0) {
                    arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + parseInt, ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                    arrayList.add(Integer.valueOf(R.raw.hour));
                }
                arrayList.add(Integer.valueOf(mContext.getResources().getIdentifier("num_" + Integer.parseInt(strArr2[c6]), ResIdentify.RES_TYPE_RAW, mContext.getApplicationInfo().packageName)));
                arrayList.add(Integer.valueOf(R.raw.minute));
                d0.e().l(mContext, arrayList);
            }
        }

        public final void b(@NotNull Context mContext, @NotNull int... raw) {
            g0.p(mContext, "mContext");
            g0.p(raw, "raw");
            d0.e().l(mContext, n.bz(raw));
        }
    }
}
