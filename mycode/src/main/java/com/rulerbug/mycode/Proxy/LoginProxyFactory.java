package com.rulerbug.mycode.Proxy;


import android.widget.BaseAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class LoginProxyFactory {
    public static <T> Object getProxy(final T t) {
        Object obj = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (isNeedLogin()) {
                    Object o = method.invoke(t, args);
                    return o;
                } else {
                    LoginUtils.logint();
                    return null;
                }

            }
        });
        return obj;
    }

    public static boolean isNeedLogin() {
        return false;
    }
}
