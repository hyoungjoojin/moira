package io.moira.shared.advice;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
class UseCaseLoggingAdvice {

  private static final Logger logger = LoggerFactory.getLogger(UseCaseLoggingAdvice.class);

  @Around("@annotation(io.moira.shared.domain.UseCase)")
  public Object useCaseMethodAdvice(final ProceedingJoinPoint pjp) throws Throwable {
    StopWatch stopWatch = new StopWatch();

    try {
      logger.debug(
          "Executing use case {}:{} with parameters: {}",
          pjp.getTarget().getClass().getName(),
          pjp.getSignature().getName(),
          Arrays.toString(pjp.getArgs()));
      stopWatch.start();
      return pjp.proceed();
    } finally {
      stopWatch.stop();
      logger.debug(
          "Finished executing use case {}:{} in {}ms",
          pjp.getTarget().getClass().getName(),
          pjp.getSignature().getName(),
          stopWatch.getTotalTimeMillis());
    }
  }

  @Around("@within(io.moira.shared.domain.UseCase) && execution(public * execute(..))")
  public Object useCaseClassAdvice(final ProceedingJoinPoint pjp) throws Throwable {
    StopWatch stopWatch = new StopWatch();

    try {
      logger.debug(
          "Executing use case {} with parameters: {}",
          pjp.getTarget().getClass().getName(),
          Arrays.toString(pjp.getArgs()));
      stopWatch.start();
      return pjp.proceed();
    } finally {
      stopWatch.stop();
      logger.debug(
          "Finished executing use case {} in {}ms",
          pjp.getTarget().getClass().getName(),
          stopWatch.getTotalTimeMillis());
    }
  }
}
