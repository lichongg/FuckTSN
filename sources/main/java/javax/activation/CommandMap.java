package javax.activation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class CommandMap {
    private static CommandMap defaultCommandMap;

    public abstract DataContentHandler createDataContentHandler(String str);

    public DataContentHandler createDataContentHandler(String str, DataSource dataSource) {
        return createDataContentHandler(str);
    }

    public abstract CommandInfo[] getAllCommands(String str);

    public CommandInfo[] getAllCommands(String str, DataSource dataSource) {
        return getAllCommands(str);
    }

    public abstract CommandInfo getCommand(String str, String str2);

    public CommandInfo getCommand(String str, String str2, DataSource dataSource) {
        return getCommand(str, str2);
    }

    public String[] getMimeTypes() {
        return null;
    }

    public abstract CommandInfo[] getPreferredCommands(String str);

    public CommandInfo[] getPreferredCommands(String str, DataSource dataSource) {
        return getPreferredCommands(str);
    }

    public static CommandMap getDefaultCommandMap() {
        if (defaultCommandMap == null) {
            defaultCommandMap = new MailcapCommandMap();
        }
        return defaultCommandMap;
    }

    public static void setDefaultCommandMap(CommandMap commandMap) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            try {
                securityManager.checkSetFactory();
            } catch (SecurityException e6) {
                if (CommandMap.class.getClassLoader() != commandMap.getClass().getClassLoader()) {
                    throw e6;
                }
            }
        }
        defaultCommandMap = commandMap;
    }
}
