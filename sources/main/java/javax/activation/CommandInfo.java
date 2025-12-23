package javax.activation;

import java.beans.Beans;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class CommandInfo {
    private String className;
    private String verb;

    public String getCommandClass() {
        return this.className;
    }

    public String getCommandName() {
        return this.verb;
    }

    public Object getCommandObject(DataHandler dataHandler, ClassLoader classLoader) throws IOException, ClassNotFoundException {
        InputStream inputStream;
        Object instantiate = Beans.instantiate(classLoader, this.className);
        if (instantiate != null) {
            if (instantiate instanceof CommandObject) {
                ((CommandObject) instantiate).setCommandContext(this.verb, dataHandler);
                return instantiate;
            }
            if ((instantiate instanceof Externalizable) && dataHandler != null && (inputStream = dataHandler.getInputStream()) != null) {
                ((Externalizable) instantiate).readExternal(new ObjectInputStream(inputStream));
            }
        }
        return instantiate;
    }

    public CommandInfo(String str, String str2) {
        this.verb = str;
        this.className = str2;
    }
}
