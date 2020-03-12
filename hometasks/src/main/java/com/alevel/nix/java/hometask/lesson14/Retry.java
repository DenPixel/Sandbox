package com.alevel.nix.java.hometask.lesson14;

public class Retry {

    public void tryCode(int maxTry, Block block) throws Exception {

        for (int i = 0; i < maxTry; i++){

            Thread.sleep(100 * i * 2);

            try{
                block.run();
                return;
            }catch (Exception e){
                e.getMessage();
            }
            if (i == maxTry - 1){
                throw new Exception();
            }
        }
    }

    public static void main(String[] args) {

        try {
            new Retry().tryCode(2, () -> {
                if ((int) (Math.random() * 10) != 0) throw new Exception();
            });
        }catch (Exception e){
            e.getMessage();
        }
    }
}
