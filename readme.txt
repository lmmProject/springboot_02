1、表单验证
    实体中，添加l@Min(value=18, message="未成年人禁止入内")等注解；
    控制层中具体方法参数中，添加（@Valid Girl girl, BindingResult bindingResult)。
        如果不加@Valid，程序会报错

2、AOP编程思想

3、异常处理
    成功或者失败时，要有统一的格式；
    自定义异常；
    @ControllerAdvice + @ExceptionHandler；
    定义枚举类，统一管理code 和 msg

4、单元测试
    @RunWith(SpringRunner.class)
    @SpringBootTest
    @AutoConfigureMockMvc
    打包时，跳过单元测试：
    mvn clean package -Dmaven.test.skip=true