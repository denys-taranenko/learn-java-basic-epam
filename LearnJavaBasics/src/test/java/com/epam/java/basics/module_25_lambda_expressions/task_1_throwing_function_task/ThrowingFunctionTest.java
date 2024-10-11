package com.epam.java.basics.module_25_lambda_expressions.task_1_throwing_function_task;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ThrowingFunction test")
class ThrowingFunctionTest {

    //region Constants
    private static final String FI_CLASS_NAME = "ThrowingFunction";
    private static final String FI_APPLY_METHOD_NAME = FI_CLASS_NAME + ".apply";
    private static final String FI_APPLY_RETURN_NAME = FI_CLASS_NAME + ".apply (return type)";
    private static final String FI_APPLY_PARAMETER_NAME = FI_CLASS_NAME + ".apply (parameter)";
    private static final String FI_APPLY_EXCEPTION_NAME = FI_CLASS_NAME + ".apply (exception)";
    private static final String FI_QUIET_METHOD_NAME = FI_CLASS_NAME + ".quiet";
    private static final String FI_QUIET_RETURN_NAME = FI_CLASS_NAME + ".quiet (return type)";
    private static final String FI_QUIET_PARAMETER_NAME = FI_CLASS_NAME + ".quiet (parameter)";
    //endregion

    //region ThrowingFunction type tests
    @DisplayName("Tests that ThrowingFunction exist")
    @Test
    void shouldExist() {
        findClass();
    }

    @DisplayName("Tests that ThrowingFunction is an interface")
    @Test
    void shouldBeAnInterface() {
        Class<?> fiClass = findClass();
        assertTrue(fiClass.isInterface(), "ThrowingFunction must be an interface");
    }

    @DisplayName("Tests that ThrowingFunction is properly generalized")
    @Test
    void shouldBeGeneralized() {
        Class<?> fiClass = findClass();
        assertThatTypeParametersValidity(FI_CLASS_NAME, fiClass.getTypeParameters());
    }

    @DisplayName("Tests that ThrowingFunction is annotated with @FunctionalInterface")
    @Test
    void shouldBeAnnotatedWithFunctionalInterface() {
        Class<?> fiClass = findClass();
        FunctionalInterface annotation = fiClass.getDeclaredAnnotation(FunctionalInterface.class);
        if (annotation == null) {
            fail(FI_CLASS_NAME + " must be annotated with @FunctionalInterface");
        }
    }
    //endregion

    //region ThrowingFunction.apply tests
    @DisplayName("Tests that ThrowingFunction has method apply")
    @Test
    void shouldHaveMethodApply() {
        findApplyMethod();
    }

    @DisplayName("Tests that ThrowingFunction.apply has correct modifiers")
    @Test
    void shouldApplyBeAbstract() {
        Method method = findApplyMethod();
        assertTrue(Modifier.isAbstract(method.getModifiers()),
                FI_APPLY_METHOD_NAME + " must be abstract");
        assertTrue(Modifier.isPublic(method.getModifiers()),
                FI_APPLY_METHOD_NAME + " must be public");
    }

    @DisplayName("Tests that ThrowingFunction.apply throws a generalized exception")
    @Test
    void shouldThrowAnException() {
        Method method = findApplyMethod();
        Type[] exceptions = method.getGenericExceptionTypes();
        assertEquals(1, exceptions.length,
                FI_APPLY_METHOD_NAME + " must have declared throwing exceptions");
        Type exception = exceptions[0];
        assertEquals(Throwable.class.getCanonicalName(),
                method.getExceptionTypes()[0].getCanonicalName(),
                FI_APPLY_EXCEPTION_NAME + " must have Throwable as upper boundary");
        assertNotEquals(Throwable.class.getCanonicalName(), exception.getTypeName(),
                FI_APPLY_EXCEPTION_NAME + " must be generalized");
    }

    @DisplayName("Tests that ThrowingFunction.apply has properly generalized parameters")
    @Test
    void shouldBeProperlyGeneralizedParametersMethod() {
        Method method = findApplyMethod();
        assertEquals(1, method.getParameterCount(),
                FI_APPLY_METHOD_NAME + " must have exactly one argument");
        Class<?>[] parameterTypes = method.getParameterTypes();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        assertEquals(Object.class, parameterTypes[0],
                FI_APPLY_PARAMETER_NAME + " must not have upper boundary");
        assertNotEquals(parameterTypes[0].getCanonicalName(), genericParameterTypes[0].getTypeName(),
                FI_APPLY_PARAMETER_NAME + " must be generalized");
    }

    @DisplayName("Tests that ThrowingFunction.apply has properly generalized return type")
    @Test
    void shouldBeProperlyGeneralizedReturnType() {
        Method method = findApplyMethod();
        Class<?> returnType = method.getReturnType();
        Type genericReturnType = method.getGenericReturnType();
        assertEquals(Object.class, returnType,
                FI_APPLY_RETURN_NAME + " must not have upper boundary");
        assertNotEquals(returnType.getCanonicalName(), genericReturnType.getTypeName(),
                FI_APPLY_RETURN_NAME + " must be generalized");
    }

    @DisplayName("Tests that all ThrowingFunction.apply generic types are different")
    @Test
    void shouldHaveDifferentGenericTypes() {
        Method method = findApplyMethod();
        ArrayList<Type> types = new ArrayList<>();
        types.add(method.getGenericReturnType());
        types.addAll(List.of(method.getGenericParameterTypes()));
        types.addAll(List.of(method.getGenericExceptionTypes()));
        assertThatAllGenericTypesAreDifferent(FI_CLASS_NAME, types);
    }

    @DisplayName("Tests that ThrowingFunction.apply does not have any method type variable")
    @Test
    void shouldApplyMethodNotBeSelfGeneralized() {
        Method method = findApplyMethod();
        if (method.getTypeParameters().length > 0) {
            fail(FI_APPLY_METHOD_NAME + " must not have any method type variable");
        }
    }
    //endregion

    //region ThrowingFunction.quiet tests
    @DisplayName("Tests that ThrowingFunction has quiet method")
    @Test
    void shouldHaveQuietMethod() {
        findQuietMethod();
    }

    @DisplayName("Tests that ThrowingFunction.quiet has correct modifiers")
    @Test
    void shouldQuietMethodBeStatic() {
        Method method = findQuietMethod();

        assertTrue(Modifier.isStatic(method.getModifiers()),
                FI_QUIET_METHOD_NAME + " must be static");
        assertTrue(Modifier.isPublic(method.getModifiers()),
                FI_QUIET_METHOD_NAME + " must be public");
    }

    @DisplayName("Tests that ThrowingFunction.quiet has right argument")
    @Test
    void shouldQuietMethodHaveThrowingFunctionAsParameter() {
        Class<?> fiClass = findClass();
        Method method = findQuietMethod();
        assertEquals(1, method.getParameterCount(),
                FI_QUIET_METHOD_NAME + " must have exactly one argument");
        ParameterizedType type = toParameterizedType(method.getGenericParameterTypes()[0]);
        assertEquals(fiClass, type.getRawType(),
                FI_QUIET_PARAMETER_NAME + " must be a " + FI_CLASS_NAME);
    }

    @DisplayName("Tests that ThrowingFunction.quiet has right return type")
    @Test
    void shouldQuietMethodHaveFunctionAsReturnType() {
        Method method = findQuietMethod();
        ParameterizedType type = toParameterizedType(method.getGenericReturnType());
        assertEquals(Function.class, type.getRawType(),
                FI_QUIET_RETURN_NAME + " must be a Function");
    }

    @DisplayName("Tests that ThrowingFunction.quiet does not throw anything")
    @Test
    void shouldQuietMethodNotThrowAnything() {
        Method method = findQuietMethod();
        Type[] exceptionTypes = method.getGenericExceptionTypes();
        if (exceptionTypes.length > 0) {
            fail(FI_QUIET_METHOD_NAME + " must not throw anything");
        }
    }

    @DisplayName("Tests that ThrowingFunction.quiet has its own valid type parameters")
    @Test
    void shouldQuietMethodHaveItsOwnTypeParameters() {
        Method method = findQuietMethod();
        assertThatTypeParametersValidity(FI_QUIET_METHOD_NAME, method.getTypeParameters());
    }

    @DisplayName("Tests that ThrowingFunction.quiet is properly generalized")
    @Test
    void shouldQuietMethodBeProperlyGeneralized() {
        Class<?> fiClass = findClass();
        Method method = findQuietMethod();
        assertEquals(1, method.getParameterCount(),
                FI_QUIET_METHOD_NAME + " must have exactly one argument");
        TypeVariable<Method>[] typeParameters = method.getTypeParameters();
        assertThatTypeParametersValidity(FI_QUIET_METHOD_NAME, typeParameters);
        assertThatAllGenericTypesAreDifferent(FI_QUIET_METHOD_NAME, List.of(typeParameters));
        ParameterizedType returnType = toParameterizedType(method.getGenericReturnType());
        assertEquals(Function.class, returnType.getRawType(),
                FI_QUIET_RETURN_NAME + " must be a Function");
        Type[] returnTypeArguments = returnType.getActualTypeArguments();
        assertThatAllGenericTypesAreDifferent(FI_QUIET_RETURN_NAME, List.of(returnTypeArguments));
        ParameterizedType parameterType = toParameterizedType(method.getGenericParameterTypes()[0]);
        assertEquals(fiClass, parameterType.getRawType(),
                FI_QUIET_PARAMETER_NAME + " must be a " + FI_CLASS_NAME);
        Type[] parameterTypeArguments = parameterType.getActualTypeArguments();
        assertThatAllGenericTypesAreDifferent(FI_QUIET_PARAMETER_NAME, List.of(parameterTypeArguments));
        assertEquals(returnTypeArguments[0], parameterTypeArguments[0],
                FI_QUIET_METHOD_NAME + " input type of the parameter and return type are not the same");
        assertEquals(returnTypeArguments[1], parameterTypeArguments[1],
                FI_QUIET_METHOD_NAME + " return type of the parameter and return type are not the same");
    }
    //endregion

    //region ThrowingFunction.quiet functional tests

    @DisplayName("Tests that ThrowingFunction.quiet returns null when null is passed")
    @Test
    void shouldReturnNullWhenNullIsPassed() {
        Object quietFunction = invokeQuiet(null);
        assertNull(quietFunction, FI_QUIET_METHOD_NAME + " must return null when null is passed");
    }

    @DisplayName("Tests that ThrowingFunction.quiet works correctly when nothing was thrown")
    @Test
    @SuppressWarnings({"rawtypes"})
    void shouldWorkCorrectlyWhenNothingWasThrown() {
        var throwingFunction = newProxy(null);
        Object quietFunction = invokeQuiet(throwingFunction);
        if (!(quietFunction instanceof Function)) {
            fail(FI_QUIET_METHOD_NAME + " must return a Function");
        }

        Object result = ((Function) quietFunction).apply("argument");
        if (!(result instanceof String)) {
            fail(FI_QUIET_METHOD_NAME
                    + " must return Function with the same return type as of the argument");
        }
        assertEquals("argument", result);
    }

    @DisplayName("Tests that ThrowingFunction.quiet resulting Function "
            + "throws unchecked when error occurred")
    @Test
    @SuppressWarnings({"rawtypes"})
    void shouldThrowUncheckedExceptionWhenErrorOccurred() {
        final var exceptionToThrow = new Exception("exception message");
        var throwingFunction = newProxy(exceptionToThrow);
        Object quietFunction = invokeQuiet(throwingFunction);
        if (!(quietFunction instanceof Function)) {
            fail(FI_QUIET_METHOD_NAME + " must return a Function");
        }

        try {
            ((Function) quietFunction).apply("argument");
        } catch (RuntimeException e) {
            assertEquals(RuntimeException.class, e.getClass(),
                    FI_QUIET_METHOD_NAME + " must wrap exactly in RuntimeException");
            assertEquals(exceptionToThrow, e.getCause(),
                    FI_QUIET_METHOD_NAME + " hides the original exception");
            return;
        } catch (Throwable e) {
            fail(FI_QUIET_METHOD_NAME + " failed to silence an exception", e);
        }
        fail(FI_QUIET_METHOD_NAME
                + " completely hides the exception instead of throwing an unchecked one");
    }
    //endregion

    //region Reflection utilities
    private static Class<?> findClass() {
        return assertDoesNotThrow(() -> Class.forName("edu.epam.fop.lambdas.ThrowingFunction"),
                FI_CLASS_NAME + " does not exist");
    }

    private static Method findApplyMethod() {
        Class<?> fiClass = findClass();
        Method method = assertDoesNotThrow(
                () -> fiClass.getDeclaredMethod("apply", Object.class),
                FI_CLASS_NAME + " must have a method named apply (T -> R)");
        method.setAccessible(true);
        return method;
    }

    private static Method findQuietMethod() {
        Class<?> fiClass = findClass();
        Method method = assertDoesNotThrow(() -> fiClass.getDeclaredMethod("quiet", fiClass),
                FI_CLASS_NAME + " must have a method named quiet (ThrowingFunction -> Function)");
        method.setAccessible(true);
        return method;
    }

    private static ParameterizedType toParameterizedType(Type type) {
        if (!(type instanceof ParameterizedType)) {
            fail(type.getTypeName() + " of " + FI_QUIET_METHOD_NAME + " is not parameterized");
        }
        return (ParameterizedType) type;
    }

    private static void assertThatTypeParametersValidity(String name, TypeVariable<?>[] typeParams) {
        assertEquals(3, typeParams.length, name + " must be properly generalized");
        boolean exceptionBounded = false;
        for (TypeVariable<?> typeParam : typeParams) {
            Type[] bounds = typeParam.getBounds();
            assertEquals(1, bounds.length,
                    name + " type parameters might have only upper bound");
            String typeName = bounds[0].getTypeName();
            boolean isException = typeName.equals(Throwable.class.getCanonicalName());
            boolean isExceptionSubclass = Throwable.class.isAssignableFrom(
                    assertDoesNotThrow(() -> Class.forName(typeName),
                            "Upper boundary is not reachable - " + typeName));
            if (exceptionBounded && isExceptionSubclass) {
                fail(name + " must have exactly one exception related generic type");
            }
            if (!exceptionBounded && isExceptionSubclass) {
                exceptionBounded = true;
            }
            if (isExceptionSubclass && !isException) {
                assertEquals(Throwable.class.getCanonicalName(), typeName,
                        name + " exception related boundary must be Throwable");
            }
            boolean isObject = typeName.equals(Object.class.getCanonicalName());
            if (!isObject && !isException) {
                assertEquals(Object.class.getCanonicalName(), typeName,
                        "Non exceptional generic type should not be bounded");
            }
        }
        if (!exceptionBounded) {
            fail(name + " must have exactly one exception related generic type, but was none");
        }
    }

    private static void assertThatAllGenericTypesAreDifferent(String name, Collection<Type> types) {
        if (types.size() != Set.copyOf(types).size()) {
            fail(name + " has reused type parameters");
        }
    }

    @SuppressWarnings("all")
    private static Object newProxy(Throwable exception) {
        Class<?> fiClass = findClass();
        return Proxy.newProxyInstance(fiClass.getClassLoader(), new Class[]{fiClass},
                (proxy, method, args) -> {
                    if (exception != null) {
                        throw exception;
                    }
                    return args[0];
                });
    }

    @SuppressWarnings("all")
    private static Object invokeQuiet(Object argument) {
        try {
            return findQuietMethod().invoke(null, argument);
        } catch (InvocationTargetException e) {
            fail(FI_QUIET_METHOD_NAME + " has thrown unexpected exception", e);
        } catch (IllegalAccessException e) {
            fail("Failed to invoke " + FI_QUIET_METHOD_NAME, e);
        }
        throw new Error("Should never be thrown");
    }
    //endregion
}
