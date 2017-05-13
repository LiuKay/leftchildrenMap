package org.leftchildren.enums;

import org.junit.Test;

/**
 * Created by kay on 2017/5/2.
 */
public class ApplyStatEnumTest {

    @Test
    public void test(){
        String statEnum=ApplyStatEnum.APPLYING.getStateInfo();
        System.out.println(statEnum);
    }
}