package test;

import test.test;

public class Calculator {
    public static final int SHARE_BIRTHDAY = 1104; // 불변의 값, 대문자와 '_'를 사용한다(불변의 클래스 변수)
    public static int shareResult; // 공유되는 값 (클래스 변수)
    public int result=0; // instance 변수
    public Calculator() {
    }
    public int add(int number1, int number2){
        result = number1+number2;
        shareResult = result;
        return result;
    }
}