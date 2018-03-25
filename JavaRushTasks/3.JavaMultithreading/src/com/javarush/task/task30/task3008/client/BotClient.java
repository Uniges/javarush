package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() throws IOException {
        return "date_bot_"+(int)(Math.random()*100);
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            /*ConsoleHelper.writeMessage(message);

            if (message.contains(":")) {

                int splitIndex = message.indexOf(":");
                String name = message.substring(0, splitIndex);
                String text = message.substring(splitIndex + 2);

                Calendar calendar = new GregorianCalendar();
                SimpleDateFormat date = new SimpleDateFormat();
                date.setTimeZone(calendar.getTimeZone());

                switch (text) {
                    case "дата":
                        date.applyPattern("d.MM.YYYY");
                        break;
                    case "день":
                        date.applyPattern("d");
                        break;
                    case "месяц":
                        date.applyPattern("MMMM");
                        break;
                    case "год":
                        date.applyPattern("YYYY");
                        break;
                    case "время":
                        date.applyPattern("H:mm:ss");
                        break;
                    case "час":
                        date.applyPattern("H");
                        break;
                    case "минуты":
                        date.applyPattern("m");
                        break;
                    case "секунды":
                        date.applyPattern("s");
                        break;
                    default:
                        date = null;
                }
                if (date != null) sendTextMessage("Информация для " + name + ": " + date.format(calendar.getTime()));
            }*/

            ConsoleHelper.writeMessage(message);

            if (message.contains(":")) {

                int splitIndex = message.indexOf(":");
                String name = message.substring(0, splitIndex);
                String text = message.substring(splitIndex + 2);

                Calendar calendar = new GregorianCalendar();
                SimpleDateFormat date = new SimpleDateFormat();
                date.setTimeZone(calendar.getTimeZone());

                switch (text) {
                    case "дата":
                        date.applyPattern("d.MM.YYYY");
                        sendTextMessage("Информация для " + name + ": " + date.format(calendar.getTime()));
                        break;
                    case "день":
                        date.applyPattern("d");
                        sendTextMessage("Информация для " + name + ": " + date.format(calendar.getTime()));
                        break;
                    case "месяц":
                        date.applyPattern("MMMM");
                        sendTextMessage("Информация для " + name + ": " + date.format(calendar.getTime()));
                        break;
                    case "год":
                        date.applyPattern("YYYY");
                        sendTextMessage("Информация для " + name + ": " + date.format(calendar.getTime()));
                        break;
                    case "время":
                        date.applyPattern("H:mm:ss");
                        sendTextMessage("Информация для " + name + ": " + date.format(calendar.getTime()));
                        break;
                    case "час":
                        date.applyPattern("H");
                        sendTextMessage("Информация для " + name + ": " + date.format(calendar.getTime()));
                        break;
                    case "минуты":
                        date.applyPattern("m");
                        sendTextMessage("Информация для " + name + ": " + date.format(calendar.getTime()));
                        break;
                    case "секунды":
                        date.applyPattern("s");
                        sendTextMessage("Информация для " + name + ": " + date.format(calendar.getTime()));
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
