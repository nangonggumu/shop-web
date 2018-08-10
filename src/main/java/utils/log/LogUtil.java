package utils.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具类
 * Created by wangjian on 2017/11/10.
 */
public class LogUtil {

    private static StackTraceElement findCaller() {

        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        if (null == callStack) return null;

        StackTraceElement caller = null;
        String logClassName = LogUtil.class.getName();
        boolean isEachLogClass = false;
        for (StackTraceElement s : callStack) {
            if (logClassName.equals(s.getClassName())) {
                isEachLogClass = true;
            }
            if (isEachLogClass) {
                if (!logClassName.equals(s.getClassName())) {
                    caller = s;
                    break;
                }
            }
        }

        return caller;
    }

    private static Logger logger() {
        StackTraceElement caller = findCaller();
        if (caller == null)
            return LoggerFactory.getLogger(LogUtil.class);
        Logger logger = LoggerFactory.getLogger(caller.getClassName() + "(" + caller.getLineNumber() + ")");

        return logger;
    }

    public static void debug(String format, Object... arguments) {
        logger().debug(format, arguments);
    }

    public static void info(String format, Object... arguments) {
        logger().info(format, arguments);
    }

    public static void error(String msg, Throwable e) {
        logger().error(msg, e);
    }

    public static void error(String format, Object... arguments) {
        logger().error(format, arguments);
    }

    public static void warn(String format, Object... arguments) {
        logger().warn(format, arguments);
    }

}
