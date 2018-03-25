package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String name = customer.getCountryName();
            String result = null;
            for (Map.Entry<String,String> entry : countries.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == name) result = key;
            }
            return result;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String s = contact.getName();
            String[] ss = s.split(", ");
            return ss[1];
        }

        @Override
        public String getContactLastName() {
            String s = contact.getName();
            String[] ss = s.split(", ");
            return ss[0];
        }

        @Override
        public String getDialString() {
            String s = contact.getPhoneNumber();
            byte[] ch = s.getBytes();
            String result = "";
            for (byte b : ch) {
                try {
                    Integer.parseInt(String.valueOf((char)b));
                    result+=(char)b;
                } catch (NumberFormatException e) {
                }
            }
            return "callto://+" + result;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}