package b.a.a.w;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* compiled from: UnsafeAllocator.java */
/* loaded from: classes.dex */
public abstract class k {

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class a extends k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f88a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f89b;

        a(Method method, Object obj) {
            this.f88a = method;
            this.f89b = obj;
        }

        @Override // b.a.a.w.k
        public <T> T c(Class<T> cls) {
            k.a(cls);
            return (T) this.f88a.invoke(this.f89b, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class b extends k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f90a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f91b;

        b(Method method, int i) {
            this.f90a = method;
            this.f91b = i;
        }

        @Override // b.a.a.w.k
        public <T> T c(Class<T> cls) {
            k.a(cls);
            return (T) this.f90a.invoke(null, cls, Integer.valueOf(this.f91b));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class c extends k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f92a;

        c(Method method) {
            this.f92a = method;
        }

        @Override // b.a.a.w.k
        public <T> T c(Class<T> cls) {
            k.a(cls);
            return (T) this.f92a.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class d extends k {
        d() {
        }

        @Override // b.a.a.w.k
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers)) {
            if (Modifier.isAbstract(modifiers)) {
                throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
            }
            return;
        }
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
    }

    public static k b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    return new d();
                }
            } catch (Exception unused3) {
                Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new c(declaredMethod3);
            }
        }
    }

    public abstract <T> T c(Class<T> cls);
}
