package cn.kfm666.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Aspect
@Component
public class TestAspect {
    @Pointcut("execution(public * cn.kfm666.aoptest.*Controller.*(..))")
    public void pointCut(){}
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    @Before(value = "pointCut()")
    public void doBefore(JoinPoint point){
        startTime.set(System.currentTimeMillis());
        System.out.println("前置切面");
    }

    @After(value = "pointCut()")
    public void doAfter(JoinPoint point){
        System.out.println("耗时："+ (System.currentTimeMillis() - startTime.get()));
        System.out.println("后置切面");
    }

    @Around(value = "pointCut()", argNames = "pjp")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕切面");
        // 如果不在环绕切面中调用目标方法，目标方法将不会被执行
        // 前置切面也不会被执行
        Object obj = pjp.proceed();
        System.out.println("执行结果："+obj);
        return obj;
    }

    /**
     * 异常抛出增强可以处理目标方法未处理的异常
     * 如调用数据库错误，可以在这个方法里面进行回滚
     * @param e
     * @return
     */
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public Object doExceptionAdvice(Throwable e){
        e.printStackTrace();
        return "出异常了";
    }
}
