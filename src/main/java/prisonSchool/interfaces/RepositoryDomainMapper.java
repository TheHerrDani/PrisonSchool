package prisonSchool.interfaces;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * T Repository
 * U Domain
 */

public class RepositoryDomainMapper<T, U> {
    private Class<T> entityType;
    private Class<U> domainType;
    private final String getRegex = "get[\\w_$]+";
    private final String setRegex = "set[\\w_$]+";
    private final Pattern getPattern = Pattern.compile(getRegex, Pattern.CASE_INSENSITIVE);
    private final Pattern setPattern = Pattern.compile(setRegex, Pattern.CASE_INSENSITIVE);
    private List<Method> entityMethods;
    private List<Method> domainMethods;

    public RepositoryDomainMapper(Class<T> t, Class<U> u) {
        this.entityType = t;
        this.domainType = u;
        this.entityMethods = Arrays.asList(entityType.getMethods());
        this.domainMethods = Arrays.asList(domainType.getMethods());
    }

    public U RepositoryToDomain(T entity) {
        try {
            Map<Method, Method> domainSetMethodList = domainMethods.stream()
                    .filter(method -> setPattern.matcher(method.getName()).find())
                    .collect(Collectors.toMap(method -> method, getFunctions));
            U u = domainType.getConstructor().newInstance();
            domainSetMethodList.keySet().forEach(method -> {
                try {
                    method.invoke(u, domainSetMethodList.get(method).invoke(entity));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new IllegalStateException();
                }
            });
            return u;
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new IllegalStateException();
        }
    }

    private UnaryOperator<Method> getFunctions = (method) -> {
        String methodName = method.getName();
        return entityMethods.stream().filter(otherMethod -> {
            String entityMethodName = otherMethod.getName();
            return getPattern.matcher(entityMethodName).find() && entityMethodName.substring(3).equals(methodName.substring(3));
        }).findFirst().orElseThrow(IllegalStateException::new);
    };
}

