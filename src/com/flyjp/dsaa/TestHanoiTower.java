package com.flyjp.dsaa;

public class TestHanoiTower {

    public static void main(String[] args) {
        HanoiTower.doTower(3,"左","中","右");
    }

}

class HanoiTower{
    /**
     * 移动盘子
     * topN：移动多少个
     * from:起始塔座
     * inter:中间塔座
     * to:目标塔座
     */
    public static void doTower(int topN,String from,String inter,String to){
        if(topN == 1){
            System.out.println("盘子1从" + from + "塔座到" + to + "塔座");
        }else{
            doTower(topN -1 , from , to , inter);//从from(左)通过to（右）到inter(中)
            System.out.println("盘子" + topN + "从" + from + "塔座到" + to + "塔座");
            doTower(topN -1 , inter ,from , to );//从inter(中)通过from(左)到to(右)
        }
    }
}
