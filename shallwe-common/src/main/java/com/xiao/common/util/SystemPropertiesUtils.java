package com.xiao.common.util;

/**
 * 系统属性工具
 * <p>
 *
 * @author： jianjun.xiao
 * @e-mail： xiaocen65535@163.com
 * @date： 2021/8/31 14:28
 */
public class SystemPropertiesUtils {

    public static final String JAVA_VERSION = "java.version";
    public static final String JAVA_VENDOR = "java.vendor";
    public static final String JAVA_VENDOR_URL = "java.vendor.url";
    public static final String JAVA_HOME = "java.home";
    public static final String JAVA_VM_SPECIFICATION_VERSION = "java.vm.specification.version";
    public static final String JAVA_VM_SPECIFICATION_VENDOR = "java.vm.specification.vendor";
    public static final String JAVA_VM_SPECIFICATION_NAME = "java.vm.specification.name";
    public static final String JAVA_VM_VERSION = "java.vm.version";
    public static final String JAVA_VM_VENDOR = "java.vm.vendor";
    public static final String JAVA_VM_NAME = "java.vm.name";
    public static final String JAVA_SPECIFICATION_VERSION = "java.specification.version";
    public static final String JAVA_SPECIFICATION_VENDOR = "java.specification.vendor";
    public static final String JAVA_SPECIFICATION_NAME = "java.specification.name";
    public static final String JAVA_CLASS_VERSION = "java.class.version";
    public static final String JAVA_CLASS_PATH = "java.class.path";
    public static final String JAVA_LIBRARY_PATH = "java.library.path";
    public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
    public static final String JAVA_COMPILER = "java.compiler";
    public static final String JAVA_EXT_DIRS = "java.ext.dirs";
    public static final String OS_NAME = "os.name";
    public static final String OS_ARCH = "os.arch";
    public static final String OS_VERSION = "os.version";
    public static final String FILE_SEPARATOR = "file.separator";
    public static final String PATH_SEPARATOR = "path.separator";
    public static final String LINE_SEPARATOR = "line.separator";
    public static final String USER_NAME = "user.name";
    public static final String USER_HOME = "user.home";
    public static final String USER_DIR = "user.dir";

    public static String getUserHome() {
        return System.getProperty(USER_HOME);
    }

    public static String getUserDir() {
        return System.getProperty(USER_DIR);
    }

    public static String getJavaIoTmpdir() {
        return System.getProperty(JAVA_IO_TMPDIR);
    }

    public static void main(String[] args) {
        System.out.println(getJavaIoTmpdir());
        System.out.println(getUserDir());
        System.out.println(getUserHome());
    }

}
