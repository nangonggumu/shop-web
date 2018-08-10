package utils.log;


/**
 * 常量类
 *
 * @author 王建
 * @date 2018/2/8 14:34
 */
public interface Constant {

    /**
     * 日志调用字符串
     */
    String TRACE_ID = "traceId";

    /**
     * HTTP超时时间
     */
    int HTTP_SOCKET_TIMEOUT = 6 * 60 * 1000;

    /**
     * HTTP超时错误码
     */
    int HTTP_TIMEOUT_ERRCODE = 1000;

    /**
     * HTTP最大重试次数
     */
    int HTTP_RETRY_COUNT = 5;

    /**
     * 缓存KEY分隔符
     */
    String CACHE_KEY_JOINER = ":";

    /**
     * 日志MDC
     */
    String LOG_MDC_KEY = "requestStr";

    /**
     * 分布式锁最长等待时间(5秒)
     */
    Long LOCK_WAIT_TIMEOUT = 5L;

    /**
     * 分布式锁最大锁定时间(30分钟)
     */
    Long LOCK_TIME = 30 * 60L;

    /**
     * 分布式锁循环获取间隔时间(100毫秒)
     */
    long LOCK_SLEEP_TIME = 100;


}
