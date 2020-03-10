package com.alevel.nix.java.hometask.lesson14;

public class Retry {

    public void tryCode(int maxTry, Block block) throws Exception {

        for (int i = 0; i < maxTry; i++){

            Thread.sleep(100 * i * 2);

            try{
                block.run();
            }catch (Exception e){
                e.getMessage();
                continue;
            }

            if (i == maxTry - 1){
                throw new Exception();
            }
        }
    }
}
