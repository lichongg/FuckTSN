package io.netty.handler.codec.http;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultCookie extends io.netty.handler.codec.http.cookie.DefaultCookie implements Cookie {
    private String comment;
    private String commentUrl;
    private boolean discard;
    private Set<Integer> ports;
    private Set<Integer> unmodifiablePorts;
    private int version;

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setPorts(int... iArr) {
        if (iArr == null) {
            throw new NullPointerException("ports");
        }
        int[] iArr2 = (int[]) iArr.clone();
        if (iArr2.length == 0) {
            Set<Integer> set = Collections.EMPTY_SET;
            this.ports = set;
            this.unmodifiablePorts = set;
            return;
        }
        TreeSet treeSet = new TreeSet();
        for (int i6 : iArr2) {
            if (i6 <= 0 || i6 > 65535) {
                throw new IllegalArgumentException("port out of range: " + i6);
            }
            treeSet.add(Integer.valueOf(i6));
        }
        this.ports = treeSet;
        this.unmodifiablePorts = null;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String comment() {
        return this.comment;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String commentUrl() {
        return this.commentUrl;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public boolean isDiscard() {
        return this.discard;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public Set<Integer> ports() {
        if (this.unmodifiablePorts == null) {
            this.unmodifiablePorts = Collections.unmodifiableSet(this.ports);
        }
        return this.unmodifiablePorts;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setComment(String str) {
        this.comment = validateValue("comment", str);
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setCommentUrl(String str) {
        this.commentUrl = validateValue("commentUrl", str);
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setDiscard(boolean z5) {
        this.discard = z5;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setVersion(int i6) {
        this.version = i6;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public int version() {
        return this.version;
    }

    public DefaultCookie(String str, String str2) {
        super(str, str2);
        Set<Integer> set = Collections.EMPTY_SET;
        this.ports = set;
        this.unmodifiablePorts = set;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getComment() {
        return comment();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getCommentUrl() {
        return commentUrl();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getDomain() {
        return domain();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public long getMaxAge() {
        return maxAge();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getName() {
        return name();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getPath() {
        return path();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public Set<Integer> getPorts() {
        return ports();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getValue() {
        return value();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public int getVersion() {
        return version();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setPorts(Iterable<Integer> iterable) {
        TreeSet treeSet = new TreeSet();
        for (Integer num : iterable) {
            int intValue = num.intValue();
            if (intValue > 0 && intValue <= 65535) {
                treeSet.add(num);
            } else {
                throw new IllegalArgumentException("port out of range: " + intValue);
            }
        }
        if (treeSet.isEmpty()) {
            Set<Integer> set = Collections.EMPTY_SET;
            this.ports = set;
            this.unmodifiablePorts = set;
        } else {
            this.ports = treeSet;
            this.unmodifiablePorts = null;
        }
    }
}
