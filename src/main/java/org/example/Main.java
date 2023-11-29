package org.example;

import java.util.Scanner;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Main {
    public static void main(String[] args) {
        // 1. ':' 문자를 기준으로 시간, 분, 초를 쪼갠다
        //    1-1. 각 단위의 인덱스에서 10의 자리와 1의 자리를 구해 계산 할 수 있다.
        //    1-2. String substring을 사용하면 원하는 문자열만 떼올 수 있다.
        //    1-3. String.split을 사용하면 토큰(':')을 기준으로 문자열을 나눠준다.
        // 2. 두 시간, 분, 초의 차이를 계산한다.
        //    2-1. 시간, 분, 초 각각의 차이를 계산한다.
        //    2-2. 시간, 분, 초를 모두 초 단위로 환산하여 차이를 계산한다.
        //    (계층적으로 표현되는 각 단위를 계산할 때, 가장 작은 단위로 통일하면 더 편할 수 있다.)
        //    * 00:00:01<=시간<24:00:00 고려
        // 3. 구해진 시간을 HH:MM:SS 형태로 출력한다.

        Scanner sc = new Scanner(System.in);
        String currentTime = sc.next();
        String dropTime = sc.next();

        // 1-1. 각 단위의 인덱스에서 10의 자리와 1의 자리를 구해 계산 할 수 있다.
        // hh:mm:ss → 01(:)34(:)67
        // String.charAt(index) - '0' : 자리수의 숫자

        int currentHour = (currentTime.charAt(0) - '0') * 10 + (currentTime.charAt(1) - '0');
        int currentMinute = (currentTime.charAt(3) - '0') * 10 + (currentTime.charAt(4) - '0');
        int currentSecond = (currentTime.charAt(6) - '0') * 10 + (currentTime.charAt(7) - '0');

        int dropHour = (dropTime.charAt(0) - '0') * 10 + (dropTime.charAt(1) - '0');
        int dropMinute = (dropTime.charAt(3) - '0') * 10 + (dropTime.charAt(4) - '0');
        int dropSecond = (dropTime.charAt(6) - '0') * 10 + (dropTime.charAt(7) - '0');

        // 2-1. 시간, 분, 초 각각의 차이를 계산한다.
        int needHour = dropHour - currentHour;
        int needMinute = dropMinute - currentMinute;
        int needSecond = dropSecond - currentSecond;

        if (needSecond < 0) {
            needSecond += 60;
            needMinute--;
        }
        if (needMinute < 0) {
            needMinute += 60;
            needHour--;
        }
        if (needHour <= 0) {
            needHour += 24;
        }

        // 3. 구해진 시간을 HH:MM:SS 형태로 출력한다.
        // 3-1 : String 이어붙이기
        String ans = "";
        if (needHour < 10)
            ans += "0" + needHour + ":";
        else ans += needHour + ":";
        if (needMinute < 10)
            ans += "0" + needMinute + ":";
        else ans += needMinute + ":";
        if (needSecond < 10)
            ans += "0" + needSecond;
        else ans += needSecond;
        System.out.println(ans);
        // 3-2 : printf로 2자리수 정수와 토큰으로 표현하기
//        System.out.printf("%02d:%02d:%02d", needHour, needMinute, needSecond);


    }
}