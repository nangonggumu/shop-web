package utils.log;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @Description:
 * @Author zhangqiang
 * @Date Created by 2018/7/11 on 上午10:48.
 */
public class TraceIDUtils {

    /**
     *
     * @Description:日志添加traceId用uuid
     * @author      zhangqaing
     * @param       []
     * @return      void
     * @date        2018/7/11 上午11:01
     */
    public static void addTraceID() {
        MDC.put(Constant.TRACE_ID, StringUtils.join("[", UUID.randomUUID().toString(), "]"));
    }

    /**
     *
     * @Description:日志添加请求uri
     * @author      zhangqaing
     * @param       [request]
     * @return      void
     * @date        2018/7/11 上午11:05
     */
    public static void addURI(HttpServletRequest request) {
        MDC.put(Constant.LOG_MDC_KEY, StringUtils.join("[", request.getMethod(), "][", request.getRequestURI(), "]"));
    }

    /**
     *
     * @Description:日志添加traceID用传入的traceId
     * @author      zhangqaing
     * @param       [traceId]
     * @return      void
     * @date        2018/7/11 上午11:02
     */
    public static void addTraceID(String traceId) {
        MDC.put(Constant.TRACE_ID, StringUtils.join("[", traceId, "]"));
    }

    /**
     *
     * @Description:日志移除traceID用传入的traceId
     * @author      zhangqaing
     * @return      void
     * @date        2018/7/11 上午11:02
     */
    public static void remaveTraceID() {
        MDC.remove(Constant.TRACE_ID);
    }

    /**
     *
     * @Description:日志移除请求uri
     * @author      zhangqaing
     * @return      void
     * @date        2018/7/11 上午11:05
     */
    public static void remaveURI(HttpServletRequest request) {
        MDC.remove(Constant.LOG_MDC_KEY);
    }

}
