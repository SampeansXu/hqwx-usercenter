package cn.huanju.edu100.hqwx.usercenter;

import cn.huanju.edu100.hqwx.usercenter.api.UserDataService;
import cn.huanju.edu100.hqwx.usercenter.config.HQWXUsercenterConfig;
import cn.huanju.edu100.hqwx.usercenter.service.impl.HttpClientHelper;
import cn.huanju.edu100.hqwx.usercenter.service.impl.UserDataServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 压测
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        HQWXUsercenterConfig.class,
        UserDataServiceImpl.class,
        HttpClientHelper.class
})
class Test_Stress {

    @Resource
    UserDataService userDataService;

    //并发线程数
    final int Thread_Count = 100;
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(Thread_Count);

    void getUserInfoById(int idx) {
        userDataService.getUserInfoById(151235971L, 94L);
        System.out.println(idx + "--> getUserInfoById");
    }

    void getUserInfoByIds(int idx) {
        Long[] ids = new Long[]{12733684L, 12733705L, 12715368L, 12735500L, 12720410L, 12754565L};
        userDataService.getUserInfoByIds(Lists.newArrayList(ids), 2L);
        System.out.println(idx + "--> getUserInfoByIds");
    }

    class TestTask implements Runnable {

        private int idx = 0;

        public TestTask(int idx) {
            this.idx = idx;
        }

        @Override
        public void run() {
            while (true) {
                if (idx % 2 == 0) {
                    getUserInfoByIds(idx);
                } else {
                    getUserInfoById(idx);
                }

//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }


    @Test
    void testStress() {

        for (int i = 0; i < Thread_Count; i++) {
            TestTask task = new TestTask(i);
            fixedThreadPool.execute(task);
        }

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
