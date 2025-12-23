package xyz.adscope.common.network.cookie.db;

import java.util.Iterator;
import java.util.List;
import xyz.adscope.common.v2.persistent.db.IBaseDbHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Where {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f56608a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.cookie.db.Where$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f56609a;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder and() {
            if (this.f56609a.length() > 0) {
                this.f56609a.append(" AND ");
            }
            return this;
        }

        public Builder bracket() {
            return insert(0, "(").append(')');
        }

        public Builder or() {
            if (this.f56609a.length() > 0) {
                this.f56609a.append(" OR ");
            }
            return this;
        }

        private Builder() {
            this.f56609a = new StringBuilder();
        }

        private Builder a(CharSequence charSequence, Options options) {
            StringBuilder sb = this.f56609a;
            sb.append("\"");
            sb.append(charSequence);
            sb.append("\"");
            sb.append(options.f56611a);
            return this;
        }

        public Builder and(CharSequence charSequence, Options options, Object obj) {
            return and().add(charSequence, options, obj);
        }

        public Builder append(Object obj) {
            this.f56609a.append(obj);
            return this;
        }

        public Where build() {
            return new Where(this, null);
        }

        public <T> Builder in(CharSequence charSequence, List<T> list) {
            StringBuilder sb = this.f56609a;
            sb.append(charSequence);
            sb.append(IBaseDbHelper.CONDITION_IN);
            sb.append("(");
            StringBuilder sb2 = new StringBuilder();
            Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                sb2.append("'");
                sb2.append(it.next());
                sb2.append("'");
                while (it.hasNext()) {
                    sb2.append(", '");
                    sb2.append(it.next());
                    sb2.append("'");
                }
            }
            StringBuilder sb3 = this.f56609a;
            sb3.append((CharSequence) sb2);
            sb3.append(")");
            return this;
        }

        public Builder insert(int i6, CharSequence charSequence) {
            this.f56609a.insert(i6, charSequence);
            return this;
        }

        public Builder isNull(CharSequence charSequence) {
            StringBuilder sb = this.f56609a;
            sb.append("\"");
            sb.append(charSequence);
            sb.append("\"");
            sb.append(" IS ");
            sb.append("NULL");
            return this;
        }

        public Builder set(String str) {
            StringBuilder sb = this.f56609a;
            sb.delete(0, sb.length()).append(str);
            return this;
        }

        public Builder add(CharSequence charSequence, Options options, Object obj) {
            a(charSequence, options).append("'").append(obj).append("'");
            return this;
        }

        public Builder and(Where where) {
            return and().append(where);
        }

        public Builder andNull(CharSequence charSequence) {
            return and().isNull(charSequence);
        }

        public Builder or(CharSequence charSequence, Options options, Object obj) {
            return or().add(charSequence, options, obj);
        }

        public Builder orNull(CharSequence charSequence) {
            return or().isNull(charSequence);
        }

        public Builder or(Where where) {
            return or().append(where);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Options {
        EQUAL(" = "),
        NO_EQUAL(" != "),
        BIGGER(" > "),
        SMALLER(" < ");


        /* renamed from: a, reason: collision with root package name */
        private String f56611a;

        Options(String str) {
            this.f56611a = str;
        }
    }

    /* synthetic */ Where(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private Where(Builder builder) {
        this.f56608a = builder.f56609a;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public String toString() {
        return this.f56608a.toString();
    }
}
