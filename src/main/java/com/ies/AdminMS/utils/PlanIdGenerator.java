package com.ies.AdminMS.utils;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;


public class PlanIdGenerator extends SequenceStyleGenerator {
    private static int counter = 10;
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        int id = counter++;
        LocalDateTime now = LocalDateTime.now();
        String value = "IES-PLAN-" + now.getDayOfMonth() + now.getMonthValue() + now.getYear() + now.getHour()
                + now.getMinute();
        return value + id;
    }
}

