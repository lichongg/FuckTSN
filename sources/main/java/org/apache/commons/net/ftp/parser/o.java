package org.apache.commons.net.ftp.parser;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class o extends org.apache.commons.net.ftp.g {

    /* renamed from: c, reason: collision with root package name */
    private Pattern f50776c = null;

    /* renamed from: d, reason: collision with root package name */
    private MatchResult f50777d = null;

    /* renamed from: e, reason: collision with root package name */
    protected Matcher f50778e = null;

    public o(String str) {
        e(str, 0);
    }

    public boolean i(String str) {
        this.f50777d = null;
        Matcher matcher = this.f50776c.matcher(str);
        this.f50778e = matcher;
        if (matcher.matches()) {
            this.f50777d = this.f50778e.toMatchResult();
        }
        return this.f50777d != null;
    }

    public boolean j(String str) {
        e(str, 0);
        return true;
    }

    public int f() {
        MatchResult matchResult = this.f50777d;
        if (matchResult == null) {
            return 0;
        }
        return matchResult.groupCount();
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 1; i6 <= this.f50777d.groupCount(); i6++) {
            sb.append(i6);
            sb.append(") ");
            sb.append(this.f50777d.group(i6));
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    public String h(int i6) {
        MatchResult matchResult = this.f50777d;
        if (matchResult == null) {
            return null;
        }
        return matchResult.group(i6);
    }

    private void e(String str, int i6) {
        try {
            this.f50776c = Pattern.compile(str, i6);
        } catch (PatternSyntaxException unused) {
            throw new IllegalArgumentException("Unparseable regex supplied: " + str);
        }
    }

    public boolean k(String str, int i6) {
        e(str, i6);
        return true;
    }

    public o(String str, int i6) {
        e(str, i6);
    }
}
