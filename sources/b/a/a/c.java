package b.a.a;

import java.lang.reflect.Field;
import java.util.Locale;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* loaded from: classes.dex */
public abstract class c implements b.a.a.d {

    /* renamed from: a  reason: collision with root package name */
    public static final c f27a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f28b;
    public static final c c;
    public static final c d;
    public static final c e;
    private static final /* synthetic */ c[] f;

    /* compiled from: FieldNamingPolicy.java */
    /* loaded from: classes.dex */
    enum a extends c {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // b.a.a.d
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f27a = aVar;
        c cVar = new c("UPPER_CAMEL_CASE", 1) { // from class: b.a.a.c.b
            @Override // b.a.a.d
            public String a(Field field) {
                return c.d(field.getName());
            }
        };
        f28b = cVar;
        c cVar2 = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: b.a.a.c.c
            @Override // b.a.a.d
            public String a(Field field) {
                return c.d(c.c(field.getName(), " "));
            }
        };
        c = cVar2;
        c cVar3 = new c("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: b.a.a.c.d
            @Override // b.a.a.d
            public String a(Field field) {
                return c.c(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        d = cVar3;
        c cVar4 = new c("LOWER_CASE_WITH_DASHES", 4) { // from class: b.a.a.c.e
            @Override // b.a.a.d
            public String a(Field field) {
                return c.c(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        e = cVar4;
        f = new c[]{aVar, cVar, cVar2, cVar3, cVar4};
    }

    private c(String str, int i) {
    }

    private static String b(char c2, String str, int i) {
        if (i < str.length()) {
            return c2 + str.substring(i);
        }
        return String.valueOf(c2);
    }

    static String c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String d(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i < length - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i++;
            charAt = str.charAt(i);
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb.append(b(Character.toUpperCase(charAt), str, i + 1));
        return sb.toString();
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f.clone();
    }

    /* synthetic */ c(String str, int i, a aVar) {
        this(str, i);
    }
}
