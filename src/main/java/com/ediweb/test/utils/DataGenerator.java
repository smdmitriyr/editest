package com.ediweb.test.utils;

import com.ediweb.test.model.Agent;
import com.ediweb.test.model.TradePoint;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<Agent> generateAgents() {
        List<Agent> agents = new ArrayList<>(10);
        agents.add(new Agent(1, "demo", "Демо", "Демов", "Демович", Agent.GENDER_MALE, 25));
        agents.add(new Agent(2, "valetin", "Валентин", "Петухов", "Иванович", Agent.GENDER_MALE, 23));
        agents.add(new Agent(3, "nikolay", "Николай", "Программистов", "Петрович", Agent.GENDER_MALE, 18));
        agents.add(new Agent(4, "anna", "Aнна", "Валентинова", "Дмитровна", Agent.GENDER_FEMALE, 21));
        agents.add(new Agent(5, "anna_2", "Анна", "Иванова", "Ивановна", Agent.GENDER_FEMALE, 29));
        agents.add(new Agent(6, "sadovnikova_e", "Екатерина", "Садовникова", "Артёмовна", Agent.GENDER_FEMALE, 19));
        agents.add(new Agent(7, "dmitriyr", "Дмитрий", "Русаков", "Викторович", Agent.GENDER_MALE, 25));
        agents.add(new Agent(8,"ivant", "Иван", "Тягов", "Сергеевич", Agent.GENDER_MALE, 25));
        agents.add(new Agent(9,"vittu", "Виталий", "Евтув", "Юрьевич", Agent.GENDER_MALE, 31));
        agents.add(new Agent(10, "alex", "Александр", "Гусев", "Сергеевич", Agent.GENDER_MALE, 27));
        return agents;
    }

    public static List<TradePoint> generateTradePoints() {
        List<TradePoint> tradePoints = new ArrayList<>(5);
        tradePoints.add(new TradePoint(1, "ИП Чижов", "г. Смоленск", 54.765942, 32.037817));
        tradePoints.add(new TradePoint(2, "Магнит на пригородной", "г. Смоленск, ул. Пригородная 9", 54.765557, 32.040190));
        tradePoints.add(new TradePoint(3, "Принцип компани", "г. Смоленск, ул. Кирова, д. 30", 54.768729, 32.040370));
        tradePoints.add(new TradePoint(4, "Евроопт на Кирова", "г. Смоленск, ул. Кирова, 28", 54.768721, 32.040352));
        tradePoints.add(new TradePoint(5, "ИП Городецкий", "г. Смоленск, ул. Октябрьской Революции, 24", 54.772575, 32.042535));
        return tradePoints;
    }


}
