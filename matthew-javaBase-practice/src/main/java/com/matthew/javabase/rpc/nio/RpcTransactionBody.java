package com.matthew.javabase.rpc.nio;

import java.io.Serializable;
import java.util.Arrays;

/**
 * rpc交互对象
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-07 14:00
 */
public class RpcTransactionBody implements Serializable{
    private static final long serialVersionUID = 6952978158170726133L;
    private String interfaceName;//目标接口名
    private String methodName;//目标方法名
    private Class<?>[] parameterTypes;//参数类型
    private Object[] parameterValues;//参数值

    public RpcTransactionBody() {
    }
    public RpcTransactionBody(String interfaceName, String methodName, Class<?>[] parameterTypes, Object[] parameterValues) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.parameterValues = parameterValues;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameterValues() {
        return parameterValues;
    }

    public void setParameterValues(Object[] parameterValues) {
        this.parameterValues = parameterValues;
    }

    @Override
    public String toString() {
        return "RpcTransactionBody{" +
                "interfaceName='" + interfaceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                ", parameterValues=" + Arrays.toString(parameterValues) +
                '}';
    }
}
