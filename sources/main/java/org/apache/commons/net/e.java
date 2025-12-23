package org.apache.commons.net;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e implements f {

    /* renamed from: a, reason: collision with root package name */
    private final PrintWriter f50554a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f50555b;

    /* renamed from: c, reason: collision with root package name */
    private final char f50556c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f50557d;

    public e(PrintStream printStream) {
        this(new PrintWriter(printStream));
    }

    public e(PrintStream printStream, boolean z5) {
        this(new PrintWriter(printStream), z5);
    }

    private String e(String str) {
        if (this.f50556c == 0) {
            return str;
        }
        int indexOf = str.indexOf(g.f50795q);
        if (indexOf <= 0) {
            return str;
        }
        return str.substring(0, indexOf) + this.f50556c + str.substring(indexOf);
    }

    @Override // org.apache.commons.net.f
    public void b(ProtocolCommandEvent protocolCommandEvent) {
        if (this.f50557d) {
            this.f50554a.print("< ");
        }
        this.f50554a.print(protocolCommandEvent.getMessage());
        this.f50554a.flush();
    }

    @Override // org.apache.commons.net.f
    public void d(ProtocolCommandEvent protocolCommandEvent) {
        if (this.f50557d) {
            this.f50554a.print("> ");
        }
        if (this.f50555b) {
            String command = protocolCommandEvent.getCommand();
            if ("PASS".equalsIgnoreCase(command) || "USER".equalsIgnoreCase(command)) {
                this.f50554a.print(command);
                this.f50554a.println(" *******");
            } else if ("LOGIN".equalsIgnoreCase(command)) {
                String message = protocolCommandEvent.getMessage();
                this.f50554a.print(message.substring(0, message.indexOf("LOGIN") + 5));
                this.f50554a.println(" *******");
            } else {
                this.f50554a.print(e(protocolCommandEvent.getMessage()));
            }
        } else {
            this.f50554a.print(e(protocolCommandEvent.getMessage()));
        }
        this.f50554a.flush();
    }

    public e(PrintStream printStream, boolean z5, char c6) {
        this(new PrintWriter(printStream), z5, c6);
    }

    public e(PrintStream printStream, boolean z5, char c6, boolean z6) {
        this(new PrintWriter(printStream), z5, c6, z6);
    }

    public e(PrintWriter printWriter) {
        this(printWriter, false);
    }

    public e(PrintWriter printWriter, boolean z5) {
        this(printWriter, z5, (char) 0);
    }

    public e(PrintWriter printWriter, boolean z5, char c6) {
        this(printWriter, z5, c6, false);
    }

    public e(PrintWriter printWriter, boolean z5, char c6, boolean z6) {
        this.f50554a = printWriter;
        this.f50555b = z5;
        this.f50556c = c6;
        this.f50557d = z6;
    }
}
