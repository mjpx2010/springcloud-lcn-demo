package com.example.demo.interceptor;

import com.lorne.tx.springcloud.interceptor.TxManagerInterceptor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lorne on 2017/6/28.
 */
@Aspect
@Component
public class TxTransactionInterceptor {

    @Autowired
    private TxManagerInterceptor txManagerInterceptor;

    @Around("execution(* com.example.demo.service.impl.*Impl.*(..))")
    public Object around(ProceedingJoinPoint point)throws Throwable{
        return txManagerInterceptor.around(point);
    }
}