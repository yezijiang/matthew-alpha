package com.matthew.javabase.lombok;


import lombok.*;

import java.io.*;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-01 11:20
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SysUserEntity {
    private String userId;
    private String userName;
    private int age;
    private String sex;

    /**
     * 1.@NonNull该注解用在属性或构造器上，Lombok会生成一个非空的声明，可用于校验参数，能帮助避免空指针。
     * 参数User为null时产生异常：NullPointerException
     */
    public static String getName(@NonNull User user) {
        return user.getName();
    }

    /**
     * 等价@NonNull
     */
    public static String getName2(User user) {
        if (user == null) {throw new NullPointerException("user is marked non-null but is null");}
        return user.getName();
    }

    /**
     * @Cleanup这个注解用在变量前面，可以保证此变量代表的资源会被自动关闭，默认是调用资源的close()方法，
     * 如果该资源有其它关闭方法，可使用@Cleanup(“methodName”)来指定要调用的方法。
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        @Cleanup
        InputStream in = new FileInputStream(args[0]);
        @Cleanup
        OutputStream out = new FileOutputStream(args[1]);
        byte[] b = new byte[1024];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
    }



    @Getter
    class User{
        private String name;
        private String sex;
    }

}
