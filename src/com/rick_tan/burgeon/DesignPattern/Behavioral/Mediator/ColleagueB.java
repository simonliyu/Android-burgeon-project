 package com.rick_tan.burgeon.DesignPattern.Behavioral.Mediator;

/**
 * Created by yongchen on 2016/1/7.
 */
public class ColleagueB extends AbstractColleague {
    @Override
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.BaffectA();
    }
}
