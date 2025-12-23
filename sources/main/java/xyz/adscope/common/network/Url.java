package xyz.adscope.common.network;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import xyz.adscope.common.network.Params;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Url {

    /* renamed from: a, reason: collision with root package name */
    private final String f56542a;

    /* renamed from: b, reason: collision with root package name */
    private final String f56543b;

    /* renamed from: c, reason: collision with root package name */
    private final int f56544c;

    /* renamed from: d, reason: collision with root package name */
    private final String f56545d;

    /* renamed from: e, reason: collision with root package name */
    private final String f56546e;

    /* renamed from: f, reason: collision with root package name */
    private final String f56547f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.Url$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f56548a;

        /* renamed from: b, reason: collision with root package name */
        private String f56549b;

        /* renamed from: c, reason: collision with root package name */
        private int f56550c;

        /* renamed from: d, reason: collision with root package name */
        private List<String> f56551d;

        /* renamed from: e, reason: collision with root package name */
        private Params.Builder f56552e;

        /* renamed from: f, reason: collision with root package name */
        private String f56553f;

        /* synthetic */ Builder(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        public Builder addPath(int i6) {
            return addPath(Integer.toString(i6));
        }

        public Builder addQuery(String str, int i6) {
            return addQuery(str, Integer.toString(i6));
        }

        public Builder setQuery(String str) {
            this.f56552e = Url.d(str).builder();
            return this;
        }

        private Builder(String str) {
            URI create = URI.create(str);
            this.f56548a = create.getScheme();
            this.f56549b = create.getHost();
            this.f56550c = Url.b(create.getPort());
            this.f56551d = Url.c(create.getPath());
            this.f56552e = Url.d(create.getQuery()).builder();
            this.f56553f = create.getFragment();
        }

        public Builder addPath(long j6) {
            return addPath(Long.toString(j6));
        }

        public Builder addQuery(String str, long j6) {
            return addQuery(str, Long.toString(j6));
        }

        public Url build() {
            return new Url(this, null);
        }

        public Builder clearPath() {
            this.f56551d.clear();
            return this;
        }

        public Builder clearQuery() {
            this.f56552e.clear();
            return this;
        }

        public Builder removeQuery(String str) {
            this.f56552e.remove(str);
            return this;
        }

        public Builder setFragment(String str) {
            this.f56553f = str;
            return this;
        }

        public Builder setHost(String str) {
            this.f56549b = str;
            return this;
        }

        public Builder setPort(int i6) {
            this.f56550c = i6;
            return this;
        }

        public Builder setQuery(Params params) {
            this.f56552e = params.builder();
            return this;
        }

        public Builder setScheme(String str) {
            this.f56548a = str;
            return this;
        }

        public Builder addPath(boolean z5) {
            return addPath(Boolean.toString(z5));
        }

        public Builder addQuery(String str, boolean z5) {
            return addQuery(str, Boolean.toString(z5));
        }

        public Builder setPath(String str) {
            this.f56551d = Url.c(str);
            return this;
        }

        public Builder addPath(char c6) {
            return addPath(String.valueOf(c6));
        }

        public Builder addQuery(String str, char c6) {
            return addQuery(str, String.valueOf(c6));
        }

        public Builder addPath(double d6) {
            return addPath(Double.toString(d6));
        }

        public Builder addQuery(String str, double d6) {
            return addQuery(str, Double.toString(d6));
        }

        public Builder addPath(float f6) {
            return addPath(Float.toString(f6));
        }

        public Builder addQuery(String str, float f6) {
            return addQuery(str, Float.toString(f6));
        }

        public Builder addPath(String str) {
            this.f56551d.add(str);
            return this;
        }

        public Builder addQuery(String str, short s5) {
            return addQuery(str, Integer.toString(s5));
        }

        public Builder addQuery(String str, String str2) {
            this.f56552e.add(str, str2);
            return this;
        }

        public Builder addQuery(String str, List<String> list) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                addQuery(str, it.next());
            }
            return this;
        }

        public Builder addQuery(Params params) {
            for (Map.Entry<String, List<Object>> entry : params.entrySet()) {
                String key = entry.getKey();
                for (Object obj : entry.getValue()) {
                    if (obj instanceof CharSequence) {
                        addQuery(key, obj.toString());
                    }
                }
            }
            return this;
        }
    }

    /* synthetic */ Url(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i6) {
        if (i6 > 0) {
            return i6;
        }
        return 80;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> c(String str) {
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(str)) {
            while (str.startsWith("/")) {
                str = str.substring(1);
            }
            while (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            Collections.addAll(linkedList, str.split("/"));
        }
        return linkedList;
    }

    public String toString() {
        return toString(false);
    }

    private Url(Builder builder) {
        this.f56542a = builder.f56548a;
        this.f56543b = builder.f56549b;
        this.f56544c = builder.f56550c;
        this.f56545d = a((List<String>) builder.f56551d, false);
        this.f56546e = builder.f56552e.build().toString(false);
        this.f56547f = builder.f56553f;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str, null);
    }

    public List<String> copyPath() {
        return c(this.f56545d);
    }

    public String getFragment() {
        return this.f56547f;
    }

    public String getHost() {
        return this.f56543b;
    }

    public Params getParams() {
        return d(this.f56546e);
    }

    public String getPath() {
        return this.f56545d;
    }

    public int getPort() {
        return this.f56544c;
    }

    public String getQuery() {
        return this.f56546e;
    }

    public String getScheme() {
        return this.f56542a;
    }

    public String toString(boolean z5) {
        return this.f56542a + "://" + this.f56543b + c(this.f56544c) + a(c(this.f56545d), z5) + a(d(this.f56546e), z5) + a(this.f56547f, z5);
    }

    private static String a(List<String> list, boolean z5) {
        if (list.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append("/");
            if (z5) {
                str = Uri.encode(str);
            }
            sb.append(str);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Params d(String str) {
        Params.Builder newBuilder = Params.newBuilder();
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("?")) {
                str = str.substring(1);
            }
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                String str3 = "";
                if (indexOf > 0) {
                    String substring = str2.substring(0, indexOf);
                    if (indexOf < str2.length() - 1) {
                        str3 = str2.substring(indexOf + 1);
                    }
                    str2 = substring;
                }
                newBuilder.add(str2, str3);
            }
        }
        return newBuilder.build();
    }

    public Builder builder() {
        return newBuilder(toString());
    }

    @Deprecated
    public Params copyQuery() {
        return getParams();
    }

    public Url location(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (URLUtil.isNetworkUrl(str)) {
            return newBuilder(str).build();
        }
        URI create = URI.create(str);
        if (str.startsWith("/")) {
            return builder().setPath(create.getPath()).setQuery(create.getQuery()).setFragment(create.getFragment()).build();
        }
        if (str.contains("../")) {
            List<String> c6 = c(getPath());
            List<String> c7 = c(create.getPath());
            List<String> subList = c7.subList(c7.lastIndexOf("..") + 1, c7.size());
            if (!c6.isEmpty()) {
                List<String> subList2 = c6.subList(0, (c6.size() - r3) - 2);
                subList2.addAll(subList);
                return builder().setPath(TextUtils.join("/", subList2)).setQuery(create.getQuery()).setFragment(create.getFragment()).build();
            }
            return builder().setPath(TextUtils.join("/", subList)).setQuery(create.getQuery()).setFragment(create.getFragment()).build();
        }
        List<String> c8 = c(getPath());
        c8.addAll(c(create.getPath()));
        return builder().setPath(TextUtils.join("/", c8)).setQuery(create.getQuery()).setFragment(create.getFragment()).build();
    }

    private static String c(int i6) {
        return (i6 <= 0 || i6 == 80) ? "" : String.format(Locale.getDefault(), ":%d", Integer.valueOf(i6));
    }

    private static String a(Params params, boolean z5) {
        String params2 = params.toString(z5);
        return TextUtils.isEmpty(params2) ? "" : String.format("?%s", params2);
    }

    private static String a(String str, boolean z5) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (z5) {
            str = Uri.encode(str);
        }
        return String.format("#%s", str);
    }
}
