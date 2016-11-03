package org.java.learn.java8.dispatcher;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2016/11/3
 * Time: 21:53
 */
@Component
public class XXXEventDispatcher implements AutoCloseable {

    @Resource
    private XXXEventHandlerInitializer initializer;

    private Map<XXXEventType, XXXEventHandler> handlers = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        //建立绑定关系；
        initializer.init();
        //监听事件并派发
        dispatch("testMsg");
    }

    /**
     * 将XXX事件注册到派发器
     *
     * @param xxxEventType
     * @param xxxEventHandler
     */
    public void bind(XXXEventType xxxEventType, XXXEventHandler xxxEventHandler) {
        this.handlers.put(xxxEventType, ((eventType, context) -> {
            try {
                xxxEventHandler.handle(eventType, context);
            } catch (Exception e) {
                //记录错误日志
                e.printStackTrace();
            }
            //打印处理器执行日志
        }));
    }

    /**
     * 进行事件派发
     * @param eventMsg
     */
    private void dispatch(String eventMsg) {
        //从eventMsg中获取eventType;
        //根据eventMsg构造eventContext;
        //执行具体的处理器方法
    }

    public void close() throws Exception {
        //释放资源
    }
}
