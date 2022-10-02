package com.assignment.Defense.of.the.Ancients2.util;

import com.assignment.Defense.of.the.Ancients2.exception.InvalidRequestException;

import java.util.List;

public class BasicValidations {


    public static void validateAccountId(Integer accountId) {
        if(accountId == null){
            throw new InvalidRequestException(Constant.ACCOUNT_ID_NOT_ENTERED);
        }
    }

    public static void validateHeroIds(List<Integer> heroIds) {
        if(heroIds == null || heroIds.size()==0){
            throw new InvalidRequestException(Constant.HERO_IDS_NOT_ENTERED);
        }
    }
}
