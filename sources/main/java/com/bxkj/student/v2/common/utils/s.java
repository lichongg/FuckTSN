package com.bxkj.student.v2.common.utils;

import com.bxkj.student.R;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20923a = a.f20930a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f20924b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f20925c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f20926d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f20927e = 2;

    /* renamed from: f, reason: collision with root package name */
    public static final int f20928f = 5;

    /* renamed from: g, reason: collision with root package name */
    public static final int f20929g = 6;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f20930a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final int f20931b = -1;

        /* renamed from: c, reason: collision with root package name */
        public static final int f20932c = 0;

        /* renamed from: d, reason: collision with root package name */
        public static final int f20933d = 1;

        /* renamed from: e, reason: collision with root package name */
        public static final int f20934e = 2;

        /* renamed from: f, reason: collision with root package name */
        public static final int f20935f = 5;

        /* renamed from: g, reason: collision with root package name */
        public static final int f20936g = 6;

        public final int a(@Nullable CharSequence charSequence) {
            return g0.g(charSequence, "早操跑") ? R.color.v3_tab_color1 : (!g0.g(charSequence, "阳光跑") && g0.g(charSequence, "自由跑")) ? R.color.v3_tab_color3 : R.color.v3_tab_color2;
        }

        public final int b(int i6) {
            return i6 != 0 ? (i6 == 1 || i6 != 2) ? R.mipmap.v3_icon_record_sunshine : R.mipmap.v3_icon_record_morning : R.mipmap.v3_icon_record_free;
        }

        public final int c(@Nullable CharSequence charSequence) {
            if (g0.g(charSequence, "早操跑")) {
                return 2;
            }
            if (g0.g(charSequence, "阳光跑")) {
                return 1;
            }
            if (g0.g(charSequence, "自由跑")) {
                return 0;
            }
            if (g0.g(charSequence, "场地锻炼")) {
                return 5;
            }
            return g0.g(charSequence, "定向越野") ? 6 : 1;
        }

        @NotNull
        public final String d(int i6) {
            return i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 5 ? i6 != 6 ? "非法进入 " : "定向越野" : "场地锻炼" : "早操跑" : "阳光跑" : "自由跑";
        }

        public final int e(@Nullable CharSequence charSequence) {
            return g0.g(charSequence, "早操跑") ? R.mipmap.v3_sports_location_description1 : (!g0.g(charSequence, "阳光跑") && g0.g(charSequence, "自由跑")) ? R.mipmap.v3_sports_location_description3 : R.mipmap.v3_sports_location_description2;
        }

        public final int f(@Nullable CharSequence charSequence) {
            return g0.g(charSequence, "早操跑") ? R.mipmap.v3_sports_location_permission1 : (!g0.g(charSequence, "阳光跑") && g0.g(charSequence, "自由跑")) ? R.mipmap.v3_sports_location_permission3 : R.mipmap.v3_sports_location_permission2;
        }

        public final int g(@Nullable CharSequence charSequence) {
            return g0.g(charSequence, "早操跑") ? R.mipmap.v3_sports_location_start1 : (!g0.g(charSequence, "阳光跑") && g0.g(charSequence, "自由跑")) ? R.mipmap.v3_sports_location_start3 : R.mipmap.v3_sports_location_start2;
        }

        public final int h(@Nullable CharSequence charSequence) {
            return g0.g(charSequence, "早操跑") ? R.mipmap.v3_sports_location_mark1 : (!g0.g(charSequence, "阳光跑") && g0.g(charSequence, "自由跑")) ? R.mipmap.v3_sports_location_mark3 : R.mipmap.v3_sports_location_mark2;
        }

        public final int i(@Nullable CharSequence charSequence) {
            return g0.g(charSequence, "早操跑") ? R.color.v3_location_color1 : (!g0.g(charSequence, "阳光跑") && g0.g(charSequence, "自由跑")) ? R.color.v3_location_color3 : R.color.v3_location_color2;
        }

        private a() {
        }
    }
}
