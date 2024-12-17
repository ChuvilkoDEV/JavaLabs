package tech.reliab.course.ChuvilkoIR.bank.model.enums;

import java.util.Random;

public enum BankAtmStatusEnum {
    WORKING,
    NOT_WORKING,
    NO_MONEY;

    private static final Random RANDOM = new Random();

    public static BankAtmStatusEnum randomStatus()  {
        BankAtmStatusEnum[] statuses = values();
        return statuses[RANDOM.nextInt(statuses.length)];
    }
}