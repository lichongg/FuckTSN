package xyz.adscope.common.network;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Params {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, List<Object>> f56510a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.Params$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, List<Object>> f56511a;

        /* synthetic */ Builder(Map map, AnonymousClass1 anonymousClass1) {
            this((Map<String, List<Object>>) map);
        }

        public Builder add(String str, int i6) {
            return add(str, Integer.toString(i6));
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (!this.f56511a.containsKey(str)) {
                    this.f56511a.put(str, new ArrayList(1));
                }
                if (obj == null) {
                    obj = "";
                }
                if (obj instanceof File) {
                    obj = new FileBinary((File) obj);
                }
                this.f56511a.get(str).add(obj);
            }
            return this;
        }

        public Builder add(String str, long j6) {
            return add(str, Long.toString(j6));
        }

        public Params build() {
            return new Params(this, null);
        }

        public Builder clear() {
            this.f56511a.clear();
            return this;
        }

        public Builder remove(String str) {
            this.f56511a.remove(str);
            return this;
        }

        private Builder() {
            this.f56511a = new LinkedHashMap();
        }

        public Builder add(String str, boolean z5) {
            return add(str, Boolean.toString(z5));
        }

        public Builder binaries(String str, List<Binary> list) {
            Iterator<Binary> it = list.iterator();
            while (it.hasNext()) {
                binary(str, it.next());
            }
            return this;
        }

        public Builder binary(String str, Binary binary) {
            return a(str, binary);
        }

        public Builder file(String str, File file) {
            return a(str, file);
        }

        public Builder files(String str, List<File> list) {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                a(str, it.next());
            }
            return this;
        }

        public Builder set(Params params) {
            return clear().add(params);
        }

        public Builder add(String str, char c6) {
            return add(str, String.valueOf(c6));
        }

        private Builder(Map<String, List<Object>> map) {
            this.f56511a = map;
        }

        public Builder add(String str, double d6) {
            return add(str, Double.toString(d6));
        }

        public Builder add(String str, float f6) {
            return add(str, Float.toString(f6));
        }

        public Builder add(String str, short s5) {
            return add(str, Integer.toString(s5));
        }

        public Builder add(String str, CharSequence charSequence) {
            return a(str, charSequence);
        }

        public Builder add(String str, List<String> list) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                add(str, it.next());
            }
            return this;
        }

        public Builder add(Params params) {
            for (Map.Entry<String, List<Object>> entry : params.entrySet()) {
                String key = entry.getKey();
                Iterator<Object> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    a(key, it.next());
                }
            }
            return this;
        }

        public Builder add(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                add(entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    /* synthetic */ Params(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String toString() {
        return toString(false);
    }

    private Params(Builder builder) {
        this.f56510a = builder.f56511a;
    }

    public static Builder newBuilder() {
        return new Builder((AnonymousClass1) null);
    }

    public Builder builder() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<Object>> entry : this.f56510a.entrySet()) {
            linkedHashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        return new Builder(linkedHashMap, null);
    }

    public boolean containsKey(String str) {
        return this.f56510a.containsKey(str);
    }

    public Set<Map.Entry<String, List<Object>>> entrySet() {
        return this.f56510a.entrySet();
    }

    public List<Object> get(String str) {
        return this.f56510a.get(str);
    }

    public Object getFirst(String str) {
        List<Object> list = this.f56510a.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return this.f56510a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f56510a.keySet();
    }

    public String toString(boolean z5) {
        StringBuilder sb = new StringBuilder();
        for (String str : keySet()) {
            for (Object obj : get(str)) {
                if (obj instanceof CharSequence) {
                    String encode = z5 ? Uri.encode(obj.toString()) : obj.toString();
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                    sb.append(str);
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(encode);
                }
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public boolean hasBinary() {
        Iterator<Map.Entry<String, List<Object>>> it = entrySet().iterator();
        while (it.hasNext()) {
            List<Object> value = it.next().getValue();
            if (value.size() > 0) {
                Iterator<Object> it2 = value.iterator();
                while (it2.hasNext()) {
                    if (it2.next() instanceof Binary) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public FormBody toFormBody() {
        return FormBody.newBuilder().params(this).build();
    }

    public UrlBody toUrlBody() {
        return UrlBody.newBuilder().params(this).build();
    }
}
