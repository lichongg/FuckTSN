package org.junit.runner.notification;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Failure implements Serializable {
    private static final long serialVersionUID = 1;
    private final Description fDescription;
    private final Throwable fThrownException;

    public Description getDescription() {
        return this.fDescription;
    }

    public Throwable getException() {
        return this.fThrownException;
    }

    public String getTestHeader() {
        return this.fDescription.getDisplayName();
    }

    public String getTrace() {
        StringWriter stringWriter = new StringWriter();
        getException().printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public String toString() {
        return getTestHeader() + ": " + this.fThrownException.getMessage();
    }

    public Failure(Description description, Throwable th) {
        this.fThrownException = th;
        this.fDescription = description;
    }

    public String getMessage() {
        return getException().getMessage();
    }
}
