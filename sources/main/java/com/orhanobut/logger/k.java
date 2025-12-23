package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class k implements m {

    /* renamed from: c, reason: collision with root package name */
    private static final int f36490c = 2;

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal<String> f36491a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private final List<g> f36492b = new ArrayList();

    private synchronized void p(int i6, @Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        n.a(str);
        c(i6, o(), n(str, objArr), th);
    }

    @Override // com.orhanobut.logger.m
    public void a(@NonNull String str, @Nullable Object... objArr) {
        p(7, null, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public synchronized void c(int i6, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        if (th != null && str2 != null) {
            try {
                str2 = str2 + " : " + n.c(th);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (th != null && str2 == null) {
            str2 = n.c(th);
        }
        if (n.d(str2)) {
            str2 = "Empty/NULL log message";
        }
        for (g gVar : this.f36492b) {
            if (gVar.b(i6, str)) {
                gVar.a(i6, str, str2);
            }
        }
    }

    @Override // com.orhanobut.logger.m
    public void d(@Nullable Object obj) {
        p(3, null, n.f(obj), new Object[0]);
    }

    @Override // com.orhanobut.logger.m
    public void e(@NonNull String str, @Nullable Object... objArr) {
        p(3, null, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public void g(@NonNull String str, @Nullable Object... objArr) {
        j(null, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public void j(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        p(6, th, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public void l(@NonNull String str, @Nullable Object... objArr) {
        p(2, null, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public void m(@NonNull String str, @Nullable Object... objArr) {
        p(5, null, str, objArr);
    }

    @NonNull
    private String n(@NonNull String str, @Nullable Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    @Nullable
    private String o() {
        String str = this.f36491a.get();
        if (str == null) {
            return null;
        }
        this.f36491a.remove();
        return str;
    }

    @Override // com.orhanobut.logger.m
    public void b(@Nullable String str) {
        if (n.d(str)) {
            d("Empty/Null json content");
            return;
        }
        try {
            String trim = str.trim();
            if (trim.startsWith("{")) {
                d(new JSONObject(trim).toString(2));
            } else if (trim.startsWith("[")) {
                d(new JSONArray(trim).toString(2));
            } else {
                g("Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            g("Invalid Json", new Object[0]);
        }
    }

    @Override // com.orhanobut.logger.m
    public void d(@NonNull String str, @Nullable Object... objArr) {
        p(4, null, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public m f(String str) {
        if (str != null) {
            this.f36491a.set(str);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.orhanobut.logger.m
    public void i(@NonNull g gVar) {
        this.f36492b.add(n.a(gVar));
    }

    @Override // com.orhanobut.logger.m
    public void k() {
        this.f36492b.clear();
    }

    k() {
    }

    @Override // com.orhanobut.logger.m
    public void h(@Nullable String str) {
        if (n.d(str)) {
            d("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            d(streamResult.getWriter().toString().replaceFirst(">", ">\n"));
        } catch (TransformerException unused) {
            g("Invalid xml", new Object[0]);
        }
    }
}
