package com.shopping;

import com.shopping.util.MD5Utils;
import com.shopping.util.Redeem;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingApplicationTests {

    @Test
    @Ignore
    public void contextLoads() {
        System.out.println("hello");
    }

    @Test
    @Ignore
    public  void jiami(){
        String str = MD5Utils.getMD5Code("456");
        System.out.println(str);
        System.out.println(MD5Utils.getMD5Code(str));
    }

    @Test
    public  void test(){
        System.out.println("=======================");
        Redeem.create((byte)1,10,12,"dak3le2");
        //Redeem.VerifyCode("m4vkwqaim4ab");
    }
}
