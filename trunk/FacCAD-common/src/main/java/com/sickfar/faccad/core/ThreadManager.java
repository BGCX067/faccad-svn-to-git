package com.sickfar.faccad.core;

import com.sickfar.faccad.module.AbstractModule;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
public final class ThreadManager {

    private static ThreadManager instance = new ThreadManager();

    private ThreadManager() {
    }

    public static ThreadManager getInstance() {
        return instance;
    }

    private Map<Object, Thread> threads = new HashMap<>();

    private Map<String, ThreadGroup> groups = new HashMap<>();

    {
        groups.put("MODULE", new ThreadGroup("Modules group"));
        groups.put("CORE", new ThreadGroup("Core group"));
        groups.put("COMMON", new ThreadGroup("Common group"));
    }

    public Thread registerRunnable(Object object, Runnable runnable) {
        if (!threads.containsKey(object)) threads.put(object, prepareThread(object, runnable));
        return threads.get(object);
    }

    public Thread getThread(Object object) {
        return threads.get(object);
    }

    public Thread registerThread(Object object, Thread thread) {
        if (!threads.containsKey(object)) threads.put(object, thread);
        return threads.get(object);
    }

    public ThreadGroup getThreadGroup(String name) {
        ThreadGroup group = groups.get(name.toUpperCase());
        if (group == null)
            group = groups.get("COMMON");
        return group;
    }

    public ThreadGroup calculateGroup(Object object) {
        if (object instanceof AbstractModule)
            return getThreadGroup("AbstractModule");
        else if (object instanceof ICore)
            return getThreadGroup("Core");
        else return getThreadGroup("Common");
    }

    public Thread prepareThread(Object object, Runnable runnable) {
        ThreadGroup g = calculateGroup(object);
        Thread t = new Thread(g, runnable);
        t.setName(g.getName() + ": " + object.toString());
        return t;
    }


}
