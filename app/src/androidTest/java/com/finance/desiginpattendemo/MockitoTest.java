package com.finance.desiginpattendemo;

import com.finance.desiginpattendemo.mvp.BasePresenter;
import com.finance.desiginpattendemo.mvp.UserMessage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by Jackie on 2018/7/2.
 */
public class MockitoTest {
    @Mock
    private ArrayList mockList;
    @Mock
    private UserMessage mockedUser;
    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void sampleTest1() throws Exception{
        //使用mock对象执行方法
        mockList.add("one");
        mockList.clear();

        //检验方法是否调用
        verify(mockList).add("one");
        verify(mockList).clear();

    }
    //直接mock对象
    @Test
    public void sampleTest2() throws Exception{
        BasePresenter basePresenter = mock(BasePresenter.class);
        //定义了当调用后返回值为Jackie
//        when(basePresenter.getUserName()).thenReturn("Jackie");
//        String userName = basePresenter.getUserName();
//        //验证是否调用了getuserName()方法
//        verify(basePresenter).getUserName();
//        Assert.assertEquals("Jackie",userName);

        String password = basePresenter.getUserName();
        //因为未定义返回值，默认返回null
        verify(basePresenter).getUserName();
        Assert.assertEquals(password,null);

    }
    //参数匹配器
    @Test
    public void argumentmatchersTest3(){
        when(mockList.get(anyInt())).thenReturn("不管请求第几个参数，都返回这句");
        System.out.println(mockList.get(0));
        //当mockList调用addAll()方法时，「匹配器」如果传入的参数list size==2，返回true；
        when(mockList.addAll(argThat(getListMatcher()))).thenReturn(true);

        //使用lambda表达式，「匹配器」如果传入的参数list size==3，返回true；      无效（原因:需使用source 1.8才能用lambda表达式）
        //when(mockList.addAll(argThat(list -> list.size() == 3))).thenReturn(true);

        boolean b1 = mockList.addAll(Arrays.asList("one","two"));
        boolean b2 = mockList.addAll(Arrays.asList("one","two","threee"));

        verify(mockList).addAll(argThat(getListMatcher()));
        Assert.assertTrue(b1);
        Assert.assertTrue(!b2);
    }

    private ListOfTwoElements getListMatcher(){
        return new ListOfTwoElements();
    }
    class ListOfTwoElements implements ArgumentMatcher<List>{

        @Override
        public boolean matches(List argument) {
            return argument.size() == 2;
        }

        @Override
        public String toString() {
            return "list of 2 elements";
        }
    }
    //验证方法的调用次数
    @Test
    public void simpleTest() throws Exception{

        mockList.add("once");
        mockList.add("twice");
        mockList.add("twice");

        verify(mockList,times(1)).add("once");
        verify(mockList,times(2)).add("twice");
        //从未调用
        verify(mockList,never()).add("three");
        //至少，至多调用校验
        verify(mockList,atLeastOnce()).add("once");
        verify(mockList,atMost(2)).add("twice");
    }
    //异常抛出测试
    @Test
    public void throwTest5(){
        doThrow(new NullPointerException("throwTest5，抛出空指针异常")).when(mockList).clear();
        //如果添加了int类型的参数聚会抛出异常
        doThrow(new IllegalArgumentException("参数有问题")).when(mockList).add(anyInt());

        mockList.add("string");
        mockList.add(12);  //抛出异常
        mockList.clear();  //抛出异常

    }
    //验证执行顺序
    @Test
    public void orderTest6() throws Exception{
        List singleMock = mock(List.class);
        singleMock.add("first add");
        singleMock.add("second add");
        InOrder order = inOrder(singleMock);
        //inOrder保证了方法的顺序执行
        order.verify(singleMock).add("first add");
        order.verify(singleMock).add("second add");

        List firstMock = mock(List.class);
        List secondMock = mock(List.class);
        firstMock.add("one");
        secondMock.add("two");

        InOrder inOrder = inOrder(firstMock,secondMock);
        //下列代码会确认是否firstmock优先secondMock执行add方法
        inOrder.verify(firstMock).add("one");
        inOrder.verify(secondMock).add("two");
    }
    //确保mock对象从未进行过交互
    @Test
    public void noInteractedTest7(){
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);
        List thridMock = mock(List.class);
        firstMock.add("one");
        verify(firstMock).add("one");
        verify(firstMock,never()).add("two");
        firstMock.add(thridMock);
        //确保交互（interaction）操作不会执行在mock对象上
        verifyZeroInteractions(secondMock,thridMock);

        //test failed
        //verifyZeroInteractions(firstMock,thridMock);
    }
/**
 * 简化mock对象的创建,请注意，一旦使用@Mock注解，一定要在测试方法调用之前调用(比如@Before注解的setUp方法)
 * MockitoAnnotations.initMocks(testClass);
 */

    //连续方法调用测试
    @Test
    public void continueMethodTest9() throws Exception{
        when(mockedUser.getName())
                .thenReturn("jackie")
                .thenThrow(new RuntimeException("方法第二次调用异常"))
                .thenReturn("第三次调用");

        String name1 = mockedUser.getName();
        try {
            String name2 = mockedUser.getName();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        String name3 = mockedUser.getName();
        System.out.println(name1);
        System.out.println(name3);

    }

    //回调方法做测试
//    @Test
//    public void callBackTest() throws Exception{
//        when(mockList.add(anyString())).thenAnswer(new Answer<Boolean>() {
//            @Override
//            public Boolean answer(InvocationOnMock invocation) throws Throwable {
//                Object[] args = invocation.getArguments();
//                Object mock = invocation.getMock();
//                return false;
//            }
//        });
//        System.out.println(mockList.add("第一次返回false"));
//
//    }

    //拦截方法的返回值（常用）
    @Test
    public void returnTest() throws Exception{
        //返回值为null的函数，可以通过这种方式测试
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                System.out.println("测试无返回值的参数");
                return null;
            }
        }).when(mockList).clear();
        doThrow(new RuntimeException("测试无返回值的函数->抛出异常"))
                .when(mockList).add(eq(1), anyString());

        doNothing().when(mockList).add(eq(2), anyString());

//        doReturn("123456").when(mockList).add(eq(3), anyString());    //不能把空返回值的函数与doReturn关联

        mockList.clear();
        mockList.add(2, "123");
        mockList.add(3, "123");
        mockList.add(4, "123");
        mockList.add(5, "123");

        //但是请记住这些add实际上什么都没有做，mock对象中仍然什么都没有
        System.out.print(mockList.get(4));


    }
    //Spy:监控真实对象(重要)
    @Test
    public void sypTest() throws Exception{
        List list = new ArrayList();
        List spyList = spy(list);

        //当spyList调用size()方法时，return100
        when(spyList.size()).thenReturn(100);

        spyList.add("one");
        spyList.add("two");

        System.out.println("spyList第一个元素" + spyList.get(0));
        System.out.println("spyList.size = " + spyList.size());

        verify(spyList).add("one");
        verify(spyList).add("two");
        //请注意！下面这行代码会报错！ java.lang.IndexOutOfBoundsException: Index: 10, Size: 2
        //不可能 : 因为当调用spy.get(0)时会调用真实对象的get(0)函数,此时会发生异常，因为真实List对象是空的
//        when(spyList.get(10)).thenReturn("ten");

        doReturn("ten").when(spyList).get(9);
        doReturn("eleven").when(spyList).get(10);

        System.out.println("spyList第10个元素" + spyList.get(9));
        System.out.println("spyList第11个元素" + spyList.get(10));
        //Mockito并不会为真实对象代理函数调用，实际上它会拷贝真实对象。因此如果你保留了真实对象并且与之交互
        //不要期望从监控对象得到正确的结果。当你在监控对象上调用一个没有被stub的函数时并不会调用真实对象的对应函数，你不会在真实对象上看到任何效果。

        //因此结论就是 : 当你在监控一个真实对象时，你想在stub这个真实对象的函数，那么就是在自找麻烦。或者你根本不应该验证这些函数。

    }
    //捕获参数（重要）
    @Test
    public void captureTest() throws Exception{
        Student student = new Student();
        student.setName("jackie_ljc");
        ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);
        mockList.add(student);
        verify(mockList).add(captor.capture());
        Student value = captor.getValue();
        Assert.assertEquals(value.getName(),"jackie_ljc");


    }

    private class Student{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }






















}
