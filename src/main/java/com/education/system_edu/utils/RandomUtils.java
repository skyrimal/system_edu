package com.education.system_edu.utils;

import java.util.Random;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年03月27日 9:46
 */
public class RandomUtils {


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            System.out.println(getRandomChineseCharacter());
        }
    }

    public static char getRandomChineseCharacter() {
        return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
    }

    public static int randomNumber(int START, int END) {
        //创建Random类对象
        Random random = new Random();
        //产生随机数
        return random.nextInt(END - START + 1) + START;
    }

    public static String getRandomChineseName() {
        char[] name = new char[4] ;
        for (int i = 0; i < randomNumber(2,4); i++) {
            name[i] = getRandomChineseCharacter();
        }
       return String.valueOf(name);
    }

    public static String getRandomClassNo(){
        return StringUtils.lengthControl(randomNumber(0,999999)+"",6);
    }
}
