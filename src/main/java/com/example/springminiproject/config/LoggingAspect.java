package com.example.springminiproject.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
   // private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.springminiproject.services.ServiceFoyer.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("In method " + name + " : ");
        log.info("In method " + name + " : ");
    }

    @Around("execution(* com.example.springminiproject.services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }
}


/* @Before @After @Around
@AfterThrowing
L'advice @AfterThrowing est exécuté après qu'une méthode ait lancé une exception. Cela peut être utilisé
pour gérer des exceptions ou pour effectuer des actions de nettoyage/logging lorsque des erreurs se produisent
.
@AfterReturning
L'advice @AfterReturning est exécuté après la fin normale de l'exécution d'une méthode (c'est-
à-dire lorsque la méthode retourne une valeur avec succès, sans lancer d'exception).
 */

/*
"execution(Modifiers-pattern? Ret-type-pattern Declaring-type-pattern?Name-pattern(param-pattern) Throws-pattern?)"
        • “?” veut dire optionnel
        • Modifiers-pattern? : public, private ...
        • Ret-type-pattern : le type de retour.
        • Declaring-type-pattern? : nom de la classe y compris le package.
        • Name-pattern : nom de la méthode.
        • Throws-pattern? : l’exception.
        • “..” veut dire, 0 ou plusieurs paramètres
        */
