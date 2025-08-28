package com.onlinevoting.util;

import java.util.Random;

public class OtpUtil {

    public Integer generateOtp() {
      Random random = new Random();
      return 100000 + random.nextInt(900000);
    }

}
